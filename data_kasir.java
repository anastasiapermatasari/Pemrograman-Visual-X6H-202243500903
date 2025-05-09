/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import koneksi.koneksi;
/**
 *
 * @author ASUS
 */


    /**
     * Creates new form data_kasir
     */
    public data_kasir() {
        initComponents();
        kosong();
        aktif();
        datatable();
    }
    protected void aktif(){
        txt_id.requestFocus();
}

protected void kosong() {
    txt_id.setText("");
    txt_nama.setText("");
    txt_telp.setText("");
    txt_alamat.setText("");
    txt_pw.setText("");

    // Reset radio button (pastikan rlaki & rperempuan dideklarasikan)
    genderGroup.clearSelection(); // Ganti "genderGroup" dengan nama grup radio kamu

    // Reset combo box (pastikan cb_agama sudah terisi data)
    cb_agama.setSelectedIndex(0); // Asumsi index 0 adalah pilihan default

    txt_id.requestFocus();
}

protected void datatable() {
    Object[] Baris = {
        "ID Kasir", "Nama Kasir", "Jenis Kelamin", "No Telepon", "Agama", "Alamat", "Password"
    };

    DefaultTableModel tabmode = new DefaultTableModel(null, Baris);
    tabel_kasir.setModel(tabmode); // Set model terlebih dahulu (optional)

    try {
        String sql = "SELECT * FROM kasir ORDER BY id ASC"; // Pastikan kolom 'id' ada di tabel kasir
        Connection conn = Koneksi.getConnection(); // Pastikan class Koneksi sudah dibuat
        Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);

        while (hasil.next()) {
            tabmode.addRow(new Object[]{
                hasil.getString("id"),        // kolom ke-1
                hasil.getString("nama"),      // kolom ke-2
                hasil.getString("kelamin"),   // kolom ke-3
                hasil.getString("telp"),      // kolom ke-4
                hasil.getString("agama"),     // kolom ke-5
                hasil.getString("alamat"),    // kolom ke-6
                hasil.getString("password")   // kolom ke-7
            });
        }

        tabel_kasir.setModel(tabmode);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Data gagal dipanggil: " + e.getMessage());
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        lbl_nama = new javax.swing.JLabel();
        lbl_kelamin = new javax.swing.JLabel();
        lbl_telp = new javax.swing.JLabel();
        lbl_agama = new javax.swing.JLabel();
        lbl_alamat = new javax.swing.JLabel();
        lbl_pw = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        rlaki = new javax.swing.JRadioButton();
        rperempuan = new javax.swing.JRadioButton();
        txt_telp = new javax.swing.JTextField();
        cb_agama = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_alamat = new javax.swing.JTextArea();
        txt_pw = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_kasir = new javax.swing.JTable();
        bsimpan = new javax.swing.JButton();
        bubah = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bbatal = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA KASIR");

        lbl_id.setText("ID Kasir");

        lbl_nama.setText("Nama Kasir");

        lbl_kelamin.setText("Jenis Kelamin");

        lbl_telp.setText("No Telepon");

        lbl_agama.setText("Agama");

        lbl_alamat.setText("Alamat");

        lbl_pw.setText("Password");

        buttonGroup1.add(rlaki);
        rlaki.setText("Laki-Laki");
        rlaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rlakiActionPerformed(evt);
            }
        });

        buttonGroup1.add(rperempuan);
        rperempuan.setText("Perempuan");

        cb_agama.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Islam", "Kristen", "Hindu", "Budha", "Konghucu" }));
        cb_agama.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_agamaItemStateChanged(evt);
            }
        });
        cb_agama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_agamaMouseClicked(evt);
            }
        });

        txt_alamat.setColumns(20);
        txt_alamat.setRows(5);
        jScrollPane1.setViewportView(txt_alamat);

        tabel_kasir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Kasir", "Nama Kasir", "Jenis Kelamin", "No Telepon", "Agama", "Alamat", "Password"
            }
        ));
        jScrollPane2.setViewportView(tabel_kasir);

        bsimpan.setText("SIMPAN");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        bubah.setText("UBAH");

        bhapus.setText("HAPUS");

        bbatal.setText("BATAL");

        bkeluar.setText("KELUAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(lbl_agama, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_alamat, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_kelamin)
                            .addComponent(lbl_telp))
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rlaki)
                                .addGap(38, 38, 38)
                                .addComponent(rperempuan))
                            .addComponent(cb_agama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                .addComponent(txt_telp, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lbl_nama)
                            .addGap(87, 87, 87)
                            .addComponent(txt_nama))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lbl_id)
                            .addGap(108, 108, 108)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbl_pw)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_pw, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bsimpan)
                        .addGap(36, 36, 36)
                        .addComponent(bubah)
                        .addGap(40, 40, 40)
                        .addComponent(bhapus)
                        .addGap(38, 38, 38)
                        .addComponent(bbatal)
                        .addGap(36, 36, 36)
                        .addComponent(bkeluar)))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_pw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_pw))
                .addGap(141, 141, 141))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bsimpan)
                            .addComponent(bubah)
                            .addComponent(bhapus)
                            .addComponent(bbatal)
                            .addComponent(bkeluar))))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_id)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nama)
                    .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_kelamin)
                            .addComponent(rlaki)
                            .addComponent(rperempuan))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_telp)
                            .addComponent(txt_telp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_agama)
                            .addComponent(cb_agama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(lbl_alamat))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_agamaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_agamaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_agamaItemStateChanged

    private void cb_agamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_agamaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_agamaMouseClicked

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
String sql = "INSERT INTO kasir VALUES (?, ?, ?, ?, ?, ?, ?)";
    try {
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, txt_id.getText());
        stat.setString(2, txt_nama.getText());
        stat.setString(3, jenis);
        stat.setString(4, txt_telp.getText());
        stat.setString(5, (String) cb_agama.getSelectedItem());
        stat.setString(6, txt_alamat.getText());
        stat.setString(7, txt_pw.getText());

        stat.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
        kosong();
        txt_id.requestFocus();
        datatable();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Data gagal disimpan: " + e);
    }
}        // TODO add your handling code here:
    }//GEN-LAST:event_bsimpanActionPerformed

    private void rlakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rlakiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rlakiActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(data_kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(data_kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(data_kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(data_kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new data_kasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton bubah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cb_agama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_agama;
    private javax.swing.JLabel lbl_alamat;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_kelamin;
    private javax.swing.JLabel lbl_nama;
    private javax.swing.JLabel lbl_pw;
    private javax.swing.JLabel lbl_telp;
    private javax.swing.JRadioButton rlaki;
    private javax.swing.JRadioButton rperempuan;
    private javax.swing.JTable tabel_kasir;
    private javax.swing.JTextArea txt_alamat;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_pw;
    private javax.swing.JTextField txt_telp;
    // End of variables declaration//GEN-END:variables
}
