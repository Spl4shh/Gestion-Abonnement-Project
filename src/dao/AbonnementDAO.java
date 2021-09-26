package dao;

import metier.Abonnement;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


public interface AbonnementDAO extends DAO<Abonnement>
{
    public ArrayList<Abonnement> getByDate(LocalDate dateDebut, LocalDate dateFin) throws SQLException;
    public ArrayList<Abonnement> getByNomPrenom(String nom, String prenom) throws SQLException;
}
