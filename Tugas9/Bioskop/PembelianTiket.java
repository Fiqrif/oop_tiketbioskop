/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas9.Bioskop;

import Tugas8.Bioskop.*;

/**
 *
 * @author Asus
 */
// Subclass untuk proses pembelian tiket dengan diskon dan metode pembayaran
public class PembelianTiket extends TiketFilm implements CetakStruk {

    private double diskon;
    private String metodePembayaran;

    // Konstruktor dengan validasi diskon
    public PembelianTiket(String namaFilm, String durasi, String asalFilm, String tayang, int harga, String metodePembayaran, double diskon) {
        super(namaFilm, durasi, asalFilm, tayang, harga);
        if (diskon < 0 || diskon > 100) {
            throw new IllegalArgumentException("Diskon harus antara 0 dan 100.");
        }
        this.metodePembayaran = metodePembayaran;
        this.diskon = diskon;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public double getDiskon() {
        return diskon;
    }

    // Menghitung total harga setelah pajak dan diskon
    public int hitungTotal(int jumlahTiket, int persenPajak) {
        int hargaAwal = super.hitungTiket(jumlahTiket, persenPajak);
        double potongan = (diskon / 100) * hargaAwal;
        return (int) (hargaAwal - potongan);
    }

    @Override
    public int hitungTiket(int jumlahTiket, int pajak) {
        return hitungTotal(jumlahTiket, pajak);
    }

    // Menampilkan detail pembelian tiket
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
                + "Diskon (" + getDiskon() + "% ) : Rp. " + (int) potongan + "\n"
                + "================================\n"
                + "Total Bayar : Rp. " + totalBayar + "\n"
                + "Metode Pembayaran : " + getMetodePembayaran() + "\n"
                + "================================\n"
                + "\nPembayaran Berhasil!";
    }

    @Override
    public String cetak() {
        int jumlahTiket = 5;
        int pajak = 5;
        int hargaAwal = super.hitungTiket(jumlahTiket, pajak);
        double potongan = (diskon / 100) * hargaAwal;
        int totalBayar = (int) (hargaAwal - potongan);

        String struk = "==== STRUK PEMBELIAN ====\n";
        struk += "Film : " + getNamaFilm() + "\n";
        struk += "Jumlah Tiket : " + jumlahTiket + "\n";
        struk += "Total Bayar setelah Diskon & Pajak: Rp. " + totalBayar + "\n";
        struk += "Metode Pembayaran : " + metodePembayaran + "\n";
        struk += "==========================\n";
        return struk;
    }

}
