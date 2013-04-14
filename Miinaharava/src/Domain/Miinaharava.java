package Domain;

import Domain.Pelilauta;
import Kayttoliittyma.GUI;
import javax.swing.JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

/**
 * Miinaharava-pelin main.
 *
 * @author kainberg
 */
public class Miinaharava {

    public static void main(String[] args) {
        int n = JOptionPane.showConfirmDialog(
                null,
                "Pikapeli?",
                "Tervetuloa Miinaharavaan",
                JOptionPane.YES_NO_OPTION);

        if (n == 0) {
            kaynnistaja(9, 9, 10);
        } else {
            String leveys;
            String korkeus;
            String miinoja;

            int leveysInt;
            int korkeusInt;
            int miinojaInt;

            leveys = JOptionPane.showInputDialog("Anna haluttu leveys:");
            try {
                leveysInt = Integer.parseInt(leveys);
            } catch (NumberFormatException e) {
                leveysInt = 9;
            }

            korkeus = JOptionPane.showInputDialog("Anna haluttu korkeus:");
            try {
                korkeusInt = Integer.parseInt(korkeus);
            } catch (NumberFormatException e) {
                korkeusInt = 9;
            }

            miinoja = JOptionPane.showInputDialog("Anna haluttu miinojen lukumäärä:");
            try {
                miinojaInt = Integer.parseInt(miinoja);
            } catch (NumberFormatException e) {
                miinojaInt = 10;
            }


            kaynnistaja(leveysInt, korkeusInt, miinojaInt);
        }
    }

    public static void kaynnistaja(int l, int k, int m) {
        GUI peli = new GUI(k, l, m);
        peli.setTitle("Miinaharava");
        peli.pack();
        peli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // osaa loppua
        peli.setVisible(true);
    }
}



/*
 * GUI peli = new GUI(5, 5, 5);
        peli.setTitle("Miinaharava");
        peli.pack();
        peli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // osaa loppua
        peli.setVisible(true); // olio näkyviin
 * 
 */