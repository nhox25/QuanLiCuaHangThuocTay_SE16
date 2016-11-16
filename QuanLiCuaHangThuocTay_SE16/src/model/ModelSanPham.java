/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.LoaiThucPham;
import bean.SanPham;
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
public class ModelSanPham {

    private LibraryDbConnect lcdb;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection con;

    public ModelSanPham() {
        lcdb = new LibraryDbConnect();
    }

    public ArrayList<SanPham> getList() {
        ArrayList<SanPham> alItem = new ArrayList<>();
        try {
            String sql = "Select * FROM sanpham INNER JOIN loaithucpham ON sanpham.id_loai = loaithucpham.id_loai";

            con = lcdb.getConnectMySQL();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                LoaiThucPham loai = new LoaiThucPham(rs.getInt("id_loai"), rs.getString("loai_thucpham"));
                alItem.add(new SanPham(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5), rs.getString(6), rs.getString(7), rs.getInt(8), loai));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelSanPham.class.getName()).log(Level.SEVERE, null, ex);
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

    public int add(SanPham item) {
        con = lcdb.getConnectMySQL();
        int result = 0;
        String sql = "INSERT INTO sanpham(nameSP,donvi,solo,hangdung,soluong,dongia,id_loai) VALUES (?,?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, item.getNameSP());
            pst.setString(2, item.getDonvi());
            pst.setString(3, item.getSolo());
            pst.setTimestamp(4, item.getHandung());
            pst.setString(5, item.getSoluong());
            pst.setString(6, item.getDongia());
            pst.setInt(7, item.getId_loaithucpham());
            pst.executeUpdate();

            rs = pst.getGeneratedKeys();
            if (rs.next()) {
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

    public int del(SanPham item) {
        con = lcdb.getConnectMySQL();
        int result = 0;
        String sql = "DELETE FROM sanpham WHERE idSanPham = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, item.getIdSanPham());
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

    public int edit(SanPham item) {
        con = lcdb.getConnectMySQL();
        int result = 0;
        String sql = "UPDATE sanpham SET nameSP=?, donvi = ?, solo=?,hangdung=?,soluong=?,dongia=?,id_loai=? WHERE idSanPham = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, item.getNameSP());
            pst.setString(2, item.getDonvi());
            pst.setString(3, item.getSolo());
            pst.setTimestamp(4, item.getHandung());
            pst.setString(5, item.getSoluong());
            pst.setString(6, item.getDongia());
            pst.setInt(7, item.getId_loaithucpham());
            pst.setInt(8, item.getIdSanPham());
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
