/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.film.javabeans;


/**
 *
 * @author User
 */
public class Penjualan {
    
    private int id;
    private String kodePenjualan;
    private String kodeCustomer;
    private String kodeFilm;
    private String tgljual;
    private String catatan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKodePenjualan() {
        return kodePenjualan;
    }

    public void setKodePenjualan(String kodePenjualan) {
        this.kodePenjualan = kodePenjualan;
    }

    public String getKodeCustomer() {
        return kodeCustomer;
    }

    public void setKodeCustomer(String kodeCustomer) {
        this.kodeCustomer = kodeCustomer;
    }

    public String getKodeFilm() {
        return kodeFilm;
    }

    public void setKodeFilm(String kodeFilm) {
        this.kodeFilm = kodeFilm;
    }

    public String getTglJual() {
        return tgljual;
    }

    public void setTglSewa(String tgljual) {
        this.tgljual = tgljual;
    }
    
}