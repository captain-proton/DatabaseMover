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
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AccessKeyMover {

    public void move() {

        ServerRuntime sourceRuntime = ServerRuntime.builder()
                .addConfig("cayenne-source.xml")
                .build();
        ServerRuntime destinationRuntime = ServerRuntime.builder()
                .addConfig("cayenne-destination.xml")
                .build();
        printRuntimeMeta(sourceRuntime);
        printRuntimeMeta(destinationRuntime);

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

        int offset = 0;
        int limit = 200;
        List<AccessKeys> accessKeys = ObjectSelect
                .query(AccessKeys.class)
                .offset(offset)
                .limit(limit)
                .select(sourceContext);

        for (AccessKeys srcObject : accessKeys) {

            AccessKeys dstObject = new AccessKeys();
            dstObject.setObjectId(srcObject.getObjectId());

            for (Property property : properties) {

                String propertyName = property.getName();
                Object propertyValue = srcObject.readProperty(propertyName);
                dstObject.writeProperty(propertyName, propertyValue);
            }
            destinationContext.registerNewObject(dstObject);
        }
        destinationContext.commitChanges();
    }

    private void printRuntimeMeta(ServerRuntime runtime) {
        DataDomain domain = runtime.getDataDomain();
        domain.getDataMaps().forEach(map ->  {
            System.out.println(map.getDefaultSchema());
            DataChannelDescriptor channelDescriptor = map.getDataChannelDescriptor();
        });
        domain.getDataNodes().forEach(node -> {
            System.out.println(node.getName());
        });
        System.out.println();
    }
}
