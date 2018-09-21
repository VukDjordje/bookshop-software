/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so.knjiga;

import db.DatabaseBroker;
import domenn.Autor;
import domenn.Knjiga;
import domenn.Napisana;
import logic.so.AbstraktnaSistemskaOperacija;

/**
 *
 * @author Djordje Vukicevic
 */
public class SacuvajKnjiguSO extends AbstraktnaSistemskaOperacija{

    public SacuvajKnjiguSO(DatabaseBroker db) {
        super(db);
    }

    @Override
    protected void validate(Object object) throws Exception {
    }

    @Override
    protected void execute(Object object) throws Exception {
        Napisana n = (Napisana) object;
        Knjiga k = n.getKnjiga();
        db.insertODO(k);
        int knjigaID = db.vratiIDKnjige();
        for (Autor a : k.getListaAutora()) {
            db.insertUNapisana(knjigaID,a.getAutorID());
        }
    }
    
}
