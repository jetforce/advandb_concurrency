/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advandb_concurrency;

import dbcon.Data;
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
    
    public void startUI() {
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
    
    private void read() {
        
    }
    
    private void delete() {
        
    }
    
    private void update() {
        
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