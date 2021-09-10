import java.sql.*;
public class Connexion {
    public Connection creeConnexion() {
        String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/muller851u_td_java";
        url += "?serverTimezone=Europe/Paris";
        String login = "muller851u_appli";
        String pwd = "Riquzo_8";
        Connection maConnexion = null;

        try {
            maConnexion = DriverManager.getConnection(url, login, pwd);
        } catch (SQLException sqle) {
            System.out.println("Erreur connexion \n" + sqle.getMessage());
        }
        return maConnexion;
    }

    /* Méthode d'ajout d'une periodicité */
    public void addPeriodicite(String libelle) {

        try {
            Connection laConnexion = creeConnexion();
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
            Connection laConnexion = creeConnexion();
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
            Connection laConnexion = creeConnexion();
            PreparedStatement requete = laConnexion.prepareStatement("UPDATE Periodicite SET libelle = ? WHERE id_periodicite = ?");
            requete.setInt(1,idPeriodicite);
            requete.setString(2,libelle);
            int res = requete.executeUpdate();
            System.out.println("Edité avec succès");


        } catch (SQLException sqle) {

            System.out.println("Problème d'édition d'une périodicité\n" + sqle.getMessage());

        }
    }
}