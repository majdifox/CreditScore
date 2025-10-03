package models;

import java.time.LocalDate;
import utils.Decision;
import utils.TypeCredit;

public class Credit {
    private LocalDate dateDeCredit;
    private double montantDemande;
    private double montantOctroye;
    private double tauxInteret;
    private int dureeEnMois;
    private TypeCredit typeCredit;
    private Decision decision;
    private Personne client; // The borrower

    // ====== Constructor ======
    public Credit(LocalDate dateDeCredit, double montantDemande, double montantOctroye,
                  double tauxInteret, int dureeEnMois, TypeCredit typeCredit,
                  Decision decision, Personne client) {
        this.dateDeCredit = dateDeCredit;
        this.montantDemande = montantDemande;
        this.montantOctroye = montantOctroye;
        this.tauxInteret = tauxInteret;
        this.dureeEnMois = dureeEnMois;
        this.typeCredit = typeCredit;
        this.decision = decision;
        this.client = client;
    }

    // ====== Getters & Setters ======
    public LocalDate getDateDeCredit() { return dateDeCredit; }
    public void setDateDeCredit(LocalDate dateDeCredit) { this.dateDeCredit = dateDeCredit; }

    public double getMontantDemande() { return montantDemande; }
    public void setMontantDemande(double montantDemande) { this.montantDemande = montantDemande; }

    public double getMontantOctroye() { return montantOctroye; }
    public void setMontantOctroye(double montantOctroye) { this.montantOctroye = montantOctroye; }

    public double getTauxInteret() { return tauxInteret; }
    public void setTauxInteret(double tauxInteret) { this.tauxInteret = tauxInteret; }

    public int getDureeEnMois() { return dureeEnMois; }
    public void setDureeEnMois(int dureeEnMois) { this.dureeEnMois = dureeEnMois; }

    public TypeCredit getTypeCredit() { return typeCredit; }
    public void setTypeCredit(TypeCredit typeCredit) { this.typeCredit = typeCredit; }

    public Decision getDecision() { return decision; }
    public void setDecision(Decision decision) { this.decision = decision; }

    public Personne getClient() { return client; }
    public void setClient(Personne client) { this.client = client; }

    // ====== toString ======
    @Override
    public String toString() {
        return "Credit{" +
                "dateDeCredit=" + dateDeCredit +
                ", montantDemande=" + montantDemande +
                ", montantOctroye=" + montantOctroye +
                ", tauxInteret=" + tauxInteret +
                ", dureeEnMois=" + dureeEnMois +
                ", typeCredit=" + typeCredit +
                ", decision=" + decision +
                ", client=" + client.getNom() + " " + client.getPrenom() +
                '}';
    }
}
