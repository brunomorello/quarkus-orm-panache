package pt.bmo.quarkus.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import pt.bmo.quarkus.jpa.model.Customer;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {
}
