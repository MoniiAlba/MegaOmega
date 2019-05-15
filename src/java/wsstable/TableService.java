/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsstable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utils.TableField;
import utils.TableManager;

/**
 *
 * @author hca
 */
@WebService(serviceName = "TableService")
@Stateless()
public class TableService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "createTable")
    public boolean createTable(
            @WebParam(name = "userName") String userName, 
            @WebParam(name = "tableName") String tableName, 
            @WebParam(name = "fields") String fields, 
            @WebParam(name = "dbName") String dbName, 
            @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        boolean res = false;
        JSONParser parser = new JSONParser();
        ArrayList<TableField> fieldsO = new ArrayList<>();
        TableField aux = null;
        JSONObject jaux = null;
        try {
            JSONArray fieldsJ = (JSONArray) parser.parse(fields);
            for( Object f : fieldsJ){
                if ( f instanceof JSONObject){
                    jaux = (JSONObject) f;
                    aux = new TableField(jaux.get("name").toString(), jaux.get("type").toString(),
                            jaux.get("isPrimaryKey").toString().equals("true"));
                    //System.out.println(aux.name + " " + aux.type + " " + aux.isPrimaryKey);
                    fieldsO.add(aux);
                }
            }
            System.out.println(fieldsJ);
            TableManager t = new TableManager(tableName, dbName, userName, password,fieldsO);
            res = true;
        } catch (ParseException ex) {
            Logger.getLogger(TableService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TableService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getRecords")
    public String getRecords(
            @WebParam(name = "dbName") String dbName, 
            @WebParam(name = "tableName") String tableName, 
            @WebParam(name = "userName") String userName, 
            @WebParam(name = "password") String password, 
            @WebParam(name = "start") int start, 
            @WebParam(name = "end") int end) {
        ArrayList<HashMap<String, String>> qres ;
        JSONArray res = null;
        try {
            //TODO write your implementation code here:
            TableManager t = new TableManager(tableName, dbName, userName, password);
            qres = t.getRecords(start, end);
            res = new JSONArray();
            JSONObject aux;
            for( HashMap<String, String> r : qres){
                aux = new JSONObject(r);
                res.add(aux);
            }
        } catch (Exception ex) {
            Logger.getLogger(TableService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res == null ? "": res.toString();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertRecord")
    public boolean insertRecord(
            @WebParam(name = "dbName") String dbName, 
            @WebParam(name = "tableName") String tableName, 
            @WebParam(name = "userName") String userName, 
            @WebParam(name = "password") String password, 
            @WebParam(name = "values") String values) {
        boolean res = false;
        try {
            //TODO write your implementation code here:
            TableManager t = new TableManager(tableName, dbName, userName,password);
            JSONParser parser = new JSONParser();
            JSONObject valuesJ = (JSONObject) parser.parse(values);
            t.insertRecord(valuesJ);
            res = true;
        } catch (Exception ex) {
            Logger.getLogger(TableService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateRecord")
    public boolean updateRecord(
            @WebParam(name = "dbName") String dbName, 
            @WebParam(name = "tableName") String tableName, 
            @WebParam(name = "userName") String userName, 
            @WebParam(name = "password") String password, 
            @WebParam(name = "values") String values,
            @WebParam(name = "primaryKey") String primaryKey) {
        boolean res = false;
        try {
            //TODO write your implementation code here:
            TableManager t = new TableManager(tableName, dbName, userName,password);
            JSONParser parser = new JSONParser();
            JSONObject valuesJ = (JSONObject) parser.parse(values);
            t.updateRecord(valuesJ,primaryKey);
            res = true;
        } catch (Exception ex) {
            Logger.getLogger(TableService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteRecord")
    public boolean deleteRecord(
            @WebParam(name = "dbName") String dbName, 
            @WebParam(name = "tableName") String tableName, 
            @WebParam(name = "userName") String userName, 
            @WebParam(name = "password") String password, 
            @WebParam(name = "primaryKey") String primaryKey) {
        boolean res = false;
        try {
            TableManager t = new TableManager(tableName, dbName, userName, password);
            t.deleteRecord(primaryKey);
            res = true;
        } catch (Exception ex) {
            Logger.getLogger(TableService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getFields")
    public String getFields(
            @WebParam(name = "dbName") String dbName, 
            @WebParam(name = "tableName") String tableName, 
            @WebParam(name = "userName") String userName, 
            @WebParam(name = "password") String password) {
        JSONArray res = new JSONArray();
        JSONObject aux;
        ArrayList<TableField> fields;
        try {
            TableManager t = new TableManager(tableName, dbName, userName, password);
            fields = t.getFields();
            for( TableField tf : fields ){
                aux = new JSONObject();
                aux.put("name", tf.name);
                aux.put("type", tf.type);
                aux.put("isPrimaryKey", tf.isPrimaryKey);
                res.add(aux);
            }
        } catch (Exception ex) {
            Logger.getLogger(TableService.class.getName()).log(Level.SEVERE, null, ex);
            return "{ \"error\": \""+ ex.toString()+"\"}";
        }
        return res.toString();
    }
    
    
    
    
    
    
    
    
    
}
