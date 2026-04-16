import java.io.*;   // Mengambil library untuk input-output (BufferedReader, dsb)
import java.net.*;  // Mengambil library untuk jaringan (ServerSocket, Socket)

public class server {

    public static void main(String[] args) {
        try {
            // MEMBUKA PORT SERVER
            // Server akan standby di port 12345. Ini seperti membuka loket nomor 12345.
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server menunggu...");

            // MENUNGGU KONEKSI (BLOCKING)
            // Program akan berhenti di baris ini sampai ada client yang connect.
            // Begitu client terhubung, objek 'socket' akan tercipta sebagai jalur komunikasi.
            Socket socket = serverSocket.accept();

            // MENYIAPKAN PENERIMAAN DATA
            // getInputStream() mengambil data yang masuk dari client.
            // InputStreamReader mengubah data mentah menjadi karakter.
            // BufferedReader digunakan agar proses membaca teks lebih cepat dan efisien.
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            // MEMBACA PESAN
            // Membaca satu baris teks yang dikirim oleh client melalui 'out.println' tadi.
            String pesan = in.readLine();

            // MENAMPILKAN PESAN
            // Mencetak pesan yang diterima ke layar console (terminal) server.
            System.out.println("Pesan dari client: " + pesan);

            // MENUTUP SEMUA AKSES
            // Menutup pembaca (in), jalur client (socket), dan loket server (serverSocket).
            in.close();
            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            // Jika port sudah dipakai aplikasi lain atau terjadi gangguan, error muncul di sini.
            e.printStackTrace();
        }
    }
}