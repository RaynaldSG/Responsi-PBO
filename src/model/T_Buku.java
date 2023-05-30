/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lab Informatika
 */
public class T_Buku extends  AbstractTableModel{
    List<Data_Buku> dabu;
    
    public T_Buku(List<Data_Buku> dabu){
        this.dabu = dabu;
    }

    @Override
    public int getRowCount() {
        return  dabu.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    public String getColumnName(int columnIndex){
        switch (columnIndex){
            case 0:
                return  "ID";
            case 1:
                return "JUDUL";
            case 2:
                return "GENRE";
            case 3:
                return "PENULIS";
            case 4:
                return "PENERBIT";
            case 5:
                return "LOKASI";
            case 6:
                return "STOCK";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return dabu.get(rowIndex).getId();
            case 1:
                return dabu.get(rowIndex).getJudul();
            case 2:
                return dabu.get(rowIndex).getGenre();
            case 3:
                return dabu.get(rowIndex).getPenulis();
            case 4:
                return dabu.get(rowIndex).getPenerbit();
            case 5:
                return dabu.get(rowIndex).getLokasi();
            case 6:
                return dabu.get(rowIndex).getStock();
            default:
                return null;
        }
    }
    
}
