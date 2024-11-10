package pt.bmo.quarkus.panache.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import pt.bmo.quarkus.jdbc.model.Artist;
import pt.bmo.quarkus.panache.model.Publisher;
import pt.bmo.quarkus.panache.repository.ArtistRepository;

import java.util.List;

@Path("/api/publishers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PublisherResource {

    @GET
    @Path("{id}")
    public Publisher findById(@PathParam("id") Long id) {
        return (Publisher) Publisher.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }

    @GET
    public List<Publisher> findAll() {
        return Publisher.listAll();
    }
}
