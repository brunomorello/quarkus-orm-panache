package pt.bmo.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.Duration;
import java.time.Instant;

@Entity
@Table(name = "t_tracks")
public class Track extends PanacheEntity {

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public Duration duration;

    @Column(name = "created_date", nullable = false)
    public Instant createdDate = Instant.now();

    @ManyToOne
    @JoinColumn(name = "cd_fk")
    public CD cd;

}
