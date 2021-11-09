package listememoire;

import dao.ClientDAO;
import dao.DAOFactory;
import dao.Persistance;
import metier.Adresse;
import metier.Client;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.sql.SQLException;


public class ListeMemoireDAOClientTest
{

    private DAOFactory daof;
    private ClientDAO clientDAO;

    @Before
    public void setUp() 
    {
        daof = DAOFactory.getDAOFactory(Persistance.ListeMemoire);
        clientDAO = daof.getClientDAO();
    }

    @Test
    public void testCreate() throws SQLException
    {
        Client clientAVerif = new Client(3, "Name", "Surname", new Adresse("8", "Ma rue", "Mon code poste", "Marange", "France"));

        clientDAO.create(clientAVerif);

        Client clientRead = clientDAO.getById(clientAVerif.getId());

        assertEquals(clientAVerif, clientRead);

        clientDAO.delete(clientRead);
    }

    @Test
    public void testUpdate() throws SQLException
    {
        Client clientAVerif = new Client(3, "Name", "Surname",  new Adresse("8", "Ma rue", "Mon code poste", "Marange", "France"));

        clientDAO.create(clientAVerif);


        Client clientUpdate = new Client(3, "New Name", "New Surname",  new Adresse("8897", "Ma rue nouvelle", "Mon nouveau code poste", "Marange", "France"));

        clientDAO.update(clientUpdate);

        Client clientRead = clientDAO.getById(clientUpdate.getId());

        assertEquals(clientUpdate, clientRead);

        clientDAO.delete(clientRead);

    }

    @Test
    public void testDelete() throws SQLException
    {
        Client clientAVerif = new Client(3, "Name", "Surname",  new Adresse("8", "Ma rue", "Mon code poste", "Marange", "France"));

        clientDAO.create(clientAVerif);

        clientDAO.delete(clientAVerif);

        assertFalse(clientDAO.findAll().contains(clientAVerif));
    }
}
