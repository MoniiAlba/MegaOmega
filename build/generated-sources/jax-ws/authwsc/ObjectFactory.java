
package authwsc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the authwsc package. 
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

    private final static QName _CreateNewUser_QNAME = new QName("http://wssauth/", "createNewUser");
    private final static QName _CreateNewUserResponse_QNAME = new QName("http://wssauth/", "createNewUserResponse");
    private final static QName _Hello_QNAME = new QName("http://wssauth/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://wssauth/", "helloResponse");
    private final static QName _SignInUser_QNAME = new QName("http://wssauth/", "signInUser");
    private final static QName _SignInUserResponse_QNAME = new QName("http://wssauth/", "signInUserResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: authwsc
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateNewUser }
     * 
     */
    public CreateNewUser createCreateNewUser() {
        return new CreateNewUser();
    }

    /**
     * Create an instance of {@link CreateNewUserResponse }
     * 
     */
    public CreateNewUserResponse createCreateNewUserResponse() {
        return new CreateNewUserResponse();
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
     * Create an instance of {@link SignInUser }
     * 
     */
    public SignInUser createSignInUser() {
        return new SignInUser();
    }

    /**
     * Create an instance of {@link SignInUserResponse }
     * 
     */
    public SignInUserResponse createSignInUserResponse() {
        return new SignInUserResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNewUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wssauth/", name = "createNewUser")
    public JAXBElement<CreateNewUser> createCreateNewUser(CreateNewUser value) {
        return new JAXBElement<CreateNewUser>(_CreateNewUser_QNAME, CreateNewUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNewUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wssauth/", name = "createNewUserResponse")
    public JAXBElement<CreateNewUserResponse> createCreateNewUserResponse(CreateNewUserResponse value) {
        return new JAXBElement<CreateNewUserResponse>(_CreateNewUserResponse_QNAME, CreateNewUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wssauth/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wssauth/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignInUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wssauth/", name = "signInUser")
    public JAXBElement<SignInUser> createSignInUser(SignInUser value) {
        return new JAXBElement<SignInUser>(_SignInUser_QNAME, SignInUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignInUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wssauth/", name = "signInUserResponse")
    public JAXBElement<SignInUserResponse> createSignInUserResponse(SignInUserResponse value) {
        return new JAXBElement<SignInUserResponse>(_SignInUserResponse_QNAME, SignInUserResponse.class, null, value);
    }

}
