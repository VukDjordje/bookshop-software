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
public class Knjiga implements Serializable, IOpstiDomenskiObjekat {

    private int knjigaID;
    private String naziv;
    private int godina;
    private String opis;
    private Izdavac izdavac;
    private Radnik radnik;
    private ArrayList<Autor> listaAutora;
    private double cena;

    public Knjiga() {
        listaAutora = new ArrayList<>();
    }

    public Knjiga(int knjigaID, String naziv, int godina, String opis, Izdavac izdavac, Radnik radnik, ArrayList<Autor> listaAutora, double cena) {
        this.knjigaID = knjigaID;
        this.naziv = naziv;
        this.godina = godina;
        this.opis = opis;
        this.izdavac = izdavac;
        this.radnik = radnik;
        this.listaAutora = listaAutora;
        this.cena = cena;
    }

    private String filter;

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }
    
    
    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public int getKnjigaID() {
        return knjigaID;
    }

    public void setKnjigaID(int knjigaID) {
        this.knjigaID = knjigaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Izdavac getIzdavac() {
        return izdavac;
    }

    public void setIzdavac(Izdavac izdavac) {
        this.izdavac = izdavac;
    }

    public ArrayList<Autor> getListaAutora() {
        return listaAutora;
    }

    public void setListaAutora(ArrayList<Autor> listaAutora) {
        this.listaAutora = listaAutora;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Knjiga) {
            Knjiga k = (Knjiga) obj;
            return k.getKnjigaID() == this.knjigaID;
        }
        return false;
    }

    @Override
    public String vratiNazivTabele() {
        return "knjiga";
    }

    @Override
    public String vratiNazivZaInsert() {
        return "naziv,godina,opis,izdavacID,radnikID,cena";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'" + naziv + "'," + godina + ",'" + opis + "'," + izdavac.getIzdavacID() + "," + radnik.getRadnikID() + "," + cena;
    }

    @Override
    public ArrayList<IOpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        ArrayList<IOpstiDomenskiObjekat> knjige = new ArrayList<>();
        while (rs.next()) {
            int radnikID = rs.getInt("radnikID");
            String ime = rs.getString("r.ime");
            String prezime = rs.getString("r.prezime");
            String usrename = rs.getString("username");
            String password = rs.getString("password");
            Radnik radnik1 = new Radnik(radnikID, ime, prezime, usrename, password);

            int izdavacID = rs.getInt("izdavacID");
            String nazivIzdavaca = rs.getString("i.naziv");
            String maticniBroj = rs.getString("maticniBroj");
            Izdavac izdavac1 = new Izdavac(izdavacID, nazivIzdavaca, maticniBroj);

            int knjigaID1 = rs.getInt("knjigaID");
            String nazivKnjige1 = rs.getString("k.naziv");
            int godina1 = rs.getInt("godina");
            String opis1 = rs.getString("opis");
            double cena1 = rs.getDouble("cena");
            Knjiga knjiga = new Knjiga(knjigaID1, nazivKnjige1, godina1, opis1, izdavac1, radnik1, new ArrayList<Autor>(), cena1);
            knjige.add(knjiga);
        }
        return knjige;
    }

    @Override
    public String vratiVrednostiZaUpdate(IOpstiDomenskiObjekat odo) {
        return null;
    }

    @Override
    public String vratiSelect() {
        return "k.*,r.*,i.*";
    }

    @Override
    public String vratiSveSelect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiWhere() {
        return "knjigaID="+getKnjigaID();
    }

    @Override
    public String vratiVrednostiWhereSlozen() {
        if(getFilter().isEmpty()){
            return "";
        }
        return ""+getFilter()+"";
    }

    @Override
    public String vratiOrderBy() {
        return "k.naziv";
    }

    @Override
    public String vratiTabeluSpajanje() {
        return "knjiga k INNER JOIN radnik r ON (k.radnikID = r.radnikID) INNER JOIN izdavac i ON (k.izdavacID = i.izdavacID)";
    }

    @Override
    public String vratiJoinAutori() {
        return "knjiga k JOIN napisana n ON k.knjigaID = n.knjigaID JOIN autor a ON a.autorID = n.autorID JOIN izdavac i ON k.izdavacID = i.izdavacID JOIN radnik r ON k.radnikID = r.radnikID";
    }

    //SELECT * FROM knjiga k JOIN napisana n ON k.knjigaID = n.knjigaID 
    //JOIN autor a ON a.autorID = n.autorID JOIN izdavac i ON k.izdavacID = i.izdavacID 
    //JOIN radnik r ON k.radnikID = r.radnikID WHERE a.prezime LIKE 'D' ORDER BY a.prezime ASC
}
