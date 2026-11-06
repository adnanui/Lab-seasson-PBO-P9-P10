// INHERITANCE: Mobil adalah Kendaraan, sekaligus bisa diasuransikan
class Mobil extends Kendaraan implements BisaDiasuransikan {

    private int jumlahKursi;

    public Mobil(String plat, String merek, double tarifPerHari, int jumlahKursi) {
        super(plat, merek, tarifPerHari); // memanggil konstruktor Kendaraan
        this.jumlahKursi = jumlahKursi;
    }

    public int getJumlahKursi() {
        return jumlahKursi;
    }

    // Mengisi abstract method dari Kendaraan
    // Mobil: tarif x hari + biaya kebersihan tetap Rp50.000
    @Override
    public double hitungBiaya(int hari) {
        return (getTarifPerHari() * hari) + 50000;
    }

    // Mengisi kontrak dari interface BisaDiasuransikan (10% dari biaya sewa)
    @Override
    public double hitungPremi(int hari) {
        return hitungBiaya(hari) * 0.10;
    }

    // OVERRIDING method info() dari Kendaraan
    @Override
    public void info() {
        System.out.println("Mobil: " + getMerek() + " | Plat: " + getPlat()
                + " | Kursi: " + jumlahKursi + " | Tarif/hari: " + getTarifPerHari());
    }
}
