package de.unidue.dbmover.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _Referrals was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Referrals extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String REFERRAL_ID_PK_COLUMN = "referral_id";

    public static final Property<Long> SUBMISSION_ID = Property.create("submissionId", Long.class);
    public static final Property<Short> STATUS = Property.create("status", Short.class);
    public static final Property<String> URL = Property.create("url", String.class);
    public static final Property<LocalDateTime> DATE_ADDED = Property.create("dateAdded", LocalDateTime.class);
    public static final Property<Long> LINK_COUNT = Property.create("linkCount", Long.class);

    protected long submissionId;
    protected short status;
    protected String url;
    protected LocalDateTime dateAdded;
    protected long linkCount;


    public void setSubmissionId(long submissionId) {
        beforePropertyWrite("submissionId", this.submissionId, submissionId);
        this.submissionId = submissionId;
    }

    public long getSubmissionId() {
        beforePropertyRead("submissionId");
        return this.submissionId;
    }

    public void setStatus(short status) {
        beforePropertyWrite("status", this.status, status);
        this.status = status;
    }

    public short getStatus() {
        beforePropertyRead("status");
        return this.status;
    }

    public void setUrl(String url) {
        beforePropertyWrite("url", this.url, url);
        this.url = url;
    }

    public String getUrl() {
        beforePropertyRead("url");
        return this.url;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        beforePropertyWrite("dateAdded", this.dateAdded, dateAdded);
        this.dateAdded = dateAdded;
    }

    public LocalDateTime getDateAdded() {
        beforePropertyRead("dateAdded");
        return this.dateAdded;
    }

    public void setLinkCount(long linkCount) {
        beforePropertyWrite("linkCount", this.linkCount, linkCount);
        this.linkCount = linkCount;
    }

    public long getLinkCount() {
        beforePropertyRead("linkCount");
        return this.linkCount;
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "submissionId":
                return this.submissionId;
            case "status":
                return this.status;
            case "url":
                return this.url;
            case "dateAdded":
                return this.dateAdded;
            case "linkCount":
                return this.linkCount;
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
            case "submissionId":
                this.submissionId = val == null ? 0 : (long)val;
                break;
            case "status":
                this.status = val == null ? 0 : (short)val;
                break;
            case "url":
                this.url = (String)val;
                break;
            case "dateAdded":
                this.dateAdded = (LocalDateTime)val;
                break;
            case "linkCount":
                this.linkCount = val == null ? 0 : (long)val;
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
        out.writeLong(this.submissionId);
        out.writeShort(this.status);
        out.writeObject(this.url);
        out.writeObject(this.dateAdded);
        out.writeLong(this.linkCount);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.submissionId = in.readLong();
        this.status = in.readShort();
        this.url = (String)in.readObject();
        this.dateAdded = (LocalDateTime)in.readObject();
        this.linkCount = in.readLong();
    }

}