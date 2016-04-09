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
public class MarinduqueNode extends Node{

    public MarinduqueNode(UI ui) throws IOException {
        super("marinduque", 1235, ui);
    }
    
    @Override
    public void sendMain(){
        //ArrayList<String> queries;
        super.middle.multiple_updateMain(null);
    }
   
}
