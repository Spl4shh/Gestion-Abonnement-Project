import java.sql.*;

public class Revue {

    // Connexion déjà établie, je commente les lignes ?
    /* private Connection laConnexion;
    public Revue() {
        Connexion bdd = new Connexion();
        laConnexion = bdd.creeConnexion();
    }*/

    /* Méthode d'ajout d'une Revue */
    public void add(int id, String titre, String description,float tarif, String visuel, int periodicite ) {

        try {
            //Connection laConnexion = creeConnexion();
            PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO Periodicite(libelle) VALUES(?)");
            System.out.println("Veuillez entrer :\n");

            System.out.println("L'identifiant de la revue : ");
            requete.setInt(1,id);

            System.out.println("Le titre : ");
            requete.setString(2,titre);

            System.out.println("La description : ");
            requete.setString(3, description);

            System.out.println("Le tarif : ");
            requete.setFloat(4, tarif);

            System.out.println("Le visuel : ");
            requete.setString(5, visuel);

            System.out.println("La périodicité : ");
            requete.setInt(6, periodicite);

            Integer res = requete.executeUpdate();
            System.out.println("Ajouté avec succès");

        } catch (SQLException sqle) {

            System.out.println("Problème d'ajout de périodicité\n" + sqle.getMessage());

        }
    }


    /* Méthode de suppression d'une Revue */
    public void remove(int idRevue) {

        try {
            PreparedStatement requete = laConnexion.prepareStatement("DELETE FROM Revue WHERE id_revue = ?");
            
            System.out.println("Veuillez entre l'identifiant de la revue : ");
            requete.setInt(1,idRevue);

            int res = requete.executeUpdate();
            if (res == 1) {
                System.out.println("Elément supprimé avec succès !");
            }
            else {
                System.out.println("Aucune ligne trouvée");
            }


        } catch (SQLException sqle) {

            System.out.println("Problème de suppression d'une Revue'\n" + sqle.getMessage());

        }
    }


    /* Méthode d'édition d'une Revue */
    public void edit(int idRevue, String titre, String description, float tarif, String visuel) {

        try {
            PreparedStatement requete = laConnexion.prepareStatement("UPDATE Revue SET titre = ?, description = ?, tarif_numero = ?, visuel = ?, WHERE id_periodicite = ?");
            
            System.out.println("Veuillez entre l'identifiant de la revue : ");
            requete.setInt(1,idRevue);

            System.out.println("Veuillez entrer : ");
            
            System.out.println("Le titre : ");
            requete.setString(2,titre);

            System.out.println("La description : ");
            requete.setString(3,description);

            System.out.println("Le tarif : ");
            requete.setFloat(4, tarif);

            System.out.println("Le visuel : ");
            requete.setString(5, visuel);

            int res = requete.executeUpdate();
            System.out.println("Modifié avec succès");


        } catch (SQLException sqle) {

            System.out.println("Problème d'édition d'une Revue\n" + sqle.getMessage());

        }
    }
}
