/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.film.dao;

import com.film.javabeans.Penyewaan;
import com.film.koneksi.Koneksi;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class PenyewaanDao {
    
     public void simpan(Penyewaan penyewaan) throws SQLException{
        
        try{
          Koneksi obj = new Koneksi();
          Connection conn = obj.bukaKoneksi();
          Statement stm = conn.createStatement();
          
          String query = "insert into pennyewaan"
                        + "(kode_penyewaan,kode_customer,kode_film,tgl_sewa,tgl_kembali,catatan) "
                        + "values('" +penyewaan.getKodePenyewaan() + "','" + penyewaan.getKodeCustomer() + "','"+penyewaan.getKodeFilm()+"','"+penyewaan.getTglSewa()+"','"+penyewaan.getTglKembali()+"','"+penyewaan.getCatatan()+"')";
          System.out.println(query);
          stm.executeUpdate(query);
          conn.close();
          stm.close();
        }catch(Exception e){
            e.printStackTrace();
        }
         
        
    }
     
       public void hapus(Penyewaan penyewaan) throws SQLException{
        
        try{
          Koneksi obj = new Koneksi();
          Connection conn = obj.bukaKoneksi();
          Statement stm = conn.createStatement();
          String query = "delete from pennyewaan where kode_penyewaan='" + penyewaan.getKodePenyewaan() + "'";
          System.out.println(query); 
          stm.executeUpdate(query);
          conn.close();
          stm.close();
        }catch(Exception e){
            e.printStackTrace();
        }
           
    }
    
}
