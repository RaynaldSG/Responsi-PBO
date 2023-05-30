/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg092_responsi;

import javax.swing.JOptionPane;

/**
 *
 * @author Lab Informatika
 */
public class E_Handle {
    static public void e_kosong(){
        JOptionPane.showMessageDialog(null, "Field Tidak Boleh Kosong", "Field Empty", JOptionPane.WARNING_MESSAGE);
    }
    static public void e_angka(){
        JOptionPane.showMessageDialog(null, "Field Input Harus Angka", "Field Format False", JOptionPane.WARNING_MESSAGE);
    }
    static public void e_ckosong(){
        JOptionPane.showMessageDialog(null, "Data Yang Dicari Tidak Ada", "Data Not Found", JOptionPane.WARNING_MESSAGE);
    }
}
