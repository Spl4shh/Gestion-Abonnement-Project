package dao;

public interface RevueDAO extends DAO<Revue>
{
    public List<Revue> getByTitre(String titre);
}