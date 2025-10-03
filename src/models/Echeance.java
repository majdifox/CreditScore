package models;

import java.time.LocalDate;
import utils.StatutPaiement;

public class Echeance {
    private LocalDate dateEcheance;
    private double mensualite;
    private LocalDate dateDePaiement;
    private StatutPaiement statutPaiement;
    private Credit credit; // the credit this installment belongs to

    // ====== Constructor ======
    public Echeance(LocalDate dateEcheance, double mensualite, LocalDate dateDePaiement,
                    StatutPaiement statutPaiement, Credit credit) {
        this.dateEcheance = dateEcheance;
        this.mensualite = mensualite;
        this.dateDePaiement = dateDePaiement;
        this.statutPaiement = statutPaiement;
        this.credit = credit;
    }

    // ====== Getters & Setters ======
    public LocalDate getDateEcheance() { return dateEcheance; }
    public void setDateEcheance(LocalDate dateEcheance) { this.dateEcheance = dateEcheance; }

    public double getMensualite() { return mensualite; }
    public void setMensualite(double mensualite) { this.mensualite = mensualite; }

    public LocalDate getDateDePaiement() { return dateDePaiement; }
    public void setDateDePaiement(LocalDate dateDePaiement) { this.dateDePaiement = dateDePaiement; }

    public StatutPaiement getStatutPaiement() { return statutPaiement; }
    public void setStatutPaiement(StatutPaiement statutPaiement) { this.statutPaiement = statutPaiement; }

    public Credit getCredit() { return credit; }
    public void setCredit(Credit credit) { this.credit = credit; }

    // ====== toString ======
    @Override
    public String toString() {
        return "Echeance{" +
                "dateEcheance=" + dateEcheance +
                ", mensualite=" + mensualite +
                ", dateDePaiement=" + dateDePaiement +
                ", statutPaiement=" + statutPaiement +
                ", credit=" + credit.getClient().getNom() + " " + credit.getClient().getPrenom() +
                '}';
    }
}
