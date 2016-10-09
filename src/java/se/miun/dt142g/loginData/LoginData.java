
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
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            //Admin and Waiter Check in one
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select UserName, Password from UserLogin where UserName = ? and Password = ?");
            ps.setString(1, user);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                //result found, means valid inputs
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
