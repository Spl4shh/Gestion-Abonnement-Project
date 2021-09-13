package metier;

public class Periodicite
{
    int id;
    String libelle;

    public Periodicite(String libelle)
    {
        this.libelle = libelle;
    }

    public Periodicite(int id, String libelle)
    {
           this.id = id;
           this.libelle = libelle;
    }

/******************GETTERS AND SETTERS*******************/

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getLibelle()
    {
        return libelle;
    }

    public void setLibelle(String libelle)
    {
        this.libelle = libelle;
    }
/*******************************************************/

}
