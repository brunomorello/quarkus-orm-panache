package pt.bmo.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import pt.bmo.quarkus.jdbc.model.Artist;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "t_items")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Item extends PanacheEntity {

    @Column(length = 100, nullable = false)
    public String title;

    @Column(length = 5000)
    public String description;

    @Column(nullable = false)
    public BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "artist_fk")
    public Artist artist;

    @Column(name = "created_date", nullable = false)
    public Instant createdAt = Instant.now();
}
