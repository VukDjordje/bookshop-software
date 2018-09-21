/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so.autor;

import db.DatabaseBroker;
import domenn.Autor;
import domenn.IOpstiDomenskiObjekat;
import java.util.ArrayList;
import logic.so.AbstraktnaSistemskaOperacija;

/**
 *
 * @author Djordje Vukicevic
 */
public class VratiSveAutoreSO extends AbstraktnaSistemskaOperacija{

    private ArrayList<Autor> listaAutora = new ArrayList<>();
    
    public VratiSveAutoreSO(DatabaseBroker db) {
        super(db);
    }

    @Override
    protected void validate(Object object) throws Exception {
    }

    @Override
    protected void execute(Object object) throws Exception {
        Autor a = new Autor();
        String filter = (String) object;
        a.setFilter(filter);
        ArrayList<IOpstiDomenskiObjekat> lista = db.vratiSveSlozen(a);
        for (IOpstiDomenskiObjekat iOpstiDomenskiObjekat : lista) {
            listaAutora.add((Autor) iOpstiDomenskiObjekat);
        }
    }
    
    public ArrayList<Autor> getAutore(){
        return listaAutora;
    }
    
}
