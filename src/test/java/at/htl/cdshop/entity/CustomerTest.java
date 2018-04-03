package at.htl.cdshop.entity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class CustomerTest {
    private Customer customer;
    private Order order;

    @Before
    public void before() {
        customer = new Customer();
        order = new Order();
    }

    @Test
    public void t001_addCd() {
        customer.addOrder(order);

        assertThat(customer.getOrders().get(0), is(order));
        assertThat(order.getCustomer(), is(customer));
    }

    @Test
    public void t002_removeCd() {
        customer.removeOrder(order);

        assertThat(customer.getOrders().size(), is(0));
        assertNull(order.getCustomer());
    }
}