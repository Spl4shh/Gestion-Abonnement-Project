package dao.listememoire;


import dao.PeriodiciteDAO;
import metier.Periodicite;

import java.util.ArrayList;
import java.util.List;

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
		objet.setId(this.donnees.get(this.donnees.size()-1).getId()+1);

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
	public List<Periodicite> findAll() 
	{
		return instance.donnees;
	}

	@Override
	public List<Periodicite> getByLibelle(String libelle) 
	{
		List<Periodicite> listePeriode = new ArrayList<Periodicite>();

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
