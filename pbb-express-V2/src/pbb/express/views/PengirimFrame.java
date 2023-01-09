
package pbb.express.views;

import pbb.express.Driver;
import pbb.express.model.account.Pengirim;
import pbb.express.model.pesanan.Pesanan;
import pbb.express.sql.Database;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PengirimFrame extends javax.swing.JFrame {
    
    private DefaultListModel<Pesanan> model;

    /** Creates new form UserFrame */
    public PengirimFrame() {
        initComponents();
        model = (DefaultListModel<Pesanan>) listPengirimDaftarPesanan.getModel();
        
        radioGroupPengirimDialogMetodeBayar.add(radioPengirimDialogMetodeBank);
        radioGroupPengirimDialogMetodeBayar.add(radioPengirimDialogMetodeVA);
        radioGroupPengirimDialogMetodeBayar.add(radioPengirimDialogMetodeDANA);
        radioGroupPengirimDialogMetodeBayar.add(radioPengirimDialogMetodeCOD);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogPengirimBayar = new javax.swing.JDialog();
        labelPengirimDialogTarif = new javax.swing.JLabel();
        btnPengirimDialogBayar = new javax.swing.JButton();
        btnPengirimDialogBatal = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        radioPengirimDialogMetodeBank = new javax.swing.JRadioButton();
        radioPengirimDialogMetodeVA = new javax.swing.JRadioButton();
        radioPengirimDialogMetodeDANA = new javax.swing.JRadioButton();
        radioPengirimDialogMetodeCOD = new javax.swing.JRadioButton();
        radioGroupPengirimDialogMetodeBayar = new javax.swing.ButtonGroup();
        labelPengirimGreeting = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listPengirimDaftarPesanan = new javax.swing.JList<>();
        labelPengirimNamaPenerima = new javax.swing.JLabel();
        labelPengirimAlamat = new javax.swing.JLabel();
        labelPengirimTarif = new javax.swing.JLabel();
        btnPengirimCetakResi = new javax.swing.JButton();
        labelPengirimStatus = new javax.swing.JLabel();
        btnPengirimBayar = new javax.swing.JButton();
        labelPengirimNomorPenerima = new javax.swing.JLabel();
        labelPengirimLokasiBarang = new javax.swing.JLabel();
        btnPengirimLihatWilayah = new javax.swing.JButton();

        dialogPengirimBayar.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogPengirimBayar.setAlwaysOnTop(true);
        dialogPengirimBayar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dialogPengirimBayar.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        dialogPengirimBayar.setType(java.awt.Window.Type.POPUP);

        labelPengirimDialogTarif.setText("Tarif: ");

        btnPengirimDialogBayar.setText("Bayar");
        btnPengirimDialogBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPengirimDialogBayarActionPerformed(evt);
            }
        });

        btnPengirimDialogBatal.setText("Batal");
        btnPengirimDialogBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPengirimDialogBatalActionPerformed(evt);
            }
        });

        jLabel4.setText("Metode Pembayaran: ");

        radioPengirimDialogMetodeBank.setText("Bank");

        radioPengirimDialogMetodeVA.setText("Virtual Account");

        radioPengirimDialogMetodeDANA.setText("DANA");

        radioPengirimDialogMetodeCOD.setText("COD");

        javax.swing.GroupLayout dialogPengirimBayarLayout = new javax.swing.GroupLayout(dialogPengirimBayar.getContentPane());
        dialogPengirimBayar.getContentPane().setLayout(dialogPengirimBayarLayout);
        dialogPengirimBayarLayout.setHorizontalGroup(
            dialogPengirimBayarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogPengirimBayarLayout.createSequentialGroup()
                .addGroup(dialogPengirimBayarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogPengirimBayarLayout.createSequentialGroup()
                        .addGroup(dialogPengirimBayarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dialogPengirimBayarLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(btnPengirimDialogBayar)
                                .addGap(39, 39, 39)
                                .addComponent(btnPengirimDialogBatal))
                            .addGroup(dialogPengirimBayarLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)))
                        .addGap(0, 52, Short.MAX_VALUE))
                    .addGroup(dialogPengirimBayarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(dialogPengirimBayarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPengirimDialogTarif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(dialogPengirimBayarLayout.createSequentialGroup()
                                .addGroup(dialogPengirimBayarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(dialogPengirimBayarLayout.createSequentialGroup()
                                        .addComponent(radioPengirimDialogMetodeBank, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(radioPengirimDialogMetodeVA))
                                    .addGroup(dialogPengirimBayarLayout.createSequentialGroup()
                                        .addComponent(radioPengirimDialogMetodeDANA, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(radioPengirimDialogMetodeCOD, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        dialogPengirimBayarLayout.setVerticalGroup(
            dialogPengirimBayarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogPengirimBayarLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(labelPengirimDialogTarif)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogPengirimBayarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioPengirimDialogMetodeBank)
                    .addComponent(radioPengirimDialogMetodeVA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogPengirimBayarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioPengirimDialogMetodeDANA)
                    .addComponent(radioPengirimDialogMetodeCOD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(dialogPengirimBayarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPengirimDialogBayar)
                    .addComponent(btnPengirimDialogBatal))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        labelPengirimGreeting.setText("Halo, " + ((Pengirim) Driver.getLoggedAccount()).getNamaPengirim());

        jLabel1.setText("Daftar Pesanan");

        listPengirimDaftarPesanan.setModel(new DefaultListModel<>());
        listPengirimDaftarPesanan.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listPengirimDaftarPesananValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listPengirimDaftarPesanan);

        labelPengirimNamaPenerima.setText("Penerima: ");

        labelPengirimAlamat.setText("Alamat:");

        labelPengirimTarif.setText("Tarif:");

        btnPengirimCetakResi.setText("Cetak Resi");
        btnPengirimCetakResi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPengirimCetakResiActionPerformed(evt);
            }
        });

        labelPengirimStatus.setText("Status: ");

        btnPengirimBayar.setText("Bayar");
        btnPengirimBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPengirimBayarActionPerformed(evt);
            }
        });

        labelPengirimNomorPenerima.setText("Nomor Penerima:");

        labelPengirimLokasiBarang.setText("Lokasi Barang:");

        btnPengirimLihatWilayah.setText("Lihat Daftar Wilayah Pengiriman");
        btnPengirimLihatWilayah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPengirimLihatWilayahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPengirimNamaPenerima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelPengirimAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelPengirimTarif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelPengirimStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelPengirimNomorPenerima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelPengirimLokasiBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPengirimCetakResi)
                                .addGap(18, 18, 18)
                                .addComponent(btnPengirimBayar)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelPengirimGreeting, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPengirimLihatWilayah)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPengirimGreeting)
                    .addComponent(btnPengirimLihatWilayah))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelPengirimNamaPenerima)
                        .addGap(18, 18, 18)
                        .addComponent(labelPengirimNomorPenerima)
                        .addGap(18, 18, 18)
                        .addComponent(labelPengirimAlamat)
                        .addGap(18, 18, 18)
                        .addComponent(labelPengirimTarif)
                        .addGap(18, 18, 18)
                        .addComponent(labelPengirimStatus)
                        .addGap(18, 18, 18)
                        .addComponent(labelPengirimLokasiBarang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPengirimCetakResi)
                            .addComponent(btnPengirimBayar))
                        .addGap(34, 34, 34))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        ViewHelper.openFrame(new LoginFrame());
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        ViewHelper.tampilkanDaftarPesanan(model);
    }//GEN-LAST:event_formWindowOpened

    private void listPengirimDaftarPesananValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listPengirimDaftarPesananValueChanged
        // TODO add your handling code here:
        // Dapetin pesanan yang lagi dipilih
        Pesanan pesanan = listPengirimDaftarPesanan.getSelectedValue();

        // Cek jika pesanan tidak kosong
        if(pesanan != null) {
            // Set label dengan data dari pesanan
            labelPengirimAlamat.setText("Alamat: " + pesanan.getPenerima().getAlamat());
            labelPengirimNamaPenerima.setText("Nama Penerima: " + pesanan.getPenerima().getNamaPenerima());
            labelPengirimNomorPenerima.setText("Nomor Penerima: " + pesanan.getPenerima().getNomor());
            labelPengirimTarif.setText("Tarif: " + pesanan.getBiayaKirim()); // Cek tarif
            labelPengirimStatus.setText("Status: " + pesanan.getStatus());
            labelPengirimLokasiBarang.setText("Lokasi Barang: " + pesanan.getBarang().getLokasiBarang());

            try {
                // Bikin statement
                PreparedStatement ps = Database.getInstance().getConnection().prepareStatement("SELECT * FROM pembayaran WHERE nomor_resi = ?");

                // Set data ke query
                ps.setString(1, pesanan.getNomorResi());

                // Eksekusi query
                ResultSet rs = ps.executeQuery();
                
                // Cek jika hasil eksekusi ada data
                if (rs.next()) {
                    btnPengirimBayar.setEnabled(false);
                    labelPengirimTarif.setText("Tarif: " + pesanan.getBiayaKirim() + " (Sudah Dibayar)");
                } else {
                    btnPengirimBayar.setEnabled(true);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }
    }//GEN-LAST:event_listPengirimDaftarPesananValueChanged

    private void btnPengirimBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPengirimBayarActionPerformed
        // TODO add your handling code here:
        labelPengirimDialogTarif.setText("Tarif: " + listPengirimDaftarPesanan.getSelectedValue().getBiayaKirim());
        
        dialogPengirimBayar.pack();
        dialogPengirimBayar.setVisible(true);
    }//GEN-LAST:event_btnPengirimBayarActionPerformed

    private void btnPengirimDialogBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPengirimDialogBatalActionPerformed
        // TODO add your handling code here:
        dialogPengirimBayar.dispose();
    }//GEN-LAST:event_btnPengirimDialogBatalActionPerformed

    private void btnPengirimDialogBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPengirimDialogBayarActionPerformed
        // TODO add your handling code here:
        
        // Ambil objek pesanan
        Pesanan pesanan = listPengirimDaftarPesanan.getSelectedValue();
        String metodeBayar = null;

        // Cek pilihan metode pembayaran
        if (radioPengirimDialogMetodeBank.isSelected()) {
            metodeBayar = "Bank";
        } else if (radioPengirimDialogMetodeDANA.isSelected()) {
            metodeBayar = "DANA";
        } else if (radioPengirimDialogMetodeVA.isSelected()) {
            metodeBayar = "Virtual Account";
        } else if(radioPengirimDialogMetodeCOD.isSelected()) {
            metodeBayar = "COD";
        }

        // Cek metodenya valid
        if (metodeBayar == null) {
            JOptionPane.showMessageDialog(this, "Pilih metode pembayaran");
            return;
        }

        // Pilih metode pembayaran
        ((Pengirim) Driver.getLoggedAccount()).pilihMetodePembayaran(pesanan.getNomorResi(), metodeBayar);

        JOptionPane.showMessageDialog(dialogPengirimBayar, "Pembayaran Berhasil");
        dialogPengirimBayar.dispose();
    }//GEN-LAST:event_btnPengirimDialogBayarActionPerformed

    private void btnPengirimCetakResiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPengirimCetakResiActionPerformed
        // TODO add your handling code here:
        ((Pengirim) Driver.getLoggedAccount()).cetakResi();
        JOptionPane.showMessageDialog(this, "Resi telah dicetak");
    }//GEN-LAST:event_btnPengirimCetakResiActionPerformed

    private void btnPengirimLihatWilayahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPengirimLihatWilayahActionPerformed
        // TODO add your handling code here:
        ((Pengirim) Driver.getLoggedAccount()).temukanLokasiPengiriman();
    }//GEN-LAST:event_btnPengirimLihatWilayahActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPengirimBayar;
    private javax.swing.JButton btnPengirimCetakResi;
    private javax.swing.JButton btnPengirimDialogBatal;
    private javax.swing.JButton btnPengirimDialogBayar;
    private javax.swing.JButton btnPengirimLihatWilayah;
    private javax.swing.JDialog dialogPengirimBayar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPengirimAlamat;
    private javax.swing.JLabel labelPengirimDialogTarif;
    private javax.swing.JLabel labelPengirimGreeting;
    private javax.swing.JLabel labelPengirimLokasiBarang;
    private javax.swing.JLabel labelPengirimNamaPenerima;
    private javax.swing.JLabel labelPengirimNomorPenerima;
    private javax.swing.JLabel labelPengirimStatus;
    private javax.swing.JLabel labelPengirimTarif;
    private javax.swing.JList<Pesanan> listPengirimDaftarPesanan;
    private javax.swing.ButtonGroup radioGroupPengirimDialogMetodeBayar;
    private javax.swing.JRadioButton radioPengirimDialogMetodeBank;
    private javax.swing.JRadioButton radioPengirimDialogMetodeCOD;
    private javax.swing.JRadioButton radioPengirimDialogMetodeDANA;
    private javax.swing.JRadioButton radioPengirimDialogMetodeVA;
    // End of variables declaration//GEN-END:variables

}
