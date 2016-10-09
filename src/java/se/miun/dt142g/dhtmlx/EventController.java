/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.dt142g.dhtmlx;

/**
 *
 * @author oskar
 */
import com.dhtmlx.planner.DHXEventsManager;
import com.dhtmlx.planner.DHXStatus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import se.miun.dt142g.dhtmlx.event.WaiterEvent;

/**
 *
 * @author oskar
 */
public class EventController {
    
    public EventController(){
    }
    
    public List<WaiterEvent>getEvents(){
        DHXEventsManager.date_format = "yyyy-MM-dd HH:mm:ss";
        List<WaiterEvent> evs = new ArrayList<>();
        
        try{
            java.sql.Connection conn = DatabaseConnection.getConnection();
            java.sql.Statement statement = conn.createStatement();
            String query = "SELECT id, text, start_date, end_date, waiter_id, color FROM waiter_event";
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
    
    public void saveEvent(WaiterEvent event, DHXStatus status){
        java.sql.Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
        } catch (InstantiationException ex) {
            Logger.getLogger(PublishManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PublishManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet result = null;
        try{
            String query = null;
            String start_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(event.getStart_date());
            String end_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(event.getEnd_date());
            if(null != status)switch (status) {
                case UPDATE:
                    query = "UPDATE waiter_event SET text=?, start_date=?, end_date=?, waiter_id=?, color=? WHERE id=?";
                    ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, event.getText());
                    ps.setString(2, start_date);
                    ps.setString(3, end_date);
                    ps.setInt(4, event.getWaiter_id());
                    ps.setString(5, event.getColor());
                    ps.setInt(6, event.getId());
                    break;
                case INSERT:
                    query = "INSERT INTO waiter_event (text, start_date, end_date, waiter_id, color) VALUES (?, ?, ?, ?, ?)";
                    ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, event.getText());
                    ps.setString(2, start_date);
                    ps.setString(3, end_date);
                    ps.setInt(4, event.getWaiter_id());
                    ps.setString(5, event.getColor());
                    break;
                case DELETE:
                    query = "DELETE FROM waiter_event WHERE id=? LIMIT 1";
                    ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, event.getId());
                    break;
                default:
                    break;
            }
            if(ps != null){
                ps.executeUpdate();
                /*result = ps.getGeneratedKeys();
                if(result.next()){
                    event.setId(result.getInt(1));
                }*/
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(result != null) try{result.close();}catch(SQLException e){}
            if(ps != null) try{ps.close();}catch(SQLException e){}
            if(conn != null) try{conn.close();}catch(SQLException e){}
        }
    }
      
}
