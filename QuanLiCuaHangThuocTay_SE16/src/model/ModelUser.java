/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.User;
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
import library.LibraryString;

/**
 *
 * @author Administrator
 */
public class ModelUser {

    private LibraryDbConnect lcdb;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection con;

    public ModelUser() {
        lcdb = new LibraryDbConnect();
    }

    public ArrayList<User> getList() {
        ArrayList<User> alItem = new ArrayList<>();
        try {
            String sql = "Select * from nhanvien";

            con = lcdb.getConnectMySQL();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                alItem.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getTimestamp(9), rs.getString(10),rs.getString(11)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelUser.class.getName()).log(Level.SEVERE, null, ex);
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
    public ArrayList<User> getList(String username) {
        ArrayList<User> alItem = new ArrayList<>();
        try {
            String sql = "Select * from nhanvien where name= '"+username+"'";

            con = lcdb.getConnectMySQL();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                alItem.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getTimestamp(9), rs.getString(10),rs.getString(11)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelUser.class.getName()).log(Level.SEVERE, null, ex);
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

    public int add(User item) {
        con = lcdb.getConnectMySQL();
        int result = 0;
        String sql = "INSERT INTO nhanvien(name,pass,fullname,luong,hinhanh,gioitinh,chucvu,ngaysinh,diachi,ttt) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, item.getName());
            pst.setString(2, LibraryString.md5(item.getPass()));
            pst.setString(3, item.getFullname());
            pst.setString(4, item.getLuong());
            pst.setString(5, item.getHinhanh());
            pst.setString(6, item.getGioitinh());
            pst.setString(7, item.getChucvu());
            pst.setTimestamp(8, item.getNgaysinh());
            pst.setString(9, item.getDiachi());
            pst.setString(10, item.getTtt());
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

    public int edit(User item) {
        con = lcdb.getConnectMySQL();
        int result = 0;
        String sql = "";
        try {
            if (!item.getPass().isEmpty()) {
                sql = "UPDATE nhanvien SET name = ?,pass=?,fullname=?,luong=?,hinhanh=?,gioitinh=?,chucvu=?,ngaysinh=?,diachi=?,ttt=? WHERE idNhanVien = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, item.getName());
                pst.setString(2, library.LibraryString.md5(item.getPass()));
                pst.setString(3, item.getFullname());
                pst.setString(4, item.getLuong());
                pst.setString(5, item.getHinhanh());
                pst.setString(6, item.getGioitinh());
                pst.setString(7, item.getChucvu());
                pst.setTimestamp(8, item.getNgaysinh());
                pst.setString(9, item.getDiachi());
                pst.setString(10, item.getTtt());
                pst.setInt(11, item.getId());
            } else {
                sql = "UPDATE nhanvien SET name = ?,fullname=?,luong=?,hinhanh=?,gioitinh=?,chucvu=?,ngaysinh=?,diachi=?,ttt=? WHERE idNhanVien = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, item.getName());
                pst.setString(2, item.getFullname());
                pst.setString(3, item.getLuong());
                pst.setString(4, item.getHinhanh());
                pst.setString(5, item.getGioitinh());
                pst.setString(6, item.getChucvu());
                pst.setTimestamp(7, item.getNgaysinh());
                pst.setString(8, item.getDiachi());
                pst.setString(9, item.getTtt());
                pst.setInt(10, item.getId());
            }
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

    public int del(User item) {
        con = lcdb.getConnectMySQL();
        int result = 0;
        String sql = "DELETE FROM nhanvien WHERE idNhanVien = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, item.getId());
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

    public User getUserByUsername(String username) {
        con = lcdb.getConnectMySQL();
        User item = null;
        String sql = "SELECT * FROM nhanvien WHERE name = '" + username + "' LIMIT 1 ";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                item = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getTimestamp(9), rs.getString(10),rs.getString(11));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi câu lệnh");
            ex.printStackTrace();
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
        return item;
    }

    
    public User getUserById(int id) {
    
        
        con = lcdb.getConnectMySQL();
        User item = null;
        String sql = "SELECT * FROM nhanvien WHERE idNhanVien = '" + id + "' LIMIT 1 ";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                item = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getTimestamp(9), rs.getString(10),rs.getString(11));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi câu lệnh");
            ex.printStackTrace();
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
        return item;
    }

    public User CheckLogin(String username, String password) {
        User user = null;
        con = lcdb.getConnectMySQL();
        String sql = "SELECT * FROM nhanvien WHERE name = '" + username + "' && pass = '" + LibraryString.md5(password) + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getTimestamp(9), rs.getString(10),rs.getString(11));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
}
