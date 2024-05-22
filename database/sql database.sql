-- Table des projets
CREATE TABLE projets (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100),
    description TEXT,
    date_debut DATE,
    date_fin DATE,
    budget NUMERIC(10, 2)
);

-- Table des tâches
CREATE TABLE taches (
    id SERIAL PRIMARY KEY,
    id_projet INT,
    description TEXT,
    date_debut DATE,
    date_fin DATE,
    statut VARCHAR(20),
    ressources TEXT,
    FOREIGN KEY (id_projet) REFERENCES projets(id)
);

-- Table des ressources
CREATE TABLE ressources (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100),
    type VARCHAR(50),
    quantite INT,
    info_fournisseur TEXT,
    id_tache INT,
    FOREIGN KEY (id_tache) REFERENCES taches(id)
);
