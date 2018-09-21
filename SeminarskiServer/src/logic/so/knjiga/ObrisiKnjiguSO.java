/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so.knjiga;

import db.DatabaseBroker;
import domenn.Knjiga;
import domenn.Napisana;
import logic.so.AbstraktnaSistemskaOperacija;

/**
 *
 * @author Djordje Vukicevic
 */
public class ObrisiKnjiguSO extends AbstraktnaSistemskaOperacija{

    public ObrisiKnjiguSO(DatabaseBroker db) {
        super(db);
    }

    @Override
    protected void validate(Object object) throws Exception {
    }

    @Override
    protected void execute(Object object) throws Exception {
        Napisana n =  (Napisana) object;
        Knjiga k = n.getKnjiga();
        System.out.println("execute");
        db.deleteODO(n);
        db.deleteODO(k);
        System.out.println("execute posle");
    }
    
}
