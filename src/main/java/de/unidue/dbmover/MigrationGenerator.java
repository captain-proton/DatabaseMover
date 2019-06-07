package de.unidue.dbmover;

import org.apache.cayenne.access.DataDomain;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.map.DataMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class MigrationGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(MigrationGenerator.class);

    private final String packageName;

    public MigrationGenerator(String packageName) {
        this.packageName = packageName;
    }

    public void generate() {
        ServerRuntime runtime = ServerRuntime.builder()
                .addConfig("cayenne-source.xml")
                .build();
        DataDomain dataDomain = runtime.getDataDomain();
        DataMap datamap = dataDomain.getDataMap("datamap");

        File dstDir = new File("src/gen/java");

        datamap.getObjEntities().forEach(entity -> {

            try {
                EntityMigrationGenerator generator = new EntityMigrationGenerator(packageName, entity, dstDir);
                generator.generate();
            } catch (ClassNotFoundException e) {
                LOG.error("Could not generate migration class for entity " + entity.getName(), e);
            }
        });
    }
}
