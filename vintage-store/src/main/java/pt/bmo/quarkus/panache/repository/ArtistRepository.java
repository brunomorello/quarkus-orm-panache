package pt.bmo.quarkus.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import pt.bmo.quarkus.jdbc.model.Artist;

@ApplicationScoped
public class ArtistRepository implements PanacheRepository<Artist> {
}
