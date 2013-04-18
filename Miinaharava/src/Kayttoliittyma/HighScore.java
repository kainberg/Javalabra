package Kayttoliittyma;

import java.io.*;

/**
 * Luokka joka pitää kirjaa highscoresta.
 *
 * @author kainberg
 */
public class HighScore {

    public long startTime = 0;
    public long stopTime = 0;
    public boolean running = false;
    public long bestTime;
    
    public void start() {
        this.startTime = System.currentTimeMillis();
        this.running = true;
    }

    public void stop() {
        this.stopTime = System.currentTimeMillis();
        this.running = false;
    }

    public void nollaus() {
        startTime = 0;
        stopTime = 0;
        running = false;
    }

    public long getHighScore() {
        //metodi palauttaa highscoren
        return bestTime;
    }

    public void updateHighScore(int uusiHighScore) {
        //metodi muuttaa highscoren
        
    }

    //kulunut aika millisekunneissa
    public long getKulunutAika() {
        long time;
        if (running) {
            time = (System.currentTimeMillis() - startTime);
        } else {
            time = (stopTime - startTime);
        }
        return time;
    }
}
