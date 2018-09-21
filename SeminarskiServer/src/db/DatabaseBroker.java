/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domenn.Autor;
import domenn.IOpstiDomenskiObjekat;
import domenn.Izdavac;
import domenn.Knjiga;
import domenn.Racun;
import domenn.Radnik;
import domenn.StavkaRacuna;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Util;

/**
 *
 * @author Djordje Vukicevic
 */
public class DatabaseBroker {

    private Connection connection;
    private Util util = new Util();

    public void ucitajDriver() {
        try {
            Class.forName(util.getValue("driver"));
            //System.out.println("Uspesno ucitan driver!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void otvoriKonekciju(){
        String url = util.getValue("url");
        String user = util.getValue("user");
        String password = util.getValue("password");

        try {
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
            //System.out.println("Uspesno otvorena konekcija!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void zatvoriKonekciju(){
        try {
            connection.close();
        } catch (Exception ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void commitTransakcije() {
        try {
            connection.commit();
        } catch (Exception ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rollbackTransakcije(){
        try {
            connection.rollback();
        } catch (Exception ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertODO(IOpstiDomenskiObjekat odo) throws Exception {
        String upit = "INSERT INTO " + odo.vratiNazivTabele() + "(" + odo.vratiNazivZaInsert() + ")" + " VALUES(" + odo.vratiVrednostiZaInsert() + ")";
        System.out.println(upit);
        try {
            Statement s = connection.createStatement();
            s.executeUpdate(upit);
            s.close();
        } catch (SQLException ex) {
            throw new Exception("Greska prilikom insertaODO!\n" + ex);
        }
    }
    
    public void insertKljucODO(IOpstiDomenskiObjekat odo, int kljuc) throws Exception{
        String upit = "INSERT INTO "+odo.vratiNazivTabele()+"("+odo.vratiNazivZaInsert()+")"+" VALUES("+odo.vratiVrednostiZaInsert()+","+kljuc+")";
        System.out.println(upit);
        try {
            Statement s = connection.createStatement();
            s.executeUpdate(upit);
            s.close();
        } catch (SQLException ex) {
            throw new Exception("Greska prilikom insertKljucODO!\n" + ex);
        }
    }
    
    public void updateODO(IOpstiDomenskiObjekat odo) throws Exception {
        String upit = "UPDATE "+odo.vratiNazivTabele()+" SET "+odo.vratiVrednostiZaUpdate(odo)+" WHERE "
                +odo.vratiVrednostiWhere();
        System.out.println(upit);
        try {
            Statement s = connection.createStatement();
            s.executeUpdate(upit);
            s.close();
        } catch (Exception ex) {
            throw new Exception("Greska prilikom updateODO!\n" + ex);
        }
    }
    
    public void deleteODO(IOpstiDomenskiObjekat odo) throws SQLException, Exception {
        String upit = "DELETE FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiVrednostiWhere();
        System.out.println(upit);
        try {
            Statement s = connection.createStatement();
            s.executeUpdate(upit);
            s.close();
        } catch (Exception ex) {
            throw new Exception("Greska prilikom deleteODO!\n" + ex);
        }

    }
    
    public ArrayList<IOpstiDomenskiObjekat> vratiSveCisto(IOpstiDomenskiObjekat odo) throws Exception{
        ArrayList<IOpstiDomenskiObjekat> lista = new ArrayList<>();
        String upit = "SELECT * FROM "+odo.vratiNazivTabele();
        System.out.println(upit);
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(upit);
            lista = odo.vratiListu(rs);
            rs.close();
            s.close();
        } catch (SQLException ex) {
            throw new Exception("Greska prilikom vratiSveCisto! \n"+ex);
        }
        return lista;
    }
    
    public IOpstiDomenskiObjekat vratiJednogODO(IOpstiDomenskiObjekat odo) throws Exception{
        IOpstiDomenskiObjekat odobj;
        String upit = "SELECT * FROM "+odo.vratiNazivTabele()+" WHERE "+odo.vratiVrednostiWhere();
        System.out.println(upit);
        try {
            Statement s = connection.createStatement();
            ResultSet rs =s.executeQuery(upit);
            odobj = odo.vratiListu(rs).get(0);
            rs.close();
            s.close();
        } catch (SQLException ex) {
            throw new Exception("Greska prilikom vraiJednogODO! \n"+ex);
        }
        return odobj;
    }
    
    public ArrayList<IOpstiDomenskiObjekat> vratiSveSlozen(IOpstiDomenskiObjekat odo) throws Exception {
        ArrayList<IOpstiDomenskiObjekat> lista = new ArrayList<>();
        String upit = "SELECT " + odo.vratiSelect() + " FROM " + odo.vratiTabeluSpajanje()
                + " " + odo.vratiVrednostiWhereSlozen();
        System.out.println(upit);
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(upit);
            lista = odo.vratiListu(rs);
            rs.close();
            s.close();
        } catch (Exception ex) {
            throw new Exception("Greska prilikom vratiSlozen!\n" + ex);
        }
        return lista;
    }

    public int vratiIDKnjige() throws Exception {
        int maxID = -1;
        String upit = "SELECT MAX(knjigaID) AS max FROM knjiga";
        try {
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(upit);
            while (rs.next()) {
                maxID = rs.getInt("max");
            }
            sqlStatement.close();
            rs.close();
        } catch (SQLException ex) {
            throw new Exception("Greska prilikom vracanja id knjige!\n" + ex);
        }
        return maxID;
    }

    public void insertUNapisana(int knjigaID, int autorID) throws Exception {
        String upit = "INSERT INTO napisana(knjigaID,autorID) VALUES(?,?)";
        try {
            PreparedStatement sqlStatement = connection.prepareStatement(upit);
            sqlStatement.setInt(1, knjigaID);
            sqlStatement.setInt(2, autorID);
            sqlStatement.executeUpdate();
            sqlStatement.close();
        } catch (Exception ex) {
            throw new Exception("Greska prilikom cuvanja napisana!\n" + ex);
        }
    }
    
    public ArrayList<IOpstiDomenskiObjekat> vratiKnjigePoAutoru(IOpstiDomenskiObjekat odo) throws Exception{
        ArrayList<IOpstiDomenskiObjekat> lista = new ArrayList<>();
        String upit = "SELECT * FROM "+odo.vratiJoinAutori()+" "+odo.vratiVrednostiWhereSlozen();
        System.out.println(upit);
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(upit);
            lista = odo.vratiListu(rs);
            rs.close();
            s.close();
        } catch (Exception ex) {
            throw new Exception("Greska prilikom vratiSlozen!\n" + ex);
        }
        return lista;
    }
}
