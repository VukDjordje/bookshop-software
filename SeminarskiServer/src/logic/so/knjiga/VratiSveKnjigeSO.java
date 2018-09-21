/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so.knjiga;

import db.DatabaseBroker;
import domenn.Autor;
import domenn.IOpstiDomenskiObjekat;
import domenn.Knjiga;
import domenn.Napisana;
import java.util.ArrayList;
import logic.so.AbstraktnaSistemskaOperacija;

/**
 *
 * @author Djordje Vukicevic
 */
public class VratiSveKnjigeSO extends AbstraktnaSistemskaOperacija {

    private ArrayList<Knjiga> listaKnjiga = new ArrayList<>();

    public VratiSveKnjigeSO(DatabaseBroker db) {
        super(db);
    }

    @Override
    protected void validate(Object object) throws Exception {
    }

    @Override
    protected void execute(Object object) throws Exception {
        Knjiga k = new Knjiga();
        String filter = (String) object;
        k.setFilter(filter);
        ArrayList<IOpstiDomenskiObjekat> lista = new ArrayList<>();
        if (filter.contains("a.prezime")) {
            System.out.println("Usao sam");
            lista = db.vratiKnjigePoAutoru(k);
        } else {
            lista = db.vratiSveSlozen(k);

        }
        for (IOpstiDomenskiObjekat odo : lista) {
            Knjiga kk = (Knjiga) odo;
            Napisana n = new Napisana();
            n.setKnjiga(kk);
            ArrayList<IOpstiDomenskiObjekat> lis = db.vratiSveSlozen(n);
            ArrayList<Autor> listaAutora = new ArrayList<>();
            for (IOpstiDomenskiObjekat li : lis) {
                listaAutora.add((Autor) li);
            }
            kk.setListaAutora(listaAutora);
            listaKnjiga.add(kk);
        }
    }

    public ArrayList<Knjiga> getListaKnjiga() {
        return listaKnjiga;
    }
}
