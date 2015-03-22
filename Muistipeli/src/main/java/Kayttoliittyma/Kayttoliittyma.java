/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Logiikka.Pelaaja;
import Logiikka.Peli;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Ida
 */
public class Kayttoliittyma {
    private Peli muistipeli;
    private Pelaaja pelaaja;
    private Frame frame;
    
    
    public Kayttoliittyma(){
        
    }
    public void run(){
        frame = new JFrame("Muistipeli");
        frame.setPreferredSize(new Dimension(800, 500));
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    
    private void luoAloitaNappi(Container container){
        JButton aloita = new JButton("Aloita");
        container.add(aloita);
        JButton lopeta = new JButton("Lopeta");
        container.add(lopeta);
        JTextField yritystenMaara = new JTextField("0");
        container.add(yritystenMaara);
        yritystenMaara.setEnabled(false);
    }
    
}
