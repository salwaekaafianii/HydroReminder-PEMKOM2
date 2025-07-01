package app;

import db.DatabaseConnection;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.TimerTask;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author salwa eka
 */
public class Progress extends javax.swing.JFrame {

    private int totalMinum = 0;
    private int targetMinum;

    public Progress(int targetMinum) {
        this.targetMinum = targetMinum;
        initComponents();
        updateProgress();
        setupTabel();
        setLocationRelativeTo(null);
        StartClock();
    }

    private Progress() {
        setLocationRelativeTo(null);
    }

    public void setTotalMinumAwal(int total) {
        this.totalMinum = total;
        updateProgress();
    }

    private void setupTabel() {
        TabelRiwayatMinum.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Jam", "ml"}
        ));
    }

    private void tambahMinum() {
        int tambahan = 250;
        totalMinum += tambahan;

        updateProgress();

        DefaultTableModel model = (DefaultTableModel) TabelRiwayatMinum.getModel();
        String jamSekarang = LocalTime.now().withNano(0).toString(); 
        model.addRow(new Object[]{jamSekarang, tambahan});

        //multimedia Sound
        playSound("src/sound/water.wav");
    }

    private void updateProgress() {
        int persen = (int) ((double) totalMinum / targetMinum * 100);
        jProgressBar1.setValue(Math.min(persen, 100));
        jLabelTarget.setText("Target: " + targetMinum + " ml  |  Diminum: " + totalMinum + " ml");
    }

    //theard
    //karena suara diputar di thread terpisah, suara bisa terus jalan, sambil bebas buka halaman lain atau interaksi dengan aplikasi tanpa gangguan.
    private void playSound(String filePath) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(filePath));
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioStream);
                    clip.start();
                } catch (Exception e) {
                    System.out.println("Sound error: " + e.getMessage());
                }
            }
        }).start();
    }

    private void simpanRiwayatHarian() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String tanggal = LocalDate.now().toString();

            //cek apakah sudah ada data hari ini
            String cek = "SELECT COUNT(*) FROM riwayat_harian WHERE tanggal = ?";
            PreparedStatement cekPs = conn.prepareStatement(cek);
            cekPs.setString(1, tanggal);
            ResultSet rs = cekPs.executeQuery();
            rs.next();
            int sudahAda = rs.getInt(1);

            if (sudahAda > 0) {
                //update data jika sudah ada
                String updateSql = "UPDATE riwayat_harian SET target = ?, total_diminum = ? WHERE tanggal = ?";
                PreparedStatement updatePs = conn.prepareStatement(updateSql);
                updatePs.setInt(1, targetMinum);
                updatePs.setInt(2, totalMinum);
                updatePs.setString(3, tanggal);
                updatePs.executeUpdate();

                javax.swing.JOptionPane.showMessageDialog(this, "Data hari ini berhasil diupdate.");
            } else {
                //insert data baru jika belum ada
                String sql = "INSERT INTO riwayat_harian (tanggal, target, total_diminum) VALUES (?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, tanggal);
                ps.setInt(2, targetMinum);
                ps.setInt(3, totalMinum);
                ps.executeUpdate();

                javax.swing.JOptionPane.showMessageDialog(this, "Berhasil disimpan ke riwayat harian.");
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal menyimpan: " + e.getMessage());
        }
    }

    private void StartClock() {
        //thread terpisah buat timer, supaya jam update terus tanpa ganggu aplikasi
        //update label pakai invokeLater supaya aman di GUI
        java.util.Timer t = new java.util.Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
                String waktu = df.format(c.getTime());

                javax.swing.SwingUtilities.invokeLater(() -> lblClock.setText(waktu));
            }
        }, 0, 1000);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelRiwayatMinum = new javax.swing.JTable();
        ButtonSimpanKeRiwayatHarian = new javax.swing.JButton();
        lblClock = new javax.swing.JLabel();
        ButtonProgress = new javax.swing.JButton();
        jLabelTarget = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        ButtonRiwayatHarian = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        ButtonBack = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mineral-water (3).png"))); // NOI18N

        jProgressBar1.setForeground(new java.awt.Color(102, 204, 255));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TabelRiwayatMinum.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TabelRiwayatMinum.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Jam", "ml"
            }
        ));
        TabelRiwayatMinum.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TabelRiwayatMinumAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(TabelRiwayatMinum);

        ButtonSimpanKeRiwayatHarian.setBackground(new java.awt.Color(102, 204, 255));
        ButtonSimpanKeRiwayatHarian.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ButtonSimpanKeRiwayatHarian.setForeground(new java.awt.Color(255, 255, 255));
        ButtonSimpanKeRiwayatHarian.setText("Simpan");
        ButtonSimpanKeRiwayatHarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSimpanKeRiwayatHarianActionPerformed(evt);
            }
        });

        lblClock.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        lblClock.setText("JAM");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblClock, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonSimpanKeRiwayatHarian))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(lblClock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonSimpanKeRiwayatHarian, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        ButtonProgress.setBackground(new java.awt.Color(102, 204, 255));
        ButtonProgress.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ButtonProgress.setForeground(new java.awt.Color(255, 255, 255));
        ButtonProgress.setText("+ 250 ml");
        ButtonProgress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonProgressActionPerformed(evt);
            }
        });

        jLabelTarget.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabelTarget.setText("Target: \" + targetMinum + \" ml  |  Diminum:");

        jPanel5.setBackground(new java.awt.Color(102, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setPreferredSize(new java.awt.Dimension(544, 89));

        ButtonRiwayatHarian.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ButtonRiwayatHarian.setText("Riwayat Harian");
        ButtonRiwayatHarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRiwayatHarianActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton2.setText("Keluar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        ButtonBack.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ButtonBack.setText("Kembali");
        ButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(ButtonBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonRiwayatHarian)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(40, 40, 40))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonRiwayatHarian, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ButtonProgress)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelTarget)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTarget)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

    private void ButtonProgressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonProgressActionPerformed
        tambahMinum();
    }//GEN-LAST:event_ButtonProgressActionPerformed

    private void TabelRiwayatMinumAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TabelRiwayatMinumAncestorAdded

    }//GEN-LAST:event_TabelRiwayatMinumAncestorAdded

    private void ButtonSimpanKeRiwayatHarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSimpanKeRiwayatHarianActionPerformed
        simpanRiwayatHarian();
    }//GEN-LAST:event_ButtonSimpanKeRiwayatHarianActionPerformed

    private void ButtonRiwayatHarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRiwayatHarianActionPerformed
        RiwayatHarian rh = new RiwayatHarian();
        rh.setVisible(true);
        dispose();
    }//GEN-LAST:event_ButtonRiwayatHarianActionPerformed

    private void ButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBackActionPerformed
        InputData kembali = new InputData("NamaUser");
        kembali.setLocationRelativeTo(null);
        kembali.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ButtonBackActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int pilihan = JOptionPane.showConfirmDialog(
                this,
                "Apakah Anda yakin ingin kembali ke halaman login?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (pilihan == JOptionPane.YES_OPTION) {
            LoginPage halamanLogin = new LoginPage();
            halamanLogin.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBack;
    private javax.swing.JButton ButtonProgress;
    private javax.swing.JButton ButtonRiwayatHarian;
    private javax.swing.JButton ButtonSimpanKeRiwayatHarian;
    private javax.swing.JTable TabelRiwayatMinum;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTarget;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblClock;
    // End of variables declaration//GEN-END:variables
}
