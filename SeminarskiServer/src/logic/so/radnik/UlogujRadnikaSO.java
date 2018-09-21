/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so.radnik;

import db.DatabaseBroker;
import domenn.Radnik;
import logic.so.AbstraktnaSistemskaOperacija;

/**
 *
 * @author Djordje Vukicevic
 */
public class UlogujRadnikaSO extends AbstraktnaSistemskaOperacija{

    private Radnik radnik;
    
    public UlogujRadnikaSO(DatabaseBroker db) {
        super(db);
    }

    @Override
    protected void validate(Object object) throws Exception {
    }

    @Override
    protected void execute(Object object) throws Exception {
        Radnik r = (Radnik) object;
        radnik = (Radnik) db.vratiJednogODO(r);
        
    }
    
    public Radnik getRadnik(){
        return radnik;
    }
}
