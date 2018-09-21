/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Djordje Vukicevic
 */
public class NitZaustavi extends Thread{
    
    ServerSocket ss;
    NitPokreni nitPokreni;
    ArrayList<NitKlijent> listaKlijenata;
    boolean kraj = false;

    public NitZaustavi(ServerSocket ss, NitPokreni nitPokreni, ArrayList<NitKlijent> listaKlijenata) {
        this.ss = ss;
        this.nitPokreni = nitPokreni;
        this.listaKlijenata = listaKlijenata;
    }

    @Override
    public void run() {
        while(!kraj){
            if(nitPokreni.isInterrupted()){
                for (NitKlijent nk : listaKlijenata) {
                    nk.interrupt();
                    nk.prekini();
                }
                if(!ss.isClosed()){
                    try {
                        ss.close();
                    } catch (IOException ex) {
                        Logger.getLogger(NitZaustavi.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                kraj = true;
            }
        }
    }
 
}
