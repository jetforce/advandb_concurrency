/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advandb_concurrency;

import dboperations.Query;
import dboperations.QueryCreator;
import java.io.IOException;
import java.util.ArrayList;
import network.Connector;

/**
 *
 * @author Jet
 */
public class MainNode extends Node{

    public MainNode(UI ui) throws IOException {
        super("main", 1234, ui);
    }
    
        public void activate() throws IOException{   
        this.server.start();
        Connector c = new Connector("localhost", this.port ,this.name,"main",this.middle);
        Connector c2 = new Connector("192.168.1.19",1235,this.name,"marinduque",this.middle);
        
        c.ConnectSelf(this.port);
        c2.Connect();
    }
    
    
    
    @Override
    public void sendMain(){
        ArrayList<Query> queries = new ArrayList<>();
        QueryCreator qc = new QueryCreator();
        int n = Integer.parseInt(ui.deleteField.getText());
        queries = qc.delete(n);
        super.middle.multiple_updateMarinduquePalawan(queries,1);
        
    }
    
    
    
}
