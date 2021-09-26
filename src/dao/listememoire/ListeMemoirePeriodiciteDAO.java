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
		int idx = -1;

		for (Periodicite periodicite : this.donnees) 
		{
			if (periodicite.getId() == objet.getId()) 
			{
				idx = this.donnees.indexOf(periodicite);
			}
		}

		if (idx == -1) 
		{
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} 
		else 
		{
			this.donnees.set(idx, objet);
			return true;
		}
		
	}

	@Override
	public boolean delete(Periodicite objet) 
	{
		Periodicite supprime;
		int idx = -1;

		for (Periodicite periodicite : this.donnees) 
		{
			if (periodicite.getId() == objet.getId()) 
			{
				idx = this.donnees.indexOf(periodicite);
			}
		}

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
		int idx = -1;

		for (Periodicite periodicite : this.donnees) 
		{
			if (periodicite.getId() == id) 
			{
				idx = this.donnees.indexOf(periodicite);
			}
		}

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
	public ArrayList<Periodicite> findAll() 
	{
		return (ArrayList<Periodicite>)instance.donnees;
	}

	@Override
	public ArrayList<Periodicite> getByLibelle(String libelle) 
	{
		ArrayList<Periodicite> listePeriode = new ArrayList<Periodicite>();

		for (Periodicite periodicite : this.donnees) 
		{
			if (periodicite.getLibelle().equals(libelle)) 
			{
				listePeriode.add(this.donnees.get(this.donnees.indexOf(periodicite)));
			}
		}

		if (listePeriode.size() == 0) 
		{
			throw new IllegalArgumentException("Aucun objet ne possède ce libelle");
		} 
		else 
		{
			return listePeriode;
		}
	}
}
