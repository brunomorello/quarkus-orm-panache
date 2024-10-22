package repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import model.Artist;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Random;

@ApplicationScoped
class ArtistRepository {

    @Inject
    DataSource dataSource;

    void persist(final Artist artist) throws SQLException {
        Connection connection = dataSource.getConnection();
        final String sql = "INSERT INTO t_artists(id, name, bio, created_date) VALUES (?, ?, ?, ?)";
        artist.setId(Math.abs(new Random().nextLong()));

        try (PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setLong(1, artist.getId());
            ps.setString(2, artist.getName());
            ps.setString(3, artist.getBio());
            ps.setTimestamp(4, Timestamp.from(artist.getCreatedDate()));
            ps.executeUpdate();
        }
        connection.close();
    }

    Artist findById(final Long id) throws SQLException {
        Connection connection = dataSource.getConnection();
        Artist artist = null;
        final String sql = "SELECT id, name, bio, created_date FROM t_artists WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                artist = new Artist(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getTimestamp(4).toInstant()
                );
            }
        }
        connection.close();
        return artist;
    }
}