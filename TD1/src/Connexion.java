import java.sql.*;
public class Connexion {
    public Connection creeConnexion() {
        String url =
                "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/muller851u_base";
        url += "?serverTimezone=Europe/Paris";
        String login = "muller851u_appli";
        String pwd = "Riquzo_8";
        Connection maConnexion = null;

        try {
            maConnexion = DriverManager.getConnection(url, login, pwd);
        } catch (SQLException sqle) {
            System.out.println("Erreur connexion" + sqle.getMessage());
        }
        return maConnexion;
    }

    /* Méthode d'ajout d'une periodicité */
    public void addPeriodicite(String idPeriodicite, String libelle) {

        try {
            Connection laConnexion = creeConnexion();
            PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO Periodicite VALUES(?,?)");
            requete.setString(1,idPeriodicite); // On définit la 1e valeur de VALUES(?,?) // VALUES(1,2)
            requete.setString(2,libelle);
            ResultSet res = requete.executeQuery();

            if (res != null) //Fermer c'est plus propre
                res.close();

        } catch (SQLException sqle) {

            System.out.println("Problème d'ajout de périodicité" + sqle.getMessage());

        }
    }

    /* Méthode de suppression d'une periodicité */
    public void removePeriodicite(String idPeriodicite) {

        try {
            Connection laConnexion = creeConnexion();
            PreparedStatement requete = laConnexion.prepareStatement("DELETE FROM Periodicite WHERE idPeriodicite = ?");
            requete.setString(1,idPeriodicite);
            ResultSet res = requete.executeQuery();

            if (res != null)
                res.close();

        } catch (SQLException sqle) {

            System.out.println("Problème de suppression d'une periodicité" + sqle.getMessage());

        }
    }

    /* Méthode d'édition d'une periodicité */
    public void editPeriodicite(String idPeriodicite, String libelle) {

        try {
            Connection laConnexion = creeConnexion();
            PreparedStatement requete = laConnexion.prepareStatement("UPDATE Periodicite SET libelle = ? WHERE idPeriodicite = ?");
            requete.setString(1,idPeriodicite);
            requete.setString(2,libelle);
            ResultSet res = requete.executeQuery();

            if (res != null)
                res.close();

        } catch (SQLException sqle) {

            System.out.println("Problème d'édition d'une periodicité" + sqle.getMessage());

        }
    }
}