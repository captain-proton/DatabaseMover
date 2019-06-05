
package org.apache.cayenne.datamap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.unidue.dbmover.cayenne.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Ejbql_QNAME = new QName("http://cayenne.apache.org/schema/10/modelMap", "ejbql");
    private final static QName _Qualifier_QNAME = new QName("http://cayenne.apache.org/schema/10/modelMap", "qualifier");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.unidue.dbmover.cayenne.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Embeddable }
     * 
     */
    public Embeddable createEmbeddable() {
        return new Embeddable();
    }

    /**
     * Create an instance of {@link Procedure }
     * 
     */
    public Procedure createProcedure() {
        return new Procedure();
    }

    /**
     * Create an instance of {@link DbAttributePair }
     * 
     */
    public DbAttributePair createDbAttributePair() {
        return new DbAttributePair();
    }

    /**
     * Create an instance of {@link Ordering }
     * 
     */
    public Ordering createOrdering() {
        return new Ordering();
    }

    /**
     * Create an instance of {@link Prefetch }
     * 
     */
    public Prefetch createPrefetch() {
        return new Prefetch();
    }

    /**
     * Create an instance of {@link EmbeddableAttributeOverride }
     * 
     */
    public EmbeddableAttributeOverride createEmbeddableAttributeOverride() {
        return new EmbeddableAttributeOverride();
    }

    /**
     * Create an instance of {@link AttributeOverride }
     * 
     */
    public AttributeOverride createAttributeOverride() {
        return new AttributeOverride();
    }

    /**
     * Create an instance of {@link PrePersist }
     * 
     */
    public PrePersist createPrePersist() {
        return new PrePersist();
    }

    /**
     * Create an instance of {@link Sql }
     * 
     */
    public Sql createSql() {
        return new Sql();
    }

    /**
     * Create an instance of {@link DbEntity }
     * 
     */
    public DbEntity createDbEntity() {
        return new DbEntity();
    }

    /**
     * Create an instance of {@link DbAttribute }
     * 
     */
    public DbAttribute createDbAttribute() {
        return new DbAttribute();
    }

    /**
     * Create an instance of {@link DbKeyGenerator }
     * 
     */
    public DbKeyGenerator createDbKeyGenerator() {
        return new DbKeyGenerator();
    }

    /**
     * Create an instance of {@link Property }
     * 
     */
    public Property createProperty() {
        return new Property();
    }

    /**
     * Create an instance of {@link PreUpdate }
     * 
     */
    public PreUpdate createPreUpdate() {
        return new PreUpdate();
    }

    /**
     * Create an instance of {@link PreRemove }
     * 
     */
    public PreRemove createPreRemove() {
        return new PreRemove();
    }

    /**
     * Create an instance of {@link PostPersist }
     * 
     */
    public PostPersist createPostPersist() {
        return new PostPersist();
    }

    /**
     * Create an instance of {@link ObjEntity }
     * 
     */
    public ObjEntity createObjEntity() {
        return new ObjEntity();
    }

    /**
     * Create an instance of {@link EmbeddedAttribute }
     * 
     */
    public EmbeddedAttribute createEmbeddedAttribute() {
        return new EmbeddedAttribute();
    }

    /**
     * Create an instance of {@link ObjAttribute }
     * 
     */
    public ObjAttribute createObjAttribute() {
        return new ObjAttribute();
    }

    /**
     * Create an instance of {@link PostAdd }
     * 
     */
    public PostAdd createPostAdd() {
        return new PostAdd();
    }

    /**
     * Create an instance of {@link PostUpdate }
     * 
     */
    public PostUpdate createPostUpdate() {
        return new PostUpdate();
    }

    /**
     * Create an instance of {@link PostRemove }
     * 
     */
    public PostRemove createPostRemove() {
        return new PostRemove();
    }

    /**
     * Create an instance of {@link PostLoad }
     * 
     */
    public PostLoad createPostLoad() {
        return new PostLoad();
    }

    /**
     * Create an instance of {@link Query }
     * 
     */
    public Query createQuery() {
        return new Query();
    }

    /**
     * Create an instance of {@link DataMap }
     * 
     */
    public DataMap createDataMap() {
        return new DataMap();
    }

    /**
     * Create an instance of {@link Embeddable.EmbeddableAttribute }
     * 
     */
    public Embeddable.EmbeddableAttribute createEmbeddableEmbeddableAttribute() {
        return new Embeddable.EmbeddableAttribute();
    }

    /**
     * Create an instance of {@link Procedure.ProcedureParameter }
     * 
     */
    public Procedure.ProcedureParameter createProcedureProcedureParameter() {
        return new Procedure.ProcedureParameter();
    }

    /**
     * Create an instance of {@link DbRelationship }
     * 
     */
    public DbRelationship createDbRelationship() {
        return new DbRelationship();
    }

    /**
     * Create an instance of {@link ObjRelationship }
     * 
     */
    public ObjRelationship createObjRelationship() {
        return new ObjRelationship();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cayenne.apache.org/schema/10/modelMap", name = "ejbql")
    public JAXBElement<String> createEjbql(String value) {
        return new JAXBElement<String>(_Ejbql_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cayenne.apache.org/schema/10/modelMap", name = "qualifier")
    public JAXBElement<String> createQualifier(String value) {
        return new JAXBElement<String>(_Qualifier_QNAME, String.class, null, value);
    }

}
