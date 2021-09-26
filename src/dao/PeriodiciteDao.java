package dao;
import metier.Periodicite;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PeriodiciteDAO extends DAO<Periodicite>
{
    public ArrayList<Periodicite> getByLibelle(String libelle) throws SQLException;
}