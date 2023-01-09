package pbb.express.views;

import pbb.express.model.account.Penerima;
import pbb.express.model.account.Pengirim;
import pbb.express.model.pesanan.Barang;
import pbb.express.model.pesanan.Pesanan;
import pbb.express.sql.Database;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewHelper {

    private static JFrame currentFrame = null;
    
    public static void openFrame(JFrame newFrame, JFrame oldFrame) {
        if (oldFrame != null) oldFrame.dispose();
        newFrame.setVisible(true);

        currentFrame = newFrame;
    }

    public static void openFrame(JFrame newFrame) {
        openFrame(newFrame, currentFrame);
    }

    public static void tampilkanDaftarPesanan(DefaultListModel<Pesanan> model) {
        model.clear();

        try {
            PreparedStatement ps = Database.getInstance().getConnection().prepareStatement("SELECT * FROM pesanan");
            PreparedStatement barangPs = Database.getInstance().getConnection().prepareStatement("SELECT * FROM barang WHERE id = ?");
            PreparedStatement akunPs = Database.getInstance().getConnection().prepareStatement("SELECT * FROM akun WHERE id = ?");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pengirim pengirim = null;
                Penerima penerima = null;
                Barang barang = null;

                akunPs.setString(1, rs.getString("penerima_id"));
                ResultSet penerimaRs = akunPs.executeQuery();
                if (penerimaRs.next()) {
                    penerima = new Penerima(penerimaRs.getString("nama"), penerimaRs.getString("alamat"), penerimaRs.getString("nomor"));
                }

                akunPs.setString(1, rs.getString("pengirim_id"));
                ResultSet pengirimRs = akunPs.executeQuery();
                if (pengirimRs.next()) {
                    pengirim = new Pengirim(pengirimRs.getString("nama"), pengirimRs.getString("alamat"), pengirimRs.getString("nomor"));
                }

                barangPs.setString(1, rs.getString("barang_id"));
                ResultSet barangRs = barangPs.executeQuery();
                if (barangRs.next()) {
                    barang = new Barang(barangRs.getString("jenis_barang"), barangRs.getInt("berat_barang"), barangRs.getString("lokasi_barang"));
                }

                Pesanan pesanan = new Pesanan();
                pesanan.setBarang(barang);
                pesanan.setPenerima(penerima);
                pesanan.setPengirim(pengirim);
                pesanan.setBiayaKirim(rs.getInt("biaya_kirim"));
                pesanan.setStatus(rs.getString("status"));
                pesanan.setNomorResi(rs.getString("nomor_resi"));
                pesanan.setTanggalKirim(rs.getDate("tanggal_kirim").toLocalDate());

                model.addElement(pesanan);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
