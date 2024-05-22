package model;

import java.util.List;

public class Tache {
    private int id;
    private String description;
    private String dateDebut;
    private String dateFin;
    private String statut;
    private List<Projet> projet;


    public Tache(List<Projet> Projet) {
        this.projet = projet;
    }

    public Tache(int id, String description, String dateDebut, String dateFin, String statut) {
        this.id = id;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;

    }

    public List<Projet> getProjet() {
        return projet;
    }

    public void setProjet(List<Projet> projet) {
        this.projet = projet;
    }

    public Tache() {

    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }


    public String getStatut() {
        return statut;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }


}
