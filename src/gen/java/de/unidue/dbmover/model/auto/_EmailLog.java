package de.unidue.dbmover.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _EmailLog was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _EmailLog extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String LOG_ID_PK_COLUMN = "log_id";

    public static final Property<Long> ASSOC_TYPE = Property.create("assocType", Long.class);
    public static final Property<Long> ASSOC_ID = Property.create("assocId", Long.class);
    public static final Property<Long> SENDER_ID = Property.create("senderId", Long.class);
    public static final Property<LocalDateTime> DATE_SENT = Property.create("dateSent", LocalDateTime.class);
    public static final Property<String> IP_ADDRESS = Property.create("ipAddress", String.class);
    public static final Property<Long> EVENT_TYPE = Property.create("eventType", Long.class);
    public static final Property<String> FROM_ADDRESS = Property.create("fromAddress", String.class);
    public static final Property<String> RECIPIENTS = Property.create("recipients", String.class);
    public static final Property<String> CC_RECIPIENTS = Property.create("ccRecipients", String.class);
    public static final Property<String> BCC_RECIPIENTS = Property.create("bccRecipients", String.class);
    public static final Property<String> SUBJECT = Property.create("subject", String.class);
    public static final Property<String> BODY = Property.create("body", String.class);

    protected Long assocType;
    protected Long assocId;
    protected long senderId;
    protected LocalDateTime dateSent;
    protected String ipAddress;
    protected Long eventType;
    protected String fromAddress;
    protected String recipients;
    protected String ccRecipients;
    protected String bccRecipients;
    protected String subject;
    protected String body;


    public void setAssocType(long assocType) {
        beforePropertyWrite("assocType", this.assocType, assocType);
        this.assocType = assocType;
    }

    public long getAssocType() {
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
        if(this.assocId == null) {
            return 0;
        }
        return this.assocId;
    }

    public void setSenderId(long senderId) {
        beforePropertyWrite("senderId", this.senderId, senderId);
        this.senderId = senderId;
    }

    public long getSenderId() {
        beforePropertyRead("senderId");
        return this.senderId;
    }

    public void setDateSent(LocalDateTime dateSent) {
        beforePropertyWrite("dateSent", this.dateSent, dateSent);
        this.dateSent = dateSent;
    }

    public LocalDateTime getDateSent() {
        beforePropertyRead("dateSent");
        return this.dateSent;
    }

    public void setIpAddress(String ipAddress) {
        beforePropertyWrite("ipAddress", this.ipAddress, ipAddress);
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        beforePropertyRead("ipAddress");
        return this.ipAddress;
    }

    public void setEventType(long eventType) {
        beforePropertyWrite("eventType", this.eventType, eventType);
        this.eventType = eventType;
    }

    public long getEventType() {
        beforePropertyRead("eventType");
        if(this.eventType == null) {
            return 0;
        }
        return this.eventType;
    }

    public void setFromAddress(String fromAddress) {
        beforePropertyWrite("fromAddress", this.fromAddress, fromAddress);
        this.fromAddress = fromAddress;
    }

    public String getFromAddress() {
        beforePropertyRead("fromAddress");
        return this.fromAddress;
    }

    public void setRecipients(String recipients) {
        beforePropertyWrite("recipients", this.recipients, recipients);
        this.recipients = recipients;
    }

    public String getRecipients() {
        beforePropertyRead("recipients");
        return this.recipients;
    }

    public void setCcRecipients(String ccRecipients) {
        beforePropertyWrite("ccRecipients", this.ccRecipients, ccRecipients);
        this.ccRecipients = ccRecipients;
    }

    public String getCcRecipients() {
        beforePropertyRead("ccRecipients");
        return this.ccRecipients;
    }

    public void setBccRecipients(String bccRecipients) {
        beforePropertyWrite("bccRecipients", this.bccRecipients, bccRecipients);
        this.bccRecipients = bccRecipients;
    }

    public String getBccRecipients() {
        beforePropertyRead("bccRecipients");
        return this.bccRecipients;
    }

    public void setSubject(String subject) {
        beforePropertyWrite("subject", this.subject, subject);
        this.subject = subject;
    }

    public String getSubject() {
        beforePropertyRead("subject");
        return this.subject;
    }

    public void setBody(String body) {
        beforePropertyWrite("body", this.body, body);
        this.body = body;
    }

    public String getBody() {
        beforePropertyRead("body");
        return this.body;
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
            case "senderId":
                return this.senderId;
            case "dateSent":
                return this.dateSent;
            case "ipAddress":
                return this.ipAddress;
            case "eventType":
                return this.eventType;
            case "fromAddress":
                return this.fromAddress;
            case "recipients":
                return this.recipients;
            case "ccRecipients":
                return this.ccRecipients;
            case "bccRecipients":
                return this.bccRecipients;
            case "subject":
                return this.subject;
            case "body":
                return this.body;
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
                this.assocType = (Long)val;
                break;
            case "assocId":
                this.assocId = (Long)val;
                break;
            case "senderId":
                this.senderId = val == null ? 0 : (long)val;
                break;
            case "dateSent":
                this.dateSent = (LocalDateTime)val;
                break;
            case "ipAddress":
                this.ipAddress = (String)val;
                break;
            case "eventType":
                this.eventType = (Long)val;
                break;
            case "fromAddress":
                this.fromAddress = (String)val;
                break;
            case "recipients":
                this.recipients = (String)val;
                break;
            case "ccRecipients":
                this.ccRecipients = (String)val;
                break;
            case "bccRecipients":
                this.bccRecipients = (String)val;
                break;
            case "subject":
                this.subject = (String)val;
                break;
            case "body":
                this.body = (String)val;
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
        out.writeObject(this.assocId);
        out.writeLong(this.senderId);
        out.writeObject(this.dateSent);
        out.writeObject(this.ipAddress);
        out.writeObject(this.eventType);
        out.writeObject(this.fromAddress);
        out.writeObject(this.recipients);
        out.writeObject(this.ccRecipients);
        out.writeObject(this.bccRecipients);
        out.writeObject(this.subject);
        out.writeObject(this.body);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.assocType = (Long)in.readObject();
        this.assocId = (Long)in.readObject();
        this.senderId = in.readLong();
        this.dateSent = (LocalDateTime)in.readObject();
        this.ipAddress = (String)in.readObject();
        this.eventType = (Long)in.readObject();
        this.fromAddress = (String)in.readObject();
        this.recipients = (String)in.readObject();
        this.ccRecipients = (String)in.readObject();
        this.bccRecipients = (String)in.readObject();
        this.subject = (String)in.readObject();
        this.body = (String)in.readObject();
    }

}
