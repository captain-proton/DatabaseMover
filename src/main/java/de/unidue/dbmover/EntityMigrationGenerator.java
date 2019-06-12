package de.unidue.dbmover;

import com.squareup.javapoet.*;
import org.apache.cayenne.CayenneRuntimeException;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.exp.Property;
import org.apache.cayenne.map.ObjEntity;
import org.apache.cayenne.query.ObjectSelect;
import org.apache.cayenne.query.Orderings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

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

    public void generate() {
        ClassName base = generateBase();
        generateModifiableClass(base);
    }

    private ClassName generateBase() {
        ClassName className = ClassName.get(migrationBasePackageName, String.join("", "_", objectEntity.getName(), "Mover"));
        TypeSpec typeSpec = TypeSpec.classBuilder(className)
                .addModifiers(Modifier.PUBLIC)
                .addSuperinterface(EntityMover.class)
                .addField(FieldSpec.builder(Integer.class, "maxLoadedItems")
                        .addModifiers(Modifier.PRIVATE)
                        .initializer("200")
                        .build())
                .addMethod(buildDefaultConstructor())
                .addMethod(buildBaseMaxLoadedItemsConstructor())
                .addMethod(buildMoveMethod(objectEntity))
                .addMethod(buildMigrateMethod(objectEntity))
                .addMethod(buildLoadMethod(objectEntity))
                .addMethod(buildMaxLoadedItemsGetter())
                .addMethod(buildMaxLoadedItemsSetter())
                .build();

        JavaFile javaFile = JavaFile.builder(migrationBasePackageName, typeSpec).build();
        try {
            javaFile.writeTo(destinationDirectory);
        } catch (IOException e) {
            LOG.error("Could not generate migration class for entity " + objectEntity.getClassName(), e);
        }
        return className;
    }

    private MethodSpec buildMaxLoadedItemsGetter() {
        return MethodSpec.methodBuilder("getMaxLoadedItems")
                .addModifiers(Modifier.PUBLIC)
                .returns(Integer.class)
                .addStatement("return $N", "maxLoadedItems")
                .build();
    }

    private MethodSpec buildMaxLoadedItemsSetter() {
        return MethodSpec.methodBuilder("setMaxLoadedItems")
                .addModifiers(Modifier.PUBLIC)
                .addParameter(Integer.class, "maxLoadedItems")
                .addStatement("this.$N = $N", "maxLoadedItems", "maxLoadedItems")
                .build();
    }

    private MethodSpec buildDefaultConstructor() {
        return MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .build();
    }

    private MethodSpec buildBaseMaxLoadedItemsConstructor() {
        return MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(Integer.class, "maxLoadedItems")
                .addStatement("this.$N = $N", "maxLoadedItems", "maxLoadedItems")
                .build();
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
                .returns(Long.class)
                .addParameter(String.class, "sourceConfigFile")
                .addParameter(String.class, "destinationConfigFile")
                .addStatement("$T sourceRuntime = $T.builder().addConfig($N).build()", ServerRuntime.class, ServerRuntime.class, "sourceConfigFile")
                .addStatement("$T destinationRuntime = $T.builder().addConfig($N).build()", ServerRuntime.class, ServerRuntime.class, "destinationConfigFile")
                .addStatement("$T[] fields = $T.class.getFields()", Field.class, entityClass)
                .addStatement("$T<$T> properties = new $T<>()", List.class, Property.class, ArrayList.class)
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
                .addStatement("long movedObjectCount = 0L")
                .addStatement("$T sourceContext = sourceRuntime.newContext()", ObjectContext.class)
                .addStatement("$T destinationContext = destinationRuntime.newContext()", ObjectContext.class)
                .beginControlFlow("try")
                .addStatement("$N.select(ObjectSelect.query($L.class).limit(1))", "destinationContext", objEntity.getClassName())
                .addStatement("$N = migrate$L(sourceContext, destinationContext, properties)", "movedObjectCount", objEntity.getName())
                .nextControlFlow("catch ($T e)", CayenneRuntimeException.class)
                .addStatement("System.err.println(\"Unable to access \" + $L.class.getSimpleName())", objEntity.getClassName())
                .addStatement("$N.printStackTrace()", "e")
                .nextControlFlow("finally")
                .addStatement("$N.shutdown()", "sourceRuntime")
                .addStatement("$N.shutdown()", "destinationRuntime")
                .endControlFlow()
                .addStatement("return $N", "movedObjectCount")
                .build();
    }

    private MethodSpec buildMigrateMethod(ObjEntity objEntity) {

        String entityName = objEntity.getName();
        String entityClassName = objEntity.getClassName();
        ClassName listClassName = ClassName.get("java.util", "List");

        return buildMigrateMethodSignature()
                .addStatement("int offset = 0")
                .addStatement("long result = 0L")
                .addStatement("$T<$T> sourceObjects = load$L(offset, $N, $N)", listClassName, entityClass, entityName, "properties", "sourceContext")
                .beginControlFlow("while ($N.size() > 0)", "sourceObjects")
                .beginControlFlow("for ($L obj : $N)", entityClassName, "sourceObjects")
                .addStatement("$T dstObject = $N.newObject($T.class)", entityClass, "destinationContext", entityClass)
                .beginControlFlow("try")
                .beginControlFlow("for ($T property : properties)", Property.class)
                .addStatement("$T propertyName = property.getName()", String.class)
                .addStatement("$T propertyValue = obj.readProperty(propertyName)", Object.class)
                .addStatement("dstObject.writeProperty(propertyName, propertyValue)")
                .endControlFlow()
                .addStatement("destinationContext.commitChanges()")
                .addStatement("$N++", "result")
                .nextControlFlow("catch ($T e)", CayenneRuntimeException.class)
                .addStatement("$N.getGraphManager().unregisterNode($N.getObjectId())", "destinationContext", "dstObject")
                .addStatement("System.err.println(\"Could not commit \" + $N + \"; cause: \" + $N.getCause().getMessage())", "obj", "e")
                .endControlFlow()
                .endControlFlow()
                .addStatement("offset += $N", "maxLoadedItems")
                .addStatement("sourceObjects = load$L(offset, $N, sourceContext)", entityName, "properties")
                .endControlFlow()
                .addStatement("return result")
                .build();
    }

    private MethodSpec buildLoadMethod(ObjEntity objEntity) {

        CodeBlock orderingsBlock = CodeBlock.builder()
                .addStatement("$T orderings = new $T()", Orderings.class, Orderings.class)
                .addStatement("$N.stream().map(p -> p.asc()).forEach(o -> $N.add(o))", "properties", "orderings")
                .build();
        return buildLoadMethodSignature()
                .addCode(orderingsBlock)
                .addStatement("return $T.query($L.class)" +
                        ".offset(offset)" +
                        ".orderBy($N)" +
                        ".limit($N)" +
                        ".select(context)",
                        ObjectSelect.class, objEntity.getClassName(), "orderings", "maxLoadedItems")
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
                .addAnnotation(Mover.class)
                .addModifiers(Modifier.PUBLIC)
                .addMethod(buildDefaultConstructor())
                .addMethod(buildMaxLoadedItemsConstructor())
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

    private MethodSpec buildMaxLoadedItemsConstructor() {

        return MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(Integer.class, "maxLoadedItems")
                .addStatement("super($N)", "maxLoadedItems")
                .build();
    }

    private MethodSpec buildLoadMethodOverride() {
        return buildLoadMethodSignature()
                .addAnnotation(Override.class)
                .addComment("Use this method to implement your own 'load" + objectEntity.getName() + "' implementation")
                .addStatement("return super.load$L($N, $N, $N)", objectEntity.getName(), "offset", "properties", "context")
                .build();
    }

    private MethodSpec buildMigrateMethodOverride() {
        return buildMigrateMethodSignature()
                .addAnnotation(Override.class)
                .addComment("Use this method to implement your own 'migrate" + objectEntity.getName() + "' implementation")
                .addStatement("return super.migrate$L($N, $N, $N)", objectEntity.getName(), "sourceContext", "destinationContext", "properties")
                .build();
    }

    private MethodSpec.Builder buildMigrateMethodSignature() {

        ClassName listClassName = ClassName.get("java.util", "List");
        ClassName propertyClassName = ClassName.get(Property.class);
        TypeName propertiesType = ParameterizedTypeName.get(listClassName, propertyClassName);

        return MethodSpec.methodBuilder("migrate" + objectEntity.getName())
                .returns(Long.class)
                .addModifiers(Modifier.PROTECTED)
                .addParameter(ObjectContext.class, "sourceContext")
                .addParameter(ObjectContext.class, "destinationContext")
                .addParameter(propertiesType, "properties");
    }

    private MethodSpec.Builder buildLoadMethodSignature() {

        ClassName listClassName = ClassName.get(List.class);
        ClassName objClassName = ClassName.get(entityClass);
        TypeName returnType = ParameterizedTypeName.get(listClassName, objClassName);

        ClassName propertyClassName = ClassName.get(Property.class);
        TypeName propertiesType = ParameterizedTypeName.get(listClassName, propertyClassName);

        return MethodSpec.methodBuilder("load" + objectEntity.getName())
                .addModifiers(Modifier.PROTECTED)
                .returns(returnType)
                .addParameter(Integer.class, "offset")
                .addParameter(propertiesType, "properties")
                .addParameter(ObjectContext.class, "context");
    }
}
