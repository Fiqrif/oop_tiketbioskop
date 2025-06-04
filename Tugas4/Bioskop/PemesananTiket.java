/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas4.Bioskop;

/**
 *
 * @author Asus
 */                                                     
public class PemesananTiket extends TiketFilm {
    private int jumlah;

    // Konstruktor default dengan nilai awal
    public PemesananTiket() {
        super("Spiderman", "190 Menit", "Amerika", "18.00", 35000);
        this.jumlah = 5;
    }
    
    // Getter dan Setter untuk jumlah tiket
    public int getJumlah() {
        return jumlah;
    }
    
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
    // Method untuk memperbarui harga dan jumlah tiket
    public void setPemesanan(int harga, int jumlah) {
        setHarga(harga);
        this.jumlah = jumlah;
    }
}
