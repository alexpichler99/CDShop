package at.htl.cdshop.business;

import at.htl.cdshop.entity.Band;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BandFacade {
    @PersistenceContext
    private EntityManager em;

    public void save(Band band) {
        em.persist(band);
    }

    public List<Band> findAll() {
        return em.createNamedQuery("Band.findAll").getResultList();
    }
}
