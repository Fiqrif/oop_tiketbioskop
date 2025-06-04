/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas3.Bioskop;

/**
 *
 * @author Asus
 */
public class PembelianTiket extends TiketFilm {
    private double diskon;
    private String metodePembayaran;

    // Konstruktor untuk menerima semua informasi tiket
    public PembelianTiket(String nama_film, String durasi, String asal_film, String tayang, int harga, String metodePembayaran, double diskon) {
        super(nama_film, durasi, asal_film, tayang, harga);
        this.metodePembayaran = metodePembayaran;
        this.diskon = diskon;
    }

    // Getter untuk metode pembayaran dan diskon
    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public double getDiskon() {
        return diskon;
    }

    // Menghitung total harga tiket setelah pajak dan diskon
    public int hitungTotal(int jumlahTiket, int persenPajak) {
        int hargaAwal = super.hitungTiket(jumlahTiket, persenPajak); // Harga tiket setelah pajak
        double potongan = (diskon / 100) * hargaAwal; // Menghitung diskon
        return (int) (hargaAwal - potongan); // Total harga setelah diskon
    }
}

