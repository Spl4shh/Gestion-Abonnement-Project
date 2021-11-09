package listememoire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.sql.SQLException;

import dao.DAOFactory;
import dao.PeriodiciteDAO;
import dao.Persistance;
import metier.Periodicite;
import org.junit.Before;
import org.junit.Test;


public class ListeMemoireDAOPeriodiciteTest
{
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
        Periodicite periodiciteAVerif = new Periodicite(3,"Mensuel");

        periodiciteDAO.create(periodiciteAVerif);

        Periodicite periodiciteRead = periodiciteDAO.getById(periodiciteAVerif.getId());

        assertEquals(periodiciteAVerif, periodiciteRead);

        periodiciteDAO.delete(periodiciteAVerif);
    }

    @Test
    public void testUpdate() throws SQLException
    {
        Periodicite periodiciteAVerif = new Periodicite(3,"Code58698");

        periodiciteDAO.create(periodiciteAVerif);

        Periodicite periodiciteRead = periodiciteDAO.getByLibelle("Code58698").get(0);

        Periodicite periodiciteUpdate = new Periodicite(periodiciteRead.getId(),"Update");

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
