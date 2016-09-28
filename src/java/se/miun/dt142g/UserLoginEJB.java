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
import se.miun.dt142g.model.Dish;
import se.miun.dt142g.model.Userlogin;

/**
 *
 * @author oskar
 */
@Stateless
@Named
public class UserLoginEJB {
    @PersistenceContext
    EntityManager em;
    
    @Inject Userlogin userlogin;
    
    public List getList(){
        return em.createNamedQuery("Userlogin.findAll").getResultList();
    }
    public void create(){
        Userlogin l2 = new Userlogin(userlogin.getUsername(), userlogin.getPassword());
        em.persist(l2);
    }
}
