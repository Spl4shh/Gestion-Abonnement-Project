package dao;
import metier.Revue;

import java.sql.SQLException;
import java.util.List;

public interface RevueDAO extends DAO<Revue>
{
    public List<Revue> getByTitre(String titre) throws SQLException;
}
