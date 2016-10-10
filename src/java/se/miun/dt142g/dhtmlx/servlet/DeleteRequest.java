/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.dt142g.dhtmlx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import se.miun.dt142g.dhtmlx.DatabaseConnection;
import se.miun.dt142g.dhtmlx.EventController;

/**
 *
 * @author oskar
 */
@WebServlet(name = "DeleteRequest", urlPatterns = {"/DeleteRequest"})
public class DeleteRequest extends HttpServlet {
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        EventController controller = new EventController();
        
        controller.deleteEventRequest(request.getParameter("id"));
        
        String redirectURL = "javacalendar.jsp";
        response.sendRedirect(redirectURL);
    }

   

}
