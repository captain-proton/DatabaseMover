package de.unidue.dbmover.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _ScheduledTasks was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _ScheduledTasks extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String CLASS_NAME_PK_COLUMN = "class_name";

    public static final Property<String> CLASS_NAME = Property.create("className", String.class);
    public static final Property<LocalDateTime> LAST_RUN = Property.create("lastRun", LocalDateTime.class);

    protected String className;
    protected LocalDateTime lastRun;


    public void setClassName(String className) {
        beforePropertyWrite("className", this.className, className);
        this.className = className;
    }

    public String getClassName() {
        beforePropertyRead("className");
        return this.className;
    }

    public void setLastRun(LocalDateTime lastRun) {
        beforePropertyWrite("lastRun", this.lastRun, lastRun);
        this.lastRun = lastRun;
    }

    public LocalDateTime getLastRun() {
        beforePropertyRead("lastRun");
        return this.lastRun;
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "className":
                return this.className;
            case "lastRun":
                return this.lastRun;
            default:
                return super.readPropertyDirectly(propName);
        }
    }

    @Override
    public void writePropertyDirectly(String propName, Object val) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch (propName) {
            case "className":
                this.className = (String)val;
                break;
            case "lastRun":
                this.lastRun = (LocalDateTime)val;
                break;
            default:
                super.writePropertyDirectly(propName, val);
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        writeSerialized(out);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        readSerialized(in);
    }

    @Override
    protected void writeState(ObjectOutputStream out) throws IOException {
        super.writeState(out);
        out.writeObject(this.className);
        out.writeObject(this.lastRun);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.className = (String)in.readObject();
        this.lastRun = (LocalDateTime)in.readObject();
    }

}