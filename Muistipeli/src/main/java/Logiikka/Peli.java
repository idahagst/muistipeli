/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

import java.util.ArrayList;

/**
 *
 * @author Ida
 */
public class Peli {
   
    private ArrayList<Kortti> kortit;
    
    public Peli(){
        this.kortit = new ArrayList<Kortti>();
    }
    
    public void lisaaKortti(Kortti kortti){
        kortit.add(kortti);
    }
    
    public void poistaKortit(){
        kortit.removeAll(kortit);
    }
    
    public ArrayList getKortit(){
        return kortit;
    }
}
