package app;

import java.sql.Connection;

/**
 *
 * @author salwa eka
 */
public class EditDataRiwayat extends javax.swing.JDialog {

    private String tanggalLama;

    public EditDataRiwayat(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public EditDataRiwayat(java.awt.Frame parent, boolean modal, String tanggal, int total, int target) {
        super(parent, modal);
        initComponents();

        this.tanggalLama = tanggal;

        Tanggal.setText(tanggal);
        Tanggal.setEditable(false); 
        TotalMinumML.setText(String.valueOf(total));
        TargetMinum.setText(String.valueOf(target));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        Tanggal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TotalMinumML = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TargetMinum = new javax.swing.JTextField();
        Simpan = new javax.swing.JButton();
        Batal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("EDIT DATA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jLabel7)
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel7)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        Tanggal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Tanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TanggalActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Total Minum");

        TotalMinumML.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        TotalMinumML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalMinumMLActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Tanggal");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Target");

        TargetMinum.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        TargetMinum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TargetMinumActionPerformed(evt);
            }
        });

        Simpan.setBackground(new java.awt.Color(102, 204, 255));
        Simpan.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Simpan.setForeground(new java.awt.Color(255, 255, 255));
        Simpan.setText("Simpan");
        Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanActionPerformed(evt);
            }
        });

        Batal.setBackground(new java.awt.Color(102, 204, 255));
        Batal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Batal.setForeground(new java.awt.Color(255, 255, 255));
        Batal.setText("Batal");
        Batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                        .addComponent(TotalMinumML)
                        .addComponent(jLabel10)
                        .addComponent(TargetMinum)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Batal)
                .addGap(18, 18, 18)
                .addComponent(Simpan)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TotalMinumML, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TargetMinum, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Batal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TanggalActionPerformed

    }//GEN-LAST:event_TanggalActionPerformed

    private void TotalMinumMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalMinumMLActionPerformed
        
    }//GEN-LAST:event_TotalMinumMLActionPerformed

    private void TargetMinumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TargetMinumActionPerformed
        
    }//GEN-LAST:event_TargetMinumActionPerformed

    private void SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanActionPerformed
        String tanggal = Tanggal.getText().trim();
        String totalStr = TotalMinumML.getText().trim();
        String targetStr = TargetMinum.getText().trim();

        if (tanggal.isEmpty() || totalStr.isEmpty() || targetStr.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Semua field harus diisi!");
            return;
        }

        try {
            int total = Integer.parseInt(totalStr);
            int target = Integer.parseInt(targetStr);

            Connection conn = db.DatabaseConnection.getConnection();
            String sql = "UPDATE riwayat_harian SET total_diminum=?, target=? WHERE tanggal=?";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, total);
            ps.setInt(2, target);
            ps.setString(3, tanggal);
            ps.executeUpdate();

            javax.swing.JOptionPane.showMessageDialog(this, "Data berhasil diperbarui!");
            this.dispose();

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Total dan Target harus berupa angka!");
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal update: " + e.getMessage());
        }
    }//GEN-LAST:event_SimpanActionPerformed

    private void BatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BatalActionPerformed
        this.dispose(); 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RiwayatHarian().setVisible(true);
            }
        });
    }//GEN-LAST:event_BatalActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Batal;
    private javax.swing.JButton Simpan;
    private javax.swing.JTextField Tanggal;
    private javax.swing.JTextField TargetMinum;
    private javax.swing.JTextField TotalMinumML;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
