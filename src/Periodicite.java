import connexion.Connexion;

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

    public void add(String libelle) throws SQLException
    {
            PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO Periodicite(libelle) Values (?)");
            requete.setString(1, libelle);
            int res = requete.executeUpdate();

            if (requete != null)
                requete.close();

            System.out.println("Ajouté avec succes");
    }

    public void remove(int idPeriodicite) throws SQLException
    {
        PreparedStatement requete = laConnexion.prepareStatement("DELETE FROM Periodicite WHERE id_periodicite = ?");
        requete.setInt(1, idPeriodicite);
        int res = requete.executeUpdate();


        if (requete != null)
            requete.close();

        if (res == 1)
        {
            System.out.println("Elément supprimé avec succès !");
        }
        else
        {
            System.out.println("Aucune ligne trouvée");
        }  
    }

    public void edit(int idPeriodicite, String libelle) throws SQLException
    {
        PreparedStatement requete = laConnexion.prepareStatement("UPDATE Periodicite SET libelle = ? WHERE id_periodicite = ?");
        requete.setInt(2, idPeriodicite);
        requete.setString(1, libelle);
        int res = requete.executeUpdate();

        if (requete != null)
            requete.close();

        System.out.println("Modifié avec succes");
    }

    public void close() throws SQLException
    {
        if (laConnexion != null)
            laConnexion.close();
    }
}
