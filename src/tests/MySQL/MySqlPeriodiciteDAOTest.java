package tests.MySQL;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import dao.DAOFactory;
import dao.PeriodiciteDAO;
import dao.Persistance;
import metier.Periodicite;

public class MySqlPeriodiciteDAOTest {

    private DAOFactory daof;
    private PeriodiciteDAO periodiciteDAO;

    @Before
    public void setUp()
    {
        daof = DAOFactory.getDAOFactory(Persistance.MYSQL);
        periodiciteDAO = daof.getPeriodiciteDAO();
    }

    @Test
    public void testCreate() throws SQLException
    {
        // On crée une nouvelle periodicite a verifier 
        Periodicite periodiciteAVerif = new Periodicite("Code15532478956");

        // On l'ajoute avec la dao
        periodiciteDAO.create(periodiciteAVerif);

        Periodicite periodiciteRead = periodiciteDAO.getByLibelle(periodiciteAVerif.getLibelle()).get(0);

        // periodiciteAVerif prends pour valeur l'id donné dans la base
        periodiciteAVerif.setId(periodiciteRead.getId());

        // On vérifie si periodiciteAVerif == periodiciteRead
        assertTrue(periodiciteAVerif.equals(periodiciteRead));

        // Suppression
        periodiciteDAO.delete(periodiciteRead);
    }

    @Test
    public void testUpdate() throws SQLException
    {
        // Création d'1 periodicite
        Periodicite periodiciteAVerif = new Periodicite("Code155324");
        
        // Crée la périodicité dans la bdd
        periodiciteDAO.create(periodiciteAVerif);

        // Création Periodicite à update
        Periodicite periodiciteUpdate = new Periodicite("NouveauCode123");

        // vérification (libelle est il identique)
        Periodicite periodiciteRead = periodiciteDAO.getByLibelle(periodiciteAVerif.getLibelle()).get(0);

        // Définit l'id de periodiciteUpdate <- id periodiciteRead
        periodiciteUpdate.setId(periodiciteRead.getId());

        // Periodicite dao prend pour valeur celles de periodicite update
        periodiciteDAO.update(periodiciteUpdate);

        // On recupère une periodicite grace a son id
        periodiciteRead = periodiciteDAO.getById(periodiciteUpdate.getId());

        // Vérification si periodiciteUpdate == periodiciteRead
        assertTrue(periodiciteUpdate.equals(periodiciteRead));

        // Suppression à la fin
        periodiciteDAO.delete(periodiciteRead);

    }
}