package pbb.express.model.pesanan;

public class Barang {

    private String jenisBarang;

    private int beratBarang;

    private String lokasiBarang;

    public Barang(String jenisBarang, int beratBarang, String lokasiBarang) {
        this.jenisBarang = jenisBarang;
        this.beratBarang = beratBarang;
        this.lokasiBarang = lokasiBarang;
    }

    public String getJenisBarang() {
        return jenisBarang;
    }

    public int getBeratBarang() {
        return beratBarang;
    }

    public String getLokasiBarang() {
        return lokasiBarang;
    }
}
