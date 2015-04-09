/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

import java.util.ArrayList;
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
public class PeliTest {

    public PeliTest() {
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

//    @Test
//    public void lisaaKorttiToimii() {
//        Peli peli = new Peli();
//        Kortti kortti1 = new Kortti(1);
//        Kortti kortti2 = new Kortti(2);
//        peli.lisaaKortti(kortti1);
//        peli.lisaaKortti(kortti2);
//        int vastaus = peli.getKorttiparienLukumaara();
//        assertEquals(2, vastaus);
//    }
//
//    @Test
//    public void poistaKortitToimii() {
//        Peli peli = new Peli();
//        Kortti kortti1 = new Kortti(1);
//        Kortti kortti2 = new Kortti(2);
//        peli.lisaaKortti(kortti1);
//        peli.lisaaKortti(kortti2);
//        peli.poistaKortit();
//        int vastaus = peli.getKorttiparienLukumaara();
//        assertEquals(0, vastaus);
//    }
//
////    @Test
////    public void getKortitAntaaKortit() {
////        Peli peli = new Peli();
////        ArrayList<Kortti> kortti = new ArrayList<Kortti>();
////        Kortti kortti1 = new Kortti(1);
////        Kortti kortti2 = new Kortti(2);
////        peli.lisaaKortti(kortti1);
////        kortti.add(kortti1);
////        peli.lisaaKortti(kortti2);
////        kortti.add(kortti2);
////        ArrayList<Integer> vastaus = peli.getKortit();
////        assertEquals(kortti, vastaus);
////    }
//    @Test 
//    public void getKorttiParienLukumaaraAntaaOikeanLukumaaran(){
//        Peli peli = new Peli();
//    Kortti kortti1 = new Kortti(1);
//    Kortti kortti2 = new Kortti(2);
//        peli.lisaaKortti(kortti1);
//        peli.lisaaKortti(kortti2);
//        int vastaus = peli.getKorttiparienLukumaara();
//        assertEquals(2, vastaus);
//    }
//    @Test
//    public void aloitaPeliToimii(){
//        Peli peli = new Peli();
//        peli.lisaaKortti("kortti1");
//        peli.lisaaKortti("kortti2");
//        peli.aloitaPeli();
//        assertEquals("kortti1, kortti2", peli.arvoKortit());
//        
//    }
}
