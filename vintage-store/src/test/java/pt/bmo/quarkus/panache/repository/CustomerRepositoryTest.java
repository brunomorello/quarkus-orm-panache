package pt.bmo.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import pt.bmo.quarkus.jpa.model.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class CustomerRepositoryTest {

    @Inject
    CustomerRepository repository;

    @Test
    @TestTransaction
    void shouldCreateAndFindCustomer() {
        Customer customer = new Customer("firstName", "lastName", "email");
        repository.persist(customer);

        assertNotNull(customer.getId());
        assertTrue(repository.listAllCustomerWithNameDan().size() <= repository.count());

        Customer customerFound = repository.findById(customer.getId());
        assertEquals("firstName", customerFound.getFirstName());
    }
}