/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advandb_concurrency;

import dboperations.QueryCreator;
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
        
        
        
        try {
            
            UI ui =  new UI();
            //Node n = new Node("marinduque",1234,ui);
            MainNode n = new MainNode(ui);
            ui.startUI(n);
            n.activate();
            
            
        } catch (IOException ex) {
            Logger.getLogger(Advandb_concurrency.class.getName()).log(Level.SEVERE, null, ex);
        }
            
   
    }
    
}
