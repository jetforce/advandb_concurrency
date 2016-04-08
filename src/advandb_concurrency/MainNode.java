/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advandb_concurrency;

import java.io.IOException;

/**
 *
 * @author Jet
 */
public class MainNode extends Node{

    public MainNode(UI ui) throws IOException {
        super("main", 1234, ui);
    }
    
    @Override
    public void sendMain(){
        
        
    }
    
    
    
}
