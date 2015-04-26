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
    
    Kortti kortti;
    
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
        kortti = new Kortti(Color.red);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriAsettaaOikeatArvot2(){
        Color vastaus = kortti.getVari();
        assertEquals(Color.RED, vastaus);
    }
    @Test
    public void konstruktoriAsettaaEtteiKorttiOleKaannetty(){
        boolean vastaus = kortti.onkoKaannetty();
        assertEquals(false, vastaus);
    }
    @Test
    public void KaannaKorttiToimii(){
        kortti.kaannaKortti();
        boolean vastaus = kortti.onkoKaannetty();
        assertEquals(true, vastaus);
    }
    @Test
    public void setVariToimii(){
        kortti.setVari(Color.gray);
        Color vastaus = kortti.getVari();
        assertEquals(Color.gray, vastaus);
    }
    @Test 
    public void palautaKaannettyToimii(){
        kortti.kaannaKortti();
        kortti.palautaKaannetty();
        boolean vastaus = kortti.onkoKaannetty();
        assertEquals(false, vastaus);
    }
    
    
}
