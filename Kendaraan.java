// Abstract class: kelas dasar untuk semua kendaraan yang disewakan
abstract class Kendaraan {

    // ENCAPSULATION: atribut disembunyikan (private)
    private String plat;
    private String merek;
    private double tarifPerHari;
    private boolean tersedia;

    // Konstruktor
    public Kendaraan(String plat, String merek, double tarifPerHari) {
        this.plat = plat;
        this.merek = merek;
        this.tarifPerHari = tarifPerHari;
        this.tersedia = true; // kendaraan baru otomatis tersedia
    }

    // Getter
    public String getPlat() {
        return plat;
    }

    public String getMerek() {
        return merek;
    }

    public double getTarifPerHari() {
        return tarifPerHari;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    // Setter dengan validasi
    public void setTarifPerHari(double tarifPerHari) {
        if (tarifPerHari > 0) {
            this.tarifPerHari = tarifPerHari;
        } else {
            System.out.println("Tarif tidak valid, harus lebih dari 0.");
        }
    }

    // Perubahan status hanya lewat method ini (bukan diubah langsung)
    public void sewa() {
        if (tersedia) {
            tersedia = false;
            System.out.println(merek + " (" + plat + ") berhasil disewa.");
        } else {
            System.out.println(merek + " (" + plat + ") sedang disewa orang lain.");
        }
    }

    public void kembalikan() {
        tersedia = true;
        System.out.println(merek + " (" + plat + ") sudah dikembalikan.");
    }

    // Abstract method: cara hitung biaya berbeda di tiap subclass
    public abstract double hitungBiaya(int hari);

    // OVERLOADING: nama sama dengan hitungBiaya(int), parameter berbeda
    public double hitungBiaya(int hari, double diskonPersen) {
        double biaya = hitungBiaya(hari);
        return biaya - (biaya * diskonPersen / 100);
    }

    // Method konkrit, nanti di-override oleh subclass
    public void info() {
        System.out.println("Kendaraan: " + merek + " | Plat: " + plat
                + " | Tarif/hari: " + tarifPerHari);
    }
}
