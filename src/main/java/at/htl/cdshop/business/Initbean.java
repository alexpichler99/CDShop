package at.htl.cdshop.business;

import at.htl.cdshop.entity.Band;
import at.htl.cdshop.entity.CD;
import at.htl.cdshop.entity.Track;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class Initbean {
    @Inject
    BandFacade bandFacade;

    @Inject
    CDFacade cdFacade;

    @Inject
    TrackFacade trackFacade;

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
    }
}
