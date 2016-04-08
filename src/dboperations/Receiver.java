/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dboperations;

import advandb_concurrency.UI;
import dbcon.Data;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import threadpool.Task;

/**
 *
 * @author Jet
 */
public class Receiver implements Task{
    
    private String query;
    
    public static void main(String args[]) {
    }
    
    private UI ui;
    
    public Receiver(String query,UI ui){
        this.query = query;
        this.ui = ui;
    }
    
    @Override
    public void work() {
        PreparedStatement s = null;
        String type = query.substring(0, query.indexOf("\n")).trim().toUpperCase();
        System.out.println(" > TYPE: " + type);
        System.out.println(" > QUERY: " + query);
        Date utilDate = new Date();
     
       // display time and date using toString()
 
        try {
            
            switch (type) {
                case "UPDATE":
                    this.ui.addInfo( new java.sql.Timestamp(utilDate.getTime()) +" UPDATE : "+ query);
                    s = Data.con.prepareStatement(query);
                    s.executeUpdate();
                    break;
                case "DELETE":
                    this.ui.addInfo(new java.sql.Timestamp(utilDate.getTime())+ " DELETE : "+ query);
                    s = Data.con.prepareStatement(query);
                    s.executeUpdate();
                    break;
                case "SELECT":
                    
                    this.ui.addInfo(new java.sql.Timestamp(utilDate.getTime()) + " SELECT : "+query);
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
            System.out.println(ex.toString());
        }
    }
    
}
