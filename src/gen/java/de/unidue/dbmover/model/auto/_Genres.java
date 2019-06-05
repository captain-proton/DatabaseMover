package de.unidue.dbmover.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _Genres was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Genres extends BaseDataObject {

    private static final long serialVersionUID = 1L; 


    public static final Property<Long> CONTEXT_ID = Property.create("contextId", Long.class);
    public static final Property<Long> SEQ = Property.create("seq", Long.class);
    public static final Property<Short> SORTABLE = Property.create("sortable", Short.class);
    public static final Property<Short> ENABLED = Property.create("enabled", Short.class);
    public static final Property<Long> CATEGORY = Property.create("category", Long.class);
    public static final Property<Short> DEPENDENT = Property.create("dependent", Short.class);
    public static final Property<Short> SUPPLEMENTARY = Property.create("supplementary", Short.class);
    public static final Property<String> ENTRY_KEY = Property.create("entryKey", String.class);
    public static final Property<Integer> GENRE_ID = Property.create("genreId", Integer.class);

    protected long contextId;
    protected Long seq;
    protected short sortable;
    protected short enabled;
    protected long category;
    protected short dependent;
    protected Short supplementary;
    protected String entryKey;
    protected Integer genreId;


    public void setContextId(long contextId) {
        beforePropertyWrite("contextId", this.contextId, contextId);
        this.contextId = contextId;
    }

    public long getContextId() {
        beforePropertyRead("contextId");
        return this.contextId;
    }

    public void setSeq(long seq) {
        beforePropertyWrite("seq", this.seq, seq);
        this.seq = seq;
    }

    public long getSeq() {
        beforePropertyRead("seq");
        if(this.seq == null) {
            return 0;
        }
        return this.seq;
    }

    public void setSortable(short sortable) {
        beforePropertyWrite("sortable", this.sortable, sortable);
        this.sortable = sortable;
    }

    public short getSortable() {
        beforePropertyRead("sortable");
        return this.sortable;
    }

    public void setEnabled(short enabled) {
        beforePropertyWrite("enabled", this.enabled, enabled);
        this.enabled = enabled;
    }

    public short getEnabled() {
        beforePropertyRead("enabled");
        return this.enabled;
    }

    public void setCategory(long category) {
        beforePropertyWrite("category", this.category, category);
        this.category = category;
    }

    public long getCategory() {
        beforePropertyRead("category");
        return this.category;
    }

    public void setDependent(short dependent) {
        beforePropertyWrite("dependent", this.dependent, dependent);
        this.dependent = dependent;
    }

    public short getDependent() {
        beforePropertyRead("dependent");
        return this.dependent;
    }

    public void setSupplementary(short supplementary) {
        beforePropertyWrite("supplementary", this.supplementary, supplementary);
        this.supplementary = supplementary;
    }

    public short getSupplementary() {
        beforePropertyRead("supplementary");
        if(this.supplementary == null) {
            return 0;
        }
        return this.supplementary;
    }

    public void setEntryKey(String entryKey) {
        beforePropertyWrite("entryKey", this.entryKey, entryKey);
        this.entryKey = entryKey;
    }

    public String getEntryKey() {
        beforePropertyRead("entryKey");
        return this.entryKey;
    }

    public void setGenreId(Integer genreId) {
        beforePropertyWrite("genreId", this.genreId, genreId);
        this.genreId = genreId;
    }

    public Integer getGenreId() {
        beforePropertyRead("genreId");
        return this.genreId;
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "contextId":
                return this.contextId;
            case "seq":
                return this.seq;
            case "sortable":
                return this.sortable;
            case "enabled":
                return this.enabled;
            case "category":
                return this.category;
            case "dependent":
                return this.dependent;
            case "supplementary":
                return this.supplementary;
            case "entryKey":
                return this.entryKey;
            case "genreId":
                return this.genreId;
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
            case "seq":
                this.seq = (Long)val;
                break;
            case "sortable":
                this.sortable = val == null ? 0 : (short)val;
                break;
            case "enabled":
                this.enabled = val == null ? 0 : (short)val;
                break;
            case "category":
                this.category = val == null ? 0 : (long)val;
                break;
            case "dependent":
                this.dependent = val == null ? 0 : (short)val;
                break;
            case "supplementary":
                this.supplementary = (Short)val;
                break;
            case "entryKey":
                this.entryKey = (String)val;
                break;
            case "genreId":
                this.genreId = (Integer)val;
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
        out.writeObject(this.seq);
        out.writeShort(this.sortable);
        out.writeShort(this.enabled);
        out.writeLong(this.category);
        out.writeShort(this.dependent);
        out.writeObject(this.supplementary);
        out.writeObject(this.entryKey);
        out.writeObject(this.genreId);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.contextId = in.readLong();
        this.seq = (Long)in.readObject();
        this.sortable = in.readShort();
        this.enabled = in.readShort();
        this.category = in.readLong();
        this.dependent = in.readShort();
        this.supplementary = (Short)in.readObject();
        this.entryKey = (String)in.readObject();
        this.genreId = (Integer)in.readObject();
    }

}
