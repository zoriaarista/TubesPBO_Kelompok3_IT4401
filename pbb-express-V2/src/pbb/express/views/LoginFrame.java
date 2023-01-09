
package pbb.express.views;

import pbb.express.Driver;
import pbb.express.model.account.*;
import pbb.express.sql.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textFieldLoginUsername = new javax.swing.JTextField();
        labelLoginUsername = new javax.swing.JLabel();
        labelLoginPassword = new javax.swing.JLabel();
        btnLoginLogin = new javax.swing.JButton();
        passwordFieldLoginPassword = new javax.swing.JPasswordField();
        btnLoginKeRegister = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelLoginUsername.setText("Username");

        labelLoginPassword.setText("Password");

        btnLoginLogin.setText("Login");
        btnLoginLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginLoginActionPerformed(evt);
            }
        });

        btnLoginKeRegister.setText("Halaman Register");
        btnLoginKeRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginKeRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLoginLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLoginKeRegister))
                    .addComponent(textFieldLoginUsername)
                    .addComponent(labelLoginPassword)
                    .addComponent(labelLoginUsername)
                    .addComponent(passwordFieldLoginPassword))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(labelLoginUsername)
                .addGap(18, 18, 18)
                .addComponent(textFieldLoginUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(labelLoginPassword)
                .addGap(18, 18, 18)
                .addComponent(passwordFieldLoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoginLogin)
                    .addComponent(btnLoginKeRegister))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginLoginActionPerformed
        // TODO add your handling code here:
        
        String inputUsername = textFieldLoginUsername.getText();
        char[] inputPassword = passwordFieldLoginPassword.getPassword();

        try {
            PreparedStatement stmt = Database.getInstance().getConnection().prepareStatement("" +
                    "SELECT username, password, nama, nomor, alamat, wilayah_bekerja, jenis_akun.jenis\n" +
                    "FROM akun JOIN jenis_akun ON jenis_akun.id = akun.jenis_akun_id\n" +
                    "WHERE username = ? AND password = ?");
            stmt.setString(1, inputUsername);
            stmt.setString(2, String.valueOf(inputPassword));

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Akun akun = null;

                String username = rs.getString("username");
                String password = rs.getString("password");
                String nama = rs.getString("nama");
                String nomor = rs.getString("nomor");
                String alamat = rs.getString("alamat");
                String jenis = rs.getString("jenis");
                String wilayahBekerja = rs.getString("wilayah_bekerja");

                if (jenis.equalsIgnoreCase("admin")) {
                    akun = new Admin(nama);
                }else if (jenis.equalsIgnoreCase("pengirim")) {
                    akun = new Pengirim(nama, nomor, alamat);
                }else if (jenis.equalsIgnoreCase("penerima")){
                    akun = new Penerima(nama, nomor, alamat);
                }else if (jenis.equalsIgnoreCase("kurir")){
                    akun = new Kurir(nama, nomor, wilayahBekerja);
                }

                if (akun == null) {
                    JOptionPane.showMessageDialog(this, "Jenis akun belum didukung");
                    return;
                }
                
                Driver.setAccount(akun);

                akun.setPassword(password);
                akun.setUsername(username);
                akun.login();
            } else {
                JOptionPane.showMessageDialog(this, "Username atau password salah");
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }//GEN-LAST:event_btnLoginLoginActionPerformed

    private void btnLoginKeRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginKeRegisterActionPerformed
        // TODO add your handling code here:
        ViewHelper.openFrame(new RegisterFrame());
    }//GEN-LAST:event_btnLoginKeRegisterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginKeRegister;
    private javax.swing.JButton btnLoginLogin;
    private javax.swing.JLabel labelLoginPassword;
    private javax.swing.JLabel labelLoginUsername;
    private javax.swing.JPasswordField passwordFieldLoginPassword;
    private javax.swing.JTextField textFieldLoginUsername;
    // End of variables declaration//GEN-END:variables
}
