/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

/**
 *
 * @author soeur
 */
public class RestClient {
    private Client client;
    private WebTarget webtarget;
    private static final String URI = "http://localhost:8080/MegaOmega/webresources/";
    
    public RestClient(){
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webtarget = client.target(URI).path("auth");
    }
    
    public String postHtml(String userName, String password){
        
        Form form = new Form();
        form.param("userName", userName);
        form.param("password", password);
        Response resp = webtarget.request().post(Entity.form(form));
        String body = resp.readEntity(String.class);
        resp.close();
        return body;
    }
    
    public String putHtml(String userName, String password, String dbName){
        Form form = new Form();
        form.param("userName", userName);
        form.param("password", password);
        form.param("dbName", dbName);
        Response resp = webtarget.request().put(Entity.form(form));
        String body = resp.readEntity(String.class);
        System.out.println("Resp: "+body);
        resp.close();
        return body;
    }
}
