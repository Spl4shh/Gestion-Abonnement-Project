package tests.ProcessAdressTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import metier.ProcessAdress;

public class normalizationVoieTest 
{
    String res;

    @Test
    public void testChaineVide()
    {
        res = ProcessAdress.normalizeVoie("");
        assertEquals(", ", res);
    }

    @Test
    public void testChaineNull()
    {
        res = ProcessAdress.normalizeVoie(null);
        assertEquals(null, res);
    }

    @Test
    public void testChaineNombre()
    {
        res = ProcessAdress.normalizeVoie("4sqdq6843");
        assertEquals(", 4sqdq6843", res);
    }

    @Test
    public void testChaineMajuscule()
    {
        res = ProcessAdress.normalizeVoie("BOULEVARD");
        assertEquals(", boulevard", res);

        res = ProcessAdress.normalizeVoie("BOulEVard");
        assertEquals(", boulevard", res);
    }

    @Test
    public void testChaineMinuscule()
    {
        res = ProcessAdress.normalizeVoie("faubourg");
        assertEquals(", faubourg", res);
    }

    @Test
    public void testCasRemplacement()
    {
        res = ProcessAdress.normalizeVoie("boUL");
        assertEquals(", boulevard", res);

        res = ProcessAdress.normalizeVoie("boUl.");
        assertEquals(", boulevard", res);

        res = ProcessAdress.normalizeVoie("bd");
        assertEquals(", boulevard", res);

        res = ProcessAdress.normalizeVoie("Faub.");
        assertEquals(", faubourg", res);

        res = ProcessAdress.normalizeVoie("fG");
        assertEquals(", faubourg", res);
    }
}