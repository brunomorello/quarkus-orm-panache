package pt.bmo.quarkus.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import pt.bmo.quarkus.jdbc.model.Artist;

import java.util.List;

@ApplicationScoped
public class ArtistRepository implements PanacheRepository<Artist> {
    public List<Artist> listAllArtistsSorted() {
        return listAll(Sort.descending("name"));
    }
}
