/*
 Testit eivät vielä tee mitään hirveän järkevää
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kainberg
 */
public class PelilautaTest {

    Pelilauta helppo;
    Pelilauta custom;

    public PelilautaTest() {
    }

    @Before
    public void setUp() {
        helppo = new Pelilauta();
        custom = new Pelilauta(12, 12, 25);
    }

    @Test
    public void konstruktoritToimiiOikeallaSyotteella() {
        Pelilauta helppo2 = new Pelilauta();
        Pelilauta custom2 = new Pelilauta(5, 5, 5);
        assertNotNull(helppo2);
        assertNotNull(custom2);
    }

    @Test
    public void konstruktoriToimiiLiianIsollaSyotteella() {
        Pelilauta custom2 = new Pelilauta(5, 5, 50000);
        assertNotNull(custom2);
    }

    @Test
    public void konstruktoriToimiiLiianPienellaSyotteella() {
        Pelilauta custom2 = new Pelilauta(5, 5, -50000);
        assertNotNull(custom2);
    }

    @Test
    public void setMiinaToimiiOikeallaSyotteella() {
        helppo.setMiina(1, 1);
        assertEquals(helppo.getRuutu(1, 1).onkoMiina(), true);
    }

    @Test
    public void asetaMiinatAsettaaOikeanMaaranMiinojaHelpossaPelissa() {
        helppo.asetaMiinat();
        int miinoja = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (helppo.getRuutu(i, j) != null) {
                    if (helppo.onkoRuudussaMiina(i, j) == true) {
                        miinoja++;
                    }
                }
            }
        }

        assertEquals(10, miinoja);
    }

    @Test
    public void asetaMiinatAsettaaOikeanMaaranMiinojaCustomPelissa() {
        custom.asetaMiinat();
        int miinoja = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (custom.getRuutu(i, j) != null) {
                    if (custom.onkoRuudussaMiina(i, j) == true) {
                        miinoja++;
                    }
                }
            }
        }

        assertEquals(25, miinoja);
    }

    @Test
    public void naapuriMiinojenLaskijaToimiiNurkassaYhdellaMiinalla() {
        helppo.setMiina(0, 0);
        int lukumaara = helppo.naapuriMiinojenLaskija(1, 1);
        assertEquals(1, lukumaara);
    }

    @Test
    public void naapuriMiinojenLaskijaToimiiNurkassaUseallaMiinalla() {
        helppo.setMiina(0, 1);
        helppo.setMiina(1, 1);
        helppo.setMiina(1, 0);

        int lukumaara = helppo.naapuriMiinojenLaskija(0, 0);
        assertEquals(3, lukumaara);
    }

    @Test
    public void naapuriMiinojenLaskijaToimiiReunallaYhdellaMiinalla() {
        helppo.setMiina(0, 3);
        int lukumaara = helppo.naapuriMiinojenLaskija(0, 2);
        assertEquals(1, lukumaara);
    }

    @Test
    public void naapuriMiinojenLaskijaToimiiReunallaUseallaMiinalla() {
        helppo.setMiina(0, 3);
        helppo.setMiina(1, 2);
        helppo.setMiina(0, 1);

        int lukumaara = helppo.naapuriMiinojenLaskija(0, 2);
        assertEquals(3, lukumaara);
    }

    @Test
    public void naapuriMiinojenLaskijaToimiiKeskellaYhdellaMiinalla() {
        helppo.setMiina(3, 3);
        int lukumaara = helppo.naapuriMiinojenLaskija(4, 4);
        assertEquals(1, lukumaara);
    }

    @Test
    public void naapuriMiinojenLaskijaToimiiKeskellaUseallaMiinalla() {
        helppo.setMiina(3, 4);
        helppo.setMiina(4, 3);
        helppo.setMiina(2, 2);
        helppo.setMiina(4, 4);

        int lukumaara = helppo.naapuriMiinojenLaskija(3, 3);
        assertEquals(4, lukumaara);
    }

    @Test
    public void ruutujenAsettajaToimiiNurkassa() {
        helppo.setMiina(0, 0);
        helppo.ruutujenAsettaja();
        assertEquals(1, helppo.getRuutu(1, 1).getNaapuriMiinojenLkm());
    }

    @Test
    public void ruutujenAsettajaToimiiReunalla() {
        helppo.setMiina(0, 3);
        helppo.ruutujenAsettaja();
        assertEquals(1, helppo.getRuutu(1, 3).getNaapuriMiinojenLkm());
    }

    @Test
    public void ruutujenAsettajaToimiiKeskella() {
        helppo.setMiina(3, 3);
        helppo.ruutujenAsettaja();
        assertEquals(1, helppo.getRuutu(2, 2).getNaapuriMiinojenLkm());
    }
}
