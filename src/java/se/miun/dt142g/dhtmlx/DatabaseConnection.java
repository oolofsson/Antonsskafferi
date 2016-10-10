/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.dt142g.dhtmlx;

import java.sql.*;
/**
 *
 * @author oskar
 */
public class DatabaseConnection {
    public static Connection getConnection() throws InstantiationException, IllegalAccessException{
        Connection conn = null;
        String url = "jdbc:derby://localhost:1527/";
        String dbName = "sample";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        String user = "app";    
        String password = "app";
        try{
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url+dbName, user, password);
            System.out.println("Connected to database");
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}
