/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas.Bioskop;

/**
 *
 * @author Asus
 */
public class Film { //mendeklarasikan kelas film
    String nama_film, durasi, asal_film, tayang, harga; //mendeklarasikan object
    void dataNamaFilm(String Nama_Film){ //mendeklarasikan method
        this.nama_film = Nama_Film;
    }    
    void dataDurasi(String Durasi){ //mendeklarasikan method
        this.durasi = Durasi;
    }
    void dataAsalFilm(String Asal_Film){ //mendeklarasikan method
        this.asal_film = Asal_Film;
    }  
    void dataTayang(String Tayang){ //mendeklarasikan method
        this.tayang = Tayang;
    }
    void dataHarga(String Harga){ //mendeklarasikan method
        this.harga = Harga;
    }
    
    
    String cetakNama_Film(){ //mendeklarasikan method
        return nama_film;
    }
    String cetakDurasi(){ //mendeklarasikan method
        return durasi;
    }
    String cetakAsal_Film(){ //mendeklarasikan method
        return asal_film;
    }
    String cetakTayang(){ //mendeklarasikan method
        return tayang;
    }
    String cetakHarga(){ //mendeklarasikan method
        return harga;
    }
}
