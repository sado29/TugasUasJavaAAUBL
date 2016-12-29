/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.film.dao;

import com.film.javabeans.Customer;
import com.film.koneksi.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CustomerDao {
   
    
     public void simpan(Customer customer) throws SQLException{
        
        try{
          Koneksi obj = new Koneksi();
          Connection conn = obj.bukaKoneksi();
          Statement stm = conn.createStatement();
          
          String query = "insert into customer"
                        + "(kode_customer,nama_customer,alamat,telepon) "
                        + "values('" + customer.getKodeCustomer() + "','" + customer.getNamaCustomer() + "','" + customer.getAlamatCustomer() + "','" + customer.getTeleponCustomer() + "')";
          System.out.println(query);
          stm.executeUpdate(query);
          conn.close();
          stm.close();
        }catch(Exception e){
            e.printStackTrace();
        }
         
        
    }
     
   public void ubah(Customer customer) throws SQLException{
        
        try{
          Koneksi obj = new Koneksi();
          Connection conn = obj.bukaKoneksi();
          Statement stm = conn.createStatement();
          
          String query = "update customer set nama_customer='" + customer.getNamaCustomer() + "',alamat='" + customer.getAlamatCustomer() + "',telepon='" + customer.getTeleponCustomer() + "' where kode_customer='"+customer.getKodeCustomer()+"'";
          System.out.println(query);             
          stm.executeUpdate(query);
          conn.close();
          stm.close();
        }catch(Exception e){
            e.printStackTrace();
        }     
  }
    
        
     public void hapus(Customer customer) throws SQLException{
        
        try{
          Koneksi obj = new Koneksi();
          Connection conn = obj.bukaKoneksi();
          Statement stm = conn.createStatement();
          
          String query = "delete from customer where kode_customer='" + customer.getKodeCustomer() + "'";
          System.out.println(query); 
          stm.executeUpdate(query);
          conn.close();
          stm.close();
        }catch(Exception e){
            e.printStackTrace();
        }
           
    }
     
    public Customer cari(String kodeCustomer) throws SQLException{
            Customer customer = null;
        
        try{
         
          Koneksi obj = new Koneksi();
          Connection conn = obj.bukaKoneksi();
          Statement stm = conn.createStatement();
        
          String query = "select * from customer where kode_customer='"+kodeCustomer+"'";
          System.out.println(query);
          ResultSet rs = stm.executeQuery(query);
          
          if(rs.next()){
              customer = new Customer();
              customer.setKodeCustomer(rs.getString("kode_customer"));
              customer.setNamaCustomer(rs.getString("nama_customer"));
              customer.setAlamatCustomer(rs.getString("alamat"));
              customer.setTeleponCustomer(rs.getString("telepon"));
          }
          conn.close();
          stm.close();

          
        }catch(Exception e){
            e.printStackTrace();
        }
        return customer;
         
        
    }
} 