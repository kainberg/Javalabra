/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
public class TavallinenRuutuTest {

    TavallinenRuutu tyhja;
    TavallinenRuutu kaksi;

    public TavallinenRuutuTest() {
    }

    @Before
    public void setUp() {
        tyhja = new TavallinenRuutu(0);
        kaksi = new TavallinenRuutu(2);

    }

    @Test
    public void konstruktoriToimii() {
        TavallinenRuutu ruutu = new TavallinenRuutu(2);
        assertNotNull(ruutu);
    }

    @Test
    public void onkoMiinaPalauttaaFalse() {
        assertEquals(kaksi.onkoMiina(), false);
    }

    @Test
    public void getNaapurimiinojenLkmToimii() {
        assertEquals(kaksi.getNaapuriMiinojenLkm(), 2);
        assertEquals(tyhja.getNaapuriMiinojenLkm(), 0);
    }

    @Test
    public void luodullaTavallisellaRuudullaEiLippua() {
        assertEquals(kaksi.onkoLippua(), false);
    }

    @Test
    public void luotuTavallinenRuutuPiilossa() {
        assertEquals(kaksi.olenkoPiilossa(), true);
    }

    @Test
    public void muutaLippuaToimiiJosMuuttaaKerran() {
        kaksi.muutaLippu();
        assertEquals(kaksi.onkoLippua(), true);
    }

    @Test
    public void muutaLippuaToimiiJosMuuttaaKaksiKertaa() {
        kaksi.muutaLippu();
        kaksi.muutaLippu();
        assertEquals(kaksi.onkoLippua(), false);
    }

    @Test
    public void eiVoiPaljastaaLiputettuaRuutua() {
        kaksi.muutaLippu();
        kaksi.paljastaRuutu();
        assertEquals(kaksi.olenkoPiilossa(), true);
    }
}
