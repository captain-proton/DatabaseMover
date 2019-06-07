package de.unidue.dbmover;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.stream.Collectors;

public class DbMover {

    private static final Logger LOG = LoggerFactory.getLogger(DbMover.class);

    public void invokeAll(String cayenneSourceProjectFile,
                          String cayenneDestinationProjectFile,
                          String moverPackage) {

        Reflections reflections = new Reflections(moverPackage);
        Set<Class<? extends EntityMover>> movers = reflections.getSubTypesOf(EntityMover.class)
                .stream()
                .filter(m -> m.isAnnotationPresent(Mover.class))
                .collect(Collectors.toSet());

        movers.forEach(m -> {
            try {
                EntityMover mover = m.newInstance();
                mover.move(cayenneSourceProjectFile, cayenneDestinationProjectFile);
            } catch (InstantiationException e) {
                LOG.error("Could not instantiate " + m.getName(), e);
            } catch (IllegalAccessException e) {
                LOG.error("Could not access contructors of " + m.getName(), e);
            }
        });
    }
}
