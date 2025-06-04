/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas3.Bioskop;

/**
 *
 * @author Asus
 */
public class TiketFilm {
    String nama_film, durasi, asal_film, tayang; //mendeklarasikan object
    int harga;
    
    //Konstruktor dengan parameter untuk menginisialisasi objek
    public TiketFilm(String nama_film, String durasi, String asal_film, String tayang, int harga){
        this.nama_film = nama_film; //Mengisi atribut dari parameter
        this.durasi = durasi;
        this.asal_film = asal_film;
        this.harga = harga;
        this.tayang = tayang;
    }
    
    //Method untuk menghitung harga jumlah tiket dan pajak
    public int hitungTiket(int jumlahTiket, int persenPajak) {
        int totalHarga = this.harga * jumlahTiket; // Menghitung total harga tiket
        int pajak = (totalHarga * persenPajak) / 100; // Menghitung pajak berdasarkan persentase
        return totalHarga + pajak; // Harga akhir setelah ditambah pajak
    }
}   
