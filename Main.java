import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // RUNTIME POLYMORPHISM: objek Mobil & Motor disimpan di referensi Kendaraan
        ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();
        daftarKendaraan.add(new Mobil("AD 1234 AB", "Toyota Avanza", 350000, 7));
        daftarKendaraan.add(new Mobil("AD 5678 CD", "Honda Brio", 300000, 5));
        daftarKendaraan.add(new Motor("AD 1111 EF", "Honda Beat", 80000, 110));
        daftarKendaraan.add(new Motor("AD 2222 GH", "Yamaha NMAX", 120000, 155));

        int hari = 3;

        System.out.println("=== Daftar Kendaraan ===");
        for (Kendaraan k : daftarKendaraan) {
            k.info(); // info() yang dipanggil menyesuaikan jenis objek aslinya
        }

        System.out.println("\n=== Perhitungan Biaya Sewa " + hari + " Hari ===");
        for (Kendaraan k : daftarKendaraan) {
            System.out.println(k.getMerek());
            System.out.println("  Biaya normal      : Rp" + k.hitungBiaya(hari));
            System.out.println("  Biaya diskon 10%  : Rp" + k.hitungBiaya(hari, 10)); // overloading

            // Cek apakah objek ini memenuhi kontrak interface
            if (k instanceof BisaDiasuransikan) {
                BisaDiasuransikan b = (BisaDiasuransikan) k;
                System.out.println("  Premi asuransi    : Rp" + b.hitungPremi(hari));
            }
        }

        System.out.println("\n=== Proses Penyewaan ===");
        Kendaraan pilihan = daftarKendaraan.get(0);
        pilihan.sewa();
        pilihan.sewa();        // gagal, karena sudah disewa
        pilihan.kembalikan();

        System.out.println("\n=== Uji Setter (Encapsulation) ===");
        Kendaraan motor = daftarKendaraan.get(2);
        motor.setTarifPerHari(-5000);  // ditolak oleh validasi
        motor.setTarifPerHari(90000);  // diterima
        System.out.println("Tarif baru " + motor.getMerek() + ": Rp" + motor.getTarifPerHari());
    }
}
