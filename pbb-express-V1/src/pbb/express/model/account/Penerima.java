package pbb.express.model.account;

import pbb.express.model.pesanan.Pesanan;
import pbb.express.sql.Database;
import pbb.express.views.PenerimaFrame;
import pbb.express.views.ViewHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Penerima extends Akun{

    private String nama = null;

    private String alamat = null;

    private String nomor = null;

    public Penerima(String nama, String alamat, String nomor) {
        this.nama = nama;
        this.alamat = alamat;
        this.nomor = nomor;
    }

    public Penerima(String nama) {
        this.nama = nama;

        try {
            PreparedStatement ps = Database.getInstance().getConnection()
                    .prepareStatement(
                            "SELECT * FROM akun JOIN jenis_akun ON akun.jenis_akun_id = jenis_akun.id " +
                                    "WHERE nama = ? AND jenis_akun.jenis = 'Penerima'");
            ps.setString(1, nama);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                this.alamat = rs.getString("alamat");
                this.nomor = rs.getString("nomor");
            }

            ps.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void login() {
        ViewHelper.openFrame(new PenerimaFrame());
    }

    public void cekLokasiBarang(Pesanan pesanan) {
        try {
            PreparedStatement ps = Database.getInstance().getConnection().prepareStatement("SELECT b.lokasi_barang FROM pesanan JOIN barang b ON pesanan.barang_id = b.id WHERE nomor_resi = ?");

            ps.setString(1, pesanan.getNomorResi());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Lokasi barang: " + rs.getString("lokasi_barang"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getNamaPenerima() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNomor() {
        return nomor;
    }
}
