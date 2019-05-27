package de.unidue.dbmover.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _Filters was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Filters extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String FILTER_ID_PK_COLUMN = "filter_id";

    public static final Property<Long> FILTER_GROUP_ID = Property.create("filterGroupId", Long.class);
    public static final Property<Long> CONTEXT_ID = Property.create("contextId", Long.class);
    public static final Property<String> DISPLAY_NAME = Property.create("displayName", String.class);
    public static final Property<String> CLASS_NAME = Property.create("className", String.class);
    public static final Property<Short> IS_TEMPLATE = Property.create("isTemplate", Short.class);
    public static final Property<Long> PARENT_FILTER_ID = Property.create("parentFilterId", Long.class);
    public static final Property<Long> SEQ = Property.create("seq", Long.class);

    protected long filterGroupId;
    protected long contextId;
    protected String displayName;
    protected String className;
    protected short isTemplate;
    protected long parentFilterId;
    protected long seq;


    public void setFilterGroupId(long filterGroupId) {
        beforePropertyWrite("filterGroupId", this.filterGroupId, filterGroupId);
        this.filterGroupId = filterGroupId;
    }

    public long getFilterGroupId() {
        beforePropertyRead("filterGroupId");
        return this.filterGroupId;
    }

    public void setContextId(long contextId) {
        beforePropertyWrite("contextId", this.contextId, contextId);
        this.contextId = contextId;
    }

    public long getContextId() {
        beforePropertyRead("contextId");
        return this.contextId;
    }

    public void setDisplayName(String displayName) {
        beforePropertyWrite("displayName", this.displayName, displayName);
        this.displayName = displayName;
    }

    public String getDisplayName() {
        beforePropertyRead("displayName");
        return this.displayName;
    }

    public void setClassName(String className) {
        beforePropertyWrite("className", this.className, className);
        this.className = className;
    }

    public String getClassName() {
        beforePropertyRead("className");
        return this.className;
    }

    public void setIsTemplate(short isTemplate) {
        beforePropertyWrite("isTemplate", this.isTemplate, isTemplate);
        this.isTemplate = isTemplate;
    }

    public short getIsTemplate() {
        beforePropertyRead("isTemplate");
        return this.isTemplate;
    }

    public void setParentFilterId(long parentFilterId) {
        beforePropertyWrite("parentFilterId", this.parentFilterId, parentFilterId);
        this.parentFilterId = parentFilterId;
    }

    public long getParentFilterId() {
        beforePropertyRead("parentFilterId");
        return this.parentFilterId;
    }

    public void setSeq(long seq) {
        beforePropertyWrite("seq", this.seq, seq);
        this.seq = seq;
    }

    public long getSeq() {
        beforePropertyRead("seq");
        return this.seq;
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "filterGroupId":
                return this.filterGroupId;
            case "contextId":
                return this.contextId;
            case "displayName":
                return this.displayName;
            case "className":
                return this.className;
            case "isTemplate":
                return this.isTemplate;
            case "parentFilterId":
                return this.parentFilterId;
            case "seq":
                return this.seq;
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
            case "filterGroupId":
                this.filterGroupId = val == null ? 0 : (long)val;
                break;
            case "contextId":
                this.contextId = val == null ? 0 : (long)val;
                break;
            case "displayName":
                this.displayName = (String)val;
                break;
            case "className":
                this.className = (String)val;
                break;
            case "isTemplate":
                this.isTemplate = val == null ? 0 : (short)val;
                break;
            case "parentFilterId":
                this.parentFilterId = val == null ? 0 : (long)val;
                break;
            case "seq":
                this.seq = val == null ? 0 : (long)val;
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
        out.writeLong(this.filterGroupId);
        out.writeLong(this.contextId);
        out.writeObject(this.displayName);
        out.writeObject(this.className);
        out.writeShort(this.isTemplate);
        out.writeLong(this.parentFilterId);
        out.writeLong(this.seq);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.filterGroupId = in.readLong();
        this.contextId = in.readLong();
        this.displayName = (String)in.readObject();
        this.className = (String)in.readObject();
        this.isTemplate = in.readShort();
        this.parentFilterId = in.readLong();
        this.seq = in.readLong();
    }

}
