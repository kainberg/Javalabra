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

    public TavallinenRuutu(int naapuriMiinojenLkm) {
        this.naapuriMiinojenLkm = naapuriMiinojenLkm;
    }
    
    public int getNaapuriMiinojenLkm(){
        return naapuriMiinojenLkm;
    }

    @Override
    public boolean onkoMiina() {
        return false;
    }
}
