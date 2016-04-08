/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dboperations;

import dbcon.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 *
 * @author Jet
 */
public class QueryCreator {
    
    public void read() {
        
    }
    
    public void update() {
        
    }
    
    public String delete() {
        String deleteQuery = 
            "DELETE\n" +
            "FROM survey " +
            "WHERE house_id = " + getRandomNum();
        return deleteQuery;
    }
    
    private int getMax() {
        String getMaxQuery =
                "SELECT\n" +
                "MAX(house_id) as max FROM family;";
        
        Statement s = null;
        ResultSet rs = null;
        
        int max = 0;
        try {
            s = Data.con.createStatement();
            s.execute(getMaxQuery);
            rs = s.getResultSet();
            
            if(rs.next())
                max = rs.getInt("max");
        } catch (SQLException ex) {
            System.out.println("Error in getting max");
        }
        
        return max;
    }
    
    private int getRandomNum() {
        Random rand = new Random();
        
        int x = rand.nextInt(getMax()) + 1;
        
        System.out.println(" > random num: " + x);
        
        return x;
    }
    
}
