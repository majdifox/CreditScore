package models;

import utils.TypeContrat;
import utils.SecteurEmploi;
import utils.SituationFamiliale;
import java.time.LocalDate;

public class Employe extends Personne {
    // ====== Fields ======
    private double salaire;
    private int anciennete; // in years
    private String poste;
    private TypeContrat typeContrat;  // enum
    private SecteurEmploi secteur;     // enum

    // ====== Constructor ======
    public Employe(String nom, String prenom, LocalDate dateNaissance, String ville,
                   int nombreEnfants, double investissement, double placement,
                   SituationFamiliale situationFamiliale, LocalDate createdAt, int score,
                   double salaire, int anciennete, String poste,
                   TypeContrat typeContrat, SecteurEmploi secteur) {

        super(nom, prenom, dateNaissance, ville, nombreEnfants, investissement,
                placement, situationFamiliale, createdAt, score);

        this.salaire = salaire;
        this.anciennete = anciennete;
        this.poste = poste;
        this.typeContrat = typeContrat;
        this.secteur = secteur;
    }

    // ====== Getters & Setters ======
    public double getSalaire() { return salaire; }
    public void setSalaire(double salaire) { this.salaire = salaire; }

    public int getAnciennete() { return anciennete; }
    public void setAnciennete(int anciennete) { this.anciennete = anciennete; }

    public String getPoste() { return poste; }
    public void setPoste(String poste) { this.poste = poste; }

    public TypeContrat getTypeContrat() { return typeContrat; }
    public void setTypeContrat(TypeContrat typeContrat) { this.typeContrat = typeContrat; }

    public SecteurEmploi getSecteur() { return secteur; }
    public void setSecteur(SecteurEmploi secteur) { this.secteur = secteur; }

    // ====== Utility ======
    @Override
    public String toString() {
        return super.toString() + " Employe{" +
                "salaire=" + salaire +
                ", anciennete=" + anciennete +
                ", poste='" + poste + '\'' +
                ", typeContrat=" + typeContrat +
                ", secteur=" + secteur +
                '}';
    }
}
