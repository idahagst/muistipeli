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
public class Kayttoliittyma extends JPanel implements ActionListener, MouseListener {

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
        newrect.addMouseListener(this);
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

    class RectDraw extends JPanel {

        private Peli muistipeli;

        public RectDraw() {
            this.muistipeli = new Peli();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g);
        }

        public void draw(Graphics g) {
            for (int i = 20; i < 250; i = i + 120) {
                for (int j = 20; j < 300; j = j + 120) {
                    int x = j;
                    int y = i;
//                    for (int a = 0; a < 2; a++) {
//                        for (int b = 0; b < 3; b++) {
//                            if (muistipeli.getKortti(a, b).onkoKaannetty() == false) {
                            //etittäis tietty kortti muistipelistä ja katottais
                                //onks se käännetty vai ei ja piirretään sen mukaan
                                //oikeenlainen neliö
                                g.drawRect(x, y, 100, 100);
                                g.fillRect(x, y, 100, 100);
//                            } else {
//                                g.drawRect(x, y, 100, 100);
//                            }
//                        }
//                    }
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getX() <= 120 && e.getX() >= 20 && e.getY() <= 120 && e.getY() >= 20) {
            Kortti kortti = muistipeli.getKortti(0, 0);
            muistipeli.kaannaKortti(kortti);
            //pitääkö tässä kutsua uudelleen piirtotyökalua, jotta se piirtää
            //kortit uudelleen oikein
        } else if (e.getX() <= 240 && e.getX() >= 140 && e.getY() <= 120 && e.getY() >= 20) {
            Kortti kortti = muistipeli.getKortti(0, 1);
            muistipeli.kaannaKortti(kortti);
        }
        //pitää vielä lisätä muut tai miten ne kannattaa hoitaa?
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public JFrame getFrame() {
        return peliIkkuna;
    }
//    public void luoKortit() {
//        JPanel korttipaneeli = new JPanel(new GridLayout(1, 5));
//        Kortti[][] kortit = muistipeli.getKortit();
//        for (int y = 0; y < muistipeli.pelinKorkeus(); y++) {
//            for (int x = 0; x < muistipeli.pelinLeveys(); x++) {
//                Kortti kortti = kortit[y][x];
//                int kortinNumero = kortti.kortinNumero();
//                JButton luotuKortti = new JButton("" + kortinNumero);
//                luotuKortti.addActionListener(this);
//
//                korttipaneeli.add(luotuKortti);
//
//                // kÃ¤ydÃ¤Ã¤n korttei lÃ¤pi for silmukoilla ja sisimmÃ¤ssÃ¤ silmukassa luodaan kaikille jbuttonit
//                // jbuttonin nimi on joko tyhjÃ¤ tai kortin numero riippuen kummin pÃ¤in
//                //lisÃ¤Ã¤ taulukko, jossa kortit on tÃ¤nne
//            }
//        }
//        peliIkkuna.add(korttipaneeli, BorderLayout.SOUTH);
//
//    }

}
