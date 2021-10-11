package com.javafx.Modele.metier;

public class Revue
{
  /* Définition des attributs */
  int id, idPeriodicite;
  double tarifNumero;
  String titre, description, visuel;
  /* Fin Définition des attributs */


  /* Méthode Revue */
  public Revue(int id, String titre, String description, double tarifNumero, String visuel, int idPeriodicite)
  {
      this.setId(id);
      this.setTitre(titre);
      this.setDescription(description);
      this.setTarifNumero(tarifNumero);
      this.setVisuel(visuel);
      this.setIdPeriodicite(idPeriodicite);
  }

  public Revue(Integer id)
  {
      this.setId(id);
  }

  public Revue(String titre, String description, double tarifNumero, String visuel, int idPeriodicite)
  {
      this.setTitre(titre);
      this.setDescription(description);
      this.setTarifNumero(tarifNumero);
      this.setVisuel(visuel);
      this.setIdPeriodicite(idPeriodicite);
  }
  /* Fin Méthode Revue */


  /* Getters & Setters */
  public int getId() 
  {
    return this.id;
  }

  public void setId(int id)
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

  public double getTarifNumero()
{
      return this.tarifNumero;
  }

  public void setTarifNumero(double tarifNumero)
  {
      this.tarifNumero = tarifNumero;
  }

  public String getDescription()
  {
      return this.description;
  }

  public void setDescription(String description)
  {
      if (description != null && !description.equals(""))
      {
        this.description = description;
      }
  }
  
  public String getTitre() 
  {
    return this.titre;
  }
  
  public void setTitre(String titre) 
  {
      if (titre != null && !titre.equals(""))
      {
        this.titre = titre;
      }
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
        this.description.equals(revue.description) &&
        this.idPeriodicite == revue.idPeriodicite &&
        this.tarifNumero == revue.tarifNumero &&
        this.titre.equals(revue.titre) &&
        this.visuel.equals(revue.visuel))    
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
    return (this.getId() + " " + this.getTitre() + " " + this.getDescription() + " " + this.getTarifNumero() + " " + this.getVisuel() + " " + this.getIdPeriodicite());
  }
}
