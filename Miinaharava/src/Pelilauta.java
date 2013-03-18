/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;

/**
 *
 * @author kainberg
 */
public class Pelilauta {

    public Ruutu[][] ruudut;
    public int miinojenLkm;
    public int leveys;
    public int korkeus;

    public Pelilauta() {
        this.ruudut = new Ruutu[9][9];
        this.miinojenLkm = 10;
        this.leveys = 9;
        this.korkeus = 9;
    }

    public Pelilauta(int leveys, int korkeus, int miinoja) {
        this.ruudut = new Ruutu[leveys][korkeus];
        if (miinoja > leveys * korkeus) {
            this.miinojenLkm = leveys * korkeus - 1; //ei voi laittaa enemmän miinoja kuin ruutuja
        } else {
            this.miinojenLkm = miinoja;
        }

        this.leveys = leveys;
        this.korkeus = korkeus;
    }

    public void setMiina(int leveys, int korkeus) {
        this.ruudut[leveys][korkeus] = new Miina();
    }

    public void asetaMiinat() {
        //metodi asettaa miinojenLkm:n verran miinoja laudalle randomisti
        Random generator = new Random();
        int xRandom = generator.nextInt(leveys);
        int yRandom = generator.nextInt(korkeus);
        boolean olikoVanhaMiina = false;

        for (int i = 0; i < miinojenLkm; i++) {
            if (ruudut[xRandom][yRandom] == null) {
                setMiina(xRandom, yRandom);
            } else {
                i--;
            }
            xRandom = generator.nextInt(leveys);
            yRandom = generator.nextInt(korkeus);
        }

    }

    public void ruutujenAsettaja() {
        //metodi luo tyhjiin pelilaudan paikkoihin tavalliset ruudut, ja asettaa niitten arvoksi naapurimiinojen lkm:n
    }
}
