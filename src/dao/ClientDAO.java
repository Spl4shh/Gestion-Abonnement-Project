package dao;


//import metier.Adresse;
import metier.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDAO extends DAO<Client>
{
   public List<Client> getByNomPrenom(String nom, String prenom) throws SQLException;
}
