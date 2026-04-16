import java.io.PrintWriter; // Library untuk mengirim teks ke server
import java.net.Socket;      // Library untuk membuat koneksi jaringan (TCP)

public class client {

    public static void main(String[] args) {
        try {
            // MEMBUKA KONEKSI
            // Membuat koneksi ke server dengan IP 10.8.0.38 pada port 12345
            Socket socket = new Socket("10.8.0.38", 12345);

            // MENYIAPKAN PENGIRIMAN DATA
            // getOutputStream() mengambil jalur keluar, 'true' berarti data langsung dikirim tanpa ditunda (auto-flush)
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // MENDEFINISIKAN PESAN
            String pesan = "Halo Naila Ayu Pradea Angelia";

            // MENGIRIM PESAN KE SERVER
            // Pesan dikirim melalui jaringan ke alamat IP yang dituju di atas
            out.println(pesan);

            // MEMBERSIHKAN KONEKSI
            // Menutup jalur pesan dan koneksi soket agar hemat memori dan tidak menggantung
            out.close();
            socket.close();

        } catch (Exception e) {
            // Jika ada error (misal IP tidak ketemu atau Notepad gagal buka), pesan error muncul di sini
            e.printStackTrace();
        }
    }
}