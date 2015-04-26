/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

import java.awt.Color;
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
    
    Peli peli;
    Kortti kortti1;
    Kortti kortti2;
    
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
        peli = new Peli();
        kortti1 = new Kortti(Color.blue);
        kortti2 = new Kortti(Color.red);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void lisaaKorttiToimii() {
        peli.lisaaKortti(kortti1);
        peli.lisaaKortti(kortti2);
        int vastaus = peli.getKorttiparienLukumaara();
        assertEquals(2, vastaus);
    }

    @Test
    public void poistaKortitToimii() {
        peli.lisaaKortti(kortti1);
        peli.lisaaKortti(kortti2);
        peli.poistaKortit();
        int vastaus = peli.getPelinKorkeus();
        assertEquals(0, vastaus);
    }
    
    @Test
    public void getKorttiTaulukkoAntaaOikeanKokoisen(){
        peli.aloitaPeli(2, 3);
        peli.arvoKortit();
        int vastaus = peli.getPelinKorkeus();
        assertEquals(2, vastaus);
    }
    @Test
    public void getKorttiParienLukumaaraAntaaOikeanLukumaaran() {
        peli.lisaaKortti(kortti1);
        peli.lisaaKortti(kortti2);
        int vastaus = peli.getKorttiparienLukumaara();
        assertEquals(2, vastaus);
    }
    @Test 
    public void pelinKorkeusToimii(){
        peli.aloitaPeli(2,2);
        int vastaus = peli.getPelinKorkeus();
        assertEquals(2, vastaus);
    }
     @Test 
    public void peliLeveysToimii(){
        peli.aloitaPeli(2,2);
        int vastaus = peli.getPelinLeveys();
        assertEquals(2, vastaus);
    }
    @Test
    public void poistaKorttiPelistaToimii(){
        peli.poistaKorttiPelista(kortti1);
        Color vastaus = kortti1.getVari();
        assertEquals(new Color(0,0,0,0), vastaus);
    }
    
    @Test
    public void arvoKortitLuoListan(){
        peli.arvoKortit();
        ArrayList<Integer> vastaus = peli.getKorttiLista();
        assertEquals(peli.getKorttiLista(), vastaus);
    }
    
    @Test
    public void arvoKortitListanKokoOikea(){
        peli.arvoKortit();
        int vastaus = peli.getKorttiLista().size();
        assertEquals(0, vastaus);
    }
    @Test
    public void arvoVaritPeliinLuoListan(){
        peli.arvoVaritPeliin();
        ArrayList<Color> vastaus = peli.getVarilista();
        assertEquals(peli.getVarilista(), vastaus);
    }
    @Test
    public void arvoVaritPeliinListanKokoOikea(){
        peli.arvoVaritPeliin();
        int vastaus = peli.getVarilista().size();
        assertEquals(peli.getPelinKorkeus()*peli.getPelinLeveys(), vastaus);
    }
    @Test
    public void kaannaKorttiToimiiEkallaKortilla(){
        peli.lisaaKortti(kortti1);
        peli.kaannaKortti(kortti1);
        boolean vastaus = kortti1.onkoKaannetty();
        assertEquals(true, vastaus);
    }
    @Test 
    public void onkoKaksiKorttiKaannettyToimii(){
        peli.lisaaKortti(kortti1);
        peli.lisaaKortti(kortti2);
        peli.kaannaKortti(kortti1);
        peli.kaannaKortti(kortti2);
        boolean vastaus = peli.onkoKaksiKorttiaKaannetty();
        assertEquals(true, vastaus);
    }
    @Test
    public void olikoKortitSamatLisaaPelaajalleYrityksenJosKortitSamat(){
        peli.lisaaKortti(kortti1);
        peli.kaannaKortti(kortti1);
        peli.kaannaKortti(kortti1);
        peli.olikoKortitSamat();
        int vastaus = peli.getPelaaja().getYritystenMaara();
        assertEquals(1, vastaus);
    }
    @Test
    public void olikoKortitSamatLisaaPelaajalleYrityksenJosKortitErit(){
        peli.lisaaKortti(kortti1);
        peli.lisaaKortti(kortti2);
        peli.kaannaKortti(kortti1);
        peli.kaannaKortti(kortti2);
        peli.olikoKortitSamat();
        int vastaus = peli.getPelaaja().getYritystenMaara();
        assertEquals(1, vastaus);
    }
    @Test
    public void olikoKortitSamatEiLisaaPariaJosKortitErit(){
        peli.lisaaKortti(kortti1);
        peli.lisaaKortti(kortti2);
        peli.kaannaKortti(kortti1);
        peli.kaannaKortti(kortti2);
        peli.olikoKortitSamat();
        int vastaus = peli.getPelaaja().getLoydetytParit();
        assertEquals(0, vastaus);
    }
    @Test
    public void olikoKortitSamatLisaaLoydetynParinJosKortitSamat(){
        peli.lisaaKortti(kortti1);
        peli.kaannaKortti(kortti1);
        peli.kaannaKortti(kortti1);
        peli.olikoKortitSamat();
        int vastaus = peli.getPelaaja().getLoydetytParit();
        assertEquals(1, vastaus);
    }
    @Test
    public void olikoKortitSamatLaittaaKortitKaannetyiksi(){
        peli.lisaaKortti(kortti1);
        peli.kaannaKortti(kortti1);
        peli.kaannaKortti(kortti1);
        peli.olikoKortitSamat();
        boolean vastaus = peli.onkoEkaKorttiKaannetty();
        assertEquals(false, vastaus);
    }
    @Test
    public void olikoKortitSamatPoistaaLoydetytPelista(){
        peli.lisaaKortti(kortti1);
        peli.kaannaKortti(kortti1);
        peli.kaannaKortti(kortti1);
        Color vastaus = peli.getEkaKortti().getVari();
        assertEquals(peli.getEkaKortti().getVari(), vastaus);
        
    }
    @Test
    public void arvoKortitLuoOikeanMaaranPareja(){
        peli.lisaaKortti(kortti1);
        peli.lisaaKortti(kortti2);
        
    }
    @Test
    public void getEkaKorttiPalauttaaEkanKortin(){
        peli.lisaaKortti(kortti1);
        peli.lisaaKortti(kortti2);
        peli.kaannaKortti(kortti1);
        peli.kaannaKortti(kortti2);
        Kortti vastaus = peli.getEkaKortti();
        assertEquals(kortti1, vastaus);
    }
    @Test
    public void getTokaKorttiPalauttaaTokanKortin(){
        peli.lisaaKortti(kortti1);
        peli.lisaaKortti(kortti2);
        peli.kaannaKortti(kortti1);
        peli.kaannaKortti(kortti2);
        Kortti vastaus = peli.getTokaKortti();
        assertEquals(kortti2, vastaus);
    }
    @Test
    public void onkoTokaKorttiKaannetty(){
        peli.lisaaKortti(kortti1);
        peli.lisaaKortti(kortti2);
        peli.kaannaKortti(kortti1);
        boolean vastaus = kortti2.onkoKaannetty();
        assertEquals(false, vastaus);
    }
}
