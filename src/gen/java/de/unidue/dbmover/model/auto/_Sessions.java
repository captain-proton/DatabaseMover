package de.unidue.dbmover.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _Sessions was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Sessions extends BaseDataObject {

    private static final long serialVersionUID = 1L; 


    public static final Property<String> SESSION_ID = Property.create("sessionId", String.class);
    public static final Property<Long> USER_ID = Property.create("userId", Long.class);
    public static final Property<String> IP_ADDRESS = Property.create("ipAddress", String.class);
    public static final Property<String> USER_AGENT = Property.create("userAgent", String.class);
    public static final Property<Long> CREATED = Property.create("created", Long.class);
    public static final Property<Long> LAST_USED = Property.create("lastUsed", Long.class);
    public static final Property<Short> REMEMBER = Property.create("remember", Short.class);
    public static final Property<String> DATA = Property.create("data", String.class);
    public static final Property<String> DOMAIN = Property.create("domain", String.class);

    protected String sessionId;
    protected Long userId;
    protected String ipAddress;
    protected String userAgent;
    protected long created;
    protected long lastUsed;
    protected short remember;
    protected String data;
    protected String domain;


    public void setSessionId(String sessionId) {
        beforePropertyWrite("sessionId", this.sessionId, sessionId);
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        beforePropertyRead("sessionId");
        return this.sessionId;
    }

    public void setUserId(long userId) {
        beforePropertyWrite("userId", this.userId, userId);
        this.userId = userId;
    }

    public long getUserId() {
        beforePropertyRead("userId");
        if(this.userId == null) {
            return 0;
        }
        return this.userId;
    }

    public void setIpAddress(String ipAddress) {
        beforePropertyWrite("ipAddress", this.ipAddress, ipAddress);
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        beforePropertyRead("ipAddress");
        return this.ipAddress;
    }

    public void setUserAgent(String userAgent) {
        beforePropertyWrite("userAgent", this.userAgent, userAgent);
        this.userAgent = userAgent;
    }

    public String getUserAgent() {
        beforePropertyRead("userAgent");
        return this.userAgent;
    }

    public void setCreated(long created) {
        beforePropertyWrite("created", this.created, created);
        this.created = created;
    }

    public long getCreated() {
        beforePropertyRead("created");
        return this.created;
    }

    public void setLastUsed(long lastUsed) {
        beforePropertyWrite("lastUsed", this.lastUsed, lastUsed);
        this.lastUsed = lastUsed;
    }

    public long getLastUsed() {
        beforePropertyRead("lastUsed");
        return this.lastUsed;
    }

    public void setRemember(short remember) {
        beforePropertyWrite("remember", this.remember, remember);
        this.remember = remember;
    }

    public short getRemember() {
        beforePropertyRead("remember");
        return this.remember;
    }

    public void setData(String data) {
        beforePropertyWrite("data", this.data, data);
        this.data = data;
    }

    public String getData() {
        beforePropertyRead("data");
        return this.data;
    }

    public void setDomain(String domain) {
        beforePropertyWrite("domain", this.domain, domain);
        this.domain = domain;
    }

    public String getDomain() {
        beforePropertyRead("domain");
        return this.domain;
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "sessionId":
                return this.sessionId;
            case "userId":
                return this.userId;
            case "ipAddress":
                return this.ipAddress;
            case "userAgent":
                return this.userAgent;
            case "created":
                return this.created;
            case "lastUsed":
                return this.lastUsed;
            case "remember":
                return this.remember;
            case "data":
                return this.data;
            case "domain":
                return this.domain;
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
            case "sessionId":
                this.sessionId = (String)val;
                break;
            case "userId":
                this.userId = (Long)val;
                break;
            case "ipAddress":
                this.ipAddress = (String)val;
                break;
            case "userAgent":
                this.userAgent = (String)val;
                break;
            case "created":
                this.created = val == null ? 0 : (long)val;
                break;
            case "lastUsed":
                this.lastUsed = val == null ? 0 : (long)val;
                break;
            case "remember":
                this.remember = val == null ? 0 : (short)val;
                break;
            case "data":
                this.data = (String)val;
                break;
            case "domain":
                this.domain = (String)val;
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
        out.writeObject(this.sessionId);
        out.writeObject(this.userId);
        out.writeObject(this.ipAddress);
        out.writeObject(this.userAgent);
        out.writeLong(this.created);
        out.writeLong(this.lastUsed);
        out.writeShort(this.remember);
        out.writeObject(this.data);
        out.writeObject(this.domain);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.sessionId = (String)in.readObject();
        this.userId = (Long)in.readObject();
        this.ipAddress = (String)in.readObject();
        this.userAgent = (String)in.readObject();
        this.created = in.readLong();
        this.lastUsed = in.readLong();
        this.remember = in.readShort();
        this.data = (String)in.readObject();
        this.domain = (String)in.readObject();
    }

}
