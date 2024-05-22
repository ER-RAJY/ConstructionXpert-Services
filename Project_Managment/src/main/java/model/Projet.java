package model;

public class Projet {
    private int id;
    private String nom;
    private String description;
    private String dateDebut;
    private String dateFin;
    private double budget;


    public Projet() {

    }

    public Projet(int id, String nom, String description, String dateDebut, String dateFin, double budget) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.budget = budget;

    }



    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDateFin()
    {
        return dateFin;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public double getBudget() {
        return budget;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public void setBudget(double budget) {
        this.budget = budget;
    }

}
