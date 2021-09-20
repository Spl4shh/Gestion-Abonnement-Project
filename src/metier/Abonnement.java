package metier;

import java.sql.Date;

public class Abonnement
{
    int id, idClient, idRevue;
    Date dateDebut, dateFin;

    public Abonnement(Date dateDebut, Date dateFin, int idClient, int idRevue)
    {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idClient = idClient;
        this.idRevue = idRevue;
    }

    public Abonnement(int id, Date dateDebut, Date dateFin, int idClient, int idRevue)
    {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idClient = idClient;
        this.idRevue = idRevue;
    }

    public Abonnement(int id) {
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

    public int getIdClient()
    {
        return idClient;
    }

    public void setIdClient(int idClient)
    {
        this.idClient = idClient;
    }

    public int getIdRevue()
    {
        return idRevue;
    }

    public void setIdRevue(int idRevue)
    {
        this.idRevue = idRevue;
    }

    public Date getDateDebut()
    {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut)
    {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin()
    {
        return dateFin;
    }

    public void setDateFin(Date dateFin)
    {
        this.dateFin = dateFin;
    }
/******************************************************/

}
