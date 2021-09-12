import java.sql.*;

public class Connexion
{
    public Connection creeConnexion()
    {
        String url =
                "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/nataneli1u_td_cpoa";
        url += "?serverTimezone=Europe/Paris";
        String login = "nataneli1u_appli";
        String pwd = "Xbb8R2D2";
        Connection maConnexion = null;

        try
        {
            maConnexion = DriverManager.getConnection(url, login, pwd);
        } catch (SQLException sqle)
        {
            System.out.println("Erreur connexion\n" + sqle.getMessage());
        }
        return maConnexion;
    }
}