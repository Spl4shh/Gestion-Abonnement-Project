package dao;

import metier.Abonnement;

import java.sql.Date;
import java.util.List;


public interface AbonnementDAO extends DAO<Abonnement>
{
    public List<Abonnement> getByDate(Date dateDebut, Date dateFin);
    public List<Abonnement> getByNomPrenom(String nom, String prenom);
}
