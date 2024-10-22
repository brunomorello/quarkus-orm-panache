package repository;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import model.Artist;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class ArtistRepositoryTest {

    @Inject
    ArtistRepository repository;

    @Test
    void shouldCreateAndFindAnArtist() throws SQLException {
        Artist artist = new Artist("name", "bio");

        repository.persist(artist);
        assertNotNull(artist.getId());

        Artist artistFound = repository.findById(artist.getId());
        assertEquals(artist.getName(), artistFound.getName());
    }
}
