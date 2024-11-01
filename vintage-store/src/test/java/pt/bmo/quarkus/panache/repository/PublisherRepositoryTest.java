package pt.bmo.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import pt.bmo.quarkus.panache.model.Publisher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class PublisherRepositoryTest {

    @Test
    @TestTransaction
    void shouldCreateAndFindPublisher() {
        long count = Publisher.count();
        int listAllSize = Publisher.listAll().size();

        assertEquals(count, listAllSize);

        Publisher publisher = new Publisher("name");
        Publisher.persist(publisher);

        assertNotNull(publisher.id);
        assertEquals(count + 1, Publisher.count());

        Publisher publisherFound = Publisher.findById(publisher.id);
        publisherFound = Publisher.findByName(publisher.name).orElseThrow(EntityNotFoundException::new);
        assertEquals("name", publisherFound.name);
        assertTrue(Publisher.findByContainsName(publisher.name).size() > 0);

        Publisher.deleteById(publisher.id);
        assertEquals(count, Publisher.count());
    }
}