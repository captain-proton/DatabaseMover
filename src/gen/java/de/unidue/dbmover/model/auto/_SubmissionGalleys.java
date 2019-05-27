package de.unidue.dbmover.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _SubmissionGalleys was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _SubmissionGalleys extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String GALLEY_ID_PK_COLUMN = "galley_id";

    public static final Property<String> LOCALE = Property.create("locale", String.class);
    public static final Property<Long> SUBMISSION_ID = Property.create("submissionId", Long.class);
    public static final Property<Long> FILE_ID = Property.create("fileId", Long.class);
    public static final Property<String> LABEL = Property.create("label", String.class);
    public static final Property<Double> SEQ = Property.create("seq", Double.class);
    public static final Property<String> REMOTE_URL = Property.create("remoteUrl", String.class);
    public static final Property<Short> IS_APPROVED = Property.create("isApproved", Short.class);

    protected String locale;
    protected long submissionId;
    protected Long fileId;
    protected String label;
    protected double seq;
    protected String remoteUrl;
    protected short isApproved;


    public void setLocale(String locale) {
        beforePropertyWrite("locale", this.locale, locale);
        this.locale = locale;
    }

    public String getLocale() {
        beforePropertyRead("locale");
        return this.locale;
    }

    public void setSubmissionId(long submissionId) {
        beforePropertyWrite("submissionId", this.submissionId, submissionId);
        this.submissionId = submissionId;
    }

    public long getSubmissionId() {
        beforePropertyRead("submissionId");
        return this.submissionId;
    }

    public void setFileId(long fileId) {
        beforePropertyWrite("fileId", this.fileId, fileId);
        this.fileId = fileId;
    }

    public long getFileId() {
        beforePropertyRead("fileId");
        if(this.fileId == null) {
            return 0;
        }
        return this.fileId;
    }

    public void setLabel(String label) {
        beforePropertyWrite("label", this.label, label);
        this.label = label;
    }

    public String getLabel() {
        beforePropertyRead("label");
        return this.label;
    }

    public void setSeq(double seq) {
        beforePropertyWrite("seq", this.seq, seq);
        this.seq = seq;
    }

    public double getSeq() {
        beforePropertyRead("seq");
        return this.seq;
    }

    public void setRemoteUrl(String remoteUrl) {
        beforePropertyWrite("remoteUrl", this.remoteUrl, remoteUrl);
        this.remoteUrl = remoteUrl;
    }

    public String getRemoteUrl() {
        beforePropertyRead("remoteUrl");
        return this.remoteUrl;
    }

    public void setIsApproved(short isApproved) {
        beforePropertyWrite("isApproved", this.isApproved, isApproved);
        this.isApproved = isApproved;
    }

    public short getIsApproved() {
        beforePropertyRead("isApproved");
        return this.isApproved;
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "locale":
                return this.locale;
            case "submissionId":
                return this.submissionId;
            case "fileId":
                return this.fileId;
            case "label":
                return this.label;
            case "seq":
                return this.seq;
            case "remoteUrl":
                return this.remoteUrl;
            case "isApproved":
                return this.isApproved;
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
            case "locale":
                this.locale = (String)val;
                break;
            case "submissionId":
                this.submissionId = val == null ? 0 : (long)val;
                break;
            case "fileId":
                this.fileId = (Long)val;
                break;
            case "label":
                this.label = (String)val;
                break;
            case "seq":
                this.seq = val == null ? 0 : (double)val;
                break;
            case "remoteUrl":
                this.remoteUrl = (String)val;
                break;
            case "isApproved":
                this.isApproved = val == null ? 0 : (short)val;
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
        out.writeObject(this.locale);
        out.writeLong(this.submissionId);
        out.writeObject(this.fileId);
        out.writeObject(this.label);
        out.writeDouble(this.seq);
        out.writeObject(this.remoteUrl);
        out.writeShort(this.isApproved);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.locale = (String)in.readObject();
        this.submissionId = in.readLong();
        this.fileId = (Long)in.readObject();
        this.label = (String)in.readObject();
        this.seq = in.readDouble();
        this.remoteUrl = (String)in.readObject();
        this.isApproved = in.readShort();
    }

}