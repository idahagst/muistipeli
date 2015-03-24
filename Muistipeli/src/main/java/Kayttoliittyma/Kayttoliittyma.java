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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Ida
 */
public class Kayttoliittyma implements Runnable {

    private Peli muistipeli;
    private Pelaaja pelaaja;
    private JFrame frame;

    public Kayttoliittyma() {

    }

    @Override
    public void run() {
        teeIkkuna();
        luoAloitajaLopetaNappi(frame.getContentPane());
    }

    public void teeIkkuna() {
        frame = new JFrame("Muistipeli");
        frame.setPreferredSize(new Dimension(800, 500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
    }

//    private void luoAloitajaLopetaNappi(Container container) {
//        frame.setLayout(new GridLayout(1, 3));
//        JButton aloita = new JButton("Aloita");
//        container.add(aloita);
//        JButton lopeta = new JButton("Lopeta");
//        container.add(lopeta);
//        JTextField yritystenMaara = new JTextField("0");
//        container.add(yritystenMaara);
//        yritystenMaara.setEnabled(false);
//        
////JLabel tasonvalinta = new JLabel("Valitse taso:");
////        JRadioButton helppo = new JRadioButton("Helppo");
////        JRadioButton keskivaikea = new JRadioButton("Keskivaikea");
////        JRadioButton vaikea = new JRadioButton("Vaikea");
////        ButtonGroup buttongroup = new ButtonGroup();
////        buttongroup.add(helppo);
////        buttongroup.add(keskivaikea);
////        buttongroup.add(vaikea);
////        container.add(helppo);
////        container.add(keskivaikea);
////        container.add(vaikea);
//        
//        Tapahtumankuuntelija kuuntelija = new Tapahtumankuuntelija(aloita, lopeta, yritystenMaara);
//        aloita.addActionListener(kuuntelija);
//        lopeta.addActionListener(kuuntelija);
//
//    }
    private void luoAloitajaLopetaNappi(Container container) {
        frame.setLayout(new GridLayout(1, 5));
        JButton aloitahelppo = new JButton("Helppo");
        container.add(aloitahelppo);
        JButton aloitakeskivaikea = new JButton("Keskivaikea");
        container.add(aloitakeskivaikea);
        JButton aloitavaikea = new JButton("Vaikea");
        container.add(aloitavaikea);
        JButton lopeta = new JButton("Lopeta");
        container.add(lopeta);
        JTextField yritystenMaara = new JTextField("0");
        container.add(yritystenMaara);
        yritystenMaara.setEnabled(false);

        Tapahtumankuuntelija kuuntelija = new Tapahtumankuuntelija(aloitahelppo, aloitakeskivaikea, aloitavaikea, lopeta, yritystenMaara);
        aloitahelppo.addActionListener(kuuntelija);
        aloitakeskivaikea.addActionListener(kuuntelija);
        aloitavaikea.addActionListener(kuuntelija);
        lopeta.addActionListener(kuuntelija);
    }

    public void luoKortit() {
        //lisää taulukko, jossa kortit on tänne
        
    }

    public JFrame getFrame() {
        return frame;
    }

}
