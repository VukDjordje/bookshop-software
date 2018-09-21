/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domenn.Autor;
import domenn.Izdavac;
import domenn.Knjiga;
import domenn.Napisana;
import domenn.Racun;
import domenn.Radnik;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.IOperacije;
import konstante.IStatus;
import logic.Kontroler;
import transfer.OdgovorObjekat;
import transfer.ZahtevObjekat;

/**
 *
 * @author Djordje Vukicevic
 */
public class NitKlijent extends Thread {

    int rb;
    Socket socket;
    LocalTime vreme;

    public NitKlijent(int rb, Socket socket, LocalTime vreme) {
        this.rb = rb;
        this.socket = socket;
        this.vreme = vreme;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            ZahtevObjekat zahtev = primiZahtev();
            OdgovorObjekat odgovor = new OdgovorObjekat();

            switch (zahtev.getOperacija()) {
                case IOperacije.NADJI_RADNIKA:
                    try {
                        Radnik r = (Radnik) zahtev.getParametar();
                        Radnik rad = Kontroler.getInstance().loginRadnika(r);
                        odgovor.setOdgovor(rad);
                        odgovor.setStatus(IStatus.OK);
                    } catch (Exception ex) {
                        odgovor.setStatus(IStatus.ERROR);
                        odgovor.setPoruka(ex.getMessage());
                    }
                    break;
                case IOperacije.IZBRISI_AUTORE:
                    try {
                        Autor a = (Autor) zahtev.getParametar();
                        Kontroler.getInstance().obrisiAutora(a);
                        odgovor.setStatus(IStatus.OK);
                    } catch (Exception ex) {
                        odgovor.setStatus(IStatus.ERROR);
                        odgovor.setPoruka(ex.getMessage());
                    }
                    break;
                case IOperacije.VRATI_AUTORE:
                    try {
                        String filter = (String) zahtev.getParametar();
                        ArrayList<Autor> listaAutora = Kontroler.getInstance().vratiAutore(filter);
                        odgovor.setOdgovor(listaAutora);
                        odgovor.setStatus(IStatus.OK);
                    } catch (Exception ex) {
                        odgovor.setStatus(IStatus.ERROR);
                        odgovor.setPoruka(ex.getMessage());
                    }
                    break;
                case IOperacije.UBACI_AUTORE:
                    try {
                        Autor aUbaci = (Autor) zahtev.getParametar();
                        Kontroler.getInstance().zapamtiAutora(aUbaci);
                        odgovor.setStatus(IStatus.OK);
                    } catch (Exception ex) {
                        odgovor.setStatus(IStatus.ERROR);
                        odgovor.setPoruka(ex.getMessage());
                    }
                    break;
                case IOperacije.UPDATE_AUTORA:
                    try {
                        Autor aUpdate = (Autor) zahtev.getParametar();
                        Kontroler.getInstance().izmeniAutoraSiO(aUpdate);
                        odgovor.setStatus(IStatus.OK);
                    } catch (Exception ex) {
                        odgovor.setStatus(IStatus.ERROR);
                        odgovor.setPoruka(ex.getMessage());
                    }
                    break;
                case IOperacije.VRATI_IZDAVACE:
                    try {
                        ArrayList<Izdavac> listaIzdavaca = Kontroler.getInstance().vratiIzdavace();
                        odgovor.setOdgovor(listaIzdavaca);
                        odgovor.setStatus(IStatus.OK);
                    } catch (Exception ex) {
                        odgovor.setStatus(IStatus.ERROR);
                        odgovor.setPoruka(ex.getMessage());
                    }
                    break;
                case IOperacije.VRATI_KNJIGE:
                    try {
                        String filterKnjige = (String) zahtev.getParametar();
                        ArrayList<Knjiga> listaKnjiga = Kontroler.getInstance().vratiKnjige(filterKnjige);
                        odgovor.setOdgovor(listaKnjiga);
                    } catch (Exception ex) {
                        odgovor.setStatus(IStatus.ERROR);
                        odgovor.setPoruka(ex.getMessage());
                    }
                    break;
                case IOperacije.IZBRISI_KNJIGU:
                    try {
                        Napisana napisana = (Napisana) zahtev.getParametar();
                        Kontroler.getInstance().obrisiTrazenuKnjiguu(napisana);
                        odgovor.setStatus(IStatus.OK);
                    } catch (Exception ex) {
                        odgovor.setStatus(IStatus.ERROR);
                        odgovor.setPoruka(ex.getMessage());
                    }
                    break;
                case IOperacije.UBACI_KNJIGU:
                    try {
                        Napisana napisana = (Napisana) zahtev.getParametar();
                        Kontroler.getInstance().zapamtiKnjige(napisana);
                        odgovor.setStatus(IStatus.OK);
                    } catch (Exception ex) {
                        odgovor.setStatus(IStatus.ERROR);
                        odgovor.setPoruka(ex.getMessage());
                    }
                    break;
                case IOperacije.UBACI_RACUN:
                    try {
                        Racun racun = (Racun) zahtev.getParametar();
                        Kontroler.getInstance().zapamtiRacun(racun);
                        odgovor.setStatus(IStatus.OK);
                    } catch (Exception ex) {
                        odgovor.setStatus(IStatus.ERROR);
                        odgovor.setPoruka(ex.getMessage());
                    }
                    break;
            }
            posaljiOdgovor(odgovor);
        }
    }

    private ZahtevObjekat primiZahtev() {
        ZahtevObjekat zahtev = new ZahtevObjekat();
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            zahtev = (ZahtevObjekat) in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            this.interrupt();
            Kontroler.getInstance().obrisiKlijenta(this);
        }

        return zahtev;
    }

    private void posaljiOdgovor(OdgovorObjekat odgovor) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(odgovor);
        } catch (IOException ex) {
            this.interrupt();
            Kontroler.getInstance().obrisiKlijenta(this);
        }
    }

    private void posaljiOdgovorSvima(OdgovorObjekat odgovor, Socket s) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeObject(odgovor);
        } catch (IOException ex) {
            this.interrupt();
            Kontroler.getInstance().obrisiKlijenta(this);
        }
    }

    public void prekini() {
        if (!socket.isClosed()) {
            try {
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(NitKlijent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public LocalTime getVreme() {
        return vreme;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

}
