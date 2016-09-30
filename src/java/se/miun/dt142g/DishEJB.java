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
import javax.persistence.Query;
import se.miun.dt142g.model.Dish;

/**
 *
 * @author oskar
 */
@Stateless
@Named
public class DishEJB {
    
    @PersistenceContext
    EntityManager em;
    
    @Inject Dish dish;
    
    public List<Dish> getList(){
        return em.createNamedQuery("Dish.findAll").getResultList();
    }
    public void create(){
        Dish d = new Dish(dish.getDishname(), dish.getDishprice(), dish.getDishtype());
        em.persist(d);
    }
    public void delete(){
        em.createQuery("DELETE FROM Dish c WHERE c.dishid = " + dish.getDishid()).executeUpdate();
    }
 
}
