/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author soeur
 */
public class TableManager {
    private String tableName;
    private DbConnection conn;
    private ResultSet rs;
    ArrayList<TableField> fields;
    
    //Acces existing table by name
    public TableManager(String tableName, String db,String user, String password) throws Exception{
        this.conn = new DbConnection(db, user, password);
        this.tableName = tableName;
        
        Statement st = conn.getStmt();
        rs = st.executeQuery("SELECT * FROM SYS.SYSTABLES where tabletype ='T' and tablename = '"+tableName+"'");
        System.out.println("[Table Manager]: " +"SELECT * FROM SYS.SYSTABLES where tabletype ='T' and tablename = '"+tableName+"'" );
        if(!rs.next())
            throw new Exception("[Table Manager]: Non existing table");
        else
            setFields();
    }

    //Retrieve column names and pk and save them in fields attribute
    private void setFields(){
        fields = new ArrayList<>();
        String pkName;
        try {
            DatabaseMetaData mt = conn.getCon().getMetaData();
            ResultSet cols = mt.getColumns(null,null, tableName, null);
            //System.out.println("------------PRIMARY KEYS-------------");
            while(cols.next()){
                fields.add(new TableField(cols.getString("COLUMN_NAME"), cols.getString("DATA_TYPE"),false));
            }
            ResultSet rs = mt.getPrimaryKeys(null,null, tableName);
            //System.out.println("------------PRIMARY KEYS-------------");
            if(rs.next()){
                pkName = rs.getString("COLUMN_NAME");
                for(TableField f: fields){
                    if(f.name.equals(pkName))
                        f.isPrimaryKey = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    //Create new table by providing List of TableFields
    public TableManager(String tableName, String db,String user, String password, ArrayList<TableField> fields) throws Exception{
        this.conn = new DbConnection(db, user, password);
        this.tableName = tableName;
        TableField pk = null;
        
        Statement st = conn.getStmt();
        //StringBuilder sql = new StringBuilder("create table p2 (id INTEGER)"); 
        StringBuilder sql = new StringBuilder(); 
        sql.append("CREATE TABLE ");
        sql.append(tableName);
        sql.append(" (");
        sql.append("\n ");
        for( TableField f : fields){
            sql.append(f.name);
            sql.append(" ");
            sql.append(f.type);
            sql.append(", ");
            sql.append("\n ");
            if(f.isPrimaryKey)
                pk = f;
        }
        sql.append("PRIMARY KEY ( ");
        sql.append(pk.name);
        sql.append(" ))");

        Logger.getLogger(TableManager.class.getName()).log(Level.INFO,"[Table Manager]:"+ sql.toString());
        Logger.getLogger(TableManager.class.getName()).log(Level.INFO, "[Table Manager]: Created table "+tableName);
        //System.out.println(sql.toString());
        st.executeUpdate(sql.toString());
        setFields();
    }
    
    private TableField getPk(){
        TableField res = null;
        for(TableField f: fields){
            if( f.isPrimaryKey )
                res = f;
        }
        return res;
    }
    
    public ArrayList<HashMap<String,String>> getRecords(int start, int end) throws SQLException{
        ArrayList<HashMap<String,String>> res = new ArrayList<>();
        HashMap<String, String> it ;
        Statement q = conn.getStmt();
        TableField pk = getPk();
        String sql = "SELECT * FROM "+tableName+" ORDER BY "+pk.name+" OFFSET "
                + start+ " ROWS FETCH NEXT "+end+ " ROWS ONLY";
        //System.out.println(sql);
        ResultSet rs = q.executeQuery(sql);
        while( rs.next() ){
            it = new HashMap<>();
            for(TableField f : fields){
                it.put(f.name, rs.getString(f.name));
                //System.out.print(f.name +" :" + rs.getString(f.name) + ";");

            }
            res.add(it);
           // System.out.println("");
        }
        
        return res;
    }
    private TableField getFieldByName(String name){
        TableField res = null;
        
        for(TableField f: fields){
            if( f.name.equals(name) )
                res = f;
        }
        
        return res;
    }
    public void insertRecord(HashMap<String, String> values) throws SQLException{
        Statement q = conn.getStmt();
        String sql = "INSERT INTO "+ tableName + " ( ";
        StringBuilder cols = new StringBuilder();
        StringBuilder vals = new StringBuilder();
        
        for(String key: values.keySet()){
            cols.append(key);
            cols.append(", ");
            
            //Checa si el valor es un varchar y necesita comilla simple (')
            //por ahora el cliente debe mandar el valor con commilla simple 
//            if(Integer.parseInt(getFieldByName(key).type) == Types.VARCHAR ){
//                vals.append("'");
//                vals.append(values.get(key));
//                vals.append("'");
//            }else{
//                vals.append(values.get(key));
//            }
            vals.append(values.get(key));
            vals.append(", ");
        }
        cols.deleteCharAt(cols.length()-2);
        vals.deleteCharAt(vals.length()-2);
        sql = sql + cols.toString() + " ) " + " VALUES ( " + vals.toString() + ") ";
        //System.out.println(sql);
        q.executeUpdate(sql);
        
    }
    
    public void updateRecord(HashMap<String, String> values, String pk) throws SQLException{
        Statement q = conn.getStmt();
        String sql = "UPDATE "+ tableName + " SET ";
        StringBuilder aux = new StringBuilder();
        StringBuilder vals = new StringBuilder();
        
        for(String key: values.keySet()){
            aux.append(key);
            aux.append(" = ");
            aux.append(values.get(key));
            aux.append(", ");
        }
        aux.deleteCharAt(aux.length()-2);
        sql = sql + aux.toString() + " WHERE " + getPk().name +" = " + pk;
        System.out.println("[Table Manager]: " + sql);
        q.executeUpdate(sql);
        
    }
    
    public void deleteRecord(String pk) throws SQLException{
        Statement q = conn.getStmt();
        String sql = "DELETE FROM  "+ tableName + " where " +getPk().name +" = " + pk;
        //System.out.println(sql);
        q.executeUpdate(sql);
    }
    

    
    public static void main(String[] args) throws Exception{
        

    }
}
