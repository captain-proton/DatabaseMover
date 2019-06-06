package de.unidue.dbmover;

import com.squareup.javapoet.*;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.access.DataDomain;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.exp.Property;
import org.apache.cayenne.map.DataMap;
import org.apache.cayenne.map.ObjEntity;
import org.apache.cayenne.query.ObjectSelect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EntityMigrationGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(EntityMigrationGenerator.class);

    private final String migrationBasePackageName;
    private final ObjEntity objectEntity;
    private final File destinationDirectory;
    private final Class<?> entityClass;

    public EntityMigrationGenerator(String migrationPackageName, ObjEntity objectEntity, File destinationDirectory) throws ClassNotFoundException {

        this.migrationBasePackageName = migrationPackageName + ".auto";
        this.objectEntity = objectEntity;
        this.destinationDirectory = destinationDirectory;
        this.entityClass = Class.forName(objectEntity.getClassName());
    }

    public static void main(String[] args) {

        ServerRuntime runtime = ServerRuntime.builder()
                .addConfig("cayenne-source.xml")
                .build();
        DataDomain dataDomain = runtime.getDataDomain();
        DataMap datamap = dataDomain.getDataMap("datamap");

        File dstDir = new File("src/gen/java");
        String migrationPackageName = "de.unidue.dbmover.migration";

        datamap.getObjEntities().forEach(entity ->  {

            try {
                EntityMigrationGenerator generator = new EntityMigrationGenerator(migrationPackageName, entity, dstDir);
                TypeSpec base = generator.generateBase();
                generator.generate(base, dstDir, migrationPackageName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public TypeSpec generateBase() {
        TypeSpec typeSpec = TypeSpec.classBuilder(String.join("", "_", objectEntity.getName(), "Mover"))
                .addModifiers(Modifier.PUBLIC)
                .addMethod(buildMoveMethod(objectEntity))
                .addMethod(buildMigrateMethod(objectEntity))
                .addMethod(buildLoadMethod(objectEntity))
                .build();

        JavaFile javaFile = JavaFile.builder(migrationBasePackageName, typeSpec).build();
        try {
            javaFile.writeTo(destinationDirectory);
        } catch (IOException e) {
            LOG.error("Could not generate migration class for entity " + objectEntity.getClassName(), e);
        }
        return typeSpec;
    }

    private MethodSpec buildMoveMethod(ObjEntity objEntity) {
        return MethodSpec.methodBuilder("move")
                .addModifiers(Modifier.PUBLIC)
                .addStatement("$T sourceRuntime = $T.builder().addConfig(\"cayenne-source.xml\").build()", ServerRuntime.class, ServerRuntime.class)
                .addStatement("$T destinationRuntime = $T.builder().addConfig(\"cayenne-destination.xml\").build()", ServerRuntime.class, ServerRuntime.class)
                .addStatement("$T[] fields = $T.class.getFields()", Field.class, entityClass)
                .addStatement("$T<$T> properties = new $T<>()", Set.class, Property.class, HashSet.class)
                .beginControlFlow("for ($T field : fields)", Field.class)
                .beginControlFlow("if (field.getType().equals($T.class))", Property.class)
                .beginControlFlow("try")
                .addStatement("$T property = ($T) field.get(null)",  Property.class,  Property.class)
                .addStatement("properties.add(property)")
                .nextControlFlow("catch ($T e)", IllegalAccessException.class)
                .addStatement("e.printStackTrace()")
                .endControlFlow()
                .endControlFlow()
                .endControlFlow()
                .addStatement("$T sourceContext = sourceRuntime.newContext()", ObjectContext.class)
                .addStatement("$T destinationContext = destinationRuntime.newContext()", ObjectContext.class)
                .addStatement("migrate$L(sourceContext, destinationContext, properties)", objEntity.getName())
                .build();
    }

    private MethodSpec buildMigrateMethod(ObjEntity objEntity) {

        String entityName = objEntity.getName();
        String entityClassName = objEntity.getClassName();
        ClassName setClassName = ClassName.get("java.util", "Set");
        ClassName listClassName = ClassName.get("java.util", "List");
        ClassName propertyClassName = ClassName.get(Property.class);
        TypeName propertiesType = ParameterizedTypeName.get(setClassName, propertyClassName);

        return MethodSpec.methodBuilder("migrate" + entityName)
                .addModifiers(Modifier.PROTECTED)
                .addParameter(ObjectContext.class, "sourceContext")
                .addParameter(ObjectContext.class, "destinationContext")
                .addParameter(propertiesType, "properties")
                .addStatement("int offset = 0")
                .addStatement("int limit = 200")
                .addStatement("$T<$T> sourceObjects = load$L(offset, limit, $N)", listClassName, entityClass, entityName, "sourceContext")
                .beginControlFlow("while ($N.size() > 0)", "sourceObjects")
                .beginControlFlow("for ($L obj : $N)", entityClassName, "sourceObjects")
                .addStatement("$T dstObject = $N.newObject($T.class)", entityClass, "destinationContext", entityClass)
                .beginControlFlow("for ($T property : properties)", Property.class)
                .addStatement("$T propertyName = property.getName()", String.class)
                .addStatement("$T propertyValue = obj.readProperty(propertyName)", Object.class)
                .addStatement("dstObject.writeProperty(propertyName, propertyValue)")
                .endControlFlow()
                .endControlFlow()
                .addStatement("destinationContext.commitChanges()")
                .addStatement("offset += limit")
                .addStatement("sourceObjects = load$L(offset, limit, sourceContext)", entityName)
                .endControlFlow()
                .build();
    }

    private MethodSpec buildLoadMethod(ObjEntity objEntity) {

        ClassName listClassName = ClassName.get(List.class);
        ClassName objClassName = ClassName.get(entityClass);
        TypeName returnType = ParameterizedTypeName.get(listClassName, objClassName);

        return MethodSpec.methodBuilder("load" + objEntity.getName())
                .addModifiers(Modifier.PROTECTED)
                .returns(returnType)
                .addParameter(Integer.class, "offset")
                .addParameter(Integer.class, "limit")
                .addParameter(ObjectContext.class, "context")
                .addStatement("return $T.query($L.class)" +
                        ".offset(offset)" +
                        ".limit(limit)" +
                        ".select(context)", ObjectSelect.class, objEntity.getClassName())
                .build();
    }

    private void generate(TypeSpec baseClass, File dstDir, String packageName) {

    }
}
