/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import niti.NitKlijent;

/**
 *
 * @author Djordje Vukicevic
 */
public class ModelTabeleKlijenti extends AbstractTableModel{

    ArrayList<NitKlijent> listaKlijenata;
    String[] naziviKolona = {"RB","Klijent","Vreme"};
    DateTimeFormatter dtf;

    public ModelTabeleKlijenti(ArrayList<NitKlijent> listaKlijenata) {
        this.listaKlijenata = listaKlijenata;
        dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    }

    @Override
    public int getRowCount() {
        return listaKlijenata.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NitKlijent nk = listaKlijenata.get(rowIndex);
        switch(columnIndex){
            case 0: return nk.getRb();
            case 1: return "Klijent "+nk.getRb()+" ("+nk.getSocket().getInetAddress().getHostName()+")";
            case 2: return nk.getVreme().format(dtf);
            default: return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    public void setListaKlijenata(ArrayList<NitKlijent> listaKlijenata) {
        this.listaKlijenata = listaKlijenata;
        fireTableDataChanged();
    }
    
    public void srediRB(){
        int brojac = 0;
        for (NitKlijent nk : listaKlijenata) {
            brojac++;
            nk.setRb(brojac);
        }
        fireTableDataChanged();
    }
}
