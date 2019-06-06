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

    private final String migrationPackageName;
    private final String migrationBasePackageName;
    private final ObjEntity objectEntity;
    private final File destinationDirectory;
    private final Class<?> entityClass;

    public EntityMigrationGenerator(String migrationPackageName, ObjEntity objectEntity, File destinationDirectory) throws ClassNotFoundException {

        this.migrationPackageName = migrationPackageName;
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

        datamap.getObjEntities().forEach(entity -> {

            try {
                EntityMigrationGenerator generator = new EntityMigrationGenerator(migrationPackageName, entity, dstDir);
                ClassName base = generator.generateBase();
                generator.generateModifiableClass(base);
            } catch (ClassNotFoundException e) {
                LOG.error("Could not generate migration class for entity " + entity.getName(), e);
            }
        });
    }

    private ClassName generateBase() {
        ClassName className = ClassName.get(migrationBasePackageName, String.join("", "_", objectEntity.getName(), "Mover"));
        TypeSpec typeSpec = TypeSpec.classBuilder(className)
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
        return className;
    }

    private MethodSpec buildMoveMethod(ObjEntity objEntity) {
        return MethodSpec.methodBuilder("move")
                .addJavadoc("<p>Moves all records that are associated to the object entity\n"
                        + "{@code $L}.</p>\n"
                        + "\n"
                        + "<p>{@code move} is the first method to be called to replicate\n"
                        + "one record from a database to another one. It loads all\n"
                        + "static properties ({@code $T}) from the object entity\n"
                        + "and calls {@code migrate$L}.</p>",
                        objEntity.getName(), Property.class, objEntity.getName())
                .addModifiers(Modifier.PUBLIC)
                .addStatement("$T sourceRuntime = $T.builder().addConfig(\"cayenne-source.xml\").build()", ServerRuntime.class, ServerRuntime.class)
                .addStatement("$T destinationRuntime = $T.builder().addConfig(\"cayenne-destination.xml\").build()", ServerRuntime.class, ServerRuntime.class)
                .addStatement("$T[] fields = $T.class.getFields()", Field.class, entityClass)
                .addStatement("$T<$T> properties = new $T<>()", Set.class, Property.class, HashSet.class)
                .beginControlFlow("for ($T field : fields)", Field.class)
                .beginControlFlow("if (field.getType().equals($T.class))", Property.class)
                .beginControlFlow("try")
                .addStatement("$T property = ($T) field.get(null)", Property.class, Property.class)
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
        ClassName listClassName = ClassName.get("java.util", "List");

        return buildMigrateMethodSignature()
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

        return buildLoadMethodSignature()
                .addStatement("return $T.query($L.class)" +
                        ".offset(offset)" +
                        ".limit(limit)" +
                        ".select(context)", ObjectSelect.class, objEntity.getClassName())
                .build();
    }

    private void generateModifiableClass(ClassName baseClass) {

        // com.example._SampleMover -> com/example/SampleMover.java
        StringBuilder classFilename = new StringBuilder(migrationPackageName.replaceAll("\\.", "/"));
        classFilename.append("/");
        classFilename.append(baseClass.simpleName().substring(1));
        classFilename.append(".java");
        File moverClassFile = new File(destinationDirectory, classFilename.toString());
        if (moverClassFile.exists()) {
            return;
        }
        TypeSpec typeSpec = TypeSpec.classBuilder(objectEntity.getName() + "Mover")
                .superclass(baseClass)
                .addModifiers(Modifier.PUBLIC)
                .addMethod(buildMigrateMethodOverride())
                .addMethod(buildLoadMethodOverride())
                .build();

        JavaFile javaFile = JavaFile.builder(migrationPackageName, typeSpec).build();
        try {
            javaFile.writeTo(destinationDirectory);
        } catch (IOException e) {
            LOG.error("Could not generate modifiable migration class for entity " + objectEntity.getClassName(), e);
        }
    }

    private MethodSpec buildLoadMethodOverride() {
        return buildLoadMethodSignature()
                .addAnnotation(Override.class)
                .addComment("Use this method to implement your own 'load" + objectEntity.getName() + "' implementation")
                .addStatement("return super.load$L($N, $N, $N)", objectEntity.getName(), "offset", "limit", "context")
                .build();
    }

    private MethodSpec buildMigrateMethodOverride() {
        return buildMigrateMethodSignature()
                .addAnnotation(Override.class)
                .addComment("Use this method to implement your own 'migrate" + objectEntity.getName() + "' implementation")
                .addStatement("super.migrate$L($N, $N, $N)", objectEntity.getName(), "sourceContext", "destinationContext", "properties")
                .build();
    }

    private MethodSpec.Builder buildMigrateMethodSignature() {

        ClassName setClassName = ClassName.get("java.util", "Set");
        ClassName propertyClassName = ClassName.get(Property.class);
        TypeName propertiesType = ParameterizedTypeName.get(setClassName, propertyClassName);

        return MethodSpec.methodBuilder("migrate" + objectEntity.getName())
                .addModifiers(Modifier.PROTECTED)
                .addParameter(ObjectContext.class, "sourceContext")
                .addParameter(ObjectContext.class, "destinationContext")
                .addParameter(propertiesType, "properties");
    }

    private MethodSpec.Builder buildLoadMethodSignature() {

        ClassName listClassName = ClassName.get(List.class);
        ClassName objClassName = ClassName.get(entityClass);
        TypeName returnType = ParameterizedTypeName.get(listClassName, objClassName);

        return MethodSpec.methodBuilder("load" + objectEntity.getName())
                .addModifiers(Modifier.PROTECTED)
                .returns(returnType)
                .addParameter(Integer.class, "offset")
                .addParameter(Integer.class, "limit")
                .addParameter(ObjectContext.class, "context");
    }
}
