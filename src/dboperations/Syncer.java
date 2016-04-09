/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dboperations;

import dbcon.Data;
import java.sql.PreparedStatement;
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
                "transaction_id,place_id,query_stmt FROM transactions where synced = 0;";
                
             String update = "UPDATE "+
                    "transactions "+
                    "SET synced = 1 "+
                    "WHERE transaction_id = ";
                            
        
        
            Statement s = null;
            PreparedStatement s2 = null;
            ResultSet rs = null;

            int id,t_id = 0;
            String stmt;
            String[] query_list;
            String formed_query;
            try {
                s = Data.con.createStatement();
                s.execute(getMaxQuery);
                rs = s.getResultSet();
                
                
                
                
                while(rs.next()){
                    t_id = rs.getInt("transaction_id");
                    id = rs.getInt("place_id");
                    stmt =rs.getString("query_stmt");
                    
                    formed_query = stmt.substring(0, stmt.indexOf(" "));
                    formed_query+= "\n";
                    formed_query+= stmt.substring(stmt.indexOf(" "), stmt.length()) +"\n";
                    
                    System.out.println("stmt is "+formed_query);
                    if(this.m.sendMain(formed_query)){
                        s2 = Data.con.prepareStatement(update+" "+t_id);
                        s2.executeUpdate();
                        
                        
                        System.out.println("sucess" +update+" "+id+"\n");
                    }else{
                        System.out.println("Main closed");
                        return;
                    }
                    
                }
                    
            } catch (SQLException ex) {
                System.out.println("Error in getting max");
            }
        
  
                   
        }
        
        
         public void Sync_with_palawanmarin(){
            
  
        String getMaxQuery =
                "SELECT\n" +
                "transaction_id,place_id,query_stmt FROM transactions where synced = 0;";
                
             String update = "UPDATE "+
                    "transactions "+
                    "SET synced = 1 "+
                    "WHERE transaction_id = ";
                            
        
        
            Statement s = null;
            PreparedStatement s2 = null;
            ResultSet rs = null;

            int id,t_id = 0;
            String stmt;
            String[] query_list;
            String formed_query;
            try {
                s = Data.con.createStatement();
                s.execute(getMaxQuery);
                rs = s.getResultSet();
                boolean b;
                
                
                
                while(rs.next()){
                    t_id = rs.getInt("transaction_id");
                    id = rs.getInt("place_id");
                    stmt =rs.getString("query_stmt");
                    
                    formed_query = stmt.substring(0, stmt.indexOf(" "));
                    formed_query+= "\n";
                    formed_query+= stmt.substring(stmt.indexOf(" "), stmt.length()) +"\n";
                    
                    System.out.println("stmt is "+formed_query);
                    
                    if(id ==1){
                        b = this.m.sendMarinduque(formed_query);
                    }else b = this.m.sendPalawan(formed_query);
                    
                    if(b){
                        s2 = Data.con.prepareStatement(update+" "+t_id);
                        s2.executeUpdate();
                        
                        
                        System.out.println("sucess" +update+" "+id+"\n");
                    }else{
                        System.out.println("Main closed");
                        return;
                    }
                    
                }
                    
            } catch (SQLException ex) {
                System.out.println("Error in getting max");
            }
        
  
                   
        }
        
        
}
