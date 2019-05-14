/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author soeur
 */
public class DBManager {

    private DbConnection conn;
    private ResultSet rs;
    
    public DBManager() {
    }
    
    public ArrayList <String> getTableName(String dbName, String user, String psswrd){
        try {
            this.conn = new DbConnection(dbName, user, psswrd);
            Statement st = conn.getStmt();
            rs = st.executeQuery("SELECT TABLENAME FROM SYS.SYSTABLES where tabletype ='T'");
            
            ArrayList <String> tablas = new ArrayList<>();
            while(rs.next()){
                tablas.add(rs.getString("TABLENAME"));
                System.out.println("Tabla añadida: "+rs.getString("TABLENAME"));
            }
            return tablas;
            
        } catch (SQLException ex) {
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
}
