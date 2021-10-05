package tests.ProcessAdressTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import metier.ProcessAdress;

public class normalizationVoieTest 
{
    
    @Test
    public void testChaineVide()
    {
        String res;
        
        res = ProcessAdress.normalizeVoie("");

        assertEquals(", ", res);
    }

    @Test
    public void testChaineNull()
    {
        String res;
        
        res = ProcessAdress.normalizeVoie(null);

        assertEquals(", ", res);
    }

    @Test
    public void testChaineMajuscule()
    {
        String res;
        
        res = ProcessAdress.normalizeVoie("BOULEVARD");

        assertEquals(", boulevard", res);

        res = ProcessAdress.normalizeVoie("BOulEVard");

        assertEquals(", boulevard", res);
    }

    @Test
    public void testChaineMinuscule()
    {
        String res;
        
        res = ProcessAdress.normalizeVoie("faubourg");

        assertEquals(", faubourg", res);


    }

    @Test
    public void testChaineCasRemplacement()
    {
        
    }

}
