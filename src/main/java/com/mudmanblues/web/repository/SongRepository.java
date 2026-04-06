package com.mudmanblues.web.repository;

import com.mudmanblues.web.model.Song;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository {
    private final DataSource dataSource;

    // Constructor injection of DataSource
    public SongRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Method to find a song by its slug and return a Song object, or null if not found
    public Song findBySlug(String slug) {
        String sql = "SELECT * FROM songs WHERE slug = ?";

        try (Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, slug);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapRowToSong(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Method to find all songs and return a list of Song objects
    public List<Song> findAll() {
        List<Song> songs = new ArrayList<>();

        String sql = "SELECT * FROM songs";

        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                songs.add(mapRowToSong(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return songs;
    }

    // Helper method to map a ResultSet row to a Song object
    private Song mapRowToSong(ResultSet rs) throws SQLException {
        return new Song(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("slug"),
                rs.getString("lyrics"),
                rs.getString("language"),
                rs.getString("album"),
                rs.getString("video_id")
        );
    }
}
