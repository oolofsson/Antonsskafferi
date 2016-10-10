/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.dt142g.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author William
 */
public class DataConnect {
    public static Connection getConnection() {
    try {
	Class.forName("org.apache.derby.jdbc.ClientDriver"); // databastypp, (JavaDerby)
        String myDB = "jdbc:derby://localhost:1527/sample"; // var och vilken port databasen ligger på i datorn i string
	Connection con = DriverManager.getConnection(
	myDB, "app", "app"); // skapar en uppkoppling mot db:n, användarnamn = app, lösenord = app.
	return con; // returnerar uppkopplingen
		} 
        catch (Exception ex) {
                System.out.println("Database.getConnection() Error -->"
                + ex.getMessage());
                return null;
		}
	}
    
    public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}
