<%@page import="java.sql.*" %>
<%@page import="com.film.koneksi.Koneksi" %>
<%

  String namaCustomer = null;  
  String judulFilm = null; 
  String kodeCustomer = request.getParameter("kodecustomer"); 
  String kodeFilm = request.getParameter("kodefilm"); 
 
  if(kodeCustomer != null){
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

     



 
