/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.dt142g.dhtmlx.servlet;

import com.dhtmlx.planner.DHXStatus;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
        
        //WaiterEvent event1 = waiters.get(Integer.parseInt(request.getParameter("change_id1")));
        //WaiterEvent event2 = waiters.get(Integer.parseInt(request.getParameter("change_id2")));

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

        String redirectURL = "javacalendar.jsp";
        response.sendRedirect(redirectURL);
            
    }

}
