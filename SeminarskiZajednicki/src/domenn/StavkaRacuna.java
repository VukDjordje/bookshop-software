/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domenn;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Djordje Vukicevic
 */
public class StavkaRacuna implements Serializable,IOpstiDomenskiObjekat{
    int rb;
    int kolicina;
    double iznos;
    Knjiga knjiga;

    public StavkaRacuna() {
    }

    public StavkaRacuna(int rb, int kolicina, double iznos, Knjiga knjiga) {
        this.rb = rb;
        this.kolicina = kolicina;
        this.iznos = iznos;
        this.knjiga = knjiga;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    @Override
    public String vratiNazivTabele() {
        return "stavkaracuna";
    }

    @Override
    public String vratiNazivZaInsert() {
        return "rb,kolicina,iznos,knjigaID,racunID";
    }

    //return "'"+name+"','"+address+"','"+vat+"','"+identNumber+"',"+getCity().getCode();
    @Override
    public String vratiVrednostiZaInsert() {
        return rb+","+kolicina+","+iznos+","+knjiga.getKnjigaID();
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
