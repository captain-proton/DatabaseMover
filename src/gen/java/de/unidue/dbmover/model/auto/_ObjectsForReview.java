package de.unidue.dbmover.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _ObjectsForReview was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _ObjectsForReview extends BaseDataObject {

    private static final long serialVersionUID = 1L; 


    public static final Property<Long> REVIEW_OBJECT_TYPE_ID = Property.create("reviewObjectTypeId", Long.class);
    public static final Property<Long> CONTEXT_ID = Property.create("contextId", Long.class);
    public static final Property<Short> AVAILABLE = Property.create("available", Short.class);
    public static final Property<LocalDateTime> DATE_CREATED = Property.create("dateCreated", LocalDateTime.class);
    public static final Property<Long> EDITOR_ID = Property.create("editorId", Long.class);
    public static final Property<String> NOTES = Property.create("notes", String.class);
    public static final Property<Integer> OBJECT_IDENTIFIER = Property.create("objectIdentifier", Integer.class);

    protected long reviewObjectTypeId;
    protected long contextId;
    protected short available;
    protected LocalDateTime dateCreated;
    protected Long editorId;
    protected String notes;
    protected Integer objectIdentifier;


    public void setReviewObjectTypeId(long reviewObjectTypeId) {
        beforePropertyWrite("reviewObjectTypeId", this.reviewObjectTypeId, reviewObjectTypeId);
        this.reviewObjectTypeId = reviewObjectTypeId;
    }

    public long getReviewObjectTypeId() {
        beforePropertyRead("reviewObjectTypeId");
        return this.reviewObjectTypeId;
    }

    public void setContextId(long contextId) {
        beforePropertyWrite("contextId", this.contextId, contextId);
        this.contextId = contextId;
    }

    public long getContextId() {
        beforePropertyRead("contextId");
        return this.contextId;
    }

    public void setAvailable(short available) {
        beforePropertyWrite("available", this.available, available);
        this.available = available;
    }

    public short getAvailable() {
        beforePropertyRead("available");
        return this.available;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        beforePropertyWrite("dateCreated", this.dateCreated, dateCreated);
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateCreated() {
        beforePropertyRead("dateCreated");
        return this.dateCreated;
    }

    public void setEditorId(long editorId) {
        beforePropertyWrite("editorId", this.editorId, editorId);
        this.editorId = editorId;
    }

    public long getEditorId() {
        beforePropertyRead("editorId");
        if(this.editorId == null) {
            return 0;
        }
        return this.editorId;
    }

    public void setNotes(String notes) {
        beforePropertyWrite("notes", this.notes, notes);
        this.notes = notes;
    }

    public String getNotes() {
        beforePropertyRead("notes");
        return this.notes;
    }

    public void setObjectIdentifier(Integer objectIdentifier) {
        beforePropertyWrite("objectIdentifier", this.objectIdentifier, objectIdentifier);
        this.objectIdentifier = objectIdentifier;
    }

    public Integer getObjectIdentifier() {
        beforePropertyRead("objectIdentifier");
        return this.objectIdentifier;
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "reviewObjectTypeId":
                return this.reviewObjectTypeId;
            case "contextId":
                return this.contextId;
            case "available":
                return this.available;
            case "dateCreated":
                return this.dateCreated;
            case "editorId":
                return this.editorId;
            case "notes":
                return this.notes;
            case "objectIdentifier":
                return this.objectIdentifier;
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
            case "reviewObjectTypeId":
                this.reviewObjectTypeId = val == null ? 0 : (long)val;
                break;
            case "contextId":
                this.contextId = val == null ? 0 : (long)val;
                break;
            case "available":
                this.available = val == null ? 0 : (short)val;
                break;
            case "dateCreated":
                this.dateCreated = (LocalDateTime)val;
                break;
            case "editorId":
                this.editorId = (Long)val;
                break;
            case "notes":
                this.notes = (String)val;
                break;
            case "objectIdentifier":
                this.objectIdentifier = (Integer)val;
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
        out.writeLong(this.reviewObjectTypeId);
        out.writeLong(this.contextId);
        out.writeShort(this.available);
        out.writeObject(this.dateCreated);
        out.writeObject(this.editorId);
        out.writeObject(this.notes);
        out.writeObject(this.objectIdentifier);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.reviewObjectTypeId = in.readLong();
        this.contextId = in.readLong();
        this.available = in.readShort();
        this.dateCreated = (LocalDateTime)in.readObject();
        this.editorId = (Long)in.readObject();
        this.notes = (String)in.readObject();
        this.objectIdentifier = (Integer)in.readObject();
    }

}
