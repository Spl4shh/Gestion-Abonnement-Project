package com.javafx.Modele.metier;

public class Revue
{
  /* Définition des attributs */
  private int id, idPeriodicite;
  private double tarifNumero;
  private String titre, description, visuel;
  /* Fin Définition des attributs */


  /* Méthode Revue */
  public Revue(int id, String titre, String description, double tarifNumero, String visuel, Periodicite periode)
  {
      this.setId(id);
      this.setTitre(titre);
      this.setDescription(description);
      this.setTarifNumero(tarifNumero);
      this.setVisuel(visuel);
      this.setIdPeriodicite(periode);
  }

  public Revue(Integer id)
  {
      this.setId(id);
  }

  public Revue(String titre, String description, double tarifNumero, String visuel, Periodicite periode)
  {
      this.setTitre(titre);
      this.setDescription(description);
      this.setTarifNumero(tarifNumero);
      this.setVisuel(visuel);
      this.setIdPeriodicite(periode);
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

  public void setIdPeriodicite(Periodicite periodicite)
  {
      if (periodicite == null)
      {
          throw new IllegalArgumentException("Periodicité nulle");
      }
      else
      {
          this.idPeriodicite = periodicite.getId();
      }
  }

  public double getTarifNumero()
{
      return this.tarifNumero;
  }

  public void setTarifNumero(double tarifNumero)
  {
      if (tarifNumero < 0)
      {
          throw new IllegalArgumentException("Tarif négatif");
      }
      else
      {
          this.tarifNumero = tarifNumero;
      }
  }

  public String getDescription()
  {
      return this.description;
  }

  public void setDescription(String description)
  {
      if (description == null || description.equals(""))
      {
        throw new IllegalArgumentException("Description non saisie");
      }
      else
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
      if (titre == null || titre.equals(""))
      {
          throw new IllegalArgumentException("Titre non saisie");
      }
      else
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
    return ("ID : " + this.getId() + ", titre : " + this.getTitre() + ", description : " + this.getDescription() + ", tarif unitaire : " + this.getTarifNumero() + ", visuel : " + this.getVisuel() + ", ID périodicité : " + this.getIdPeriodicite());
  }
}
