package de.unidue.dbmover.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _ReviewAssignments was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _ReviewAssignments extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String REVIEW_ID_PK_COLUMN = "review_id";

    public static final Property<Long> SUBMISSION_ID = Property.create("submissionId", Long.class);
    public static final Property<Long> REVIEWER_ID = Property.create("reviewerId", Long.class);
    public static final Property<String> COMPETING_INTERESTS = Property.create("competingInterests", String.class);
    public static final Property<Short> RECOMMENDATION = Property.create("recommendation", Short.class);
    public static final Property<LocalDateTime> DATE_ASSIGNED = Property.create("dateAssigned", LocalDateTime.class);
    public static final Property<LocalDateTime> DATE_NOTIFIED = Property.create("dateNotified", LocalDateTime.class);
    public static final Property<LocalDateTime> DATE_CONFIRMED = Property.create("dateConfirmed", LocalDateTime.class);
    public static final Property<LocalDateTime> DATE_COMPLETED = Property.create("dateCompleted", LocalDateTime.class);
    public static final Property<LocalDateTime> DATE_ACKNOWLEDGED = Property.create("dateAcknowledged", LocalDateTime.class);
    public static final Property<LocalDateTime> DATE_DUE = Property.create("dateDue", LocalDateTime.class);
    public static final Property<LocalDateTime> DATE_RESPONSE_DUE = Property.create("dateResponseDue", LocalDateTime.class);
    public static final Property<LocalDateTime> LAST_MODIFIED = Property.create("lastModified", LocalDateTime.class);
    public static final Property<Short> REMINDER_WAS_AUTOMATIC = Property.create("reminderWasAutomatic", Short.class);
    public static final Property<Short> DECLINED = Property.create("declined", Short.class);
    public static final Property<Short> REPLACED = Property.create("replaced", Short.class);
    public static final Property<Long> REVIEWER_FILE_ID = Property.create("reviewerFileId", Long.class);
    public static final Property<LocalDateTime> DATE_RATED = Property.create("dateRated", LocalDateTime.class);
    public static final Property<LocalDateTime> DATE_REMINDED = Property.create("dateReminded", LocalDateTime.class);
    public static final Property<Short> QUALITY = Property.create("quality", Short.class);
    public static final Property<Long> REVIEW_ROUND_ID = Property.create("reviewRoundId", Long.class);
    public static final Property<Short> STAGE_ID = Property.create("stageId", Short.class);
    public static final Property<Short> REVIEW_METHOD = Property.create("reviewMethod", Short.class);
    public static final Property<Short> ROUND = Property.create("round", Short.class);
    public static final Property<Short> STEP = Property.create("step", Short.class);
    public static final Property<Long> REVIEW_FORM_ID = Property.create("reviewFormId", Long.class);
    public static final Property<Short> UNCONSIDERED = Property.create("unconsidered", Short.class);

    protected long submissionId;
    protected long reviewerId;
    protected String competingInterests;
    protected Short recommendation;
    protected LocalDateTime dateAssigned;
    protected LocalDateTime dateNotified;
    protected LocalDateTime dateConfirmed;
    protected LocalDateTime dateCompleted;
    protected LocalDateTime dateAcknowledged;
    protected LocalDateTime dateDue;
    protected LocalDateTime dateResponseDue;
    protected LocalDateTime lastModified;
    protected short reminderWasAutomatic;
    protected short declined;
    protected short replaced;
    protected Long reviewerFileId;
    protected LocalDateTime dateRated;
    protected LocalDateTime dateReminded;
    protected Short quality;
    protected Long reviewRoundId;
    protected short stageId;
    protected short reviewMethod;
    protected short round;
    protected short step;
    protected Long reviewFormId;
    protected Short unconsidered;


    public void setSubmissionId(long submissionId) {
        beforePropertyWrite("submissionId", this.submissionId, submissionId);
        this.submissionId = submissionId;
    }

    public long getSubmissionId() {
        beforePropertyRead("submissionId");
        return this.submissionId;
    }

    public void setReviewerId(long reviewerId) {
        beforePropertyWrite("reviewerId", this.reviewerId, reviewerId);
        this.reviewerId = reviewerId;
    }

    public long getReviewerId() {
        beforePropertyRead("reviewerId");
        return this.reviewerId;
    }

    public void setCompetingInterests(String competingInterests) {
        beforePropertyWrite("competingInterests", this.competingInterests, competingInterests);
        this.competingInterests = competingInterests;
    }

    public String getCompetingInterests() {
        beforePropertyRead("competingInterests");
        return this.competingInterests;
    }

    public void setRecommendation(short recommendation) {
        beforePropertyWrite("recommendation", this.recommendation, recommendation);
        this.recommendation = recommendation;
    }

    public short getRecommendation() {
        beforePropertyRead("recommendation");
        if(this.recommendation == null) {
            return 0;
        }
        return this.recommendation;
    }

    public void setDateAssigned(LocalDateTime dateAssigned) {
        beforePropertyWrite("dateAssigned", this.dateAssigned, dateAssigned);
        this.dateAssigned = dateAssigned;
    }

    public LocalDateTime getDateAssigned() {
        beforePropertyRead("dateAssigned");
        return this.dateAssigned;
    }

    public void setDateNotified(LocalDateTime dateNotified) {
        beforePropertyWrite("dateNotified", this.dateNotified, dateNotified);
        this.dateNotified = dateNotified;
    }

    public LocalDateTime getDateNotified() {
        beforePropertyRead("dateNotified");
        return this.dateNotified;
    }

    public void setDateConfirmed(LocalDateTime dateConfirmed) {
        beforePropertyWrite("dateConfirmed", this.dateConfirmed, dateConfirmed);
        this.dateConfirmed = dateConfirmed;
    }

    public LocalDateTime getDateConfirmed() {
        beforePropertyRead("dateConfirmed");
        return this.dateConfirmed;
    }

    public void setDateCompleted(LocalDateTime dateCompleted) {
        beforePropertyWrite("dateCompleted", this.dateCompleted, dateCompleted);
        this.dateCompleted = dateCompleted;
    }

    public LocalDateTime getDateCompleted() {
        beforePropertyRead("dateCompleted");
        return this.dateCompleted;
    }

    public void setDateAcknowledged(LocalDateTime dateAcknowledged) {
        beforePropertyWrite("dateAcknowledged", this.dateAcknowledged, dateAcknowledged);
        this.dateAcknowledged = dateAcknowledged;
    }

    public LocalDateTime getDateAcknowledged() {
        beforePropertyRead("dateAcknowledged");
        return this.dateAcknowledged;
    }

    public void setDateDue(LocalDateTime dateDue) {
        beforePropertyWrite("dateDue", this.dateDue, dateDue);
        this.dateDue = dateDue;
    }

    public LocalDateTime getDateDue() {
        beforePropertyRead("dateDue");
        return this.dateDue;
    }

    public void setDateResponseDue(LocalDateTime dateResponseDue) {
        beforePropertyWrite("dateResponseDue", this.dateResponseDue, dateResponseDue);
        this.dateResponseDue = dateResponseDue;
    }

    public LocalDateTime getDateResponseDue() {
        beforePropertyRead("dateResponseDue");
        return this.dateResponseDue;
    }

    public void setLastModified(LocalDateTime lastModified) {
        beforePropertyWrite("lastModified", this.lastModified, lastModified);
        this.lastModified = lastModified;
    }

    public LocalDateTime getLastModified() {
        beforePropertyRead("lastModified");
        return this.lastModified;
    }

    public void setReminderWasAutomatic(short reminderWasAutomatic) {
        beforePropertyWrite("reminderWasAutomatic", this.reminderWasAutomatic, reminderWasAutomatic);
        this.reminderWasAutomatic = reminderWasAutomatic;
    }

    public short getReminderWasAutomatic() {
        beforePropertyRead("reminderWasAutomatic");
        return this.reminderWasAutomatic;
    }

    public void setDeclined(short declined) {
        beforePropertyWrite("declined", this.declined, declined);
        this.declined = declined;
    }

    public short getDeclined() {
        beforePropertyRead("declined");
        return this.declined;
    }

    public void setReplaced(short replaced) {
        beforePropertyWrite("replaced", this.replaced, replaced);
        this.replaced = replaced;
    }

    public short getReplaced() {
        beforePropertyRead("replaced");
        return this.replaced;
    }

    public void setReviewerFileId(long reviewerFileId) {
        beforePropertyWrite("reviewerFileId", this.reviewerFileId, reviewerFileId);
        this.reviewerFileId = reviewerFileId;
    }

    public long getReviewerFileId() {
        beforePropertyRead("reviewerFileId");
        if(this.reviewerFileId == null) {
            return 0;
        }
        return this.reviewerFileId;
    }

    public void setDateRated(LocalDateTime dateRated) {
        beforePropertyWrite("dateRated", this.dateRated, dateRated);
        this.dateRated = dateRated;
    }

    public LocalDateTime getDateRated() {
        beforePropertyRead("dateRated");
        return this.dateRated;
    }

    public void setDateReminded(LocalDateTime dateReminded) {
        beforePropertyWrite("dateReminded", this.dateReminded, dateReminded);
        this.dateReminded = dateReminded;
    }

    public LocalDateTime getDateReminded() {
        beforePropertyRead("dateReminded");
        return this.dateReminded;
    }

    public void setQuality(short quality) {
        beforePropertyWrite("quality", this.quality, quality);
        this.quality = quality;
    }

    public short getQuality() {
        beforePropertyRead("quality");
        if(this.quality == null) {
            return 0;
        }
        return this.quality;
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

    public void setStageId(short stageId) {
        beforePropertyWrite("stageId", this.stageId, stageId);
        this.stageId = stageId;
    }

    public short getStageId() {
        beforePropertyRead("stageId");
        return this.stageId;
    }

    public void setReviewMethod(short reviewMethod) {
        beforePropertyWrite("reviewMethod", this.reviewMethod, reviewMethod);
        this.reviewMethod = reviewMethod;
    }

    public short getReviewMethod() {
        beforePropertyRead("reviewMethod");
        return this.reviewMethod;
    }

    public void setRound(short round) {
        beforePropertyWrite("round", this.round, round);
        this.round = round;
    }

    public short getRound() {
        beforePropertyRead("round");
        return this.round;
    }

    public void setStep(short step) {
        beforePropertyWrite("step", this.step, step);
        this.step = step;
    }

    public short getStep() {
        beforePropertyRead("step");
        return this.step;
    }

    public void setReviewFormId(long reviewFormId) {
        beforePropertyWrite("reviewFormId", this.reviewFormId, reviewFormId);
        this.reviewFormId = reviewFormId;
    }

    public long getReviewFormId() {
        beforePropertyRead("reviewFormId");
        if(this.reviewFormId == null) {
            return 0;
        }
        return this.reviewFormId;
    }

    public void setUnconsidered(short unconsidered) {
        beforePropertyWrite("unconsidered", this.unconsidered, unconsidered);
        this.unconsidered = unconsidered;
    }

    public short getUnconsidered() {
        beforePropertyRead("unconsidered");
        if(this.unconsidered == null) {
            return 0;
        }
        return this.unconsidered;
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "submissionId":
                return this.submissionId;
            case "reviewerId":
                return this.reviewerId;
            case "competingInterests":
                return this.competingInterests;
            case "recommendation":
                return this.recommendation;
            case "dateAssigned":
                return this.dateAssigned;
            case "dateNotified":
                return this.dateNotified;
            case "dateConfirmed":
                return this.dateConfirmed;
            case "dateCompleted":
                return this.dateCompleted;
            case "dateAcknowledged":
                return this.dateAcknowledged;
            case "dateDue":
                return this.dateDue;
            case "dateResponseDue":
                return this.dateResponseDue;
            case "lastModified":
                return this.lastModified;
            case "reminderWasAutomatic":
                return this.reminderWasAutomatic;
            case "declined":
                return this.declined;
            case "replaced":
                return this.replaced;
            case "reviewerFileId":
                return this.reviewerFileId;
            case "dateRated":
                return this.dateRated;
            case "dateReminded":
                return this.dateReminded;
            case "quality":
                return this.quality;
            case "reviewRoundId":
                return this.reviewRoundId;
            case "stageId":
                return this.stageId;
            case "reviewMethod":
                return this.reviewMethod;
            case "round":
                return this.round;
            case "step":
                return this.step;
            case "reviewFormId":
                return this.reviewFormId;
            case "unconsidered":
                return this.unconsidered;
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
            case "reviewerId":
                this.reviewerId = val == null ? 0 : (long)val;
                break;
            case "competingInterests":
                this.competingInterests = (String)val;
                break;
            case "recommendation":
                this.recommendation = (Short)val;
                break;
            case "dateAssigned":
                this.dateAssigned = (LocalDateTime)val;
                break;
            case "dateNotified":
                this.dateNotified = (LocalDateTime)val;
                break;
            case "dateConfirmed":
                this.dateConfirmed = (LocalDateTime)val;
                break;
            case "dateCompleted":
                this.dateCompleted = (LocalDateTime)val;
                break;
            case "dateAcknowledged":
                this.dateAcknowledged = (LocalDateTime)val;
                break;
            case "dateDue":
                this.dateDue = (LocalDateTime)val;
                break;
            case "dateResponseDue":
                this.dateResponseDue = (LocalDateTime)val;
                break;
            case "lastModified":
                this.lastModified = (LocalDateTime)val;
                break;
            case "reminderWasAutomatic":
                this.reminderWasAutomatic = val == null ? 0 : (short)val;
                break;
            case "declined":
                this.declined = val == null ? 0 : (short)val;
                break;
            case "replaced":
                this.replaced = val == null ? 0 : (short)val;
                break;
            case "reviewerFileId":
                this.reviewerFileId = (Long)val;
                break;
            case "dateRated":
                this.dateRated = (LocalDateTime)val;
                break;
            case "dateReminded":
                this.dateReminded = (LocalDateTime)val;
                break;
            case "quality":
                this.quality = (Short)val;
                break;
            case "reviewRoundId":
                this.reviewRoundId = (Long)val;
                break;
            case "stageId":
                this.stageId = val == null ? 0 : (short)val;
                break;
            case "reviewMethod":
                this.reviewMethod = val == null ? 0 : (short)val;
                break;
            case "round":
                this.round = val == null ? 0 : (short)val;
                break;
            case "step":
                this.step = val == null ? 0 : (short)val;
                break;
            case "reviewFormId":
                this.reviewFormId = (Long)val;
                break;
            case "unconsidered":
                this.unconsidered = (Short)val;
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
        out.writeLong(this.reviewerId);
        out.writeObject(this.competingInterests);
        out.writeObject(this.recommendation);
        out.writeObject(this.dateAssigned);
        out.writeObject(this.dateNotified);
        out.writeObject(this.dateConfirmed);
        out.writeObject(this.dateCompleted);
        out.writeObject(this.dateAcknowledged);
        out.writeObject(this.dateDue);
        out.writeObject(this.dateResponseDue);
        out.writeObject(this.lastModified);
        out.writeShort(this.reminderWasAutomatic);
        out.writeShort(this.declined);
        out.writeShort(this.replaced);
        out.writeObject(this.reviewerFileId);
        out.writeObject(this.dateRated);
        out.writeObject(this.dateReminded);
        out.writeObject(this.quality);
        out.writeObject(this.reviewRoundId);
        out.writeShort(this.stageId);
        out.writeShort(this.reviewMethod);
        out.writeShort(this.round);
        out.writeShort(this.step);
        out.writeObject(this.reviewFormId);
        out.writeObject(this.unconsidered);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.submissionId = in.readLong();
        this.reviewerId = in.readLong();
        this.competingInterests = (String)in.readObject();
        this.recommendation = (Short)in.readObject();
        this.dateAssigned = (LocalDateTime)in.readObject();
        this.dateNotified = (LocalDateTime)in.readObject();
        this.dateConfirmed = (LocalDateTime)in.readObject();
        this.dateCompleted = (LocalDateTime)in.readObject();
        this.dateAcknowledged = (LocalDateTime)in.readObject();
        this.dateDue = (LocalDateTime)in.readObject();
        this.dateResponseDue = (LocalDateTime)in.readObject();
        this.lastModified = (LocalDateTime)in.readObject();
        this.reminderWasAutomatic = in.readShort();
        this.declined = in.readShort();
        this.replaced = in.readShort();
        this.reviewerFileId = (Long)in.readObject();
        this.dateRated = (LocalDateTime)in.readObject();
        this.dateReminded = (LocalDateTime)in.readObject();
        this.quality = (Short)in.readObject();
        this.reviewRoundId = (Long)in.readObject();
        this.stageId = in.readShort();
        this.reviewMethod = in.readShort();
        this.round = in.readShort();
        this.step = in.readShort();
        this.reviewFormId = (Long)in.readObject();
        this.unconsidered = (Short)in.readObject();
    }

}
