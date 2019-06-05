
package de.unidue.dbmover.cayenne.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}property" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}embeddable" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}procedure" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}db-entity" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}obj-entity" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}db-relationship" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}obj-relationship" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}query" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="project-version" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "property",
    "embeddable",
    "procedure",
    "dbEntity",
    "objEntity",
    "dbRelationship",
    "objRelationship",
    "query",
    "any"
})
@XmlRootElement(name = "data-map", namespace = "http://cayenne.apache.org/schema/10/modelMap")
public class DataMap {

    @XmlElement(namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<Property> property;
    @XmlElement(namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<Embeddable> embeddable;
    @XmlElement(namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<Procedure> procedure;
    @XmlElement(name = "db-entity", namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<DbEntity> dbEntity;
    @XmlElement(name = "obj-entity", namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<ObjEntity> objEntity;
    @XmlElement(name = "db-relationship", namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<DbRelationship> dbRelationship;
    @XmlElement(name = "obj-relationship", namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<ObjRelationship> objRelationship;
    @XmlElement(namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<Query> query;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAttribute(name = "project-version", required = true)
    protected String projectVersion;

    /**
     * Gets the value of the property property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the property property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Property }
     * 
     * 
     */
    public List<Property> getProperty() {
        if (property == null) {
            property = new ArrayList<Property>();
        }
        return this.property;
    }

    /**
     * Gets the value of the embeddable property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the embeddable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEmbeddable().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Embeddable }
     * 
     * 
     */
    public List<Embeddable> getEmbeddable() {
        if (embeddable == null) {
            embeddable = new ArrayList<Embeddable>();
        }
        return this.embeddable;
    }

    /**
     * Gets the value of the procedure property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the procedure property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProcedure().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Procedure }
     * 
     * 
     */
    public List<Procedure> getProcedure() {
        if (procedure == null) {
            procedure = new ArrayList<Procedure>();
        }
        return this.procedure;
    }

    /**
     * Gets the value of the dbEntity property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dbEntity property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDbEntity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DbEntity }
     * 
     * 
     */
    public List<DbEntity> getDbEntity() {
        if (dbEntity == null) {
            dbEntity = new ArrayList<DbEntity>();
        }
        return this.dbEntity;
    }

    /**
     * Gets the value of the objEntity property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objEntity property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjEntity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObjEntity }
     * 
     * 
     */
    public List<ObjEntity> getObjEntity() {
        if (objEntity == null) {
            objEntity = new ArrayList<ObjEntity>();
        }
        return this.objEntity;
    }

    /**
     * Gets the value of the dbRelationship property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dbRelationship property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDbRelationship().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DbRelationship }
     * 
     * 
     */
    public List<DbRelationship> getDbRelationship() {
        if (dbRelationship == null) {
            dbRelationship = new ArrayList<DbRelationship>();
        }
        return this.dbRelationship;
    }

    /**
     * Gets the value of the objRelationship property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objRelationship property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjRelationship().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObjRelationship }
     * 
     * 
     */
    public List<ObjRelationship> getObjRelationship() {
        if (objRelationship == null) {
            objRelationship = new ArrayList<ObjRelationship>();
        }
        return this.objRelationship;
    }

    /**
     * Gets the value of the query property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the query property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQuery().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Query }
     * 
     * 
     */
    public List<Query> getQuery() {
        if (query == null) {
            query = new ArrayList<Query>();
        }
        return this.query;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * {@link Element }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    /**
     * Ruft den Wert der projectVersion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectVersion() {
        return projectVersion;
    }

    /**
     * Legt den Wert der projectVersion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectVersion(String value) {
        this.projectVersion = value;
    }

}
