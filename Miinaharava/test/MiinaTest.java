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
    }

    @Test
    public void onkoMiinaPalauttaaTrue() {
        assertEquals(miina.onkoMiina(), true);
    }
}
