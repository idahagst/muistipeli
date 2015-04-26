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
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/**
 * Luokka luo pelin näytölle ja hoitaa pelin graafiset toiminnot
 *
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
    private int x;
    private int y;
    private Timer timer;
//    private long aloitusaika;
//    private long lopetusaika;

    /**
     * konstruktori yhdistää logiikassa käytettävän pelin käyttöliittymään eli
     * luo peliksi oikean pelin, se luo uuden pelilaudan, jolle voidaan piirtää
     * ja se luo pelaajan, joka pelaa peliä, konstruktori kutsuu metodia
     * Ikkuna();
     *
     * @param peli
     */
    public Kayttoliittyma(Peli peli) {

        this.muistipeli = peli;
        pelilauta = new RectDraw(peli);
        Ikkuna();
        pelaaja = muistipeli.getPelaaja();
        this.timer = new Timer(1000, new MyTimerActionListener());
        
    }

    /**
     * metodi luo peli-ikkunan ja lisää sille hiirenkuuntelijan metodi myös
     * kutsuu luoNapit() metodia
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
     * metodi luo peli-ikkunaan napit, joista voi valita pelin tason metodi luo
     * myös osiot, joissa näkyy pelaajan yritysten ja löydettyjen parien määrä
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
     * metodi lopettaa pelin ja tulostaa pelaajalle näkyville kuinka monta
     * yritystä hän käytti ja kuinka monta paria hän löysi
     */
    public void lopetaPeli() {
//        this.lopetusaika = System.currentTimeMillis();
//        double kaytettyaika = (lopetusaika - aloitusaika)/ 1000;
        JPanel lopetuspaneeli = new JPanel(new GridLayout(2, 1));
        JLabel lopetusteksti = new JLabel("Peli päättyi!");
        JLabel toinenteksti = new JLabel("Käytit " + pelaaja.getYritystenMaara() + " yritystä ja löysit " + pelaaja.getLoydetytParit() + " paria.");
//        JLabel kolmasteksti = new JLabel("Käytit aikaa " + kaytettyaika + "sekuntia");
        lopetuspaneeli.add(lopetusteksti);
        lopetuspaneeli.add(toinenteksti);
//        lopetuspaneeli.add(kolmasteksti);
        peliIkkuna.add(lopetuspaneeli, BorderLayout.SOUTH);
        muistipeli.getPelaaja().nollaaLoydetyt();
        muistipeli.getPelaaja().nollaaYritykset();
        muistipeli.poistaKortit();
        yritystenMaara.setText("Yritykset " + pelaaja.getYritystenMaara());
        loydetytParit.setText("Löydetyt " + pelaaja.getLoydetytParit());
        pelilauta.repaint();
    }

    /**
     * luokka piirtää pelilaudalle muistipelin kortit riippuen siitä, minkä
     * tason pelaaja valitsee
     */
    class RectDraw extends JPanel {

        private Peli muistipeli;
/**
 * konstruktorille liitetään peli, josta saadaan tieto, mitä piirretään
 * @param muistipeli 
 */
        public RectDraw(Peli muistipeli) {
            this.muistipeli = muistipeli;
        }
/**
 * metodi kutsuu toista metodia, joka piirtää pelin kortit
 * @param g 
 */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g);
        }
/**
 * metodi piirtää pelin kortit laudalle
 * @param g 
 */
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
            pelaaja.nollaaLoydetyt();
            pelaaja.nollaaYritykset();
//            long aloitusaika = System.currentTimeMillis();
            pelilauta.repaint();
        } else if (e.getSource() == aloitakeskivaikea) {
            muistipeli.aloitaPeli(3, 4);
            pelaaja.nollaaLoydetyt();
            pelaaja.nollaaYritykset();
            pelilauta.repaint();
        } else if (e.getSource() == aloitavaikea) {
            muistipeli.aloitaPeli(4, 4);
            pelaaja.nollaaLoydetyt();
            pelaaja.nollaaYritykset();
            pelilauta.repaint();
        } else if (e.getSource() == lopeta) {
            lopetaPeli();
            pelilauta.repaint();
        }
    }

    class MyTimerActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (muistipeli.onkoKaksiKorttiaKaannetty()) {
            muistipeli.olikoKortitSamat();
            if (muistipeli.onkoKaikkiKortitKaannetty()) {
                lopetaPeli();
            }
            pelilauta.repaint();
            timer.stop();
        }
        yritystenMaara.setText("Yritykset " + pelaaja.getYritystenMaara());
        loydetytParit.setText("Löydetyt " + pelaaja.getLoydetytParit());
        
        }
        
    }
    @Override
    public void mouseClicked(MouseEvent e)  {
        int ykoordinaatti = e.getY() / 120;
        int xkoordinaatti = e.getX() / 120;
        int y = e.getY();
        int x = e.getX();
        Color lapinakyva = new Color(0, 0, 0, 0);
                if (muistipeli.getPelinKorkeus() == 2) {
                    if (y < 120 && y > 20 || y < 240 && y > 140) {
                        if (x < 120 && x > 20 || x < 240 && x > 140 || x < 360 && x > 260) {
                            Kortti kortti = muistipeli.getKortti(ykoordinaatti, xkoordinaatti);
                            if(kortti.getVari().equals(lapinakyva)){
                                
                            } else {
                            muistipeli.kaannaKortti(kortti);
                            }
                        }
                    }
                }else if (muistipeli.getPelinKorkeus() == 3) {
                    if (y < 120 && y > 20 || y < 240 && y > 140 || y < 360 && y > 260) {
                        if (x < 120 && x > 20 || x < 240 && x > 140 || x < 360 && x > 260  || x <480 && x >380) {
                            Kortti kortti = muistipeli.getKortti(ykoordinaatti, xkoordinaatti);
                            if(kortti.getVari().equals(lapinakyva)){
                                
                            } else {
                            muistipeli.kaannaKortti(kortti);
                            }
                        }
                    }
                }else if (muistipeli.getPelinKorkeus() == 4) {
                    if (y < 120 && y > 20 || y < 240 && y > 140 || y < 360 && y > 260 || y <480 && y >380) {
                        if (x < 120 && x > 20 || x < 240 && x > 140 || x < 360 && x > 260 || x <480 && x >380) {
                            Kortti kortti = muistipeli.getKortti(ykoordinaatti, xkoordinaatti);
                            if(kortti.getVari().equals(lapinakyva)){
                                
                            } else {
                            muistipeli.kaannaKortti(kortti);
                            }
                        }
                    }
                }
            pelilauta.repaint();
            timer.start();
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
