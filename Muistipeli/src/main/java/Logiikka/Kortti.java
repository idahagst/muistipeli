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
public class Kortti {
    private boolean onkoKaannetty;
    private int numero;
    
    
    public Kortti(int numero){
        this.numero= numero;
        this.onkoKaannetty = false;
    }
    
    public boolean onkoKaannetty(){
        return this.onkoKaannetty;
    }
    public int kortinNumero(){
        return this.numero;
    }
    public void kaannaKortti(){
        this.onkoKaannetty = true;
    }
    public void palautaKaannetty(){
        this.onkoKaannetty = false;
    }
}
