package tests.listememoire;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.DAOFactory;
import dao.Persistance;
import metier.Periodicite;


public class ListeMemoireDAOPeriodiciteTest {
    private DAOFactory daof;

    @Before
    public void setUp() {
        daof = DAOFactory.getDAOFactory(Persistance.ListeMemoire);
    }

    @Test
    public void testCreate() throws SQLException
    {
        Periodicite PeriodiciteAVerif = new Periodicite(3,"Mensuel");
        Assert.assertTrue(daof.getPeriodiciteDAO().create(PeriodiciteAVerif));

        Periodicite PeriodiciteRead = daof.getPeriodiciteDAO().getById(PeriodiciteAVerif.getId());
        assertEquals(PeriodiciteAVerif, PeriodiciteRead);
    }
}
