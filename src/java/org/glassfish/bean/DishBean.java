/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassfish.bean;

import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.glassfish.samples.DishEJB;
import org.glassfish.samples.model.Dish;

/**
 *
 * @author oskar
 */
@ManagedBean
@RequestScoped
@Named
public class DishBean {

    private String dish;
    private List<String> dishes; 

    @EJB
    private DishEJB ejb;

    @PostConstruct
    public void init() {
        for(int i = 0; i < ejb.getList().size(); i++){
            Dish d = (Dish) ejb.getList().get(i);
            dishes.add(d.getDishname() + ", " + d.getDishprice() + "kr");
        }
    }

    // ... (getters, setters, etc)

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public List<String> getDishes() {
        return dishes;
    }

    
}
