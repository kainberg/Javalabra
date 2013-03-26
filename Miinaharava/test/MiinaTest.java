/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Domain.Miina;
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
public class MiinaTest {

    Miina miina;

    public MiinaTest() {
    }

    @Before
    public void setUp() {
        miina = new Miina();

    }

    @Test
    public void konstruktoriToimii() {
        Miina miina = new Miina();
        assertNotNull(miina);
    }

    @Test
    public void onkoMiinaPalauttaaTrue() {
        assertEquals(miina.onkoMiina(), true);
    }

    @Test
    public void getNaapuriMiinojenLkmPalauttaaMiinusYksi() {
        assertEquals(miina.getNaapuriMiinojenLkm(), -1);
    }

    @Test
    public void luodullaMiinallaEiLippua() {
        assertEquals(miina.onkoLippua(), false);
    }

    @Test
    public void luotuMiinaPiilossa() {
        assertEquals(miina.olenkoPiilossa(), true);
    }

    @Test
    public void muutaLippuaToimiiJosMuuttaaKerran() {
        miina.muutaLippu();
        assertEquals(miina.onkoLippua(), true);
    }

    @Test
    public void muutaLippuaToimiiJosMuuttaaKaksiKertaa() {
        miina.muutaLippu();
        miina.muutaLippu();
        assertEquals(miina.onkoLippua(), false);
    }

    @Test
    public void eiVoiPaljastaaLiputettuaRuutua() {
        miina.muutaLippu();
        miina.paljastaRuutu();
        assertEquals(miina.olenkoPiilossa(), true);
    }
}
