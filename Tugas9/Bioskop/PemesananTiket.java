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
// Subclass untuk proses pemesanan tiket film
public class PemesananTiket extends TiketFilm implements CetakStruk {

    private int jumlah;

    // Konstruktor default dengan data film bawaan
    public PemesananTiket() {
        super("Jumbo", "190 Menit", "Indonesia", "18.00", 35000);
        this.jumlah = 5;
    }

    public int getJumlah() {
        return jumlah;
    }

    // Setter jumlah dengan validasi
    public void setJumlah(int jumlah) throws IllegalArgumentException {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah tiket harus lebih dari 0.");
        }
        this.jumlah = jumlah;
    }

    // Setter untuk harga dan jumlah sekaligus, dengan validasi
    public void setPemesanan(int harga, int jumlah) throws IllegalArgumentException {
        if (harga <= 0) {
            throw new IllegalArgumentException("Harga tidak boleh nol atau negatif.");
        }
        setHarga(harga);
        setJumlah(jumlah);
    }

    @Override
    public int hitungTiket(int jumlahTiket, int pajak) {
        return super.hitungTiket(jumlahTiket, pajak);
    }

    @Override
    public int hitungTiket(int jumlahTiket) {
        return super.hitungTiket(jumlahTiket);
    }

    // Menampilkan informasi pemesanan tiket
    @Override
    public void infoTiket() {
        System.out.println("Film: " + getNamaFilm());
        System.out.println("Jumlah: " + jumlah);
        System.out.println("Harga per Tiket: Rp. " + getHarga());
    }

    @Override
    public String toString() {
        return "=== Pemesanan Tiket ===\n"
                + "Film yang dipesan : " + getNamaFilm() + "\n"
                + "Durasi Film : " + getDurasi() + "\n"
                + "Asal Film : " + getAsalFilm() + "\n"
                + "Tayang pada jam : " + getTayang() + "\n"
                + "Harga per Tiket : Rp. " + getHarga() + "\n"
                + "Jumlah Tiket : " + getJumlah() + "\n";
    }

    @Override
    public String cetak() {
        String struk = "==== STRUK PEMESANAN ====\n";
        struk += "Film : " + getNamaFilm() + "\n";
        struk += "Jumlah Tiket : " + jumlah + "\n";
        struk += "Total Bayar (tanpa pajak): Rp. " + hitungTiket(jumlah) + "\n";
        struk += "==========================\n";
        return struk;
    }

}
