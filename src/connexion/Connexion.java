package connexion;
import java.sql.*;

public class Connexion 
 {
    private static Connexion instance;
    private String url, dbName, pwd, login;
    private Connection maConnexion;

    private Connexion()
    {
        this.creeConnexion();
    }

    public static Connexion getInstance()
    {
         if (instance == null)
         {
             instance = new Connexion();

         }
         return instance;
    }

     public Connection creeConnexion()
    { 
        //Pour l'instant les identifiants sont ici, plus tard dans un fichier XML
        dbName = "nataneli1u_td_cpoa";
        pwd = "Xbb8R2D2";
        login = "nataneli1u_appli";

        String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/" + dbName;
        url += "?serverTimezone=Europe/Paris";
        maConnexion = null;

        try 
        {
            DriverManager.setLoginTimeout(1);
            maConnexion = DriverManager.getConnection(url, login, pwd);
        }
        catch (SQLException sqle)
        {
            System.out.println("Erreur connexion \n" + sqle.getMessage());
        }
        return maConnexion;
    }
}
