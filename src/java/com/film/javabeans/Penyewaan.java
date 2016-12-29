/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.film.javabeans;


/**
 *
 * @author User
 */
public class Penyewaan {
    
    private int id;
    private String kodePenyewaan;
    private String kodeCustomer;
    private String kodeFilm;
    private String tglsewa;
    private String tglKembali;
    private String catatan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKodePenyewaan() {
        return kodePenyewaan;
    }

    public void setKodePenyewaan(String kodePeminjaman) {
        this.kodePenyewaan = kodePeminjaman;
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

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public String getTglSewa() {
        return tglsewa;
    }

    public void setTglSewa(String tglSewa) {
        this.tglsewa = tglSewa;
    }

    public String getTglKembali() {
        return tglKembali;
    }

    public void setTglKembali(String tglKembali) {
        this.tglKembali = tglKembali;
    }   
    
}