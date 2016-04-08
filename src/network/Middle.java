/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import advandb_concurrency.UI;
import dboperations.Receiver;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import threadpool.ThreadPool;

/**
 *
 * @author Jet
 */
public class Middle {
 
    private Listener main;
    private Listener palawan;
    private Listener marinduque;
    private String name;
    private ThreadPool pool;
    private BufferedWriter local_write = null;
    private UI ui;
    
    public Middle(String name, ThreadPool pool,UI ui){
        this.ui = ui;
        this.pool = pool;
        this.name = name;
        this.main = null;
        this.palawan = null;
        this.marinduque = null;
        
       
    }    
    
    
    public void local_write_multiple(int times, String query){
        ReadSender sender= new ReadSender(times,query,local_write);
        sender.start();
    }
    
    
    public void local_writ(String query){
        try {
            local_write.write(query+"\n");
            local_write.flush();
        } catch (IOException ex) {
            System.out.println("Unable to listen self");
            Logger.getLogger(Middle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void setLocal(BufferedWriter writer){
        this.local_write = writer;
    }
    
    public void addTask(String q){
        pool.putTask(new Receiver(q,this.ui));
    }
    
    
    public boolean sendMain(String query){  
      if(this.main != null){
          return this.main.sendMessage(query);
      } return false; 
    }
    
    
    public boolean sendPalawan(String query){
        if(this.palawan!=null){
            return this.palawan.sendMessage(query);
        }return false;
    }
    
    public boolean sendMarinduque(String query){
        if(this.marinduque!=null){
            return this.marinduque.sendMessage(query);
        }return false;
    }
    
    
    
    public void connect(Socket socket) throws IOException{
        Listener l = new Listener(socket,this);
        l.start();      
    }
    
    public void connectMain(Listener l){
        this.main = l;
        System.out.println(this.name +"connected to "+"main");
        
    }
    
    public void connectPalawan(Listener l){
        this.palawan = l;
        System.out.println(this.name +"connected to "+"Palawan");
    }
    
    public void connectMarinduque(Listener l ){
        this.marinduque = l;
        System.out.println(this.name +"connected to "+"Marinduque");
    }
    
    
    public void connectMain(Connector c) throws IOException{
        
        if(this.main == null){
            Listener l = new Listener(c.getSocket(),this,"main");
            l.sendName();
            this.main = l;
            l.start();
            System.out.println(this.name +"connected to "+"main");
        }else if(!this.main.isAlive()){
            Listener l = new Listener(c.getSocket(),this,"main");
            l.sendName();
            this.main = l;
            l.start();
            System.out.println(this.name +"connected to "+"main");
        }

        
    }
    
    public void connectPalawan(Connector c) throws IOException{
        if(this.palawan==null){
            Listener l = new Listener(c.getSocket(),this,"palawan");
            l.sendName();
            this.palawan = l;
            l.start();
            System.out.println(this.name +"connected to "+"Palawan");
        }else if(!this.palawan.isAlive()){
            Listener l = new Listener(c.getSocket(),this,"palawan");
            l.sendName();
            this.palawan = l;
            l.start();
            System.out.println(this.name +"connected to "+"Palawan");
        }
    }
    
    public void connectMarinduque(Connector c) throws IOException{
        
        if(this.marinduque==null){
            Listener l = new Listener(c.getSocket(),this,"marinduque");
            l.sendName();
            this.marinduque = l;
            l.start();
            System.out.println(this.name +"connected to "+"Marinduque");
        }else if(!this.marinduque.isAlive()){
            Listener l = new Listener(c.getSocket(),this,"marinduque");
            l.sendName();
            this.marinduque = l;
            l.start();
            System.out.println(this.name +"connected to "+"Marinduque");
        }

    }
    
    
    
}
