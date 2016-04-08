/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Jet
 */
public class Connector {
   
    private Socket socket;
    
    public Connector(String address,int port) throws IOException{
        this.socket = new Socket(address,port);    
    }
    
    
    
    
}
