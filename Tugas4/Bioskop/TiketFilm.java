/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas4.Bioskop;

/**
 *
 * @author Asus
 */
public class TiketFilm {

    // Atribut bersifat private untuk menerapkan enkapsulasi
    private String namaFilm, durasi, asalFilm, tayang;
    private int harga;

    // Konstruktor untuk menginisialisasi objek TiketFilm
    public TiketFilm(String namaFilm, String durasi, String asalFilm, String tayang, int harga) {
        this.namaFilm = namaFilm;
        this.durasi = durasi;
        this.asalFilm = asalFilm;
        this.tayang = tayang;
        this.harga = harga;
    }

    // Getter dan Setter untuk setiap atribut agar tetap terenkapsulasi
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

    // Method untuk menghitung total harga tiket dengan pajak
    public int hitungTiket(int jumlahTiket, int persenPajak) {
        int totalHarga = this.harga * jumlahTiket; // Menghitung total harga sebelum pajak
        int pajak = (totalHarga * persenPajak) / 100; // Menghitung pajak berdasarkan persentase
        return totalHarga + pajak; // Mengembalikan total harga setelah ditambah pajak
    }
}
