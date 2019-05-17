/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import beans.RecordResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author hca
 */
@Path("row")
public class RowResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RowResource
     */
    public RowResource() {
    }

    /**
     * Retrieves representation of an instance of rest.RowResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson(
        @QueryParam("dbName") String dbName, 
        @QueryParam("tableName") String tableName, 
        @QueryParam( "userName") String userName, 
        @QueryParam("password") String password) {
        //TODO return proper representation object
        String count = getCount( dbName, tableName,  userName, password);
        return "{\"count\" : \""+count+"\"}";
    }

    /**
     * PUT method for updating or creating an instance of RowResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    @POST
    @Produces(MediaType.APPLICATION_XML)
    public RecordResponse postXml(
        @FormParam("userName") String userName, 
        @FormParam("tableName") String tableName, 
        @FormParam("dbName") String dbName, 
        @FormParam("password") String password,
        @FormParam("primaryKey") String primaryKey) {
        //System.out.println(userName+""+tableName+""+dbName+""+password+""+primaryKey);
        boolean status = deleteRecord(dbName, tableName, userName, password, primaryKey);
        RecordResponse res;
        if( status )
            res = new RecordResponse("exito", "Eliminacion de tupla exitosa");
        else
            res = new RecordResponse("error", "Error en eliminacion de tupla");
        return res;
    }

    private static boolean deleteRecord(java.lang.String dbName, java.lang.String tableName, java.lang.String userName, java.lang.String password, java.lang.String primaryKey) {
        tablewssc.TableService_Service service = new tablewssc.TableService_Service();
        tablewssc.TableService port = service.getTableServicePort();
        return port.deleteRecord(dbName, tableName, userName, password, primaryKey);
    }

    private static String getCount(java.lang.String dbName, java.lang.String tableName, java.lang.String userName, java.lang.String password) {
        tablewssc.TableService_Service service = new tablewssc.TableService_Service();
        tablewssc.TableService port = service.getTableServicePort();
        return port.getCount(dbName, tableName, userName, password);
    }
    
    
}
