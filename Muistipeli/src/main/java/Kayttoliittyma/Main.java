/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Logiikka.Peli;

/**
 *
 * @author Ida
 */
public class Main {
    
    public static void main(String[] args){
        Peli peli = new Peli();
        Kayttoliittyma liittyma = new Kayttoliittyma(peli);
        peli.aloitaPeli(2, 3);
        
        
    }
}
