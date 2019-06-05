
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
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}sql" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}ejbql" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="qualifier" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}ordering" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}prefetch" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="root" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="root-name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="result-entity" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    "sql",
    "ejbql",
    "qualifier",
    "ordering",
    "prefetch",
    "any"
})
@XmlRootElement(name = "query", namespace = "http://cayenne.apache.org/schema/10/modelMap")
public class Query {

    @XmlElement(namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<Property> property;
    @XmlElement(namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<Sql> sql;
    @XmlElement(namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<String> ejbql;
    @XmlElement(namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<String> qualifier;
    @XmlElement(namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<Ordering> ordering;
    @XmlElement(namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected List<Prefetch> prefetch;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "root")
    protected String root;
    @XmlAttribute(name = "root-name")
    protected String rootName;
    @XmlAttribute(name = "result-entity")
    protected String resultEntity;

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
     * Gets the value of the sql property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sql property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSql().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Sql }
     * 
     * 
     */
    public List<Sql> getSql() {
        if (sql == null) {
            sql = new ArrayList<Sql>();
        }
        return this.sql;
    }

    /**
     * Gets the value of the ejbql property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ejbql property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEjbql().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getEjbql() {
        if (ejbql == null) {
            ejbql = new ArrayList<String>();
        }
        return this.ejbql;
    }

    /**
     * Gets the value of the qualifier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the qualifier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQualifier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getQualifier() {
        if (qualifier == null) {
            qualifier = new ArrayList<String>();
        }
        return this.qualifier;
    }

    /**
     * Gets the value of the ordering property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ordering property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrdering().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ordering }
     * 
     * 
     */
    public List<Ordering> getOrdering() {
        if (ordering == null) {
            ordering = new ArrayList<Ordering>();
        }
        return this.ordering;
    }

    /**
     * Gets the value of the prefetch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prefetch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrefetch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Prefetch }
     * 
     * 
     */
    public List<Prefetch> getPrefetch() {
        if (prefetch == null) {
            prefetch = new ArrayList<Prefetch>();
        }
        return this.prefetch;
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
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
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
     * Ruft den Wert der root-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoot() {
        return root;
    }

    /**
     * Legt den Wert der root-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoot(String value) {
        this.root = value;
    }

    /**
     * Ruft den Wert der rootName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRootName() {
        return rootName;
    }

    /**
     * Legt den Wert der rootName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRootName(String value) {
        this.rootName = value;
    }

    /**
     * Ruft den Wert der resultEntity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultEntity() {
        return resultEntity;
    }

    /**
     * Legt den Wert der resultEntity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultEntity(String value) {
        this.resultEntity = value;
    }

}
