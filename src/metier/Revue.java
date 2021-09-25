package metier;

public class Revue
{
  /* Définition des attributs */
  int id, idPeriodicite;
  float tarifNumero;
  String titre, description, visuel;
  /* Fin Définition des attributs */


  /* Méthode Revue */
  public Revue
  (
      int id, 
      String titre,
      String description,
      float tarifNumero, 
      String visuel,
      int idPeriodicite

  ) 
  {
      this.id = id;
      this.titre = titre;
      this.description = description;
      this.tarifNumero = tarifNumero;
      this.visuel = visuel;
      this.idPeriodicite = idPeriodicite;
  }

  public Revue(Integer id)
  {
    this.id = id;
  }

  public Revue
  (
      String titre,
      String description,
      float tarifNumero, 
      String visuel,
      int idPeriodicite

  ) 
  {
      this.titre = titre;
      this.description = description;
      this.tarifNumero = tarifNumero;
      this.visuel = visuel;
      this.idPeriodicite = idPeriodicite;
  }
  /* Fin Méthode Revue */


  /* Getters & Setters */
  public int getId() 
  {
    return this.id;
  }

  public void setId(int  id) 
  {
		this.id = id;
	}
  
  public int getIdPeriodicite() 
  {
    return this.idPeriodicite;
  }

  public void setIdPeriodicite(int  idPeriodicite) 
  {
		this.idPeriodicite = idPeriodicite;
	}

	public float getTarifNumero() 
  {
		return this.tarifNumero;
	}

	public void setTarifNumero(float tarifNumero) 
  {
		this.tarifNumero = tarifNumero;
	}

	public String getDescription() 
  {
		return this.description;
	}

	public void setDescription(String description) 
  {
		this.description = description;
	}
  
  public String getTitre() 
  {
    return this.titre;
  }
  
  public void setTitre(String titre) 
  {
    this.titre = titre;
  }
  
  public String getVisuel() 
  {
    return this.visuel;
  }
  
  public void setVisuel(String visuel) 
  {
    this.visuel = visuel;
  }
  /* Fin Getters & Setters */


  @Override
    public boolean equals(Object object)
    {
      Revue revue = (Revue) object;

      if (this.id == revue.id &&
          this.description == revue.description &&
          this.idPeriodicite == revue.idPeriodicite &&
          this.tarifNumero == revue.tarifNumero &&
          this.titre == revue.titre &&
          this.visuel == revue.visuel)    
      {
        return true;
      } 
      else 
      {
        return false;  
      }
    }
}
