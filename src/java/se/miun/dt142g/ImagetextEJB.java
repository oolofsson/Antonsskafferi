
package se.miun.dt142g;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.miun.dt142g.model.Imagetext;

/**
 *
 * @author William
 */
@Stateless
@Named
public class ImagetextEJB {

@PersistenceContext
    EntityManager em;
    
    @Inject Imagetext imagetext;
    
    public List<Imagetext> getList(){
        return em.createNamedQuery("Imagetext.findAll").getResultList();
    }
     
    public void create(){
        Imagetext d = new Imagetext(imagetext.getImagetext());
        delete();
        em.persist(d);
    }
     public void delete(){
        em.createQuery("DELETE FROM Imagetext").executeUpdate();
    }
}
