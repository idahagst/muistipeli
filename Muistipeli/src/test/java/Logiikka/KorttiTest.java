/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

import java.awt.Color;
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
public class KorttiTest {
    
    public KorttiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Kortti kortti = new Kortti(1, Color.red);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriAsettaaOikeatArvot(){
        Kortti kortti = new Kortti(1, Color.RED);
        int vastaus = kortti.kortinNumero();
        assertEquals(1, vastaus);
    }
    
    @Test
    public void konstruktoriAsettaaOikeatArvot2(){
        Kortti kortti = new Kortti(1, Color.RED);
        Color vastaus = kortti.getVari();
        assertEquals(Color.RED, vastaus);
    }
    @Test
    public void konstruktoriAsettaaEtteiKorttiOleKaannetty(){
        Kortti kortti = new Kortti(1, Color.red);
        boolean vastaus = kortti.onkoKaannetty();
        assertEquals(false, vastaus);
    }
    @Test
    public void KaannaKorttiToimii(){
        Kortti kortti = new Kortti(1, Color.RED);
        kortti.kaannaKortti();
        boolean vastaus = kortti.onkoKaannetty();
        assertEquals(true, vastaus);
    }
    @Test
    public void kortinNumeroAntaaNumeron(){
        Kortti kortti = new Kortti(1, Color.red);
        int vastaus = kortti.kortinNumero();
        assertEquals(1, vastaus);
               
    }
    @Test
    public void setVariToimii(){
        Kortti kortti = new Kortti(1, Color.red);
        kortti.setVari(Color.gray);
        Color vastaus = kortti.getVari();
        assertEquals(Color.gray, vastaus);
    }
    @Test 
    public void palautaKaannettyToimii(){
        Kortti kortti = new Kortti(1,Color.red);
        kortti.kaannaKortti();
        kortti.palautaKaannetty();
        boolean vastaus = kortti.onkoKaannetty();
        assertEquals(false, vastaus);
    }
    
    
}
