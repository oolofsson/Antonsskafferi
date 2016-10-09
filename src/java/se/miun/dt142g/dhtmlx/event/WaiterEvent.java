/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.dt142g.dhtmlx.event;

import com.dhtmlx.planner.DHXEvent;
import java.util.Date;

/**
 *
 * @author oskar
 */
public class WaiterEvent extends DHXEvent {
    
    public String color;
    public int waiter_id;
    
    public WaiterEvent() {
        
    }
    public WaiterEvent(String text, Date start_date, Date end_date, 
            int waiter_id, String color){
        
        this.text = text;
        this.start_date = start_date;
        this.end_date = end_date;
        this.waiter_id = waiter_id;
        this.color = color;
    }
    
    public int getWaiter_id() {
        return waiter_id;
    }

    public void setWaiter_id(int waiter_id) {
        this.waiter_id = waiter_id;
    }
    
    public String getColor() {
            return color;
    }
    public void setColor(String color) {
            this.color = color;
    }
    
}
