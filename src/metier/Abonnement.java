package metier;

import java.time.LocalDate;

public class Abonnement
{
    int id, idClient, idRevue;
    LocalDate dateDebut, dateFin;

    public Abonnement(LocalDate dateDebut, LocalDate dateFin, int idClient, int idRevue)
    {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idClient = idClient;
        this.idRevue = idRevue;
    }

    public Abonnement(int id, LocalDate dateDebut, LocalDate dateFin, int idClient, int idRevue)
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

    public LocalDate getDateDebut()
    {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut)
    {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin()
    {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin)
    {
        this.dateFin = dateFin;
    }
/******************************************************/
/********************Surcharge*************************/  

    @Override
    public boolean equals(Object object)
    {
        Abonnement abo = (Abonnement)object;

        if (this.id == abo.id && 
            this.idClient == abo.idClient &&
            this.idRevue == abo.idRevue &&
            this.dateDebut.equals(abo.dateDebut) &&
            this.dateFin.equals(abo.dateFin)) 
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
