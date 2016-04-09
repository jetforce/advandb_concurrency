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
import network.Middle;

/**
 *
 * @author Jet
 */
public class Syncer {
    
      private Middle m;
        
        public Syncer(Middle m){
            this.m = m;
        }
        
        
        public void Sync_with_main(){
            
  
        String getMaxQuery =
                "SELECT\n" +
                "place_id,query_stmt FROM transactions where synced = 0;";
        
             String update = "UPDATE "+
                    "transactions "+
                    "SET synced = 1 "+
                    "WHERE transaction_id = ";
                            
        
        
            Statement s = null;
            ResultSet rs = null;

            int id = 0;
            String stmt;
            try {
                s = Data.con.createStatement();
                s.execute(getMaxQuery);
                rs = s.getResultSet();

                while(rs.next()){
                    id = rs.getInt("place_id");
                    stmt =rs.getString("query_stmt");


                    if(this.m.sendMain(stmt)){
                        s = Data.con.createStatement();
                        s.executeUpdate(update+" "+id );
                        
                    }else{
                        return;
                    }
                    
                }
                    
            } catch (SQLException ex) {
                System.out.println("Error in getting max");
            }
        
  
                   
        }
        
        
}
