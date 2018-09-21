/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import view.FrmServerskaForma;

/**
 *
 * @author Djordje Vukicevic
 */
public class NitOsvezi extends Thread {

    FrmServerskaForma fsf;

    public NitOsvezi(FrmServerskaForma fsf) {
        this.fsf = fsf;
    }

    @Override
    public void run() {
        while (true) {
            fsf.osveziKlijente();
            System.out.println("Sredio!");
            try {
                sleep(5000);
            } catch (InterruptedException ex) {
                System.out.println("Greska pri osvezavanju!");
            }
        }
    }

}
