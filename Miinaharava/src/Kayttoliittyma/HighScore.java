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


    public void updateHighScore() throws IOException {
        //metodi muuttaa highscoren
        FileWriter fstream = new FileWriter("score.txt");
        BufferedWriter out = new BufferedWriter(fstream);
        long ehdokas=this.getKulunutAika();
        out.write(Long.toString(ehdokas) );
        //Close the output stream
        out.close();

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
