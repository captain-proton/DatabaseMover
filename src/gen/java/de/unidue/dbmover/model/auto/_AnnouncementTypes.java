package de.unidue.dbmover.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AnnouncementTypes was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AnnouncementTypes extends BaseDataObject {

    private static final long serialVersionUID = 1L; 


    public static final Property<Short> ASSOC_TYPE = Property.create("assocType", Short.class);
    public static final Property<Long> ASSOC_ID = Property.create("assocId", Long.class);
    public static final Property<Long> TYPE_ID = Property.create("typeId", Long.class);

    protected Short assocType;
    protected long assocId;
    protected long typeId;


    public void setAssocType(short assocType) {
        beforePropertyWrite("assocType", this.assocType, assocType);
        this.assocType = assocType;
    }

    public short getAssocType() {
        beforePropertyRead("assocType");
        if(this.assocType == null) {
            return 0;
        }
        return this.assocType;
    }

    public void setAssocId(long assocId) {
        beforePropertyWrite("assocId", this.assocId, assocId);
        this.assocId = assocId;
    }

    public long getAssocId() {
        beforePropertyRead("assocId");
        return this.assocId;
    }

    public void setTypeId(long typeId) {
        beforePropertyWrite("typeId", this.typeId, typeId);
        this.typeId = typeId;
    }

    public long getTypeId() {
        beforePropertyRead("typeId");
        return this.typeId;
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "assocType":
                return this.assocType;
            case "assocId":
                return this.assocId;
            case "typeId":
                return this.typeId;
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
            case "assocType":
                this.assocType = (Short)val;
                break;
            case "assocId":
                this.assocId = val == null ? 0 : (long)val;
                break;
            case "typeId":
                this.typeId = val == null ? 0 : (long)val;
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
        out.writeObject(this.assocType);
        out.writeLong(this.assocId);
        out.writeLong(this.typeId);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.assocType = (Short)in.readObject();
        this.assocId = in.readLong();
        this.typeId = in.readLong();
    }

}
