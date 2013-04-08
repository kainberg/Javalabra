package Domain;

/**
 * Miinaharavaan kuuluva miinaton ruutu, joka toteuttaa rajapinnan Ruutu.
 */
public class TavallinenRuutu implements Ruutu {

    public int naapuriMiinojenLkm;
    public boolean onkoPiilossa;
    public boolean onkoLippua;

    public TavallinenRuutu(int naapuriMiinojenLkm) {
        this.naapuriMiinojenLkm = naapuriMiinojenLkm;
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
     * Metodi palauttaa naapurimiinojen lukumäärän.
     */
    @Override
    public int getNaapuriMiinojenLkm() {
        return naapuriMiinojenLkm;
    }

    /**
     * Metodi palauttaa tiedon siitä, että kyseessä ei ole miina.
     *
     * @return false
     */
    @Override
    public boolean onkoMiina() {
        return false;
    }

    @Override
    public String toString() {
        return "" + getNaapuriMiinojenLkm();
    }
}
