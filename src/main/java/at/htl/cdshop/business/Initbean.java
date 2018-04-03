package at.htl.cdshop.business;

import at.htl.cdshop.entity.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Startup
@Singleton
public class Initbean {
    @Inject
    BandFacade bandFacade;

    @Inject
    CDFacade cdFacade;

    @Inject
    TrackFacade trackFacade;

    @Inject
    CustomerFacade customerFacade;

    @Inject
    OrderFacade orderFacade;

    @Inject
    OrderItemFacade orderItemFacade;

    @PostConstruct
    private void init() {
        Band b = new Band("Motionless In White", 2005);
        CD cd = new CD("Graveyard Shift", b);
        Track t = new Track("Rats", cd);
        Track t1 = new Track("Queen For Queen", cd);
        Track t2 = new Track("Necessary evil", cd);

        CD cd1 = new CD("Reincarnate", b);
        Track t3 = new Track("Death March", cd1);
        Track t4 = new Track("Reincarnate", cd1);
        Track t5 = new Track("Puppets 3", cd1);

        CD cd3 = new CD();
        cd3.setTitle("Creatures");
        Track t9 = new Track();
        t9.setName("Immaculate Misconception");

        Track t10 = new Track();
        t10.setName("We Only Come Out At Night");

        cd3.addTrack(t9);
        cd3.addTrack(t10);
        b.addCD(cd3);

        trackFacade.save(t9);
        trackFacade.save(t10);
        cdFacade.save(cd3);

        bandFacade.save(b);
        cdFacade.save(cd);
        trackFacade.save(t);
        trackFacade.save(t1);
        trackFacade.save(t2);

        cdFacade.save(cd1);
        trackFacade.save(t3);
        trackFacade.save(t4);
        trackFacade.save(t5);

        Band b1 = new Band("Cattle Decapitation", 1996);
        CD cd2 = new CD("The Harvest Floor", b1);
        Track t6 = new Track("The Gardeners Of Eden", cd2);
        Track t7 = new Track("A Body Farm", cd2);
        Track t8 = new Track("We Are Horrible People", cd2);

        bandFacade.save(b1);
        cdFacade.save(cd2);
        trackFacade.save(t6);
        trackFacade.save(t7);
        trackFacade.save(t8);

        Customer c1 = new Customer("Max", "Mustermann");
        customerFacade.save(c1);

        Order o1 = new Order(c1, Date.valueOf(LocalDate.now()));

        OrderItem oi1 = new OrderItem(o1, cd);
        OrderItem oi2 = new OrderItem(o1, cd1);

        List<OrderItem> l = new LinkedList<>();
        l.add(oi1);
        l.add(oi2);
        orderItemFacade.save(oi1);
        orderItemFacade.save(oi2);

        o1.setOrderItems(l);

        orderFacade.save(o1);

        List<Order> li = new LinkedList<Order>();
        li.add(o1);

        c1.setOrders(li);
    }
}
