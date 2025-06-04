/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Tugas10.Bioskop;

//import Tugas5.Bioskop.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class GUI_PesanTiket extends javax.swing.JFrame {

    /**
     * Creates new form GUI_PesanTiket
     */
    public GUI_PesanTiket() {
        initComponents();
        tampil();
        tampil_namaFilm();
        tampil_asalFilm();
        tampil_durasi();
        tampil_waktuTayang();
    }

    public void itempilih() {
        int row = tb_pesanTiket.getSelectedRow(); // ambil baris yang dipilih dari JTable
        if (row >= 0) {
            cmbNamaFilm.setSelectedItem(namaFilm);
            cmbAsalFilm.setSelectedItem(asalFilm);
            cmbDurasi.setSelectedItem(durasi);
            cmbWaktu.setSelectedItem(waktuTayang);
            txtHarga.setText(Integer.toString(harga));
            txtJumlah.setText(Integer.toString(jumlah));
        } else {
            JOptionPane.showMessageDialog(null, "Pilih baris terlebih dahulu di tabel!");
        }
    }

    public void batal() {
        cmbNamaFilm.setSelectedIndex(0);
        cmbAsalFilm.setSelectedIndex(0);
        cmbDurasi.setSelectedIndex(0);
        cmbWaktu.setSelectedIndex(0);
        txtHarga.setText("");
        txtJumlah.setText("");
    }

    String namaFilm, asalFilm, durasi, waktuTayang;
    int harga, jumlah;

    public Connection conn;

    public void koneksi() throws SQLException {
        try {
            conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/oop_bioskop?serverTimezone=UTC",
                    "root",
                    "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_PesanTiket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(GUI_PesanTiket.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception es) {
            Logger.getLogger(GUI_PesanTiket.class.getName()).log(Level.SEVERE, null, es);
        }
    }

    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("Nama Film");
        tabelhead.addColumn("Asal Film");
        tabelhead.addColumn("Durasi");
        tabelhead.addColumn("Waktu Tayang");
        tabelhead.addColumn("Harga");
        tabelhead.addColumn("Jumlah");

        try {
            koneksi();
            System.out.println("Koneksi berhasil.");

            String sql = "SELECT * FROM tb_pesan";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);

            boolean adaData = false;
            while (res.next()) {
                adaData = true;
                tabelhead.addRow(new Object[]{
                    res.getString("Nama_Film"),
                    res.getString("Asal_Film"),
                    res.getString("Durasi"),
                    res.getString("Waktu_Tayang"),
                    res.getString("Harga"),
                    res.getString("Jumlah")
                });
            }

            if (!adaData) {
                System.out.println("Data kosong di tb_pesan.");
            }

            tb_pesanTiket.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI\n" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void tampil_namaFilm() {
        try {
            koneksi();
            String sql = "SELECT * FROM tb_tiket order by Nama_Film asc";
            Statement stt = conn.createStatement();
            ResultSet res = stt.executeQuery(sql);
            while (res.next()) {
                Object[] ob = new Object[3];
                ob[0] = res.getString("Nama_Film");
                cmbNamaFilm.addItem((String) ob[0]);
            }
            res.close();
            stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void tampil_asalFilm() {
        try {
            koneksi();
            String sql = "SELECT * FROM tb_tiket order by Asal_Film asc";
            Statement stt = conn.createStatement();
            ResultSet res = stt.executeQuery(sql);
            while (res.next()) {
                Object[] ob = new Object[3];
                ob[0] = res.getString("Asal_Film");
                cmbAsalFilm.addItem((String) ob[0]);
            }
            res.close();
            stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void tampil_durasi() {
        try {
            koneksi();
            String sql = "SELECT * FROM tb_tiket order by Durasi asc";
            Statement stt = conn.createStatement();
            ResultSet res = stt.executeQuery(sql);
            while (res.next()) {
                Object[] ob = new Object[3];
                ob[0] = res.getString("Durasi");
                cmbDurasi.addItem((String) ob[0]);
            }
            res.close();
            stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void tampil_waktuTayang() {
        try {
            koneksi();
            String sql = "SELECT * FROM tb_tiket order by Waktu_Tayang asc";
            Statement stt = conn.createStatement();
            ResultSet res = stt.executeQuery(sql);
            while (res.next()) {
                Object[] ob = new Object[3];
                ob[0] = res.getString("Waktu_Tayang");
                cmbWaktu.addItem((String) ob[0]);
            }
            res.close();
            stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void refresh() {
        new GUI_PesanTiket().setVisible(true);
        this.setVisible(false);
    }

    public void insert() {
        String namaFilm = cmbNamaFilm.getSelectedItem().toString();
        String asalFilm = cmbAsalFilm.getSelectedItem().toString();
        String durasi = cmbDurasi.getSelectedItem().toString();
        String waktuTayang = cmbWaktu.getSelectedItem().toString();
        String harga = txtHarga.getText();
        String jumlah = txtJumlah.getText();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop_bioskop", "root", "");
            String sql = ("INSERT INTO tb_pesan (Nama_Film, Asal_Film, Durasi, Waktu_Tayang, Harga, Jumlah)"
                    + "VALUES('" + namaFilm + "','" + asalFilm + "','" + durasi + "','" + waktuTayang + "','" + harga + "','" + jumlah + "')");
            PreparedStatement pst = conn.prepareStatement(sql);
            System.out.println(sql);

            pst.executeUpdate(); // <-- ini WAJIB agar data masuk ke database

            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Pesan Tiket Bioskop!\nNama_Film: " + namaFilm);

            pst.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!\n" + e.getMessage());
            System.err.println(e.getCause());
        }

        refresh(); 
    }

    public void delete() {
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                String sql = "DELETE FROM tb_pesan WHERE Nama_Film='" + cmbNamaFilm.getSelectedItem().toString() + "'";
                java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
                batal();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal di hapus");
            }
        }
        refresh();
    }

    public void cari() {
        try {
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM tb_pesan WHERE Nama_Film LIKE '%" + txtSearch.getText() + "%'";
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                cmbNamaFilm.setSelectedItem(rs.getString("Nama_Film"));
                cmbAsalFilm.setSelectedItem(rs.getString("Asal_Film"));
                cmbDurasi.setSelectedItem(rs.getString("Durasi"));
                cmbWaktu.setSelectedItem(rs.getString("Waktu_Tayang"));
                txtHarga.setText(rs.getString("Harga"));
                txtJumlah.setText(rs.getString("Jumlah"));
            } else {
                JOptionPane.showMessageDialog(null, "Data yang Anda cari tidak ada");
            }

            rs.close();
            statement.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mencari data: " + ex.getMessage());
        }
    }

    public void update() {
        String namaFilm = (String) cmbNamaFilm.getSelectedItem();
        String asalFilm = (String) cmbAsalFilm.getSelectedItem();
        String durasi = (String) cmbDurasi.getSelectedItem();
        String waktuTayang = (String) cmbWaktu.getSelectedItem();
        String harga = txtHarga.getText();
        String jumlah = txtJumlah.getText();

        String namaFilm_lama = (String) cmbNamaFilm.getSelectedItem();
        String asalFilm_lama = (String) cmbAsalFilm.getSelectedItem();

        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(
                    "UPDATE tb_pesan SET "
                    + "Nama_Film='" + namaFilm + "', "
                    + "Asal_Film='" + asalFilm + "', "
                    + "Durasi='" + durasi + "', "
                    + "Waktu_Tayang='" + waktuTayang + "', "
                    + "Harga='" + harga + "', "
                    + "Jumlah='" + jumlah + "' "
                    + "WHERE Nama_Film='" + namaFilm_lama + "'"
            );
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Update Data Nilai!");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        refresh();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_pesanTiket = new javax.swing.JTable();
        btnBatal = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnSeacrh = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbNamaFilm = new javax.swing.JComboBox<>();
        cmbAsalFilm = new javax.swing.JComboBox<>();
        cmbDurasi = new javax.swing.JComboBox<>();
        cmbWaktu = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Pesan Tiket");

        jLabel2.setText("Harga");

        jLabel3.setText("Jumlah");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        tb_pesanTiket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nama Film", "Asal Film", "Durasi", "Waktu Tayang", "Harga", "Jumlah"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tb_pesanTiket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_pesanTiketMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tb_pesanTiket);

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnSeacrh.setText("Search");
        btnSeacrh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeacrhActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jLabel4.setText("Nama Film");

        jLabel5.setText("Asal Film");

        jLabel6.setText("Durasi");

        jLabel7.setText("Waktu Tayang");

        cmbNamaFilm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "~Nama Film~" }));
        cmbNamaFilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNamaFilmActionPerformed(evt);
            }
        });

        cmbAsalFilm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "~Asal Film~" }));
        cmbAsalFilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAsalFilmActionPerformed(evt);
            }
        });

        cmbDurasi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "~Durasi~" }));
        cmbDurasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDurasiActionPerformed(evt);
            }
        });

        cmbWaktu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "~Waktu Tayang~" }));
        cmbWaktu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbWaktuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel1)
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtHarga)
                            .addComponent(txtJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                            .addComponent(cmbNamaFilm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbAsalFilm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbDurasi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbWaktu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(240, 240, 240)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSeacrh)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addGap(18, 18, 18)
                        .addComponent(btnBatal)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClose)
                        .addGap(58, 58, 58))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSeacrh)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnSimpan)
                                .addComponent(btnBatal)
                                .addComponent(btnUpdate))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnClose)
                                .addComponent(btnHapus))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbNamaFilm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbAsalFilm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmbDurasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cmbWaktu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        batal();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSeacrhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeacrhActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_btnSeacrhActionPerformed

    private void cmbNamaFilmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNamaFilmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbNamaFilmActionPerformed

    private void cmbAsalFilmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAsalFilmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAsalFilmActionPerformed

    private void cmbDurasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDurasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDurasiActionPerformed

    private void cmbWaktuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbWaktuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbWaktuActionPerformed

    private void tb_pesanTiketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_pesanTiketMouseClicked
        // TODO add your handling code here:
        int tabel = tb_pesanTiket.getSelectedRow();
        namaFilm = tb_pesanTiket.getValueAt(tabel, 0).toString();
        asalFilm = tb_pesanTiket.getValueAt(tabel, 1).toString();
        durasi = tb_pesanTiket.getValueAt(tabel, 2).toString();
        waktuTayang = tb_pesanTiket.getValueAt(tabel, 3).toString();
        harga = Integer.parseInt(tb_pesanTiket.getValueAt(tabel, 4).toString());
        jumlah = Integer.parseInt(tb_pesanTiket.getValueAt(tabel, 5).toString());
        itempilih();
    }//GEN-LAST:event_tb_pesanTiketMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnHapusActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_PesanTiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_PesanTiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_PesanTiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_PesanTiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_PesanTiket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSeacrh;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbAsalFilm;
    private javax.swing.JComboBox<String> cmbDurasi;
    private javax.swing.JComboBox<String> cmbNamaFilm;
    private javax.swing.JComboBox<String> cmbWaktu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tb_pesanTiket;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
