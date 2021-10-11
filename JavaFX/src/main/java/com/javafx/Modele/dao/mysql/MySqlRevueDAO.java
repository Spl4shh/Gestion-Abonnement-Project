package com.javafx.Modele.dao.mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.javafx.Modele.connexion.Connexion;
import com.javafx.Modele.dao.RevueDAO;
import com.javafx.Modele.metier.Periodicite;
import com.javafx.Modele.metier.Revue;

public class MySqlRevueDAO implements RevueDAO
{
    private static MySqlRevueDAO instance;
    
    Connexion maBD;
    Connection laConnexion;

    public static RevueDAO getInstance()
    {
        if (instance == null) 
        {
            instance = new MySqlRevueDAO();
        }
        return instance;
    }

    private MySqlRevueDAO() 
    {
        maBD = new Connexion();
        laConnexion = maBD.creeConnexion();
    }

    @Override
    public boolean create(Revue objet) throws SQLException
    {
        maBD = new Connexion();
        laConnexion = maBD.creeConnexion();

        PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO Revue(titre, description, tarif_numero, visuel, id_periodicite) Values (?, ?, ?, ?, ?)");
        requete.setString(1, objet.getTitre());
        requete.setString(2, objet.getDescription());
        requete.setDouble(3, objet.getTarifNumero());
        requete.setString(4, objet.getVisuel());
        requete.setInt(5, objet.getIdPeriodicite());

        int res = requete.executeUpdate();

        if (laConnexion != null)
            laConnexion.close();

        return (res == 1);
    }

    @Override
    public boolean update(Revue objet) throws SQLException 
    {
        maBD = new Connexion();
        laConnexion = maBD.creeConnexion();

        PreparedStatement requete = laConnexion.prepareStatement("UPDATE Revue SET titre = ?, description = ?, tarif_numero = ?, visuel = ?, id_periodicite = ? WHERE id_revue = ?");
        requete.setString(1, objet.getTitre());
        requete.setString(2, objet.getDescription());
        requete.setDouble(3, objet.getTarifNumero());
        requete.setString(4, objet.getVisuel());
        requete.setInt(5, objet.getIdPeriodicite());
        requete.setInt(6, objet.getId());

        int res = requete.executeUpdate();

        if (laConnexion != null)
            laConnexion.close();

        return (res == 1);
    }

    @Override
    public boolean delete(Revue objet) throws SQLException 
    {
        maBD = new Connexion();
        laConnexion = maBD.creeConnexion();

        PreparedStatement requete = laConnexion.prepareStatement("DELETE FROM Revue WHERE id_revue = ?");
        requete.setInt(1, objet.getId());

        int res = requete.executeUpdate();

        if (laConnexion != null)
            laConnexion.close();

        return (res == 1);
    }

    @Override
    public Revue getById(int i) throws SQLException 
    {
        maBD = new Connexion();
        laConnexion = maBD.creeConnexion();

        PreparedStatement requete = laConnexion.prepareStatement("SELECT * FROM Revue WHERE id_revue = ?");
        requete.setInt(1, i);

        ResultSet res = requete.executeQuery();
        res.next();

        Revue revue = new Revue(res.getInt(1), res.getString(2), res.getString(3), res.getFloat(4), res.getString(5), new Periodicite(res.getInt(6)) );

        if (laConnexion != null)
            laConnexion.close();

        return revue;
    }

    @Override
    public List<Revue> getByTitre(String titre) throws SQLException
    {
        List<Revue> listeRevue = new ArrayList<>();

        maBD = new Connexion();
        laConnexion = maBD.creeConnexion();

        PreparedStatement requete = laConnexion.prepareStatement("SELECT * FROM Revue WHERE titre = ?");
        requete.setString(1, titre);

        ResultSet res = requete.executeQuery();
        
        while (res.next()) 
        {
            listeRevue.add(new Revue(res.getInt(1), res.getString(2), res.getString(3), res.getFloat(4), res.getString(5), new Periodicite(res.getInt(6))));
        }

        if (laConnexion != null)
            laConnexion.close();
        
        return listeRevue;
    }

    @Override
    public List<Revue> findAll() throws SQLException 
    {
        List<Revue> listeRevue = new ArrayList<>();

        maBD = new Connexion();
        laConnexion = maBD.creeConnexion();

        PreparedStatement requete = laConnexion.prepareStatement("SELECT * FROM Revue");
        
        ResultSet res = requete.executeQuery();
        
        while (res.next()) 
        {
            listeRevue.add(new Revue(res.getInt(1), res.getString(2), res.getString(3), res.getFloat(4), res.getString(5), new Periodicite(res.getInt(6))));
        }

        if (laConnexion != null)
            laConnexion.close();

        return listeRevue;
    }
    
}