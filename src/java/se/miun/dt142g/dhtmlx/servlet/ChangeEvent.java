/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.dt142g.dhtmlx.servlet;

import com.dhtmlx.planner.DHXStatus;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import se.miun.dt142g.dhtmlx.ChangedEventLog;
import se.miun.dt142g.dhtmlx.EventController;
import se.miun.dt142g.dhtmlx.event.ChangedEvent;
import se.miun.dt142g.dhtmlx.event.WaiterEvent;

/**
 *
 * @author oskar
 */
@WebServlet(name = "ChangeEvent", urlPatterns = {"/ChangeEvent"})
public class ChangeEvent extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EventController controller = new EventController();
                

        List<WaiterEvent> waiters = controller.getEvents();
        WaiterEvent event1 = null;
        WaiterEvent event2 = null;
        
        //Get events 
        for(int i = 0; i < waiters.size(); i++){
            if(waiters.get(i).getId().equals(Integer.parseInt(request.getParameter("event1")))){
                event1 = waiters.get(i);
            }else if(waiters.get(i).getId().equals(Integer.parseInt(request.getParameter("event2")))){
                event2 = waiters.get(i);
            }
            
        }
        
         
        //Swap waiterinfo
        String tmpText = event1.getText();
        int tmpWaiterId = event1.getWaiter_id();
        String tmpColor = event1.getColor();

        event1.setText(event2.getText());
        event1.setWaiter_id(event2.getWaiter_id());
        event1.setColor(event2.getColor());

        event2.setText(tmpText);
        event2.setWaiter_id(tmpWaiterId);
        event2.setColor(tmpColor);

        controller.saveEvent(event1, DHXStatus.UPDATE); //Save events 
        controller.saveEvent(event2, DHXStatus.UPDATE);
        

        //Delete request
        controller.deleteEventRequest(request.getParameter("id"));
        
        
        //Save to changed event log
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        
        String message = event2.getText() + " har bytt passet: " + df.format(event2.getStart_date())
                + ", mot " + event1.getText() + "s pass: " + df.format(event1.getStart_date()) + ".";
        
        ChangedEvent changedEvent = new ChangedEvent(0, message);
        
        ChangedEventLog.updateChangedEventLog(changedEvent);
        
        
        
        String redirectURL = "javacalendar.jsp";
        response.sendRedirect(redirectURL);
            
    }

}
