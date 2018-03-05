package at.htl.cdshop.business;

import at.htl.cdshop.entity.CD;
import at.htl.cdshop.entity.Track;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class TrackFacade {
    @PersistenceContext
    private EntityManager em;

    public void save(Track track) {
        em.persist(track);
    }

    public List<Track> findByCD(CD cd) {
        return em.createNamedQuery("Track.findByCD").setParameter("CD", cd).getResultList();
    }
}
