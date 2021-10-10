package com.javafx.Modele.dao.listememoire;


import com.javafx.Modele.dao.ClientDAO;
import com.javafx.Modele.metier.Adresse;
import com.javafx.Modele.metier.Client;

import java.util.ArrayList;
import java.util.List;

public class ListeMemoireClientDAO implements ClientDAO {

	private static ListeMemoireClientDAO instance;

	private List<Client> donnees;


	public static ListeMemoireClientDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireClientDAO();
		}

		return instance;
	}

	private ListeMemoireClientDAO() {

		this.donnees = new ArrayList<Client>();

		this.donnees.add(new Client(1, "Robert", "Jean Jésus", new Adresse("4", "rue du frêne", "58000", "Ville Perdue", "ImagiNation")));
		this.donnees.add(new Client(2, "Damien", "Kevin", new Adresse("10", "Rue de la foret", "55555", "Ville de la mer", "Nation inconnues")));
	}


	@Override
	public boolean create(Client objet) {

		objet.setId(3);
		// Ne fonctionne que si l'objet métier est bien fait...
		while (this.donnees.contains(objet)) {

			objet.setId(objet.getId() + 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	@Override
	public boolean update(Client objet) 
	{
		int idx = -1;
		for (Client client : this.donnees) {
			if (client.getId() == objet.getId())
			{
				idx = this.donnees.indexOf(client);
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
	public boolean delete(Client objet) 
	{
		Client supprime;
		int idx = -1;

		for (Client client : this.donnees) {
			if (client.getId() == objet.getId())
			{
				idx = this.donnees.indexOf(client);
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
	public Client getById(int id) {

		int idx = -1;

		for (Client client : this.donnees) 
		{
			if (client.getId() == id) 
			{
				idx = this.donnees.indexOf(client);
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
	public List<Client> findAll() 
	{
		return this.donnees;
	}

	@Override
	public List<Client> getByNomPrenom(String nom, String prenom) 
	{
		List<Client> listeRevue = new ArrayList<Client>();

		for (Client client : this.donnees) 
		{
			if (client.getNom().equals(nom) && client.getPrenom().equals(prenom)) 
			{
				listeRevue.add(this.donnees.get(this.donnees.indexOf(client)));
			}
		}

		if (listeRevue.size() == 0) 
		{
			throw new IllegalArgumentException("Aucun objet ne possède ce nom / prenom");
		} 
		else 
		{
			return listeRevue;
		}
	}

	@Override
	public List<Client> getByAdresse(Adresse adresse)
	{
		List<Client> listeRevue = new ArrayList<Client>();

		
		
		for (Client client : this.donnees) 
		{
			if (client.getAdresse().getNoRue().equals(adresse.getNoRue()) && client.getAdresse().getVoie().equals(adresse.getVoie()) && client.getAdresse().getCodePostal().equals(adresse.getCodePostal()))
			{
				listeRevue.add(this.donnees.get(this.donnees.indexOf(client)));
			}
		}

		if (listeRevue.size() == 0) 
		{
			throw new IllegalArgumentException("Aucun objet ne possède cette adresse");
		} 
		else 
		{
			return listeRevue;
		}
	}
}
