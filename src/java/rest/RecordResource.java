/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import beans.RecordResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author hca
 */
@Path("record")
public class RecordResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RecordResource
     */
    public RecordResource() {
    }

    /**
     * Retrieves representation of an instance of rest.RecordResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getHtml(
        @QueryParam("dbName") String dbName, 
        @QueryParam("tableName") String tableName, 
        @QueryParam( "userName") String userName, 
        @QueryParam("password") String password, 
        @QueryParam( "start") int start, 
        @QueryParam( "end") int end) {
        //TODO return proper representation object
        return getRecords(dbName, tableName, userName, password, start, end);
    }

    /**
     * PUT INSERT RECORD
     * @param content representation for the resource
     */
    @PUT
    @Produces(MediaType.APPLICATION_XML)
    public RecordResponse putHtml(
        @FormParam("userName") String userName, 
        @FormParam("tableName") String tableName, 
        @FormParam( "values") String values, 
        @FormParam("dbName") String dbName, 
        @FormParam("password") String password) {
        
        boolean status = insertRecord(dbName, tableName, userName, password, values);
        RecordResponse res;
        if( status )
            res = new RecordResponse("exito", "Insercion de tupla exitosa");
        else
            res = new RecordResponse("error", "Error en insercion de tupla");
        return res;
    }

    private static String getRecords(java.lang.String dbName, java.lang.String tableName, java.lang.String userName, java.lang.String password, int start, int end) {
        tablewssc.TableService_Service service = new tablewssc.TableService_Service();
        tablewssc.TableService port = service.getTableServicePort();
        return port.getRecords(dbName, tableName, userName, password, start, end);
    }

    private static boolean insertRecord(java.lang.String dbName, java.lang.String tableName, java.lang.String userName, java.lang.String password, java.lang.String values) {
        tablewssc.TableService_Service service = new tablewssc.TableService_Service();
        tablewssc.TableService port = service.getTableServicePort();
        return port.insertRecord(dbName, tableName, userName, password, values);
    }
    
    
}
