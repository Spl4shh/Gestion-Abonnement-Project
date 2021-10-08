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

    }    
}
