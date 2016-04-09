/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import dboperations.QueryCreator;
import java.util.ArrayList;

/**
 *
 * @author Jet
 */
public class UpdateSender extends Thread{
    
    private ArrayList<String> q;
    private Middle m;
    private QueryCreator qc = new QueryCreator();
    private int id;
    
    public UpdateSender(ArrayList<String> queries, Middle m, int id){
        this.q = queries;
        this.m = m;
        this.id = id;
    }
    
    public void run(){
        
        boolean n;
        
       for(int i=0; i< q.size(); i++){
            n = this.m.sendMain(this.q.get(i)); 
       if(n){
           //
       }else{
           String tq =  qc.addTransaction(this.q.get(i), id);
           this.m.local_write(tq);
       }
            
        }
        
        
    }
    
    
    
    
}
