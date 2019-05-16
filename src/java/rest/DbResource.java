/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import beans.DataBase;
import dbwsc.Exception_Exception;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author soeur
 */
@Path("db")
public class DbResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DbResource
     */
    public DbResource() {
    }

    /**
     * Retrieves representation of an instance of rest.DbResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/xml")
    public String getXml() {
        //TODO return proper representation object
        return "Database Service";
    }

    /**
     * PUT method for updating or creating an instance of DbResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @POST
    @Produces(MediaType.APPLICATION_XML)
    public  DataBase postXml(@FormParam("dbName")String dbName, @FormParam("userName")String userName, @FormParam("password")String psswrd) throws Exception {
        //TODO return proper representation object
        System.out.println("[DbResource]: "+dbName+" "+ userName+" "+psswrd);
        ArrayList <String> ans = getTableName(dbName, userName, psswrd);
        System.out.println("Resp: "+ans.toString());
        DataBase db = new DataBase();
        db.setName(dbName);
        db.setTables(ans);
        System.out.println("Base a responder: "+db.toString());
        return db;
    }

    private static java.util.ArrayList<java.lang.String> getTableName(java.lang.String dbName, java.lang.String userName, java.lang.String password) throws Exception_Exception {
        dbwsc.DataBaseService_Service service = new dbwsc.DataBaseService_Service();
        dbwsc.DataBaseService port = service.getDataBaseServicePort();
        return (ArrayList<String>) port.getTableName(dbName, userName, password);
    }
}
