/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsstable;

import java.util.ArrayList;
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
    public String createTable(
            @WebParam(name = "userName") String userName, 
            @WebParam(name = "tableName") String tableName, 
            @WebParam(name = "fields") String fields, 
            @WebParam(name = "dbName") String dbName, 
            @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
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
        } catch (ParseException ex) {
            Logger.getLogger(TableService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TableService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "dummy";
    }
    
}
