import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Periodicite
{
    private Connection laConnexion;

    public Periodicite()
    {
        Connexion maBD = new Connexion();
        laConnexion = maBD.creeConnexion();
    }

    public void add(String libelle)
    {
        try
        {
            PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO Periodicite(libelle) Values (?)");
            requete.setString(1, libelle);
            int res = requete.executeUpdate();

            if (requete != null)
                requete.close();
            if (laConnexion != null)
                laConnexion.close();

            System.out.println("Ajouté avec succes");
        } catch (SQLException sqle)
        {
            System.out.println("Pb add Periodicite" + sqle.getMessage());
        }
    }

    public void remove(int idPeriodicite)
    {
        try
        {
            PreparedStatement requete = laConnexion.prepareStatement("DELETE FROM Periodicite WHERE id_periodicite = ?");
            requete.setInt(1, idPeriodicite);
            int res = requete.executeUpdate();


            if (requete != null)
                requete.close();
            if (laConnexion != null)
                laConnexion.close();

            System.out.println("Supprimé avec succes");
        } catch (SQLException sqle)
        {
            System.out.println("Pb remove Periodicite" + sqle.getMessage());
        }
    }

    public void edit(int idPeriodicite, String libelle)
    {
        try
        {
            PreparedStatement requete = laConnexion.prepareStatement("UPDATE Periodicite SET libelle = ? WHERE id_periodicite = ?");
            requete.setInt(2, idPeriodicite);
            requete.setString(1, libelle);
            int res = requete.executeUpdate();

            if (requete != null)
                requete.close();
            if (laConnexion != null)
                laConnexion.close();

            System.out.println("Modifié avec succes");
        } catch (SQLException sqle)
        {
            System.out.println("Pb edit Periodicite" + sqle.getMessage());
        }
    }
}
