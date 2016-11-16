/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.SanPham;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import model.ModelSanPham;
import renderer.TableCellRendererTimeStamp;

/**
 *
 * @author Administrator
 */
public class ControllerSanPham extends AbstractTableModel {

    private ArrayList<SanPham> alItem = new ArrayList<>();
    private String[] arCol = {"ID", "Tên sản phẩm", "Loại", "Đơn vị", "Số lô", "Hạn dùng", "Số lượng", "Đơn giá"};
    private JTable table;
    private ModelSanPham model;

    public ControllerSanPham(JTable table) {
        this.table = table;
        model = new ModelSanPham();
        alItem = model.getList();

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
        SanPham obj = alItem.get(i);
        Object value = null;
        switch (i1) {
            case 0:
                value = obj.getIdSanPham();
                break;
            case 1:
                value = obj.getNameSP();
                break;
            case 2:
                value = obj.getName_loai();
                break;
            case 3:
                value = obj.getDonvi();
                break;
            case 4:
                value = obj.getSolo();
                break;
            case 5:
                value = obj.getHandung();
                break;
            case 6:
                value = obj.getSoluong();
                break;
            case 7:
                value = obj.getDongia();
                break;
        }
        return value;
    }

    public void loadTable() {
        table.setModel(this);
        table.getTableHeader().setPreferredSize(new Dimension(0, 30));
        table.setRowHeight(28);
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(130);
        table.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
        table.getColumnModel().getColumn(5).setCellRenderer(new TableCellRendererTimeStamp());
    }

    public int addItem(SanPham obj) {

        //add DB
        int id = model.add(obj);
        //add model
        obj.setIdSanPham(id);
        alItem.add(obj);
        fireTableDataChanged(); // load lại form

        return id;
    }

    public int delItem(int row, SanPham obj) {
        //del DB
        model.del(obj);

        //del model
        int rowModel = table.convertRowIndexToModel(row);
        alItem.remove(rowModel);
        fireTableDataChanged();
        return 1;
    }

    public int edit(int row, SanPham obj) {
        //edit DB
        model.edit(obj);
        //edit mmodel
        int rowModel = table.convertRowIndexToModel(row);
        alItem.set(rowModel, obj);
        fireTableRowsUpdated(rowModel, rowModel);
        table.setRowSelectionInterval(row, row);
        return 1;
    }

}
