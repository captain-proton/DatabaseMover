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
import java.util.Optional;
import java.util.stream.Collectors;

public class PkAttributeGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(PkAttributeGenerator.class);

    public static void main(String[] args) {
        PkAttributeGenerator generator = new PkAttributeGenerator();
        generator.generateAttributes();
    }

    private void generateAttributes() {
        File datamapFile = new File("src/main/resources/datamap.map.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DataMap.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            DataMap map = (DataMap) unmarshaller.unmarshal(datamapFile);
            for (DbEntity entity : map.getDbEntity()) {

                entity.getDbAttribute()
                        .stream()
                        .filter(attribute -> attribute.isIsPrimaryKey() != null && attribute.isIsPrimaryKey()
                                && attribute.isIsGenerated() != null && attribute.isIsGenerated())
                        .forEach(attribute -> {
                            addObjectProperty(map, entity, attribute);
                            attribute.setIsGenerated(null);
                            attribute.setIsPrimaryKey(null);
                        });
            }
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(map, datamapFile);

        } catch (JAXBException ex) {
            LOG.error("JAXB failed", ex);
        }
    }

    private void addObjectProperty(DataMap map, DbEntity dbEntity, DbAttribute dbAttribute) {
        Optional<ObjEntity> objEntityOptional = map.getObjEntity()
                .stream()
                .filter(obj -> obj.getDbEntityName().equals(dbEntity.getName()))
                .findAny();

        if (!objEntityOptional.isPresent()) {
            LOG.warn("Could not find a object dbEntity for db dbEntity " + dbEntity.getName());
            return;
        }

        ObjEntity objEntity = objEntityOptional.get();
        String dbAttributeType = dbAttribute.getType();
        int sqlType = TypesMapping.getSqlTypeByName(dbAttributeType);
        String javaType = TypesMapping.getJavaBySqlType(sqlType);

        if (javaType != null) {
            String dbAttributeName = dbAttribute.getName();
            String pkAttributeName = buildJavaName(dbAttributeName);

            Optional<ObjAttribute> presentAttribute = objEntity.getObjAttribute()
                    .stream()
                    .filter(objAttribute -> objAttribute.getName().equals(pkAttributeName))
                    .findAny();
            if (presentAttribute.isPresent()) {

                LOG.warn(objEntity.getName() + " already contains an attribute with name " + pkAttributeName);
            } else {

                ObjAttribute pkAttribute = new ObjAttribute();
                pkAttribute.setType(javaType);
                pkAttribute.setDbAttributePath(dbAttributeName);
                pkAttribute.setName(pkAttributeName);

                objEntity.getObjAttribute().add(pkAttribute);
                String msg = String.format("Added attribute %30s of type %25s to %s", pkAttributeName, pkAttribute.getType(), objEntity.getName());
                LOG.info(msg);
            }

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
