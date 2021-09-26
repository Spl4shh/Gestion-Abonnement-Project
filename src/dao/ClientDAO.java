package dao;

import metier.Client;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ClientDAO extends DAO<Client>
{
   public ArrayList<Client> getByNomPrenom(String nom, String prenom) throws SQLException;
   public ArrayList<Client> getByAdresse(String noRue, String voie, String codePostal) throws SQLException;
}
