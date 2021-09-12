import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Client
{
    private Connection laConnexion;

    public Client()
    {
        Connexion maBD = new Connexion();
        laConnexion = maBD.creeConnexion();
    }

    public void add(String nom, String prenom, String noRue, String voie, String codePostal, String ville, String pays)
    {
        try
        {
            PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO Client(nom, prenom, no_rue, voie, code_postal, ville, pays) Values (?, ?, ?, ?, ?, ?, ?)");
            requete.setString(1, nom);
            requete.setString(2, prenom);
            requete.setString(3, noRue);
            requete.setString(4, voie);
            requete.setString(5, codePostal);
            requete.setString(6, ville);
            requete.setString(7, pays);
            int res = requete.executeUpdate();

            if (requete != null)
                requete.close();
            if (laConnexion != null)
                laConnexion.close();

            System.out.println("Ajouté avec succes");
        } catch (SQLException sqle)
        {
            System.out.println("Pb add Client" + sqle.getMessage());
        }
    }

    public void remove(int id_client)
    {
        try
        {
            PreparedStatement requete = laConnexion.prepareStatement("DELETE FROM Client WHERE id_client = ?");
            requete.setInt(1, id_client);
            int res = requete.executeUpdate();


            if (requete != null)
                requete.close();
            if (laConnexion != null)
                laConnexion.close();

            if (res == 1)
            {
                System.out.println("Elément supprimé avec succès !");
            }
            else
            {
                System.out.println("Aucune ligne trouvée");
            }
        } catch (SQLException sqle)
        {
            System.out.println("Pb remove Client" + sqle.getMessage());
        }
    }

    public void edit(int idClient, String nom, String prenom, String noRue, String voie, String codePostal, String ville, String pays)
    {
        try
        {
            PreparedStatement requete = laConnexion.prepareStatement("UPDATE Client SET nom = ?,SET prenom = ?, SET no_rue = ?" +
                    ", SET voie = ?, SET code_postal = ?, SET ville = ?, SET pays = ?) WHERE id_client =  ?");
            requete.setString(1, nom);
            requete.setString(2, prenom);
            requete.setString(3, noRue);
            requete.setString(4, voie);
            requete.setString(5, codePostal);
            requete.setString(6, ville);
            requete.setString(7, pays);
            requete.setInt(8, idClient);
            int res = requete.executeUpdate();

            if (requete != null)
                requete.close();
            if (laConnexion != null)
                laConnexion.close();

            System.out.println("Ajouté avec succes");
        } catch (SQLException sqle)
        {
            System.out.println("Pb add Client" + sqle.getMessage());
        }
    }
}
