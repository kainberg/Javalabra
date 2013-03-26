package Domain;


import Domain.Ruutu;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kainberg
 */
public class Miina implements Ruutu {

    public boolean olenMiina;
    public boolean onkoPiilossa;
    public boolean onkoLippua;

    public Miina() {
        this.olenMiina = true;
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
            } else {
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
        return -1;
    }

    @Override
    public boolean onkoMiina() {
        return olenMiina;
    }

    @Override
    public String toString() {
        return "M";
    }
}
