
package dbwsc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the dbwsc package. 
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

    private final static QName _Exception_QNAME = new QName("http://wssdatabase/", "Exception");
    private final static QName _GetTableName_QNAME = new QName("http://wssdatabase/", "getTableName");
    private final static QName _GetTableNameResponse_QNAME = new QName("http://wssdatabase/", "getTableNameResponse");
    private final static QName _Hello_QNAME = new QName("http://wssdatabase/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://wssdatabase/", "helloResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dbwsc
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link GetTableName }
     * 
     */
    public GetTableName createGetTableName() {
        return new GetTableName();
    }

    /**
     * Create an instance of {@link GetTableNameResponse }
     * 
     */
    public GetTableNameResponse createGetTableNameResponse() {
        return new GetTableNameResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wssdatabase/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTableName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wssdatabase/", name = "getTableName")
    public JAXBElement<GetTableName> createGetTableName(GetTableName value) {
        return new JAXBElement<GetTableName>(_GetTableName_QNAME, GetTableName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTableNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wssdatabase/", name = "getTableNameResponse")
    public JAXBElement<GetTableNameResponse> createGetTableNameResponse(GetTableNameResponse value) {
        return new JAXBElement<GetTableNameResponse>(_GetTableNameResponse_QNAME, GetTableNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wssdatabase/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wssdatabase/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

}
