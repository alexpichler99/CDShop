package at.htl.cdshop.web;

import at.htl.cdshop.business.BandFacade;
import at.htl.cdshop.business.TrackFacade;
import at.htl.cdshop.entity.Band;
import at.htl.cdshop.entity.CD;
import at.htl.cdshop.entity.Track;

import javax.enterprise.inject.Model;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@Model
@RequestScoped
public class IndexController {
    @Inject
    BandFacade bandFacade;

    @Inject
    TrackFacade trackFacade;

    String name;

    public IndexController() {
        this.name = "HTL Leonding";
    }

    public String getName() {
        return name;
    }

    public List<Band> findAllBands() {
        List<Band> b = bandFacade.findAll();
        return b;
    }

    public List<Track> findTracksByCD(CD cd) {
        return trackFacade.findByCD(cd);
    }
}
