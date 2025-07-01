package app;

import db.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import utils.RiwayatMinum;

/**
 *
 * @author salwa eka
 */
public class RiwayatHarian extends javax.swing.JFrame {

    public RiwayatHarian() {
        initComponents();
        tampilkanRiwayat();
        setLocationRelativeTo(null);

    }

    private void tampilkanRiwayat() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Tanggal");
        model.addColumn("Total Diminum (ml)");
        model.addColumn("Target (ml)");

        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM riwayat_harian ORDER BY tanggal DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            java.text.SimpleDateFormat sdfInput = new java.text.SimpleDateFormat("yyyy-MM-dd");
            java.text.SimpleDateFormat sdfHari = new java.text.SimpleDateFormat("EEEE", new java.util.Locale("id", "ID"));

            while (rs.next()) {
                String tanggalStr = rs.getString("tanggal");
                java.util.Date tanggal = sdfInput.parse(tanggalStr);
                String hari = sdfHari.format(tanggal);

                String gabungan = hari + ", " + tanggalStr;

                model.addRow(new Object[]{
                    gabungan,
                    rs.getInt("total_diminum"),
                    rs.getInt("target")
                });
            }

            jTable1.setModel(model);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal load data: " + e.getMessage());
        }
    }

    private void simpanDataKeDatabase(ArrayList<RiwayatMinum> data) {
        try {
            Connection conn = DatabaseConnection.getConnection();

            String sqlInsert = "INSERT INTO riwayat_harian (tanggal, total_diminum, target) VALUES (?, ?, ?) "
                    + "ON DUPLICATE KEY UPDATE total_diminum=?, target=?";
            PreparedStatement ps = conn.prepareStatement(sqlInsert);

            for (RiwayatMinum item : data) {
                ps.setString(1, item.getTanggal());
                ps.setInt(2, item.getTotalDiminum());
                ps.setInt(3, item.getTarget());
                ps.setInt(4, item.getTotalDiminum());
                ps.setInt(5, item.getTarget());
                ps.executeUpdate();
            }

            javax.swing.JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke database");

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal simpan ke database: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        ButtonBack = new javax.swing.JButton();
        TambahRiwayat = new javax.swing.JButton();
        EditRiwayat = new javax.swing.JButton();
        HapusRiwayat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        ButtonDowloadFile = new javax.swing.JButton();
        ButtonMuatFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("RIWAYAT MINUM HARIAN");

        ButtonBack.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ButtonBack.setText("Kembali");
        ButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBackActionPerformed(evt);
            }
        });

        TambahRiwayat.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TambahRiwayat.setText("Tambah");
        TambahRiwayat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahRiwayatActionPerformed(evt);
            }
        });

        EditRiwayat.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        EditRiwayat.setText("Edit");
        EditRiwayat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditRiwayatActionPerformed(evt);
            }
        });

        HapusRiwayat.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        HapusRiwayat.setText("Hapus");
        HapusRiwayat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusRiwayatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(ButtonBack)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(TambahRiwayat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EditRiwayat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(HapusRiwayat)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TambahRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HapusRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jTable1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tanggal", "Total", "Target"
            }
        ));
        jTable1.setPreferredSize(new java.awt.Dimension(150, 80));
        jScrollPane1.setViewportView(jTable1);

        jPanel3.setBackground(new java.awt.Color(102, 204, 255));

        ButtonDowloadFile.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ButtonDowloadFile.setText("Download File");
        ButtonDowloadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDowloadFileActionPerformed(evt);
            }
        });

        ButtonMuatFile.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ButtonMuatFile.setText("Memuat File");
        ButtonMuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonMuatFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonDowloadFile)
                .addGap(18, 18, 18)
                .addComponent(ButtonMuatFile)
                .addGap(32, 32, 32))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonDowloadFile, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonMuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonDowloadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDowloadFileActionPerformed
        //serialization (Menyimpan data dari database ke file .ser)                                           
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM riwayat_harian ORDER BY tanggal DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ArrayList<RiwayatMinum> data = new ArrayList<>();

            while (rs.next()) {
                String tanggal = rs.getString("tanggal");
                int total = rs.getInt("total_diminum");
                int target = rs.getInt("target");
                data.add(new RiwayatMinum(tanggal, total, target));
            }

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("riwayat.ser"))) {
                out.writeObject(data);
            }

            javax.swing.JOptionPane.showMessageDialog(this, "Berhasil disimpan ke file riwayat.ser");

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal simpan ke file: " + e.getMessage());
        }
    }//GEN-LAST:event_ButtonDowloadFileActionPerformed

    private void ButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBackActionPerformed
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM riwayat_harian WHERE tanggal = CURRENT_DATE";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            int target = 2000; // default
            int total = 0;

            if (rs.next()) {
                target = rs.getInt("target");
                total = rs.getInt("total_diminum");
            }

            Progress progressForm = new Progress(target);
            progressForm.setTotalMinumAwal(total);
            progressForm.setLocationRelativeTo(null);
            progressForm.setVisible(true);
            this.dispose();

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal kembali ke halaman progress: " + e.getMessage());
        }
    }//GEN-LAST:event_ButtonBackActionPerformed

    private void ButtonMuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMuatFileActionPerformed
        //deserialisasi (memuat data dari file .ser yang berisi objek ArrayList<RiwayatMinum>)
        //membuka dialog file chooser untuk memilih file
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Pilih file riwayat.ser");

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

            //proses deserialisasi: membaca objek ArrayList<RiwayatMinum> dari file
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                ArrayList<RiwayatMinum> data = (ArrayList<RiwayatMinum>) in.readObject();

                //mengosongkan tabel sebelum menampilkan data yang baru dimuat
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);

                java.text.SimpleDateFormat sdfInput = new java.text.SimpleDateFormat("yyyy-MM-dd");
                java.text.SimpleDateFormat sdfHari = new java.text.SimpleDateFormat("EEEE", new java.util.Locale("id", "ID"));

                for (RiwayatMinum rm : data) {
                    try {
                        java.util.Date tanggal = sdfInput.parse(rm.getTanggal());
                        String hari = sdfHari.format(tanggal);
                        String gabungan = hari + ", " + rm.getTanggal();

                        model.addRow(new Object[]{
                            gabungan,
                            rm.getTotalDiminum(),
                            rm.getTarget()
                        });
                    } catch (Exception ex) {
                        model.addRow(new Object[]{
                            rm.getTanggal(),
                            rm.getTotalDiminum(),
                            rm.getTarget()
                        });
                    }
                }

                //menyimpan data yang baru dimuat ke dalam database
                simpanDataKeDatabase(data);

                JOptionPane.showMessageDialog(this, "Data berhasil dimuat dari file.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_ButtonMuatFileActionPerformed

    private void TambahRiwayatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahRiwayatActionPerformed
        TambahDataRiwayat dialog = new TambahDataRiwayat(this, true);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
        tampilkanRiwayat();
    }//GEN-LAST:event_TambahRiwayatActionPerformed

    private void EditRiwayatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditRiwayatActionPerformed
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Pilih salah satu data terlebih dahulu!");
            return;
        }

        String tanggalGabungan = jTable1.getValueAt(selectedRow, 0).toString();
        String tanggal = tanggalGabungan.split(", ")[1];

        int total = Integer.parseInt(jTable1.getValueAt(selectedRow, 1).toString());
        int target = Integer.parseInt(jTable1.getValueAt(selectedRow, 2).toString());

        EditDataRiwayat dialog = new EditDataRiwayat(this, true, tanggal, total, target);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

        tampilkanRiwayat();
    }//GEN-LAST:event_EditRiwayatActionPerformed

    private void HapusRiwayatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusRiwayatActionPerformed
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Pilih salah satu data terlebih dahulu!");
            return;
        }
        int konfirmasi = javax.swing.JOptionPane.showConfirmDialog(this,
                "Apakah Anda yakin ingin menghapus data ini?",
                "Konfirmasi Hapus",
                javax.swing.JOptionPane.YES_NO_OPTION);

        if (konfirmasi == javax.swing.JOptionPane.YES_OPTION) {
            try {
                String tanggalGabungan = jTable1.getValueAt(selectedRow, 0).toString();
                String tanggal = tanggalGabungan.split(", ")[1];

                Connection conn = DatabaseConnection.getConnection();
                String sql = "DELETE FROM riwayat_harian WHERE tanggal = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, tanggal);
                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");
                    tampilkanRiwayat();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Data tidak ditemukan atau sudah dihapus.");
                }

            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_HapusRiwayatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBack;
    private javax.swing.JButton ButtonDowloadFile;
    private javax.swing.JButton ButtonMuatFile;
    private javax.swing.JButton EditRiwayat;
    private javax.swing.JButton HapusRiwayat;
    private javax.swing.JButton TambahRiwayat;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
