/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.util.ArrayList;

/**
 *
 * @author Jet
 */
public class UpdateSender extends Thread{
    
    private ArrayList<String> q;
    private Middle m;
    
    public UpdateSender(ArrayList<String> queries, Middle m){
        this.q = queries;
        this.m = m;
    }
    
    public void run(){
        
        boolean n;
        
       for(int i=0; i< q.size(); i++){
            n = this.m.sendMain(this.q.get(i)); 
       if(n){
           //Success sending
       }else{
           //fail sending
       }
            
        }
        
        
    }
    
    
    
    
}
