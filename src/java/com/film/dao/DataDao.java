/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.film.dao;

import com.film.javabeans.Data;
import com.film.koneksi.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataDao {
   
    
     public void simpan(Data data) throws SQLException{
        
        try{
          Koneksi obj = new Koneksi();
          Connection conn = obj.bukaKoneksi();
          Statement stm = conn.createStatement();
          
          String query = "insert into datafilm"
                        + "(kode_film,judul_film,sutradara,kode_kategori) "
                        + "values('" + data.getKodeData() + "','" + data.getJudulData() + "','" + data.getSutradaraData() + "','" + data.getKategoriData() + "')";
          System.out.println(query);
          stm.executeUpdate(query);
          conn.close();
          stm.close();
        }catch(Exception e){
            e.printStackTrace();
        }
         
        
    }
     
   public void ubah(Data data) throws SQLException{
        
        try{
          Koneksi obj = new Koneksi();
          Connection conn = obj.bukaKoneksi();
          Statement stm = conn.createStatement();
          String query = "update datafilm set judul_film='" + data.getJudulData() + "',sutradara='" + data.getSutradaraData() + "',kode_kategor='" + data.getKategoriData() + "' where kode_film='"+data.getKodeData()+"'";
          System.out.println(query);             
          stm.executeUpdate(query);
          conn.close();
          stm.close();
        }catch(Exception e){
            e.printStackTrace();
        }     
  }
    
        
     public void hapus(Data data) throws SQLException{
        
        try{
          Koneksi obj = new Koneksi();
          Connection conn = obj.bukaKoneksi();
          Statement stm = conn.createStatement();
          
          String query = "delete from datafilm where kode_film='" + data.getKodeData() + "'";
          System.out.println(query); 
          stm.executeUpdate(query);
          conn.close();
          stm.close();
        }catch(Exception e){
            e.printStackTrace();
        }
           
    }
     
    public Data cari(String kodeFilm) throws SQLException{
            Data data = null;
        
        try{
         
          Koneksi obj = new Koneksi();
          Connection conn = obj.bukaKoneksi();
          Statement stm = conn.createStatement();
        
          String query = "select * from datafilm where kode_film='"+kodeFilm+"'";
          System.out.println(query);
          ResultSet rs = stm.executeQuery(query);
          
          if(rs.next()){
              data = new Data();
              data.setKodeData(rs.getString("kode_film"));
              data.setJudulData(rs.getString("judul_film"));
              data.setSutradaraData(rs.getString("sutradara"));
              data.setKategoriData(rs.getString("kode_kategori"));
              data.setSelectedItem(rs.getString("kode_kategori"));
          }
          conn.close();
          stm.close();

          
        }catch(Exception e){
            e.printStackTrace();
        }
        return data;
         
        
    }
} 