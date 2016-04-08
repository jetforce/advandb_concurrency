/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jet
 */
public class Server extends Thread{
    
    private ServerSocket server;
    private int port;
    private boolean life;
    private Middle middle;
    private String name;
    
    
    public Server(int port,String name) throws IOException{
        this.name = name;
        this.middle = new Middle();
        this.life = true;
        this.port = port;
        this.server = new ServerSocket(port);
    }
    
    public void run(){
        
        Socket socket;
        
        while(this.life){     
            try {  
                socket= this.server.accept();
                this.middle.connect(socket);    
                System.out.println("Resiv connect");
            } catch (IOException ex) {
                System.out.println("Failed to accept connection");
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
    }
    
    
    
    
}
