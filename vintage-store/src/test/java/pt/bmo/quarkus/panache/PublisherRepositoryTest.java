package pt.bmo.quarkus.panache;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class PublisherRepositoryTest {

    @Test
    @TestTransaction
    void shouldCreateAndFindPublisher() {
        Publisher publisher = new Publisher("name");
        Publisher.persist(publisher);

        assertNotNull(publisher.id);

        Publisher publisherFound = Publisher.findById(publisher.id);
        assertEquals("name", publisherFound.name);
    }
}