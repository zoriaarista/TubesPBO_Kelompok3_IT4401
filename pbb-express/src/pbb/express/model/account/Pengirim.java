package pbb.express.model.account;

import pbb.express.interfaces.Resiable;
import pbb.express.model.pesanan.Pesanan;
import pbb.express.sql.Database;
import pbb.express.views.PengirimFrame;
import pbb.express.views.ViewHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Pengirim extends Akun implements Resiable {

    private String nama;

    private String alamat;

    private String nomor;

    public Pengirim(String nama, String alamat, String nomor) {
        this.nama = nama;
        this.alamat = alamat;
        this.nomor = nomor;
    }

    public Pengirim(String nama) {
        this.nama = nama;

        try {
            Connection connection = Database.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(
                            "SELECT * FROM akun JOIN jenis_akun ON akun.jenis_akun_id = jenis_akun.id " +
                                    "WHERE nama = ? AND jenis_akun.jenis = 'Pengirim'");
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
        ViewHelper.openFrame(new PengirimFrame());
    }

    @Override
    public String cetakResi() {
        return UUID.randomUUID().toString();
    }

    public void cekTarif(Pesanan pesanan) {
        try {
            PreparedStatement ps = Database.getInstance().getConnection().prepareStatement("SELECT biaya_kirim FROM pesanan WHERE nomor_resi = ?");

            ps.setString(1, pesanan.getNomorResi());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Biaya kirim: " + rs.getInt("biaya_kirim"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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

    public void temukanLokasiPengiriman() {
        try {
            PreparedStatement ps = Database.getInstance().getConnection().prepareStatement("SELECT wilayah_bekerja FROM akun WHERE jenis_akun_id = 2");

            ResultSet rs = ps.executeQuery();
            System.out.println("Lokasi pengiriman tersedia: ");
            while (rs.next()) {
                System.out.println("- " + rs.getString("wilayah_bekerja"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void pilihMetodePembayaran(String resi, String metodeBayar) {
        try {
            PreparedStatement ps = Database.getInstance().getConnection().prepareStatement("INSERT INTO pembayaran (nomor_resi, metode) VALUE (?, ?)");

            ps.setString(1, resi);
            ps.setString(2, metodeBayar);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getNamaPengirim() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNomor() {
        return nomor;
    }
}
