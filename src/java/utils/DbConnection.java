/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author soeur
 */
public class DbConnection {
    private Connection con;
    private Statement stmt;

    public DbConnection(String db, String user, String password) {
        try { 
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            this.con = DriverManager.getConnection(
                                "jdbc:derby://localhost:1527/"+db+";create=true;",
                                user,
                                password); 
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found: "+ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
    public void createDb(String db, String user, String password) throws SQLException{
        Connection c = DriverManager.getConnection(
                                "jdbc:derby://localhost:1527/"+db+";create=true;",
                                user,
                                password);
        c.close();
    }

    public Connection getCon() {
        return con;
    }

    public Statement getStmt() {
        try {
            if(this.stmt == null)
                this.stmt = this.con.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stmt;
    }
    
    public void closeResources(){
        try{
            if(this.stmt!=null)
               this.stmt.close();
         }catch(SQLException se2){
         }// nothing we can do
         try{
            if(this.con!=null)
               this.con.close();
         }catch(SQLException se){
            se.printStackTrace();
         }
    }
    
    public static void main(String[] args) throws SQLException {
//       Connection c =  DriverManager.getConnection(
//                                "jdbc:derby://localhost:1527/"+"p2"+";create=true;",
//                                "p1",
//                                "p1");
//       c.close()

    DbConnection db = new DbConnection("Omega","root","root");
    //db.createDb("p3", "p3", "p3");
        //System.out.println("Create db ");
    }
}
