package dao;

public interface PeriodiciteDAO<Periodicite> 
{
    public List<Periodicite> getByLibelle(String libelle);
}