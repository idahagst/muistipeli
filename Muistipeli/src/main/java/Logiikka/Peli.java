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
    private Kortti[][] kortit;//taulukko joka pitää sisällään kortteja
    private ArrayList<Kortti> korttilista = new ArrayList<Kortti>();
    private Pelaaja pelaaja;
    private boolean ensimmainenKorttiKaannetty;
    private boolean toinenKorttiKaannetty;
    private int ekaKortti;
    private int tokaKortti;
    private int yrityksiaJaljella;
    private ArrayList<Integer> kortitPelissa;
    
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

    public ArrayList getKortit() {
        return korttilista;
    }

    public int getKorttiparienLukumaara() {
        return korttilista.size();
    }
    
    public void aloitaPeli(int y, int x){
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
    
    public Kortti[][] arvoKortit(){
        int parienMaara = 10;
        kortitPelissa = new ArrayList<Integer>();
        int i = 0;
        while(i<parienMaara){
            kortitPelissa.add(i);
            kortitPelissa.add(i);
            i++;
        }
        Collections.shuffle(kortitPelissa);
        for(int y=0; y<5; y++){
            for(int x=0; x<4; x++){
                Kortti kortti = new Kortti(kortitPelissa.get(0));
                kortit[y][x] = kortti;
                
            }
        }
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
                //pitää poistaa pöydältä löydetty pari
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
                // kääntääkö äskeinen kortit takaisin vai miten käännetään?
            }
        }
    }
            
        
        
        
//        else if(this.yrityksiaJaljella == 0) {
//            System.out.println("Sinulla ei ole enää yrityksiä");
//            lopetaPeli();
//        }
        
    
    
    public void lopetaPeli(){
        kortitPelissa.removeAll(kortitPelissa);
        System.out.println("Peli päättyi");
        System.out.print("Käytit " + pelaaja.getYritystenMaara() + "yritystä.");
        System.out.println("Löysit" + pelaaja.getLoydetytParit() + "paria.");
        
    }
    
}
