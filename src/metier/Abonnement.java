package metier;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

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
        if (client == null)
        {
            throw new IllegalArgumentException("Client non saisie");
        }
        else
        {
            this.idClient = client.getId();
        }
    }

    public int getIdRevue()
    {
        return idRevue;
    }

    public void setIdRevue(Revue revue)
    {
        if (revue == null)
        {
            throw new IllegalArgumentException("Revue non saisie");
        }
        else
        {
            this.idRevue = revue.getId();
        }    }

    public LocalDate getDateDebut()
    {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut)
    {
        if (dateDebut == null)
        {
            throw new IllegalArgumentException("Date de debut non saisie");
        }
        else
        {
            this.dateDebut = dateDebut;
        }
    }

    public LocalDate getDateFin()
    {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin)
    {
        if (dateFin == null)
        {
            throw new IllegalArgumentException("Date de fin non saisie");
        }
        else if (this.getDateDebut().isAfter(dateFin))
        {
            throw new IllegalArgumentException("Date de fin apres la date de debut");
        }
        else
        {
            this.dateFin = dateFin;
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

    @Override
    public int hashCode()
    {
        return Objects.hash(id, idClient, idRevue, dateDebut, dateFin);
    }
}
