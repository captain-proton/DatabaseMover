
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
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}db-attribute" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}db-key-generator" minOccurs="0"/>
 *         &lt;element ref="{http://cayenne.apache.org/schema/10/modelMap}qualifier" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="schema" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="catalog" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dbAttribute",
    "dbKeyGenerator",
    "qualifier",
    "any"
})
@XmlRootElement(name = "db-entity", namespace = "http://cayenne.apache.org/schema/10/modelMap")
public class DbEntity {

    @XmlElement(name = "db-attribute", namespace = "http://cayenne.apache.org/schema/10/modelMap", required = true)
    protected List<DbAttribute> dbAttribute;
    @XmlElement(name = "db-key-generator", namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected DbKeyGenerator dbKeyGenerator;
    @XmlElement(namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected String qualifier;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "schema")
    protected String schema;
    @XmlAttribute(name = "catalog")
    protected String catalog;

    /**
     * Gets the value of the dbAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dbAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDbAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DbAttribute }
     * 
     * 
     */
    public List<DbAttribute> getDbAttribute() {
        if (dbAttribute == null) {
            dbAttribute = new ArrayList<DbAttribute>();
        }
        return this.dbAttribute;
    }

    /**
     * Ruft den Wert der dbKeyGenerator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DbKeyGenerator }
     *     
     */
    public DbKeyGenerator getDbKeyGenerator() {
        return dbKeyGenerator;
    }

    /**
     * Legt den Wert der dbKeyGenerator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DbKeyGenerator }
     *     
     */
    public void setDbKeyGenerator(DbKeyGenerator value) {
        this.dbKeyGenerator = value;
    }

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
     * Ruft den Wert der schema-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchema() {
        return schema;
    }

    /**
     * Legt den Wert der schema-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchema(String value) {
        this.schema = value;
    }

    /**
     * Ruft den Wert der catalog-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatalog() {
        return catalog;
    }

    /**
     * Legt den Wert der catalog-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatalog(String value) {
        this.catalog = value;
    }

}
