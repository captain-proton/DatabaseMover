package de.unidue.dbmover.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _UserInterests was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _UserInterests extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String CONTROLLED_VOCAB_ENTRY_ID_PK_COLUMN = "controlled_vocab_entry_id";
    public static final String USER_ID_PK_COLUMN = "user_id";

    public static final Property<Long> USER_ID = Property.create("userId", Long.class);
    public static final Property<Long> CONTROLLED_VOCAB_ENTRY_ID = Property.create("controlledVocabEntryId", Long.class);

    protected long userId;
    protected long controlledVocabEntryId;


    public void setUserId(long userId) {
        beforePropertyWrite("userId", this.userId, userId);
        this.userId = userId;
    }

    public long getUserId() {
        beforePropertyRead("userId");
        return this.userId;
    }

    public void setControlledVocabEntryId(long controlledVocabEntryId) {
        beforePropertyWrite("controlledVocabEntryId", this.controlledVocabEntryId, controlledVocabEntryId);
        this.controlledVocabEntryId = controlledVocabEntryId;
    }

    public long getControlledVocabEntryId() {
        beforePropertyRead("controlledVocabEntryId");
        return this.controlledVocabEntryId;
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "userId":
                return this.userId;
            case "controlledVocabEntryId":
                return this.controlledVocabEntryId;
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
            case "userId":
                this.userId = val == null ? 0 : (long)val;
                break;
            case "controlledVocabEntryId":
                this.controlledVocabEntryId = val == null ? 0 : (long)val;
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
        out.writeLong(this.userId);
        out.writeLong(this.controlledVocabEntryId);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.userId = in.readLong();
        this.controlledVocabEntryId = in.readLong();
    }

}
