/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas3.Bioskop;

/**
 *
 * @author Asus
 */
public class PemesananTiket extends TiketFilm {
    int jumlah;

    public PemesananTiket() {
        super("Spiderman", "190 Menit", "Amerika", "18.00", 35000);
        this.jumlah = 5;
    }

    public void setPemesanan(int harga, int jumlah) {
        this.harga = harga;
        this.jumlah = jumlah;
    }
}
