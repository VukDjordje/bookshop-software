/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domenn;

import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author Djordje Vukicevic
 */
public interface IOpstiDomenskiObjekat {
    public String vratiNazivTabele();
    public String vratiNazivZaInsert();
    public String vratiVrednostiZaInsert();
    ArrayList<IOpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception;
    public String vratiVrednostiZaUpdate(IOpstiDomenskiObjekat odo);
    public String vratiSelect();
    public String vratiSveSelect();
    public String vratiVrednostiWhere();
    public String vratiVrednostiWhereSlozen();
    public String vratiOrderBy();
    public String vratiTabeluSpajanje();
    public String vratiJoinAutori();
    
}
