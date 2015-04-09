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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
    private JLabel yritystenMaara;
    private RectDraw newrect;

    public Kayttoliittyma(Peli peli) {
        this.muistipeli = peli;
        newrect = new RectDraw(peli);
        Ikkuna();
    }

    public void Ikkuna() {
        peliIkkuna = new JFrame("Muistipeli");
        peliIkkuna.setPreferredSize(new Dimension(800, 500));
        peliIkkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        peliIkkuna.pack();
        luoNapit();
        peliIkkuna.add(newrect);
        newrect.addMouseListener(this);
        peliIkkuna.setVisible(true);
    }

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
        yritystenMaara = new JLabel("0");
        //millä tätä muutetaan?
        nappipaneeli.add(yritystenMaara);
        peliIkkuna.add(nappipaneeli, BorderLayout.NORTH);
    }

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
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aloitahelppo) {
            muistipeli.aloitaPeli(2, 3);
        } else if (e.getSource() == aloitakeskivaikea) {
//            muistipeli.aloitaPeli(5, 4);
        } else if (e.getSource() == aloitavaikea) {
//            muistipeli.aloitaPeli(6, 6);
        } else if (e.getSource() == lopeta) {
            muistipeli.lopetaPeli();
        }
        int yritykset = pelaaja.getYritystenMaara();
        yritystenMaara.setText("" + yritykset);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int ykoordinaatti = e.getY() / 120;
        int xkoordinaatti = e.getX() / 120;
        Kortti kortti = muistipeli.getKortti(ykoordinaatti, xkoordinaatti);
        muistipeli.kaannaKortti(kortti);
        newrect.repaint();
        if(muistipeli.onkoKaksiKorttiaKaannetty()){
            muistipeli.kaannaKaikkiKortit();
            newrect.repaint();
        }
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

    public JFrame getFrame() {
        return peliIkkuna;
    }
}
