/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.dt142g.dhtmlx.servlet;

import com.dhtmlx.planner.DHXStatus;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import se.miun.dt142g.dhtmlx.EventController;
import se.miun.dt142g.dhtmlx.event.WaiterEvent;

/**
 *
 * @author oskar
 */
@WebServlet(name = "SaveEvent", urlPatterns = {"/SaveEvent"})
public class SaveEvent extends HttpServlet {

   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        EventController controller = new EventController();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date start_date = null; 
        Date end_date = null;
        try {
            start_date = format.parse(request.getParameter("start_date"));
            end_date = format.parse(request.getParameter("end_date"));
        } catch (ParseException ex) {
            Logger.getLogger(SaveEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int waiter_id = Integer.parseInt(request.getParameter("waiter_id"));

        WaiterEvent waiterEvent = new WaiterEvent(request.getParameter("text"), 
                start_date, end_date, waiter_id, request.getParameter("color"));

        controller.saveEvent(waiterEvent, DHXStatus.INSERT);

        String redirectURL = "javacalendar.jsp";
        response.sendRedirect(redirectURL);
        
    }

   

}
