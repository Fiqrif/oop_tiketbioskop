/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas5.Bioskop;

/**
 *
 * @author Asus
 */
public class TiketFilm {

    // Atribut private (enkapsulasi)
    private String namaFilm, durasi, asalFilm, tayang;
    private int harga;

    // Konstruktor
    public TiketFilm(String namaFilm, String durasi, String asalFilm, String tayang, int harga) {
        this.namaFilm = namaFilm;
        this.durasi = durasi;
        this.asalFilm = asalFilm;
        this.tayang = tayang;
        this.harga = harga;
    }

    // Getter dan Setter
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

    // Method untuk menghitung harga total dengan pajak (bisa dioverride)
    public int hitungTiket(int jumlahTiket, int persenPajak) {
        int totalHarga = harga * jumlahTiket;
        int pajak = (totalHarga * persenPajak) / 100;
        return totalHarga + pajak;
    }

    // Overloading: hitung harga tanpa pajak
    public int hitungTiket(int jumlahTiket) {
        return harga * jumlahTiket;
    }

    // Method info umum (bisa dioverride di child)
    public void infoTiket() {
        System.out.println("Film: " + namaFilm);
    }

    // Override method toString() agar bisa menampilkan informasi lengkap saat objek dicetak
    @Override
    public String toString() {
        return "=== Informasi Tiket ===\n"
                + "Nama Film : " + namaFilm + "\n"
                + "Asal Film : " + asalFilm + "\n"
                + "Durasi : " + durasi + "\n"
                + "Waktu Tayang : " + tayang + "\n"
                + "Harga Tiket : Rp. " + harga + "\n";
    }
}
