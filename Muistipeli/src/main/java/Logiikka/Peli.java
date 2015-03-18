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
    
    public Peli(){
        this.kortit = new ArrayList<String>();
        this.pelaaja = new Pelaaja("");
//        aloitaPeli();
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
    
    public int getKorttienLukumaara(){
        return kortit.size();
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
        if(ensimmainenKorttiKaannetty == false && toinenKorttiKaannetty == false){
           ensimmainenKorttiKaannetty = true;
           //ekaKortti = jostain saataisiin ekan käännetyn kortin nimi 
            
        } else if (ensimmainenKorttiKaannetty == true && toinenKorttiKaannetty == false){
            toinenKorttiKaannetty = true;
            //tokaKortti = jostain tokan käännetyn kortin nimi
            if (ekaKortti == tokaKortti){
                pelaaja.lisaaPari();
            } else {
                System.out.println("Kortit eivät olleet samat");
            }
            ensimmainenKorttiKaannetty = false;
            toinenKorttiKaannetty = false;
        }
    }
    
}
