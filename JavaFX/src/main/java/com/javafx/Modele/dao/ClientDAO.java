package com.javafx.Modele.dao;



import com.javafx.Modele.metier.Adresse;
import com.javafx.Modele.metier.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDAO extends DAO<Client>
{
   public List<Client> getByNomPrenom(String nom, String prenom) throws SQLException;
   public List<Client> getByAdresse(Adresse adresse) throws SQLException;
}
