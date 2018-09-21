/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domenn;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Djordje Vukicevic
 */
public class Radnik implements Serializable, IOpstiDomenskiObjekat {

    private int radnikID;
    private String ime;
    private String prezime;
    private String username;
    private String password;

    public Radnik() {
    }

    public Radnik(int radnikID, String ime, String prezime, String username, String password) {
        this.radnikID = radnikID;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRadnikID() {
        return radnikID;
    }

    public void setRadnikID(int radnikID) {
        this.radnikID = radnikID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String vratiNazivTabele() {
        return "radnik";
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
        ArrayList<IOpstiDomenskiObjekat> radnik = new ArrayList<>();
        Radnik r = null;
        while (rs.next()) {
            int radnikIDl = rs.getInt("radnikID");
            String imel = rs.getString("ime");
            String prezimel = rs.getString("prezime");
            String usernamel = rs.getString("username");
            String passwordl = rs.getString("password");
            r = new Radnik(radnikIDl, imel, prezimel, usernamel, passwordl);
        }
        if(r==null) throw new Exception();
        radnik.add(r);
        return radnik;
    }

    @Override
    public String vratiVrednostiZaUpdate(IOpstiDomenskiObjekat odo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSelect() {
        return "*";
    }

    @Override
    public String vratiSveSelect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiWhere() {
        return "username='"+getUsername()+"' AND password='"+getPassword()+"'";
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
