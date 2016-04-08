/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
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
    
    public Connector(){
        
    }
    
    
    public Connector(String address,int port,String name,String urname, Middle m){
        this.urname = urname;
        this.address = address;
        this.port = port;
        this.myname = name;
        this.m = m;
    }
    
    public void ConnectSelf(int port) throws IOException {
        
            this.socket = new Socket("localhost",port);
            BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(socket.getOutputStream())); 
            writer.write(myname+"\n");
            writer.flush();
            this.m.setLocal(writer);
            
    }
    
    
    public void Connect(){
        
        try {
            this.socket = new Socket(address,port);
            System.out.println("connected! " +this.myname);
            switch(this.urname){
                case "main": System.out.println("Connecting to main");
                    m.connectMain(this);
                    break;
                case "palawan"://System.out.println("Connecting to palawan");
                    m.connectPalawan(this);
                    break;
                case "marinduque"://System.out.println("Connecting to marinduque");
                    m.connectMarinduque(this);
                    break;
            }
            
        }catch(ConnectException e){
            System.out.println("Unable to connect to "+this.myname);
        }catch (IOException ex) {
            System.out.println("Failed to connect");
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    public Socket getSocket(){
        return this.socket;
    }
    
    
}
