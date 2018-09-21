/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.model;

import domenn.Autor;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Djordje Vukicevic
 */
public class ModelTabelAutor extends AbstractTableModel {

    private ArrayList<Autor> listaAutora;
    private String[] naziviKolona = {"RB", "Ime", "Prezime", "Zanr"};

    public ModelTabelAutor() {
        listaAutora = new ArrayList<>();
    }

    public ModelTabelAutor(ArrayList<Autor> listaAutora) {
        this.listaAutora = listaAutora;
    }

    @Override
    public int getRowCount() {
        if (listaAutora != null) {
            return listaAutora.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Autor a = listaAutora.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ++rowIndex;
            case 1:
                return a.getIme();
            case 2:
                return a.getPrezime();
            case 3:
                return a.getZanr();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    public Autor vratiAutora(int index) {
        return listaAutora.get(index);
    }

    public void dodajAutora(Autor a) {
        listaAutora.add(a);
        fireTableDataChanged();
    }

    public ArrayList<Autor> vratiListuAutora() {
        return listaAutora;
    }

    public void obrisiAutora(int red) {
        listaAutora.remove(red);
        fireTableDataChanged();
    }

    public void isprazniTabelu() {
        listaAutora.clear();
        fireTableDataChanged();
    }

}
