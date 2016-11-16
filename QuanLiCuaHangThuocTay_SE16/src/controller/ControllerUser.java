/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ModelUser;
import bean.User;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class ControllerUser extends AbstractTableModel {

    private ArrayList<User> alItem = new ArrayList<>();
    private String[] arCol = {"ID", "Tên nhân viên", "Giới tính", "Chức vụ","Địa chỉ","Mức lương","Ngày sinh","Hình ảnh","Giới thiệu"};
    private JTable table;
    private ModelUser mUser;

    public ControllerUser(JTable table) {
        this.table = table;
        mUser = new ModelUser();
        alItem = mUser.getList();
    }

    @Override
    public int getRowCount() {
        return alItem.size();
    }

    @Override
    public int getColumnCount() {
        return arCol.length;
    }

    @Override
    public String getColumnName(int i) {
        return arCol[i];
    }

    @Override
    public Class<?> getColumnClass(int i) {
        if (i == 0) {
            return Integer.class;
        }
        return super.getColumnClass(i);

    }

    @Override
    public Object getValueAt(int i, int i1) {
        User objUser = alItem.get(i);
        Object value = null;
        switch (i1) {
            case 0:
                value = objUser.getId();
                break;
            case 1:
                value = objUser.getFullname();
                break;
            case 2:
                value = objUser.getGioitinh();
                break;
            case 3:
                value = objUser.getChucvu();
                break;
            case 4:
                value = objUser.getDiachi();
                break;
            case 5:
                value = objUser.getLuong();
                break;
            case 6:
                value = objUser.getNgaysinh();
                break;
            case 7:
                value = objUser.getHinhanh();
                break;
            case 8:
                value = objUser.getTtt();
                break;
        }
        return value;
    }

    public void loadTable() {
        table.setModel(this);
        table.getTableHeader().setPreferredSize(new Dimension(0, 30));
        table.setRowHeight(28);
        table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(50);
        table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
        table.getTableHeader().getColumnModel().getColumn(7).setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(8).setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(0);
    }

    public int delItem(int row, User objUser) {
        //del DB
        mUser.del(objUser);
        
        //del model
        int rowModel = table.convertRowIndexToModel(row);
        alItem.remove(rowModel);
        fireTableDataChanged();
        return 1;
    }

    public boolean checkUsername(User username) {
        User m = mUser.getUserByUsername(username.getName());
        if (m != null) {
            return true;
        } else {
            return false;
        }
    }
    public User checkIdUser(User objUser){
        return  mUser.getUserById(objUser.getId());
    }
    public User CheckLogin(String username, String password) {
        return mUser.CheckLogin(username, password);
    }

}
