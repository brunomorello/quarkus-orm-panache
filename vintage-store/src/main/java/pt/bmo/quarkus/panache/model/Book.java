package pt.bmo.quarkus.panache.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Book extends Item {

    @Column(length = 15)
    public String isbn;

    @Column(name = "number_pages")
    public int numberOfPages;

    @Column(name = "publication_date", nullable = false)
    public LocalDate publicationDate;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    public Language language;

    @ManyToOne
    public Publisher publisher;
}
