/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advandb_concurrency;

import java.io.IOException;
import network.Connector;
import network.Middle;
import network.Server;
import threadpool.ThreadPool;

/**
 *
 * @author Jet
 */
public class Node {
    
    protected Middle middle;
    protected Server server;
    protected String name;
    protected int port;
    protected UI ui;
    
    public ThreadPool executor;
    /*
    public Node(String name,int port) throws IOException{
        this.executor = new ThreadPool(8,1000);
        this.executor.start();
        this.middle = new Middle(name,executor);
        this.port = port;
        this.name = name;
        this.server = new Server(port,name,this.middle);  
    }*/
     
    public Node(String name,int port,UI ui) throws IOException{
        this.executor = new ThreadPool(8,1000);
        this.executor.start();
        this.ui = ui;
        this.middle = new Middle(name,executor,this.ui);
        this.port = port;
        this.name = name;
        this.server = new Server(port,name,this.middle); 
    }
    
    
    
     
    public void activate() throws IOException{
       
        
        this.server.start();
        Connector c = new Connector("localhost", this.port ,this.name,"main",this.middle);
        Connector c2 = new Connector("192.168.1.19",1235,this.name,"marinduque",this.middle);
        
        c.ConnectSelf(this.port);
        c2.Connect();
    }
    
    public void readSelf(int times , String Query){
        this.middle.local_write_multiple(times, Query);
    }
    
    public void sendMain(){

       System.out.println("Hello");
    }
    
    
    
}
