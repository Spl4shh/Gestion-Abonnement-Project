package com.javafx.Modele.tests.ProcessAdressTest;

import static org.junit.Assert.assertEquals;

import com.javafx.Modele.metier.ProcessAdress;
import org.junit.Test;

public class normalizationPaysTest 
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
}
