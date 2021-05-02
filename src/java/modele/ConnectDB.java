/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.*;
import java.util.logging.*;


/**
 *
 * @author Faranirina
 */
public class ConnectDB {
    public static final String chmin = "jdbc:mysql://localhost:3306/employedb";
    public static final String user = "root";
    public static final String password = "";
    
    public static Connection connect() {
        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(chmin, user, password);
            return conn;
        }catch(ClassNotFoundException | SQLException e) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE,null,e);
        }
        return null;
    }
}
