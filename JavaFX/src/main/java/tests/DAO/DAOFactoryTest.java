package tests.DAO;

import static org.junit.Assert.assertTrue;

import com.javafx.Modele.dao.DAOFactory;
import com.javafx.Modele.dao.ListeMemoireDAOFactory;
import com.javafx.Modele.dao.MySQLDAOFactory;
import com.javafx.Modele.dao.Persistance;
import org.junit.Test;

public class DAOFactoryTest 
{
    DAOFactory daoF;
    @Test
    public void testGetDAOFactory()
    {
        Persistance persistance = Persistance.ListeMemoire;

        daoF = DAOFactory.getDAOFactory(persistance);

        assertTrue(daoF instanceof ListeMemoireDAOFactory);

        persistance = Persistance.MYSQL;

        daoF = DAOFactory.getDAOFactory(persistance);

        assertTrue(daoF instanceof MySQLDAOFactory);
    }
}