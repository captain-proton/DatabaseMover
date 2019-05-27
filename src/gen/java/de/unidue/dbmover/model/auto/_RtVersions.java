package de.unidue.dbmover.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _RtVersions was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _RtVersions extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String VERSION_ID_PK_COLUMN = "version_id";

    public static final Property<Long> JOURNAL_ID = Property.create("journalId", Long.class);
    public static final Property<String> VERSION_KEY = Property.create("versionKey", String.class);
    public static final Property<String> LOCALE = Property.create("locale", String.class);
    public static final Property<String> TITLE = Property.create("title", String.class);
    public static final Property<String> DESCRIPTION = Property.create("description", String.class);

    protected long journalId;
    protected String versionKey;
    protected String locale;
    protected String title;
    protected String description;


    public void setJournalId(long journalId) {
        beforePropertyWrite("journalId", this.journalId, journalId);
        this.journalId = journalId;
    }

    public long getJournalId() {
        beforePropertyRead("journalId");
        return this.journalId;
    }

    public void setVersionKey(String versionKey) {
        beforePropertyWrite("versionKey", this.versionKey, versionKey);
        this.versionKey = versionKey;
    }

    public String getVersionKey() {
        beforePropertyRead("versionKey");
        return this.versionKey;
    }

    public void setLocale(String locale) {
        beforePropertyWrite("locale", this.locale, locale);
        this.locale = locale;
    }

    public String getLocale() {
        beforePropertyRead("locale");
        return this.locale;
    }

    public void setTitle(String title) {
        beforePropertyWrite("title", this.title, title);
        this.title = title;
    }

    public String getTitle() {
        beforePropertyRead("title");
        return this.title;
    }

    public void setDescription(String description) {
        beforePropertyWrite("description", this.description, description);
        this.description = description;
    }

    public String getDescription() {
        beforePropertyRead("description");
        return this.description;
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "journalId":
                return this.journalId;
            case "versionKey":
                return this.versionKey;
            case "locale":
                return this.locale;
            case "title":
                return this.title;
            case "description":
                return this.description;
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
            case "journalId":
                this.journalId = val == null ? 0 : (long)val;
                break;
            case "versionKey":
                this.versionKey = (String)val;
                break;
            case "locale":
                this.locale = (String)val;
                break;
            case "title":
                this.title = (String)val;
                break;
            case "description":
                this.description = (String)val;
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
        out.writeLong(this.journalId);
        out.writeObject(this.versionKey);
        out.writeObject(this.locale);
        out.writeObject(this.title);
        out.writeObject(this.description);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.journalId = in.readLong();
        this.versionKey = (String)in.readObject();
        this.locale = (String)in.readObject();
        this.title = (String)in.readObject();
        this.description = (String)in.readObject();
    }

}