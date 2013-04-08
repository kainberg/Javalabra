package Kayttoliittyma;

/*
 Tähän tulee hieno GUI
 */
/**
 *
 * @author kainberg
 */
import Domain.Pelilauta;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

/**
 * Miinaharava-pelin graafinen käyttöliittymä.
 *
 * @author kainberg
 */
public class GUI extends JFrame {

    private Pelilauta peli;
    private JButton paljastaKaikkiNappula;
    private JTextField sanoma;

    public GUI() {
        peli = new Pelilauta();
        paljastaKaikkiNappula = new JButton("Luovutan");
        sanoma = new JTextField();
        sanoma.setText("Hyvin menee!");

        //alustetaan peli

        peli.asetaMiinat();
        peli.ruutujenAsettaja();



        paljastaKaikkiNappula.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent tapahtuma) {
                //nappia painamalla luovutetaan ja paljastetaan pelilauta
                sanoma.setText("Luovutit");
                
            }
        });

        JPanel paneeli = new JPanel(new GridLayout(1, 2));
        paneeli.add(paljastaKaikkiNappula);
        paneeli.add(sanoma);

        this.setLayout(new BorderLayout());
        add(paneeli);

    }
}
