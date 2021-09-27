package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.DAOFactory;
import dao.Persistance;
import dao.listememoire.ListeMemoireRevueDAO;
import metier.Revue;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import javax.lang.model.element.ElementKind;

public class ListeMemoireDAORevueTest
{

    private DAOFactory daof;

    @Before
    public void setUp() {
        daof = DAOFactory.getDAOFactory(Persistance.ListeMemoire);
    }

    @Test
    public void testCreate() throws SQLException
    {
        Revue revueAVerif = new Revue(3,"test_Revue","Revue super random", (float)5.7, "Visuel Random pour une revue random",1);
        Assert.assertTrue(daof.getRevueDAO().create(revueAVerif));

        Revue revueRead = daof.getRevueDAO().getById(revueAVerif.getId());
;
        assertEquals(revueAVerif, revueRead);
    }
}
