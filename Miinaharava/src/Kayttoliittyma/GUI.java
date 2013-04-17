package Kayttoliittyma;

/*
 Spagettiluokka, refraktorointi meneillään
 */
/**
 *
 * @author kainberg
 */
import Domain.*;
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
public class GUI extends JFrame implements MouseListener {

    private Pelilauta peli;
    private JButton paljastaKaikkiNappula;
    private JButton uusiPeli;
    private JTextField sanoma;
    private JButton[][] ruudut;
    private boolean eiOsuttuMiinaan;

    public GUI(int leveys, int korkeus, int miinoja) {
        final int leveysFinal = leveys;
        final int korkeusFinal = korkeus;
        final int miinojaFinal = miinoja;
        peli = new Pelilauta(leveysFinal, korkeusFinal, miinojaFinal);
        paljastaKaikkiNappula = new JButton("Tarkista");
        sanoma = new JTextField();
        sanoma.setText("Hyvin menee!");
        eiOsuttuMiinaan = true;
        uusiPeli = new JButton("Uusi peli");

        ruudut = new JButton[peli.leveys][peli.korkeus];


        //luodaan ruudut
        for (int i = 0; i < peli.leveys; i++) {
            for (int j = 0; j < peli.korkeus; j++) {
                ruudut[i][j] = new JButton("");
                ruudut[i][j].setPreferredSize(new Dimension(50, 50));
                ruudut[i][j].addMouseListener(this);
                ruudut[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent tapahtuma) {
                        if (eiOsuttuMiinaan) {
                            if (tapahtuma.getSource() instanceof JButton) {
                                //etsitään koordinaatit
                                int xKoordinaatti = 0;
                                int yKoordinaatti = 0;
                                for (int k = 0; k < peli.leveys; k++) {
                                    for (int l = 0; l < peli.korkeus; l++) {
                                        if (ruudut[k][l] == tapahtuma.getSource()) {
                                            xKoordinaatti = k;
                                            yKoordinaatti = l;
                                        }
                                    }
                                }


                                if (!peli.getRuutu(xKoordinaatti, yKoordinaatti).onkoLippua() && peli.getRuutu(xKoordinaatti, yKoordinaatti).olenkoPiilossa()) {
                                    if (peli.getRuutu(xKoordinaatti, yKoordinaatti).onkoMiina()) {
                                        peli.paljastaRuutu(xKoordinaatti, yKoordinaatti);
                                        ((JButton) tapahtuma.getSource()).setBackground(Color.red);
                                        eiOsuttuMiinaan = false;
                                        sanoma.setText("Hävisit");
                                    } else {
                                        int naapuriMiinoja = peli.getRuutu(xKoordinaatti, yKoordinaatti).getNaapuriMiinojenLkm();
                                        peli.paljastaRuutu(xKoordinaatti, yKoordinaatti);
                                        if (naapuriMiinoja != 0) {
                                            ((JButton) tapahtuma.getSource()).setText("" + naapuriMiinoja);
                                        } else {
                                            ((JButton) tapahtuma.getSource()).setBackground(Color.GRAY);
                                            klikkaaja(xKoordinaatti, yKoordinaatti);

                                        }

                                    }
                                }


                            }
                        }
                    }
                });

            }

        }



        //alustetaan peli

        peli.asetaMiinat();

        peli.ruutujenAsettaja();

        //tarkistusnappula
        paljastaKaikkiNappula.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tapahtuma) {

                        int counter = 0;
                        for (int k = 0; k < peli.leveys; k++) {
                            for (int l = 0; l < peli.korkeus; l++) {
                                if (peli.getRuutu(k, l).olenkoPiilossa()) {
                                    counter++;
                                }
                            }
                        }

                        if (counter == peli.miinojenLkm && eiOsuttuMiinaan) {
                            sanoma.setText("Onneksi olkoon!");
                        } else {
                            eiOsuttuMiinaan = true;
                            for (int k = 0; k < peli.leveys; k++) {
                                for (int l = 0; l < peli.korkeus; l++) {
                                    if (peli.getRuutu(k, l).olenkoPiilossa()) {
                                        ruudut[k][l].doClick();
                                        eiOsuttuMiinaan = true;
                                    }
                                }
                            }

                            sanoma.setText("Lol");


                        }
                    }
                });


        //uusi peli-nappula
        uusiPeli.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent tapahtuma2) {
                //alustetaan uusi peli



                eiOsuttuMiinaan = true;
                peli = new Pelilauta(leveysFinal, korkeusFinal, miinojaFinal);
                peli.asetaMiinat();
                peli.ruutujenAsettaja();
                sanoma.setText("Hyvin menee!");

                //
                for (int k = 0; k < peli.leveys; k++) {
                    for (int l = 0; l < peli.korkeus; l++) {
                        if (peli.getRuutu(k, l).olenkoPiilossa()) {
                            ruudut[k][l].setText("");
                            ruudut[k][l].setBackground(null);
                        }
                    }
                }
            }
        });

        //GUI-säätämistä
        JPanel paneeli = new JPanel(new GridLayout(1, 3));
        paneeli.add(paljastaKaikkiNappula);
        paneeli.add(sanoma);
        paneeli.add(uusiPeli);


        JPanel paneeli2 = new JPanel(new GridLayout(peli.leveys, peli.korkeus));
        for (int i = 0; i < peli.leveys; i++) {
            for (int j = 0; j < peli.korkeus; j++) {

                paneeli2.add(ruudut[i][j]);
            }
        }


        this.setLayout(new BorderLayout());
        add(paneeli, BorderLayout.NORTH);
        add(paneeli2);

    }

    //Ruudun painamisen käsittelijä
    @Override
    public void mousePressed(MouseEvent e) {

        if (eiOsuttuMiinaan) {
            if (e.getSource() instanceof JButton) {
                //etsitään koordinaatit
                int xKoordinaatti = 0;
                int yKoordinaatti = 0;
                for (int k = 0; k < peli.leveys; k++) {
                    for (int l = 0; l < peli.korkeus; l++) {
                        if (ruudut[k][l] == e.getSource()) {
                            xKoordinaatti = k;
                            yKoordinaatti = l;
                        }
                    }
                }


                //Painettiin vasenta nappia
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (!peli.getRuutu(xKoordinaatti, yKoordinaatti).onkoLippua() && peli.getRuutu(xKoordinaatti, yKoordinaatti).olenkoPiilossa()) {
                        if (peli.getRuutu(xKoordinaatti, yKoordinaatti).onkoMiina()) {
                            peli.paljastaRuutu(xKoordinaatti, yKoordinaatti);
                            ((JButton) e.getSource()).setBackground(Color.red);
                            eiOsuttuMiinaan = false;
                            sanoma.setText("Hävisit");
                        } else {
                            int naapuriMiinoja = peli.getRuutu(xKoordinaatti, yKoordinaatti).getNaapuriMiinojenLkm();
                            peli.paljastaRuutu(xKoordinaatti, yKoordinaatti);
                            if (naapuriMiinoja != 0) {
                                ((JButton) e.getSource()).setText("" + naapuriMiinoja);
                            } else {
                                ((JButton) e.getSource()).setBackground(Color.GRAY);
                                klikkaaja(xKoordinaatti, yKoordinaatti);

                            }

                        }
                    }

                } //Painettiin oikeaa nappia
                else if (e.getButton() == MouseEvent.BUTTON3) {
                    if (peli.onkoPiilossa(xKoordinaatti, yKoordinaatti)) {
                        peli.laitaLippu(xKoordinaatti, yKoordinaatti);
                        if (peli.onkoLippua(xKoordinaatti, yKoordinaatti)) {
                            ((JButton) e.getSource()).setBackground(Color.BLACK);
                        } else {
                            ((JButton) e.getSource()).setBackground(null);
                        }
                    }
                }

            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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

    public void klikkaaja(int x, int y) {
        for (int tyjhaApuX = -1; tyjhaApuX <= 1; tyjhaApuX++) {
            for (int tyjhaApuY = -1; tyjhaApuY <= 1; tyjhaApuY++) {
                if (peli.onkoIndeksitKunnossa(x + tyjhaApuX, y + tyjhaApuY) && peli.getRuutu(x + tyjhaApuX, y + tyjhaApuY).olenkoPiilossa()) {
                    if (peli.getRuutu(x, y).getNaapuriMiinojenLkm() == 0) {
                        ruudut[x + tyjhaApuX][y + tyjhaApuY].doClick();
                    }
                }
            }
        }


    }
}
