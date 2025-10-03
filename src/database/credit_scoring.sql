-- ===================================
-- DATABASE: credit_scoring
-- Created for: Credit Scoring System
-- ===================================

CREATE DATABASE IF NOT EXISTS credit_scoring;
USE credit_scoring;

-- ===================================
-- Table 1: CLIENTS (Employe + Professionnel)
-- ===================================
DROP TABLE IF EXISTS score_history;
DROP TABLE IF EXISTS incidents;
DROP TABLE IF EXISTS echeances;
DROP TABLE IF EXISTS credits;
DROP TABLE IF EXISTS clients;

CREATE TABLE clients (
    id INT AUTO_INCREMENT PRIMARY KEY,

    -- Type discriminator
    type_client ENUM('EMPLOYE','PROFESSIONNEL') NOT NULL,

    -- Base Personne fields
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    date_naissance DATE NOT NULL,
    ville VARCHAR(100),
    nombre_enfants INT DEFAULT 0,
    investissement DOUBLE DEFAULT 0,
    placement DOUBLE DEFAULT 0,
    situation_familiale ENUM('MARIE','CELIBATAIRE','DIVORCE','VEUF') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    score INT DEFAULT 0,

    -- Employe-specific
    salaire DOUBLE DEFAULT NULL,
    anciennete INT DEFAULT NULL COMMENT 'Anciennete en mois ou points',
    poste VARCHAR(100) DEFAULT NULL,
    type_contrat ENUM('CDI_PUBLIC','CDI_PRIVE_GRANDE_ENTREPRISE','CDI_PRIVE_PME','CDD_INTERIM','PROFESSION_LIBERALE','AUTO_ENTREPRENEUR') DEFAULT NULL,
    secteur_emploi ENUM('PUBLIC','GRANDE_ENTREPRISE','PME','AUTRE') DEFAULT NULL,

    -- Professionnel-specific
    revenu DOUBLE DEFAULT NULL,
    immatriculation_fiscale VARCHAR(50) DEFAULT NULL,
    secteur_activite ENUM('AGRICULTURE','SERVICE','COMMERCE','CONSTRUCTION','INDUSTRIE','AUTRE') DEFAULT NULL,
    activite VARCHAR(100) DEFAULT NULL,

    -- Indexes for analytics
    INDEX idx_score (score),
    INDEX idx_type_client (type_client),
    INDEX idx_created_at (created_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ===================================
-- Table 2: CREDITS
-- ===================================
CREATE TABLE credits (
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT NOT NULL,
    date_credit DATE NOT NULL,
    montant_demande DOUBLE NOT NULL,
    montant_octroye DOUBLE DEFAULT NULL,
    taux_interet DOUBLE DEFAULT NULL COMMENT 'Taux en pourcentage',
    duree_en_mois INT DEFAULT NULL,
    type_credit ENUM('IMMOBILIER','CONSOMMATION','AUTO','AUTRE') NOT NULL,
    decision ENUM('ACCORD_IMMEDIAT','ETUDE_MANUELLE','REFUS_AUTOMATIQUE') NOT NULL,
    score_at_credit INT DEFAULT 0 COMMENT 'Score du client au moment de la demande',

    FOREIGN KEY (client_id) REFERENCES clients(id) ON DELETE CASCADE,
    INDEX idx_client_id (client_id),
    INDEX idx_date_credit (date_credit),
    INDEX idx_decision (decision)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ===================================
-- Table 3: ECHEANCES
-- ===================================
CREATE TABLE echeances (
    id INT AUTO_INCREMENT PRIMARY KEY,
    credit_id INT NOT NULL,
    date_echeance DATE NOT NULL,
    mensualite DOUBLE NOT NULL,
    date_paiement DATE DEFAULT NULL COMMENT 'NULL si pas encore paye',
    statut_paiement ENUM('PAYEATEMPS','ENRETARD','PAYEENRETARD','IMPAYEREGLE','IMPAYENONREGLE') NOT NULL,

    FOREIGN KEY (credit_id) REFERENCES credits(id) ON DELETE CASCADE,
    INDEX idx_credit_id (credit_id),
    INDEX idx_date_echeance (date_echeance),
    INDEX idx_statut_paiement (statut_paiement)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ===================================
-- Table 4: INCIDENTS
-- ===================================
CREATE TABLE incidents (
    id INT AUTO_INCREMENT PRIMARY KEY,
    echeance_id INT NOT NULL,
    date_incident DATE NOT NULL,
    score_impact INT DEFAULT 0 COMMENT 'Peut etre negatif ou positif',
    type_incident ENUM('PAYEATEMPS','ENRETARD','PAYEENRETARD','IMPAYEREGLE','IMPAYENONREGLE') NOT NULL,

    FOREIGN KEY (echeance_id) REFERENCES echeances(id) ON DELETE CASCADE,
    INDEX idx_echeance_id (echeance_id),
    INDEX idx_date_incident (date_incident),
    INDEX idx_type_incident (type_incident)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ===================================
-- Table 5: SCORE_HISTORY
-- ===================================
CREATE TABLE score_history (
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT NOT NULL,
    score INT NOT NULL,
    date_calcul TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    reason VARCHAR(255) DEFAULT NULL COMMENT 'Ex: Demande credit, Paiement en retard',

    FOREIGN KEY (client_id) REFERENCES clients(id) ON DELETE CASCADE,
    INDEX idx_client_id (client_id),
    INDEX idx_date_calcul (date_calcul)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ===================================
-- Optional: Sample Data
-- ===================================
INSERT INTO clients (type_client, nom, prenom, date_naissance, ville, nombre_enfants, investissement, placement, situation_familiale, score, salaire, anciennete, poste, type_contrat, secteur_emploi)
VALUES ('EMPLOYE', 'Alami', 'Hassan', '1985-05-15', 'Casablanca', 2, 50000, 20000, 'MARIE', 0, 8000, 60, 'Ingenieur', 'CDI_PUBLIC', 'PUBLIC');

INSERT INTO clients (type_client, nom, prenom, date_naissance, ville, nombre_enfants, investissement, placement, situation_familiale, score, revenu, immatriculation_fiscale, secteur_activite, activite)
VALUES ('PROFESSIONNEL', 'Bennani', 'Fatima', '1990-08-20', 'Rabat', 1, 30000, 15000, 'MARIE', 0, 6500, 'IF12345678', 'SERVICE', 'Avocat');

