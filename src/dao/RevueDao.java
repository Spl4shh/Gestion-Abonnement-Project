package dao;

public interface RevueDAO<Revue>
{
    public List<Revue> getByTitre(String titre);
}