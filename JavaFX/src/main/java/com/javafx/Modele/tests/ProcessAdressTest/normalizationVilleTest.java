package com.javafx.Modele.tests.ProcessAdressTest;

import static org.junit.Assert.assertEquals;

import com.javafx.Modele.metier.ProcessAdress;
import org.junit.Test;


public class normalizationVilleTest 
{
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
        res = ProcessAdress.normalizeVille(null);
        assertEquals(null, res);
    }

    @Test
    public void testChaineNombre()
    {
        res = ProcessAdress.normalizeVille("4sqdq6843");
        assertEquals("4sqdq6843", res);
    }

    @Test
    public void testChaineMajuscule()
    {
        res = ProcessAdress.normalizeVille("BOULEVARD");
        assertEquals("Boulevard", res);

        res = ProcessAdress.normalizeVille("BOulEVard");
        assertEquals("Boulevard", res);

        res = ProcessAdress.normalizeVille("BOulEVard peXan");
        assertEquals("Boulevard Pexan", res);
    }

    @Test
    public void testChaineMinuscule()
    {
        res = ProcessAdress.normalizeVille("montigny");
        assertEquals("Montigny", res);
    }

    @Test
    public void testCasRemplacement()
    {
        // les
        res = ProcessAdress.normalizeVille("Marange lès metz");
        assertEquals("Marange-lès-Metz", res);

        res = ProcessAdress.normalizeVille("marange LèS metz");
        assertEquals("Marange-lès-Metz", res);

        res = ProcessAdress.normalizeVille("maRange lEs meTz");
        assertEquals("Marange-lès-Metz", res);
        
        // aux
        res = ProcessAdress.normalizeVille("marange aux metz");
        assertEquals("Marange-aux-Metz", res);

        // sous
        res = ProcessAdress.normalizeVille("marange sous metz");
        assertEquals("Marange-sous-Metz", res);

        res = ProcessAdress.normalizeVille("st marange sous metz");
        assertEquals("Saint-Marange-sous-Metz", res);

        res = ProcessAdress.normalizeVille("ste marange sous metz");
        assertEquals("Sainte-Marange-sous-Metz", res);
    }

    @Test
    public void testUniquementPreposition()
    {
        res = ProcessAdress.normalizeVille("lès");
        assertEquals("lès", res);
    }
}