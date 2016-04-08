/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advandb_concurrency;

import dbcon.Data;
import dboperations.QueryCreator;
import dboperations.Receiver;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Hannah
 */
public class UI {
    
    JButton readGo, deleteGo, updateGo;
    JTextField readField, deleteField, updateField;
    JTextArea infoArea;
    private Node node;
    

    
    
    public void startUI(Node node){
        this.node = node;
        
        Frame frame = new Frame();
        readGo = frame.readGoBtn;           readGo.addActionListener(new GoListener("read"));
        deleteGo = frame.deleteGoBtn;       deleteGo.addActionListener(new GoListener("delete"));
        updateGo = frame.updateGoBtn;       updateGo.addActionListener(new GoListener("update"));
        readField = frame.readField;
        deleteField = frame.deleteField;
        updateField = frame.updateField;
        infoArea = frame.infoArea;
        frame.setVisible(true);
    }
    
    private void addTransaction(String query_stmt, int place_id) {
        String testQuery = 
            "INSERT\n" +
            "INTO transactions (place_id, query_stmt, synced)\n" +
            "VALUES (" + place_id + ", " + query_stmt + ", 0);";
        //Receiver r = new Receiver(testQuery);
        //r.work();
    }
    

    public void addInfo(String info){
        System.out.println("Hello");
        infoArea.append(info+"\n");
    }
    
    

    private void read() {
        
        int times = Integer.parseInt(readField.getText());
        System.out.println("times "+times );
        String Query = "SELECT"+"\n"+"* FROM survey"+"\n";
        this.node.readSelf(times,Query);
        
    }
    
    private void delete(){
        QueryCreator qc = new QueryCreator();
        int n = Integer.parseInt(deleteField.getText());
        for(int i = 0; i < n; i++) {
            String query_stmt = "\"" + qc.delete() + "\""; 
            addTransaction(query_stmt, 1);  // 1 is hardcoded / to be replaced
        }
        System.out.println("> > FINISHED DELETING");
    }
    
    private void update(){
        
    }
    
    public class GoListener implements ActionListener {
        String buttonType;
        public GoListener(String buttonType) {
            this.buttonType = buttonType;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            switch(buttonType) {
                case "read": read(); break;
                case "delete": delete(); break;
                case "update": update();
            }
        }
    }
}