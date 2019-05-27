package de.unidue.dbmover.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _Metrics was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Metrics extends BaseDataObject {

    private static final long serialVersionUID = 1L; 


    public static final Property<String> LOAD_ID = Property.create("loadId", String.class);
    public static final Property<Long> ASSOC_TYPE = Property.create("assocType", Long.class);
    public static final Property<Long> CONTEXT_ID = Property.create("contextId", Long.class);
    public static final Property<Long> SUBMISSION_ID = Property.create("submissionId", Long.class);
    public static final Property<Long> ASSOC_ID = Property.create("assocId", Long.class);
    public static final Property<String> DAY = Property.create("day", String.class);
    public static final Property<String> MONTH = Property.create("month", String.class);
    public static final Property<Short> FILE_TYPE = Property.create("fileType", Short.class);
    public static final Property<String> COUNTRY_ID = Property.create("countryId", String.class);
    public static final Property<String> REGION = Property.create("region", String.class);
    public static final Property<String> CITY = Property.create("city", String.class);
    public static final Property<String> METRIC_TYPE = Property.create("metricType", String.class);
    public static final Property<Integer> METRIC = Property.create("metric", Integer.class);
    public static final Property<Long> PKP_SECTION_ID = Property.create("pkpSectionId", Long.class);
    public static final Property<Long> ASSOC_OBJECT_TYPE = Property.create("assocObjectType", Long.class);
    public static final Property<Long> ASSOC_OBJECT_ID = Property.create("assocObjectId", Long.class);
    public static final Property<Long> REPRESENTATION_ID = Property.create("representationId", Long.class);

    protected String loadId;
    protected long assocType;
    protected long contextId;
    protected Long submissionId;
    protected long assocId;
    protected String day;
    protected String month;
    protected Short fileType;
    protected String countryId;
    protected String region;
    protected String city;
    protected String metricType;
    protected int metric;
    protected Long pkpSectionId;
    protected Long assocObjectType;
    protected Long assocObjectId;
    protected Long representationId;


    public void setLoadId(String loadId) {
        beforePropertyWrite("loadId", this.loadId, loadId);
        this.loadId = loadId;
    }

    public String getLoadId() {
        beforePropertyRead("loadId");
        return this.loadId;
    }

    public void setAssocType(long assocType) {
        beforePropertyWrite("assocType", this.assocType, assocType);
        this.assocType = assocType;
    }

    public long getAssocType() {
        beforePropertyRead("assocType");
        return this.assocType;
    }

    public void setContextId(long contextId) {
        beforePropertyWrite("contextId", this.contextId, contextId);
        this.contextId = contextId;
    }

    public long getContextId() {
        beforePropertyRead("contextId");
        return this.contextId;
    }

    public void setSubmissionId(long submissionId) {
        beforePropertyWrite("submissionId", this.submissionId, submissionId);
        this.submissionId = submissionId;
    }

    public long getSubmissionId() {
        beforePropertyRead("submissionId");
        if(this.submissionId == null) {
            return 0;
        }
        return this.submissionId;
    }

    public void setAssocId(long assocId) {
        beforePropertyWrite("assocId", this.assocId, assocId);
        this.assocId = assocId;
    }

    public long getAssocId() {
        beforePropertyRead("assocId");
        return this.assocId;
    }

    public void setDay(String day) {
        beforePropertyWrite("day", this.day, day);
        this.day = day;
    }

    public String getDay() {
        beforePropertyRead("day");
        return this.day;
    }

    public void setMonth(String month) {
        beforePropertyWrite("month", this.month, month);
        this.month = month;
    }

    public String getMonth() {
        beforePropertyRead("month");
        return this.month;
    }

    public void setFileType(short fileType) {
        beforePropertyWrite("fileType", this.fileType, fileType);
        this.fileType = fileType;
    }

    public short getFileType() {
        beforePropertyRead("fileType");
        if(this.fileType == null) {
            return 0;
        }
        return this.fileType;
    }

    public void setCountryId(String countryId) {
        beforePropertyWrite("countryId", this.countryId, countryId);
        this.countryId = countryId;
    }

    public String getCountryId() {
        beforePropertyRead("countryId");
        return this.countryId;
    }

    public void setRegion(String region) {
        beforePropertyWrite("region", this.region, region);
        this.region = region;
    }

    public String getRegion() {
        beforePropertyRead("region");
        return this.region;
    }

    public void setCity(String city) {
        beforePropertyWrite("city", this.city, city);
        this.city = city;
    }

    public String getCity() {
        beforePropertyRead("city");
        return this.city;
    }

    public void setMetricType(String metricType) {
        beforePropertyWrite("metricType", this.metricType, metricType);
        this.metricType = metricType;
    }

    public String getMetricType() {
        beforePropertyRead("metricType");
        return this.metricType;
    }

    public void setMetric(int metric) {
        beforePropertyWrite("metric", this.metric, metric);
        this.metric = metric;
    }

    public int getMetric() {
        beforePropertyRead("metric");
        return this.metric;
    }

    public void setPkpSectionId(long pkpSectionId) {
        beforePropertyWrite("pkpSectionId", this.pkpSectionId, pkpSectionId);
        this.pkpSectionId = pkpSectionId;
    }

    public long getPkpSectionId() {
        beforePropertyRead("pkpSectionId");
        if(this.pkpSectionId == null) {
            return 0;
        }
        return this.pkpSectionId;
    }

    public void setAssocObjectType(long assocObjectType) {
        beforePropertyWrite("assocObjectType", this.assocObjectType, assocObjectType);
        this.assocObjectType = assocObjectType;
    }

    public long getAssocObjectType() {
        beforePropertyRead("assocObjectType");
        if(this.assocObjectType == null) {
            return 0;
        }
        return this.assocObjectType;
    }

    public void setAssocObjectId(long assocObjectId) {
        beforePropertyWrite("assocObjectId", this.assocObjectId, assocObjectId);
        this.assocObjectId = assocObjectId;
    }

    public long getAssocObjectId() {
        beforePropertyRead("assocObjectId");
        if(this.assocObjectId == null) {
            return 0;
        }
        return this.assocObjectId;
    }

    public void setRepresentationId(long representationId) {
        beforePropertyWrite("representationId", this.representationId, representationId);
        this.representationId = representationId;
    }

    public long getRepresentationId() {
        beforePropertyRead("representationId");
        if(this.representationId == null) {
            return 0;
        }
        return this.representationId;
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "loadId":
                return this.loadId;
            case "assocType":
                return this.assocType;
            case "contextId":
                return this.contextId;
            case "submissionId":
                return this.submissionId;
            case "assocId":
                return this.assocId;
            case "day":
                return this.day;
            case "month":
                return this.month;
            case "fileType":
                return this.fileType;
            case "countryId":
                return this.countryId;
            case "region":
                return this.region;
            case "city":
                return this.city;
            case "metricType":
                return this.metricType;
            case "metric":
                return this.metric;
            case "pkpSectionId":
                return this.pkpSectionId;
            case "assocObjectType":
                return this.assocObjectType;
            case "assocObjectId":
                return this.assocObjectId;
            case "representationId":
                return this.representationId;
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
            case "loadId":
                this.loadId = (String)val;
                break;
            case "assocType":
                this.assocType = val == null ? 0 : (long)val;
                break;
            case "contextId":
                this.contextId = val == null ? 0 : (long)val;
                break;
            case "submissionId":
                this.submissionId = (Long)val;
                break;
            case "assocId":
                this.assocId = val == null ? 0 : (long)val;
                break;
            case "day":
                this.day = (String)val;
                break;
            case "month":
                this.month = (String)val;
                break;
            case "fileType":
                this.fileType = (Short)val;
                break;
            case "countryId":
                this.countryId = (String)val;
                break;
            case "region":
                this.region = (String)val;
                break;
            case "city":
                this.city = (String)val;
                break;
            case "metricType":
                this.metricType = (String)val;
                break;
            case "metric":
                this.metric = val == null ? 0 : (int)val;
                break;
            case "pkpSectionId":
                this.pkpSectionId = (Long)val;
                break;
            case "assocObjectType":
                this.assocObjectType = (Long)val;
                break;
            case "assocObjectId":
                this.assocObjectId = (Long)val;
                break;
            case "representationId":
                this.representationId = (Long)val;
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
        out.writeObject(this.loadId);
        out.writeLong(this.assocType);
        out.writeLong(this.contextId);
        out.writeObject(this.submissionId);
        out.writeLong(this.assocId);
        out.writeObject(this.day);
        out.writeObject(this.month);
        out.writeObject(this.fileType);
        out.writeObject(this.countryId);
        out.writeObject(this.region);
        out.writeObject(this.city);
        out.writeObject(this.metricType);
        out.writeInt(this.metric);
        out.writeObject(this.pkpSectionId);
        out.writeObject(this.assocObjectType);
        out.writeObject(this.assocObjectId);
        out.writeObject(this.representationId);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.loadId = (String)in.readObject();
        this.assocType = in.readLong();
        this.contextId = in.readLong();
        this.submissionId = (Long)in.readObject();
        this.assocId = in.readLong();
        this.day = (String)in.readObject();
        this.month = (String)in.readObject();
        this.fileType = (Short)in.readObject();
        this.countryId = (String)in.readObject();
        this.region = (String)in.readObject();
        this.city = (String)in.readObject();
        this.metricType = (String)in.readObject();
        this.metric = in.readInt();
        this.pkpSectionId = (Long)in.readObject();
        this.assocObjectType = (Long)in.readObject();
        this.assocObjectId = (Long)in.readObject();
        this.representationId = (Long)in.readObject();
    }

}
