/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.dt142g.dhtmlx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import se.miun.dt142g.dhtmlx.servlet.DeleteRequest;

/**
 *
 * @author oskar
 */
public class WaiterRemover {
    public static void delete(int waiterId){
        Connection conn;
        try{
            conn = DatabaseConnection.getConnection();
            
            //Delete the events
            String queryWaiterEvent = "DELETE FROM waiter_event WHERE waiter_id = " + waiterId;
            PreparedStatement psWaiterEvent = conn.prepareStatement(queryWaiterEvent);

            psWaiterEvent.execute();
            
            //Delete change requests
            String queryChangeRequest = "DELETE FROM change_request WHERE sender_id = " + waiterId + " OR receiver_id = " + waiterId;
            PreparedStatement psChangeRequest = conn.prepareStatement(queryChangeRequest);
            
            psChangeRequest.execute();
            
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DeleteRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
