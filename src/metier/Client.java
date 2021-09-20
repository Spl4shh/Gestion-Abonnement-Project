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
		  return this.noRue;
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
}
