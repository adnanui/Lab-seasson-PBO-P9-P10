// INHERITANCE: Motor adalah Kendaraan, sekaligus bisa diasuransikan
class Motor extends Kendaraan implements BisaDiasuransikan {

    private int kapasitasCC;

    public Motor(String plat, String merek, double tarifPerHari, int kapasitasCC) {
        super(plat, merek, tarifPerHari); // memanggil konstruktor Kendaraan
        this.kapasitasCC = kapasitasCC;
    }

    public int getKapasitasCC() {
        return kapasitasCC;
    }

    // Mengisi abstract method dari Kendaraan
    // Motor: tarif x hari (sudah termasuk helm)
    @Override
    public double hitungBiaya(int hari) {
        return getTarifPerHari() * hari;
    }

    // Mengisi kontrak dari interface BisaDiasuransikan (5% dari biaya sewa)
    @Override
    public double hitungPremi(int hari) {
        return hitungBiaya(hari) * 0.05;
    }

    // OVERRIDING method info() dari Kendaraan
    @Override
    public void info() {
        System.out.println("Motor: " + getMerek() + " | Plat: " + getPlat()
                + " | CC: " + kapasitasCC + " | Tarif/hari: " + getTarifPerHari());
    }
}
