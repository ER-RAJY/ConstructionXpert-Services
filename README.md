# ConstructionXpert Services

ConstructionXpert Services est une application de gestion de projets de construction destinée à fournir à l'équipe de construction un outil efficace pour planifier et organiser les projets de construction. L'application offre une interface conviviale pour visualiser, mettre à jour et supprimer des projets, des tâches et des ressources, tout en garantissant la sécurité des données et l'intégrité du système.

## Fonctionnalités

### Gestion des Projets

- Créer un nouveau projet en spécifiant son nom, sa description, sa date de début, sa date de fin et son budget.
- Afficher la liste des projets existants avec leurs détails.
- Mettre à jour les détails d'un projet existant.
- Supprimer un projet existant.

### Gestion des Tâches

- Créer une nouvelle tâche pour un projet en spécifiant sa description, sa date de début, sa date de fin, son statut (à faire, en cours, terminé) et les ressources nécessaires.
- Afficher la liste des tâches associées à un projet avec leurs détails.
- Mettre à jour les détails d'une tâche existante.
- Supprimer une tâche existante.

### Gestion des Ressources

- Ajouter de nouvelles ressources avec leurs détails tels que le nom, le type, la quantité et les informations du fournisseur.
- Afficher la liste des ressources disponibles avec leurs détails.
- Mettre à jour les détails d'une ressource existante.
- Supprimer une ressource existante.

## Conception UML

### Diagramme de Classe
![Diagramme de Classe](https://github.com/ER-RAJY/ConstructionXpert-Services/blob/main/Conception%20Uml/Diagramme%20de%20class.png)

### Diagramme de Cas d'Utilisation
![Diagramme de Cas d'Utilisation](https://github.com/ER-RAJY/ConstructionXpert-Services/blob/main/Conception%20Uml/Diagramme%20de%20use%20case.png)

### Diagramme de Séquence
![Diagramme de Séquence](https://github.com/ER-RAJY/ConstructionXpert-Services/blob/main/Conception%20Uml/Diagramme%20de%20sequence.png)

## Requêtes de la Base de Données

```sql
CREATE TABLE projects (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    description TEXT,
    start_date DATE,
    end_date DATE,
    budget NUMERIC(10, 2)
);

CREATE TABLE tasks (
    id SERIAL PRIMARY KEY,
    project_id INT,
    description TEXT,
    start_date DATE,
    end_date DATE,
    status VARCHAR(20),
    FOREIGN KEY (project_id) REFERENCES projects(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE resources (
    id SERIAL PRIMARY KEY,
    task_id INT,
    name VARCHAR(100),
    type VARCHAR(50),
    quantity INT,
    supplier_info TEXT,
    FOREIGN KEY (task_id) REFERENCES tasks(id) ON DELETE CASCADE ON UPDATE CASCADE
);
