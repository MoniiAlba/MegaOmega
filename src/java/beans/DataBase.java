/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author soeur
 */
@XmlRootElement(name = "db")
public class DataBase {
    private String name;
    private ArrayList<String> tables;

    public DataBase() {
    }
    
    public DataBase(String name, ArrayList<String> tables) {
        this.name = name;
        this.tables = tables;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getTables() {
        return tables;
    }

    @XmlElement
    public void setTables(ArrayList<String> tables) {
        this.tables = tables;
    }

    @Override
    public String toString() {
        return "Base de datos: "+this.getName() + "\n Tablas: "+this.getTables().toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
