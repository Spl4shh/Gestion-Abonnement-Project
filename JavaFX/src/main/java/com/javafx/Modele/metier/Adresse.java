package com.javafx.Modele.metier;

public class Adresse {


    // Setters & getters

    private String noRue, voie, codePostal, ville, pays;

    public Adresse(String noRue, String voie, String codePostal, String ville, String pays)
    {
        this.noRue = noRue;
        this.voie = voie;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
    }

    public String getNoRue() 
    {
        return this.noRue;
    }

    public void setNoRue(String noRue) 
    {
        this.noRue = noRue;
    }

    public String getVoie() 
    {
        return this.voie;
    }

    public void setVoie(String voie) 
    {
        this.voie = voie;
    }

    public String getCodePostal() 
    {
        return this.codePostal;
    }

    public void setCodePostal(String codePostal) 
    {
        this.codePostal = codePostal;
    }

    public String getVille() 
    {
        return this.ville;
    }

    public void setVille(String ville) 
    {
        this.ville = ville;
    }

    public String getPays() 
    {
        return this.pays;
    }

    public void setPays(String pays) 
    {
        this.pays = pays;
    }

    @Override
    public boolean equals(Object object)
    {
        Adresse adresse = (Adresse) object;

        if (this.getCodePostal().equals(adresse.getCodePostal()) && 
            this.getNoRue().equals(adresse.getNoRue()) && 
            this.getPays().equals(adresse.getPays()) && 
            this.getVille().equals(adresse.getVille())) 
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String toString()
    {
        return (this.getNoRue() + " " + this.getVoie() + " " + this.getVille() + " " + this.getCodePostal() + " " + this.getPays()); 
    }
}
