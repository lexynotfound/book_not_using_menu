package com.raihan;
/* 
 * Program pengelola buku
 * created by Kurnia Raihan Ardian
 * Menambahkan buku dengan oop, yaitu buku yang berisi
 * String Judul, String Penerbit, Int Halaman, double harga
 * semuanya di jadikan class atau oop
 * ini adalah versi satu atau Exams 1
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Selamat Datang di program Mengelola buku ");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Masukkan nama: ");
            String nama = scanner.nextLine();

            System.out.print("Masukkan alamat: ");
            String alamat = scanner.nextLine();

            int jumlahBuku;
            do {
                System.out.print("Masukkan jumlah buku (minimal 1): ");
                jumlahBuku = scanner.nextInt();
            } while (jumlahBuku < 1);

            if (jumlahBuku >= 5) {
                jumlahBuku = 5;
            }

            scanner.nextLine(); 

            Buku[] daftarBuku = new Buku[jumlahBuku];

            for (int i = 0; i < jumlahBuku; i++) {
                Buku buku = new Buku();

                System.out.println("\nData Buku ke-" + (i + 1));

                do {
                    System.out.print("ISBN: ");
                    buku.isbn = scanner.nextLine();
                } while (buku.isbn.trim().isEmpty());

                do {
                    System.out.print("Judul: ");
                    buku.judul = scanner.nextLine();
                } while (buku.judul.trim().isEmpty());

                do {
                    System.out.print("Penerbit: ");
                    buku.penerbit = scanner.nextLine();
                } while (buku.penerbit.trim().isEmpty());

                do {
                    try {
                        System.out.print("Harga: ");
                        buku.harga = Double.parseDouble(scanner.nextLine());
                        if (buku.harga <= 0) {
                            throw new Exception("Harga harus lebih dari 0.");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } while (buku.harga <= 0);

                do {
                    try {
                        System.out.print("Jumlah Halaman: ");
                        buku.halaman = Integer.parseInt(scanner.nextLine());
                        if (buku.halaman <= 0) {
                            throw new Exception("Jumlah halaman harus lebih dari 0.");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } while (buku.halaman <= 0);

                daftarBuku[i] = buku;
            }

            System.out.println("\nNama: " + nama);
            System.out.println("Alamat: " + alamat);

            System.out.println("\n=========================================");
            System.out.println("No    Judul           ISBN           Penerbit      Harga    Halaman");
            System.out.println("=========================================");

            for (int i = 0; i < jumlahBuku; i++) {
                System.out.printf("%-6d%-16s%-14s%-14s%-9.2f%-10d%n", 
                (i + 1), 
                daftarBuku[i].judul, 
                daftarBuku[i].isbn, 
                daftarBuku[i].penerbit, 
                daftarBuku[i].harga, 
                daftarBuku[i].halaman);
            }
        }
    }
}
