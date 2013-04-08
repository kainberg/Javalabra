package Domain;

import Domain.Ruutu;

/**
 * Miinaharavaan kuuluva miina, joka toteuttaa rajapinnan Ruutu.
 */
public class Miina implements Ruutu {

    public boolean olenMiina;
    public boolean onkoPiilossa;
    public boolean onkoLippua;

    public Miina() {
        this.olenMiina = true;
        this.onkoPiilossa = true;
        this.onkoLippua = false;
    }

    /**
     * Metodi palauttaa tiedon siitä onko ruutu piilossa.
     */
    @Override
    public boolean olenkoPiilossa() {
        return onkoPiilossa;
    }

    /**
     * Metodi palauttaa tiedon siitä onko ruudussa lippu.
     */
    @Override
    public boolean onkoLippua() {
        return onkoLippua;
    }

    /**
     * Metodi muuttaa lipun statuksen: jos ruudussa on lippu, se otetaan pois,
     * ja jos ei ole lippua, niin laitetaan lippu.
     */
    @Override
    public void muutaLippu() {
        if (olenkoPiilossa()) {
            if (onkoLippua == false) {
                onkoLippua = true;
            } else {
                onkoLippua = false;
            }
        }
    }

    /**
     * Metodi paljastaa ruudun jos ruudussa ei ole lippua.
     */
    @Override
    public void paljastaRuutu() {
        if (onkoLippua == false) {
            this.onkoPiilossa = false;
        }
    }

    /**
     * Metodi palauttaa -1.
     */
    @Override
    public int getNaapuriMiinojenLkm() {
        return -1;
    }

    /**
     * Metodi palauttaa tiedon siitä, että kyseessä on miina.
     *
     * @return true
     */
    @Override
    public boolean onkoMiina() {
        return olenMiina;
    }

    @Override
    public String toString() {
        return "M";
    }
}
