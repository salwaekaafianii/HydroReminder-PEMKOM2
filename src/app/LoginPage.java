package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import db.DatabaseConnection;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import utils.PasswordUtil;

/**
 *
 * @author salwa eka
 */
public class LoginPage extends javax.swing.JFrame {

    private Locale Locale;
    private ResourceBundle rb;

    public LoginPage() {
        initComponents();
        setLocationRelativeTo(null);
        applyLanguage();

    }

    //internationalization (i8n)
    //fungsi untuk menerapkan bahasa berdasarkan pilihan pengguna
    private void applyLanguage() {
        int lang = ComboBoxBahasa.getSelectedIndex();
        String language = "en";
        String country = "US";

        switch (lang) {
            case 1:
                language = "id";
                country = "ID";
                break;
            case 0:
            default:
                language = "en";
                country = "US";
                break;
        }

        Locale = new Locale(language, country);
        rb = ResourceBundle.getBundle("internationalization.Bundle", Locale);

        setTitle(rb.getString("LoginPage.title"));
        lblChooseLanguage.setText(rb.getString("LoginPage.lblChooseLanguage.text"));
        labelnama.setText(rb.getString("LoginPage.labelnama.text"));
        labelpassword.setText(rb.getString("LoginPage.labelpassword.text"));
        ButtonLogin.setText(rb.getString("LoginPage.ButtonLogin.text"));
        labelDhaa.setText(rb.getString("LoginPage.labelDhaa.text"));
        ButtonSignUp.setText(rb.getString("LoginPage.ButtonSignUp.text"));
        Title.setText(rb.getString("LoginPage.Title.text"));

        ComboBoxBahasa.removeAllItems();
        for (int i = 0; i < 2; i++) {
            ComboBoxBahasa.addItem(rb.getString("cmbChooseLanguage." + i));
        }
        ComboBoxBahasa.setSelectedIndex(lang);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        labelnama = new javax.swing.JLabel();
        Nama = new javax.swing.JTextField();
        labelpassword = new javax.swing.JLabel();
        ButtonLogin = new javax.swing.JButton();
        lblChooseLanguage = new javax.swing.JLabel();
        ComboBoxBahasa = new javax.swing.JComboBox<>();
        labelDhaa = new javax.swing.JLabel();
        ButtonSignUp = new javax.swing.JButton();
        Password = new javax.swing.JPasswordField();
        Left = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        Right.setBackground(new java.awt.Color(102, 204, 255));
        Right.setPreferredSize(new java.awt.Dimension(400, 500));

        Title.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("LOGIN");
        Title.setToolTipText("");

        labelnama.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelnama.setForeground(new java.awt.Color(255, 255, 255));
        labelnama.setText("Username");

        Nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaActionPerformed(evt);
            }
        });

        labelpassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelpassword.setForeground(new java.awt.Color(255, 255, 255));
        labelpassword.setText("Password");

        ButtonLogin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ButtonLogin.setText("Login");
        ButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLoginActionPerformed(evt);
            }
        });

        lblChooseLanguage.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblChooseLanguage.setForeground(new java.awt.Color(255, 255, 255));
        lblChooseLanguage.setText("Choose Language : ");

        ComboBoxBahasa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ComboBoxBahasa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English", "Indonesia" }));
        ComboBoxBahasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxBahasaActionPerformed(evt);
            }
        });

        labelDhaa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelDhaa.setForeground(new java.awt.Color(255, 255, 255));
        labelDhaa.setText("Don't have an account? ");

        ButtonSignUp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ButtonSignUp.setForeground(new java.awt.Color(255, 51, 51));
        ButtonSignUp.setText("Sign Up");
        ButtonSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSignUpActionPerformed(evt);
            }
        });

        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ButtonLogin)
                            .addComponent(labelpassword, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(labelnama, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, RightLayout.createSequentialGroup()
                                .addComponent(labelDhaa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonSignUp))
                            .addComponent(Password, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                        .addComponent(lblChooseLanguage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(Title)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblChooseLanguage))
                .addGap(67, 67, 67)
                .addComponent(Title)
                .addGap(17, 17, 17)
                .addComponent(labelnama)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nama, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelpassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDhaa)
                    .addComponent(ButtonSignUp))
                .addGap(46, 46, 46))
        );

        jPanel1.add(Right);
        Right.setBounds(400, 0, 400, 500);

        Left.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel5.setText("HYDRO REMINDER");

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel6))
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel5)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(198, 198, 198))
        );

        jPanel1.add(Left);
        Left.setBounds(0, 0, 400, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaActionPerformed

    }//GEN-LAST:event_NamaActionPerformed

    private void ButtonSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSignUpActionPerformed
        SignUp signUpFrame = new SignUp(Locale);
        signUpFrame.setVisible(true);
        signUpFrame.pack();
        signUpFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_ButtonSignUpActionPerformed

    private void ComboBoxBahasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxBahasaActionPerformed
        applyLanguage();
    }//GEN-LAST:event_ComboBoxBahasaActionPerformed

    private void ButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLoginActionPerformed
        String nama = Nama.getText();
        String password = new String(Password.getPassword());

        if (nama.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama dan kata sandi harus diisi!");
            return;
        }

        //cryptography
        String hashedPassword = PasswordUtil.hashPassword(password);

        //database (JDBC)
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE name = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nama);
            stmt.setString(2, hashedPassword);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Selamat datang, " + nama + "!");
                InputData inputdata = new InputData(nama);
                inputdata.setVisible(true);
                inputdata.setLocationRelativeTo(null);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Nama atau kata sandi salah!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal login: " + e.getMessage());
        }
    }//GEN-LAST:event_ButtonLoginActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed

    }//GEN-LAST:event_PasswordActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonLogin;
    private javax.swing.JButton ButtonSignUp;
    private javax.swing.JComboBox<String> ComboBoxBahasa;
    private javax.swing.JPanel Left;
    private javax.swing.JTextField Nama;
    private javax.swing.JPasswordField Password;
    private javax.swing.JPanel Right;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelDhaa;
    private javax.swing.JLabel labelnama;
    private javax.swing.JLabel labelpassword;
    private javax.swing.JLabel lblChooseLanguage;
    // End of variables declaration//GEN-END:variables
}
