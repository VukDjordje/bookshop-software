/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so.autor;

import db.DatabaseBroker;
import domenn.Autor;
import domenn.IOpstiDomenskiObjekat;
import logic.so.AbstraktnaSistemskaOperacija;

/**
 *
 * @author Djordje Vukicevic
 */
public class SacuvajAutorSO extends AbstraktnaSistemskaOperacija{

    public SacuvajAutorSO(DatabaseBroker db) {
        super(db);
    }

    @Override
    protected void validate(Object object) throws Exception {
    }

    @Override
    protected void execute(Object object) throws Exception {
        Autor a = (Autor) object;
        db.insertODO(a);
    }
   
}
