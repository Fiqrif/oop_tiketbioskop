/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas5.Bioskop;

/**
 *
 * @author Asus
 */
public class PembelianTiket extends TiketFilm {

    private double diskon;
    private String metodePembayaran;

    public PembelianTiket(String namaFilm, String durasi, String asalFilm, String tayang, int harga, String metodePembayaran, double diskon) {
        super(namaFilm, durasi, asalFilm, tayang, harga);
        this.metodePembayaran = metodePembayaran;
        this.diskon = diskon;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public double getDiskon() {
        return diskon;
    }

    // Override method untuk menghitung total dengan pajak dan diskon
    public int hitungTotal(int jumlahTiket, int persenPajak) {
        int hargaAwal = super.hitungTiket(jumlahTiket, persenPajak);
        double potongan = (diskon / 100) * hargaAwal;
        return (int) (hargaAwal - potongan);
    }

    // Overloading hitungTotal: hanya jumlah tiket
    public int hitungTotal(int jumlahTiket) {
        return hitungTotal(jumlahTiket, 5); // default pajak 5%
    }

    // Overloading hitungTotal: tanpa parameter
    public int hitungTotal() {
        return hitungTotal(1, 5); // default 1 tiket, pajak 5%
    }

    // Override toString() untuk menampilkan detail lengkap pembelian tiket
    @Override
    public String toString() {
        int jumlahTiket = 5;
        int pajak = 5;
        int hargaAwal = super.hitungTiket(jumlahTiket, pajak); // total harga setelah pajak
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

    // Override infoTiket()
    @Override
    public void infoTiket() {
        System.out.println(toString());
    }

}
