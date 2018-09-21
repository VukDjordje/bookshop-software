/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.model;

import domenn.Knjiga;
import domenn.Racun;
import domenn.StavkaRacuna;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Djordje Vukicevic
 */
public class ModelTabelRacun extends AbstractTableModel {

    private Racun racun;
    private String[] naziviKolona = {"Knjiga", "Jedinicna cena", "Kolicina", "Iznos"};

    public ModelTabelRacun(Racun racun) {
        this.racun = racun;
    }

    @Override
    public int getRowCount() {
        return racun.getListaStavki().size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaRacuna sr = racun.getListaStavki().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sr.getKnjiga();
            case 1:
                if (sr.getKnjiga() != null) {
                    return sr.getKnjiga().getCena();
                } else {
                    return 0;
                }
            case 2:
                return sr.getKolicina();
            case 3:
                return sr.getIznos();
            default:
                return "n/a";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        StavkaRacuna sr = racun.getListaStavki().get(rowIndex);
        switch(columnIndex){
            case 0:
                sr.setKnjiga((Knjiga) aValue);
                sr.setIznos(sr.getKnjiga().getCena()*sr.getKolicina());
                fireTableCellUpdated(rowIndex, 1);
                fireTableCellUpdated(rowIndex, 3);
                break;
            case 1:
                break;
            case 2:
                sr.setKolicina(Integer.parseInt(aValue.toString()));
                if(sr.getKnjiga() != null){
                    sr.setIznos(sr.getKnjiga().getCena()*sr.getKolicina());
                    fireTableCellUpdated(rowIndex, 3);
                }
                break;
            case 3: break;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex == 1 || columnIndex == 3){
            return false;
        } else{
            return true;
        }
    }

    public void dodajStavku(){
        racun.dodajStavku();
        fireTableDataChanged();
    }
    
    public void ukloniStavku(int red){
        racun.obrisiStavku(red);
        fireTableDataChanged();
    }
    
    public void clear(){
        racun.getListaStavki().clear();
        fireTableDataChanged();
    }
}
