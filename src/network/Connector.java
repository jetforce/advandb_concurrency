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
    
    public Connector(String address,int port,String name, Middle m){
        this.address = address;
        this.port = port;
        this.myname = name;
        this.m = m;
    }
    
    public void Connect(){
        
        try {
            this.socket = new Socket(address,port);
            System.out.println("connected!");
            switch(this.myname){
                case "main": System.out.println("Connecting to main");
                    m.connectMain(this);
                    break;
                case "palawan":System.out.println("Connecting to palawan");
                    m.connectPalawan(this);
                    break;
                case "marinduque":System.out.println("Connecting to marinduque");
                    m.connectMarinduque(this);
                    break;
            }
            
        } catch (IOException ex) {
            System.out.println("Failed to connect");
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    public Socket getSocket(){
        return this.socket;
    }
    
    
}
