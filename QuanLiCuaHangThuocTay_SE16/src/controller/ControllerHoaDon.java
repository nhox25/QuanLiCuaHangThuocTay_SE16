/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.HoaDon;
import bean.login_user;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.ModelHoaDon;
import model.ModelLogin_user;
import renderer.TableCellRendererTimeStamp;

public class ControllerHoaDon {

    ModelHoaDon modelHoaDon;
    private ModelLogin_user modelLogin_user;

    public ControllerHoaDon() {
        modelHoaDon = new ModelHoaDon();
        modelLogin_user = new ModelLogin_user();
    }

    public Vector vCols() {
        Vector vCols = new Vector();
        vCols.add("ID");
        vCols.add("Tên Kh");
        vCols.add("Địa chỉ");
        vCols.add("Tên thuốc");
        vCols.add("Số lượng");
        vCols.add("Giá");
        vCols.add("Thành tiền");
        vCols.add("Ghi chú");
        return vCols;
    }

    public Vector vRows() {
        Vector vRows = new Vector();
        ArrayList<HoaDon> alItem = modelHoaDon.getList();
        for (HoaDon item1 : alItem) {
            Vector v1 = new Vector();
            v1.add(item1.getIdHD());
            v1.add(item1.getTenKH());
            v1.add(item1.getDiaChi());
            v1.add(item1.getTenSP());
            v1.add(item1.getSoluong());
            v1.add(item1.getGia());
            v1.add(item1.getThanhtien());
            v1.add(item1.getGhichu());

            vRows.add(v1);
        }

        return vRows;
    }

    //Thống kê
    public Vector vColsTK() {
        Vector vCols = new Vector();
        vCols.add("ID");
        vCols.add("Tên thuốc");
        vCols.add("Số lượng");
        vCols.add("Giá");
        vCols.add("Thành tiền");
        vCols.add("Người bán");
        vCols.add("Ngày bán");
        return vCols;
    }

    public Vector vRowsTK() {
        Vector vRows = new Vector();
        ArrayList<HoaDon> alItem = new ArrayList<>();
        ArrayList<login_user> user = modelLogin_user.getUserLogin();
        String username = user.get(0).getFullname();
        String chucvu = user.get(0).getChucvu();
        if (chucvu.equals("Admintors")) {
            alItem = modelHoaDon.getListTK(null);
        } else {
            alItem = modelHoaDon.getListTK(username);
        }
        for (HoaDon item1 : alItem) {
            Vector v1 = new Vector();
            v1.add(item1.getIdHD());
            v1.add(item1.getTenSP());
            v1.add(item1.getSoluong());
            v1.add(item1.getGia());
            v1.add(item1.getThanhtien());
            v1.add(item1.getUsername());
            v1.add(item1.getTime());
            vRows.add(v1);
        }
        return vRows;
    }

    public void loadTable(JTable table, DefaultTableModel model, HoaDon item) {
        table.setModel(model);
        model.setDataVector(vRows(), vCols());
        setWidthHeight(table);
        table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(50);
        table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
        table.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(4).setMinWidth(75);
        table.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(75);

    }

    public void loadTableTK(JTable table, DefaultTableModel model, HoaDon item) {
        table.setModel(model);
        model.setDataVector(vRowsTK(), vColsTK());
        setWidthHeight(table);
        table.getColumnModel().getColumn(6).setCellRenderer(new TableCellRendererTimeStamp());

    }

    public void setWidthHeight(JTable table) {
        table.getTableHeader().setPreferredSize(new Dimension(300, 30));
        table.setRowHeight(26);
    }

    public int add(HoaDon item) {
        int result = 0;
        int k = 0;
        ArrayList<HoaDon> list = new ArrayList<HoaDon>();
        list = modelHoaDon.getList();
        for (int i = 0; i < list.size(); i++) {
            if ((item.getTenSP().equals(list.get(i).getTenSP()))) {
                item.setSoluong(list.get(i).getSoluong() + item.getSoluong());
                int thanhtien = item.getSoluong() * item.getGia();
                item.setThanhtien(thanhtien);
                modelHoaDon.edit(item);
                k = 1;
            }
        }
        if (k == 0) {
            modelHoaDon.add(item);

        }
        result = 1;
        return result;
    }

    public int sub(HoaDon item) {
        int result = 0;
        ArrayList<HoaDon> list = new ArrayList<HoaDon>();
        list = modelHoaDon.getList();
        for (int i = 0; i < list.size(); i++) {
            if ((item.getTenSP().equals(list.get(i).getTenSP()))) {
                item.setSoluong(list.get(i).getSoluong() - item.getSoluong());
                int thanhtien = item.getSoluong() * item.getGia();
                item.setThanhtien(thanhtien);
                modelHoaDon.edit(item);
            }
        }
        result = 1;
        return result;
    }

    public int del(HoaDon item) {
        int result = 0;
        modelHoaDon.del(item);
        result = 1;
        return result;
    }

    public int edit(HoaDon item) {
        int result = 0;
        modelHoaDon.edit(item);
        result = 1;
        return result;
    }

//    public int traban(HoaDon item) {
//        int result = 0;
//        modelHoaDon.traban(item);
//        result = 1;
//        return result;
//    }
    public void in() {
        modelHoaDon.in();
    }
}
