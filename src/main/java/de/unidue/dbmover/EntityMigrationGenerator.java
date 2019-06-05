package de.unidue.dbmover;

import org.apache.cayenne.access.DataDomain;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.map.DataMap;
import org.apache.cayenne.map.DbEntity;

import java.io.File;

public class EntityMigrationGenerator {

    public static void main(String[] args) {
        EntityMigrationGenerator generator = new EntityMigrationGenerator();

        ServerRuntime runtime = ServerRuntime.builder()
                .addConfig("cayenne-source.xml")
                .build();
        DataDomain dataDomain = runtime.getDataDomain();
        DataMap datamap = dataDomain.getDataMap("datamap");

        File dstDir = new File("src/gen/java");
        String packageName = "de.unidue.dbmover.migration";

        datamap.getDbEntities().forEach(entity -> generator.generate(entity, dstDir, packageName));
    }

    public void generate(DbEntity dbEntity, File destDir, String packageName) {

    }
}
