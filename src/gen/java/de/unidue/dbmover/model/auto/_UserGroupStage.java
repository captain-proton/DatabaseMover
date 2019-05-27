package de.unidue.dbmover.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _UserGroupStage was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _UserGroupStage extends BaseDataObject {

    private static final long serialVersionUID = 1L; 


    public static final Property<Long> CONTEXT_ID = Property.create("contextId", Long.class);
    public static final Property<Long> USER_GROUP_ID = Property.create("userGroupId", Long.class);
    public static final Property<Long> STAGE_ID = Property.create("stageId", Long.class);

    protected long contextId;
    protected long userGroupId;
    protected long stageId;


    public void setContextId(long contextId) {
        beforePropertyWrite("contextId", this.contextId, contextId);
        this.contextId = contextId;
    }

    public long getContextId() {
        beforePropertyRead("contextId");
        return this.contextId;
    }

    public void setUserGroupId(long userGroupId) {
        beforePropertyWrite("userGroupId", this.userGroupId, userGroupId);
        this.userGroupId = userGroupId;
    }

    public long getUserGroupId() {
        beforePropertyRead("userGroupId");
        return this.userGroupId;
    }

    public void setStageId(long stageId) {
        beforePropertyWrite("stageId", this.stageId, stageId);
        this.stageId = stageId;
    }

    public long getStageId() {
        beforePropertyRead("stageId");
        return this.stageId;
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "contextId":
                return this.contextId;
            case "userGroupId":
                return this.userGroupId;
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
            case "contextId":
                this.contextId = val == null ? 0 : (long)val;
                break;
            case "userGroupId":
                this.userGroupId = val == null ? 0 : (long)val;
                break;
            case "stageId":
                this.stageId = val == null ? 0 : (long)val;
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
        out.writeLong(this.userGroupId);
        out.writeLong(this.stageId);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.contextId = in.readLong();
        this.userGroupId = in.readLong();
        this.stageId = in.readLong();
    }

}
