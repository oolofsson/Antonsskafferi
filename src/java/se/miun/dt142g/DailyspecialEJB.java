/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.dt142g;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.miun.dt142g.model.Dailyspecial;
import se.miun.dt142g.model.Dish;

/**
 *
 * @author oskar
 */
@Stateless
@Named
public class DailyspecialEJB {

    
    @PersistenceContext
    EntityManager em;
    
    @Inject Dailyspecial dailyspecial;
    
    public List<Dailyspecial> getList(){
        return em.createNamedQuery("Dailyspecial.findAll").getResultList();
    }
    public void create(){
        Dailyspecial d = new Dailyspecial(1, dailyspecial.getMonday(), dailyspecial.getTuesday(),
                dailyspecial.getWednesday(), dailyspecial.getThursday(), dailyspecial.getFriday());
        em.persist(d);
    }
}
