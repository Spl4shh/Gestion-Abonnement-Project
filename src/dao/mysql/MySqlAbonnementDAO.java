package dao.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.AbonnementDAO;
import metier.Abonnement;

public class MySqlAbonnementDAO implements AbonnementDAO
{

    @Override
    public boolean create(Abonnement objet) throws SQLException 
    {
        Connexion maBD = new Connexion();
        Connection laConnexion = maBD.creeConnexion();

        PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO Abonnement(date_debut, date_fin, id_client, id_revue) Values (?, ?, ?, ?)");
        requete.setDate(1, objet.getDateDebut());
        requete.setDate(2, objet.getDateFin());
        requete.setInt(3, objet.getIdClient());
        requete.setInt(4, objet.getIdRevue());

        int res = requete.executeUpdate();

        if (laConnexion != null)
            laConnexion.close();

        return (res == 1);
    }

    @Override
    public boolean update(Abonnement objet) throws SQLException 
    {
        Connexion maBD = new Connexion();
        Connection laConnexion = maBD.creeConnexion();

        PreparedStatement requete = laConnexion.prepareStatement("UPDATE Abonnement SET date_debut = ?, date_fin = ?, id_client = ?, id_revue = ? WHERE id_abonnement =  ?");
        requete.setDate(1, objet.getDateDebut());
        requete.setDate(2, objet.getDateFin());
        requete.setInt(3, objet.getIdClient());
        requete.setInt(4, objet.getIdRevue());
        requete.setInt(5, objet.getId());

        int res = requete.executeUpdate();

        if (laConnexion != null)
            laConnexion.close();

        return (res == 1);
    }

    @Override
    public boolean delete(Abonnement objet) throws SQLException 
    {
        Connexion maBD = new Connexion();
        Connection laConnexion = maBD.creeConnexion();

        PreparedStatement requete = laConnexion.prepareStatement("DELETE FROM Abonnement WHERE id_abonnement = ?");
        requete.setInt(1, objet.getId());

        int res = requete.executeUpdate();

        if (laConnexion != null)
            laConnexion.close();

        return (res == 1);
    }

    @Override
    public Abonnement getById(int i) throws SQLException 
    {
        Connexion maBD = new Connexion();
        Connection laConnexion = maBD.creeConnexion();

        PreparedStatement requete = laConnexion.prepareStatement("SELECT * FROM Abonnement WHERE id_abonnement = ?");
        requete.setInt(1, i);

        ResultSet res = requete.executeQuery();

        if (laConnexion != null)
            laConnexion.close();

        return new Abonnement(res.getInt(1), res.getDate(2), res.getDate(3), res.getInt(4), res.getInt(5));
    }
    
    @Override
    public List<Abonnement> getByDate(Date dateDebut, Date dateFin) throws SQLException 
    {
        List<Abonnement> listeAbonnement = new ArrayList<Abonnement>();

        Connexion maBD = new Connexion();
        Connection laConnexion = maBD.creeConnexion();

        PreparedStatement requete = laConnexion.prepareStatement("SELECT * FROM Abonnement WHERE date_debut = ? AND date_fin = ?");
        requete.setDate(1, dateDebut);
        requete.setDate(2, dateFin);

        ResultSet res = requete.executeQuery();

        if (laConnexion != null)
            laConnexion.close();

        while (res.next()) 
        {
            listeAbonnement.add(new Abonnement(res.getInt(1), res.getDate(2), res.getDate(3), res.getInt(4), res.getInt(5)));
        }

        return listeAbonnement;
    }

    @Override
    public List<Abonnement> getByNomPrenom(String nom, String prenom) throws SQLException 
    {
        List<Abonnement> listeAbonnement = new ArrayList<Abonnement>();

        Connexion maBD = new Connexion();
        Connection laConnexion = maBD.creeConnexion();

        PreparedStatement requete = laConnexion.prepareStatement("SELECT * FROM Abonnement a, Client c WHERE a.id_client = c.id_client AND nom = ? AND prenom = ?");
        requete.setString(1, nom);
        requete.setString(2, prenom);

        ResultSet res = requete.executeQuery();

        if (laConnexion != null)
            laConnexion.close();

        while (res.next()) 
        {
            listeAbonnement.add(new Abonnement(res.getInt(1), res.getDate(2), res.getDate(3), res.getInt(4), res.getInt(5)));
        }

        return listeAbonnement;
    }
    
    @Override
    public ArrayList<Abonnement> findAll() throws SQLException 
    {
        ArrayList<Abonnement> listeAbonnement = new ArrayList<Abonnement>();

        Connexion maBD = new Connexion();
        Connection laConnexion = maBD.creeConnexion();

        PreparedStatement requete = laConnexion.prepareStatement("SELECT * FROM Abonnement");
        
        ResultSet res = requete.executeQuery();

        if (laConnexion != null)
            laConnexion.close();

        while (res.next()) 
        {
            listeAbonnement.add(new Abonnement(res.getInt(1), res.getDate(2), res.getDate(3), res.getInt(4), res.getInt(5)));
        }

        return listeAbonnement;
    }
}
