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
    // Subclass PembelianTiket
public class PembelianTiket extends TiketFilm {
    private double diskon;
    private String metodePembayaran;

    public PembelianTiket(String namaFilm, String durasi, String asalFilm, String tayang, int harga, String metodePembayaran, double diskon) {
        super(namaFilm, durasi, asalFilm, tayang, harga);
        this.metodePembayaran = metodePembayaran;
        this.diskon = diskon;
    }

    public String getMetodePembayaran() { return metodePembayaran; }
    public double getDiskon() { return diskon; }

    // Menghitung total dengan pajak dan diskon
    public int hitungTotal(int jumlahTiket, int persenPajak) {
        int hargaAwal = super.hitungTiket(jumlahTiket, persenPajak);
        double potongan = (diskon / 100) * hargaAwal;
        return (int) (hargaAwal - potongan);
    }

    @Override
    public int hitungTiket(int jumlahTiket, int pajak) {
        return hitungTotal(jumlahTiket, pajak);
    }

    // Menampilkan info pembelian
    @Override
    public void infoTiket() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        int jumlahTiket = 5;
        int pajak = 5;
        int hargaAwal = super.hitungTiket(jumlahTiket, pajak);
        double potongan = (diskon / 100) * hargaAwal;
        int totalBayar = (int) (hargaAwal - potongan);

        return "=== Detail Pembelian Tiket ===\n"
                + "Nama Film : " + getNamaFilm() + "\n"
                + "Durasi : " + getDurasi() + "\n"
                + "Asal Film : " + getAsalFilm() + "\n"
                + "Waktu Tayang : " + getTayang() + "\n"
                + "Harga per Tiket : Rp. " + getHarga() + "\n"
                + "Jumlah Tiket : " + jumlahTiket + "\n"
                + "Pajak (5%) : Rp. " + ((getHarga() * jumlahTiket * pajak) / 100) + "\n"
                + "Diskon (" + getDiskon() + "%) : Rp. " + (int) potongan + "\n"
                + "================================\n"
                + "Total Bayar : Rp. " + totalBayar + "\n"
                + "Metode Pembayaran : " + getMetodePembayaran() + "\n"
                + "================================\n"
                + "\nPembayaran Berhasil!";
    }
}

