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
        if (miinoja > leveys * korkeus || miinoja < 1) {
            this.miinojenLkm = leveys * korkeus - 1; //ei voi laittaa enemmän miinoja kuin ruutuja
        } else if (miinoja <= 0) {
            this.miinojenLkm = 1;
        } else {
            this.miinojenLkm = miinoja;
        }

        this.leveys = leveys;
        this.korkeus = korkeus;
    }

    public void setRuutu(int leveys, int korkeus, int naapuriMiinoja) {
        this.ruudut[leveys][korkeus] = new TavallinenRuutu(naapuriMiinoja);
    }

    public boolean onkoRuudussaMiina(int xKoordinaatti, int yKoordinaatti) {
        boolean palautettava = ruudut[xKoordinaatti][yKoordinaatti].onkoMiina();
        return palautettava;
    }

    public Ruutu getRuutu(int xKoordinaatti, int yKoordinaatti) {
        Ruutu palautettava = ruudut[xKoordinaatti][yKoordinaatti];
        return palautettava;
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

    public int naapuriMiinojenLaskija(int xKoordinaatti, int yKoordinaatti) {
        int palautettava = 0;

        for (int i = xKoordinaatti - 1; i <= xKoordinaatti + 1; i++) {
            for (int j = yKoordinaatti - 1; j <= yKoordinaatti + 1; j++) {
                //tarkistetaan ollaanko matriisissa
                if (i < 0 || j < 0 || i > leveys - 1 || j > korkeus - 1) {
                    //ei tehdä mitään
                } else {
                    if (getRuutu(i, j) != null) {
                        if (ruudut[i][j].onkoMiina() == true) {
                            palautettava++;
                        }
                    }
                }

            }
        }


        return palautettava;
    }

    public void ruutujenAsettaja() {
        //metodi luo tyhjiin pelilaudan paikkoihin tavalliset ruudut, ja asettaa niitten arvoksi naapurimiinojen lkm:n
        int naapurimiinoja;

        for (int i = 0; i < leveys; i++) {
            for (int j = 0; j < korkeus; j++) {
                if (getRuutu(i, j) == null) {
                    naapurimiinoja = naapuriMiinojenLaskija(i, j);
                    setRuutu(i, j, naapurimiinoja);
                }

            }
        }
    }
}
