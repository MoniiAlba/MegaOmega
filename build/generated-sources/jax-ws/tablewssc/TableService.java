
package tablewssc;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "TableService", targetNamespace = "http://wsstable/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TableService {


    /**
     * 
     * @param password
     * @param dbName
     * @param userName
     * @param fields
     * @param tableName
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createTable", targetNamespace = "http://wsstable/", className = "tablewssc.CreateTable")
    @ResponseWrapper(localName = "createTableResponse", targetNamespace = "http://wsstable/", className = "tablewssc.CreateTableResponse")
    @Action(input = "http://wsstable/TableService/createTableRequest", output = "http://wsstable/TableService/createTableResponse")
    public boolean createTable(
        @WebParam(name = "userName", targetNamespace = "")
        String userName,
        @WebParam(name = "tableName", targetNamespace = "")
        String tableName,
        @WebParam(name = "fields", targetNamespace = "")
        String fields,
        @WebParam(name = "dbName", targetNamespace = "")
        String dbName,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @param password
     * @param dbName
     * @param values
     * @param userName
     * @param tableName
     * @param primaryKey
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateRecord", targetNamespace = "http://wsstable/", className = "tablewssc.UpdateRecord")
    @ResponseWrapper(localName = "updateRecordResponse", targetNamespace = "http://wsstable/", className = "tablewssc.UpdateRecordResponse")
    @Action(input = "http://wsstable/TableService/updateRecordRequest", output = "http://wsstable/TableService/updateRecordResponse")
    public boolean updateRecord(
        @WebParam(name = "dbName", targetNamespace = "")
        String dbName,
        @WebParam(name = "tableName", targetNamespace = "")
        String tableName,
        @WebParam(name = "userName", targetNamespace = "")
        String userName,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "values", targetNamespace = "")
        String values,
        @WebParam(name = "primaryKey", targetNamespace = "")
        String primaryKey);

    /**
     * 
     * @param password
     * @param dbName
     * @param start
     * @param end
     * @param userName
     * @param tableName
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getRecords", targetNamespace = "http://wsstable/", className = "tablewssc.GetRecords")
    @ResponseWrapper(localName = "getRecordsResponse", targetNamespace = "http://wsstable/", className = "tablewssc.GetRecordsResponse")
    @Action(input = "http://wsstable/TableService/getRecordsRequest", output = "http://wsstable/TableService/getRecordsResponse")
    public String getRecords(
        @WebParam(name = "dbName", targetNamespace = "")
        String dbName,
        @WebParam(name = "tableName", targetNamespace = "")
        String tableName,
        @WebParam(name = "userName", targetNamespace = "")
        String userName,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "start", targetNamespace = "")
        int start,
        @WebParam(name = "end", targetNamespace = "")
        int end);

    /**
     * 
     * @param password
     * @param dbName
     * @param values
     * @param userName
     * @param tableName
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertRecord", targetNamespace = "http://wsstable/", className = "tablewssc.InsertRecord")
    @ResponseWrapper(localName = "insertRecordResponse", targetNamespace = "http://wsstable/", className = "tablewssc.InsertRecordResponse")
    @Action(input = "http://wsstable/TableService/insertRecordRequest", output = "http://wsstable/TableService/insertRecordResponse")
    public boolean insertRecord(
        @WebParam(name = "dbName", targetNamespace = "")
        String dbName,
        @WebParam(name = "tableName", targetNamespace = "")
        String tableName,
        @WebParam(name = "userName", targetNamespace = "")
        String userName,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "values", targetNamespace = "")
        String values);

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://wsstable/", className = "tablewssc.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://wsstable/", className = "tablewssc.HelloResponse")
    @Action(input = "http://wsstable/TableService/helloRequest", output = "http://wsstable/TableService/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @param password
     * @param dbName
     * @param userName
     * @param tableName
     * @param primaryKey
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteRecord", targetNamespace = "http://wsstable/", className = "tablewssc.DeleteRecord")
    @ResponseWrapper(localName = "deleteRecordResponse", targetNamespace = "http://wsstable/", className = "tablewssc.DeleteRecordResponse")
    @Action(input = "http://wsstable/TableService/deleteRecordRequest", output = "http://wsstable/TableService/deleteRecordResponse")
    public boolean deleteRecord(
        @WebParam(name = "dbName", targetNamespace = "")
        String dbName,
        @WebParam(name = "tableName", targetNamespace = "")
        String tableName,
        @WebParam(name = "userName", targetNamespace = "")
        String userName,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "primaryKey", targetNamespace = "")
        String primaryKey);

}
