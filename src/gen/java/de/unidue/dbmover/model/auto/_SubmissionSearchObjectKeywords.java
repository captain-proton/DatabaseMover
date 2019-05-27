package de.unidue.dbmover.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _SubmissionSearchObjectKeywords was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _SubmissionSearchObjectKeywords extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String OBJECT_ID_PK_COLUMN = "object_id";
    public static final String POS_PK_COLUMN = "pos";

    public static final Property<Long> KEYWORD_ID = Property.create("keywordId", Long.class);
    public static final Property<Integer> POS = Property.create("pos", Integer.class);
    public static final Property<Long> ID = Property.create("id", Long.class);

    protected long keywordId;
    protected int pos;
    protected long id;


    public void setKeywordId(long keywordId) {
        beforePropertyWrite("keywordId", this.keywordId, keywordId);
        this.keywordId = keywordId;
    }

    public long getKeywordId() {
        beforePropertyRead("keywordId");
        return this.keywordId;
    }

    public void setPos(int pos) {
        beforePropertyWrite("pos", this.pos, pos);
        this.pos = pos;
    }

    public int getPos() {
        beforePropertyRead("pos");
        return this.pos;
    }

    public void setId(long id) {
        beforePropertyWrite("id", this.id, id);
        this.id = id;
    }

    public long getId() {
        beforePropertyRead("id");
        return this.id;
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "keywordId":
                return this.keywordId;
            case "pos":
                return this.pos;
            case "id":
                return this.id;
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
            case "keywordId":
                this.keywordId = val == null ? 0 : (long)val;
                break;
            case "pos":
                this.pos = val == null ? 0 : (int)val;
                break;
            case "id":
                this.id = val == null ? 0 : (long)val;
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
        out.writeLong(this.keywordId);
        out.writeInt(this.pos);
        out.writeLong(this.id);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.keywordId = in.readLong();
        this.pos = in.readInt();
        this.id = in.readLong();
    }

}