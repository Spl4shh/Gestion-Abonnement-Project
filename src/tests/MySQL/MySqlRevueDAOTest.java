package tests.MySQL;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

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

        Revue revueRead = revueDAO.getByTitre("Code154329").get(0);

        assertTrue(revue.equals(revueRead));
    }
}
