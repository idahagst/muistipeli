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
    private ArrayList<String> kortit;
    private Pelaaja pelaaja;
    private boolean ensimmainenKorttiKaannetty;
    private boolean toinenKorttiKaannetty;
    private String ekaKortti;
    private String tokaKortti;
    private int yrityksiaJaljella;
    private ArrayList<String> kortitPelissa;
    
    public Peli(){
        this.kortit = new ArrayList<String>();
        this.pelaaja = new Pelaaja("");
        //this.yrityksiaJaljella = ?;
        // aloitaPeli();
    }
    
    public void lisaaKortti(String nimi){
        kortit.add(nimi);
        
    }
    
    public void poistaKortit(){
        kortit.removeAll(kortit);
    }
    
    public ArrayList getKortit(){
        return kortit;
    }
    
    public int getKorttiparienLukumaara(){
        return kortit.size();
    }
    
    public void aloitaPeli(){
        ensimmainenKorttiKaannetty = false;
        toinenKorttiKaannetty = false;
        valitseTaso();
    }
    public void valitseTaso(){
        System.out.println("Kuinka monta korttiparia?");
        int korttiparienMaara = Integer.parseInt(lukija.nextLine());
        arvoKortit(korttiparienMaara);
    }
    
    public ArrayList arvoKortit(int kuinkaMontaParia){
        int parienMaara = kuinkaMontaParia;
        Collections.shuffle(kortit);
        kortitPelissa = new ArrayList<String>();
        int i = 0;
        while(i<=parienMaara){
            kortitPelissa.add(kortit.get(i));
            kortitPelissa.add(kortit.get(i));
            i++;
        }
        return kortitPelissa;
                
    }
    
    public void kaannaKortti(){
        int korttienMaara = kortitPelissa.size();
        if(korttienMaara >=2){
        if(ensimmainenKorttiKaannetty == false && toinenKorttiKaannetty == false){
           ensimmainenKorttiKaannetty = true;
           //ekaKortti = jostain saataisiin ekan käännetyn kortin nimi 
            
        } else if (ensimmainenKorttiKaannetty == true && toinenKorttiKaannetty == false){
            toinenKorttiKaannetty = true;
            //tokaKortti = jostain tokan käännetyn kortin nimi
            if (ekaKortti == tokaKortti){
                pelaaja.lisaaPari();
                pelaaja.lisaaYritys();
//                this.yrityksiaJaljella--;
                ensimmainenKorttiKaannetty = false;
                toinenKorttiKaannetty = false;
                korttienMaara = korttienMaara - 2;
                //pitää poistaa pöydältä löydetty pari
            } else {
                System.out.println("Kortit eivät olleet samat");
                pelaaja.lisaaYritys();
//                this.yrityksiaJaljella--;
                ensimmainenKorttiKaannetty = false;
                toinenKorttiKaannetty = false;
                // kääntääkö äskeinen kortit takaisin vai miten käännetään?
            }
            
        }
        } else if( korttienMaara<2){
            lopetaPeli();
        }
        
//        else if(this.yrityksiaJaljella == 0) {
//            System.out.println("Sinulla ei ole enää yrityksiä");
//            lopetaPeli();
//        }
        
    }
    
    public void lopetaPeli(){
        kortitPelissa.removeAll(kortitPelissa);
        System.out.println("Peli päättyi");
        System.out.print("Käytit " + pelaaja.getYritystenMaara() + "yritystä.");
        System.out.println("Löysit" + pelaaja.getLoydetytParit() + "paria.");
        
    }
    
}
