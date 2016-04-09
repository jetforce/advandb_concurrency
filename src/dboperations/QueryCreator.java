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
import java.util.ArrayList;
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
    
    
    public String addTransaction(String query_stmt, int place_id) {
        String testQuery = 
            "INSERT\n" +
            "INTO transactions (place_id, query_stmt, synced)\n" +
            "VALUES (" + place_id + ", \" " + query_stmt + " \", 0);\n";
        //Receiver r = new Receiver(testQuery);
        //r.work();
        return testQuery;
    }
    
    
    
    
    
    
    public ArrayList<Query> delete(int n) {
        ArrayList<Query> queries = new ArrayList<>();
        int x[] = getMax();
        int max = x[0];
        int place_id = x[1];
        for(int i = 0; i < n; i++) {
            String deleteQuery = 
                "DELETE\n" +
                "FROM location " +
                "WHERE house_id = " + max + "\n";
            queries.add(new Query(deleteQuery, place_id));
            max--;
        }
        return queries;
    }
    
    private int[] getMax() {
        String getMaxQuery =
                "SELECT\n" +
                "MAX(house_id) as max, place_id FROM location;";
        
        Statement s = null;
        ResultSet rs = null;
        
        //int max = 0, place_id;
        int x[] = new int[3];
        
        try {
            s = Data.con.createStatement();
            s.execute(getMaxQuery);
            rs = s.getResultSet();
            
            if(rs.next()) {
                x[0] = rs.getInt("max");
                x[1] = rs.getInt("place_id");
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
        return x;
    }
    
}
