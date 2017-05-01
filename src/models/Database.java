/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author BASISDATA
 */
public class Database {
    private String server = "jdbc:mysql://localhost:3306/tubespbo";
    private String dbuser = "root";
    private String dbpasswd = "";
    private Statement statement = null;
    private Connection connection = null;
    
    public Connection getConnection(){
        Connection con = null;
            try {
                con = DriverManager.getConnection(server, dbuser, dbpasswd);
//                JOptionPane.showMessageDialog(null, "Connected!");
                return con;
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//                JOptionPane.showMessageDialog(null, "Not connected");
                return null;
            }
        } 
    }
