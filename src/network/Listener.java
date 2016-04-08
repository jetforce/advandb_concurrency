/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jet
 */
public class Listener extends Thread{
    
    private BufferedReader reader;
    private Socket mysocket;
    private boolean life;
    private String name= null;
    private Middle m;
    private BufferedWriter writer;
    
    public Listener(Socket soc, Middle m) throws IOException{
        this.life = true;   
        this.name = "";
        this.writer = new BufferedWriter( new OutputStreamWriter(soc.getOutputStream())); 
    }
    
    public Listener(Socket soc,Middle m,String name ) throws IOException{
        this.life = true;   
        this.name = name;
        this.writer = new BufferedWriter( new OutputStreamWriter(soc.getOutputStream())); 
    }
    
    public boolean sendName(){
        try {
            writer.write(this.name+"\n");
        } catch (IOException ex) {
            this.life = false;
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
        return true;
    }
    
    
    public void run(){   
        
        String line;
        
        try {
            this.reader = new BufferedReader(new InputStreamReader(this.mysocket.getInputStream()));
            
            if(this.name.isEmpty()){
                this.name = this.reader.readLine();
                System.out.println("received "+this.name);
                switch(name){
                    case "main": m.connectMain(this);
                        break;
                    case "palawan":m.connectPalawan(this);
                        break;
                    case "marinduque":m.connectMarinduque(this);
                        break;
                }
            }

            
            
            while((line= this.reader.readLine()) != null){
                System.out.println(this.name+" received "+line);                       
            }
                
        } catch (IOException ex) {
            life = false;
            System.out.println(this.name + " One connection died");
        }
    }
   
}
