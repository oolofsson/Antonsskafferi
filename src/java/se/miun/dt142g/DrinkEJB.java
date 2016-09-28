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
import se.miun.dt142g.model.Drink;

/**
 *
 * @author oskar
 */
@Stateless
@Named
public class DrinkEJB {
    
    @PersistenceContext
    EntityManager em;
    
    @Inject Drink drink;
    
    public List getList(){
        return em.createNamedQuery("Drink.findAll").getResultList();
    }
    public void create(){
        Drink d2 = new Drink(drink.getDrinkid(), drink.getDrinkname(), drink.getDrinkprice(), drink.getDrinktype());
        em.persist(d2);
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
