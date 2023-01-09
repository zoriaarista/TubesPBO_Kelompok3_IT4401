package pbb.express.model.account;

import pbb.express.model.pesanan.Pesanan;
import pbb.express.sql.Database;
import pbb.express.views.KurirFrame;
import pbb.express.views.ViewHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Kurir extends Akun{

    private String nama;

    private String nomor;

    private String wilayahBekerja;

    public Kurir(String nama, String nomor, String wilayahBekerja) {
        this.nama = nama;
        this.nomor = nomor;
        this.wilayahBekerja = wilayahBekerja;
    }

    @Override
    public void login() {
        ViewHelper.openFrame(new KurirFrame());
    }

    public String cekAlamat(Pesanan pesanan){
        return pesanan.getPenerima().getAlamat();
    }

    public String cekMetodePembayaran(Pesanan pesanan){
        try {
            // Bikin statement buat ambil data
            PreparedStatement ps = Database.getInstance().getConnection()
                    .prepareStatement("SELECT * FROM pembayaran WHERE nomor_resi = ?");

            ps.setString(1, pesanan.getNomorResi());
            ResultSet rs = ps.executeQuery();
            
            // Kembaliin metode pembayaran
            return rs.next() ? "Metode Pembayaran: " + rs.getString("metode") : "Belum ada pembayaran";
        } catch (SQLException ex) {
            Logger.getLogger(KurirFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Belum ada pembayaran";
    }

    // Konfirmasi barang telah sampai
    public void cekBarangSampai(Pesanan pesanan) {
        pesanan.setStatus("Diterima");

        try {
            PreparedStatement ps = Database.getInstance().getConnection().prepareStatement("UPDATE pesanan SET status = ? WHERE nomor_resi = ?");
            ps.setString(1, pesanan.getStatus());
            ps.setString(2, pesanan.getNomorResi());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getWilayahBekerja() {
        return wilayahBekerja;
    }
}
