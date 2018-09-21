/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so.autor;

import db.DatabaseBroker;
import domenn.Autor;
import logic.so.AbstraktnaSistemskaOperacija;

/**
 *
 * @author Djordje Vukicevic
 */
public class IzbrisiAutoraSO extends AbstraktnaSistemskaOperacija{

    public IzbrisiAutoraSO(DatabaseBroker db) {
        super(db);
    }

    @Override
    protected void validate(Object object) throws Exception {
    }

    @Override
    protected void execute(Object object) throws Exception {
        Autor a = (Autor) object;
        System.out.println("execute");
        db.deleteODO(a);
        System.out.println("execute posle");
    }
    
}
