package tests;

import metier.Periodicite;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PeriodiciteTest {
    @Test
    public void test() {
        String obj1 = "Junit";
        String obj2 = "Junit";
        assertEquals(obj1, obj2);

        assertEquals(5, Periodicite.getId());
    }

}
