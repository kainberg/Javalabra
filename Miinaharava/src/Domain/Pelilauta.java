package Domain;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;

/**
 * Miinaharava-pelin logiikkaluokka.
 *
 * @author kainberg
 */
public class Pelilauta {

    public Ruutu[][] ruudut;
    public int miinojenLkm;
    public int leveys;
    public int korkeus;

    /**
     * Konstruktori.
     */
    public Pelilauta() {
        this.ruudut = new Ruutu[9][9];
        this.miinojenLkm = 10;
        this.leveys = 9;
        this.korkeus = 9;
    }

    /**
     * Konstruktori.
     *
     * @param leveys
     * @param korkeus
     * @param miinoja
     */
    public Pelilauta(int leveys, int korkeus, int miinoja) {
        int ruudunLeveys;
        int ruudunKorkeus;

        //tarkistetaan leveys
        if (leveys <= 0) {
            this.leveys = 1;
            ruudunLeveys = 1;
        } else if (leveys > 25) {
            this.leveys = 25;
            ruudunLeveys = 25;
        } else {
            this.leveys = leveys;
            ruudunLeveys = leveys;
        }

        //tarkistetaan korkeus
        if (korkeus <= 0) {
            this.korkeus = 1;
            ruudunKorkeus = 1;
        } else if (korkeus > 25) {
            this.korkeus = 25;
            ruudunKorkeus = 25;
        } else {
            this.korkeus = korkeus;
            ruudunKorkeus = korkeus;
        }


        this.ruudut = new Ruutu[ruudunLeveys][ruudunKorkeus];
        if (miinoja > leveys * korkeus) {
            this.miinojenLkm = leveys * korkeus - 1; //ei voi laittaa enemmän miinoja kuin ruutuja
        } else if (miinoja <= 0) {
            this.miinojenLkm = 1; //pakko laittaa vähintään 1 miina
        } else {
            this.miinojenLkm = miinoja;
        }
    }

    /**
     * Metodi asettaa tavallisen ruudun pelilaudan haluttuun kohtaa.
     *
     * @param leveys
     * @param korkeus
     * @param naapuriMiinoja
     */
    public void setRuutu(int leveys, int korkeus, int naapuriMiinoja) {
        this.ruudut[leveys][korkeus] = new TavallinenRuutu(naapuriMiinoja);
    }

    /**
     * Metodi paljastaa ruudun.
     *
     * @param x
     * @param y
     */
    public void paljastaRuutu(int x, int y) {
        ruudut[x][y].paljastaRuutu();
    }

    /**
     * Metodi muuttaa lipun statuksen. Jos ruudussa on lippu, se lähtee pois, ja
     * jos ruudussa ei ole lippua siihen tulee lippu.
     *
     * @param x
     * @param y
     */
    public void laitaLippu(int x, int y) {
        ruudut[x][y].muutaLippu();
    }

    /**
     * Metodi palauttaa true jos ruudussa on lippu.
     *
     * @param x
     * @param y
     * @return
     */
    public boolean onkoLippua(int x, int y) {
        boolean palautettava = ruudut[x][y].onkoLippua();
        return palautettava;
    }

    /**
     * Metodi palauttaa true jos ruutu on piilossa, eli jos sitä ei ole avattu.
     *
     * @param x
     * @param y
     * @return
     */
    public boolean onkoPiilossa(int x, int y) {
        boolean palautettava = ruudut[x][y].olenkoPiilossa();
        return palautettava;
    }

    /**
     * Metodi palauttaa tiedon siitä onko pelilaudan halutussa kohdassa miina.
     *
     * @param xKoordinaatti
     * @param yKoordinaatti
     * @return
     */
    public boolean onkoRuudussaMiina(int xKoordinaatti, int yKoordinaatti) {
        boolean palautettava = ruudut[xKoordinaatti][yKoordinaatti].onkoMiina();
        return palautettava;
    }

    /**
     * Metodi palauttaa halutun ruudun.
     *
     * @param xKoordinaatti
     * @param yKoordinaatti
     * @return
     */
    public Ruutu getRuutu(int xKoordinaatti, int yKoordinaatti) {
        Ruutu palautettava = ruudut[xKoordinaatti][yKoordinaatti];
        return palautettava;
    }

    /**
     * Metodi asettaa pelilaudan haluttuun kohtaan miinan.
     *
     * @param leveys
     * @param korkeus
     */
    public void setMiina(int leveys, int korkeus) {
        this.ruudut[leveys][korkeus] = new Miina();
    }

    /**
     * Metodi asettaa pelilaudalle konstruktorissa määritellyn lukumäärän
     * miinoja.
     */
    public void asetaMiinat() {
        //metodi asettaa miinojenLkm:n verran miinoja laudalle randomisti
        Random generator = new Random();
        int xRandom = generator.nextInt(leveys);
        int yRandom = generator.nextInt(korkeus);


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

    /**
     * Metodi palauttaa pelilaudalla olevan ruudun naapurimiinojen lukumäärän.
     *
     * @param xKoordinaatti
     * @param yKoordinaatti
     * @return
     */
    public int naapuriMiinojenLaskija(int xKoordinaatti, int yKoordinaatti) {
        int palautettava = 0;

        for (int i = xKoordinaatti - 1; i <= xKoordinaatti + 1; i++) {
            for (int j = yKoordinaatti - 1; j <= yKoordinaatti + 1; j++) {
                //tarkistetaan ollaanko matriisissa
                if (!onkoIndeksitKunnossa(i, j)) {
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

    /**
     * Metodi asettaa pelilaudan tyhjiin ruutuihin tavallisen ruudun, jolla on
     * tieto siitä kuinka monta naapurimiinaa sillä on.
     */
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

    public boolean onkoIndeksitKunnossa(int x, int y) {
        if (x < 0 || y < 0 || x > leveys - 1 || y > korkeus - 1) {
            return false;
        }
        return true;
    }
}
