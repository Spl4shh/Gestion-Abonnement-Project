package tests.listememoire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.DAOFactory;
import dao.PeriodiciteDAO;
import dao.Persistance;
import metier.Periodicite;


public class ListeMemoireDAOPeriodiciteTest {
    private DAOFactory daof;
    private PeriodiciteDAO periodiciteDAO;

    @Before
    public void setUp() {
        daof = DAOFactory.getDAOFactory(Persistance.ListeMemoire);
        periodiciteDAO = daof.getPeriodiciteDAO();
    }

    @Test
    public void testCreate() throws SQLException
    {
        Periodicite PeriodiciteAVerif = new Periodicite(3,"Mensuel");
        Assert.assertTrue(daof.getPeriodiciteDAO().create(PeriodiciteAVerif));

        Periodicite PeriodiciteRead = daof.getPeriodiciteDAO().getById(PeriodiciteAVerif.getId());
        assertEquals(PeriodiciteAVerif, PeriodiciteRead);
    }

    @Test
    public void testUpdate() throws SQLException
    {
        Periodicite periodiciteAVerif = new Periodicite(3,"Update");

        periodiciteDAO.create(periodiciteAVerif);

        Periodicite periodiciteRead = periodiciteDAO.getById(periodiciteAVerif.getId());

        Periodicite periodiciteUpdate = new Periodicite(3,"Update");

        periodiciteDAO.update(periodiciteUpdate);

        periodiciteRead = periodiciteDAO.getById(periodiciteUpdate.getId());

        assertEquals(periodiciteUpdate, periodiciteRead);

    }

    @Test
    public void testDelete() throws SQLException
    {
        Periodicite periodiciteAVerif = new Periodicite(3,"Update");
        
        periodiciteDAO.create(periodiciteAVerif);

        periodiciteDAO.delete(periodiciteAVerif);

        assertFalse(periodiciteDAO.findAll().contains(periodiciteAVerif));
    }
}
