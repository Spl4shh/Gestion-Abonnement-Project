package tests.MySQL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import dao.AbonnementDAO;
import dao.DAOFactory;
import dao.Persistance;
import metier.Abonnement;
import metier.Client;
import metier.Revue;
import org.junit.Before;
import org.junit.Test;


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
                                                LocalDate.parse("12/03/2347", DateTimeFormatter.ofPattern("dd/MM/yyyy")), new Client(1), new Revue(1));

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
                                                LocalDate.parse("12/03/2347", DateTimeFormatter.ofPattern("dd/MM/yyyy")), new Client(1), new Revue(1));

        abonnementDAO.create(abonnement);

        Abonnement abonnementUpdate = new Abonnement(LocalDate.parse("30/07/2347", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                                                    LocalDate.parse("12/03/2347", DateTimeFormatter.ofPattern("dd/MM/yyyy")), new Client(1), new Revue(1));


        Abonnement abonnementRead = abonnementDAO.getByDate(abonnement.getDateDebut(), abonnement.getDateFin()).get(0);

        abonnementUpdate.setId(abonnementRead.getId());

        abonnementDAO.update(abonnementUpdate);

        abonnementRead = abonnementDAO.getById(abonnementUpdate.getId());   

        assertTrue(abonnementUpdate.equals(abonnementRead));

        abonnementDAO.delete(abonnementRead);
    }

    @Test
    public void testDelete() throws SQLException
    {
        Abonnement abonnement = new Abonnement(LocalDate.parse("30/07/2347", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                                                LocalDate.parse("12/03/2347", DateTimeFormatter.ofPattern("dd/MM/yyyy")), new Client(1), new Revue(1));

        abonnementDAO.create(abonnement);

        Abonnement abonnementRead = abonnementDAO.getByDate(abonnement.getDateDebut(), abonnement.getDateFin()).get(0);

        abonnement.setId(abonnementRead.getId());

        abonnementDAO.delete(abonnementRead);

        List<Abonnement> liste;

        liste = abonnementDAO.getByDate(abonnement.getDateDebut(), abonnement.getDateFin());

        assertEquals(0, liste.size());
    }
}
