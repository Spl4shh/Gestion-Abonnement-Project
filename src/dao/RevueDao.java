package dao;

public interface RevueDao<Revue>
{
    public List<Revue> getByTitre(String titre);
}