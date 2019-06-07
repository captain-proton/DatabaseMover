package de.unidue.dbmover;

public interface EntityMover {

    /**
     * Moves all of a given object entity from a data source given through the source config file
     * to a destination data source given inside the destination config file.
     *
     * @param cayenneSourceConfigFile      Path that contains the configuration file that points to the source data source
     * @param cayenneDestinationConfigFile Path that contains the configuration file that points to the destination data source
     */
    void move(String cayenneSourceConfigFile, String cayenneDestinationConfigFile);

    /**
     * Sets how many maximum items should be loaded during movement.
     *
     * @param maxLoadedItems Integer greater than zero
     */
    void setMaxLoadedItems(Integer maxLoadedItems);
}
