/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.dt142g;

import javax.ejb.Stateless;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import se.miun.dt142g.model.Alacarte;
/**
 *
 * @author William
 */
@Stateless
@Named
public class AlacarteEJB {

    @PersistenceContext
    EntityManager em;
    
    @Inject Alacarte alacarte;
    
    public List<Alacarte> getList(){
        return em.createNamedQuery("Alacarte.findAll").getResultList();
    }
    public void create(){
        Alacarte d = new Alacarte(alacarte.getAlacartename(), alacarte.getAlacarteprice(), alacarte.getAlacartetype());
        em.persist(d);
    }
    public void delete(){
        em.createQuery("DELETE FROM Alacarte c WHERE c.alacarteid = " + alacarte.getAlacarteid()).executeUpdate();
    }
 
}
