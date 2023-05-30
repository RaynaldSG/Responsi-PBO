/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Data_Buku;

/**
 *
 * @author Lab Informatika
 */
public interface DAOI_Buku {
    public List<Data_Buku> getAll();
    public void insertBuku(Data_Buku dab);
    public void editBuku(Data_Buku dab);
    public void deleteBuku(int id);
}
