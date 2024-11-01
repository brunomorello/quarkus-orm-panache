package pt.bmo.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import pt.bmo.quarkus.jdbc.model.Artist;
import pt.bmo.quarkus.jpa.model.Customer;
import pt.bmo.quarkus.panache.model.Book;
import pt.bmo.quarkus.panache.model.Language;
import pt.bmo.quarkus.panache.model.OrderLine;
import pt.bmo.quarkus.panache.model.Publisher;
import pt.bmo.quarkus.panache.model.PurchaseOrder;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class PurchaseOrderRepositoryTest {

    @Inject
    CustomerRepository customerRepository;

    @Test
    @TestTransaction
    void shouldCreateAndFindAPurchaseOrder() {
        final Artist artist = new Artist("artist name", "artist bio");
        final Publisher publisher = new Publisher("publisher name");

        final Book book = new Book();
        book.title = "book title";
        book.description = "book long description";
        book.numberOfPages = 500;
        book.isbn = "fake_isbn";
        book.language = Language.PORTUGUESE;
        book.price = new BigDecimal(10);
        book.artist = artist;
        book.publisher = publisher;
        book.publicationDate = LocalDate.of(2011, 02, 01);
        Book.persist(book);

        final Customer customer = new Customer("first name", "last name", "test@test.com");
        customerRepository.persist(customer);

        final OrderLine orderLine = new OrderLine();
        orderLine.item = book;
        orderLine.quantity = 2;

        final PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.customer = customer;
        purchaseOrder.addOrderLine(orderLine);

        PurchaseOrder.persist(purchaseOrder);
    }
}