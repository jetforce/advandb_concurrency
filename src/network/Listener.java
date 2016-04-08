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
    private String name= "";
    private Middle m;
    private BufferedWriter writer;
    
    public Listener(Socket soc, Middle m) throws IOException{
        this.mysocket = soc;
        this.life = true;   
        this.name = "";
        this.m=m;
        this.writer = new BufferedWriter( new OutputStreamWriter(soc.getOutputStream())); 
    }
    
    public Listener(Socket soc,Middle m,String name ) throws IOException{
        this.mysocket = soc;
        this.life = true;   
        this.name = name;
        this.m =m;
        this.writer = new BufferedWriter( new OutputStreamWriter(soc.getOutputStream())); 
    }
    
    public void sendName() throws IOException{
        writer.write(this.name+"\n");
        writer.flush();
        System.out.println("Wrote");
    }
    
    public boolean sendMessage(String message){     
        try {
            //System.out.println("I WROTE HERE "+this.name);
            writer.write(message+"\n");
            writer.flush();
            return true;
        } catch (IOException ex) {
            life = false;
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public void run(){   
        
        String line;
        String inAll = "";
        
        try {
            
          
            this.reader = new BufferedReader(new InputStreamReader(this.mysocket.getInputStream()));
            if(this.name.isEmpty()){
                     
                this.name = this.reader.readLine();
                
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
                inAll=inAll + line +"\n";
                if(line.isEmpty()){
                    System.out.println("Al:" +inAll);
                    m.addTask(inAll);
                    inAll = "";
                    //execute whatever here
                }
                
            }
                
        } catch (IOException ex) {
            life = false;
            System.out.println(this.name + " One connection died");
        }
    }
   
}
