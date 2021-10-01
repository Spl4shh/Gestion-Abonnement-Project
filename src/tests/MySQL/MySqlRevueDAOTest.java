package tests.MySQL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.DAOFactory;
import dao.Persistance;
import dao.RevueDAO;
import metier.Revue;

public class MySqlRevueDAOTest 
{
    private DAOFactory daof;
    private RevueDAO revueDAO;

    @Before
    public void setUp()
    {
        daof = DAOFactory.getDAOFactory(Persistance.MYSQL);
        revueDAO = daof.getRevueDAO();
    }


    @Test
    public void testCreate() throws SQLException
    {
        Revue revue = new Revue("Code154329", "Description", (float)10.1, "Visuel", 1);

        revueDAO.create(revue);

        Revue revueRead = revueDAO.getByTitre(revue.getTitre()).get(0);

        revue.setId(revueRead.getId());

        assertTrue(revue.equals(revueRead));

        revueDAO.delete(revueRead);
    }

    @Test
    public void testUpdate() throws SQLException
    {
        Revue revue = new Revue("Code154329", "Description", (float)10.1, "Visuel", 1);

        revueDAO.create(revue);

        Revue revueUpdate = new Revue("Nouveau Code 3742", "nouvelle Description", (float)10.1, "Visuel", 1);

 /*       Revue revueRead = revueDAO.getByNomPrenom(revue.getNom(), revue.getPrenom()).get(0);

        revueUpdate.setId(revueRead.getId());

        revueDAO.update(revueUpdate);

        revueRead = revueDAO.getByNomPrenom(revueUpdate.getNom(), revueUpdate.getPrenom()).get(0);   

        assertTrue(revueUpdate.equals(revueRead));

        revueDAO.delete(revueRead);*/
    }

    @Test
    public void testDelete() throws SQLException
    {
        Revue revue = new Revue("Code154329", "Description", (float)10.1, "Visuel", 1);

        revueDAO.create(revue);

        Revue revueRead = revueDAO.getByTitre("Code154329").get(0);

        revue.setId(revueRead.getId());

        revueDAO.delete(revueRead);

        List<Revue> liste = new ArrayList<>();
        liste = revueDAO.getByTitre("Code154329");

        assertEquals(0, liste.size());
    }
}
