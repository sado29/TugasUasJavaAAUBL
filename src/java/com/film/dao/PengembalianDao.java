/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.film.dao;

import com.film.javabeans.Pengembalian;
import com.film.koneksi.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class PengembalianDao {
    
     public void simpan(Pengembalian pengembalian) throws SQLException{
        
        try{
          Koneksi obj = new Koneksi();
          Connection conn = obj.bukaKoneksi();
          Statement stm = conn.createStatement();
          
          String query = "insert into pengembalian"
                        + "(kode_penyewaan,kode_customer,kode_film,tgl_kembali) "
                        + "values('" +pengembalian.getKodePengembalian() + "','" + pengembalian.getKodeCustomer() + "','"+pengembalian.getKodeFilm()+"','"+pengembalian.getTglKembali()+"')";
          System.out.println(query);
          stm.executeUpdate(query);
          conn.close();
          stm.close();
        }catch(Exception e){
            e.printStackTrace();
        }
         
        
    }
     
       public void hapus(Pengembalian pengembalian) throws SQLException{
        
        try{
          Koneksi obj = new Koneksi();
          Connection conn = obj.bukaKoneksi();
          Statement stm = conn.createStatement();
          String query = "delete from pengembalian where kode_penyewaan='" + pengembalian.getKodePengembalian() + "'";
          System.out.println(query); 
          stm.executeUpdate(query);
          conn.close();
          stm.close();
        }catch(Exception e){
            e.printStackTrace();
        }
           
    }
       
    public Pengembalian cari(String kodePengembalian) throws SQLException{
            Pengembalian pengembalian = null;
        
        try{
         
          Koneksi obj = new Koneksi();
          Connection conn = obj.bukaKoneksi();
          Statement stm = conn.createStatement();
        
          String query = "select * from pennyewaan where kode_penyewaan='"+kodePengembalian+"'";
          System.out.println(query);
          ResultSet rs = stm.executeQuery(query);
          
          if(rs.next()){
              pengembalian = new Pengembalian();
              pengembalian.setKodePengembalian(rs.getString("kode_penyewaan"));
              pengembalian.setKodeCustomer(rs.getString("kode_customer"));
              pengembalian.setKodeFilm(rs.getString("kode_film"));
          }
          conn.close();
          stm.close();

          
        }catch(Exception e){
            e.printStackTrace();
        }
        return pengembalian;
         
        
    }       
    
}