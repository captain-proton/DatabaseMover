package de.unidue.dbmover;

import org.apache.cayenne.datamap.*;
import org.apache.cayenne.dba.TypesMapping;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MissingAttributeGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(MissingAttributeGenerator.class);

    public void generateAttributes(String datamapFilename) {
        File datamapFile = new File(datamapFilename);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DataMap.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            DataMap map = (DataMap) unmarshaller.unmarshal(datamapFile);
            for (DbEntity dbEntity : map.getDbEntity()) {

                Optional<ObjEntity> objEntityOptional = map.getObjEntity()
                        .stream()
                        .filter(e -> e.getDbEntityName().equals(dbEntity.getName()))
                        .findAny();

                if (objEntityOptional.isPresent()) {

                    ObjEntity objEntity = objEntityOptional.get();
                    addMissingProperties(dbEntity, objEntity);
                    dbEntity.getDbAttribute().forEach(a -> a.setIsGenerated(null));
                } else {
                    LOG.warn("Db entity " + dbEntity.getName() + " has no object mapping");
                }
            }
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(map, datamapFile);

            LOG.info("Missing attributes generated");
        } catch (JAXBException ex) {
            LOG.error("JAXB failed", ex);
        }
    }

    private void addMissingProperties(DbEntity dbEntity, ObjEntity objEntity) {
        Predicate<DbAttribute> noObjectAttribute = dbAttribute -> !objEntity.getObjAttribute()
                .stream()
                .filter(objAttribute -> objAttribute.getDbAttributePath().equals(dbAttribute.getName()))
                .findAny()
                .isPresent();

        List<DbAttribute> targetDbAttributes = dbEntity.getDbAttribute()
                .stream()
                .filter(noObjectAttribute)
                .collect(Collectors.toList());

        for (DbAttribute dbAttribute : targetDbAttributes) {
            addObjectProperty(objEntity, dbAttribute);
        }
    }

    private void addObjectProperty(ObjEntity objEntity, DbAttribute dbAttribute) {

        String dbAttributeType = dbAttribute.getType();
        int sqlType = TypesMapping.getSqlTypeByName(dbAttributeType);
        String javaType = TypesMapping.getJavaBySqlType(sqlType);

        if (javaType != null) {

            String dbAttributeName = dbAttribute.getName();
            String objAttributeName = buildJavaName(dbAttributeName);

            ObjAttribute objAttribute = new ObjAttribute();
            objAttribute.setType(javaType);
            objAttribute.setDbAttributePath(dbAttributeName);
            objAttribute.setName(objAttributeName);

            objEntity.getObjAttribute().add(objAttribute);
            String msg = String.format("Added attribute %30s of type %25s to %s", objAttributeName, objAttribute.getType(), objEntity.getName());
            LOG.info(msg);

        } else {
            LOG.warn("Did not found java type of db attribute " + dbAttribute.getName() + ":" + dbAttributeType);
        }
    }

    private String buildJavaName(String dbAttributeName) {
        String[] split = dbAttributeName.split("[\\p{Punct}]+");
        StringBuilder javaName = new StringBuilder(split[0]);
        if (split.length > 1) {
            String suffix = Arrays.stream(ArrayUtils.remove(split, 0))
                    .map(s -> StringUtils.capitalize(s))
                    .collect(Collectors.joining());
            javaName.append(suffix);
        }
        return javaName.toString();
    }
}
