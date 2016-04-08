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
    
    public Node(String name,int port) throws IOException{
        this.middle = new Middle(name);
        this.port = port;
        this.name = name;
        this.server = new Server(port,name,this.middle);  
    }
     
    public Node(String name,int port,UI ui) throws IOException{
        this.ui = ui;
        this.middle = new Middle(name);
        this.port = port;
        this.name = name;
        this.server = new Server(port,name,this.middle);  
    }
    public void activate(){
        this.server.start();
        Connector c = new Connector("localhost", 1234 ,"main",this.middle);
        c.Connect();
    }
    
    
    
}
