package at.htl.cdshop.business;

import at.htl.cdshop.entity.Band;
import at.htl.cdshop.entity.CD;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CDFacade {
    @PersistenceContext
    private EntityManager em;

    public void save(CD cd) {
        em.persist(cd);
    }

    public List<CD> findByBand(Band band) {
        return em.createNamedQuery("CD.findByBand").setParameter("BAND", band).getResultList();
    }
}
