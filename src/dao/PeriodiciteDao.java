package dao;

public interface PeriodiciteDao<Periodicite> 
{
    public List<Periodicite> getByLibelle(String libelle);
}