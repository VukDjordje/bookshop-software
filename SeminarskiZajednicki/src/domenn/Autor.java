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
public class Autor implements Serializable, IOpstiDomenskiObjekat {

    private int autorID;
    private String zanr;
    private String ime;
    private String prezime;
    private Radnik radnik;

    private String filter;

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }
    
    public Autor() {
    }

    public Autor(int autorID, String zanr, String ime, String prezime, Radnik radnik) {
        this.autorID = autorID;
        this.zanr = zanr;
        this.ime = ime;
        this.prezime = prezime;
        this.radnik = radnik;
    }

    public int getAutorID() {
        return autorID;
    }

    public void setAutorID(int autorID) {
        this.autorID = autorID;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
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

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            if (((Autor) obj).getAutorID() == this.getAutorID()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String vratiNazivTabele() {
        return "autor";
    }

    @Override
    public String vratiNazivZaInsert() {
        return "zanr,ime,prezime,radnikID";
    }
    
    @Override
    public String vratiVrednostiZaInsert() {
        return "'" + zanr + "','" + ime + "','" + prezime + "'," + radnik.getRadnikID();
    }

    @Override
    public ArrayList<IOpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        ArrayList<IOpstiDomenskiObjekat> listaAutora = new ArrayList<>();
        while (rs.next()) {
            int radnikID = rs.getInt("radnikID");
            String ime = rs.getString("r.ime");
            String prezime = rs.getString("r.prezime");
            String usrename = rs.getString("username");
            String password = rs.getString("password");
            Radnik radnik = new Radnik(radnikID, ime, prezime, usrename, password);

            int autorID = rs.getInt("autorID");
            String jmbg = rs.getString("zanr");
            String imeAutora = rs.getString("ime");
            String prezimeAutora = rs.getString("prezime");
            Autor autor = new Autor(autorID, jmbg, imeAutora, prezimeAutora, radnik);
            listaAutora.add(autor);
        }
        return listaAutora;
    }

    @Override
    public String vratiVrednostiZaUpdate(IOpstiDomenskiObjekat odo) {
        Autor ar = (Autor) odo;
        return "zanr='"+ar.getZanr()+"',"+"ime='"+ar.getIme()+"',"+"prezime='"+ar.getPrezime()+"',"+"radnikID='"+ar.getRadnik().getRadnikID()+"'";
    }

    @Override
    public String vratiSelect() {
        return "a.*,r.*";
    }

    @Override
    public String vratiVrednostiWhere() {
        return "autorID="+getAutorID();
    }

    @Override
    public String vratiOrderBy() {
        return "a.prezime";
    }

    @Override
    public String vratiSveSelect() {
        return "*";
    }

    @Override
    public String vratiTabeluSpajanje() {
        return "Autor a INNER JOIN Radnik r ON (a.radnikID=r.radnikID)";
    }

    @Override
    public String vratiVrednostiWhereSlozen() {
        if(getFilter().isEmpty()){
            return "";
        }
        return ""+getFilter()+"";
    }

    @Override
    public String vratiJoinAutori() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
