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
    
    public List<Alacarte> getStarter(){
        return em.createNamedQuery("Alacarte.findByStarter").getResultList();
    }
    
    public List<Alacarte> getMainCourse(){
        return em.createNamedQuery("Alacarte.findByMainCourse").getResultList();
    }
    
    public List<Alacarte> getDessert(){
        return em.createNamedQuery("Alacarte.findByDessert").getResultList();
    }
    
    public void create(){//lägga in AlacarteDescription?
        Alacarte d = new Alacarte(alacarte.getAlacartename(), alacarte.getAlacartedescription(), alacarte.getAlacarteprice(), alacarte.getAlacartetype());
        em.persist(d);
    }
    public void delete(){
        em.createQuery("DELETE FROM Alacarte c WHERE c.alacarteid = " + alacarte.getAlacarteid()).executeUpdate();
    }
 
}
