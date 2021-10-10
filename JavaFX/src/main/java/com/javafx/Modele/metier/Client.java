package com.javafx.Modele.metier;

public class Client 
{
    int id;
    String nom, prenom;
    Adresse adresse;

    public Client(String nom, String prenom, Adresse adresse) 
    {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public Client(int id, String nom, String prenom, Adresse adresse) 
    {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public Client(int id) 
    {
        this.id = id;
    }

    public int getId() 
    {
        return this.id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getNom() 
    {
        return this.nom;
    }

    public void setNom(String nom) 
    {
        this.nom = nom;
    }

    public String getPrenom() 
    {
        return this.prenom;
    }

    public void setPrenom(String nom) 
    {
        this.nom = nom;
    }
    
    public Adresse getAdresse() 
    {
        return this.adresse;
    }

    public void setAdresse(Adresse adresse) 
    {
        this.adresse = adresse;
    }


    @Override
    public boolean equals(Object object)
    {
        Client client = (Client) object;

        if (this.id == client.id &&
            this.nom.equals(client.nom) &&
            this.prenom.equals(client.prenom) &&
            this.adresse.equals(client.adresse)) 
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
        return (this.getId() + " " + this.getNom() + " " + this.getPrenom() + " " + this.adresse.toString());
    }
}
