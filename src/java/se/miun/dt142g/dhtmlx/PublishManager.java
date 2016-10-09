/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.dt142g.dhtmlx;


import com.dhtmlx.planner.DHXEv;
import com.dhtmlx.planner.DHXEventsManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import se.miun.dt142g.dhtmlx.event.WaiterEvent;

/**
 *
 * @author oskar
 */
public class PublishManager extends DHXEventsManager { //Only for showing events in datebase to planner
    
    public PublishManager(HttpServletRequest request){
        super(request);
    }
    @Override
    public Iterable<DHXEv>getEvents(){
        DHXEventsManager.date_format = "yyyy-MM-dd HH:mm:ss";
        List<DHXEv> evs = new ArrayList<>();
        
        
        
        String currentID = getRequest().getSession().getAttribute("username").toString();    
        String query = null;
        
        if(currentID.length() < 4){
            query = "SELECT id, text, start_date, end_date, waiter_id, color FROM waiter_event where waiter_id = " + currentID; //
        }
        else{
            query = "SELECT id, text, start_date, end_date, waiter_id, color FROM waiter_event";
        }
        
        try{
            java.sql.Connection conn = DatabaseConnection.getConnection();
            java.sql.Statement statement = conn.createStatement();
            
            ResultSet resultset = statement.executeQuery(query);
            while(resultset.next()){ //change to waiterevent
                
                WaiterEvent e = new WaiterEvent();
                e.setId(Integer.parseInt(resultset.getString("id")));
                e.setText(resultset.getString("text"));
                e.setStart_date(resultset.getString("start_date"));
                e.setEnd_date(resultset.getString("end_date"));
                e.setWaiter_id(Integer.parseInt(resultset.getString("waiter_id")));
                e.setColor(resultset.getString("color"));
                
                evs.add(e);
                
            }
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        } catch (InstantiationException ex) {
            Logger.getLogger(PublishManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PublishManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        DHXEventsManager.date_format = "MM/dd/yyyy HH:mm";
        return evs;
    }
    
    
}
