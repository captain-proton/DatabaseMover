package de.unidue.dbmover;

import de.unidue.dbmover.model.AccessKeys;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.access.DataDomain;
import org.apache.cayenne.configuration.DataChannelDescriptor;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.exp.Property;
import org.apache.cayenne.map.DataMap;
import org.apache.cayenne.query.ObjectSelect;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AccessKeyMover {

    public static void main(String[] args) {
        AccessKeyMover mover = new AccessKeyMover();
        mover.move();
    }

    public void move() {

        ServerRuntime sourceRuntime = ServerRuntime.builder()
                .addConfig("cayenne-source.xml")
                .build();
        ServerRuntime destinationRuntime = ServerRuntime.builder()
                .addConfig("cayenne-destination.xml")
                .build();

        Field[] fields = AccessKeys.class.getFields();
        Set<Property> properties = new HashSet<>();
        for (Field field : fields) {
            if (field.getType().equals(Property.class)) {
                try {
                    Property property = (Property) field.get(null);
                    properties.add(property);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        ObjectContext sourceContext = sourceRuntime.newContext();
        ObjectContext destinationContext = destinationRuntime.newContext();

        migrateAccessKeys(sourceContext, destinationContext, properties);
    }

    protected void migrateAccessKeys(ObjectContext sourceContext, ObjectContext destinationContext, Set<Property> properties) {

        int offset = 0;
        int limit = 200;

        List<AccessKeys> accessKeys = loadAccessKeys(offset, limit, sourceContext);

        while (accessKeys.size() > 0) {


            for (AccessKeys srcObject : accessKeys) {

                AccessKeys dstObject = destinationContext.newObject(AccessKeys.class);

                for (Property property : properties) {

                    String propertyName = property.getName();
                    Object propertyValue = srcObject.readProperty(propertyName);
                    dstObject.writeProperty(propertyName, propertyValue);
                }
            }
            destinationContext.commitChanges();

            offset += limit;
            accessKeys = loadAccessKeys(offset, limit, sourceContext);
        };
    }

    protected List<AccessKeys> loadAccessKeys(int offset, int limit, ObjectContext context) {
        return ObjectSelect
                .query(AccessKeys.class)
                .offset(offset)
                .limit(limit)
                .select(context);
    }
}
