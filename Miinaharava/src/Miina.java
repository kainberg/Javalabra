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
    
    public Miina(){
    this.olenMiina=true;
    }
    
    

    @Override
    public boolean onkoMiina() {
        return olenMiina;
    }
}
