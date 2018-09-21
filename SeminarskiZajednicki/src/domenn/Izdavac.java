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
public class Izdavac implements Serializable, IOpstiDomenskiObjekat {

    private int izdavacID;
    private String naziv;
    private String maticniBroj;

    public Izdavac() {
    }

    public Izdavac(int izdavacID, String naziv, String maticniBroj) {
        this.izdavacID = izdavacID;
        this.naziv = naziv;
        this.maticniBroj = maticniBroj;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public int getIzdavacID() {
        return izdavacID;
    }

    public void setIzdavacID(int izdavacID) {
        this.izdavacID = izdavacID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "izdavac";
    }

    @Override
    public String vratiNazivZaInsert() {
        return null;
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return null;
    }

    @Override
    public ArrayList<IOpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        ArrayList<IOpstiDomenskiObjekat> izdavaci = new ArrayList<>();
        try {
            while (rs.next()) {
                int izdavacID1 = rs.getInt("izdavacID");
                String naziv1 = rs.getString("naziv");
                String maticniBroj1 = rs.getString("maticniBroj");
                Izdavac izdavac = new Izdavac(izdavacID1, naziv1, maticniBroj1);
                izdavaci.add(izdavac);
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return izdavaci;
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
