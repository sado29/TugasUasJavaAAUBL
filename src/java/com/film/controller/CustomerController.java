package com.film.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.film.dao.CustomerDao;
import com.film.javabeans.Customer;
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
public class CustomerController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        CustomerDao customerDao = new CustomerDao();
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Customer customer = new Customer();
        RequestDispatcher rd;
       try {
            /* TODO output your page here. You may use following sample code. */
           String kodeCustomer = request.getParameter("kodeCustomer");
           String namaCustomer = request.getParameter("namaCustomer");
           String alamatCustomer = request.getParameter("alamatCustomer");
           String teleponCustomer = request.getParameter("teleponCustomer");
           if(request.getParameter("cari") != null){
               customer = customerDao.cari(kodeCustomer);
               if(customer != null){
                    request.setAttribute("kodeCustomer", customer.getKodeCustomer());
                    request.setAttribute("namaCustomer", customer.getNamaCustomer()); 
                    request.setAttribute("alamatCustomer", customer.getAlamatCustomer());
                    request.setAttribute("teleponCustomer", customer.getTeleponCustomer());
               }else{
                   request.setAttribute("kodecustomer", kodeCustomer);
               }
                rd = request.getRequestDispatcher("index.jsp?go=Customer");
                rd.forward(request, response);
           }else if(request.getParameter("simpan") != null){
               customer.setKodeCustomer(kodeCustomer);
               customer.setNamaCustomer(namaCustomer);
               customer.setAlamatCustomer(alamatCustomer);
               customer.setTeleponCustomer(teleponCustomer);
               customerDao.simpan(customer);
               rd = request.getRequestDispatcher("index.jsp?go=Customer");
               rd.forward(request, response);
           }else if(request.getParameter("ubah") != null){
               customer.setKodeCustomer(kodeCustomer);
               customer.setNamaCustomer(namaCustomer);
               customer.setAlamatCustomer(alamatCustomer);
               customer.setTeleponCustomer(teleponCustomer);;
               customerDao.ubah(customer);
               rd = request.getRequestDispatcher("index.jsp?go=Customer");
               rd.forward(request, response);
           }else if(request.getParameter("hapus") != null){
               customer.setKodeCustomer(kodeCustomer);
               customerDao.hapus(customer);
               rd = request.getRequestDispatcher("index.jsp?go=Customer");
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
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
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
