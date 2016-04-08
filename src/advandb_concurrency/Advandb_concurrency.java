/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advandb_concurrency;

import dboperations.Receiver;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import network.Connector;
import network.Middle;
import network.Server;

/**
 *
 * @author Jet
 */
public class Advandb_concurrency {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String testQuery = 
                "UPDATE \n transactions "
                + " SET synced = 1 "
                + " WHERE transaction_id = 1"
                + " AND place_id = 1";
        Receiver r = new Receiver(testQuery);
        r.work();
        
        try{
            
            Node n = new Node("main", 1234,new UI());
            n.activate();
            
            /*
            String query_stmt = 
            "\"SELECT COUNT(*) FROM fact;\"";
            String testQuery = 
            "INSERT\n" +
            "INTO transactions (place_id, query_stmt, synced)\n" +
            "VALUES (1, " + query_stmt + ", 0);";
        Receiver r = new Receiver(testQuery);
        r.work();
            */
            /*
            Node n2 = new Node("palawan", 1235);
            n2.activate();
            */
            
            
        }catch(Exception e){
            System.out.println("Unable to start server");
        }        
    }
    
}
