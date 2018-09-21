/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import transfer.OdgovorObjekat;
import transfer.ZahtevObjekat;

/**
 *
 * @author Djordje Vukicevic
 */
public class KomunikacijaSaServerom {
    private static KomunikacijaSaServerom instanca;
    private Socket socket;

    private KomunikacijaSaServerom() {
        
    }
    
    public boolean poveziSe(String ip,int port){
        boolean povezan = false;
        try {
            socket = new Socket(ip, port);
            povezan = true;
        } catch (IOException ex) {
            povezan = false;
            
        }
        return povezan;
    }

    public static KomunikacijaSaServerom getInstanca() {
        if(instanca == null){
            instanca = new KomunikacijaSaServerom();
        }
        return instanca;
    }
    
    public void posaljiZahtev(ZahtevObjekat zahtev){
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(zahtev);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Greska na serveru!", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public OdgovorObjekat primiOdgovor(){
        OdgovorObjekat odgovor = new OdgovorObjekat();
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            odgovor = (OdgovorObjekat) in.readObject();
        } catch (Exception ex) {
        } 
        return odgovor;
    }
}
