package pt.bmo.quarkus.panache.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
import pt.bmo.quarkus.jdbc.model.Artist;
import pt.bmo.quarkus.panache.repository.ArtistRepository;

import java.util.List;

@Path("/api/artists")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(Transactional.TxType.SUPPORTS)
public class ArtistResource {

    @Inject
    ArtistRepository repository;

    @GET
    @Path("{id}")
    public Artist findById(@PathParam("id") Long id) {
        return repository.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }

    @GET
    public List<Artist> findAll() {
        return repository.listAll();
    }

    @POST
    @Transactional(Transactional.TxType.REQUIRED)
    public Response create(Artist artist, @Context UriInfo uriInfo) {
        repository.persist(artist);
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder().path(Long.toString(artist.getId()));
        return Response.created(uriBuilder.build()).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional(Transactional.TxType.REQUIRED)
    public void delete(@PathParam("id") Long id) {
        repository.deleteById(id);
    }
}
