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

    /**
     * Metodi käynnistää kellon.
     */
    public void start() {
        this.startTime = System.currentTimeMillis();
        this.running = true;
    }

    /**
     * Metodi pysäyttää kellon
     */
    public void stop() {
        this.stopTime = System.currentTimeMillis();
        this.running = false;
    }

    /**
     * Metodi nollaa kellon.
     */
    public void nollaus() {
        startTime = 0;
        stopTime = 0;
        running = false;
    }

    /**
     * Metodi palauttaa vanhan highscoren.
     *
     * @return
     */
    public String getHighScore() throws IOException {
        String palautettava = "";
        try {
            FileInputStream fstream = new FileInputStream("score.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                palautettava = palautettava + strLine;
            }
            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return palautettava;
    }

    /**
     * Metodi päivittää highscoren jos vanha highscore voitetaan.
     *
     * @throws IOException
     */
    public void updateHighScore() throws IOException {
        //tarkistetaan jos uusi on parempi
        long ehdokas = this.getKulunutAika();
        long vanha = Long.parseLong(getHighScore());
        int onkoPienempi = Long.compare(ehdokas, vanha);
        if (onkoPienempi > 0) {
            //metodi muuttaa highscoren
            FileWriter fstream = new FileWriter("score.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(Long.toString(ehdokas));
            //Close the output stream
            out.close();
        }
    }

    /**
     * Metodi palauttaa kuluneen ajan.
     *
     * @return
     */
    public long getKulunutAika() {
        long time;
        time = (stopTime - startTime);
        return time;
    }
}
