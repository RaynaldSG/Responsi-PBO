/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Data_Buku;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;
import pkg092_responsi.SQL_Connector;
/**
 *
 * @author Lab Informatika
 */
public class DAO_Buku implements DAOI_Buku{
    Connection connection;
    final String get_Query = "SELECT * FROM dataperpus";
    final String insert_Query = "INSERT INTO dataperpus (id, judul, genre, penulis, penerbit, lokasi, stock) VALUES (NULL, ?, ?, ?, ?, ?, ?)";
    final String edit_Query = "UPDATE `dataperpus` SET `judul` = ?, `genre` = ?, `penulis` = ?, `penerbit` = ?, `lokasi` = ?, `stock` = ? WHERE `dataperpus`.`id` = ?";
    final String delete_query = "DELETE FROM dataperpus WHERE id = ?";
    
     public DAO_Buku(){
         connection = SQL_Connector.connection();
     }
            
    @Override
    public List<Data_Buku> getAll() {
        List<Data_Buku> dabu = null;
        
        try {
            dabu = new ArrayList<Data_Buku>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(get_Query);
            while(rs.next()){
                Data_Buku dab = new Data_Buku();
                dab.setId(rs.getInt("id"));
                dab.setJudul(rs.getString("judul"));
                dab.setGenre(rs.getString("genre"));
                dab.setPenulis(rs.getString("penulis"));
                dab.setPenerbit(rs.getString("penerbit"));
                dab.setLokasi(rs.getString("lokasi"));
                dab.setStock(rs.getInt("stock"));
                dabu.add(dab);
            }
        } catch (SQLException e) {
            Logger.getLogger(Data_Buku.class.getName()).log(Level.SEVERE, null, e);
        }
        return dabu;
    }

    @Override
    public void insertBuku(Data_Buku dab) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(insert_Query);
            st.setString(1, dab.getJudul());
            st.setString(2, dab.getGenre());
            st.setString(3, dab.getPenulis());
            st.setString(4, dab.getPenerbit());
            st.setString(5, dab.getLokasi());
            st.setInt(6, dab.getStock());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void editBuku(Data_Buku dab) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(edit_Query);
            st.setString(1, dab.getJudul());
            st.setString(2, dab.getGenre());
            st.setString(3, dab.getPenulis());
            st.setString(4, dab.getPenerbit());
            st.setString(5, dab.getLokasi());
            st.setInt(6, dab.getStock());
            st.setInt(7, dab.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteBuku(int id) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(delete_query);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
