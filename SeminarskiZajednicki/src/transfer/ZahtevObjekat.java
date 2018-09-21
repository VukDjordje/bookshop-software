/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;
import java.net.Socket;

/**
 *
 * @author Djordje Vukicevic
 */
public class ZahtevObjekat implements Serializable{
    private int operacija;
    private Object parametar;

    public ZahtevObjekat() {
    }

    public ZahtevObjekat(int operacija, Object parametar) {
        this.operacija = operacija;
        this.parametar = parametar;
    }

    public ZahtevObjekat(Socket socketK) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getParametar() {
        return parametar;
    }

    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }
    
}
