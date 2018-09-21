/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so.racun;

import db.DatabaseBroker;
import domenn.Racun;
import domenn.StavkaRacuna;
import logic.so.AbstraktnaSistemskaOperacija;

/**
 *
 * @author Djordje Vukicevic
 */
public class SacuvajRacunSO extends AbstraktnaSistemskaOperacija{

    public SacuvajRacunSO(DatabaseBroker db) {
        super(db);
    }

    @Override
    protected void validate(Object object) throws Exception {
    }

    @Override
    protected void execute(Object object) throws Exception {
        Racun r = (Racun) object;
        db.insertODO(r);
        int racunID = r.getSifraRacuna();
        for (StavkaRacuna sr : r.getListaStavki()) {
            db.insertKljucODO(sr, racunID);
        }   
    }
    
}
