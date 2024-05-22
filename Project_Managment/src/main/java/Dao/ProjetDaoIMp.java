package Dao;

import model.Projet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetDaoIMp {
    private Connection connection;

    public ProjetDaoIMp(Connection connection) {
        this.connection = connection;
    }

    public ProjetDaoIMp() {

    }

    // Create
    public void addProjet(Projet projet) throws SQLException {
        String query = "INSERT INTO projets (nom, description, date_debut, date_fin, budget) VALUES (?, ?, ?, ?, ?)";
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
    public Projet getProjet(int id) throws SQLException {
        String query = "SELECT * FROM projets WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Projet(
                            rs.getInt("id"),
                            rs.getString("nom"),
                            rs.getString("description"),
                            rs.getString("date_debut"),
                            rs.getString("date_fin"),
                            rs.getDouble("budget")
                    );
                }
            }
        }
        return null;
    }

    // Read all
    public List<Projet> getAllProjets() throws SQLException {
        List<Projet> projets = new ArrayList<>();
        String query = "SELECT * FROM projets";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Projet projet = new Projet(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("description"),
                        rs.getString("date_debut"),
                        rs.getString("date_fin"),
                        rs.getDouble("budget")
                );
                projets.add(projet);
            }
        }
        return projets;
    }

    // Update
    public void updateProjet(Projet projet) throws SQLException {
        String query = "UPDATE projets SET nom = ?, description = ?, date_debut = ?, date_fin = ?, budget = ? WHERE id = ?";
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
        String query = "DELETE FROM projets WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }


}
