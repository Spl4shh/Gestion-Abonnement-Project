package tests.ProcessAdressTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import metier.ProcessAdress;

public class normalizationCodePostalTest {
    String res;

    @Test
    public void testChaineVide()
    {
        res = ProcessAdress.normalizeVille("");
        assertEquals("", res);
    }

    @Test
    public void testChaineNull()
    {
        res = ProcessAdress.normalizeCode2(null);
        assertEquals(null, res);
    }

    @Test
    public void testChaineNombre()
    {
        res = ProcessAdress.normalizeCode2("57");
        assertEquals("57", res);
    }

    @Test
    public void testChaineMinuscule()
    {
        res = ProcessAdress.normalizeCode2("L-57420");
        assertEquals("L-57420", res);
    }
}
