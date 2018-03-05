package at.htl.cdshop.rest;

import at.htl.cdshop.business.BandFacade;
import at.htl.cdshop.entity.Band;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("band")
public class BandEndpoint {
    @Inject
    BandFacade bandFacade;

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response postBand(@Valid Band band) {
        bandFacade.save(band);
        return Response.noContent().build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Band> getAll() {
        return bandFacade.findAll();
    }
}
