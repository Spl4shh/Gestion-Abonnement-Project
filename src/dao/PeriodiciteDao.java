package dao;

public interface PeriodiciteDAO extends DAO<Periodicite>
{
    public List<Periodicite> getByLibelle(String libelle);
}