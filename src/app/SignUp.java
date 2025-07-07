package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import db.DatabaseConnection;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import utils.PasswordUtil;

public class SignUp extends javax.swing.JFrame {
    private Locale locale;
    private ResourceBundle rb;

    public SignUp() {
        this(new Locale("en", "US"));
        initComponents();
        setLocationRelativeTo(null);
    }

    public SignUp(Locale locale) {
        this.locale = locale;
        this.rb = ResourceBundle.getBundle("internationalization.Bundle", locale);
        initComponents();
        setLocationRelativeTo(null);
        applyLanguage();
    }

    private void applyLanguage() {
        setTitle(rb.getString("SignUp.title"));
        Title.setText(rb.getString("SignUp.Title.text"));
        labelnama.setText(rb.getString("SignUp.labelnama.text"));
        labelemail.setText(rb.getString("SignUp.labelemail.text"));
        labelpassword.setText(rb.getString("SignUp.labelpassword.text"));
        ButtonSignUp.setText(rb.getString("SignUp.ButtonSignUp.text"));
        jLabel4.setText(rb.getString("SignUp.jLabel4.text"));
        ButtonLogin.setText(rb.getString("SignUp.ButtonLogin.text"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        ButtonLogin = new javax.swing.JButton();
        Title = new javax.swing.JLabel();
        labelnama = new javax.swing.JLabel();
        Nama = new javax.swing.JTextField();
        labelemail = new javax.swing.JLabel();
        EmailSignUp = new javax.swing.JTextField();
        ButtonSignUp = new javax.swing.JButton();
        labelpassword = new javax.swing.JLabel();
        PasswordSignUp = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel7.setText("HYDRO REMINDER");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel7)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(198, 198, 198))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 400, 500);

        jPanel3.setBackground(new java.awt.Color(102, 204, 255));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Already have an account?");

        ButtonLogin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ButtonLogin.setForeground(new java.awt.Color(255, 51, 51));
        ButtonLogin.setText("Login");
        ButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLoginActionPerformed(evt);
            }
        });

        Title.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setText("SIGN UP");
        Title.setToolTipText("");

        labelnama.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelnama.setForeground(new java.awt.Color(255, 255, 255));
        labelnama.setText("Full Name");

        Nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaActionPerformed(evt);
            }
        });

        labelemail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelemail.setForeground(new java.awt.Color(255, 255, 255));
        labelemail.setText("Email");

        EmailSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailSignUpActionPerformed(evt);
            }
        });

        ButtonSignUp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ButtonSignUp.setText("Sign Up");
        ButtonSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSignUpActionPerformed(evt);
            }
        });

        labelpassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelpassword.setForeground(new java.awt.Color(255, 255, 255));
        labelpassword.setText("Password ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(Title)
                        .addGap(134, 134, 134))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonLogin))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(EmailSignUp, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelemail, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Nama, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelnama, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(labelpassword)
                                    .addGap(223, 223, 223))
                                .addComponent(ButtonSignUp)
                                .addComponent(PasswordSignUp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(46, 46, 46))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(Title)
                .addGap(26, 26, 26)
                .addComponent(labelnama)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nama, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelemail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmailSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelpassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonSignUp)
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ButtonLogin))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(400, 0, 400, 500);

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

    private void ButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLoginActionPerformed
        LoginPage LoginFrame = new LoginPage();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_ButtonLoginActionPerformed

    private void NamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaActionPerformed

    }//GEN-LAST:event_NamaActionPerformed

    private void EmailSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailSignUpActionPerformed

    }//GEN-LAST:event_EmailSignUpActionPerformed

    private void ButtonSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSignUpActionPerformed
        String name = Nama.getText();
        String email = EmailSignUp.getText();
        String password = PasswordSignUp.getText();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!");
            return;
        }

        String hashedPassword = PasswordUtil.hashPassword(password);

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, hashedPassword);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Pendaftaran berhasil!");
                new LoginPage().setVisible(true);
                this.dispose();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Pendaftaran gagal: " + e.getMessage());
        }
    }//GEN-LAST:event_ButtonSignUpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonLogin;
    private javax.swing.JButton ButtonSignUp;
    private javax.swing.JTextField EmailSignUp;
    private javax.swing.JTextField Nama;
    private javax.swing.JPasswordField PasswordSignUp;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelemail;
    private javax.swing.JLabel labelnama;
    private javax.swing.JLabel labelpassword;
    // End of variables declaration//GEN-END:variables
}
