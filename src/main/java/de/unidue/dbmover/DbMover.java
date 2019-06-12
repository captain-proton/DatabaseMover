package de.unidue.dbmover;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DbMover {

    private static final Logger LOG = LoggerFactory.getLogger(DbMover.class);

    public void invokeAll(String cayenneSourceProjectFile,
                          String cayenneDestinationProjectFile,
                          String moverPackage) {

        Reflections reflections = new Reflections(moverPackage);
        List<Class<? extends EntityMover>> movers = reflections.getSubTypesOf(EntityMover.class)
                .stream()
                .filter(m -> m.isAnnotationPresent(Mover.class))
                .sorted(Comparator.comparing(Class::getSimpleName))
                .collect(Collectors.toList());

        movers.forEach(m -> {
            String moverName = m.getSimpleName();
            try {
                EntityMover mover = m.newInstance();
                LOG.info("Starting " + moverName);
                long start = System.currentTimeMillis();
                mover.move(cayenneSourceProjectFile, cayenneDestinationProjectFile);
                LOG.info(moverName + " finished in " + (System.currentTimeMillis() - start) + " ms");
            } catch (InstantiationException e) {
                LOG.error("Could not instantiate " + m.getName(), e);
            } catch (IllegalAccessException e) {
                LOG.error("Could not access contructors of " + m.getName(), e);
            } catch (Exception e) {
                LOG.error(moverName + " was not able to move records", e);
            }
        });
    }
}
