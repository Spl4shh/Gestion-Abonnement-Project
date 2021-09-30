package metier;

public class Client 
{
    int id;
    String nom, prenom, noRue, voie, codePostal, ville, pays;

    public Client(String nom, String prenom, String noRue, String voie, String codePostal, String ville, String pays) 
    {
        this.nom = nom;
        this.prenom = prenom;
        this.noRue = noRue;
        this.voie = voie;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
    }

    public Client(int id, String nom, String prenom, String noRue, String voie, String codePostal, String ville, String pays) 
    {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.noRue = noRue;
        this.voie = voie;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
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
        Client client = (Client) object;

        if (this.id == client.id &&
            this.nom.equals(client.nom) &&
            this.prenom.equals(client.prenom) &&
            this.noRue.equals(client.noRue) &&
            this.voie.equals(client.voie) &&
            this.codePostal.equals(client.codePostal) &&
            this.ville.equals(client.ville) &&
            this.pays.equals(client.pays)) 
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
        return (this.getId() + " " + this.getNom() + " " + this.getPrenom() + " " + this.getNoRue() + " " + this.getVoie() + " " + this.getCodePostal() + " " + this.getVille() + " " + this.getPays());
    }
}
