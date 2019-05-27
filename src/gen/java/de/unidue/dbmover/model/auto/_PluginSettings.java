package de.unidue.dbmover.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _PluginSettings was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _PluginSettings extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String CONTEXT_ID_PK_COLUMN = "context_id";
    public static final String PLUGIN_NAME_PK_COLUMN = "plugin_name";
    public static final String SETTING_NAME_PK_COLUMN = "setting_name";

    public static final Property<String> PLUGIN_NAME = Property.create("pluginName", String.class);
    public static final Property<Long> CONTEXT_ID = Property.create("contextId", Long.class);
    public static final Property<String> SETTING_NAME = Property.create("settingName", String.class);
    public static final Property<String> SETTING_VALUE = Property.create("settingValue", String.class);
    public static final Property<String> SETTING_TYPE = Property.create("settingType", String.class);

    protected String pluginName;
    protected long contextId;
    protected String settingName;
    protected String settingValue;
    protected String settingType;


    public void setPluginName(String pluginName) {
        beforePropertyWrite("pluginName", this.pluginName, pluginName);
        this.pluginName = pluginName;
    }

    public String getPluginName() {
        beforePropertyRead("pluginName");
        return this.pluginName;
    }

    public void setContextId(long contextId) {
        beforePropertyWrite("contextId", this.contextId, contextId);
        this.contextId = contextId;
    }

    public long getContextId() {
        beforePropertyRead("contextId");
        return this.contextId;
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
            case "pluginName":
                return this.pluginName;
            case "contextId":
                return this.contextId;
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
            case "pluginName":
                this.pluginName = (String)val;
                break;
            case "contextId":
                this.contextId = val == null ? 0 : (long)val;
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
        out.writeObject(this.pluginName);
        out.writeLong(this.contextId);
        out.writeObject(this.settingName);
        out.writeObject(this.settingValue);
        out.writeObject(this.settingType);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.pluginName = (String)in.readObject();
        this.contextId = in.readLong();
        this.settingName = (String)in.readObject();
        this.settingValue = (String)in.readObject();
        this.settingType = (String)in.readObject();
    }

}