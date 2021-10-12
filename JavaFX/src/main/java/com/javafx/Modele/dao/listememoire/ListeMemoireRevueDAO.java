package com.javafx.Modele.dao.listememoire;

import com.javafx.Modele.dao.RevueDAO;
import com.javafx.Modele.metier.Periodicite;
import com.javafx.Modele.metier.Revue;

import java.util.ArrayList;
import java.util.List;

public class ListeMemoireRevueDAO implements RevueDAO {

	private static ListeMemoireRevueDAO instance;

	private List<Revue> donnees;


	public static ListeMemoireRevueDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireRevueDAO();
		}

		return instance;
	}

	private ListeMemoireRevueDAO()
	{

		this.donnees = new ArrayList<Revue>();

		this.donnees.add(new Revue(1,"Random Revue","Revue super random", 5.7, "Visuel Random pour une revue random",new Periodicite(1)));
		this.donnees.add(new Revue(2, "Le Quotidien", "Une revue questionnant l'aléatoire", 10.6,"Visuel d'un quotidien aléatoire",new Periodicite(2)));
	}


	@Override
	public boolean create(Revue objet) {

		objet.setId(3);
		// Ne fonctionne que si l'objet métier est bien fait...
		while (this.donnees.contains(objet)) 
		{
			objet.setId(objet.getId() + 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	@Override
	public boolean update(Revue objet) 
	{
		int idx = -1;

		for (Revue revue : this.donnees) 
		{
			if (revue.getId() == objet.getId()) 
			{
				idx = this.donnees.indexOf(revue);
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
	public boolean delete(Revue objet) 
	{
		Revue supprime;
		int idx = -1;

		for (Revue revue : this.donnees) 
		{
			if (revue.getId() == objet.getId()) 
			{
				idx = this.donnees.indexOf(revue);
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
	public Revue getById(int id) 
	{
		int idx = -1;

		for (Revue revue : this.donnees) 
		{
			if (revue.getId() == id) 
			{
				idx = this.donnees.indexOf(revue);
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
	public List<Revue> findAll() 
	{
		return this.donnees;
	}

	@Override
	public List<Revue> getByTitre(String titre) 
	{
		List<Revue> listeRevue = new ArrayList<>();

		for (Revue revue : this.donnees) 
		{
			if (revue.getTitre().equals(titre)) 
			{
				listeRevue.add(this.donnees.get(this.donnees.indexOf(revue)));
			}
		}

		if (listeRevue.size() == 0) 
		{
			throw new IllegalArgumentException("Aucun objet ne possède ce titre");
		} 
		else 
		{
			return listeRevue;
		}
	}
}
