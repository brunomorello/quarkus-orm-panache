package pt.bmo.quarkus.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import pt.bmo.quarkus.jpa.model.Customer;

import java.util.List;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {
    public List<Customer> listAllCustomerWithNameDan() {
        return list("firstName = 'Dan'", Sort.by("lastName"));
    }
}
