/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

/**
 *
 * @author Ida
 */
public class Pelaaja {
    
    private String nimi;
    private int loydetytParit;
    private int yritystenMaara;
    
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
    
    public void lisaaPari(){
        this.loydetytParit++;
    }
    
    public void lisaaYritys(){
        this.yritystenMaara++;
    }
    
    public void nollaaYritykset(){
        this.yritystenMaara = 0;
    }
    public void nollaaLoydetyt(){
        this.loydetytParit = 0;
    }
}
