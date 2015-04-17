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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Luokka luo pelin näytölle ja hoitaa pelin graafiset toiminnot
 * @author Ida
 */
public class Kayttoliittyma extends JPanel implements ActionListener, MouseListener {

    private Peli muistipeli;
    private Pelaaja pelaaja;
    private JFrame peliIkkuna;
    private JButton aloitahelppo;
    private JButton aloitakeskivaikea;
    private JButton aloitavaikea;
    private JButton lopeta;
    private JLabel yritystenMaara;
    private JLabel loydetytParit;
    private RectDraw pelilauta;

    /**
     * konstruktori yhdistää logiikassa käytettävän pelin käyttöliittymään eli luo peliksi 
     * oikean pelin, se luo uuden pelilaudan, jolle voidaan piirtää ja se luo pelaajan,
     * joka pelaa peliä, konstruktori kutsuu metodia Ikkuna();
     * @param peli 
     */
    public Kayttoliittyma(Peli peli) {
        
        this.muistipeli = peli;
        pelilauta = new RectDraw(peli);
        Ikkuna();
        pelaaja = muistipeli.getPelaaja();
    }

    /**
     * metodi luo peli-ikkunan ja lisää sille hiirenkuuntelijan
     * metodi myös kutsuu luoNapit() metodia
     */
    public void Ikkuna() {
        peliIkkuna = new JFrame("Muistipeli");
        peliIkkuna.setPreferredSize(new Dimension(800, 600));
        peliIkkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        peliIkkuna.pack();
        luoNapit();
        peliIkkuna.add(pelilauta);
        pelilauta.addMouseListener(this);
        peliIkkuna.setVisible(true);
    }

    /**
     * metodi luo peli-ikkunaan napit, joista voi valita pelin tason
     * metodi luo myös osiot, joissa näkyy pelaajan yritysten ja löydettyjen
     * parien määrä
     */
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
        yritystenMaara = new JLabel("Yritykset 0");
        nappipaneeli.add(yritystenMaara);
        loydetytParit = new JLabel("Löydetyt 0");
        nappipaneeli.add(loydetytParit);
        peliIkkuna.add(nappipaneeli, BorderLayout.NORTH);
    }

    /**
     * metodi lopettaa pelin ja tulostaa pelaajalle näkyville kuinka monta yritystä hän
     * käytti ja kuinka monta paria hän löysi
     */
    public void lopetaPeli() {
//        JFrame lopetusikkuna = new JFrame("Peli päättyi");
//        lopetusikkuna.setPreferredSize(new Dimension(800, 600));
//        lopetusikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        lopetusikkuna.pack();
        JPanel lopetuspaneeli = new JPanel(new GridLayout(2,1));
        JLabel lopetusteksti = new JLabel("Peli päättyi!");
        JLabel toinenteksti = new JLabel("Käytit " + pelaaja.getYritystenMaara() + " yritystä ja löysit " + pelaaja.getLoydetytParit() + " paria.");
        lopetuspaneeli.add(lopetusteksti);
        lopetuspaneeli.add(toinenteksti);
        peliIkkuna.add(lopetuspaneeli, BorderLayout.EAST);
        muistipeli.getPelaaja().nollaaLoydetyt();
        muistipeli.getPelaaja().nollaaYritykset();
        muistipeli.kaannaKaikkiKortit();
        pelilauta.repaint();
        }
    
    

    /**
     * luokka piirtää pelilaudalle muistipelin kortit riippuen siitä, minkä
     * tason pelaaja valitsee
     */
    class RectDraw extends JPanel {

        private Peli muistipeli;

        public RectDraw(Peli muistipeli) {
            this.muistipeli = muistipeli;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g);
        }

        public void draw(Graphics g) {
            if (muistipeli.getPelinKorkeus() == 2) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 2; j++) {
                        Kortti kortti = muistipeli.getKortti(j, i);
                        if (kortti.onkoKaannetty()) {
                            g.setColor(kortti.getVari());
                        } else {
                            g.setColor(Color.black);
                        }
                        g.fillRect(20 + i * 120, 20 + j * 120, 100, 100);

                    }
                }
            } else if (muistipeli.getPelinKorkeus() == 3) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 3; j++) {
                        Kortti kortti = muistipeli.getKortti(j, i);
                        if (kortti.onkoKaannetty()) {
                            g.setColor(kortti.getVari());
                        } else {
                            g.setColor(Color.black);
                        }
                        g.fillRect(20 + i * 120, 20 + j * 120, 100, 100);

                    }
                }
            } else if (muistipeli.getPelinKorkeus() == 4) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        Kortti kortti = muistipeli.getKortti(j, i);
                        if (kortti.onkoKaannetty()) {
                            g.setColor(kortti.getVari());
                        } else {
                            g.setColor(Color.black);
                        }
                        g.fillRect(20 + i * 120, 20 + j * 120, 100, 100);

                    }
                }
            } 
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aloitahelppo) {
            muistipeli.aloitaPeli(2, 3);
            peliIkkuna.repaint();
            pelilauta.repaint();
        } else if (e.getSource() == aloitakeskivaikea) {
            muistipeli.aloitaPeli(3, 4);
            pelilauta.repaint();
        } else if (e.getSource() == aloitavaikea) {
            muistipeli.aloitaPeli(4, 4);
            pelilauta.repaint();
        } else if (e.getSource() == lopeta) {
            lopetaPeli();
            pelilauta.repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int ykoordinaatti = e.getY() / 120;
        int xkoordinaatti = e.getX() / 120;
        Kortti kortti = muistipeli.getKortti(ykoordinaatti, xkoordinaatti);
        muistipeli.kaannaKortti(kortti);
        pelilauta.repaint();
        if (muistipeli.onkoKaksiKorttiaKaannetty()) {
            muistipeli.olikoKortitSamat();
            if(muistipeli.onkoKaikkiKortitKaannetty()){
                lopetaPeli();
            }
            pelilauta.repaint();
        }
        yritystenMaara.setText("Yritykset " + pelaaja.getYritystenMaara());
        loydetytParit.setText("Löydetyt " + pelaaja.getLoydetytParit());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
