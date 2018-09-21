/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.model;

import domenn.Autor;
import domenn.Knjiga;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Djordje Vukicevic
 */
public class ModelTabelKnjiga extends AbstractTableModel {

    private List<Knjiga> listaKnjiga;
    private String[] naziviKolona = {"Naziv", "Godina", "Opis", "Autor"};

    public ModelTabelKnjiga(List<Knjiga> listaKnjiga) {
        this.listaKnjiga = listaKnjiga;
    }

    @Override
    public int getRowCount() {
        return listaKnjiga.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Knjiga knjiga = listaKnjiga.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return knjiga.getNaziv();
            case 1:
                return knjiga.getGodina();
            case 2:
                return knjiga.getOpis();
            case 3:
                if(knjiga.getListaAutora() != null){
                    ArrayList<Autor> lista = knjiga.getListaAutora();
                String nalepi = "";
                for (int i = 0; i<lista.size(); i++) {
                    Autor a = lista.get(i);
                    if(i == lista.size()-1){
                        nalepi += a.getPrezime();
                    } else {
                        nalepi += a.getPrezime()+", ";
                    }
                    
                }
                return nalepi;
                }

               return "";
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    public Knjiga vratiKnjigu(int index) {
        return listaKnjiga.get(index);
    }

}
