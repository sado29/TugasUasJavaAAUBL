package com.film.koneksi;
import java.sql.*;

public class Koneksi {
    public Connection bukaKoneksi()throws SQLException{
        Connection connect;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/film","root","");
            return connect;
        }
        catch(Exception exc){

        }
        return null;
    }

}
