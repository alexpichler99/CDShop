package at.htl.cdshop.business;

import at.htl.cdshop.entity.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CustomerFacade {
    @PersistenceContext
    EntityManager em;

    public void save(Customer customer) {
        em.persist(customer);
    }

    public void update(Customer customer) {
        em.merge(customer);
    }
}
