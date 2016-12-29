/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.film.controller;

import com.film.dao.DataDao;
import com.film.dao.KategoriDao;
import com.film.javabeans.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author angkasaolrenza
 */
public class DataController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     DataDao DataDao = new DataDao();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Data data = new Data();
        RequestDispatcher rd;
       try {
            /* TODO output your page here. You may use following sample code. */
           String kodeFilm = request.getParameter("kdfilm");
           String judulFilm = request.getParameter("judul");
           String sutradaraFilm = request.getParameter("sutradara");
           String kodeKategori = request.getParameter("kategorilist");          
           if(request.getParameter("cari") != null){
               data = DataDao.cari(kodeFilm);
               if(data != null){
                    request.setAttribute("kdfilm", data.getKodeData());
                    request.setAttribute("judul", data.getJudulData()); 
                    request.setAttribute("sutradara", data.getSutradaraData());
                    request.setAttribute("kategorilist", data.getKategoriData());
               }else{
                   request.setAttribute("kdfilm", kodeFilm);
               }
                rd = request.getRequestDispatcher("index.jsp?go=DataFilm");
                rd.forward(request, response);
           }else if(request.getParameter("simpan") != null){
               data.setKodeData(kodeFilm);
               data.setJudulData(judulFilm);
               data.setSutradaraData(sutradaraFilm);
               data.setKategoriData(kodeKategori);
               DataDao.simpan(data);
               rd = request.getRequestDispatcher("index.jsp?go=DataFilm");
               rd.forward(request, response);
           }else if(request.getParameter("ubah") != null){
               data.setKodeData(kodeFilm);
               data.setJudulData(judulFilm);
               data.setSutradaraData(sutradaraFilm);
               data.setKategoriData(kodeKategori);
               DataDao.ubah(data);
               rd = request.getRequestDispatcher("index.jsp?go=DataFilm");
               rd.forward(request, response);
           }else if(request.getParameter("hapus") != null){
               data.setKodeData(kodeFilm);
               DataDao.hapus(data);
               rd = request.getRequestDispatcher("index.jsp?go=DataFilm");
               rd.forward(request, response);
           }
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
