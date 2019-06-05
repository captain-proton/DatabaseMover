package de.unidue.dbmover;

import org.apache.cayenne.access.DataDomain;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.map.DataMap;
import org.apache.cayenne.map.DbEntity;

public class Mover {

    public static void main(String[] args) {
        ServerRuntime runtime = ServerRuntime.builder()
                .addConfig("cayenne-project.xml")
                .build();
        DataDomain dataDomain = runtime.getDataDomain();
        DataMap datamap = dataDomain.getDataMap("datamap");
        for (DbEntity entity : datamap.getDbEntities()) {
            System.out.println(entity.getFullyQualifiedName());

        }
    }
}
