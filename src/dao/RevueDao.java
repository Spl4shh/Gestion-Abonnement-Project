package dao;
import metier.Revue;
import java.util.list;

public interface RevueDAO extends DAO<Revue>
{
    public List<Revue> getByTitre(String titre);
}