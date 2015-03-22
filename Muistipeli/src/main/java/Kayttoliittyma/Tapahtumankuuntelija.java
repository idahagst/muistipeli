/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Logiikka.Pelaaja;
import Logiikka.Peli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Ida
 */
public class Tapahtumankuuntelija implements ActionListener {
    
    private JButton aloita;
    private JButton lopeta;
    private JTextField yritystenMaara;
    private JLabel tasonvalinta;
    private Kayttoliittyma kayttoliittyma;
    private Peli peli;
    private Pelaaja pelaaja;
    

    public Tapahtumankuuntelija(JButton aloita, JButton lopeta, JTextField yritystenMaara){
        this.aloita = aloita;
        this.lopeta = lopeta;
        this.yritystenMaara = yritystenMaara;
        this.tasonvalinta = tasonvalinta;
        this.kayttoliittyma = new Kayttoliittyma();
        this.peli = new Peli();
        this.pelaaja = new Pelaaja("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == aloita){
            peli.aloitaPeli();
        } else if (e.getSource() == lopeta){
            peli.lopetaPeli();
        } 
        
        int yritykset = pelaaja.getYritystenMaara();
        yritystenMaara.setText("" + yritykset);
    }
}
