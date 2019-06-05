package de.unidue.dbmover.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _GroupSettings was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _GroupSettings extends BaseDataObject {

    private static final long serialVersionUID = 1L; 


    public static final Property<Long> GROUP_ID = Property.create("groupId", Long.class);
    public static final Property<String> LOCALE = Property.create("locale", String.class);
    public static final Property<String> SETTING_NAME = Property.create("settingName", String.class);
    public static final Property<String> SETTING_VALUE = Property.create("settingValue", String.class);
    public static final Property<String> SETTING_TYPE = Property.create("settingType", String.class);

    protected long groupId;
    protected String locale;
    protected String settingName;
    protected String settingValue;
    protected String settingType;


    public void setGroupId(long groupId) {
        beforePropertyWrite("groupId", this.groupId, groupId);
        this.groupId = groupId;
    }

    public long getGroupId() {
        beforePropertyRead("groupId");
        return this.groupId;
    }

    public void setLocale(String locale) {
        beforePropertyWrite("locale", this.locale, locale);
        this.locale = locale;
    }

    public String getLocale() {
        beforePropertyRead("locale");
        return this.locale;
    }

    public void setSettingName(String settingName) {
        beforePropertyWrite("settingName", this.settingName, settingName);
        this.settingName = settingName;
    }

    public String getSettingName() {
        beforePropertyRead("settingName");
        return this.settingName;
    }

    public void setSettingValue(String settingValue) {
        beforePropertyWrite("settingValue", this.settingValue, settingValue);
        this.settingValue = settingValue;
    }

    public String getSettingValue() {
        beforePropertyRead("settingValue");
        return this.settingValue;
    }

    public void setSettingType(String settingType) {
        beforePropertyWrite("settingType", this.settingType, settingType);
        this.settingType = settingType;
    }

    public String getSettingType() {
        beforePropertyRead("settingType");
        return this.settingType;
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "groupId":
                return this.groupId;
            case "locale":
                return this.locale;
            case "settingName":
                return this.settingName;
            case "settingValue":
                return this.settingValue;
            case "settingType":
                return this.settingType;
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
            case "groupId":
                this.groupId = val == null ? 0 : (long)val;
                break;
            case "locale":
                this.locale = (String)val;
                break;
            case "settingName":
                this.settingName = (String)val;
                break;
            case "settingValue":
                this.settingValue = (String)val;
                break;
            case "settingType":
                this.settingType = (String)val;
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
        out.writeLong(this.groupId);
        out.writeObject(this.locale);
        out.writeObject(this.settingName);
        out.writeObject(this.settingValue);
        out.writeObject(this.settingType);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.groupId = in.readLong();
        this.locale = (String)in.readObject();
        this.settingName = (String)in.readObject();
        this.settingValue = (String)in.readObject();
        this.settingType = (String)in.readObject();
    }

}
