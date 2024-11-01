package pt.bmo.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import pt.bmo.quarkus.panache.model.Publisher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        assertEquals("name", publisherFound.name);

        Publisher.deleteById(publisher.id);
        assertEquals(count, Publisher.count());
    }
}