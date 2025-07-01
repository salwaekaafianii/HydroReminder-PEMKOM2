package app;

import db.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author salwa eka
 */
public class InputData extends javax.swing.JFrame {

    private int kebutuhanAir;

    public InputData() {
        initComponents();
        jLabel8.setText("");
        setLocationRelativeTo(null);
        setupSpinners();
        setupFocusBeratBadan();
        ButtonMulai.setEnabled(false);
    }

    public InputData(String name) {
        initComponents();
        jLabel2.setText("Selamat datang di Hydro Reminder, " + name + "!");
        jLabel8.setText("");
        setupSpinners();
        setupFocusBeratBadan();
        ButtonMulai.setEnabled(false);
        loadDataTerakhir();
    }

    private void setupSpinners() {
        SpinnerDateModel modelBangun = new SpinnerDateModel();
        SpinnerBangun.setModel(modelBangun);
        JSpinner.DateEditor editorBangun = new JSpinner.DateEditor(SpinnerBangun, "HH:mm");
        SpinnerBangun.setEditor(editorBangun);

        SpinnerDateModel modelTidur = new SpinnerDateModel();
        SpinnerTidur.setModel(modelTidur);
        JSpinner.DateEditor editorTidur = new JSpinner.DateEditor(SpinnerTidur, "HH:mm");
        SpinnerTidur.setEditor(editorTidur);
    }

    private void setupFocusBeratBadan() {
        BeratBadan.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                String input = BeratBadan.getText().trim();
                if (!input.toLowerCase().endsWith("kg") && !input.isEmpty()) {
                    BeratBadan.setText(input + " kg");
                }
            }

            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                String input = BeratBadan.getText().trim();
                if (input.toLowerCase().endsWith("kg")) {
                    BeratBadan.setText(input.substring(0, input.length() - 3).trim());
                }
            }
        });
    }

    private void simpanDataKeDatabase() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO input_data (gender, level_aktivitas, waktu_bangun, waktu_tidur, berat_badan, usia, kebutuhan_air) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, ComboBoxGender.getSelectedItem().toString());
            ps.setString(2, ComboBoxLevelActiviitas.getSelectedItem().toString());
            java.util.Date waktuBangun = (java.util.Date) SpinnerBangun.getValue();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm");
            String strBangun = sdf.format(waktuBangun);

            java.util.Date waktuTidur = (java.util.Date) SpinnerTidur.getValue();
            String strTidur = sdf.format(waktuTidur);

            ps.setString(3, strBangun);
            ps.setString(4, strTidur);

            String beratText = BeratBadan.getText().trim().replace(" kg", "");
            double berat = Double.parseDouble(beratText);
            ps.setDouble(5, berat);

            int usia = Integer.parseInt(TextFieldUsia.getText().trim());
            ps.setInt(6, usia);
            ps.setInt(7, kebutuhanAir);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Data berhasil disimpan ke database.");
            } else {
                System.out.println("Gagal menyimpan data.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error menyimpan data: " + e.getMessage());
        }
    }

    private void loadDataTerakhir() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM input_data ORDER BY id DESC LIMIT 1";
            PreparedStatement ps = conn.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ComboBoxGender.setSelectedItem(rs.getString("gender"));
                ComboBoxLevelActiviitas.setSelectedItem(rs.getString("level_aktivitas"));

                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm");
                SpinnerBangun.setValue(sdf.parse(rs.getString("waktu_bangun")));
                SpinnerTidur.setValue(sdf.parse(rs.getString("waktu_tidur")));

                BeratBadan.setText(rs.getDouble("berat_badan") + " kg");
                TextFieldUsia.setText(String.valueOf(rs.getInt("usia")));

                kebutuhanAir = rs.getInt("kebutuhan_air");
                jLabel8.setText("Tubuh Anda membutuhkan " + kebutuhanAir + " ml air hari ini. Ayo, mulai dengan minuman pertamamu sekarang!");
                ButtonMulai.setEnabled(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data terakhir: " + e.getMessage());
        }
    }

    //generic
    //<T extends Number> artinya parameter 'berat' bisa berupa angka jenis apapun
    //(seperti Integer, Double, Float, dll)
    public <T extends Number> int hitungKebutuhanAir(T berat, double faktor) {
        return (int) (berat.doubleValue() * faktor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ComboBoxGender = new javax.swing.JComboBox<>();
        ComboBoxLevelActiviitas = new javax.swing.JComboBox<>();
        SpinnerBangun = new javax.swing.JSpinner();
        HitungMl = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        SpinnerTidur = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        BeratBadan = new javax.swing.JTextField();
        ButtonMulai = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TextFieldUsia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/timer.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Selamat datang diHydro Reminder, [Name]!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(30, 30, 30))
        );

        ComboBoxGender.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ComboBoxGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-Laki", "Perempuan" }));

        ComboBoxLevelActiviitas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ComboBoxLevelActiviitas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tidak Aktif", "Aktif Ringan", "Aktif Sedang", "Sangat Aktif" }));

        SpinnerBangun.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        HitungMl.setBackground(new java.awt.Color(102, 204, 255));
        HitungMl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        HitungMl.setForeground(new java.awt.Color(255, 255, 255));
        HitungMl.setText("Menghitung");
        HitungMl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HitungMlActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Berat Badan");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Identitas Gender");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Tingkat Aktivitas ");

        SpinnerTidur.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Waktu Bangun");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Waktu Tidur");

        BeratBadan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        BeratBadan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeratBadanActionPerformed(evt);
            }
        });

        ButtonMulai.setBackground(new java.awt.Color(102, 204, 255));
        ButtonMulai.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ButtonMulai.setForeground(new java.awt.Color(255, 255, 255));
        ButtonMulai.setText("Mulai");
        ButtonMulai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonMulaiActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel8.setText("Tubuh Anda membutuhkan [kebutuhanAir] ml air hari ini. Ayo, mulai dengan minuman pertamamu sekarang!");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Usia");

        TextFieldUsia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        TextFieldUsia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldUsiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ComboBoxGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(BeratBadan, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9)
                            .addComponent(TextFieldUsia, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(SpinnerBangun, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                .addComponent(SpinnerTidur))
                            .addComponent(jLabel7)
                            .addComponent(ComboBoxLevelActiviitas, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(164, 164, 164))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(HitungMl, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonMulai, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(240, 240, 240))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(93, 93, 93))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BeratBadan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxLevelActiviitas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextFieldUsia, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(SpinnerBangun))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SpinnerTidur, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxGender, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HitungMl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonMulai, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BeratBadanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeratBadanActionPerformed

    }//GEN-LAST:event_BeratBadanActionPerformed

    private void ButtonMulaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMulaiActionPerformed
        if (kebutuhanAir <= 0) {
            JOptionPane.showMessageDialog(this, "Silakan hitung kebutuhan air terlebih dahulu.");
            return;
        }
        simpanDataKeDatabase();
        Progress progressFrame = new Progress(kebutuhanAir);
        progressFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ButtonMulaiActionPerformed

    private void HitungMlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HitungMlActionPerformed
        try {
            int usia = Integer.parseInt(TextFieldUsia.getText().trim());
            String gender = ComboBoxGender.getSelectedItem().toString();
            String level = ComboBoxLevelActiviitas.getSelectedItem().toString();

            double kebutuhanDasar;

            if (usia <= 12) {
                kebutuhanDasar = 1250; // Anak-anak (1.000–1.500 mL rata-rata)
            } else if (usia <= 17) {
                kebutuhanDasar = 1750; // Remaja (1.500–2.000 mL rata-rata)
            } else if (usia >= 60) {
                kebutuhanDasar = 1750; // Lansia (1.500–2.000 mL rata-rata)
            } else {
                if (gender.equalsIgnoreCase("Laki-Laki")) {
                    kebutuhanDasar = 2500; // Pria Dewasa
                } else {
                    kebutuhanDasar = 2000; // Wanita Dewasa
                }
            }

            double penyesuaian = 0;
            switch (level) {
                case "Aktif Ringan":
                    penyesuaian += 200;
                    break;
                case "Aktif Sedang":
                    penyesuaian += 400;
                    break;
                case "Sangat Aktif":
                    penyesuaian += 600;
                    break;
                case "Tidak Aktif":
                default:
                    penyesuaian += 0;
                    break;
            }

            if (gender.equalsIgnoreCase("Laki-Laki")) {
                penyesuaian += 100;
            }

            double totalKebutuhan = kebutuhanDasar + penyesuaian;

            if (totalKebutuhan > 5000) {
                jLabel8.setText("Hasil tidak wajar (" + totalKebutuhan + " ml). Mohon periksa kembali input Anda.");
                kebutuhanAir = 0;
                ButtonMulai.setEnabled(false);
                return;
            }

            if (totalKebutuhan < 1000) {
                totalKebutuhan = 1000;
            }

            kebutuhanAir = (int) totalKebutuhan;
            jLabel8.setText("Tubuh Anda membutuhkan " + kebutuhanAir + " ml air hari ini. Ayo, mulai dengan minuman pertamamu sekarang!");
            ButtonMulai.setEnabled(true);

        } catch (NumberFormatException e) {
            jLabel8.setText("Mohon masukkan usia yang valid!");
            kebutuhanAir = 0;
            ButtonMulai.setEnabled(false);
        }
    }//GEN-LAST:event_HitungMlActionPerformed

    private void TextFieldUsiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldUsiaActionPerformed

    }//GEN-LAST:event_TextFieldUsiaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BeratBadan;
    private javax.swing.JButton ButtonMulai;
    private javax.swing.JComboBox<String> ComboBoxGender;
    private javax.swing.JComboBox<String> ComboBoxLevelActiviitas;
    private javax.swing.JButton HitungMl;
    private javax.swing.JSpinner SpinnerBangun;
    private javax.swing.JSpinner SpinnerTidur;
    private javax.swing.JTextField TextFieldUsia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
