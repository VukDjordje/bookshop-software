/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domenn;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Djordje Vukicevic
 */
public class Racun implements Serializable,IOpstiDomenskiObjekat{

    private int sifraRacuna;
    private double ukupanIznos;
    private Radnik radnik;
    private List<StavkaRacuna> listaStavki;

    public Racun() {
        listaStavki = new LinkedList<>();
    }

    public Racun(int sifraRacuna, double ukupanIznos, Radnik radnik) {
        this.sifraRacuna = sifraRacuna;
        this.ukupanIznos = ukupanIznos;
        this.radnik = radnik;
        this.listaStavki = new LinkedList<>();
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public int getSifraRacuna() {
        return sifraRacuna;
    }

    public void setSifraRacuna(int sifraRacuna) {
        this.sifraRacuna = sifraRacuna;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public List<StavkaRacuna> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<StavkaRacuna> listaStavki) {
        this.listaStavki = listaStavki;
    }

    public void dodajStavku() {
        listaStavki.add(new StavkaRacuna());
    }

    public void obrisiStavku(int red) {
        listaStavki.remove(red);
    }

    public void pripremiRacun() {
        double ukupanIznos = 0;
        int rb = 0;
        for (StavkaRacuna stavkaRacuna : listaStavki) {
            ukupanIznos += stavkaRacuna.getIznos();
            rb++;
            stavkaRacuna.setRb(rb);
        }
        setUkupanIznos(ukupanIznos);
    }

    @Override
    public String vratiNazivTabele() {
        return "racun";
    }

    @Override
    public String vratiNazivZaInsert() {
        return "racunID,ukupanIznos,radnikID";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'"+sifraRacuna+"',"+ukupanIznos+","+radnik.getRadnikID();
    }

    @Override
    public ArrayList<IOpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiZaUpdate(IOpstiDomenskiObjekat odo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSelect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSveSelect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiWhere() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiWhereSlozen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiOrderBy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiTabeluSpajanje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiJoinAutori() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
