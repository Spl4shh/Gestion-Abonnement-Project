package dao.listememoire;

import java.util.ArrayList;
import java.util.List;

import dao.PeriodiciteDAO;
import metier.Periodicite;

public class ListeMemoirePeriodiciteDAO implements PeriodiciteDAO 
{

	private static ListeMemoirePeriodiciteDAO instance;

	private List<Periodicite> donnees;

	private ListeMemoirePeriodiciteDAO() 
	{
		this.donnees = new ArrayList<Periodicite>();

		this.donnees.add(new Periodicite(1, "Mensuel"));
		this.donnees.add(new Periodicite(2, "Quotidien"));
	}

	public static ListeMemoirePeriodiciteDAO getInstance() 
	{
		if (instance == null) 
		{
			instance = new ListeMemoirePeriodiciteDAO();
		}	
		
		return instance;
	}

	@Override
	public boolean create(Periodicite objet) 
	{
		objet.setId(3);      // 3 car on créé 2 instance objet Periodicité avant
		// Ne fonctionne que si l'objet métier est bien fait...
		while (this.donnees.contains(objet)) 
		{
			objet.setId(objet.getId() + 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	@Override
	public boolean update(Periodicite objet) 
	{
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) 
		{
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} 
		else 
		{
			this.donnees.set(idx, objet);
		}
		return true;
	}

	@Override
	public boolean delete(Periodicite objet) 
	{
		Periodicite supprime;
		
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) 
		{
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} 
		else 
		{
			supprime = this.donnees.remove(idx);
		}
		
		return objet.equals(supprime);
	}

	@Override
	public Periodicite getById(int id) 
	{
		// Ne fonctionne que si l'objet métier est bien fait...
		//Probleme de logique, si equlas est surchargé avec tout les attributs, la methode en dessous renveras forcement l'exception

		int idx = this.donnees.indexOf(new Periodicite(id, "test"));
		if (idx == -1) 
		{
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} 
		else 
		{
			return this.donnees.get(idx);
		}
	}

	@Override
	public List<Periodicite> findAll() 
	{
		return (List<Periodicite>)instance.donnees;
	}

	@Override
	public List<Periodicite> getByLibelle(String libelle) 
	{
		return instance.getByLibelle(libelle);
	}
}
