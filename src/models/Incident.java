package models;

import java.time.LocalDate;
import utils.TypeIncident;

public class Incident {
    private LocalDate dateIncident;
    private Echeance echeance; // the payment that caused it
    private int scoreImpact;    // how much this incident affects the score
    private TypeIncident typeIncident;

    // ====== Constructor ======
    public Incident(LocalDate dateIncident, Echeance echeance, int scoreImpact, TypeIncident typeIncident) {
        this.dateIncident = dateIncident;
        this.echeance = echeance;
        this.scoreImpact = scoreImpact;
        this.typeIncident = typeIncident;
    }

    // ====== Getters & Setters ======
    public LocalDate getDateIncident() { return dateIncident; }
    public void setDateIncident(LocalDate dateIncident) { this.dateIncident = dateIncident; }

    public Echeance getEcheance() { return echeance; }
    public void setEcheance(Echeance echeance) { this.echeance = echeance; }

    public int getScoreImpact() { return scoreImpact; }
    public void setScoreImpact(int scoreImpact) { this.scoreImpact = scoreImpact; }

    public TypeIncident getTypeIncident() { return typeIncident; }
    public void setTypeIncident(TypeIncident typeIncident) { this.typeIncident = typeIncident; }

    // ====== toString ======
    @Override
    public String toString() {
        return "Incident{" +
                "dateIncident=" + dateIncident +
                ", echeance=" + echeance.getCredit().getClient().getNom() + " " +
                echeance.getCredit().getClient().getPrenom() +
                ", scoreImpact=" + scoreImpact +
                ", typeIncident=" + typeIncident +
                '}';
    }
}
