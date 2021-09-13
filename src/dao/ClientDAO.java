package dao;

import metier.Client;

import java.util.List;

public interface ClientDAO extends DAO<Client>
{
   public List<Client> getByNomPrenom(String nom, String prenom);
   public List<Client> getByAdresse(String noVoie, String voie, String codePostal);
}
