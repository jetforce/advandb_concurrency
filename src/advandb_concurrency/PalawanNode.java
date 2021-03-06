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

/**
 *
 * @author Jet
 */
public class PalawanNode extends Node{

    int place_id = 2;
    
    public PalawanNode(UI ui) throws IOException {
        super("palawan", 1235, ui);
    }
    
    
    @Override
    public void sendMain(){
        
        ArrayList<Query> queries = new ArrayList<>();
        QueryCreator qc = new QueryCreator();
        int n = Integer.parseInt(ui.deleteField.getText());
        queries = qc.delete(n);
        
        super.middle.multiple_updateMain(queries,place_id);
        
    }
    
    
}
