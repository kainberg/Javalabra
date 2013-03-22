/*
 Koko tämä toteutus abstraktina luokkana? Aika paljon yhteisiä metodeja ja copy-pastea
 */

/**
 *
 * @author kainberg
 */
public interface Ruutu {

    boolean onkoMiina();

    boolean olenkoPiilossa();
    
    boolean onkoLippua();
    
    void paljastaRuutu();

    int getNaapuriMiinojenLkm();
    //voi olla että hölmö ratkaisu
    
    void muutaLippu();
    //metodi laittaa lipun jos ruutu piilossa ja siinä ei ole lippua
}
