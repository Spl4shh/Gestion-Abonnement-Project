package tests.MySQL;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import dao.DAOFactory;
import dao.PeriodiciteDAO;
import dao.Persistance;
import metier.Periodicite;

public class MySqlPeriodiciteDAOTest {

    private DAOFactory daof;
    private PeriodiciteDAO periodiciteDAO;

    @Before
    public void setUp()
    {
        daof = DAOFactory.getDAOFactory(Persistance.MYSQL);
        periodiciteDAO = daof.getPeriodiciteDAO();
    }

    @Test
    public void testCreate() throws SQLException
    {
        Periodicite periodiciteAVerif = new Periodicite(3,"Code15532478956");
        periodiciteDAO.create(periodiciteAVerif);

        Periodicite periodiciteRead = periodiciteDAO.getByLibelle(periodiciteAVerif.getLibelle()).get(0);

        periodiciteAVerif.setId(periodiciteRead.getId());

        assertTrue(periodiciteAVerif.equals(periodiciteRead));

        periodiciteDAO.delete(periodiciteRead);
    }
}