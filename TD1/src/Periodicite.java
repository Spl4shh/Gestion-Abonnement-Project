import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Periodicite {

    private Connection laConnexion;
    public Periodicite() {
            Connexion bdd = new Connexion();
            laConnexion = bdd.creeConnexion();
        }
    /* Méthode d'ajout d'une periodicité */
    public void addPeriodicite(String libelle) {

        try {
            //Connection laConnexion = creeConnexion();
            PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO Periodicite(libelle) VALUES(?)");
            requete.setString(1,libelle);
            Integer res = requete.executeUpdate();
            System.out.println("Ajouté avec succès");

        } catch (SQLException sqle) {

            System.out.println("Problème d'ajout de périodicité\n" + sqle.getMessage());

        }
    }

    /* Méthode de suppression d'une periodicité */
    public void removePeriodicite(int idPeriodicite) {

        try {
            PreparedStatement requete = laConnexion.prepareStatement("DELETE FROM Periodicite WHERE id_periodicite = ?");
            requete.setInt(1,idPeriodicite);
            int res = requete.executeUpdate();
            if (res == 1) {
                System.out.println("Supprimé avec succès");
            }
            else {
                System.out.println("Aucune ligne trouvée");
            }


        } catch (SQLException sqle) {

            System.out.println("Problème de suppression d'une periodicité\n" + sqle.getMessage());

        }
    }

    /* Méthode d'édition d'une periodicité */
    public void editPeriodicite(int idPeriodicite, String libelle) {

        try {
            PreparedStatement requete = laConnexion.prepareStatement("UPDATE Periodicite SET libelle = ? WHERE id_periodicite = ?");
            requete.setString(1,libelle);
            requete.setInt(2,idPeriodicite);
            int res = requete.executeUpdate();
            System.out.println("Modifié avec succès");


        } catch (SQLException sqle) {

            System.out.println("Problème d'édition d'une périodicité\n" + sqle.getMessage());

        }
    }
}
