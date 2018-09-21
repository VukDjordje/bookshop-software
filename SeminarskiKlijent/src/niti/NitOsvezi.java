/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.util.logging.Level;
import java.util.logging.Logger;
import view.autor.FrmBrisanjeAutora;

/**
 *
 * @author Djordje Vukicevic
 */
public class NitOsvezi extends Thread{
    
    FrmBrisanjeAutora frmBrisanje;

    public NitOsvezi(FrmBrisanjeAutora frmBrisanje) {
        this.frmBrisanje = frmBrisanje;
    }

    @Override
    public void run() {
        while(!isInterrupted()){
            frmBrisanje.pripremiFormu();
            System.out.println("Sredio");
            try {
                sleep(5000);
            } catch (InterruptedException ex) {
                System.out.println("Greska pri osvezavanju!");
            }
        }
    }
    
    
}
