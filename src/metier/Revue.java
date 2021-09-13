package metier;

public class Revue
{
    /* Définition des attributs */
    int id_revue, idPeriodicite;
    float tarifNumero;
    String titre, description, visuel;
    /* Fin Définition des attributs */


    /* Méthode Revue */
    public Revue
    (
        int idRevue, 
        int idPeriodicite,
        float tarifNumero, 
        String titre,
        String description,
        String visuel
    ) 
    {
        this.idRevue = idRevue;
        this.idPeriodicite = idPeriodicite;
        this.tarifNumero = tarifNumero;
        this.titre = titre;
        this.description = description;
        this.visuel = visuel;
    }
    /* Fin Méthode Revue */


    /* Getters & Setters */
    	public id_revue, getIdPeriodicite() 
    {
		return this.idPeriodicite;
	}

	public void setIdPeriodicite(id_revue, idPeriodicite) 
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

	public titre, getDescription,() 
    {
		return this.description,;
	}

	public void setDescription,(titre, description,) 
    {
		this.description, = description,;
	}
    /* Fin Getters & Setters */
}
