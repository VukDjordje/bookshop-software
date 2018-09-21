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
public class Napisana implements Serializable,IOpstiDomenskiObjekat{
    private Knjiga knjiga;
    private Autor autor;

    public Napisana() {
       
    }

    public Napisana(Knjiga knjiga, Autor autor) {
        this.knjiga = knjiga;
        this.autor = autor;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    @Override
    public String vratiNazivTabele() {
        return "napisana";
    }

    @Override
    public String vratiNazivZaInsert() {
        return "knjigaID,autorID";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return knjiga.getKnjigaID()+","+autor.getAutorID();
    }

    //SELECT * FROM knjiga k JOIN napisana n ON k.knjigaID = n.knjigaID 
    //JOIN autor a ON a.autorID = n.autorID JOIN radnik r ON a.radnikID = r.radnikID WHERE k.knjigaID = 9
    @Override
    public ArrayList<IOpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        ArrayList<IOpstiDomenskiObjekat> listaN = new ArrayList<>();
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
            listaN.add(autor);
        }
        return listaN;
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
        return "knjigaID="+getKnjiga().getKnjigaID();
    }

    @Override
    public String vratiVrednostiWhereSlozen() {
        return "WHERE k.knjigaID="+getKnjiga().getKnjigaID();
    }

    @Override
    public String vratiOrderBy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiTabeluSpajanje() {
        return "knjiga k JOIN napisana n ON k.knjigaID = n.knjigaID JOIN autor a ON a.autorID = n.autorID JOIN radnik r ON a.radnikID = r.radnikID";
    }

    @Override
    public String vratiJoinAutori() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
