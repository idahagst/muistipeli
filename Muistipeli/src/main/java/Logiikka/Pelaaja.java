/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

/**
 * Pelaaja-luokka kertoo minkälainen on pelaaja-olio
 * @author Ida
 */
public class Pelaaja {
    /**
     * pelaajan nimi
     */
    private String nimi;
    /**
     * pelaajan löytämät korttiparit
     */
    private int loydetytParit;
    /**
     * pelaajan käyttämien yritysten määrä
     */
    private int yritystenMaara;
    /**
     * konstruktori luo pelaajan ja asettaa tälle nimen
     * konstruktori asettaa löydetyt parit ja yritykset 0
     * @param nimi Pelaajan nimi
     */
    public Pelaaja(String nimi){
       this.nimi = nimi;
       this.loydetytParit = 0;
       this.yritystenMaara = 0;
    }
    
    public String getNimi(){
        return this.nimi;
    }
    
    public int getLoydetytParit(){
        return this.loydetytParit;
    }
    
    public int getYritystenMaara(){
        return this.yritystenMaara;
    }
    /**
     * metodi lisää pelaajalle yhden löydetyn korttiparin
     */
    public void lisaaPari(){
        this.loydetytParit++;
    }
    /**
     * metodi lisää pelaajalle yhden yrityksen
     */
    public void lisaaYritys(){
        this.yritystenMaara++;
    }
    /**
     * metodi nollaa pelaajan yritykset
     */
    public void nollaaYritykset(){
        this.yritystenMaara = 0;
    }
    /**
     * metodi nollaa pelaajan löytämät korttiparit
     */
    public void nollaaLoydetyt(){
        this.loydetytParit = 0;
    }
}
