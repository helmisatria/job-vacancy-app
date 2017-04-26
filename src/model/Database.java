/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.ArrayList;

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
    
    public void connect() {
        try{
            connection = DriverManager.getConnection(server, dbuser, dbpasswd);
            statement = connection.createStatement();
        } catch (Exception e){
            throw new IllegalArgumentException("Terjadi kesalahan saat connect to database");
        }
    }
    
    
}
