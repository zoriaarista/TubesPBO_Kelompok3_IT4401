package pbb.express.model.account;

import pbb.express.interfaces.Resiable;
import pbb.express.model.pesanan.Pesanan;
import pbb.express.sql.Database;
import pbb.express.views.AdminFrame;
import pbb.express.views.ViewHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import javax.swing.JOptionPane;

public class Admin extends Akun implements Resiable {

    private String nama;

    public Admin(String nama) {
        this.nama = nama;
    }

    @Override
    public String cetakResi() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void login() {
        ViewHelper.openFrame(new AdminFrame());
    }

    public void addData(Pesanan pesanan) {
        Connection connection = Database.getInstance().getConnection();

        try {
            PreparedStatement barangPs = connection.prepareStatement("INSERT INTO barang(jenis_barang, berat_barang, lokasi_barang) VALUE (?, ?, ?)");
            barangPs.setString(1, pesanan.getBarang().getJenisBarang());
            barangPs.setInt(2, pesanan.getBarang().getBeratBarang());
            barangPs.setString(3, pesanan.getBarang().getLokasiBarang());
            barangPs.executeUpdate();
            barangPs.close();

            int pengirimId = 0, penerimaId = 0, barangId = 0;

            PreparedStatement akunPs = connection.prepareStatement("SELECT id FROM akun WHERE nama = ?");
            akunPs.setString(1, pesanan.getPengirim().getNamaPengirim());

            ResultSet rs = akunPs.executeQuery();
            if (rs.next()) {
                pengirimId = rs.getInt("id");
            }else {
                JOptionPane.showMessageDialog(null, "Nama Pengirim tidak ditemukan");
            }

            akunPs.setString(1, pesanan.getPenerima().getNamaPenerima());
            rs = akunPs.executeQuery();
            if (rs.next()) {
                penerimaId = rs.getInt("id");
            }else {
                JOptionPane.showMessageDialog(null, "Nama Penerima tidak ditemukan");
            }

            PreparedStatement barangIdPs = connection.prepareStatement("SELECT id FROM barang WHERE jenis_barang = ? AND berat_barang = ? AND lokasi_barang = ?");
            barangIdPs.setString(1, pesanan.getBarang().getJenisBarang());
            barangIdPs.setInt(2, pesanan.getBarang().getBeratBarang());
            barangIdPs.setString(3, pesanan.getBarang().getLokasiBarang());
            rs = barangIdPs.executeQuery();
            if (rs.next()) {
                barangId = rs.getInt("id");
            }

            PreparedStatement pesananPs = connection.prepareStatement(
                    "INSERT INTO pesanan(pengirim_id, penerima_id, barang_id, tanggal_kirim, biaya_kirim, nomor_resi, status) VALUE (?, ?, ?, ?, ?, ?, ?)");

            pesananPs.setInt(1, pengirimId);
            pesananPs.setInt(2, penerimaId);
            pesananPs.setInt(3, barangId);
            pesananPs.setObject(4, pesanan.getTanggalKirim());
            pesananPs.setInt(5, pesanan.getBiayaKirim());
            pesananPs.setString(6, cetakResi());
            pesananPs.setString(7, pesanan.getStatus());

            pesananPs.executeUpdate();

            pesananPs.close();
            akunPs.close();
            barangIdPs.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteData(Pesanan pesanan) {
        // Dapeting koneksi
        Connection connection = Database.getInstance().getConnection();

        try {
            // Bikin statement, set query dan eksekusi
            PreparedStatement ps = connection.prepareStatement("DELETE FROM pesanan WHERE nomor_resi = ?");
            ps.setString(1, pesanan.getNomorResi());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateData(Pesanan pesanan) {
        // Dapetin koneksi
        Connection connection = Database.getInstance().getConnection();

        try {
            // Bikin statement dan set data, trus di eksekusi
            PreparedStatement ps = connection.prepareStatement("UPDATE pesanan SET status = ? WHERE nomor_resi = ?");
            ps.setString(1, pesanan.getStatus());
            ps.setString(2, pesanan.getNomorResi());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ubahLokasiBarang(Pesanan pesanan) {
        Connection connection = Database.getInstance().getConnection();

        try {
            // Get barang id from database
            PreparedStatement barangPs = connection.prepareStatement("SELECT id FROM barang WHERE jenis_barang = ? AND berat_barang = ? AND lokasi_barang = ?");
            barangPs.setString(1, pesanan.getBarang().getJenisBarang());
            barangPs.setInt(2, pesanan.getBarang().getBeratBarang());

            ResultSet barangRs = barangPs.executeQuery();
            int barangId = barangRs.next() ? barangRs.getInt("id") : 0;

            PreparedStatement ps = connection.prepareStatement("UPDATE barang SET lokasi_barang = ? WHERE id = ?");
            ps.setString(1, pesanan.getBarang().getLokasiBarang());
            ps.setInt(2, barangId);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
