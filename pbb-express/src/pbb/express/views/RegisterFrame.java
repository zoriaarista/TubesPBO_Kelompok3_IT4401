/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pbb.express.views;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pbb.express.sql.Database;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class RegisterFrame extends javax.swing.JFrame {

    /**
     * Creates new form RegisterFrame
     */
    public RegisterFrame() {
        initComponents();
        buttonGroupRegisterJenisAkun.add(radioRegisterKurir);
        buttonGroupRegisterJenisAkun.add(radioRegisterPenerima);
        buttonGroupRegisterJenisAkun.add(radioRegisterPengirim);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupRegisterJenisAkun = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textFieldRegisterUsername = new javax.swing.JTextField();
        textFieldRegisterNama = new javax.swing.JTextField();
        textFieldRegisterNomor = new javax.swing.JTextField();
        textFieldRegisterAlamat = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        radioRegisterKurir = new javax.swing.JRadioButton();
        radioRegisterPenerima = new javax.swing.JRadioButton();
        radioRegisterPengirim = new javax.swing.JRadioButton();
        btnRegisterDaftar = new javax.swing.JButton();
        btnRegisterKeLogin = new javax.swing.JButton();
        btnRegisterReset = new javax.swing.JButton();
        passwordFieldRegisterPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setText("Username");

        jLabel6.setText("Nama");

        jLabel7.setText("Nomor");

        jLabel8.setText("Password");

        jLabel10.setText("Alamat");

        jLabel11.setText("Jenis Akun");

        radioRegisterKurir.setText("Kurir");

        radioRegisterPenerima.setText("Penerima");

        radioRegisterPengirim.setText("Pengirim");

        btnRegisterDaftar.setText("Daftar");
        btnRegisterDaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterDaftarActionPerformed(evt);
            }
        });

        btnRegisterKeLogin.setText("Kembali ke Login");
        btnRegisterKeLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterKeLoginActionPerformed(evt);
            }
        });

        btnRegisterReset.setText("Reset");
        btnRegisterReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegisterDaftar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRegisterReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegisterKeLogin)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(passwordFieldRegisterPassword, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioRegisterKurir, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(radioRegisterPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(radioRegisterPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textFieldRegisterUsername, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldRegisterNama, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldRegisterNomor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldRegisterAlamat, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(40, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldRegisterUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldRegisterNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldRegisterNomor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldRegisterAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordFieldRegisterPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioRegisterKurir)
                    .addComponent(radioRegisterPenerima)
                    .addComponent(radioRegisterPengirim))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegisterKeLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegisterDaftar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegisterReset, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterKeLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterKeLoginActionPerformed
        // TODO add your handling code here:
        ViewHelper.openFrame(new LoginFrame());
    }//GEN-LAST:event_btnRegisterKeLoginActionPerformed

    private void btnRegisterDaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterDaftarActionPerformed
        // TODO add your handling code here:
        String username = textFieldRegisterUsername.getText();
        String nama = textFieldRegisterNama.getText();
        String nomor = textFieldRegisterNomor.getText();
        String alamat = textFieldRegisterAlamat.getText();
        String password = String.valueOf(passwordFieldRegisterPassword.getPassword());
        
        if (username.isEmpty() || nama.isEmpty() || nomor.isEmpty() || alamat.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harap di isi");
            return;
        }
        
        int jenisAkunId;
        
        if (radioRegisterKurir.isSelected()) {
            jenisAkunId = 2;
        }else if (radioRegisterPenerima.isSelected()) {
            jenisAkunId = 3;
        }else if (radioRegisterPengirim.isSelected()) {
            jenisAkunId = 4;
        }else {
            JOptionPane.showMessageDialog(this, "Jenis akun harus dipilih");
            return;
        }
        
        try {
            PreparedStatement ps = Database.getInstance().getConnection()
                    .prepareStatement(
                            "INSERT INTO akun(username, password, nama, nomor, alamat, wilayah_bekerja, jenis_akun_id) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, nama);
            ps.setString(4, nomor);
            ps.setString(5, alamat);
            
            if (jenisAkunId == 2) {
                ps.setString(6, alamat);
            }else {
                ps.setString(6, null);
            }
            ps.setInt(7, jenisAkunId);
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Registrasi berhasil");
            
            textFieldRegisterAlamat.setText("");
            textFieldRegisterNama.setText("");
            textFieldRegisterNomor.setText("");
            textFieldRegisterUsername.setText("");
            passwordFieldRegisterPassword.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(RegisterFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegisterDaftarActionPerformed

    private void btnRegisterResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterResetActionPerformed
        // TODO add your handling code here:
        textFieldRegisterAlamat.setText("");
        textFieldRegisterNama.setText("");
        textFieldRegisterNomor.setText("");
        textFieldRegisterUsername.setText("");
        passwordFieldRegisterPassword.setText("");
        
    }//GEN-LAST:event_btnRegisterResetActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegisterDaftar;
    private javax.swing.JButton btnRegisterKeLogin;
    private javax.swing.JButton btnRegisterReset;
    private javax.swing.ButtonGroup buttonGroupRegisterJenisAkun;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField passwordFieldRegisterPassword;
    private javax.swing.JRadioButton radioRegisterKurir;
    private javax.swing.JRadioButton radioRegisterPenerima;
    private javax.swing.JRadioButton radioRegisterPengirim;
    private javax.swing.JTextField textFieldRegisterAlamat;
    private javax.swing.JTextField textFieldRegisterNama;
    private javax.swing.JTextField textFieldRegisterNomor;
    private javax.swing.JTextField textFieldRegisterUsername;
    // End of variables declaration//GEN-END:variables
}