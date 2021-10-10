package com.javafx.Modele.tests.listememoire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.sql.SQLException;

import com.javafx.Modele.dao.DAOFactory;
import com.javafx.Modele.dao.PeriodiciteDAO;
import com.javafx.Modele.dao.Persistance;
import com.javafx.Modele.metier.Periodicite;
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
