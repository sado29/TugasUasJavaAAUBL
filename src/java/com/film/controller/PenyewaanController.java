/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.film.controller;

import com.film.dao.PenyewaanDao;
import com.film.javabeans.Penyewaan;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class PenyewaanController extends HttpServlet {
    
     Penyewaan penyewaan = new Penyewaan();
     PenyewaanDao penyewaanDao = new PenyewaanDao();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd;

        try {
            /* TODO output your page here. You may use following sample code. */
           String kodePenyewaan = request.getParameter("kodePenyewaan");
           String kodeCustomer = request.getParameter("kodeCustomer");
           String kodeFilm = request.getParameter("kodeFilm");
           String tglSewa = request.getParameter("tglsewa");
           String tglKembali = request.getParameter("tglkembali");
           String catatan = request.getParameter("catatanSewa"); 

            if(request.getParameter("Simpan") != null){
               penyewaan.setKodePenyewaan(kodePenyewaan);
               penyewaan.setKodeCustomer(kodeCustomer);
               penyewaan.setKodeFilm(kodeFilm);
               penyewaan.setTglSewa(tglSewa);
               penyewaan.setTglKembali(tglKembali);
               penyewaan.setCatatan(catatan);
               penyewaanDao.simpan(penyewaan);
               rd = request.getRequestDispatcher("index.jsp?go=PenyewaanFilm");
               rd.forward(request, response);
           }else if(request.getParameter("Hapus")!= null){
               penyewaan.setKodePenyewaan(kodePenyewaan);
               penyewaanDao.hapus(penyewaan);
               rd = request.getRequestDispatcher("index.jsp?go=PenyewaanFilm");
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
                    try {
                        processRequest(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(PenyewaanController.class.getName()).log(Level.SEVERE, null, ex);
                    }
        } catch (ParseException ex) {
            Logger.getLogger(PenyewaanController.class.getName()).log(Level.SEVERE, null, ex);
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
                    try {
                        processRequest(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(PenyewaanController.class.getName()).log(Level.SEVERE, null, ex);
                    }
        } catch (ParseException ex) {
            Logger.getLogger(PenyewaanController.class.getName()).log(Level.SEVERE, null, ex);
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
