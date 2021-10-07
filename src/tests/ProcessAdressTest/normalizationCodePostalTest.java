package tests.ProcessAdressTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import metier.ProcessAdress;

public class normalizationCodePostalTest {
    String res;

    @Test
    public void testChaineVide()
    {
        res = ProcessAdress.normalizeCode2("");
        assertEquals("", res);
    }

    @Test
    public void testChaineNull()
    {
        res = ProcessAdress.normalizeCode2(null);
        assertEquals(null, res);
    }

    @Test
    public void testChaineNombre5()
    {
        res = ProcessAdress.normalizeCode2("57000");
        assertEquals("57000", res);
    }

    @Test
    public void testChaineNombre4IdPays()
    {
        res = ProcessAdress.normalizeCode2("L-7420");
        assertEquals("07420", res);
    }

    @Test
    public void testChaineNombre5IdPays()
    {
        res = ProcessAdress.normalizeCode2("L-57420");
        assertEquals("57420", res);
    }

    @Test
    public void testChaineLettre()
    {
        res = ProcessAdress.normalizeCode2("ABCDE");
        assertEquals("", res);
    }
}
