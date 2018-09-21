/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so.izdavac;

import db.DatabaseBroker;
import domenn.IOpstiDomenskiObjekat;
import domenn.Izdavac;
import java.util.ArrayList;
import logic.so.AbstraktnaSistemskaOperacija;

/**
 *
 * @author Djordje Vukicevic
 */
public class VratiIzdavaceSO extends AbstraktnaSistemskaOperacija{

    ArrayList<Izdavac> listaIzdavaci;
    
    public VratiIzdavaceSO(DatabaseBroker db) {
        super(db);
        listaIzdavaci = new ArrayList<>();
    }

    @Override
    protected void validate(Object object) throws Exception {
    }

    @Override
    protected void execute(Object object) throws Exception {
        ArrayList<IOpstiDomenskiObjekat> lista = db.vratiSveCisto(new Izdavac());
        for (IOpstiDomenskiObjekat odo : lista) {
            listaIzdavaci.add((Izdavac) odo);
        }
    }

    public ArrayList<Izdavac> getListaIzdavaci() {
        return listaIzdavaci;
    }
    
    
}
