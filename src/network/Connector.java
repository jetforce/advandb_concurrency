/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jet
 */
public class Connector {
   
    private Socket socket;
    private String myname;
    private String urname;
    private Middle m;
    private String address;
    private int port;
    
    public Connector(String address,int port,String name,String urname, Middle m){
        
        this.address = address;
        this.port = port;
        this.myname = name;
        this.m = m;
        this.urname = urname;
    }
    
    public void Connect(){
        
        try {
            this.socket = new Socket(address,port);
             
            switch(urname){
                case "main": m.connectMain(this);
                    break;
                case "palawan":m.connectPalawan(this);
                    break;
                case "marinduque":m.connectMarinduque(this);
                    break;
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    public Socket getSocket(){
        return this.socket;
    }
    
    
}
