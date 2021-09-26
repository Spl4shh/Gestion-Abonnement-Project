package dao.listememoire;

import java.util.ArrayList;
import java.util.List;

import dao.RevueDAO;
import metier.Revue;

public class ListeMemoireRevueDAO implements RevueDAO {

	private static ListeMemoireRevueDAO instance;

	private List<Revue> donnees;


	public static ListeMemoireRevueDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireRevueDAO();
		}

		return instance;
	}

	private ListeMemoireRevueDAO() {

		this.donnees = new ArrayList<Revue>();

		this.donnees.add(new Revue(1,"Random Revue","Revue super random", (float)5.7, "Visuel Random pour une revue random",1));
		this.donnees.add(new Revue(2, "Le Quotidien", "Une revue questionnant l'aléatoire", (float)10.6,"Visuel d'un quotidien aléatoire",2));
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
	public ArrayList<Revue> findAll() 
	{
		return (ArrayList<Revue>) this.donnees;
	}

	@Override
	public ArrayList<Revue> getByTitre(String titre) 
	{
		ArrayList<Revue> listeRevue = new ArrayList<Revue>();

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
