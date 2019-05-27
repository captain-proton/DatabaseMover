package de.unidue.dbmover.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _EditDecisions was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _EditDecisions extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String EDIT_DECISION_ID_PK_COLUMN = "edit_decision_id";

    public static final Property<Long> SUBMISSION_ID = Property.create("submissionId", Long.class);
    public static final Property<Short> ROUND = Property.create("round", Short.class);
    public static final Property<Long> EDITOR_ID = Property.create("editorId", Long.class);
    public static final Property<Short> DECISION = Property.create("decision", Short.class);
    public static final Property<LocalDateTime> DATE_DECIDED = Property.create("dateDecided", LocalDateTime.class);
    public static final Property<Long> REVIEW_ROUND_ID = Property.create("reviewRoundId", Long.class);
    public static final Property<Long> STAGE_ID = Property.create("stageId", Long.class);

    protected long submissionId;
    protected short round;
    protected long editorId;
    protected short decision;
    protected LocalDateTime dateDecided;
    protected Long reviewRoundId;
    protected Long stageId;


    public void setSubmissionId(long submissionId) {
        beforePropertyWrite("submissionId", this.submissionId, submissionId);
        this.submissionId = submissionId;
    }

    public long getSubmissionId() {
        beforePropertyRead("submissionId");
        return this.submissionId;
    }

    public void setRound(short round) {
        beforePropertyWrite("round", this.round, round);
        this.round = round;
    }

    public short getRound() {
        beforePropertyRead("round");
        return this.round;
    }

    public void setEditorId(long editorId) {
        beforePropertyWrite("editorId", this.editorId, editorId);
        this.editorId = editorId;
    }

    public long getEditorId() {
        beforePropertyRead("editorId");
        return this.editorId;
    }

    public void setDecision(short decision) {
        beforePropertyWrite("decision", this.decision, decision);
        this.decision = decision;
    }

    public short getDecision() {
        beforePropertyRead("decision");
        return this.decision;
    }

    public void setDateDecided(LocalDateTime dateDecided) {
        beforePropertyWrite("dateDecided", this.dateDecided, dateDecided);
        this.dateDecided = dateDecided;
    }

    public LocalDateTime getDateDecided() {
        beforePropertyRead("dateDecided");
        return this.dateDecided;
    }

    public void setReviewRoundId(long reviewRoundId) {
        beforePropertyWrite("reviewRoundId", this.reviewRoundId, reviewRoundId);
        this.reviewRoundId = reviewRoundId;
    }

    public long getReviewRoundId() {
        beforePropertyRead("reviewRoundId");
        if(this.reviewRoundId == null) {
            return 0;
        }
        return this.reviewRoundId;
    }

    public void setStageId(long stageId) {
        beforePropertyWrite("stageId", this.stageId, stageId);
        this.stageId = stageId;
    }

    public long getStageId() {
        beforePropertyRead("stageId");
        if(this.stageId == null) {
            return 0;
        }
        return this.stageId;
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "submissionId":
                return this.submissionId;
            case "round":
                return this.round;
            case "editorId":
                return this.editorId;
            case "decision":
                return this.decision;
            case "dateDecided":
                return this.dateDecided;
            case "reviewRoundId":
                return this.reviewRoundId;
            case "stageId":
                return this.stageId;
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
            case "round":
                this.round = val == null ? 0 : (short)val;
                break;
            case "editorId":
                this.editorId = val == null ? 0 : (long)val;
                break;
            case "decision":
                this.decision = val == null ? 0 : (short)val;
                break;
            case "dateDecided":
                this.dateDecided = (LocalDateTime)val;
                break;
            case "reviewRoundId":
                this.reviewRoundId = (Long)val;
                break;
            case "stageId":
                this.stageId = (Long)val;
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
        out.writeShort(this.round);
        out.writeLong(this.editorId);
        out.writeShort(this.decision);
        out.writeObject(this.dateDecided);
        out.writeObject(this.reviewRoundId);
        out.writeObject(this.stageId);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.submissionId = in.readLong();
        this.round = in.readShort();
        this.editorId = in.readLong();
        this.decision = in.readShort();
        this.dateDecided = (LocalDateTime)in.readObject();
        this.reviewRoundId = (Long)in.readObject();
        this.stageId = (Long)in.readObject();
    }

}
