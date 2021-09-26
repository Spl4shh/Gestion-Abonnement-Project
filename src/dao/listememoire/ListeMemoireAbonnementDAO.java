package dao.listememoire;

import dao.AbonnementDAO;
import metier.Abonnement;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ListeMemoireAbonnementDAO implements AbonnementDAO {

    private static ListeMemoireAbonnementDAO instance;

    private List<Abonnement> donnees;


    public static ListeMemoireAbonnementDAO getInstance()
    {
        if (instance == null) {
            instance = new ListeMemoireAbonnementDAO();
        }

        return instance;
    }

    private ListeMemoireAbonnementDAO()
    {
        this.donnees = new ArrayList<Abonnement>();

        this.donnees.add(new Abonnement(1, LocalDate.parse("23/04/2001", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            LocalDate.parse("24/04/2001", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 1, 1));
        this.donnees.add(new Abonnement(2, LocalDate.parse("23/04/2001", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            LocalDate.parse("24/04/2001", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 2, 2));
    }


    @Override
    public boolean create(Abonnement objet)
    {
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
    public boolean update(Abonnement objet)
    {
        // Ne fonctionne que si l'objet métier est bien fait...
        int idx = this.donnees.indexOf(objet);
        if (idx == -1) 
        {
            throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
        } else 
        {

            this.donnees.set(idx, objet);
        }

        return true;
    }

    @Override
    public boolean delete(Abonnement objet)
    {
        Abonnement supprime;

        // Ne fonctionne que si l'objet métier est bien fait...
        int idx = this.donnees.indexOf(objet);
        if (idx == -1)
        {
            throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
        } else
        {
            supprime = this.donnees.remove(idx);
        }

        return objet.equals(supprime);
    }

    @Override
    public Abonnement getById(int id)
    {
        // Ne fonctionne que si l'objet métier est bien fait...
        int idx = this.donnees.indexOf(new  Abonnement(id, LocalDate.parse("11/11/1111", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            LocalDate.parse("11/11/1111", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 0, 0));
        if (idx == -1)
        {
            throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
        } else
        {
            return this.donnees.get(idx);
        }
    }

    @Override
    public ArrayList<Abonnement> findAll()
    {
        return (ArrayList<Abonnement>) this.donnees;
    }

    @Override
    public ArrayList<Abonnement> getByDate(LocalDate dateDebut, LocalDate dateFin)
    {
        ArrayList<Abonnement> listAbonnement = null;

        // Ne fonctionne que si l'objet métier est bien fait...
        int idx = this.donnees.indexOf(new  Abonnement(0, dateDebut, dateFin, 0, 0));
        if (listAbonnement.isEmpty())
        {
            throw new IllegalArgumentException("Aucun objet ne possède ce nom");
        } else
        {
            return listAbonnement;
        }
    }

    @Override
    public ArrayList<Abonnement> getByNomPrenom(String nom, String prenom) throws SQLException 
    {
        // 
        // To do
        // Implementation de la fabrique necessaire au préalable
        // 
        // 
        return null;
    }
}
