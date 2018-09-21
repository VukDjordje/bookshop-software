/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import db.DatabaseBroker;
import domenn.Autor;
import domenn.Izdavac;
import domenn.Knjiga;
import domenn.Napisana;
import domenn.Racun;
import domenn.Radnik;
import domenn.StavkaRacuna;
import java.util.ArrayList;
import logic.so.autor.SacuvajAutorSO;
import logic.so.autor.IzbrisiAutoraSO;
import logic.so.autor.IzmeniAutoraSO;
import logic.so.autor.VratiSveAutoreSO;
import logic.so.izdavac.VratiIzdavaceSO;
import logic.so.knjiga.ObrisiKnjiguSO;
import logic.so.knjiga.SacuvajKnjiguSO;
import logic.so.knjiga.VratiSveKnjigeSO;
import logic.so.racun.SacuvajRacunSO;
import logic.so.radnik.UlogujRadnikaSO;
import niti.NitKlijent;

/**
 *
 * @author Djordje Vukicevic
 */
public class Kontroler {

    public static Kontroler instance;
    private DatabaseBroker dbbr;
    private ArrayList<NitKlijent> listaKlijenata;

    private Kontroler() {
        dbbr = new DatabaseBroker();
        try {
            dbbr.ucitajDriver();
            listaKlijenata = new ArrayList<>();
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public ArrayList<NitKlijent> getListaKlijenata() {
        return listaKlijenata;
    }

    public void dodajKlijenta(NitKlijent nk) {
        listaKlijenata.add(nk);
    }

    public void obrisiKlijenta(NitKlijent nk) {
        listaKlijenata.remove(nk);
    }
  
    public Radnik loginRadnika(Radnik r) throws Exception{
        dbbr.otvoriKonekciju();
        UlogujRadnikaSO so = new UlogujRadnikaSO(dbbr);
        try {
            so.templateExecute(r);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        dbbr.zatvoriKonekciju();
        return so.getRadnik();
    }
    
    public ArrayList<Izdavac> vratiIzdavace() throws Exception{
        dbbr.otvoriKonekciju();
        VratiIzdavaceSO so = new VratiIzdavaceSO(dbbr);
        try {
            so.templateExecute(dbbr);
        } catch (Exception ex) {
            throw new Exception("Greska prilikom vracanja izdavaca! \n"+ex);
        }
        dbbr.zatvoriKonekciju();
        return so.getListaIzdavaci();
    }
    
    public void zapamtiAutora(Autor a) throws Exception{
        dbbr.otvoriKonekciju();
        SacuvajAutorSO so = new SacuvajAutorSO(dbbr);
        try {
            so.templateExecute(a);
        } catch (Exception ex) {
            throw new Exception("Greska prilikom cuvanja autora! \n"+ex.getMessage());
        }
        dbbr.zatvoriKonekciju();   
    }
    
    public ArrayList<Autor> vratiAutore(String filter) throws Exception{
        dbbr.otvoriKonekciju();
        VratiSveAutoreSO autoriSO = new VratiSveAutoreSO(dbbr);
        try {
            autoriSO.templateExecute(filter);
        } catch (Exception ex) {
            throw new Exception("Greska prilikom ucitavanja autora!\n"+ex);
        }
        dbbr.zatvoriKonekciju();
        return autoriSO.getAutore();
    }
    
    public void obrisiAutora(Autor a) throws Exception{
        dbbr.otvoriKonekciju();
        IzbrisiAutoraSO so = new IzbrisiAutoraSO(dbbr);
        try {
            so.templateExecute(a);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        dbbr.zatvoriKonekciju();
    }
    
    public void izmeniAutoraSiO(Autor a) throws Exception{
        dbbr.otvoriKonekciju();
        IzmeniAutoraSO so = new IzmeniAutoraSO(dbbr);
        try {
            so.templateExecute(a);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        dbbr.zatvoriKonekciju();
    }
    
    public void zapamtiRacun(Racun r) throws Exception{
        dbbr.otvoriKonekciju();
        SacuvajRacunSO so = new SacuvajRacunSO(dbbr);
        try {
            so.templateExecute(r);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        dbbr.zatvoriKonekciju();
    }
    
    public ArrayList<Knjiga> vratiKnjige(String filter) throws Exception{
        dbbr.otvoriKonekciju();
        VratiSveKnjigeSO so = new VratiSveKnjigeSO(dbbr);
        try {
            so.templateExecute(filter);
        } catch (Exception ex) {
            throw new Exception("Greska prilikom ucitavanja knjige!\n"+ex);
        }
        dbbr.zatvoriKonekciju();
        return so.getListaKnjiga();
    }

    public void zapamtiKnjige(Napisana n) throws Exception{
        dbbr.otvoriKonekciju();
        SacuvajKnjiguSO so = new SacuvajKnjiguSO(dbbr);
        try {
            so.templateExecute(n);
        } catch (Exception ex) {
            throw new Exception("Greska prilikom cuvanja knjige! \n"+ex.getMessage());
        }
        dbbr.zatvoriKonekciju();
    }
    
    public void obrisiTrazenuKnjiguu(Napisana n) throws Exception{
        dbbr.otvoriKonekciju();
        ObrisiKnjiguSO so = new ObrisiKnjiguSO(dbbr);
        try {
            so.templateExecute(n);
        } catch (Exception ex) {
            throw new Exception("Greska prilikom brisanja knjige! \n"+ex);
        }
        dbbr.zatvoriKonekciju();
    }
}
