/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas8.Bioskop;


/**
 *
 * @author Asus
 */

// Library untuk input pada CLI
import java.util.Scanner;
// Kelas utama untuk menjalankan aplikasi CLI
public class MainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Selamat datang di Aplikasi Tiket Film");

            // Input data film
            System.out.print("Masukkan nama film: ");
            String nama = input.nextLine();
            System.out.print("Masukkan durasi film: ");
            String durasi = input.nextLine();
            System.out.print("Masukkan asal film: ");
            String asal = input.nextLine();
            System.out.print("Masukkan waktu tayang (13.00 / 18.00): ");
            String tayang = input.nextLine();
            System.out.print("Masukkan harga tiket: ");
            int harga = input.nextInt();
            input.nextLine(); // membersihkan newline

            // Pilih jenis transaksi
            System.out.print("Pilih jenis transaksi (1.Pemesanan / 2.Pembelian): ");
            int pilihan = input.nextInt();
            input.nextLine();

            if (pilihan == 1) {
                // Pemesanan tiket
                PemesananTiket pesan = new PemesananTiket();
                System.out.print("Masukkan jumlah tiket: ");
                int jml = input.nextInt();
                pesan.setPemesanan(harga, jml);
                pesan.infoTiket();
                System.out.println("Total Bayar: Rp. " + pesan.hitungTiket(jml, 10));
            } else if (pilihan == 2) {
                // Pembelian tiket
                System.out.println("Pilih metode pembayaran:");
                System.out.println("1. Cash");
                System.out.println("2. Debit");
                System.out.println("3. QRIS");
                System.out.print("Masukkan pilihan (1/2/3): ");
                int metodePilihan = input.nextInt();
                input.nextLine();

                String metode;
                // Menentukan metode pembayaran
                switch (metodePilihan) {
                    case 1: metode = "Cash"; break;
                    case 2: metode = "Debit"; break;
                    case 3: metode = "QRIS"; break;
                    default:
                        throw new IllegalArgumentException("Metode pembayaran tidak valid.");
                }

                // Input diskon dengan validasi
                double diskon;
                do {
                    System.out.print("Masukkan diskon 1-100 (%): ");
                    diskon = input.nextDouble();
                    if (diskon < 0 || diskon > 100) {
                        System.out.println("Diskon harus antara 0 dan 100. Silakan coba lagi.");
                    }
                } while (diskon < 0 || diskon > 100);
                System.out.println("");

                // Membuat objek pembelian dan menampilkan info
                PembelianTiket beli = new PembelianTiket(nama, durasi, asal, tayang, harga, metode, diskon);
                beli.infoTiket();
                System.out.println("");
            } else {
                System.out.println("Pilihan tidak valid.");
            }

        } catch (Exception e) {
            // Menangani semua error input
            System.out.println("Terjadi kesalahan input: " + e.getMessage());
        } finally {
            input.close();
        }
    }
}
