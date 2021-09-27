package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import dao.listememoire.ListeMemoirePeriodiciteDAO;


public class PeriodiciteTest {
    @Test
    public void testLibelle() {
        assertEquals("Mensuel", ListeMemoirePeriodiciteDAO.getInstance().getById(1).getLibelle());        
        //assertEquals("Mensuel", ListeMemoirePeriodiciteDAO.getInstance().getById(2).getLibelle());
    }

    @Test
    public void testId() {
        assertEquals(1, ListeMemoirePeriodiciteDAO.getInstance().getById(1).getId());        
        //assertEquals(1, ListeMemoirePeriodiciteDAO.getInstance().getById(2).getId());  
    }
}
