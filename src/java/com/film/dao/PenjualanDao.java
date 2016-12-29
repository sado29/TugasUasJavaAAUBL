/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.film.dao;

import com.film.javabeans.Penjualan;
import com.film.koneksi.Koneksi;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class PenjualanDao {
    
     public void simpan(Penjualan penjualan) throws SQLException{
        
        try{
          Koneksi obj = new Koneksi();
          Connection conn = obj.bukaKoneksi();
          Statement stm = conn.createStatement();
          
          String query = "insert into penjualan"
                        + "(kode_penjualan,kode_customer,kode_film,tgl_jual) "
                        + "values('" +penjualan.getKodePenjualan() + "','" + penjualan.getKodeCustomer() + "','"+penjualan.getKodeFilm()+"','"+penjualan.getTglJual()+"')";
          System.out.println(query);
          stm.executeUpdate(query);
          conn.close();
          stm.close();
        }catch(Exception e){
            e.printStackTrace();
        }
     /*   
        try{
          Koneksi obj = new Koneksi();
          Connection conn = obj.bukaKoneksi();
          Statement stm = conn.createStatement();
          
          String query = "delete from datafilm where kode_film='" + penjualan.getKodeFilm() + "'";
          System.out.println(query); 
          stm.executeUpdate(query);
          conn.close();
          stm.close();
        }catch(Exception e){
            e.printStackTrace();
        }
     */    
        
    }
     
       public void hapus(Penjualan penjualan) throws SQLException{
        
        try{
          Koneksi obj = new Koneksi();
          Connection conn = obj.bukaKoneksi();
          Statement stm = conn.createStatement();
          String query = "delete from penjualan where kode_penjualan='" + penjualan.getKodePenjualan() + "'";
          System.out.println(query); 
          stm.executeUpdate(query);
          conn.close();
          stm.close();
        }catch(Exception e){
            e.printStackTrace();
        }
           
    }
    
}