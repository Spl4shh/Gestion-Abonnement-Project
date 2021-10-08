package tests.ProcessAdressTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import metier.ProcessAdress;

public class normalizationPays 
{
    String res;

    @Test
    public void testChaineNull()
    {
        res = ProcessAdress.normalizePays(null);
        assertEquals(null, res);
    }

    @Test
    public void testChaineVide()
    {
        res = ProcessAdress.normalizePays("");
        assertEquals("", res);
    }    

    @Test
    public void testLux() 
    {
        res = ProcessAdress.normalizePays("letzebuerg");
        assertEquals("Luxembourg", res);
    }

    @Test
    public void testBelgique() 
    {
        res = ProcessAdress.normalizePays("belgium");
        assertEquals("Belgique", res);
    }

    @Test
    public void testSuisse() 
    {
        res = ProcessAdress.normalizePays("switzerland");
        assertEquals("Suisse", res);
        res = ProcessAdress.normalizePays("schweiz");
        assertEquals("Suisse", res);
    }
}
