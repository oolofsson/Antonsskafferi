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
import se.miun.dt142g.dhtmlx.WaiterRemover;
import se.miun.dt142g.model.Dish;
import se.miun.dt142g.model.Waiter;

/**
 *
 * @author oskar
 */
@Named
@Stateless
public class WaiterEJB {

    @PersistenceContext
    EntityManager em;
    
    @Inject Waiter waiter;
    
    public List<Waiter> getList(){
        return em.createNamedQuery("Waiter.findAll").getResultList();
    }
    public void create(){
        Waiter w = new Waiter(waiter.getWaitername(), waiter.getPincode());
        em.persist(w);
    }
    public void delete(){ //Delete everything waiter is involved in
        em.createQuery("DELETE FROM Waiter w WHERE w.waiterid = " + waiter.getWaiterid()).executeUpdate();
        
        WaiterRemover.delete(waiter.getWaiterid());
    }
    
}
