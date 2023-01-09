package pbb.express.model.pesanan;

import pbb.express.model.account.Penerima;
import pbb.express.model.account.Pengirim;

import java.time.LocalDate;

public class Pesanan {

    private Pengirim pengirim;

    private Penerima penerima;

    private Barang barang;

    private LocalDate tanggalKirim = LocalDate.now();

    private int biayaKirim;

    private String status;

    private String nomorResi;

    public Pesanan() {}

    public Pesanan(Pengirim pengirim, Penerima penerima, Barang barang, int biayaKirim, String status) {
        this.pengirim = pengirim;
        this.penerima = penerima;
        this.barang = barang;
        this.biayaKirim = biayaKirim;
        this.status = status;
    }

    public void setPengirim(Pengirim pengirim) {
        this.pengirim = pengirim;
    }

    public void setPenerima(Penerima penerima) {
        this.penerima = penerima;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public void setTanggalKirim(LocalDate tanggalKirim) {
        this.tanggalKirim = tanggalKirim;
    }

    public void setBiayaKirim(int biayaKirim) {
        this.biayaKirim = biayaKirim;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setNomorResi(String nomorResi) {
        this.nomorResi = nomorResi;
    }

    public Pengirim getPengirim() {
        return pengirim;
    }

    public Penerima getPenerima() {
        return penerima;
    }

    public Barang getBarang() {
        return barang;
    }

    public LocalDate getTanggalKirim() {
        return tanggalKirim;
    }

    public int getBiayaKirim() {
        return biayaKirim;
    }

    public String getStatus() {
        return status;
    }

    public String getNomorResi() {
        return nomorResi;
    }

    @Override
    public String toString() {
        return nomorResi;
    }
}
