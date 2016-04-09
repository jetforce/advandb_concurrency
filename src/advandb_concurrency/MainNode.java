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
public class MainNode extends Node{

    public MainNode(UI ui) throws IOException {
        super("main", 1234, ui);
    }
    
    @Override
    public void sendMain(){
        ArrayList<String> queries = new ArrayList<>();
        QueryCreator qc = new QueryCreator();
        int n = Integer.parseInt(ui.deleteField.getText());
        queries = qc.delete(n);
        super.middle.multiple_updateMarinduque(queries,1);
        
    }
    
    
    
}
