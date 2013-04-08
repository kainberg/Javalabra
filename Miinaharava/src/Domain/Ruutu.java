package Domain;

/**
 * Miinaharavaan kuuluva ruutu, joka voi olla joko miina tai tavallinen ruutu.
 *
 * @author kainberg
 */
public interface Ruutu {

    /**
     * Metodi palauttaa tiedon siitä onko kyseessä miina.
     *
     * @return true
     */
    boolean onkoMiina();

    /**
     * Metodi palauttaa tiedon siitä onko ruutu piilossa.
     */
    boolean olenkoPiilossa();

    /**
     * Metodi palauttaa tiedon siitä onko ruudussa lippu.
     */
    boolean onkoLippua();

    /**
     * Metodi paljastaa ruudun jos ruudussa ei ole lippua.
     */
    void paljastaRuutu();

    /**
     * Metodi palauttaa naapurimiinojen lukumäärän. Jos kyseessä on miina metodi
     * palauttaa -1.
     */
    int getNaapuriMiinojenLkm();

    /**
     * Metodi muuttaa lipun statuksen: jos ruudussa on lippu, se otetaan pois,
     * ja jos ei ole lippua, niin laitetaan lippu.
     */
    void muutaLippu();
}
