package Dao;

import model.Projet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetDaoIMp implements ProjetDao {
    private Connection connection;

    public ProjetDaoIMp(Connection connection) {
        this.connection = connection;
    }

    // Create
    public void addProjet(Projet projet) throws SQLException {
        String query = "INSERT INTO projet (nom, description, dateDebut, dateFin, budget) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, projet.getNom());
            stmt.setString(2, projet.getDescription());
            stmt.setString(3, projet.getDateDebut());
            stmt.setString(4, projet.getDateFin());
            stmt.setDouble(5, projet.getBudget());
            stmt.executeUpdate();
        }
    }

    // Read by ID
    public Projet getProjetById(int id) throws SQLException {
        String query = "SELECT * FROM projet WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Projet(
                            rs.getInt("id"),
                            rs.getString("nom"),
                            rs.getString("description"),
                            rs.getString("dateDebut"),
                            rs.getString("dateFin"),
                            rs.getDouble("budget")
                    );
                }
            }
        }
        return null;
    }

    // Read all
    public List<Projet> getAllProjets() {
        List<Projet> projets = new ArrayList<>();
        String query = "SELECT * FROM projet";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Projet projet = new Projet(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("description"),
                        rs.getString("dateDebut"),
                        rs.getString("dateFin"),
                        rs.getDouble("budget")
                );
                projets.add(projet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projets;
    }

    // Update
    public void updateProjet(Projet projet) throws SQLException {
        String query = "UPDATE projet SET nom = ?, description = ?, dateDebut = ?, dateFin = ?, budget = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, projet.getNom());
            stmt.setString(2, projet.getDescription());
            stmt.setString(3, projet.getDateDebut());
            stmt.setString(4, projet.getDateFin());
            stmt.setDouble(5, projet.getBudget());
            stmt.setInt(6, projet.getId());
            stmt.executeUpdate();
        }
    }

    // Delete
    public void deleteProjet(int id) throws SQLException {
        String query = "DELETE FROM projet WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
