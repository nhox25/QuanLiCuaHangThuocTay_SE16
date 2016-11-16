/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.User;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import library.LibraryDbConnect;
import model.ModelUser;

/**
 *
 * @author Administrator
 */
public class FrSuaNhanVien extends javax.swing.JFrame {

    private LibraryDbConnect lcdb;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection con;
    private int crow = -1;
    private static String maNV;
    private ModelUser mUser;
    private JTable table;
    private File file = null;
    private ArrayList<User> alItem = new ArrayList<>();

    public FrSuaNhanVien(String maNV) {
        this.setIconImage(new ImageIcon(getClass().getResource("/images/se16.png")).getImage());
        initComponents();
        this.table = table;
        mUser = new ModelUser();
        lcdb = new LibraryDbConnect();
        getList(maNV);
    }

    public ArrayList<User> getList(String maNV) {
        ArrayList<User> alItem = new ArrayList<>();
        try {
            String sql = "Select * from nhanvien where idNhanVien =" + maNV;
            con = lcdb.getConnectMySQL();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                alItem.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getTimestamp(9), rs.getString(10), rs.getString(11)));
                tfMaNhanVien.setText(rs.getString(1));
                tfName.setText(rs.getString(2));
                tfFullName.setText(rs.getString(4));
                tfLuong.setText(rs.getString(5));
                lbHinhNhanVien.setText(rs.getString(6));
                String hinhanh = lbHinhNhanVien.getName();
                String pathFileUpload = "files\\" + hinhanh;
                ImageIcon imageIcon = new ImageIcon(pathFileUpload);
                Image imageSmall = imageIcon.getImage().getScaledInstance(168, 110, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(imageSmall);
                lbHinhNhanVien.setIcon(icon);
                cbGioiTinh.setSelectedItem(rs.getString(7));
                cbChucVu.setSelectedItem(rs.getString(8));
                spNgaySinh.setValue(rs.getTimestamp(9));
                tfDiaChi.setText(rs.getString(10));
                taTTT.setText(rs.getString(11));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrSuaNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                st.close();
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi close");
                ex.printStackTrace();
            }
        }
        return alItem;
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfMaNhanVien = new javax.swing.JTextField();
        tfName = new javax.swing.JTextField();
        tfFullName = new javax.swing.JTextField();
        tfLuong = new javax.swing.JTextField();
        spNgaySinh = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        btnSua = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        lbHinhNhanVien = new javax.swing.JLabel();
        cbGioiTinh = new javax.swing.JComboBox<>();
        psPass = new javax.swing.JPasswordField();
        cbChucVu = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        taTTT = new javax.swing.JTextArea();
        tfDiaChi = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thêm Nhân Viên", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 204)), null)); // NOI18N

        jLabel1.setText("Mã nhân viên :");

        jLabel2.setText("Tên đăng nhập :");

        jLabel3.setText("Mật khẩu");

        jLabel4.setText("Họ và tên :");

        jLabel5.setText("Lương :");

        jLabel6.setText("Hình ảnh :");

        tfMaNhanVien.setEditable(false);
        tfMaNhanVien.setEnabled(false);

        tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });

        spNgaySinh.setModel(new javax.swing.SpinnerDateModel());

        btnSua.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-icon.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel2.add(btnSua);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Button-Refresh-icon_1.png"))); // NOI18N
        jButton3.setText("Nhập lại");
        jPanel2.add(jButton3);

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button-del-icon.png"))); // NOI18N
        jButton4.setText("Close");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);

        cbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        cbChucVu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admintors", "Nhân viên", "Thư ký", "Giữ xe", "CEO", "Khác" }));

        taTTT.setColumns(20);
        taTTT.setRows(5);
        jScrollPane1.setViewportView(taTTT);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/open-file-icon.png"))); // NOI18N
        jButton1.setText("Upload");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Giới tính :");

        jLabel9.setText("Chức vụ :");

        jLabel10.setText("Ngày sinh");

        jLabel7.setText("Địa chỉ :");

        jLabel11.setText("Thêm :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbHinhNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(6, 6, 6))
                            .addComponent(tfFullName, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(tfName, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(tfLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(tfMaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(psPass))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spNgaySinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbChucVu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cbGioiTinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(psPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(lbHinhNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 107, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int id = 0;
        if (!tfMaNhanVien.getText().isEmpty()) {
            id = Integer.parseInt(tfMaNhanVien.getText());
        }
        String name = tfName.getText();
        String fullname = tfFullName.getText();
        String pass = new String(psPass.getPassword());
        Date date = (Date) spNgaySinh.getValue();
        Timestamp ngaysinh = new Timestamp(date.getTime());
        String gioitinh = (String) cbGioiTinh.getSelectedItem();
        String luong = tfLuong.getText();
        String chucvu = (String) cbChucVu.getSelectedItem();
        String address = tfDiaChi.getText();
        String ttt = taTTT.getText();
        String hinhanh = lbHinhNhanVien.getName();
        String pathFileUpload = "files\\" + hinhanh;
        ImageIcon imageIcon = new ImageIcon(pathFileUpload);
        Image imageSmall = imageIcon.getImage().getScaledInstance(70, 90, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(imageSmall);
        lbHinhNhanVien.setIcon(icon);
        User obj = new User(id, name, pass, fullname, luong, hinhanh, gioitinh, chucvu, ngaysinh, address, ttt);
        if (isValid(obj)) {
            int p = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa", "Sửa?", JOptionPane.YES_NO_OPTION);
            if (p == 0) {
                edit(obj);
                JOptionPane.showMessageDialog(this, "Sửa thàng công!");
                resetForm();
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showDialog(null, "Upload file");
        if (result == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            String filename = file.getName();
            String path = file.getAbsolutePath();
            String pathFileUpload = "files\\" + filename;
            Path source = Paths.get(path);
            Path target = Paths.get(pathFileUpload);
            try {
                Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                Logger.getLogger(FrThemNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
            ImageIcon imageIcon = new ImageIcon(pathFileUpload);
            Image imageSmall = imageIcon.getImage().getScaledInstance(70, 90, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(imageSmall);
            lbHinhNhanVien.setIcon(icon);
            lbHinhNhanVien.setName(filename);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    public int edit(User objUser) {
        mUser.edit(objUser);
        return 1;
    }

    private boolean isValid(User objUser) {
        boolean result = true;
        User objUserById = null;
        objUserById = checkIdUser(objUser);
        if (objUser.getName().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên");
            result = false;
        } else if (objUser.getFullname().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập họ và tên");
            result = false;
        } else if (objUser.getLuong().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập lương");
            result = false;
        } else if (objUser.getChucvu().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập chức vụ");
            result = false;
        } else if (objUser.getDiachi().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập địa chỉ");
            result = false;
        } else if (!objUserById.getName().equals(objUser.getName())) {
            if (checkUsername(objUser)) {
                JOptionPane.showMessageDialog(null, "Trùng tên đăng nhập");
                return false;
            }
        }
        return result;
    }

    public void resetForm() {
        crow = -1;
        tfMaNhanVien.setText("");
        tfName.setText("");
        psPass.setText("");
        lbHinhNhanVien.setIcon(null);
        tfFullName.setText("");
        cbGioiTinh.setSelectedIndex(0);
        tfLuong.setText("");
        cbChucVu.setSelectedIndex(0);
        tfDiaChi.setText("");
        taTTT.setText("");
    }

    public boolean checkUsername(User username) {
        User m = mUser.getUserByUsername(username.getName());
        if (m != null) {
            return true;
        } else {
            return false;
        }
    }

    public User checkIdUser(User objUser) {
        return mUser.getUserById(objUser.getId());
    }

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
            java.util.logging.Logger.getLogger(FrSuaNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrSuaNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrSuaNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrSuaNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrSuaNhanVien(maNV).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JComboBox cbChucVu;
    private javax.swing.JComboBox<String> cbGioiTinh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbHinhNhanVien;
    private javax.swing.JPasswordField psPass;
    private javax.swing.JSpinner spNgaySinh;
    private javax.swing.JTextArea taTTT;
    private javax.swing.JTextField tfDiaChi;
    private javax.swing.JTextField tfFullName;
    private javax.swing.JTextField tfLuong;
    private javax.swing.JTextField tfMaNhanVien;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}