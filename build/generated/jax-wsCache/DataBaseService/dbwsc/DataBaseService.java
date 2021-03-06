
package dbwsc;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebService(name = "DataBaseService", targetNamespace = "http://wssdatabase/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface DataBaseService {


    /**
     * 
     * @param password
     * @param dbName
     * @param userName
     * @return
     *     returns java.util.List<java.lang.String>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getTableName", targetNamespace = "http://wssdatabase/", className = "dbwsc.GetTableName")
    @ResponseWrapper(localName = "getTableNameResponse", targetNamespace = "http://wssdatabase/", className = "dbwsc.GetTableNameResponse")
    @Action(input = "http://wssdatabase/DataBaseService/getTableNameRequest", output = "http://wssdatabase/DataBaseService/getTableNameResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://wssdatabase/DataBaseService/getTableName/Fault/Exception")
    })
    public List<String> getTableName(
        @WebParam(name = "dbName", targetNamespace = "")
        String dbName,
        @WebParam(name = "userName", targetNamespace = "")
        String userName,
        @WebParam(name = "password", targetNamespace = "")
        String password)
        throws Exception_Exception
    ;

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://wssdatabase/", className = "dbwsc.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://wssdatabase/", className = "dbwsc.HelloResponse")
    @Action(input = "http://wssdatabase/DataBaseService/helloRequest", output = "http://wssdatabase/DataBaseService/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

}
