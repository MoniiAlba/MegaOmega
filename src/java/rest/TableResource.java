/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import beans.TableResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author hca
 */
@Path("table")
public class TableResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TableResource
     */
    public TableResource() {
    }

    /**
     * Retrieves representation of an instance of rest.TableResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        //TODO return proper representation object
        return "TableResource";
    }

    /**
     * PUT CREATE TABLE
     * @param content representation for the resource
     */
    @PUT
    @Produces(MediaType.APPLICATION_XML)
    public  TableResponse putXml(
            @FormParam("userName") String userName, 
            @FormParam("tableName") String tableName, 
            @FormParam( "fields") String fields, 
            @FormParam("dbName") String dbName, 
            @FormParam("password") String password){
        //TODO return proper representation object
        boolean wsRes = createTable(userName, tableName, fields, dbName, password);
        TableResponse res;
        if(wsRes)
        res = new TableResponse("ok", "Tabla creada");
        else
            res = new TableResponse("error", "Error creacion tabla");
        return res;
    }

    private static boolean createTable(java.lang.String userName, java.lang.String tableName, java.lang.String fields, java.lang.String dbName, java.lang.String password) {
        tablewssc.TableService_Service service = new tablewssc.TableService_Service();
        tablewssc.TableService port = service.getTableServicePort();
        return port.createTable(userName, tableName, fields, dbName, password);
    }
}
