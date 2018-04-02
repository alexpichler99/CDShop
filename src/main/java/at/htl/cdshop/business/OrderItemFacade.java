package at.htl.cdshop.business;

import at.htl.cdshop.entity.OrderItem;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class OrderItemFacade {
    @PersistenceContext
    EntityManager em;

    public void save(OrderItem orderItem) {
        em.persist(orderItem);
    }
}
