package tests.MySQL;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import dao.DAOFactory;
import dao.Persistance;
import dao.RevueDAO;
import metier.Periodicite;
import metier.Revue;
import org.junit.Before;
import org.junit.Test;

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
        Revue revue = new Revue("Code154329", "Description", (float)10.1, "Visuel", new Periodicite(1));

        revueDAO.create(revue);

        Revue revueRead = revueDAO.getByTitre(revue.getTitre()).get(0);

        revue.setId(revueRead.getId());

        assertEquals(revue, revueRead);

        revueDAO.delete(revueRead);
    }

    @Test
    public void testUpdate() throws SQLException
    {
        Revue revue = new Revue("Code154329", "Description", 10.1, "Visuel", new Periodicite(1));

        revueDAO.create(revue);

        Revue revueUpdate = new Revue("Code154329", "Description", 10.1, "Visuel", new Periodicite(1));

        Revue revueRead = revueDAO.getByTitre(revue.getTitre()).get(0);

        revueUpdate.setId(revueRead.getId());

        revueDAO.update(revueUpdate);

        revueRead = revueDAO.getById(revueUpdate.getId());

        assertEquals(revueUpdate, revueRead);

        revueDAO.delete(revueRead);
    }

    @Test
    public void testDelete() throws SQLException
    {
        Revue revue = new Revue("Code154329", "Description", (float)10.1, "Visuel", new Periodicite(1));

        revueDAO.create(revue);

        Revue revueRead = revueDAO.getByTitre("Code154329").get(0);

        revue.setId(revueRead.getId());

        revueDAO.delete(revueRead);

        List<Revue> liste;
        liste = revueDAO.getByTitre("Code154329");

        assertEquals(0, liste.size());
    }
}
