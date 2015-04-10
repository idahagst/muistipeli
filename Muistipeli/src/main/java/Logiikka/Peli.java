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
                a++;
                Kortti kortti = new Kortti(kortitPelissa.get(0), varit.get(a/2));
                kortit[y][x] = kortti;
                kortitPelissa.remove(0);
                
            }
        }
    }

    public int getPelinKorkeus() {
        return this.korkeus;
    }

    public int getPelinLeveys() {
        return this.leveys;
    }

    public Kortti[][] getKortit() {
        return kortit;
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
        } else {
            olikoKortitSamat(ekaKortti, tokaKortti);
        }
    }
    /**
     * metodi testaa onko kaksi korttia samat
     * @param kortti1 ensimmäinen vertailtava kortti
     * @param kortti2 toinen vertailtava kortti
     */
    public void olikoKortitSamat(Kortti kortti1, Kortti kortti2){
        ekaKortti = kortti1;
        tokaKortti = kortti2;
        if (ekaKortti.getVari() == tokaKortti.getVari()) {
                pelaaja.lisaaPari();
                pelaaja.lisaaYritys();
                //pitÃ¤Ã¤ poistaa pÃ¶ydÃ¤ltÃ¤ lÃ¶ydetty pari
                ensimmainenKorttiKaannetty = false;
                toinenKorttiKaannetty = false;
                ekaKortti.palautaKaannetty();
                tokaKortti.palautaKaannetty();
        }
        else{
            pelaaja.lisaaYritys();
            ensimmainenKorttiKaannetty = false;
            toinenKorttiKaannetty = false;
            ekaKortti.palautaKaannetty();
            tokaKortti.palautaKaannetty();
        }
    }
    /**
     * metodi poistaa halutun kortin pelistä 
     * @param kortti kortti, joka halutana poistaa 
     */
    public void poistaKorttiPelista(Kortti kortti) {
        kortti.setVari(Color.GRAY);
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
        return ekaKortti.onkoKaannetty() && tokaKortti.onkoKaannetty();
    }
    /**
     * metodi palauttaa onko kaksi käännettyä korttia samat
     * @return true tai false
     */
    public boolean onkoKortitSamat() {
        return ekaKortti.getVari() == tokaKortti.getVari();
    }
    /**
     * metodi lopettaa pelin, poistaa kaikki kortit pelistä ja tulostaa 
     * pelaajalle pelin tulokset
     */
    public void lopetaPeli() {
        kortitPelissa.removeAll(kortitPelissa);
        System.out.println("Peli pÃ¤Ã¤ttyi");
        System.out.print("KÃ¤ytit " + pelaaja.getYritystenMaara() + "yritystÃ¤.");
        System.out.println("LÃ¶ysit" + pelaaja.getLoydetytParit() + "paria.");

    }

}
