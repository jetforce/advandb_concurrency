/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import dboperations.Query;
import dboperations.QueryCreator;
import java.util.ArrayList;

/**
 *
 * @author Jet
 */
public class UpdateSenderMain extends Thread{
    
    private ArrayList<Query> q;
    private Middle m;
    private QueryCreator qc = new QueryCreator();
    private int id;
    
    public UpdateSenderMain(ArrayList<Query> queries, Middle m, int id){
        this.q = queries;
        this.m = m;
        this.id = id;
    }
    
    public void run(){
        
       boolean n;
        
       for(int i=0; i< q.size(); i++){
           if(this.q.get(i).place_id == 1){
               n = this.m.sendMarinduque(this.q.get(i).query);
           }else{
                n = this.m.sendPalawan(this.q.get(i).query);
           }
            
           
           if(n){
           this.m.local_write(this.q.get(i).query);
       }else{
           String tq =  qc.addTransaction(this.q.get(i).query, id);
           this.m.local_write(tq);
       }
            
        }
        
        
    }
    
    
    
    
}
