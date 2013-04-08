package Domain;

import Domain.Pelilauta;
import Kayttoliittyma.GUI;
import javax.swing.JFrame;

/**
 * Miinaharava-pelin main.
 *
 * @author kainberg
 */
public class Miinaharava {

    public static void main(String[] args) {
        GUI peli = new GUI();
        peli.setTitle("Miinaharava");
        peli.pack();
        peli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // osaa loppua
        peli.setVisible(true); // olio näkyviin


    }
}
