package metier;

import java.util.Objects;

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

    public Periodicite(int id)
    {
        this.id = id;
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
        if (libelle == null || libelle.equals(""))
        {
            throw new IllegalArgumentException("Libelle non saisie");
        }
        else
        {
            this.libelle = libelle;
        }
    }
/******************************************************/
/********************Surcharge*************************/

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (object == null || getClass() != object.getClass())
        {
            return false;
        }

        Periodicite periode = (Periodicite) object;

        if (periode != null &&
            this.id == periode.id &&
            this.libelle.equals(periode.libelle))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public String toString()
    {
        return (this.getId() + " " + this.getLibelle());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, libelle);
    }
}
