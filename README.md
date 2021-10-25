[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com)
----------
### Pour faire fonctionner l'appli, penser a importer les librairies + a mettre le bon chemin dans la Run Configuration
----------

### Ce qui fonctionne

- Le Menu général

- Sélection de la ListeMémoire ou de MySQL

- Les ajouts (ListeMémoire ou MySQL) pour :
  - Abonnement
  - Client
  - Périodicité
  - Revue

- Les suppressions (ListeMémoire ou MySQL) pour :
  - Abonnement
  - Client
  - Périodicité
  - Revue

- Une fenêtre de confirmation lors de la suppression d'un élément

- Les modifications (ListeMémoire ou MySQL) pour :
  - Abonnement
  - Client
  - Périodicité
  - Revue

- L'importation d'une liste de clients en .csv

- L'affichage lors du double clic pour : 
  - Abonnement
  - Client
  - Périodicité
  - Revue

----------

### Ce qui ne fonctionne pas

- La sélection de MySQL lorsque le VPN n'est pas activé (Indication au client de penser à activer le VPN)
- L'affichage d'un visuel pour une revue
- Leger beug avec l'utilisation de MySQL, pour le tarif d'une revue, le prix n'est pas exactement celui rentré
----------

### Répartition des tâches

Léane : 
- Réalisation des interfaces JavaFX
- Classe Metier de Periodicité
- Les controlleurs de Periodicité
- Méthodes de Tests pour "Périodicité"
- README.txt
- Correction des bugs
- Test de l'appli

Romain : 
- Classe Metier (Revue, Abonnement, Client)
- Classe Test (Revue, Abonnement, Client)
- Controlleur (Revue, Abonnement, Client)
- Gestion de la DAO
- Correction des bugs
- Test de l'appli
----------

### % D'investissement

Romain : 70% 

Léane : 30%
