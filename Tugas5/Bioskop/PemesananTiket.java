/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas5.Bioskop;

/**
 *
 * @author Asus
 */
public class PemesananTiket extends TiketFilm {

    private int jumlah;

    public PemesananTiket() {
        super("Spiderman", "190 Menit", "Amerika", "18.00", 35000);
        this.jumlah = 5;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    // Overloading method dari parent
    public void setPemesanan(int harga, int jumlah) {
        setHarga(harga);
        this.jumlah = jumlah;
    }

    // Override infoTiket()
    @Override
    public void infoTiket() {
        System.out.println("Film: " + getNamaFilm());
        System.out.println("Jumlah: " + jumlah);
        System.out.println("Harga per Tiket: Rp. " + getHarga());
    }

    // Overloading: hitungTiket hanya dengan pajak
    public int hitungTiket(int pajak) {
        return super.hitungTiket(jumlah, pajak);
    }

    // Overloading: hitungTiket tanpa parameter
    public int hitungTiket() {
        return super.hitungTiket(jumlah);
    }

    // Override toString() untuk menampilkan info lengkap pemesanan
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

}
