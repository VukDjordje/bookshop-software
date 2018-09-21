/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so;

import db.DatabaseBroker;
import domenn.IOpstiDomenskiObjekat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Djordje Vukicevic
 */
public abstract class AbstraktnaSistemskaOperacija {

    protected DatabaseBroker db;

    public AbstraktnaSistemskaOperacija(DatabaseBroker db) {
        this.db = db;
    }

    public void templateExecute(Object object) throws Exception {
        try {
            validate(object);
            execute(object);
            commit();
        } catch (Exception ex) {
            rollback();
            throw new Exception("Greska: " + ex.getMessage());
        }

    }

    protected abstract void validate(Object object) throws Exception;

    protected abstract void execute(Object object) throws Exception;

    private void commit() {
        db.commitTransakcije();
    }

    private void rollback() {
        db.rollbackTransakcije();
    }

}
