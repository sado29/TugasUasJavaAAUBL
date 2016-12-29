/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.film.controller;

import com.film.dao.PengembalianDao;
import com.film.javabeans.Pengembalian;
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
public class PengembalianController extends HttpServlet {
    
     Pengembalian pengembalian = new Pengembalian();
     PengembalianDao pengembalianDao = new PengembalianDao();
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
           String tglKembali = request.getParameter("tglkembali");
           
           if(request.getParameter("cari") != null){
               pengembalian = pengembalianDao.cari(kodePenyewaan);
               if(pengembalian != null){
                    request.setAttribute("kodePenyewaan",pengembalian.getKodePengembalian());
                    request.setAttribute("kodeCustomer", pengembalian.getKodeCustomer()); 
                    request.setAttribute("kodeFilm", pengembalian.getKodeFilm()); 
               }else{
                   request.setAttribute("kodePenyewaan", kodePenyewaan);
               }
                rd = request.getRequestDispatcher("index.jsp?go=PengembalianFilm");
                rd.forward(request, response);
           }else if(request.getParameter("Simpan") != null){
               pengembalian.setKodePengembalian(kodePenyewaan);
               pengembalian.setKodeCustomer(kodeCustomer);
               pengembalian.setKodeFilm(kodeFilm);
               pengembalian.setTglKembali(tglKembali);
               pengembalianDao.simpan(pengembalian);
               rd = request.getRequestDispatcher("index.jsp?go=PengembalianFilm");
               rd.forward(request, response);
           }else if(request.getParameter("Hapus")!= null){
               pengembalian.setKodePengembalian(kodePenyewaan);
               pengembalianDao.hapus(pengembalian);
               rd = request.getRequestDispatcher("index.jsp?go=PengembalianFilm");
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
                        Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
                    }
        } catch (ParseException ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
                    }
        } catch (ParseException ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
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
