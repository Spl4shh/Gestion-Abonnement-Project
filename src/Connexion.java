import java.sql.*;
public class Connexion {
    public Connection creeConnexion() {
        String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/muller851u_td_java";
        url += "?serverTimezone=Europe/Paris";
        String login = "muller851u_appli";
        String pwd = "Riquzo_8";
        Connection maConnexion = null;

        try 
        {
            maConnexion = DriverManager.getConnection(url, login, pwd);
        } catch (SQLException sqle) {
            System.out.println("Erreur connexion \n" + sqle.getMessage());
        }
        return maConnexion;
    }
}
