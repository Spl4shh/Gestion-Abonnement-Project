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

    public void uneRequete() {

        try {
            Connection laConnexion = creeConnexion();
            Statement requete = laConnexion.createStatement();
            ResultSet res = requete.executeQuery("select no_etudiant, nom_etudiant from etudiant");

        } catch (SQLException sqle) {

            System.out.println("Pb select" + sqle.getMessage());

        }
    }
}