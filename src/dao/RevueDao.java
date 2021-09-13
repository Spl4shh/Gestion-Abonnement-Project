package dao;
import metier.Revue;

public interface RevueDAO extends DAO<Revue>
{
    public List<Revue> getByTitre(String titre);
}