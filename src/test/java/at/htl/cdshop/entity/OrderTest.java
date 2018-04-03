package at.htl.cdshop.entity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class OrderTest {
    private Order order;
    private OrderItem orderItem;

    @Before
    public void before() {
        order = new Order();
        orderItem = new OrderItem();
    }

    @Test
    public void t001_addCd() {
        order.addOrderItem(orderItem);

        assertThat(order.getOrderItems().get(0), is(orderItem));
        assertThat(orderItem.getOrder(), is(order));
    }

    @Test
    public void t002_removeCd() {
        order.removeOrderItem(orderItem);

        assertThat(order.getOrderItems().size(), is(0));
        assertNull(orderItem.getOrder());
    }

}