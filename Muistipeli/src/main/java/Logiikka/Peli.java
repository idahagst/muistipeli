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
 *
 * @author Ida
 */
public class Peli {

    private Scanner lukija;
    private Kortti[][] kortit;//taulukko joka pitÃ¤Ã¤ sisÃ¤llÃ¤Ã¤n kortteja
    private ArrayList<Kortti> korttilista = new ArrayList<Kortti>(); //kaikki mahdolliset kortit
    private Pelaaja pelaaja;
    private boolean ensimmainenKorttiKaannetty;
    private boolean toinenKorttiKaannetty;
    private Kortti ekaKortti;
    private Kortti tokaKortti;
    private int yrityksiaJaljella;
    private ArrayList<Integer> kortitPelissa; //pelissä olevat kortit, jokaista listassa kaksi
    private int korkeus;
    private int leveys;
    private ArrayList<Color> varit;

    public Peli() {
//        this.kortit = new Kortti[y][x];
        this.pelaaja = new Pelaaja("");
        //this.yrityksiaJaljella = ?;
        // aloitaPeli();
        this.varit = new ArrayList<Color>();
        varit.add(Color.RED);
        varit.add(Color.BLUE);
        varit.add(Color.GREEN);
        varit.add(Color.YELLOW);
        
    }

    public void lisaaKortti(Kortti kortti) {
        korttilista.add(kortti);

    }

    public void poistaKortit() {
        korttilista.removeAll(korttilista);
    }
    
    public int getKorttiparienLukumaara() {
        return korttilista.size();
    }

    public void aloitaPeli(int y, int x) {
        this.korkeus = y;
        this.leveys = x;
        this.kortit = new Kortti[y][x];
        ensimmainenKorttiKaannetty = false;
        toinenKorttiKaannetty = false;
        arvoKortit();
    }

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

    
    
    public int pelinKorkeus() {
        return this.korkeus;
    }

    public int pelinLeveys() {
        return this.leveys;
    }

    public Kortti[][] getKortit() {
        return kortit;
    }
    
    public Kortti getKortti(int y, int x){
        return kortit[y][x];
    }

    public void kaannaKortti(Kortti kortti) {
        int korttienMaara = kortitPelissa.size();

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
    
    public void olikoKortitSamat(Kortti kortti1, Kortti kortti2){
        ekaKortti = kortti1;
        tokaKortti = kortti2;
        if (ekaKortti.getVari() == tokaKortti.getVari()) {
                pelaaja.lisaaPari();
                pelaaja.lisaaYritys();
//                this.yrityksiaJaljella--;
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
    public void poistaKorttiPelista(Kortti kortti) {
        kortti.setVari(Color.white);
    }

    public boolean onkoKortitSamat() {
        if (ekaKortti.getVari() == tokaKortti.getVari()) {
            return true;
        }
        return false;
    }

//        else if(this.yrityksiaJaljella == 0) {
//            System.out.println("Sinulla ei ole enÃ¤Ã¤ yrityksiÃ¤");
//            lopetaPeli();
//        }
    public void lopetaPeli() {
        kortitPelissa.removeAll(kortitPelissa);
        System.out.println("Peli pÃ¤Ã¤ttyi");
        System.out.print("KÃ¤ytit " + pelaaja.getYritystenMaara() + "yritystÃ¤.");
        System.out.println("LÃ¶ysit" + pelaaja.getLoydetytParit() + "paria.");

    }

}
