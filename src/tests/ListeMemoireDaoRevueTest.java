package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.DAOFactory;
import dao.Persistance;
import dao.RevueDAO;
import metier.Revue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
        Revue revueAVerif = new Revue(3,"test_Revue","Revue super random", (float)5.7, "Visuel Random pour une revue random",1);

        Assert.assertTrue(revueDAO.create(revueAVerif));

        Revue revueRead = revueDAO.getById(revueAVerif.getId());

        assertEquals(revueAVerif, revueRead);
    }

    @Test
    public void testUpdate() throws SQLException
    {
        Revue revueAVerif = new Revue(3,"test_Revue","Revue super random", (float)5.7, "Visuel Random pour une revue random",1);

        Assert.assertTrue(revueDAO.create(revueAVerif));

        Revue revueRead = revueDAO.getById(revueAVerif.getId());

        assertEquals(revueAVerif, revueRead);

        Revue revueUpdate = new Revue(3,"Update","Update", (float)0.1, "Update",2);

        revueDAO.update(revueUpdate);

        revueRead = revueDAO.getById(revueUpdate.getId());

        assertEquals(revueUpdate, revueRead);
    }

    @Test
    public void testDelete() throws SQLException
    {
        Revue revueAVerif = new Revue(3,"test_Revue","Revue super random", (float)5.7, "Visuel Random pour une revue random",1);

        Assert.assertTrue(revueDAO.create(revueAVerif));

        Revue revueRead = revueDAO.getById(revueAVerif.getId());

        assertEquals(revueAVerif, revueRead);

        revueDAO.delete(revueAVerif);

        assertFalse(revueDAO.findAll().contains(revueAVerif));
    }
}
