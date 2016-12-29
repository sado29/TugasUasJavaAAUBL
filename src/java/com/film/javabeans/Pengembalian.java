
package com.film.javabeans;

public class Pengembalian {
    
    private int id;
    private String kodePengembalian;
    private String kodeCustomer;
    private String kodeFilm;
    private String tglkembali;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKodePengembalian() {
        return kodePengembalian;
    }

    public void setKodePengembalian(String kodePengembalian) {
        this.kodePengembalian = kodePengembalian;
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

    public String getTglKembali() {
        return tglkembali;
    }

    public void setTglKembali(String tglkembali) {
        this.tglkembali = tglkembali;
    }
    
}