/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.LoaiThucPham;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import model.ModelLoaiThucPham;

/**
 *
 * @author Administrator
 */
public class ControllerLoaiThucPham extends AbstractTableModel{
    private ArrayList<LoaiThucPham> alItem = new ArrayList<>();
    private String[] arCol = {"ID","Loại thực phẩm"};
    private JTable table;
    private ModelLoaiThucPham mLoaiThucpham;
    
    public ControllerLoaiThucPham(JTable table){
        this.table = table;
        mLoaiThucpham = new ModelLoaiThucPham();
        alItem = mLoaiThucpham.getList();
        
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
        if(i == 0){
            return Integer.class;
        }
        return super.getColumnClass(i);
    }
    
    
    @Override
    public Object getValueAt(int i, int i1) {
        LoaiThucPham objTang = alItem.get(i);
        Object value = null;
        switch(i1){
            case 0:
                value = objTang.getId_loai();
            break;
            case 1:
                value = objTang.getLoai_thucpham();
            break;
        }
        return value;
    }

    public void loadTable() {
       table.setModel(this);
       table.getTableHeader().setPreferredSize(new Dimension(0, 30));
       table.setRowHeight(28);
       table.getColumnModel().getColumn(1).setPreferredWidth(600);
    }

    public int addItem(LoaiThucPham obj) {
        
        //add DB
        int id = mLoaiThucpham.add(obj);
        //add model
        obj.setId_loai(id);
        alItem.add(obj);
        fireTableDataChanged(); // load lại form
        
        return id;
    }

    public int delItem(int row, LoaiThucPham obj) {
        //del DB
        mLoaiThucpham.del(obj);
        
        //del model
        int rowModel = table.convertRowIndexToModel(row);
        alItem.remove(rowModel);
        fireTableDataChanged();
        return 1;
    }

    public int edit(int row, LoaiThucPham obj) {
        //edit DB
        mLoaiThucpham.edit(obj);
        //edit mmodel
        int rowModel = table.convertRowIndexToModel(row);
        alItem.set(rowModel, obj);
        fireTableRowsUpdated(rowModel, rowModel);
        table.setRowSelectionInterval(row, row);
        return 1;
    }
    
}
