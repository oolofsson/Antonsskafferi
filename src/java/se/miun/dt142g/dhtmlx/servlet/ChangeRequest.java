/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.dt142g.dhtmlx.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import se.miun.dt142g.dhtmlx.DatabaseConnection;
import se.miun.dt142g.dhtmlx.PublishManager;

/**
 *
 * @author oskar
 */
@WebServlet(name = "ChangeRequest", urlPatterns = {"/ChangeRequest"})
public class ChangeRequest extends HttpServlet {

 
  
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Printwriter for showing incoming requests?
        //send back to javacalendar.jsp after answer
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String query = null;
        java.sql.Connection conn = null;
        
        try {
            conn = DatabaseConnection.getConnection();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(PublishManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet result = null;
        try{
            query = "INSERT INTO change_request (sender_id, event1, event2, receiver_id) VALUES (?, ?, ?, ?)";
            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, Integer.parseInt(request.getParameter("sender_id")));
            ps.setInt(2, Integer.parseInt(request.getParameter("event1")));
            ps.setInt(3, Integer.parseInt(request.getParameter("event2")));
            ps.setInt(4, Integer.parseInt(request.getParameter("receiver_id")));
            
            if(ps != null){
                ps.executeUpdate();
              
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(result != null) try{result.close();}catch(SQLException e){}
            if(ps != null) try{ps.close();}catch(SQLException e){}
            if(conn != null) try{conn.close();}catch(SQLException e){}
        }
        String redirectURL = "javacalendar.jsp";
        response.sendRedirect(redirectURL);
       
    }

    

}
