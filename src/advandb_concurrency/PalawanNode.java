/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advandb_concurrency;

import dboperations.QueryCreator;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Jet
 */
public class PalawanNode extends Node{

    public PalawanNode(UI ui) throws IOException {
        super("palawan", 1235, ui);
    }
    
    
    @Override
    public void sendMain(){
        
        ArrayList<String> queries = new ArrayList<>();
        QueryCreator qc = new QueryCreator();
        int n = Integer.parseInt(ui.deleteField.getText());
        for(int i = 0; i < n; i++) {
            String query_stmt = qc.delete(); 
            queries.add(query_stmt);
            //addTransaction(query_stmt, 1);  // 1 is hardcoded / to be replaced
        }
        
        super.middle.multiple_updateMain(queries);
        
    }
    
    
}
