/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.login_user;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ModelLogin_user;
import model.ModelUser;

/**
 *
 * @author Administrator
 */
public class FrChangePass extends javax.swing.JFrame {

    private ModelUser modelUser;
    private ModelLogin_user modelLogin_user;

    public FrChangePass() {
        initComponents();
        modelUser = new ModelUser();
        modelLogin_user = new ModelLogin_user();
        this.setLocation(500, 300);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btOK = new javax.swing.JButton();
        btThoat = new javax.swing.JButton();
        tfOldPass = new javax.swing.JPasswordField();
        cbShowOldPass = new javax.swing.JCheckBox();
        cbShowNewsPass = new javax.swing.JCheckBox();
        cbShowReNewPass = new javax.swing.JCheckBox();
        tfNewPass = new javax.swing.JPasswordField();
        tfRePass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Đổi mật khẩu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(51, 0, 204))); // NOI18N

        jLabel1.setText("Mật khẩu cũ :");

        jLabel2.setText("Mật khẩu mới :");

        jLabel3.setText("Nhập lại mật khẩu mới :");

        btOK.setText("OK");
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOKActionPerformed(evt);
            }
        });

        btThoat.setText("Thoát");
        btThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThoatActionPerformed(evt);
            }
        });

        cbShowOldPass.setText("Show");
        cbShowOldPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbShowOldPassActionPerformed(evt);
            }
        });

        cbShowNewsPass.setText("Show");
        cbShowNewsPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbShowNewsPassActionPerformed(evt);
            }
        });

        cbShowReNewPass.setText("Show");
        cbShowReNewPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbShowReNewPassActionPerformed(evt);
            }
        });

        tfRePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRePassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btOK, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btThoat))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfRePass, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbShowReNewPass))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbShowNewsPass))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfOldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbShowOldPass)))
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfOldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbShowOldPass))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbShowNewsPass)
                    .addComponent(tfNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbShowReNewPass)
                    .addComponent(tfRePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btOK)
                    .addComponent(btThoat))
                .addGap(29, 29, 29))
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

    private void btOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOKActionPerformed
        ArrayList<login_user> user = modelLogin_user.getUserLogin();
        String username = user.get(0).getUser_login();
        String oldPass = tfOldPass.getText();
        String newPass = tfNewPass.getText();
        String reNewPass = tfRePass.getText();
        if (!newPass.equals(reNewPass)) {
            JOptionPane.showMessageDialog(null, "Nhập lại mật khẩu không khớp!");
            return;
        }
        if (modelUser.CheckLogin(username, oldPass) != null) {
            if (modelLogin_user.chage_pass(username,oldPass, newPass) > 0) {
                JOptionPane.showMessageDialog(null, "Mật khẩu đã được thay đổi!");
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Đổi mật khẩu thất bại!");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Mật khẩu cũ nhập vào không đúng!");
        }
    }//GEN-LAST:event_btOKActionPerformed

    private void btThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThoatActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btThoatActionPerformed

    private void cbShowOldPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbShowOldPassActionPerformed
        if (cbShowOldPass.isSelected()) {
            tfOldPass.setEchoChar((char) 0); //password = JPasswordField
        } else {
            tfOldPass.setEchoChar('*');
        }
    }//GEN-LAST:event_cbShowOldPassActionPerformed

    private void cbShowNewsPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbShowNewsPassActionPerformed
        if (cbShowNewsPass.isSelected()) {
            tfNewPass.setEchoChar((char) 0); //password = JPasswordField
        } else {
            tfNewPass.setEchoChar('*');
        }
    }//GEN-LAST:event_cbShowNewsPassActionPerformed

    private void tfRePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRePassActionPerformed
    }//GEN-LAST:event_tfRePassActionPerformed

    private void cbShowReNewPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbShowReNewPassActionPerformed
        if (cbShowReNewPass.isSelected()) {
            tfRePass.setEchoChar((char) 0); //password = JPasswordField
        } else {
            tfRePass.setEchoChar('*');
        }
    }//GEN-LAST:event_cbShowReNewPassActionPerformed

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
            java.util.logging.Logger.getLogger(FrChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrChangePass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOK;
    private javax.swing.JButton btThoat;
    private javax.swing.JCheckBox cbShowNewsPass;
    private javax.swing.JCheckBox cbShowOldPass;
    private javax.swing.JCheckBox cbShowReNewPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField tfNewPass;
    private javax.swing.JPasswordField tfOldPass;
    private javax.swing.JPasswordField tfRePass;
    // End of variables declaration//GEN-END:variables
}
