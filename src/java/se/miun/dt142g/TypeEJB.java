
package se.miun.dt142g;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.miun.dt142g.model.Type;

/**
 *
 * @author William
 */
@Stateless
@Named
public class TypeEJB {

@PersistenceContext
    EntityManager em;
    
    @Inject Type type;
    
    public List<Type> getList(){
        return em.createNamedQuery("Type.findAll").getResultList();
    }
    public void create(){
        Type d = new Type(type.getId(), type.getName());
        em.persist(d);
    }
    public void delete(){
        em.createQuery("DELETE FROM Type c WHERE c.typeid = " + type.getId()).executeUpdate();
    }
}
