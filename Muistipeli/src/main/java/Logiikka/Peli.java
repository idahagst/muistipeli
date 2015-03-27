/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

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
    private ArrayList<Kortti> korttilista = new ArrayList<Kortti>();
    private Pelaaja pelaaja;
    private boolean ensimmainenKorttiKaannetty;
    private boolean toinenKorttiKaannetty;
    private int ekaKortti;
    private int tokaKortti;
    private int yrityksiaJaljella;
    private ArrayList<Integer> kortitPelissa;
    private int korkeus;
    private int leveys;
    
    public Peli(){
//        this.kortit = new Kortti[y][x];
        this.pelaaja = new Pelaaja("");
        //this.yrityksiaJaljella = ?;
        // aloitaPeli();
    }
    
    public void lisaaKortti(Kortti kortti){
        korttilista.add(kortti);
        
    }
    
    public void poistaKortit() {
        korttilista.removeAll(korttilista);
    }

//    public ArrayList getKortit() {
//        return korttilista;
//    }

    public int getKorttiparienLukumaara() {
        return korttilista.size();
    }
    
    public void aloitaPeli(int y, int x){
        this.korkeus = y;
        this.leveys = x;
        this.kortit = new Kortti[y][x];
        ensimmainenKorttiKaannetty = false;
        toinenKorttiKaannetty = false;
        arvoKortit();
    }
//    public void valitseTaso(){
//        System.out.println("Kuinka monta korttiparia?");
//        int korttiparienMaara = Integer.parseInt(lukija.nextLine());
//        arvoKortit();
//    }
    
    public void arvoKortit(){
        int parienMaara = leveys*korkeus/2;
        kortitPelissa = new ArrayList<Integer>();
        int i = 0;
        while(i<parienMaara){
            kortitPelissa.add(i);
            kortitPelissa.add(i);
            i++;
        }
        Collections.shuffle(kortitPelissa);
        for(int y=0; y<korkeus; y++){
            for(int x=0; x<leveys; x++){
                Kortti kortti = new Kortti(kortitPelissa.get(0));
                kortit[y][x] = kortti;
                
            }
        }
        
        
                
    }
    public int pelinKorkeus(){
        return this.korkeus;
    }
    public int pelinLeveys(){
        return this.leveys;
    }
    public Kortti[][] getKortit(){
        return kortit;
    }
    
    public void kaannaKortti(int kortinNumero){
        int korttienMaara = kortitPelissa.size();
        
        if(ensimmainenKorttiKaannetty == false && toinenKorttiKaannetty == false){
           ensimmainenKorttiKaannetty = true;
           ekaKortti = kortinNumero;
            
        } else if (ensimmainenKorttiKaannetty == true && toinenKorttiKaannetty == false){
            toinenKorttiKaannetty = true;
            tokaKortti = kortinNumero;
            if (ekaKortti == tokaKortti){
                pelaaja.lisaaPari();
                pelaaja.lisaaYritys();
//                this.yrityksiaJaljella--;
                //pitÃ¤Ã¤ poistaa pÃ¶ydÃ¤ltÃ¤ lÃ¶ydetty pari
                ensimmainenKorttiKaannetty = false;
                toinenKorttiKaannetty = false;
                korttienMaara = korttienMaara - 2;
                if(korttienMaara<2){
                    lopetaPeli();
                }
                
            } else {
                pelaaja.lisaaYritys();
//                this.yrityksiaJaljella--;
                ensimmainenKorttiKaannetty = false;
                toinenKorttiKaannetty = false;
                // kÃ¤Ã¤ntÃ¤Ã¤kÃ¶ Ã¤skeinen kortit takaisin vai miten kÃ¤Ã¤nnetÃ¤Ã¤n?
            }
        }
    }
    
    public boolean onkoKortitSamat(){
        if(ekaKortti == tokaKortti){
            pelaaja.lisaaPari();
            pelaaja.lisaaYritys();
            return true;
        } 
        pelaaja.lisaaYritys();
        return false;
    }
            
        
        
        
//        else if(this.yrityksiaJaljella == 0) {
//            System.out.println("Sinulla ei ole enÃ¤Ã¤ yrityksiÃ¤");
//            lopetaPeli();
//        }
        
    
    
    public void lopetaPeli(){
        kortitPelissa.removeAll(kortitPelissa);
        System.out.println("Peli pÃ¤Ã¤ttyi");
        System.out.print("KÃ¤ytit " + pelaaja.getYritystenMaara() + "yritystÃ¤.");
        System.out.println("LÃ¶ysit" + pelaaja.getLoydetytParit() + "paria.");
        
    }
    
}
