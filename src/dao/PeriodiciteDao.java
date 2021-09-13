package dao;
import metier.Periodicite;
import java.util.List;

public interface PeriodiciteDAO extends DAO<Periodicite>
{
    public List<Periodicite> getByLibelle(String libelle);
}