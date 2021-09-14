package dao;

import metier.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDAO extends DAO<Client>
{
   public List<Client> getByNomPrenom(String nom, String prenom) throws SQLException;
   public List<Client> getByAdresse(String noVoie, String voie, String codePostal) throws SQLException;
}
