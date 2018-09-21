/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;

/**
 *
 * @author Djordje Vukicevic
 */
public class NitSat extends Thread{
    JLabel jlableSat;
    DateTimeFormatter dtf;

    public NitSat(JLabel jlableSat) {
        this.jlableSat = jlableSat;
        dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    }

    @Override
    public void run() {
        while(!isInterrupted()){
            LocalTime vreme = LocalTime.now();
            jlableSat.setText("Trenutno vreme: "+vreme.format(dtf));
        }
    }
    
    
}
