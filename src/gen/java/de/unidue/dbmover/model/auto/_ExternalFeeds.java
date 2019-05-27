package de.unidue.dbmover.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _ExternalFeeds was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _ExternalFeeds extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String FEED_ID_PK_COLUMN = "feed_id";

    public static final Property<Long> JOURNAL_ID = Property.create("journalId", Long.class);
    public static final Property<String> URL = Property.create("url", String.class);
    public static final Property<Double> SEQ = Property.create("seq", Double.class);
    public static final Property<Short> DISPLAY_HOMEPAGE = Property.create("displayHomepage", Short.class);
    public static final Property<Short> DISPLAY_BLOCK = Property.create("displayBlock", Short.class);
    public static final Property<Short> LIMIT_ITEMS = Property.create("limitItems", Short.class);
    public static final Property<Short> RECENT_ITEMS = Property.create("recentItems", Short.class);

    protected long journalId;
    protected String url;
    protected double seq;
    protected short displayHomepage;
    protected short displayBlock;
    protected Short limitItems;
    protected Short recentItems;


    public void setJournalId(long journalId) {
        beforePropertyWrite("journalId", this.journalId, journalId);
        this.journalId = journalId;
    }

    public long getJournalId() {
        beforePropertyRead("journalId");
        return this.journalId;
    }

    public void setUrl(String url) {
        beforePropertyWrite("url", this.url, url);
        this.url = url;
    }

    public String getUrl() {
        beforePropertyRead("url");
        return this.url;
    }

    public void setSeq(double seq) {
        beforePropertyWrite("seq", this.seq, seq);
        this.seq = seq;
    }

    public double getSeq() {
        beforePropertyRead("seq");
        return this.seq;
    }

    public void setDisplayHomepage(short displayHomepage) {
        beforePropertyWrite("displayHomepage", this.displayHomepage, displayHomepage);
        this.displayHomepage = displayHomepage;
    }

    public short getDisplayHomepage() {
        beforePropertyRead("displayHomepage");
        return this.displayHomepage;
    }

    public void setDisplayBlock(short displayBlock) {
        beforePropertyWrite("displayBlock", this.displayBlock, displayBlock);
        this.displayBlock = displayBlock;
    }

    public short getDisplayBlock() {
        beforePropertyRead("displayBlock");
        return this.displayBlock;
    }

    public void setLimitItems(short limitItems) {
        beforePropertyWrite("limitItems", this.limitItems, limitItems);
        this.limitItems = limitItems;
    }

    public short getLimitItems() {
        beforePropertyRead("limitItems");
        if(this.limitItems == null) {
            return 0;
        }
        return this.limitItems;
    }

    public void setRecentItems(short recentItems) {
        beforePropertyWrite("recentItems", this.recentItems, recentItems);
        this.recentItems = recentItems;
    }

    public short getRecentItems() {
        beforePropertyRead("recentItems");
        if(this.recentItems == null) {
            return 0;
        }
        return this.recentItems;
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "journalId":
                return this.journalId;
            case "url":
                return this.url;
            case "seq":
                return this.seq;
            case "displayHomepage":
                return this.displayHomepage;
            case "displayBlock":
                return this.displayBlock;
            case "limitItems":
                return this.limitItems;
            case "recentItems":
                return this.recentItems;
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
            case "url":
                this.url = (String)val;
                break;
            case "seq":
                this.seq = val == null ? 0 : (double)val;
                break;
            case "displayHomepage":
                this.displayHomepage = val == null ? 0 : (short)val;
                break;
            case "displayBlock":
                this.displayBlock = val == null ? 0 : (short)val;
                break;
            case "limitItems":
                this.limitItems = (Short)val;
                break;
            case "recentItems":
                this.recentItems = (Short)val;
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
        out.writeObject(this.url);
        out.writeDouble(this.seq);
        out.writeShort(this.displayHomepage);
        out.writeShort(this.displayBlock);
        out.writeObject(this.limitItems);
        out.writeObject(this.recentItems);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.journalId = in.readLong();
        this.url = (String)in.readObject();
        this.seq = in.readDouble();
        this.displayHomepage = in.readShort();
        this.displayBlock = in.readShort();
        this.limitItems = (Short)in.readObject();
        this.recentItems = (Short)in.readObject();
    }

}