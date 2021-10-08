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
<<<<<<< Updated upstream
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
=======
    public void testChaineMinus()
    {
        res = ProcessAdress.normalizePays("france");
        assertEquals("France", res);
    }

    @Test
    public void testChaineMajuscule()
    {
        res = ProcessAdress.normalizePays("FRANCE");
        assertEquals("France", res);
    } 

    @Test
    public void testRemplacementMinus()
    {
        res = ProcessAdress.normalizePays("letzebuerg");
        assertEquals("Luxembourg", res);

        res = ProcessAdress.normalizePays("belgium");
        assertEquals("Belgique", res);

        res = ProcessAdress.normalizePays("switzerland");
        assertEquals("Suisse", res);

        res = ProcessAdress.normalizePays("schweiz");
        assertEquals("Suisse", res);
    } 

    @Test
    public void testRemplacementMajuscule()
    {
        res = ProcessAdress.normalizePays("LETZEBUERG");
        assertEquals("Luxembourg", res);

        res = ProcessAdress.normalizePays("BELGIUM");
        assertEquals("Belgique", res);

        res = ProcessAdress.normalizePays("SWITZERLAND");
        assertEquals("Suisse", res);

        res = ProcessAdress.normalizePays("SCHWEIZ");
        assertEquals("Suisse", res);
    }  
>>>>>>> Stashed changes
}
