package com.codetalenta.batikindonesia;

public class BatikModels {
    private String nama, daerah, makna, hargaTertinggi, hargaTerendah, gambar;

    public BatikModels(String nama, String daerah, String makna, String hargaTertinggi, String hargaTerendah, String gambar) {
        this.nama = nama;
        this.daerah = daerah;
        this.makna = makna;
        this.hargaTertinggi = hargaTertinggi;
        this.hargaTerendah = hargaTerendah;
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDaerah() {
        return daerah;
    }

    public void setDaerah(String daerah) {
        this.daerah = daerah;
    }

    public String getMakna() {
        return makna;
    }

    public void setMakna(String makna) {
        this.makna = makna;
    }

    public String getHargaTertinggi() {
        return hargaTertinggi;
    }

    public void setHargaTertinggi(String hargaTertinggi) {
        this.hargaTertinggi = hargaTertinggi;
    }

    public String getHargaTerendah() {
        return hargaTerendah;
    }

    public void setHargaTerendah(String hargaTerendah) {
        this.hargaTerendah = hargaTerendah;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
