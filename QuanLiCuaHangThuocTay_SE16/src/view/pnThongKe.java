/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Excel;
import bean.HoaDon;
import bean.User;
import controller.ControllerHoaDon;
import java.awt.Color;
import java.util.ArrayList;
//import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import model.ModelHoaDon;
import renderer.ComboBoxModelNhanVienBan;

/**
 *
 * @author Administrator
 */
public final class pnThongKe extends javax.swing.JPanel {

    private ControllerHoaDon controllerHD;
    private DefaultTableModel model;
    private ModelHoaDon modelHD;
    private int row = 0;

    public pnThongKe() {
        initComponents();
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelHD = new ModelHoaDon();
        controllerHD = new ControllerHoaDon();
        loadTableHoaDon(null);
        loadNhanVien(null, true);
        dateFrom.setEnabled(false);
        dateTo.setEnabled(false);
        getSum();
        tfDoanhthu.setText(+getSum() + " VNĐ");
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
        dateFrom = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        dateTo = new com.toedter.calendar.JDateChooser();
        btActive = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbNhanVien = new javax.swing.JComboBox();
        btView = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfDoanhthu = new javax.swing.JLabel();
        btExcel = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbThongKe = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Từ :");
        jPanel1.add(jLabel1);

        dateFrom.setDateFormatString("dd-MM-yyyy");
        dateFrom.setPreferredSize(new java.awt.Dimension(150, 25));
        dateFrom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dateFromMouseExited(evt);
            }
        });
        dateFrom.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                dateFromCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        dateFrom.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateFromPropertyChange(evt);
            }
        });
        jPanel1.add(dateFrom);

        jLabel2.setText("Đến :");
        jPanel1.add(jLabel2);

        dateTo.setDateFormatString("dd-MM-yyyy");
        dateTo.setPreferredSize(new java.awt.Dimension(150, 25));
        dateTo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dateToMouseExited(evt);
            }
        });
        dateTo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateToPropertyChange(evt);
            }
        });
        dateTo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dateToKeyTyped(evt);
            }
        });
        jPanel1.add(dateTo);

        btActive.setText("v");
        btActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActiveActionPerformed(evt);
            }
        });
        jPanel1.add(btActive);

        jLabel3.setText("Người bán :");
        jPanel1.add(jLabel3);

        cbNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbNhanVien.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNhanVienActionPerformed(evt);
            }
        });
        cbNhanVien.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbNhanVienPropertyChange(evt);
            }
        });
        jPanel1.add(cbNhanVien);

        btView.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btView.setForeground(new java.awt.Color(0, 0, 255));
        btView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/View-icon.png"))); // NOI18N
        btView.setText("Hiển thị");
        btView.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btView.setMinimumSize(new java.awt.Dimension(70, 30));
        btView.setPreferredSize(new java.awt.Dimension(80, 25));
        btView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btViewActionPerformed(evt);
            }
        });
        jPanel1.add(btView);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("Tổng thu :");
        jPanel3.add(jLabel4);

        tfDoanhthu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tfDoanhthu.setForeground(new java.awt.Color(0, 0, 255));
        jPanel3.add(tfDoanhthu);

        btExcel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btExcel.setForeground(new java.awt.Color(0, 153, 0));
        btExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Excel-icon.png"))); // NOI18N
        btExcel.setText("Xuất Excel");
        btExcel.setBorder(null);
        btExcel.setPreferredSize(new java.awt.Dimension(100, 25));
        btExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcelActionPerformed(evt);
            }
        });
        jPanel3.add(btExcel);

        add(jPanel3, java.awt.BorderLayout.PAGE_END);

        tbThongKe.setAutoCreateRowSorter(true);
        tbThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbThongKe);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
        );

        add(jPanel4, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    public void loadTableHoaDon(HoaDon item) {
        controllerHD.loadTableTK(tbThongKe, model, item);
    }
    private void btActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActiveActionPerformed
        if ("v".equals(btActive.getText())) {
            btActive.setText("x");
            btActive.setForeground(Color.red);
            dateFrom.setEnabled(true);
            dateTo.setEnabled(true);
        } else {
            btActive.setText("v");
            btActive.setForeground(new Color(0, 160, 0));
            dateFrom.setEnabled(false);
            dateTo.setEnabled(false);
        }
    }//GEN-LAST:event_btActiveActionPerformed

    private void btViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btViewActionPerformed

        //kiếm theo id_news, tên
        TableRowSorter sorter = new TableRowSorter(tbThongKe.getModel());
        tbThongKe.setRowSorter(sorter);
        ArrayList<RowFilter<AbstractTableModel, Object>> alFilter = new ArrayList<>();

        //kiếm theo id_danh mục
        String id_find_chooser = (String.valueOf(cbNhanVien.getSelectedItem()));
        if (cbNhanVien.getSelectedIndex() != 0) {
            RowFilter<AbstractTableModel, Object> filterID_danhmuc = RowFilter.regexFilter(id_find_chooser, 5);
            alFilter.add(filterID_danhmuc);
        }
        //kiếm theo ngày
        if ("x".equals(btActive.getText())) {

            
            Date timeFrom = dateFrom.getDate();
            Date timeTo = dateTo.getDate();
            if (timeFrom == null|| timeTo == null) {
                JOptionPane.showMessageDialog(null, "Chọn ngày cần xem");
                return;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");       
            
            Calendar timeFr = Calendar.getInstance();
            timeFr.setTime(timeFrom);
            timeFr.add(Calendar.DATE, -1);  // number of days to sub

            Calendar timeT = Calendar.getInstance();
            timeT.setTime(timeTo);
            timeT.add(Calendar.DATE, 1);  // number of days to add
            
            if (timeFrom.after(timeTo)) {
                JOptionPane.showMessageDialog(null, "Chọn ngày không hợp lệ");
                return;
            } else {
                try{
                    RowFilter<AbstractTableModel, Object> filterDateFrom = RowFilter.dateFilter(RowFilter.ComparisonType.AFTER, sdf.parse(sdf.format(timeFr.getTime())), 6);
                    RowFilter<AbstractTableModel, Object> filterDateTo = RowFilter.dateFilter(RowFilter.ComparisonType.BEFORE, sdf.parse(sdf.format(timeT.getTime())), 6);
                    alFilter.add(filterDateFrom);
                    alFilter.add(filterDateTo);
                } catch (Exception ex) {
                    System.err.println(ex);
                }
            }
        }
        RowFilter<AbstractTableModel, Object> filterAnd = RowFilter.andFilter(alFilter);
        sorter.setRowFilter(filterAnd);
        if (tbThongKe.getRowCount() == 0) {
            btExcel.setEnabled(false);
        } else {
            btExcel.setEnabled(true);
        }
        getSum();
        tfDoanhthu.setText(+getSum() + " VNĐ");
    }//GEN-LAST:event_btViewActionPerformed

    private void dateToKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateToKeyTyped
    }//GEN-LAST:event_dateToKeyTyped

    private void dateToMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateToMouseExited
    }//GEN-LAST:event_dateToMouseExited

    private void dateFromMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateFromMouseExited
    }//GEN-LAST:event_dateFromMouseExited

    private void dateFromCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_dateFromCaretPositionChanged
    }//GEN-LAST:event_dateFromCaretPositionChanged

    private void dateFromPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateFromPropertyChange
    }//GEN-LAST:event_dateFromPropertyChange

    private void dateToPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateToPropertyChange
    }//GEN-LAST:event_dateToPropertyChange

    private void btExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcelActionPerformed
        TKExcel();
    }//GEN-LAST:event_btExcelActionPerformed

    private void cbNhanVienPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbNhanVienPropertyChange
    }//GEN-LAST:event_cbNhanVienPropertyChange

    private void cbNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNhanVienActionPerformed
        btExcel.setEnabled(false);
    }//GEN-LAST:event_cbNhanVienActionPerformed
    public void loadNhanVien(User Selected, boolean isSearch) {
        cbNhanVien.setModel(new ComboBoxModelNhanVienBan(Selected, true));
    }

    public double getSum() {
        int row = tbThongKe.getRowCount();
        double sum = 0;
        for (int i = 0; i < row; i++) {
            sum += Double.parseDouble(tbThongKe.getValueAt(i, 4).toString());
        }
        return sum;
    }

    public void TKExcel() {
        Date date = (Date) tbThongKe.getValueAt(row, 6);
        User name = (User) cbNhanVien.getSelectedItem();
        HoaDon hoadon = new HoaDon();
        ArrayList<HoaDon> list = new ArrayList<>();
        list = modelHD.getList(hoadon, date, name);
        JFileChooser fc = new JFileChooser();
        int choose = fc.showSaveDialog(this);
        if (choose == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            if (file.exists()) { // file tồn tại
                int answer = JOptionPane.showConfirmDialog(this, "" + file.getName() + " already exits\n Do you want to replace it?", "Confirm Save As", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (answer == JOptionPane.YES_NO_OPTION) {
                    try {
                        Excel.writeThongKe(list, file + ".xls");
                    } catch (IOException ex) {
                        Logger.getLogger(pnThongKe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else { // file chưa tồn tại
                try {
                    Excel.writeThongKe(list, file + ".xls");
                    JOptionPane.showMessageDialog(null, "Saved!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Can't Saved!");
                }

            }

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btActive;
    private javax.swing.JButton btExcel;
    private javax.swing.JButton btView;
    private javax.swing.JComboBox cbNhanVien;
    private com.toedter.calendar.JDateChooser dateFrom;
    private com.toedter.calendar.JDateChooser dateTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbThongKe;
    private javax.swing.JLabel tfDoanhthu;
    // End of variables declaration//GEN-END:variables
}
