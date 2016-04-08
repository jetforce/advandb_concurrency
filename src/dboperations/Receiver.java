/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dboperations;

import dbcon.Data;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import threadpool.Task;

/**
 *
 * @author Jet
 */
public class Receiver implements Task{
    
    private String query;
    
    public static void main(String args[]) {

    }
    
    public Receiver(String query){
        this.query = query;
    }
    
    @Override
    public void work() {
        PreparedStatement s = null;
        String type = query.substring(0, query.indexOf("\n")).trim();
        System.out.println(" > TYPE: " + type);
        System.out.println(" > QUERY: " + query);
       
        try {
            
            switch (type) {
                case "UPDATE":
                    s = Data.con.prepareStatement(query);
                    s.executeUpdate();
                    break;
                case "DELETE":
                    s = Data.con.prepareStatement(query);
                    s.executeUpdate();
                    break;
                case "SELECT":
                    s = Data.con.prepareStatement(query);
                    s.execute();
                    break;
                case "INSERT":
                    s = Data.con.prepareStatement(query);
                    s.execute();
                    break;
                default:
                    System.out.println("Error in TYPE: " + type);
                    break;
            }
            
        } catch (SQLException ex) {
            System.out.println("Error in EXECUTE: UI.java");
        }
    }
    
}
