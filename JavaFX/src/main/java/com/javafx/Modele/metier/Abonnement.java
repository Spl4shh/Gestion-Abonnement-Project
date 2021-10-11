package com.javafx.Modele.metier;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Abonnement
{
    int id, idClient, idRevue;
    LocalDate dateDebut, dateFin;

    public Abonnement(LocalDate dateDebut, LocalDate dateFin, Client client, Revue revue)
    {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idClient = client.getId();
        this.idRevue = revue.getId();
    }

    public Abonnement(int id, LocalDate dateDebut, LocalDate dateFin, Client client, Revue revue)
    {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idClient = client.getId();
        this.idRevue = revue.getId();
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

    public void setIdClient(Client client)
    {
        this.idClient = client.getId();
    }

    public int getIdRevue()
    {
        return idRevue;
    }

    public void setIdRevue(Revue revue)
    {
        this.idRevue = revue.getId();
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

    @Override
    public String toString()
    {
        DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return ("\n" + this.getId() + " \nID Client : " + this.getIdClient() + " \nID Revue : " + this.getIdRevue() + " \nDate de debut : " + this.getDateDebut().format(formatage) + " \nDate de fin : " + this.getDateFin().format(formatage));
    }
}
