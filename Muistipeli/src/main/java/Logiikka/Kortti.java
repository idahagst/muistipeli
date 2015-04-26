 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

import java.awt.Color;

/**
 * Kortti-luokka kertoo minkälainen on kortti-olio
 * @author Ida
 */
public class Kortti {
    /**
     * onkoKaannetty kertoo onko kortti käännettynä pelissä
     */
    private boolean onkoKaannetty;
    /**
     * kertoo kortin värin, eli "kuvan", jolle etsitään paria
     */
    private Color vari;
    
    /**
     * konstruktori luo kortin ja asettaa sille numeron ja värin
     * konstruktori asettaa kortin kääntämättömäksi
     * @param numero kortin numero
     * @param vari kortin väri
     */
    public Kortti(Color vari){
        this.onkoKaannetty = false;
        this.vari = vari;
    }
    /**
     * metodi kertoo onko kortti käännetty vai ei
     * @return true tai false
     */
    public boolean onkoKaannetty(){
        return this.onkoKaannetty;
    }
    /**
     * metodi kääntää kortin eli vaihtaa kortin käännetyksi
     */
    public void kaannaKortti(){
        this.onkoKaannetty = true;
    }
    /**
     * metodi palauttaa käännetyn kortin kääntämättömäksi
     */
    public void palautaKaannetty(){
        this.onkoKaannetty = false;
    }
    public Color getVari(){
        return this.vari;
    }
    public void setVari(Color vari){
        this.vari = vari;
    }
}
