package  controller;

import DAO.DAO_Buku;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.ComboBoxUI;
import model.Data_Buku;
import model.T_Buku;
import pkg092_responsi.E_Handle;
import view.UI_Perpus;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lab Informatika
 */
public class C_Perpus {
    DAO_Buku Dbuku;
    List<Data_Buku> dabu;
    Data_Buku dab;
    UI_Perpus ui;
    
    public C_Perpus(UI_Perpus ui){
        this.ui = ui;
        Dbuku = new DAO_Buku();
        this.dabu = Dbuku.getAll();
    }
    
    public void showTable(){
        this.dabu = Dbuku.getAll();
        T_Buku tBuku = new T_Buku(dabu);
        ui.getT_data().setModel(tBuku);
    }
    
    public void showSearchTable(){
        T_Buku tBuku = new T_Buku(dabu);
        ui.getT_data().setModel(tBuku);
        if(dabu.isEmpty()){
           E_Handle.e_ckosong();
        }
    }
    
    public Data_Buku getField(){
        dab = new Data_Buku();
        
        dab.setId(Integer.parseInt(ui.getI_id().getText()));
        dab.setJudul(ui.getI_judul().getText());
        dab.setGenre(ui.getI_genre().getText());
        dab.setPenulis(ui.getI_penulis().getText());
        dab.setPenerbit(ui.getI_penerbit().getText());
        dab.setLokasi(ui.getI_lokasi().getText());
        dab.setStock(Integer.parseInt(ui.getI_stock().getText()));
        
        return  dab;
    }
    
    public Data_Buku getFieldInsert(){
        dab = new Data_Buku();
        
        dab.setJudul(ui.getI_judul().getText());
        dab.setGenre(ui.getI_genre().getText());
        dab.setPenulis(ui.getI_penulis().getText());
        dab.setPenerbit(ui.getI_penerbit().getText());
        dab.setLokasi(ui.getI_lokasi().getText());
        dab.setStock(Integer.parseInt(ui.getI_stock().getText()));
        
        return  dab;
    }
    
    public void showField(int row){
        ui.getI_id().setText(String.valueOf(dabu.get(row).getId()));
        ui.getI_judul().setText(dabu.get(row).getJudul());
        ui.getI_genre().setText(dabu.get(row).getGenre());
        ui.getI_penulis().setText(dabu.get(row).getPenulis());
        ui.getI_penerbit().setText(dabu.get(row).getPenerbit());
        ui.getI_lokasi().setText(dabu.get(row).getLokasi());
        ui.getI_stock().setText(String.valueOf(dabu.get(row).getStock()));
    }
    
    public boolean checkEmpty(){
        if(ui.getI_judul().getText().isEmpty()){
            E_Handle.e_kosong();
            ui.getI_judul().requestFocus();
            return true;
        }
        else if(ui.getI_genre().getText().isEmpty()){
            E_Handle.e_kosong();
            ui.getI_genre().requestFocus();
            return true;
        }
        else if(ui.getI_penulis().getText().isEmpty()){
            E_Handle.e_kosong();
            ui.getI_penulis().requestFocus();
            return true;
        }
        else if(ui.getI_penerbit().getText().isEmpty()){
            E_Handle.e_kosong();
            ui.getI_penerbit().requestFocus();
            return true;
        }
        else if(ui.getI_lokasi().getText().isEmpty()){
            E_Handle.e_kosong();
            ui.getI_lokasi().requestFocus();
            return true;
        }
        else if(ui.getI_stock().getText().isEmpty()){
            E_Handle.e_kosong();
            ui.getI_stock().requestFocus();
            return true;
        }
        else{
            return false;
        }
    }
    
    public void insertData(){
        Data_Buku dab;
        
        if(checkEmpty() || checkAngka()){
            return;
        }
        dab = getFieldInsert();
        Dbuku.insertBuku(dab);
        showTable();
    }
    
    public void editData(){
        Data_Buku dab;
        
        if(checkEmpty() || checkAngka()){
            return;
        }
        dab = getField();
        Dbuku.editBuku(dab);
        showTable();
    }
    
    public void deleteData(){
        int id;
        
        if(ui.getI_id().getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Pilih Data", "ID Empty", JOptionPane.WARNING_MESSAGE);
            return;
        }
        id = Integer.parseInt(ui.getI_id().getText());
        Dbuku.deleteBuku(id);
        showTable();
    }
    
    public void search(){
        String type, val;
        
        type = String.valueOf(ui.getCombo().getSelectedItem());
        val = ui.getI_cari().getText();
        if(type.equals("Judul")){
            Sjudul(val);
        }
        else if(type.equals("Genre")){
            Sgenre(val);
        }
        else if(type.equals("Penulis")){
            Spenulis(val);
        }
        else if(type.equals("Penerbit")){
            Spenerbit(val);
        }
 
    }
    
    public void Sjudul(String val){
        List<Data_Buku> dabus = new ArrayList<Data_Buku>();
        Data_Buku dabt;
        
        for(int i = 0; i < dabu.size(); i++){
            if(val.equals(dabu.get(i).getJudul())){
                dabt = new Data_Buku();
                dabt.setId(dabu.get(i).getId());
                dabt.setJudul(dabu.get(i).getJudul());
                dabt.setGenre(dabu.get(i).getGenre());
                dabt.setPenulis(dabu.get(i).getPenulis());
                dabt.setPenerbit(dabu.get(i).getPenerbit());
                dabt.setLokasi(dabu.get(i).getLokasi());
                dabt.setStock(dabu.get(i).getStock());
                dabus.add(dabt);
            }
        }
        this.dabu = dabus;
        showSearchTable();
    }
    
    public void Sgenre(String val){
        List<Data_Buku> dabus = new ArrayList<Data_Buku>();
        Data_Buku dabt;
        
        for(int i = 0; i < dabu.size(); i++){
            if(val.equals(dabu.get(i).getGenre())){
                dabt = new Data_Buku();
                dabt.setId(dabu.get(i).getId());
                dabt.setJudul(dabu.get(i).getJudul());
                dabt.setGenre(dabu.get(i).getGenre());
                dabt.setPenulis(dabu.get(i).getPenulis());
                dabt.setPenerbit(dabu.get(i).getPenerbit());
                dabt.setLokasi(dabu.get(i).getLokasi());
                dabt.setStock(dabu.get(i).getStock());
                dabus.add(dabt);
            }
        }
        this.dabu = dabus;
        showSearchTable();
    }
    
    public void Spenulis(String val){
        List<Data_Buku> dabus = new ArrayList<Data_Buku>();
        Data_Buku dabt;
        
        for(int i = 0; i < dabu.size(); i++){
            if(val.equals(dabu.get(i).getPenulis())){
                dabt = new Data_Buku();
                dabt.setId(dabu.get(i).getId());
                dabt.setJudul(dabu.get(i).getJudul());
                dabt.setGenre(dabu.get(i).getGenre());
                dabt.setPenulis(dabu.get(i).getPenulis());
                dabt.setPenerbit(dabu.get(i).getPenerbit());
                dabt.setLokasi(dabu.get(i).getLokasi());
                dabt.setStock(dabu.get(i).getStock());
                dabus.add(dabt);
            }
        }
        this.dabu = dabus;
        showSearchTable();
    }
    
    public void Spenerbit(String val){
        List<Data_Buku> dabus = new ArrayList<Data_Buku>();
        Data_Buku dabt;
        
        for(int i = 0; i < dabu.size(); i++){
            if(val.equals(dabu.get(i).getPenerbit())){
                dabt = new Data_Buku();
                dabt.setId(dabu.get(i).getId());
                dabt.setJudul(dabu.get(i).getJudul());
                dabt.setGenre(dabu.get(i).getGenre());
                dabt.setPenulis(dabu.get(i).getPenulis());
                dabt.setPenerbit(dabu.get(i).getPenerbit());
                dabt.setLokasi(dabu.get(i).getLokasi());
                dabt.setStock(dabu.get(i).getStock());
                dabus.add(dabt);
            }
        }
        this.dabu = dabus;
        showSearchTable();
    }
    
    public boolean checkAngka(){
        try {
            Integer.parseInt(ui.getI_stock().getText());
            return  false;
        } catch (Exception e) {
            E_Handle.e_angka();
            ui.getI_stock().requestFocus();
            return true;
        }
    }
    
}
