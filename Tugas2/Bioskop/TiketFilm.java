/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas2.Bioskop;

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
    
    public static void main (String [] args){
        
        //Deklarasi Objek dengan nilai di parameter 
        TiketFilm tiket = new TiketFilm("Spiderman", "150 Menit", "Amerika", "Jam 18.00", 35000);
        
        //Menampilkan semua informasi yang telah di dekalarasikan dalam parameter
        System.out.println("Nama film yang akan tayang : " + tiket.nama_film);
        System.out.println("Durasi waktu film : " + tiket.durasi);
        System.out.println("Asal film : " + tiket.asal_film);
        System.out.println("Waktu tayang film : " + tiket.tayang);
        System.out.println("Harga film : " + tiket.harga);
        
        //Menampilkan total harga tiket dengan jumlah tiket 5 dan pajak sebesar 5000
        System.out.println("Total harga pesanan tiket Anda : " + tiket.hitungTiket(5, 5));
    }
}   
