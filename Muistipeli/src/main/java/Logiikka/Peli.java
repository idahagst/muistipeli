/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Luokka sisältää kaikki pelin pelaamiseen liittyvät toiminnot
 * @author Ida
 */
public class Peli {

    private Kortti[][] kortit;
    private ArrayList<Kortti> korttilista = new ArrayList<Kortti>(); //kaikki mahdolliset kortit
    private Pelaaja pelaaja;
    private boolean ensimmainenKorttiKaannetty;
    private boolean toinenKorttiKaannetty;
    private Kortti ekaKortti;
    private Kortti tokaKortti;
    private ArrayList<Integer> kortitPelissa; //pelissä olevat kortit, jokaista listassa kaksi
    private int korkeus;
    private int leveys;
    private ArrayList<Color> varit;
    /**
     * konstruktori luo pelin, asettaa sille pelaajan, luo listan väreistä,
     * joita kortit voivat olla ja lisää listalle värejä
     */
    public Peli() {
        this.pelaaja = new Pelaaja("");
        this.varit = new ArrayList<Color>();
        varit.add(Color.RED);
        varit.add(Color.BLUE);
        varit.add(Color.GREEN);
        varit.add(Color.YELLOW);
        varit.add(Color.ORANGE);
        varit.add(Color.WHITE);
        varit.add(Color.PINK);
        varit.add(Color.CYAN);
        varit.add(Color.MAGENTA);
        
    }
    /**
     * metodi lisää listalle kortin, joka voidaan myöhemmin ottaa mukaan peliin
     * @param kortti 
     */
    public void lisaaKortti(Kortti kortti) {
        korttilista.add(kortti);

    }
    /**
     * metodi poistaa kaikki kortit listalta, jolloin peliin ei voida valita yhtään korttia
     */
    public void poistaKortit() {
        korttilista.removeAll(korttilista);
    }
    /**
     * metodi palauttaa korttiparien lukumäärän
     * @return listalla olevien korttien määrä
     */
    public int getKorttiparienLukumaara() {
        return korttilista.size();
    }
    /**
     * metodi aloittaa pelin, asettaa sille korkeuden ja leveyden, luo taulukon joka
     * koostuu korteista ja asettaa ekan ja tokan kortin kääntämättömiksi
     * metodi myös arpoo korit
     * @param y pelin korkeus eli kuinka monta korttia on päällekkäin
     * @param x pelin leveys eli kuinka monta korttia on vierekkäin
     */
    public void aloitaPeli(int y, int x) {
        this.korkeus = y;
        this.leveys = x;
        this.kortit = new Kortti[y][x];
        ensimmainenKorttiKaannetty = false;
        toinenKorttiKaannetty = false;
        arvoKortit();
    }
    /**
     * metodi arpoo kortit taulukkoon, josta niitä voidaan myöhemmin pelata
     */
    public void arvoKortit() {
        int parienMaara = leveys * korkeus / 2;
        kortitPelissa = new ArrayList<Integer>();
        int i = 0;
        while (i < parienMaara) {
            kortitPelissa.add(i);
            kortitPelissa.add(i);
            i++;
        }
        Collections.shuffle(kortitPelissa);
        int a = 0;
        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {
                Kortti kortti = new Kortti(kortitPelissa.get(0), varit.get(a/2));
                kortit[y][x] = kortti;
                kortitPelissa.remove(0);
                a++;
            }
        }
    }

    public int getPelinKorkeus() {
        return this.korkeus;
    }

    public int getPelinLeveys() {
        return this.leveys;
    }
    public ArrayList<Integer> getKorttiLista() {
        return kortitPelissa;
    }
    public Kortti[][] getKorttiTaulukko() {
        return kortit;
    }
    public Pelaaja getPelaaja(){
        return this.pelaaja;
    }
    public Kortti getKortti(int y, int x){
        return kortit[y][x];
    }
    /**
     * metodi kääntää halutun kortin eli muuttaa sen käännetyksi
     * @param kortti kortti, joka halutaan kääntää
     */
    public void kaannaKortti(Kortti kortti) {

        if (ensimmainenKorttiKaannetty == false && toinenKorttiKaannetty == false) {
            ensimmainenKorttiKaannetty = true;
            ekaKortti = kortti;
            ekaKortti.kaannaKortti();

        } else if (ensimmainenKorttiKaannetty == true && toinenKorttiKaannetty == false) {
            toinenKorttiKaannetty = true;
            tokaKortti = kortti;
            tokaKortti.kaannaKortti();
        }
    }
    
    public Kortti getEkaKortti(){
        return this.ekaKortti;
    }
    public Kortti getTokaKortti(){
        return this.tokaKortti;
    }
    /**
     * metodi kertoo onko ensimmäinen kortti käännetty
     * @return true tai false riippuen onko kortti käännetty
     */
    public boolean onkoEkaKorttiKaannetty(){
        return this.ensimmainenKorttiKaannetty;
    }
    /**
     * metodi kertoo onko toinen kortti käännetty
     * @return true tai false riippuen onko kortti käännetty
     */
    public boolean onkoTokaKorttiKaannetty(){
        return this.toinenKorttiKaannetty;
    }
    /**
     * metodi testaa onko kaksi korttia samat
     * jos kaksi korttia on samat, metodi poistaa ne pelistä, lisaa pelaajalle
     * parin ja yrityksen ja asettaa ensimmäisen ja toisen kortin kääntämättömäksi
     * jos kaksi korttia ei ole samat, metodi lisää pelaajalle yrityksen ja kääntää kortit 
     * takaisin väärinpäin
     * @param kortti1 ensimmäinen vertailtava kortti
     * @param kortti2 toinen vertailtava kortti
     */
    public void olikoKortitSamat(){
        if (ekaKortti.getVari().equals(tokaKortti.getVari())) {
                pelaaja.lisaaPari();
                pelaaja.lisaaYritys();
                poistaKorttiPelista(ekaKortti);
                poistaKorttiPelista(tokaKortti);
                ensimmainenKorttiKaannetty = false;
                toinenKorttiKaannetty = false;
                ekaKortti = null;
                tokaKortti = null;
//                ekaKortti.palautaKaannetty();
//                tokaKortti.palautaKaannetty();
                onkoKaikkiKortitKaannetty();
        }
        else{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {

            }
            pelaaja.lisaaYritys();
            ensimmainenKorttiKaannetty = false;
            toinenKorttiKaannetty = false;
            ekaKortti.palautaKaannetty();
            tokaKortti.palautaKaannetty();
            ekaKortti = null;
            tokaKortti = null;
        }
    }
    /**
     * metodi kertoo onko kaikki pöydällä olevat kortit jo käännetty eli onko kaikki 
     * korttiparit löydetty
     * @return true tai false riippuen onko pöydällä löytämättömiä pareja
     */
    public boolean onkoKaikkiKortitKaannetty(){
        for(int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {
                if(kortit[y][x].onkoKaannetty()== false){
                    return false;
                } 
            }
        }
        return true;
    }
    /**
     * metodi poistaa halutun kortin pelistä 
     * @param kortti kortti, joka halutana poistaa 
     */
    public void poistaKorttiPelista(Kortti kortti) {
        kortti.setVari(new Color(0,0,0,0));
    }
    /**
     * metodi kääntää kaikki kortit pelissä kääntämättömiksi
     */
    public void kaannaKaikkiKortit(){
        for(int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {
                kortit[y][x].palautaKaannetty();
            }
        }
    }
    /**
     * metodi palauttaa onko kaksi korttia pöydällä käännettynä
     * @return true tai false
     */
    public boolean onkoKaksiKorttiaKaannetty(){
        if(ekaKortti == null || tokaKortti == null){
            return false;
        }
        return ekaKortti.onkoKaannetty() && tokaKortti.onkoKaannetty();
    }
}
