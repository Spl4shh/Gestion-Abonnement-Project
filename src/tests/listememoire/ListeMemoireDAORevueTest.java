package listememoire;

import dao.DAOFactory;
import dao.Persistance;
import dao.RevueDAO;
import metier.Periodicite;
import metier.Revue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;


public class ListeMemoireDAORevueTest
{

    private DAOFactory daof;
    private RevueDAO revueDAO;

    @Before
    public void setUp() 
    {
        daof = DAOFactory.getDAOFactory(Persistance.ListeMemoire);
        revueDAO = daof.getRevueDAO();
    }

    @Test
    public void testCreate() throws SQLException
    {
        Revue revueAVerif = new Revue(3,"test_Revue","Revue super random", 5.7, "Visuel Random pour une revue random",new Periodicite(1));

        assertTrue(revueDAO.create(revueAVerif));

        Revue revueRead = revueDAO.getById(revueAVerif.getId());

        assertEquals(revueAVerif, revueRead);

        revueDAO.delete(revueRead);
    }

    @Test
    public void testUpdate() throws SQLException
    {
        Revue revueAVerif = new Revue(3,"test_Revue","Revue super random", 5.7, "Visuel Random pour une revue random",new Periodicite(1));

        revueDAO.create(revueAVerif);


        Revue revueUpdate = new Revue(3,"Update","Update", 0.1, "Update",new Periodicite(2));

        revueDAO.update(revueUpdate);

        Revue revueRead = revueDAO.getById(revueUpdate.getId());

        assertEquals(revueUpdate, revueRead);

        revueDAO.delete(revueRead);
    }

    @Test
    public void testDelete() throws SQLException
    {
        Revue revueAVerif = new Revue(3,"test_Revue","Revue super random", 5.7, "Visuel Random pour une revue random",new Periodicite(1));

        revueDAO.create(revueAVerif);

        revueDAO.delete(revueAVerif);

        assertFalse(revueDAO.findAll().contains(revueAVerif));
    }
}
