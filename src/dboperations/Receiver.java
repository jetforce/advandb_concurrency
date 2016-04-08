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
            
            if(type.equals("UPDATE")) {
                s = Data.con.prepareStatement(query);
                s.executeUpdate();
            }
            else if(type.equals("DELETE")) {
                s = Data.con.prepareStatement(query);
                s.executeUpdate();
            }
            else {
                System.out.println("Error in TYPE: " + type);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error in EXECUTE: UI.java");
        }
    }
    
}
