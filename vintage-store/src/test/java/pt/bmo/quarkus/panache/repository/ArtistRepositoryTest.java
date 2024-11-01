package pt.bmo.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import pt.bmo.quarkus.jdbc.model.Artist;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class ArtistRepositoryTest {

    @Inject
    ArtistRepository repository;

    @Test
    @TestTransaction
    void shouldCreateAndFindAnArtist() throws SQLException {
        long count = repository.count();
        int listAllSize = repository.listAll().size();

        assertEquals(count, listAllSize);

        Artist artist = new Artist("name", "bio");
        repository.persist(artist);

        assertNotNull(artist.getId());
        assertEquals(count + 1, repository.count());
        assertEquals(count + 1, repository.listAllArtistsSorted().size());

        Artist artistFound = repository.findById(artist.getId());
        assertEquals(artist.getName(), artistFound.getName());

        repository.deleteById(artist.getId());
        assertEquals(count, repository.count());
    }
}
