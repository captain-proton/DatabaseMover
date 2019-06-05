
package de.unidue.dbmover.cayenne.model;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="db-generator-type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="db-generator-name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="db-key-cache-size" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dbGeneratorType",
    "dbGeneratorName",
    "dbKeyCacheSize"
})
@XmlRootElement(name = "db-key-generator", namespace = "http://cayenne.apache.org/schema/10/modelMap")
public class DbKeyGenerator {

    @XmlElement(name = "db-generator-type", namespace = "http://cayenne.apache.org/schema/10/modelMap", required = true)
    protected String dbGeneratorType;
    @XmlElement(name = "db-generator-name", namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected String dbGeneratorName;
    @XmlElement(name = "db-key-cache-size", namespace = "http://cayenne.apache.org/schema/10/modelMap")
    protected BigInteger dbKeyCacheSize;

    /**
     * Ruft den Wert der dbGeneratorType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDbGeneratorType() {
        return dbGeneratorType;
    }

    /**
     * Legt den Wert der dbGeneratorType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDbGeneratorType(String value) {
        this.dbGeneratorType = value;
    }

    /**
     * Ruft den Wert der dbGeneratorName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDbGeneratorName() {
        return dbGeneratorName;
    }

    /**
     * Legt den Wert der dbGeneratorName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDbGeneratorName(String value) {
        this.dbGeneratorName = value;
    }

    /**
     * Ruft den Wert der dbKeyCacheSize-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDbKeyCacheSize() {
        return dbKeyCacheSize;
    }

    /**
     * Legt den Wert der dbKeyCacheSize-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDbKeyCacheSize(BigInteger value) {
        this.dbKeyCacheSize = value;
    }

}
