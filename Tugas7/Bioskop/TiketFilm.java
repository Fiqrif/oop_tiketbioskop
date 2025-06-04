/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas7.Bioskop;

import Tugas6.Bioskop.*;

/**
 *
 * @author Asus
 */

// Kelas abstrak TiketFilm
public abstract class TiketFilm {
// Atribut umum untuk semua tiket film
    private String namaFilm, durasi, asalFilm, tayang;
    private int harga;

    //Konstruktor
    public TiketFilm(String namaFilm, String durasi, String asalFilm, String tayang, int harga) {
        this.namaFilm = namaFilm;
        this.durasi = durasi;
        this.asalFilm = asalFilm;
        this.tayang = tayang;
        this.harga = harga;
    }

    //Getter Setter
    public String getNamaFilm() {
        return namaFilm;
    }

    public void setNamaFilm(String namaFilm) {
        this.namaFilm = namaFilm;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    public String getAsalFilm() {
        return asalFilm;
    }

    public void setAsalFilm(String asalFilm) {
        this.asalFilm = asalFilm;
    }

    public String getTayang() {
        return tayang;
    }

    public void setTayang(String tayang) {
        this.tayang = tayang;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    // Overload method hitungTiket
    public int hitungTiket(int jumlahTiket, int persenPajak) {
        int total = harga * jumlahTiket;
        int pajak = (total * persenPajak) / 100;
        return total + pajak;
    }

    public int hitungTiket(int jumlahTiket) {
        return harga * jumlahTiket;
    }

    // Method abstrak untuk diimplementasikan subclass
    public abstract void infoTiket();
    @Override
    public abstract String toString();
}
