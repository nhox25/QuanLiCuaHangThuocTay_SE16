/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.ThongTinSE16;
import bean.login_user;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import library.LibraryDbConnect;
import model.ModelLoaiThucPham;
import model.ModelLogin_user;

/**
 *
 * @author Administrator
 */
public class FrMain extends javax.swing.JFrame {

    private LibraryDbConnect lcdb;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection con;
    private ModelLogin_user modelLogin_user;
    String userlogin = "";
    private ModelLoaiThucPham modelLoaithucpham;

    public FrMain() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/images/se16.png")).getImage());
        setSize(1055, 730);
        setLocation(230, 1);
        modelLogin_user = new ModelLogin_user();
        ArrayList<ThongTinSE16> ks = getList();
        ThongTinSE16 name = ks.get(0);
        lbBot.setText("" + name);

        ArrayList<login_user> user = modelLogin_user.getUserLogin();
        login_user fullname = user.get(0);
        lbUser.setText("" + fullname);
        userlogin = user.get(0).getUser_login();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Are you sure?", "Warning?",
                        JOptionPane.YES_NO_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) {
                    modelLogin_user.del_user_login();
                    dispose();
                } else {
                    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
                }
            }
        });
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                lbTime.setText("Bây giờ là :" + sdf.format(new java.util.Date()));
            }
        });
        timer.start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pnTop = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lbTop = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lbTime = new javax.swing.JLabel();
        pnBot = new javax.swing.JPanel();
        lbBot = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pnCenter = new javax.swing.JPanel();
        pnCenter1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfBoss = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfAdress = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btSua = new javax.swing.JButton();
        btNhapLai = new javax.swing.JButton();
        tfNameQuan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfPhone = new javax.swing.JTextField();
        tfYear = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mniDanhSach = new javax.swing.JMenuItem();
        mniDoiPass = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mniLoaiThucPham = new javax.swing.JMenuItem();
        mniSanPham = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        mniThongKeAll = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        minQLgiaodich = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("jMenu5");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem4.setText("jMenuItem4");

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        pnTop.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel5.setForeground(new java.awt.Color(0, 255, 255));
        jPanel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        lbTop.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbTop.setForeground(new java.awt.Color(255, 51, 51));
        lbTop.setText("Chào Mừng quý khách đến với Hiệu thuốc tây SE16");
        jPanel5.add(lbTop);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Chào,");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lbUser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbUser.setText("bạn");
        lbUser.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Log-Out-icon.png"))); // NOI18N
        jButton1.setText("Logout");
        jButton1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbTime.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbTime.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lbTime, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lbUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(lbUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addContainerGap())
            .addComponent(lbTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnTopLayout = new javax.swing.GroupLayout(pnTop);
        pnTop.setLayout(pnTopLayout);
        pnTopLayout.setHorizontalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTopLayout.setVerticalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(pnTop, java.awt.BorderLayout.PAGE_START);

        pnBot.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbBot.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbBot.setForeground(new java.awt.Color(255, 51, 51));
        lbBot.setText("Thông tin thêm");
        pnBot.add(lbBot);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 255));
        jLabel9.setText("<html>Copyright &copy; by Nhoxs25</html>");
        pnBot.add(jLabel9);

        jPanel1.add(pnBot, java.awt.BorderLayout.PAGE_END);

        pnCenter.setLayout(new java.awt.BorderLayout());

        pnCenter1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông tin hiệu thuốc", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 102, 0))); // NOI18N
        pnCenter1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(255, 0, 51));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setText("Tên hiệu thuốc :");

        tfBoss.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tfBoss.setForeground(new java.awt.Color(255, 0, 0));
        tfBoss.setMinimumSize(new java.awt.Dimension(6, 26));
        tfBoss.setPreferredSize(new java.awt.Dimension(6, 32));
        tfBoss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBossActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("Địa chỉ:");

        tfAdress.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tfAdress.setForeground(new java.awt.Color(255, 0, 0));
        tfAdress.setPreferredSize(new java.awt.Dimension(6, 32));

        btSua.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-icon.png"))); // NOI18N
        btSua.setText("Sửa");
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });
        jPanel3.add(btSua);

        btNhapLai.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btNhapLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Button-Refresh-icon_1.png"))); // NOI18N
        btNhapLai.setText("Nhập lại");
        btNhapLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNhapLaiActionPerformed(evt);
            }
        });
        jPanel3.add(btNhapLai);

        tfNameQuan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tfNameQuan.setForeground(new java.awt.Color(255, 0, 0));
        tfNameQuan.setMinimumSize(new java.awt.Dimension(6, 26));
        tfNameQuan.setPreferredSize(new java.awt.Dimension(6, 32));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("Tên chủ quán:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("Số điện thoại:");

        tfPhone.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tfPhone.setForeground(new java.awt.Color(255, 0, 0));
        tfPhone.setMinimumSize(new java.awt.Dimension(6, 26));
        tfPhone.setPreferredSize(new java.awt.Dimension(6, 32));
        tfPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPhoneActionPerformed(evt);
            }
        });

        tfYear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tfYear.setForeground(new java.awt.Color(255, 0, 0));
        tfYear.setMinimumSize(new java.awt.Dimension(6, 26));
        tfYear.setPreferredSize(new java.awt.Dimension(6, 32));
        tfYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfYearActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 255));
        jLabel7.setText("Năm thành lập");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfBoss, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfNameQuan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfAdress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(tfNameQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(tfAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBoss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfAdress, tfBoss, tfNameQuan, tfPhone, tfYear});

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 240, 23, 0);
        pnCenter1.add(jPanel2, gridBagConstraints);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/welcome.gif"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = -15;
        gridBagConstraints.ipady = -10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 159, 0, 127);
        pnCenter1.add(jLabel2, gridBagConstraints);

        pnCenter.add(pnCenter1, java.awt.BorderLayout.CENTER);

        jPanel1.add(pnCenter, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Quản lí nhân viên");
        jMenu1.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu1MenuSelected(evt);
            }
        });

        mniDanhSach.setText("Danh sách nhân viên");
        mniDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDanhSachActionPerformed(evt);
            }
        });
        jMenu1.add(mniDanhSach);

        mniDoiPass.setText("Đổi mật khẩu");
        mniDoiPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDoiPassActionPerformed(evt);
            }
        });
        jMenu1.add(mniDoiPass);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Quản lí sản phẩm");
        jMenu2.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu2MenuSelected(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        mniLoaiThucPham.setText("Loại thực phẩm");
        mniLoaiThucPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLoaiThucPhamActionPerformed(evt);
            }
        });
        jMenu2.add(mniLoaiThucPham);

        mniSanPham.setText("Sản phẩm");
        mniSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSanPhamActionPerformed(evt);
            }
        });
        jMenu2.add(mniSanPham);

        jMenuBar1.add(jMenu2);

        jMenu6.setText("Thống kê");

        mniThongKeAll.setText("Thống kê chung");
        mniThongKeAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniThongKeAllActionPerformed(evt);
            }
        });
        jMenu6.add(mniThongKeAll);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Giao dịch");
        jMenu7.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu7MenuSelected(evt);
            }
        });

        minQLgiaodich.setText("Quản lí giao dịch");
        minQLgiaodich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minQLgiaodichActionPerformed(evt);
            }
        });
        jMenu7.add(minQLgiaodich);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

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

    private void mniDanhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDanhSachActionPerformed
        pnCenter.removeAll();
        pnCenter.revalidate();
        pnCenter.add(new pnDanhSachNhanVien(), BorderLayout.CENTER);
        lbTop.setText("Quản lý nhân viên");
    }//GEN-LAST:event_mniDanhSachActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed

    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu2MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu2MenuSelected
        ArrayList<login_user> user = modelLogin_user.getUserLogin();
        String chucvu = user.get(0).getChucvu();
        if (chucvu.equals("Admintors")) {
            mniSanPham.setEnabled(true);
            mniLoaiThucPham.setEnabled(true);
        } else {
            mniLoaiThucPham.setEnabled(false);
            mniSanPham.setEnabled(false);

        }
    }//GEN-LAST:event_jMenu2MenuSelected

    private void jMenu7MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu7MenuSelected
    }//GEN-LAST:event_jMenu7MenuSelected

    private void mniLoaiThucPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLoaiThucPhamActionPerformed
        pnCenter.removeAll();
        pnCenter.revalidate();
        pnCenter.add(new pnLoaiThucPham(), BorderLayout.CENTER);
        lbTop.setText("Quản lý loại sản phẩm");
    }//GEN-LAST:event_mniLoaiThucPhamActionPerformed

    private void mniSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSanPhamActionPerformed
        modelLoaithucpham = new ModelLoaiThucPham();
        if (modelLoaithucpham.getList().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Loại thực phẩm đang rỗng! Vui lòng thêm loại thực phẩm trước!");
        } else {
            pnCenter.removeAll();
            pnCenter.revalidate();
            pnCenter.add(new pnQuanLiSanPham(), BorderLayout.CENTER);
            lbTop.setText("Quản lý sản phẩm");
        }
    }//GEN-LAST:event_mniSanPhamActionPerformed

    private void minQLgiaodichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minQLgiaodichActionPerformed
        pnCenter.removeAll();
        pnCenter.revalidate();
        pnCenter.add(new pnGiaoDich(), BorderLayout.CENTER);
        lbTop.setText("Giao dịch");
    }//GEN-LAST:event_minQLgiaodichActionPerformed

    private void mniThongKeAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniThongKeAllActionPerformed
        pnCenter.removeAll();
        pnCenter.revalidate();
        pnCenter.add(new pnThongKe(), BorderLayout.CENTER);
        lbTop.setText("Thống kê tất cả");
    }//GEN-LAST:event_mniThongKeAllActionPerformed

    private void tfBossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBossActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBossActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        ThongTinSE16 tt = new ThongTinSE16();
        if (edit(tt) > 0) {
            JOptionPane.showMessageDialog(null, "Thông tin của bạn đã được thay đổi!", "Thông báo kìa!!", 0, new ImageIcon(getClass().getResource("/images/infor.png")));
        }
        ArrayList<ThongTinSE16> ks = getList();
        ThongTinSE16 name = ks.get(0);
        lbBot.setText("" + name);
    }//GEN-LAST:event_btSuaActionPerformed

    private void btNhapLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNhapLaiActionPerformed
        tfNameQuan.setText("");
        tfPhone.setText("");
        tfBoss.setText("");
        tfAdress.setText("");
        tfYear.setText("");
    }//GEN-LAST:event_btNhapLaiActionPerformed

    private void tfPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPhoneActionPerformed

    private void tfYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfYearActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int confirmed = JOptionPane.showConfirmDialog(null,
                "Are you sure?", "Warning!",
                JOptionPane.YES_NO_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {
            modelLogin_user.del_user_login();
            this.setVisible(false);
            new FrLogin().setVisible(true);
        } else {
            setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenu1MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu1MenuSelected
        ArrayList<login_user> user = modelLogin_user.getUserLogin();
        String chucvu = user.get(0).getChucvu();
        if (chucvu.equals("Admintors")) {
            mniDanhSach.setEnabled(true);
        } else {
            mniDanhSach.setEnabled(false);
        }
    }//GEN-LAST:event_jMenu1MenuSelected

    private void mniDoiPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDoiPassActionPerformed
        new FrChangePass().setVisible(true);
    }//GEN-LAST:event_mniDoiPassActionPerformed

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
            java.util.logging.Logger.getLogger(FrMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrMain().setVisible(true);
            }
        });
    }

    public ArrayList<ThongTinSE16> getList() {
        lcdb = new LibraryDbConnect();
        ArrayList<ThongTinSE16> alItem = new ArrayList<>();
        try {
            String sql = "Select * from thongtinks";
            con = lcdb.getConnectMySQL();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                alItem.add(new ThongTinSE16(rs.getString("nameKS"), rs.getString("address"), rs.getString("boss"), rs.getString("phone"), rs.getString("yearstart")));
                tfNameQuan.setText(rs.getString("nameKS"));
                tfAdress.setText(rs.getString("address"));
                tfBoss.setText(rs.getString("boss"));
                tfPhone.setText(rs.getString("phone"));
                tfYear.setText(rs.getString("yearstart"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrMain.class.getName()).log(Level.SEVERE, null, ex);
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

    public int edit(ThongTinSE16 item) {
        lcdb = new LibraryDbConnect();
        con = lcdb.getConnectMySQL();
        int result = 0;
        String sql = "UPDATE thongtinks SET nameKS = ?, address=?, boss=?, phone=?, yearstart=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, tfNameQuan.getText());
            pst.setString(2, tfAdress.getText());
            pst.setString(3, tfBoss.getText());
            try {
                Integer.parseInt(tfPhone.getText());
                pst.setString(4, tfPhone.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Nhập SĐT là số");
                return 0;
            }
            try {
                Integer.parseInt(tfYear.getText());
                pst.setString(5, tfYear.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Nhập năm thành lập là số");
                return 0;
            };
            pst.executeUpdate();
            result = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi câu lệnh");
            ex.printStackTrace();
        } finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi close");
                ex.printStackTrace();
            }
        }
        return result;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btNhapLai;
    private javax.swing.JButton btSua;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbBot;
    private javax.swing.JLabel lbTime;
    private javax.swing.JLabel lbTop;
    private javax.swing.JLabel lbUser;
    private javax.swing.JMenuItem minQLgiaodich;
    private javax.swing.JMenuItem mniDanhSach;
    private javax.swing.JMenuItem mniDoiPass;
    private javax.swing.JMenuItem mniLoaiThucPham;
    private javax.swing.JMenuItem mniSanPham;
    private javax.swing.JMenuItem mniThongKeAll;
    private javax.swing.JPanel pnBot;
    private javax.swing.JPanel pnCenter;
    private javax.swing.JPanel pnCenter1;
    private javax.swing.JPanel pnTop;
    private javax.swing.JTextField tfAdress;
    private javax.swing.JTextField tfBoss;
    private javax.swing.JTextField tfNameQuan;
    private javax.swing.JTextField tfPhone;
    private javax.swing.JTextField tfYear;
    // End of variables declaration//GEN-END:variables
}