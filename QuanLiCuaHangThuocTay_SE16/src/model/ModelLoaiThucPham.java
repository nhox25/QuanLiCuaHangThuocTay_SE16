/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.LoaiThucPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import library.LibraryDbConnect;

/**
 *
 * @author Administrator
 */
public class ModelLoaiThucPham {

    private LibraryDbConnect lcdb;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection con;

    public ModelLoaiThucPham() {
        lcdb = new LibraryDbConnect();
    }

    public ArrayList<LoaiThucPham> getList() {
        ArrayList<LoaiThucPham> alItem = new ArrayList<>();
        try {
            String sql = "Select * from loaithucpham";

            con = lcdb.getConnectMySQL();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                alItem.add(new LoaiThucPham(rs.getInt("id_loai"), rs.getString("loai_thucpham")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelLoaiThucPham.class.getName()).log(Level.SEVERE, null, ex);
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
    public int add(LoaiThucPham item) {
        con = lcdb.getConnectMySQL();
        int result = 0;
        String sql = "INSERT INTO loaithucpham(loai_thucpham) VALUES (?)";
        try {
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, item.getLoai_thucpham());
            pst.executeUpdate();
            
            rs = pst.getGeneratedKeys();
            if(rs.next()){
                result = rs.getInt(1);
            }
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

    public int del(LoaiThucPham item) {
        con = lcdb.getConnectMySQL();
        int result = 0;
        String sql = "DELETE FROM loaithucpham WHERE id_loai = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, item.getId_loai());
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

    public int edit(LoaiThucPham item) {
        con = lcdb.getConnectMySQL();
        int result = 0;
        String sql = "UPDATE loaithucpham SET loai_thucpham = ? WHERE id_loai = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, item.getLoai_thucpham());
            pst.setInt(2, item.getId_loai());
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
}
