
package org.apache.cayenne.datamap;

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
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}qualifier" minOccurs="0"/>
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}embedded-attribute" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}obj-attribute" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}attribute-override" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}post-add" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}pre-persist" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}post-persist" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}pre-update" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}post-update" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}pre-remove" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}post-remove" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}post-load" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="className" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="abstract" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="readOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="clientClassName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="clientSuperClassName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="dbEntityName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="lock-type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="superClassName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="superEntityName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="serverOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "qualifier",
    "embeddedAttribute",
    "objAttribute",
    "attributeOverride",
    "postAdd",
    "prePersist",
    "postPersist",
    "preUpdate",
    "postUpdate",
    "preRemove",
    "postRemove",
    "postLoad",
    "any"
})
@XmlRootElement(name = "obj-entity", namespace = "http://cayenne.apache.org/schema/10/modelMap")
public class ObjEntity {

    @XmlElement(namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected String qualifier;
    @XmlElement(name = "embedded-attribute", namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<EmbeddedAttribute> embeddedAttribute;
    @XmlElement(name = "obj-attribute", namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<ObjAttribute> objAttribute;
    @XmlElement(name = "attribute-override", namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<AttributeOverride> attributeOverride;
    @XmlElement(name = "post-add", namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<PostAdd> postAdd;
    @XmlElement(name = "pre-persist", namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<PrePersist> prePersist;
    @XmlElement(name = "post-persist", namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<PostPersist> postPersist;
    @XmlElement(name = "pre-update", namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<PreUpdate> preUpdate;
    @XmlElement(name = "post-update", namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<PostUpdate> postUpdate;
    @XmlElement(name = "pre-remove", namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<PreRemove> preRemove;
    @XmlElement(name = "post-remove", namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<PostRemove> postRemove;
    @XmlElement(name = "post-load", namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<PostLoad> postLoad;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAttribute(name = "className")
    protected String className;
    @XmlAttribute(name = "abstract")
    protected Boolean _abstract;
    @XmlAttribute(name = "readOnly")
    protected Boolean readOnly;
    @XmlAttribute(name = "clientClassName")
    protected String clientClassName;
    @XmlAttribute(name = "clientSuperClassName")
    protected String clientSuperClassName;
    @XmlAttribute(name = "dbEntityName")
    protected String dbEntityName;
    @XmlAttribute(name = "lock-type")
    protected String lockType;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "superClassName")
    protected String superClassName;
    @XmlAttribute(name = "superEntityName")
    protected String superEntityName;
    @XmlAttribute(name = "serverOnly")
    protected Boolean serverOnly;

    /**
     * Ruft den Wert der qualifier-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQualifier() {
        return qualifier;
    }

    /**
     * Legt den Wert der qualifier-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQualifier(String value) {
        this.qualifier = value;
    }

    /**
     * Gets the value of the embeddedAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the embeddedAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEmbeddedAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EmbeddedAttribute }
     * 
     * 
     */
    public List<EmbeddedAttribute> getEmbeddedAttribute() {
        if (embeddedAttribute == null) {
            embeddedAttribute = new ArrayList<EmbeddedAttribute>();
        }
        return this.embeddedAttribute;
    }

    /**
     * Gets the value of the objAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObjAttribute }
     * 
     * 
     */
    public List<ObjAttribute> getObjAttribute() {
        if (objAttribute == null) {
            objAttribute = new ArrayList<ObjAttribute>();
        }
        return this.objAttribute;
    }

    /**
     * Gets the value of the attributeOverride property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attributeOverride property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttributeOverride().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttributeOverride }
     * 
     * 
     */
    public List<AttributeOverride> getAttributeOverride() {
        if (attributeOverride == null) {
            attributeOverride = new ArrayList<AttributeOverride>();
        }
        return this.attributeOverride;
    }

    /**
     * Gets the value of the postAdd property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the postAdd property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPostAdd().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PostAdd }
     * 
     * 
     */
    public List<PostAdd> getPostAdd() {
        if (postAdd == null) {
            postAdd = new ArrayList<PostAdd>();
        }
        return this.postAdd;
    }

    /**
     * Gets the value of the prePersist property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prePersist property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrePersist().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PrePersist }
     * 
     * 
     */
    public List<PrePersist> getPrePersist() {
        if (prePersist == null) {
            prePersist = new ArrayList<PrePersist>();
        }
        return this.prePersist;
    }

    /**
     * Gets the value of the postPersist property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the postPersist property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPostPersist().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PostPersist }
     * 
     * 
     */
    public List<PostPersist> getPostPersist() {
        if (postPersist == null) {
            postPersist = new ArrayList<PostPersist>();
        }
        return this.postPersist;
    }

    /**
     * Gets the value of the preUpdate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the preUpdate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPreUpdate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PreUpdate }
     * 
     * 
     */
    public List<PreUpdate> getPreUpdate() {
        if (preUpdate == null) {
            preUpdate = new ArrayList<PreUpdate>();
        }
        return this.preUpdate;
    }

    /**
     * Gets the value of the postUpdate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the postUpdate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPostUpdate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PostUpdate }
     * 
     * 
     */
    public List<PostUpdate> getPostUpdate() {
        if (postUpdate == null) {
            postUpdate = new ArrayList<PostUpdate>();
        }
        return this.postUpdate;
    }

    /**
     * Gets the value of the preRemove property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the preRemove property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPreRemove().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PreRemove }
     * 
     * 
     */
    public List<PreRemove> getPreRemove() {
        if (preRemove == null) {
            preRemove = new ArrayList<PreRemove>();
        }
        return this.preRemove;
    }

    /**
     * Gets the value of the postRemove property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the postRemove property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPostRemove().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PostRemove }
     * 
     * 
     */
    public List<PostRemove> getPostRemove() {
        if (postRemove == null) {
            postRemove = new ArrayList<PostRemove>();
        }
        return this.postRemove;
    }

    /**
     * Gets the value of the postLoad property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the postLoad property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPostLoad().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PostLoad }
     * 
     * 
     */
    public List<PostLoad> getPostLoad() {
        if (postLoad == null) {
            postLoad = new ArrayList<PostLoad>();
        }
        return this.postLoad;
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
     * Ruft den Wert der className-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassName() {
        return className;
    }

    /**
     * Legt den Wert der className-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassName(String value) {
        this.className = value;
    }

    /**
     * Ruft den Wert der abstract-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAbstract() {
        return _abstract;
    }

    /**
     * Legt den Wert der abstract-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAbstract(Boolean value) {
        this._abstract = value;
    }

    /**
     * Ruft den Wert der readOnly-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReadOnly() {
        return readOnly;
    }

    /**
     * Legt den Wert der readOnly-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReadOnly(Boolean value) {
        this.readOnly = value;
    }

    /**
     * Ruft den Wert der clientClassName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientClassName() {
        return clientClassName;
    }

    /**
     * Legt den Wert der clientClassName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientClassName(String value) {
        this.clientClassName = value;
    }

    /**
     * Ruft den Wert der clientSuperClassName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientSuperClassName() {
        return clientSuperClassName;
    }

    /**
     * Legt den Wert der clientSuperClassName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientSuperClassName(String value) {
        this.clientSuperClassName = value;
    }

    /**
     * Ruft den Wert der dbEntityName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDbEntityName() {
        return dbEntityName;
    }

    /**
     * Legt den Wert der dbEntityName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDbEntityName(String value) {
        this.dbEntityName = value;
    }

    /**
     * Ruft den Wert der lockType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLockType() {
        return lockType;
    }

    /**
     * Legt den Wert der lockType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLockType(String value) {
        this.lockType = value;
    }

    /**
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Ruft den Wert der superClassName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuperClassName() {
        return superClassName;
    }

    /**
     * Legt den Wert der superClassName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuperClassName(String value) {
        this.superClassName = value;
    }

    /**
     * Ruft den Wert der superEntityName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuperEntityName() {
        return superEntityName;
    }

    /**
     * Legt den Wert der superEntityName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuperEntityName(String value) {
        this.superEntityName = value;
    }

    /**
     * Ruft den Wert der serverOnly-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isServerOnly() {
        return serverOnly;
    }

    /**
     * Legt den Wert der serverOnly-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setServerOnly(Boolean value) {
        this.serverOnly = value;
    }

}
