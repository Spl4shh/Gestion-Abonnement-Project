package com.javafx.Modele.tests.ProcessAdressTest;

import static org.junit.Assert.assertEquals;

import com.javafx.Modele.metier.ProcessAdress;
import org.junit.Test;


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
        // test boulevard
        res = ProcessAdress.normalizeVoie("boUL Pexan");
        assertEquals(", boulevard pexan", res);

        res = ProcessAdress.normalizeVoie("boUl. pexan");
        assertEquals(", boulevard pexan", res);

        res = ProcessAdress.normalizeVoie("bd pexan");
        assertEquals(", boulevard pexan", res);

        // test faubourg
        res = ProcessAdress.normalizeVoie("Faub. pexan");
        assertEquals(", faubourg pexan", res);

        res = ProcessAdress.normalizeVoie("fG pexan");
        assertEquals(", faubourg pexan", res);

        // test avenue
        res = ProcessAdress.normalizeVoie("aV pExAn");
        assertEquals(", avenue pexan", res);

        res = ProcessAdress.normalizeVoie("av. pexan");
        assertEquals(", avenue pexan", res);

        // test place
        res = ProcessAdress.normalizeVoie("pL pExAn");
        assertEquals(", place pexan", res);

        res = ProcessAdress.normalizeVoie("pl. pexan");
        assertEquals(", place pexan", res);
    }
}