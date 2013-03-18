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
    }

    @Test
    public void konstruktoritToimiiOikeallaSyotteella() {
        Pelilauta helppo2 = new Pelilauta();
        Pelilauta custom2 = new Pelilauta(5, 5, 5);
    }

    @Test
    public void setMiinaToimiiOikeallaSyotteella() {
        helppo.setMiina(1, 1);
    }

    @Test
    public void asetaMiinatToimii() {
        helppo.asetaMiinat();
    }

    @Test
    public void ruutujenAsettajaToimii() {
        helppo.ruutujenAsettaja();
    }
}
