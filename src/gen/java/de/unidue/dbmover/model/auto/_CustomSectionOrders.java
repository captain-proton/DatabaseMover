package de.unidue.dbmover.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _CustomSectionOrders was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _CustomSectionOrders extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ISSUE_ID_PK_COLUMN = "issue_id";
    public static final String SECTION_ID_PK_COLUMN = "section_id";

    public static final Property<Long> ISSUE_ID = Property.create("issueId", Long.class);
    public static final Property<Long> SECTION_ID = Property.create("sectionId", Long.class);
    public static final Property<Double> SEQ = Property.create("seq", Double.class);

    protected long issueId;
    protected long sectionId;
    protected double seq;


    public void setIssueId(long issueId) {
        beforePropertyWrite("issueId", this.issueId, issueId);
        this.issueId = issueId;
    }

    public long getIssueId() {
        beforePropertyRead("issueId");
        return this.issueId;
    }

    public void setSectionId(long sectionId) {
        beforePropertyWrite("sectionId", this.sectionId, sectionId);
        this.sectionId = sectionId;
    }

    public long getSectionId() {
        beforePropertyRead("sectionId");
        return this.sectionId;
    }

    public void setSeq(double seq) {
        beforePropertyWrite("seq", this.seq, seq);
        this.seq = seq;
    }

    public double getSeq() {
        beforePropertyRead("seq");
        return this.seq;
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "issueId":
                return this.issueId;
            case "sectionId":
                return this.sectionId;
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
            case "issueId":
                this.issueId = val == null ? 0 : (long)val;
                break;
            case "sectionId":
                this.sectionId = val == null ? 0 : (long)val;
                break;
            case "seq":
                this.seq = val == null ? 0 : (double)val;
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
        out.writeLong(this.issueId);
        out.writeLong(this.sectionId);
        out.writeDouble(this.seq);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.issueId = in.readLong();
        this.sectionId = in.readLong();
        this.seq = in.readDouble();
    }

}
