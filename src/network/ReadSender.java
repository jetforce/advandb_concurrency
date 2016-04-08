/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jet
 */
public class ReadSender extends Thread {
    
    private int times;
    private String query;
    private BufferedWriter writer;
    
    public ReadSender(int times, String query, BufferedWriter writer){
        this.times= times;
        this.query=  query;
        this.writer = writer;
    }
    
    @Override
    public void run(){
        
        for(int i=0; i< times; i++){   
            try {
                System.out.println("sending");
                this.writer.write(query+"\n");
                this.writer.flush();
            } catch (IOException ex) {
                System.out.println("failed local write");
                Logger.getLogger(ReadSender.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    
}
