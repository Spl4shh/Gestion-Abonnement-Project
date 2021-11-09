package connexion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Connexion 
 {
    private static Connexion instance;
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
        Properties accesBD = null;

        accesBD = lectureIdentifiantConnexion();

        //jdbc:mysql://LIEN_BD:PORT/"
        String url = "jdbc:mysql://"+accesBD.getProperty("adresse")+":"+accesBD.getProperty("port")+"/"+accesBD.getProperty("bdd");
        url += "?serverTimezone=Europe/Paris";
        maConnexion = null;

        try 
        {
            DriverManager.setLoginTimeout(1);
            maConnexion = DriverManager.getConnection(url, accesBD.getProperty("login"), accesBD.getProperty("pass"));
        }
        catch (SQLException sqle)
        {
            System.out.println("Erreur connexion \n" + sqle.getMessage());
        }
        return maConnexion;
    }

    public Properties lectureIdentifiantConnexion()
    {
        Properties accesBdd = new Properties();
        File fBdd = new File("src/connexion/mysql_properties.xml");

        try
        {
            FileInputStream source = new FileInputStream(fBdd);
            accesBdd.loadFromXML(source);
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        return accesBdd;
    }
}
