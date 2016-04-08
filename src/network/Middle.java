/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.net.Socket;

/**
 *
 * @author Jet
 */
public class Middle {
 
    private Listener main;
    private Listener palawan;
    private Listener marinduque;
    
    public Middle(){
        
        this.main = null;
        this.palawan = null;
        this.marinduque = null;
       
    }    
    
    public void connect(Socket socket){
        Listener l = new Listener(socket,this);
        l.start();      
    }
    
    public void connectMain(Listener l){
        this.main = l;
    }
    
    public void connectPalawan(Listener l){
        this.palawan = l;
    }
    
    public void connectMarinduque(Listener l ){
        this.marinduque = l;
    }
    
   
}
