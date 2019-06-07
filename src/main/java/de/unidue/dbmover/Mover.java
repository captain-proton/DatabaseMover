package de.unidue.dbmover;

import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mover {

    private static final Logger LOG = LoggerFactory.getLogger(Mover.class);

    public static void main(String[] args) {

        Option genPkOption = Option.builder("gen_pk_atts")
                .hasArg()
                .argName("datamap")
                .desc("Creates settable properties for all primary key" +
                        " attributes that have are automatically generated" +
                        " by the database. This must be done before all records" +
                        " are move to another database. Otherwise these keys" +
                        " will be generated and you lose object references. The" +
                        " datamap points to the cayenne datamap file that" +
                        " contains all table and object entities")
                .build();
        Option genMigrationOption = Option.builder("gen_migrators")
                .hasArg()
                .argName("package")
                .desc("Generates a base mover class for each object entity" +
                        " that is able to read objects from a source database" +
                        " and writes them into a destination database. The" +
                        " source must be defined in the cayenne-source.xml" +
                        " file and the destination inside the cayenne-destination.xml" +
                        " in src/main/resources. For each base class a modifiable" +
                        " subclass will be created in the given package. This" +
                        " class is only generated if it is not present.")
                .build();
        Option help = Option.builder("h")
                .longOpt("help")
                .desc("print usage help of this application")
                .build();

        Options options = new Options();
        options.addOption(genPkOption);
        options.addOption(genMigrationOption);
        options.addOption(help);

        // create the parser
        CommandLineParser parser = new DefaultParser();

        try {
            // parse the command line arguments
            CommandLine line = parser.parse(options, args);
            boolean hasOptions = line.getOptions() != null && line.getOptions().length > 0;
            if (line.hasOption('h') || !hasOptions) {
                printHelp(options);
            } else if (line.hasOption("gen_pk_atts")) {
                String datamapFilename = line.getOptionValue("gen_pk_atts");
                PkAttributeGenerator attributeGenerator = new PkAttributeGenerator();
                attributeGenerator.generateAttributes(datamapFilename);
            } else if (line.hasOption("gen_migrators")) {
                String packageName = line.getOptionValue("gen_migrators");
                MigrationGenerator generator = new MigrationGenerator(packageName);
                generator.generate();
            }
        } catch (ParseException e) {
            LOG.error("An error occurred on parse of arguments", e);
            printHelp(options);
        }
    }

    private static void printHelp(Options options) {

        // automatically generate the help statement
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "./gradlew move -Dexec.args='-foo bar'", options );
    }
}
