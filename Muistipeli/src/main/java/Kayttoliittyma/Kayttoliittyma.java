/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Logiikka.Kortti;
import Logiikka.Pelaaja;
import Logiikka.Peli;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Ida
 */
public class Kayttoliittyma implements ActionListener {

    private Peli muistipeli;
    private Pelaaja pelaaja;
    private JFrame peliIkkuna;
    private JButton aloitahelppo;
    private JButton aloitakeskivaikea;
    private JButton aloitavaikea;
    private JButton lopeta;
    private JTextArea yritystenMaara;
    private Graphics g;

    public Kayttoliittyma(Peli peli) {
        this.muistipeli = peli;
        Ikkuna();
    }

    public void Ikkuna() {
        peliIkkuna = new JFrame("Muistipeli");
        peliIkkuna.setPreferredSize(new Dimension(800, 500));
        peliIkkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        peliIkkuna.pack();
        luoNapit();
        RectDraw newrect = new RectDraw();
        peliIkkuna.add(newrect);
        peliIkkuna.setVisible(true);
    }

//    private void luoIkkunanOsat(Container container) {
//        container.add(new JPanel()); // itse muistipeliosa
//        container.add(luoNapit(), BorderLayout.SOUTH); // napit osio
//    }
    private void luoNapit() {
        JPanel nappipaneeli = new JPanel(new GridLayout(1, 5));
        aloitahelppo = new JButton("Helppo");
        aloitahelppo.addActionListener(this);
        nappipaneeli.add(aloitahelppo);
        aloitakeskivaikea = new JButton("Keskivaikea");
        aloitakeskivaikea.addActionListener(this);
        nappipaneeli.add(aloitakeskivaikea);
        aloitavaikea = new JButton("Vaikea");
        aloitavaikea.addActionListener(this);
        nappipaneeli.add(aloitavaikea);
        lopeta = new JButton("Lopeta");
        lopeta.addActionListener(this);
        nappipaneeli.add(lopeta);
        yritystenMaara = new JTextArea("0");
        //millä tätä muutetaan?
        nappipaneeli.add(yritystenMaara);
        peliIkkuna.add(nappipaneeli, BorderLayout.NORTH);
    }

    public void luoKortit() {
        JPanel korttipaneeli = new JPanel(new GridLayout(1, 5));
        Kortti[][] kortit = muistipeli.getKortit();
        for (int y = 0; y < muistipeli.pelinKorkeus(); y++) {
            for (int x = 0; x < muistipeli.pelinLeveys(); x++) {
                Kortti kortti = kortit[y][x];
                int kortinNumero = kortti.kortinNumero();
                JButton luotuKortti = new JButton("" + kortinNumero);
                luotuKortti.addActionListener(this);

                korttipaneeli.add(luotuKortti);

                // kÃ¤ydÃ¤Ã¤n korttei lÃ¤pi for silmukoilla ja sisimmÃ¤ssÃ¤ silmukassa luodaan kaikille jbuttonit
                // jbuttonin nimi on joko tyhjÃ¤ tai kortin numero riippuen kummin pÃ¤in
                //lisÃ¤Ã¤ taulukko, jossa kortit on tÃ¤nne
            }
        }
        peliIkkuna.add(korttipaneeli, BorderLayout.SOUTH);

    }

    private static class RectDraw extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g);
        }

        public void draw(Graphics g) {
            for (int i = 10; i < 250; i = i + 120) {
                for(int j = 10; j<300; j = j+120){
                int x = j+10;
                int y = i+10;
                g.drawRect(x, y, 100, 100);
            }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aloitahelppo) {
            muistipeli.aloitaPeli(3, 4);
        } else if (e.getSource() == aloitakeskivaikea) {
            muistipeli.aloitaPeli(5, 4);
        } else if (e.getSource() == aloitavaikea) {
            muistipeli.aloitaPeli(6, 6);
        } else if (e.getSource() == lopeta) {
            muistipeli.lopetaPeli();

            int yritykset = pelaaja.getYritystenMaara();
            yritystenMaara.setText("" + yritykset);
        }

    }

    public JFrame getFrame() {
        return peliIkkuna;
    }
    //taulukosta tiedot miten aina kuva repaintataan tällöin logiikka tietää
    //mikä kuva on oikeinpäin ja mikä väärinpäin ja muut jutut jolloin JFrameen 
    //piirretään 
    //aina kun painetaan nappii niin repaint peli uudelleen
    //Rectangle bounds = new Rectangle(korkeus, leveys, y, x); tms piirtää neliön
    //loopataan taulukkoa logiikassa josta saadaan tiedot ja piirretään
    //seurataan hiirtä, jos se on kohdassa johon on piirretty kortti, niin repaint 
    //koko paska ja logiikan puolella tarkastellaan muita juttuja
    //eli jos se missä kohtaa hiiri on, on samassa kohtaa ku taulukon kohta esim [1][2] 
    //niin logiikassa muutetaan tämä kortti käännetyksi ja käännetään toinen kortti samaan
    //tapaan ja tämän jälkeen logiikassa verrataan näitä kortteja ja tehdään tarvittavat 
    //jutut jonka jälkeen piirretään taas uudelleen pelilauta vastaamaan oikeaa 

    //jos ollaan tietyssa kohdassa kuvaa ja tiedetään sen koordinaatit niin hiirenkuuntelijalla
    //katsotaan missä ollaan ja loopataan kaikki taulukon kohdat ja katsotaan mikä kohta
    //vastaa sitä mihin hiirellä painetaan ja logiikassa tehdään loput eli käännetään
    //ja sen jälkeen piirretään uudelleen
}
