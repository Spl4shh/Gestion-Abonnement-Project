[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com)
----------
### Pour faire fonctionner l'appli, penser a importer les librairies + a mettre le bon chemin dans la Run Configuration
### Penser egalement à importer le sql dans la bd, et modifier le fichier mysql_properties.xml dans connexion
----------
L'application possede une interface graphique créé en JavaFX sous SceneBuilder.
Une DAO a également été implémenté afin de pouvoir utiliser différents moyens de persistances.
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
