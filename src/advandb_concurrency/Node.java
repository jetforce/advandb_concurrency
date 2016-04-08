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
    
    private Middle middle;
    private Server server;
    private String name;
    private int port;
    private UI ui;
    
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
     
    public Node(String name,int port) throws IOException{
        this.executor = new ThreadPool(8,1000);
        this.executor.start();
        //this.ui = ui;
        this.middle = new Middle(name,executor,this.ui);
        this.port = port;
        this.name = name;
        this.server = new Server(port,name,this.middle);  
    }
    
    
    
     
    public void activate(UI ui) throws IOException{
        this.ui = ui;
        this.server.start();
        this.ui.startUI();
        Connector c = new Connector("localhost", this.port ,"main",this.middle);
        c.ConnectSelf(this.port);
    }
    
    public void readSelf(int times , String Query){
        this.middle.local_write_multiple(times, Query);
    }
    
    
    
    
    
}
