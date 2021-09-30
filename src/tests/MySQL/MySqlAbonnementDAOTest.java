package tests.MySQL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.AbonnementDAO;
import dao.DAOFactory;
import dao.Persistance;
import metier.Abonnement;

public class MySqlAbonnementDAOTest 
{
    private DAOFactory daof;
    private AbonnementDAO abonnementDAO;

    @Before
    public void setUp()
    {
        daof = DAOFactory.getDAOFactory(Persistance.MYSQL);
        abonnementDAO = daof.getAbonnementDAO();
    }


    @Test
    public void testCreate() throws SQLException
    {
        Abonnement abonnement = new Abonnement(LocalDate.parse("30/07/2347", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                                                LocalDate.parse("12/03/2347", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 1, 1);

        abonnementDAO.create(abonnement);

        Abonnement abonnementRead = abonnementDAO.getByDate(abonnement.getDateDebut(), abonnement.getDateFin()).get(0);

        abonnement.setId(abonnementRead.getId());

        assertTrue(abonnement.equals(abonnementRead));

        abonnementDAO.delete(abonnementRead);
    }

    @Test
    public void testUpdate() throws SQLException
    {
        Abonnement abonnement = new Abonnement(LocalDate.parse("30/07/2347", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                                                LocalDate.parse("12/03/2347", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 1, 1);

        abonnementDAO.create(abonnement);

        Abonnement abonnementUpdate = new Abonnement(LocalDate.parse("30/07/2347", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                                                    LocalDate.parse("12/03/2347", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 1, 1);

        abonnementDAO.update(abonnementUpdate);

        Abonnement abonnementRead = abonnementDAO.getByDate(abonnement.getDateDebut(), abonnement.getDateFin()).get(0);

        abonnement.setId(abonnementRead.getId());

        assertTrue(abonnement.equals(abonnementRead));

        abonnementDAO.delete(abonnementRead);
    }

    @Test
    public void testDelete() throws SQLException
    {
        Abonnement abonnement = new Abonnement(LocalDate.parse("30/07/2347", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                                                LocalDate.parse("12/03/2347", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 1, 1);

        abonnementDAO.create(abonnement);

        Abonnement abonnementRead = abonnementDAO.getByDate(abonnement.getDateDebut(), abonnement.getDateFin()).get(0);

        abonnement.setId(abonnementRead.getId());

        abonnementDAO.delete(abonnementRead);

        List<Abonnement> liste = new ArrayList<>();

        liste = abonnementDAO.getByDate(abonnement.getDateDebut(), abonnement.getDateFin());

        assertEquals(0, liste.size());
    }
}
