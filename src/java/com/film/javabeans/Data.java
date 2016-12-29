package com.film.javabeans;

public class Data {
    private int id;
    private String kodeData;
    private String judulData;
    private String sutradaraData;
    private String kategoriData;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
//////////////////////////////////////////////////////
    public String getKodeData() {
        return kodeData;
    }

    public void setKodeData(String kodeData) {
        this.kodeData = kodeData;
    }
//////////////////////////////////////////////////////////
    public String getJudulData() {
        return judulData;
    }

    public void setJudulData(String judulData) {
        this.judulData = judulData;
    }
/////////////////////////////////////////////////////////////
    public String getSutradaraData() {
        return sutradaraData;
    }

    public void setSutradaraData(String sutradaraData) {
        this.sutradaraData = sutradaraData;
    }
/////////////////////////////////////////////////////////////
    public String getKategoriData() {
        return kategoriData;
    }

    public void setKategoriData(String kategoriData) {
        this.kategoriData = kategoriData;
    }
/////////////////////////////////////////////////////////////

    public void setSelectedItem(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}   