/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hannah
 */
public class DBConnection {

    //public static Connection con = DBConnection.getConnection("root","0987");
    public static void main(String args[]) {
        Connection mainCon = getConnection("root", "0987", "_main");
        Connection palawanCon = getConnection("root", "0987", "_palawan");
        Connection marinduqueCon = getConnection("root", "0987", "_marinduque");
    }
    
    private static Connection getConnection(String user, String password, String schema){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
                System.out.println("Where is your MySQL JDBC Driver?");
                e.printStackTrace();
        }

        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + schema, user, password);   
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
            System.out.println("  > " + schema + "\n");
        } else {
            System.out.println("Failed to make connection!");
            System.out.println("  > " + schema + "\n");
        }
        
        return connection;
    }    
}
