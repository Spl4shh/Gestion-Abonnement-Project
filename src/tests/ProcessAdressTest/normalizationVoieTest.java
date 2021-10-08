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
        res = ProcessAdress.normalizeVoie("BOULEVARD PEXAN");
        assertEquals(", boulevard pexan", res);

        res = ProcessAdress.normalizeVoie("BOulEVard PexaN");
        assertEquals(", boulevard pexan", res);
    }

    @Test
    public void testChaineMinuscule()
    {
        res = ProcessAdress.normalizeVoie("faubourg honoré");
        assertEquals(", faubourg honoré", res);
    }

    @Test
    public void testCasRemplacement()
    {
        res = ProcessAdress.normalizeVoie("boUL Pexan");
        assertEquals(", boulevard pexan", res);

        res = ProcessAdress.normalizeVoie("boUl. pexan");
        assertEquals(", boulevard pexan", res);

        res = ProcessAdress.normalizeVoie("bd pexan");
        assertEquals(", boulevard pexan", res);

        res = ProcessAdress.normalizeVoie("Faub. pexan");
        assertEquals(", faubourg pexan", res);

        res = ProcessAdress.normalizeVoie("fG pexan");
        assertEquals(", faubourg pexan", res);
    }
}