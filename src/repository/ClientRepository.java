package repository;


import database.Database;
import models.Personne;
import models.Employe;
import models.Professionnel;
import utils.*;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ClientRepository  {

    private final Connection conn;

//    constructor to get a DB connection
    public ClientRepository() throws SQLException{
        this.conn = Database.getInstance().getConnection();
    }

//    prepare, create and add client to the db

    public void addClient(Personne client) throws SQLException{

        String sql = "INSERT INTO clients (type_client, nom, prenom, date_naissance, ville, nombre_enfants," +
                "investissement, placement, situation_familiale, score, salaire, anciennete, poste, type_contrat, secteur_emploi," +
                "revenu, immatriculation_fiscale, secteur_activite, activite) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

//     preparing

        try(PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
        // this for both professional and employee
            stmt.setString(2, client.getNom());
            stmt.setString(3, client.getPrenom());
            stmt.setDate(4, Date.valueOf(client.getDateNaissance()));
            stmt.setString(5, client.getVille());
            stmt.setInt(6, client.getNombreEnfants());
            stmt.setDouble(7, client.getInvestissement());
            stmt.setDouble(8, client.getPlacement());
            stmt.setString(9, client.getSituationFamiliale().name());
            stmt.setInt(10, client.getScore());

            if (client instanceof Employe) {
                Employe e = (Employe) client;
                stmt.setDouble(11, e.getSalaire());
                stmt.setInt(12, e.getAnciennete());
                stmt.setString(13, e.getPoste());
                stmt.setString(14, e.getTypeContrat().name());
                stmt.setString(15, e.getSecteur().name());

                // null for professionnel fields
                stmt.setNull(16, Types.DOUBLE);
                stmt.setNull(17, Types.VARCHAR);
                stmt.setNull(18, Types.VARCHAR);
                stmt.setNull(19, Types.VARCHAR);
            } else if (client instanceof Professionnel) {
                Professionnel p = (Professionnel) client;
                stmt.setNull(11, Types.DOUBLE);
                stmt.setNull(12, Types.INTEGER);
                stmt.setNull(13, Types.VARCHAR);
                stmt.setNull(14, Types.VARCHAR);
                stmt.setNull(15, Types.VARCHAR);

                stmt.setDouble(16, p.getRevenu());
                stmt.setString(17, p.getImmatriculationFiscale());
                stmt.setString(18, p.getSecteurActivite().name());
                stmt.setString(19, p.getActivite());
            }
            stmt.executeUpdate();

        // set generated ID for clients
            try(ResultSet generatedKeys = stmt.getGeneratedKeys()){
                if(generatedKeys.next()){
                    client.setId(generatedKeys.getInt(1));
                }
            }
        }


    }

//Read : to get all clients
public List<Personne> getAllClients() throws SQLException {
    List<Personne> clients = new ArrayList<>();
    String sql = "SELECT * FROM clients";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            clients.add(mapResultSetToClient(rs));
        }
    }
    return clients;
}
//Update
    public void updateCLientScore(int clienId, int newScore) throws SQLException{
        String sql = "UPDATE clients SET score = ? WHERE ID = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt((1,clienId));
        }
    }
//raw data to java object
    private Personne mapResultSetToClient(ResultSet rs) throws SQLException {
        String type = rs.getString("type_client");
        String nom = rs.getString("nom");
        String prenom = rs.getString("prenom");
        LocalDate dateNaissance = rs.getDate("date_naissance").toLocalDate();
        String ville = rs.getString("ville");
        int nombreEnfants = rs.getInt("nombre_enfants");
        double investissement = rs.getDouble("investissement");
        double placement = rs.getDouble("placement");
        SituationFamiliale situationFamiliale = SituationFamiliale.valueOf(rs.getString("situation_familiale"));
        LocalDate createdAt = rs.getTimestamp("created_at").toLocalDateTime().toLocalDate();
        int score = rs.getInt("score");

        Personne personne;

        if ("EMPLOYE".equals(type)) {
            double salaire = rs.getDouble("salaire");
            int anciennete = rs.getInt("anciennete");
            String poste = rs.getString("poste");
            TypeContrat typeContrat = TypeContrat.valueOf(rs.getString("type_contrat"));
            SecteurEmploi secteur = SecteurEmploi.valueOf(rs.getString("secteur_emploi"));

            personne = new Employe(nom, prenom, dateNaissance, ville, nombreEnfants,
                    investissement, placement, situationFamiliale, createdAt,
                    score, salaire, anciennete, poste, typeContrat, secteur);
        } else {
            double revenu = rs.getDouble("revenu");
            String immatriculationFiscale = rs.getString("immatriculation_fiscale");
            SecteurActivite secteurActivite = SecteurActivite.valueOf(rs.getString("secteur_activite"));
            String activite = rs.getString("activite");

            personne = new Professionnel(nom, prenom, dateNaissance, ville, nombreEnfants,
                    investissement, placement, situationFamiliale, createdAt,
                    score, revenu, immatriculationFiscale, secteurActivite, activite);
        }

        return personne;
    }
}
