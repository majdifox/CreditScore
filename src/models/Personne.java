package models;

import java.time.LocalDate;
import utils.SituationFamiliale;

public abstract class Personne {

    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;
    private String ville;
    private int nbrEnfants;

    private double investissement; //argent investi
    private double placement; //argent place

    private SituationFamiliale situationFamiliale; // from enum

    private LocalDate createdAt;
    private int score;

//    constructor
    public Personne(String nom, String prenom, LocalDate dateDeNaissance, String ville, int nbrEnfants, double investissement, double placement, SituationFamiliale situationFamiliale, LocalDate createdAt, int score    ){

        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.ville = ville;
        this.nbrEnfants = nbrEnfants;
        this.investissement = investissement;
        this.placement = placement;
        this.situationFamiliale = situationFamiliale;
        this.createdAt = createdAt;
        this.score = score;
    }

    // Getters and Setters

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public LocalDate getDateNaissance() { return dateDeNaissance; }
    public void setDateNaissance(LocalDate dateNaissance) { this.dateDeNaissance = dateNaissance; }

    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }

    public int getNombreEnfants() { return nbrEnfants; }
    public void setNombreEnfants(int nombreEnfants) { this.nbrEnfants = nombreEnfants; }

    public double getInvestissement() { return investissement; }
    public void setInvestissement(double investissement) { this.investissement = investissement; }

    public double getPlacement() { return placement; }
    public void setPlacement(double placement) { this.placement = placement; }

    public SituationFamiliale getSituationFamiliale() { return situationFamiliale; }
    public void setSituationFamiliale(SituationFamiliale situationFamiliale) { this.situationFamiliale = situationFamiliale; }

    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

@Override
    public String toString(){
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateDeNaissance +
                ", ville='" + ville + '\'' +
                ", enfants=" + nbrEnfants +
                ", investissement=" + investissement +
                ", placement=" + placement +
                ", situationFamiliale=" + situationFamiliale +
                ", createdAt=" + createdAt +
                ", score=" + score +
                '}';

}}
