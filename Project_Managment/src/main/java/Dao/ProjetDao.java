package Dao;

import model.Projet;

import java.sql.SQLException;
import java.util.List;

public interface ProjetDao {
    // Méthode pour récupérer tous les projets
    List<Projet> getAllProjets();

    // Méthode pour récupérer un projet par son ID
    Projet getProjetById(int id) throws SQLException;

    // Méthode pour ajouter un nouveau projet
    void addProjet(Projet projet) throws SQLException;

    // Méthode pour mettre à jour un projet existant
    void updateProjet(Projet projet) throws SQLException;

    // Méthode pour supprimer un projet
    void deleteProjet(int id) throws SQLException;
}
