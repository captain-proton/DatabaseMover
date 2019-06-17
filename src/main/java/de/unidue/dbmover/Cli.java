package de.unidue.dbmover;

import org.apache.commons.cli.*;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class Cli {

    private static final Logger LOG = LoggerFactory.getLogger(Cli.class);

    public static void main(String[] args) {

        Option genPkOption = Option.builder("gen_missing_attributes")
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
        Option moveOption = Option.builder("move")
                .hasArg()
                .numberOfArgs(3)
                .argName("src> <dest> <package")
                .valueSeparator(' ')
                .desc("Invokes all mover classes that were generated in the" +
                        " gen_migrators step. Src and dest must point to" +
                        " cayenne project files that contain the domain the source" +
                        " and destination operates on. The package points to" +
                        " the package that contains all generated mover classes")
                .build();

        Option initOption = Option.builder("init")
                .desc("Initializes a database moving project. A project contains" +
                        " a datamap that is used both inside the source and" +
                        " destination project files. These files will be put" +
                        " under the 'conf' path and contain empty value, that" +
                        " must be set through the use of the cayenne modeler or" +
                        " by hand.")
                .build();
        Option help = Option.builder("h")
                .longOpt("help")
                .desc("print usage help of this application")
                .build();

        Options options = new Options();
        options.addOption(initOption);
        options.addOption(genPkOption);
        options.addOption(genMigrationOption);
        options.addOption(moveOption);
        options.addOption(help);

        // create the parser
        CommandLineParser parser = new DefaultParser();

        Cli cli = new Cli();

        try {
            // parse the command commandLine arguments
            CommandLine commandLine = parser.parse(options, args);
            boolean hasOptions = commandLine.getOptions() != null && commandLine.getOptions().length > 0;
            if (commandLine.hasOption('h') || !hasOptions) {

                printHelp(options);
            } else {
                cli.execCommand(commandLine);
            }
        } catch (ParseException e) {
            LOG.error("An error occurred on parse of arguments", e);
            printHelp(options);
        }
    }

    private void execCommand(CommandLine commandLine) {

        if (commandLine.hasOption("init")) {

            File path = new File("conf");
            initProject(path);
        } else if (commandLine.hasOption("gen_missing_attributes")) {

            String datamapFilename = commandLine.getOptionValue("gen_missing_attributes");
            MissingAttributeGenerator attributeGenerator = new MissingAttributeGenerator();
            attributeGenerator.generateAttributes(datamapFilename);
        } else if (commandLine.hasOption("gen_migrators")) {

            String packageName = commandLine.getOptionValue("gen_migrators");
            MigrationGenerator generator = new MigrationGenerator(packageName);
            generator.generate();
        } else if (commandLine.hasOption("move")) {

            String[] files = commandLine.getOptionValues("move");
            String src = files[0];
            String dest = files[1];
            String moverPackage = files[2];
            DbMover mover = new DbMover();
            mover.invokeAll(src, dest, moverPackage);
        }
    }

    private void initProject(File path) {
        if (!path.exists() && !path.mkdirs()) {
            LOG.error("Could not create project home directory " + path.getAbsolutePath());
            return;
        }
        try {
            copy("/cayenne-project.xml", path, "cayenne-source.xml");
            copy("/cayenne-project.xml", path, "cayenne-destination.xml");
            copy("/empty.datamap.map.xml", path, "datamap.map.xml");
        } catch (IOException e) {
            LOG.error("Could not copy initialization files to conf dir");
        }
    }

    private void copy(String src, File dir, String name) throws IOException {
        File dst = new File(dir, name);
        FileUtils.copyInputStreamToFile(Cli.class.getResourceAsStream(src), dst);
        LOG.info("Created " + dst.getCanonicalPath());
    }

    private static void printHelp(Options options) {

        // automatically generate the help statement
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("./gradlew cli -Dexec.args='-foo bar'", options);
    }
}
