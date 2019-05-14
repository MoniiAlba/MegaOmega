/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wssdatabase;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import utils.DBManager;

/**
 *
 * @author soeur
 */
@WebService(serviceName = "DataBaseService")
@Stateless()
public class DataBaseService {

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
    @WebMethod(operationName = "getTableName")
    public ArrayList<String> getTableName(@WebParam(name = "dbName") String dbName, @WebParam(name = "userName") String userName, @WebParam(name = "password") String password) throws Exception {
        //System.out.println("Datos: "+dbName+userName+password);
        DBManager db = new DBManager();
        ArrayList <String> tablas = db.getTableName(dbName, userName, password);
        return tablas;
    }
}
