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
    
    
    private ArrayList<String> kortit;
    private Pelaaja pelaaja;
    private boolean ensimmainenKorttiKaannetty;
    private boolean toinenKorttiKaannetty;
    private String ekaKortti;
    private String tokaKortti;
    private int yrityksiaJaljella;
    
    public Peli(){
        this.kortit = new ArrayList<String>();
        this.pelaaja = new Pelaaja("");
        //this.yrityksiaJaljella = ?;
        // aloitaPeli();
    }
    
    public void lisaaKortti(String nimi){
        kortit.add(nimi);
        kortit.add(nimi);
        //lisääkö tämä kaksi samannimistä korttia listaan, jolloin listassa olis 
        //kaikkia kortteja kaksi?
    }
    
    public void poistaKortit(){
        kortit.removeAll(kortit);
    }
    
    public ArrayList getKortit(){
        return kortit;
        //tulostaa kaikki kortit kahteen kertaan koska ne on listassa kaks kettaa
    }
    
    public int getKorttiparienLukumaara(){
        return kortit.size()/2;
    }
    
    public void aloitaPeli(){
        ensimmainenKorttiKaannetty = false;
        toinenKorttiKaannetty = false;
        arvoKortit();
    }
    
    public ArrayList arvoKortit(){
        Collections.shuffle(kortit);
        return kortit;
        
    }
    
    public void kaannaKortti(){
        if(this.yrityksiaJaljella > 0){ //&& kortteja on pöydällä)
        if(ensimmainenKorttiKaannetty == false && toinenKorttiKaannetty == false){
           ensimmainenKorttiKaannetty = true;
           //ekaKortti = jostain saataisiin ekan käännetyn kortin nimi 
            
        } else if (ensimmainenKorttiKaannetty == true && toinenKorttiKaannetty == false){
            toinenKorttiKaannetty = true;
            //tokaKortti = jostain tokan käännetyn kortin nimi
            if (ekaKortti == tokaKortti){
                pelaaja.lisaaPari();
                pelaaja.lisaaYritys();
                this.yrityksiaJaljella--;
                ensimmainenKorttiKaannetty = false;
                toinenKorttiKaannetty = false;
                //pitää poistaa pöydältä löydetty pari
            } else {
                System.out.println("Kortit eivät olleet samat");
                pelaaja.lisaaYritys();
                this.yrityksiaJaljella--;
                ensimmainenKorttiKaannetty = false;
                toinenKorttiKaannetty = false;
                // kääntääkö äskeinen kortit takaisin vai miten käännetään?
            }
            
        }
        }
        else if(this.yrityksiaJaljella == 0) {
            System.out.println("Sinulla ei ole enää yrityksiä");
            lopetaPeli();
        }
        //else if(kaikki kortit käännetty){
        //lopetaPeli();
    }
    public void lopetaPeli(){
        System.out.println("Peli päättyi");
        System.out.print("Käytit " + pelaaja.getYritystenMaara() + "yritystä.");
        System.out.println("Löysit" + pelaaja.getLoydetytParit() + "paria.");
        
    }
    
}
