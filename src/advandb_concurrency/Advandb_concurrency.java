/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advandb_concurrency;

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
        
        
        try{
             Middle m2 = new Middle();
             Server s = new Server(1234,"main",m2);
             s.start();
        }catch(Exception e){
            System.out.println("Unable to start server");
        }
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Advandb_concurrency.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Middle m =new Middle();
        Connector c;
        c = new Connector("localhost",1234,"main",m);
        c.Connect();
        
        
        c = new Connector("localhost",1234,"palawan",m);
        c.Connect();
        
        
        
        
        
    }
    
}
