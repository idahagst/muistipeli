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
    
    private JButton aloitahelppo;
    private JButton aloitakeskivaikea;
    private JButton aloitavaikea;
    private JButton lopeta;
    private JTextField yritystenMaara;
    private JLabel tasonvalinta;
    private Kayttoliittyma kayttoliittyma;
    private Peli peli;
    private Pelaaja pelaaja;
    

    Tapahtumankuuntelija(Kayttoliittyma liittyma, JButton aloitahelppo, JButton aloitakeskivaikea, JButton aloitavaikea, JButton lopeta, JTextField yritystenMaara){
        this.kayttoliittyma = liittyma;
        this.aloitahelppo = aloitahelppo;
        this.aloitakeskivaikea = aloitakeskivaikea;
        this.aloitavaikea = aloitavaikea;
        this.lopeta = lopeta;
        this.yritystenMaara = yritystenMaara;
//        this.tasonvalinta = tasonvalinta;
        this.peli = new Peli();
        this.pelaaja = new Pelaaja("");
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == aloitahelppo){
            peli.aloitaPeli(3,4);
        } else if(e.getSource() == aloitakeskivaikea){
            peli.aloitaPeli(5,4);
        } else if(e.getSource()== aloitavaikea){
            peli.aloitaPeli(6,6);
        }else if (e.getSource() == lopeta){
            peli.lopetaPeli();
        
        int yritykset = pelaaja.getYritystenMaara();
        yritystenMaara.setText("" + yritykset);
    }
}
}
