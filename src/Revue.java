import java.sql.*;

public class Revue
{

    private Connection laConnexion;
    public Revue()
    {
        Connexion bdd = new Connexion();
        laConnexion = bdd.creeConnexion();
    }

    /* Méthode d'ajout d'une Revue */
    public void add(String titre, String description, float tarif, String visuel, int periodicite)
    {
        try
        {
            PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO Revue(titre, description, tarif_numero, visuel, id_periodicite) VALUES(?, ?, ?, ?, ?)");

            requete.setString(1,titre);
            requete.setString(2, description);
            requete.setFloat(3, tarif);
            requete.setString(4, visuel);
            requete.setInt(5, periodicite);

            Integer res = requete.executeUpdate();
            System.out.println("Ajouté avec succès");

        } catch (SQLException sqle)
        {
            System.out.println("Problème d'ajout de revue\n" + sqle.getMessage());
        }
    }


    /* Méthode de suppression d'une Revue */
    public void remove(int idRevue)
    {
        try
        {
            PreparedStatement requete = laConnexion.prepareStatement("DELETE FROM Revue WHERE id_revue = ?");
            
            requete.setInt(1,idRevue);

            int res = requete.executeUpdate();
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
            System.out.println("Problème de suppression d'une Revue'\n" + sqle.getMessage());
        }
    }


    /* Méthode d'édition d'une Revue */
    public void edit(int idRevue, String titre, String description, float tarif, String visuel, int periodicite)
    {
        try
        {
            PreparedStatement requete = laConnexion.prepareStatement("UPDATE Revue SET titre = ?, description = ?, tarif_numero = ?, visuel = ?, WHERE id_periodicite = ?");
            
            requete.setInt(1,idRevue);
            requete.setString(2,titre);
            requete.setString(3,description);
            requete.setFloat(4, tarif);
            requete.setString(5, visuel);
            requete.setInt(6, periodicite);

            int res = requete.executeUpdate();
            System.out.println("Modifié avec succès");
        } catch (SQLException sqle)
        {
            System.out.println("Problème d'édition d'une Revue\n" + sqle.getMessage());
        }
    }
}
