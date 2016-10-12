/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.dt142g.dhtmlx;

import com.dhtmlx.planner.DHXEventsManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import se.miun.dt142g.dhtmlx.event.ChangedEvent;
import se.miun.dt142g.dhtmlx.event.WaiterEvent;
import se.miun.dt142g.dhtmlx.servlet.DeleteRequest;

/**
 *
 * @author oskar
 */
public class ChangedEventLog {
    
    
   public static List<ChangedEvent>getChangedEvents(){
        List<ChangedEvent> evs = new ArrayList<>();
        
        try{
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();
            String query = "SELECT id, message FROM changed_event_log";
            ResultSet resultset = statement.executeQuery(query);
            while(resultset.next()){ //change to waiterevent
                
                ChangedEvent e = new ChangedEvent();
                e.setId(Integer.parseInt(resultset.getString("id")));
                e.setMessage(resultset.getString("message"));
                
                evs.add(e);
                
            }
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(PublishManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return evs;
    }
   
    public static void updateChangedEventLog(ChangedEvent changedEvent){ //argument id = 1
        List changedEvents = getChangedEvents();
     
        changedEvents.add(changedEvent);
        
        deleteChangedEvents();
        saveChangedEvents(changedEvents);
    }
    
    
    private static void saveChangedEvents(List changedEvents){
        Connection conn;
        try{
            conn = DatabaseConnection.getConnection();

            for(Iterator<ChangedEvent> i = changedEvents.iterator(); i.hasNext();) { //Increment all earlier changedevents id
                ChangedEvent ch = i.next();
                if(ch.getId() < 5){
                    ch.setId(ch.getId() + 1);
                    String query = "INSERT INTO changed_event_log VALUES (?, ?)";
                    PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, ch.getId());
                    ps.setString(2, ch.getMessage());
                    
                    ps.executeUpdate();
                }
            }

            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DeleteRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void deleteChangedEvents(){
        Connection conn;
        try{
            conn = DatabaseConnection.getConnection();

            String query = "DELETE FROM changed_event_log";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.execute();

            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DeleteRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
