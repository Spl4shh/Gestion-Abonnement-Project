package com.javafx.Modele.tests.listememoire;

import com.javafx.Modele.dao.DAOFactory;
import com.javafx.Modele.dao.Persistance;
import com.javafx.Modele.dao.RevueDAO;
import com.javafx.Modele.metier.Periodicite;
import com.javafx.Modele.metier.Revue;
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
    }

    @Test
    public void testUpdate() throws SQLException
    {
        Revue revueAVerif = new Revue(3,"test_Revue","Revue super random", 5.7, "Visuel Random pour une revue random",new Periodicite(1));

        revueDAO.create(revueAVerif);

        Revue revueRead = revueDAO.getById(revueAVerif.getId());

        Revue revueUpdate = new Revue(3,"Update","Update", 0.1, "Update",new Periodicite(2));

        revueDAO.update(revueUpdate);

        revueRead = revueDAO.getById(revueUpdate.getId());

        assertEquals(revueUpdate, revueRead);
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
