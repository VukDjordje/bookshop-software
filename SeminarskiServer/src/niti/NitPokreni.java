/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import logic.Kontroler;
import util.Util;
import view.FrmServerskaForma;


/**
 *
 * @author Djordje Vukicevic
 */
public class NitPokreni extends Thread{
    
    FrmServerskaForma sf;
    ServerSocket ss;
    private Util util = new Util();

    public NitPokreni(FrmServerskaForma sf) {
        this.sf = sf;
    }

    @Override
    public void run() {
        try {
            String sPort = util.getValue("port");
            int port = Integer.parseInt(sPort);
            ss = new ServerSocket(port);
            sf.serverJePokrenut();
            System.out.println("SERVER JE POKRENUT! CEKAM KLIJENTE...");
            NitZaustavi nitZaustavi = new NitZaustavi(ss, this, Kontroler.getInstance().getListaKlijenata());
            nitZaustavi.start();
            System.out.println("NIT ZAUSTAVI SPREMNA!");
            while(!isInterrupted()){
                Socket socketK = ss.accept();
                System.out.println("KLIJENT SE POVEZAO!");
                NitKlijent nitKlijent = new NitKlijent(Kontroler.getInstance().getListaKlijenata().size()+1,socketK,LocalTime.now());
                nitKlijent.start();
                Kontroler.getInstance().getListaKlijenata().add(nitKlijent);
            }
        } catch (IOException ex) {
            System.out.println("ZAUSTAVLJEN SERVER");
            sf.serverJeZaustavljen();
        }
    }
    
    
}
