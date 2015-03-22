/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ida
 */
public class PelaajaTest {
    
    public PelaajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void NimiOnNumero(){
        Pelaaja pelaaja = new Pelaaja("123");
        String vastaus = pelaaja.getNimi();
        assertEquals("123", vastaus);
    }
    @Test
    public void loydetytParitAlussaNolla(){
        Pelaaja pelaaja = new Pelaaja("123");
        int vastaus = pelaaja.getLoydetytParit();
        assertEquals(0, vastaus);
    }
    @Test
    public void lisaaPariLisaaParin(){
        Pelaaja pelaaja = new Pelaaja("123");
        pelaaja.lisaaPari();
        pelaaja.lisaaPari();
        int vastaus = pelaaja.getLoydetytParit();
        assertEquals(2, vastaus);
    }
    @Test
    public void nollaajaNollaaParit(){
        Pelaaja pelaaja = new Pelaaja("123");
        pelaaja.lisaaPari();
        pelaaja.lisaaPari();
        pelaaja.nollaaLoydetyt();
        int vastaus = pelaaja.getLoydetytParit();
        assertEquals(0, vastaus);
    }
}
