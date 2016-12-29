<%@page import="java.sql.*" %>
<%@page import="com.film.koneksi.Koneksi" %>
<%
  //String KodePenyewaan = null;   
  String namaCustomer = null;  
  String judulFilm = null;
  String kodePenyewaan = request.getParameter("kodepenyewaan"); 
  String kodeCustomer = request.getParameter("kodecustomer"); 
  String kodeFilm = request.getParameter("kodefilm"); 

  if(kodePenyewaan != null){
           try{
          
            Koneksi konek = new Koneksi();
            Connection conn = konek.bukaKoneksi();
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM pennyewaan where kode_penyewaan ='"+kodePenyewaan+"'";
            ResultSet res = stm.executeQuery(sql);
            if(res.next()){
             kodeCustomer= res.getString("kode_customer");
             kodeFilm= res.getString("kode_film");
                               
            }
 %>
<%=kodeCustomer%>
 <% 
          conn.close();
          stm.close();         
        }catch(Exception e){
            e.printStackTrace();
        }
%>


<% 
}else if(kodeCustomer != kodeCustomer){
           
          try{
          
            Koneksi konek = new Koneksi();
            Connection conn = konek.bukaKoneksi();
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM customer where kode_customer ='"+kodeCustomer+"'";
            ResultSet res = stm.executeQuery(sql);
            if(res.next()){
             namaCustomer= res.getString("nama_customer");
                               
            }
 %>
 <%=namaCustomer%>
 <% 
          conn.close();
          stm.close();         
        }catch(Exception e){
            e.printStackTrace();
        }
%>

<%
 }else if(kodeFilm != null){
        try{
          
            Koneksi konek = new Koneksi();
            Connection conn = konek.bukaKoneksi();
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM datafilm where kode_film ='"+kodeFilm+"'";
            ResultSet res = stm.executeQuery(sql);
            if(res.next()){
             judulFilm= res.getString("judul_film");    
            }
%>
 <%=judulFilm%>
 <% 
          conn.close();
          stm.close();       
        }catch(Exception e){
            e.printStackTrace();
        }
   }
%>

     



 
