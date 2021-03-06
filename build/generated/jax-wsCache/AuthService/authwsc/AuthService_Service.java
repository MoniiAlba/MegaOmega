
package authwsc;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "AuthService", targetNamespace = "http://wssauth/", wsdlLocation = "http://localhost:8080/AuthService/AuthService?wsdl")
public class AuthService_Service
    extends Service
{

    private final static URL AUTHSERVICE_WSDL_LOCATION;
    private final static WebServiceException AUTHSERVICE_EXCEPTION;
    private final static QName AUTHSERVICE_QNAME = new QName("http://wssauth/", "AuthService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/AuthService/AuthService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        AUTHSERVICE_WSDL_LOCATION = url;
        AUTHSERVICE_EXCEPTION = e;
    }

    public AuthService_Service() {
        super(__getWsdlLocation(), AUTHSERVICE_QNAME);
    }

    public AuthService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), AUTHSERVICE_QNAME, features);
    }

    public AuthService_Service(URL wsdlLocation) {
        super(wsdlLocation, AUTHSERVICE_QNAME);
    }

    public AuthService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, AUTHSERVICE_QNAME, features);
    }

    public AuthService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AuthService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AuthService
     */
    @WebEndpoint(name = "AuthServicePort")
    public AuthService getAuthServicePort() {
        return super.getPort(new QName("http://wssauth/", "AuthServicePort"), AuthService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AuthService
     */
    @WebEndpoint(name = "AuthServicePort")
    public AuthService getAuthServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://wssauth/", "AuthServicePort"), AuthService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (AUTHSERVICE_EXCEPTION!= null) {
            throw AUTHSERVICE_EXCEPTION;
        }
        return AUTHSERVICE_WSDL_LOCATION;
    }

}
