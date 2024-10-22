package pt.bmo.quarkus.jpa.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import pt.bmo.quarkus.jpa.model.Customer;

@ApplicationScoped
class CustomerRepository {

    @Inject
    private EntityManager entityManager;

    void persist(Customer customer) {
        entityManager.persist(customer);
    }

    Customer findById(Long id) {
        return entityManager.find(Customer.class, id);
    }
}