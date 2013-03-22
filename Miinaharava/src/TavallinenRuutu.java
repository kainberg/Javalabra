/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kainberg
 */
public class TavallinenRuutu implements Ruutu {

    public int naapuriMiinojenLkm;
    public boolean onkoPiilossa;
    public boolean onkoLippua;

    public TavallinenRuutu(int naapuriMiinojenLkm) {
        this.naapuriMiinojenLkm = naapuriMiinojenLkm;
        this.onkoPiilossa = true;
        this.onkoLippua = false;
    }

    @Override
    public boolean olenkoPiilossa() {
        return onkoPiilossa;
    }
    
    @Override
    public boolean onkoLippua() {
        return onkoLippua;
    }
    

    @Override
    public void muutaLippu() {
        if (olenkoPiilossa()) {
            if (onkoLippua == false) {
                onkoLippua = true;
            } else{
                onkoLippua = false;
            }
        }
    }

    @Override
    public void paljastaRuutu() {
        if (onkoLippua == false) {
            this.onkoPiilossa = false;
        }
    }

    @Override
    public int getNaapuriMiinojenLkm() {
        return naapuriMiinojenLkm;
    }

    @Override
    public boolean onkoMiina() {
        return false;
    }

    @Override
    public String toString() {
        return "" + getNaapuriMiinojenLkm();
    }
}
