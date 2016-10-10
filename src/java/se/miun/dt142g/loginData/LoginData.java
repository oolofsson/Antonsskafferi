
package se.miun.dt142g.loginData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import se.miun.dt142g.util.DataConnect;
/**
 *
 * @author William
 */

public class LoginData {
    
    
    public static boolean validate(String user, String password){
        Connection con = null; // skapar en uppkoppling, initialt satt som 0.   
        PreparedStatement ps = null; // skapar ett förbestämt statement, initalt 0
        
        try{
            con = DataConnect.getConnection(); // hämtar connection från DataConnect som hämtar info från databasen.
            
            // sätter förbestämda statementet till "Select UserName, Password from UserLogin where UserName = ? and Password = ?"
            ps = con.prepareStatement("Select UserName, Password from UserLogin where UserName = ? and Password = ?");
            ps.setString(1, user); // sätter frågetecken 1 som värdet user har som skickas in i funktionen (det som skrivs in på sidan som username)
            ps.setString(2, password); // sätter frågetecken 2 som inskriva lösenord
            
            ResultSet rs = ps.executeQuery(); // kör statementet / queryn 
            if(rs.next()){
                //om resultat hittas betyder det att det är ett godkänt användarnamn / lösenord
		return true;
            }  
            

        } catch (SQLException ex){
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        }finally {
            DataConnect.close(con);
        }
        return false;
    }
}
