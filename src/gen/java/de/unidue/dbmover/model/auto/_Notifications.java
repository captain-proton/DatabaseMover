package de.unidue.dbmover.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _Notifications was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Notifications extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String NOTIFICATION_ID_PK_COLUMN = "notification_id";

    public static final Property<Long> CONTEXT_ID = Property.create("contextId", Long.class);
    public static final Property<Long> USER_ID = Property.create("userId", Long.class);
    public static final Property<Long> LEVEL = Property.create("level", Long.class);
    public static final Property<Long> TYPE = Property.create("type", Long.class);
    public static final Property<LocalDateTime> DATE_CREATED = Property.create("dateCreated", LocalDateTime.class);
    public static final Property<LocalDateTime> DATE_READ = Property.create("dateRead", LocalDateTime.class);
    public static final Property<Long> ASSOC_TYPE = Property.create("assocType", Long.class);
    public static final Property<Long> ASSOC_ID = Property.create("assocId", Long.class);

    protected long contextId;
    protected Long userId;
    protected long level;
    protected long type;
    protected LocalDateTime dateCreated;
    protected LocalDateTime dateRead;
    protected Long assocType;
    protected Long assocId;


    public void setContextId(long contextId) {
        beforePropertyWrite("contextId", this.contextId, contextId);
        this.contextId = contextId;
    }

    public long getContextId() {
        beforePropertyRead("contextId");
        return this.contextId;
    }

    public void setUserId(long userId) {
        beforePropertyWrite("userId", this.userId, userId);
        this.userId = userId;
    }

    public long getUserId() {
        beforePropertyRead("userId");
        if(this.userId == null) {
            return 0;
        }
        return this.userId;
    }

    public void setLevel(long level) {
        beforePropertyWrite("level", this.level, level);
        this.level = level;
    }

    public long getLevel() {
        beforePropertyRead("level");
        return this.level;
    }

    public void setType(long type) {
        beforePropertyWrite("type", this.type, type);
        this.type = type;
    }

    public long getType() {
        beforePropertyRead("type");
        return this.type;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        beforePropertyWrite("dateCreated", this.dateCreated, dateCreated);
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateCreated() {
        beforePropertyRead("dateCreated");
        return this.dateCreated;
    }

    public void setDateRead(LocalDateTime dateRead) {
        beforePropertyWrite("dateRead", this.dateRead, dateRead);
        this.dateRead = dateRead;
    }

    public LocalDateTime getDateRead() {
        beforePropertyRead("dateRead");
        return this.dateRead;
    }

    public void setAssocType(long assocType) {
        beforePropertyWrite("assocType", this.assocType, assocType);
        this.assocType = assocType;
    }

    public long getAssocType() {
        beforePropertyRead("assocType");
        if(this.assocType == null) {
            return 0;
        }
        return this.assocType;
    }

    public void setAssocId(long assocId) {
        beforePropertyWrite("assocId", this.assocId, assocId);
        this.assocId = assocId;
    }

    public long getAssocId() {
        beforePropertyRead("assocId");
        if(this.assocId == null) {
            return 0;
        }
        return this.assocId;
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "contextId":
                return this.contextId;
            case "userId":
                return this.userId;
            case "level":
                return this.level;
            case "type":
                return this.type;
            case "dateCreated":
                return this.dateCreated;
            case "dateRead":
                return this.dateRead;
            case "assocType":
                return this.assocType;
            case "assocId":
                return this.assocId;
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
            case "contextId":
                this.contextId = val == null ? 0 : (long)val;
                break;
            case "userId":
                this.userId = (Long)val;
                break;
            case "level":
                this.level = val == null ? 0 : (long)val;
                break;
            case "type":
                this.type = val == null ? 0 : (long)val;
                break;
            case "dateCreated":
                this.dateCreated = (LocalDateTime)val;
                break;
            case "dateRead":
                this.dateRead = (LocalDateTime)val;
                break;
            case "assocType":
                this.assocType = (Long)val;
                break;
            case "assocId":
                this.assocId = (Long)val;
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
        out.writeLong(this.contextId);
        out.writeObject(this.userId);
        out.writeLong(this.level);
        out.writeLong(this.type);
        out.writeObject(this.dateCreated);
        out.writeObject(this.dateRead);
        out.writeObject(this.assocType);
        out.writeObject(this.assocId);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.contextId = in.readLong();
        this.userId = (Long)in.readObject();
        this.level = in.readLong();
        this.type = in.readLong();
        this.dateCreated = (LocalDateTime)in.readObject();
        this.dateRead = (LocalDateTime)in.readObject();
        this.assocType = (Long)in.readObject();
        this.assocId = (Long)in.readObject();
    }

}
