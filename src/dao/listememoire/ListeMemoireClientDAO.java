package dao.listememoire;

import java.util.ArrayList;
import java.util.List;

import dao.ClientDAO;
import metier.Client;
import java.sql.Date;

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

		this.donnees.add(new Client(1, "Robert", "Jean Jésus", "4", "rue du frêne", "58000", "Ville Perdue", "ImagiNation"));
		this.donnees.add(new Client(2, "Damien", "Kévin", "10", "Rue de la foret", "96452", "Ville de la mer", "Nation inconnues"));
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
	public boolean update(Client objet) {
		
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
			
			this.donnees.set(idx, objet);
		}
		
		return true;
	}

	@Override
	public boolean delete(Client objet) {

		Client supprime;
		
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.donnees.remove(idx);
		}
		
		return objet.equals(supprime);
	}

	@Override
	public Client getById(int id) {
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(new Client(id, "test", "test", "test", "test", "test", "test", "test"));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	@Override
	public ArrayList<Client> findAll() {
		return (ArrayList<Client>) this.donnees;
	}

	@Override
	public List<Client> getByNomPrenom(String nom, String prenom) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getByAdresse(String noVoie, String voie, String codePostal) 
	{
		// TODO Auto-generated method stub
		return null;
	}
}
