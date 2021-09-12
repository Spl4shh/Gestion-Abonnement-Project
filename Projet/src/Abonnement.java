import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Abonnement
{
    private Connection laConnexion;

    public Abonnement()
    {
        Connexion maBD = new Connexion();
        laConnexion = maBD.creeConnexion();
    }

    public void add(java.sql.Date dateDebut, java.sql.Date dateFin, int idClient, int idRevue)
    {
        try
        {
            PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO Abonnement(date_debut, date_fin, id_client, id_revue) Values (?, ?, ?, ?)");
            requete.setDate(1, dateDebut);
            requete.setDate(2, dateFin);
            requete.setInt(3, idClient);
            requete.setInt(4, idRevue);

            int res = requete.executeUpdate();

            if (requete != null)
                requete.close();
            if (laConnexion != null)
                laConnexion.close();

            System.out.println("Ajouté avec succes");
        } catch (SQLException sqle)
        {
            System.out.println("Pb add Abonnement" + sqle.getMessage());
        }
    }

    public void remove(int idAbonnement)
    {
        try
        {
            PreparedStatement requete = laConnexion.prepareStatement("DELETE FROM Abonnement WHERE id_abonnement = ?");
            requete.setInt(1, idAbonnement);

            int res = requete.executeUpdate();

            if (requete != null)
                requete.close();
            if (laConnexion != null)
                laConnexion.close();

            System.out.println("Supprimé avec succes");
        } catch (SQLException sqle)
        {
            System.out.println("Pb remove Abonnement" + sqle.getMessage());
        }
    }

    public void edit(int idAbonnement, java.sql.Date dateDebut, java.sql.Date dateFin, int idClient, int idRevue)
    {
        try
        {
            PreparedStatement requete = laConnexion.prepareStatement("UPDATE Abonnement SET date_debut = ?,SET date_fin = ?, SET id_client = ?" +
                    ", SET id_revue = ?, WHERE id_abonnement =  ?");
            requete.setDate(1, dateDebut);
            requete.setDate(2, dateFin);
            requete.setInt(3, idClient);
            requete.setInt(4, idRevue);
            requete.setInt(5, idAbonnement);

            int res = requete.executeUpdate();

            if (requete != null)
                requete.close();
            if (laConnexion != null)
                laConnexion.close();

            System.out.println("Ajouté avec succes");
        } catch (SQLException sqle)
        {
            System.out.println("Pb add Abonnement" + sqle.getMessage());
        }
    }
}
