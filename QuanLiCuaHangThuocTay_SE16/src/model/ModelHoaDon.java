/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.HoaDon;
import bean.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import library.LibraryDbConnect;

public class ModelHoaDon {

    private Connection conn;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private LibraryDbConnect lcdb;

    public ModelHoaDon() {
        lcdb = new LibraryDbConnect();
    }

    public ArrayList<HoaDon> getList() {
        conn = lcdb.getConnectMySQL();
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        String sql = "SELECT*FROM hoadon where active = 1";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                HoaDon hoadon = new HoaDon(rs.getInt("idHD"), rs.getString("tenKH"), rs.getString("diachi"), rs.getString("tenSP"), rs.getInt("soluong"), rs.getInt("gia"), rs.getInt("thanhtien"), rs.getString("ghichu"), rs.getBoolean("active"), rs.getDate("time"), rs.getString("nhanvien"));
                listHoaDon.add(hoadon);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi câu lệnh sql");
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi câu lệnh sql");
                ex.printStackTrace();
            }
        }

        return listHoaDon;
    }

    public int add(HoaDon item) {
        conn = lcdb.getConnectMySQL();
        int result = 0;
        String sql = "INSERT INTO hoadon(tenKH,diachi,tenSP,soluong,gia,thanhtien,ghichu,time,nhanvien) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, item.getTenKH());
            pst.setString(2, item.getDiaChi());
            pst.setString(3, item.getTenSP());
            pst.setInt(4, item.getSoluong());
            pst.setInt(5, item.getGia());
            pst.setInt(6, item.getThanhtien());
            pst.setString(7, item.getGhichu());
            pst.setDate(8, item.getTime());
            pst.setString(9, item.getUsername());
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
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi close");
                ex.printStackTrace();
            }
        }
        return result;

    }

    public void del(HoaDon item) {
        conn = lcdb.getConnectMySQL();
        int result = 0;
        String sql = "DELETE FROM hoadon WHERE idHD = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, item.getIdHD());
            pst.executeUpdate();
            result = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi câu lệnh sql");
            ex.printStackTrace();
        } finally {
            try {
                pst.close();
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi câu lệnh sql");
                ex.printStackTrace();
            }
        }

    }

    public void edit(HoaDon item) {
        conn = lcdb.getConnectMySQL();
        String sql = "UPDATE hoadon SET tenKH=?,diachi=?, soluong = ? , thanhtien = ?,time=? WHERE tenSP = ?";
        try {
            pst = conn.prepareStatement(sql);

            pst.setString(1, item.getTenKH());
            pst.setString(2, item.getDiaChi());
            pst.setInt(3, item.getSoluong());
            pst.setInt(4, item.getThanhtien());
            pst.setDate(5, (java.sql.Date) item.getTime());
            pst.setString(6, item.getTenSP());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi câu lệnh sql");
            ex.printStackTrace();
        } finally {
            try {
                pst.close();
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi câu lệnh sql");
                ex.printStackTrace();
            }
        }

    }

    public void in() {
        conn = lcdb.getConnectMySQL();
        String sql = "UPDATE hoadon SET active = 0 WHERE active = 1";
        try {
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi câu lệnh sql");
            ex.printStackTrace();
        } finally {
            try {
                pst.close();
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi câu lệnh sql");
                ex.printStackTrace();
            }
        }

    }

    public ArrayList<HoaDon> getListTK(String name) {
        conn = lcdb.getConnectMySQL();
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        String sql = "SELECT*FROM hoadon where active = 0";
        if(name!=null){
            sql+=" and nhanvien= '"+name+"'";
        }
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                HoaDon hoadon = new HoaDon(rs.getInt("idHD"), rs.getString("tenKH"), rs.getString("diachi"), rs.getString("tenSP"), rs.getInt("soluong"), rs.getInt("gia"), rs.getInt("thanhtien"), rs.getString("ghichu"), rs.getBoolean("active"), rs.getDate("time"), rs.getString("nhanvien"));
                listHoaDon.add(hoadon);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi câu lệnh sql");
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi câu lệnh sql");
                ex.printStackTrace();
            }
        }

        return listHoaDon;
    }

    public ArrayList<HoaDon> getList(HoaDon item, Date time, User name) {
        conn = lcdb.getConnectMySQL();
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        String sql = "SELECT*FROM hoadon WHERE 1 ";
        if (item != null) {
            if (item.getTime() instanceof Date) {
                time = item.getTime();
                sql += " && time BETWEEN '" + time.after(time) + "' AND '" + time.before(time) + "'";
            }
            if (name.getFullname() != null) {
                sql += " && nhanvien ='" + name.getFullname() + "'";
            }
        }
        sql += " ORDER BY idHD DESC";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                HoaDon hoadon = new HoaDon(rs.getInt("idHD"), rs.getString("tenKH"), rs.getString("diachi"), rs.getString("tenSP"), rs.getInt("soluong"), rs.getInt("gia"), rs.getInt("thanhtien"), rs.getString("ghichu"), rs.getBoolean("active"), rs.getDate("time"), rs.getString("nhanvien"));
                listHoaDon.add(hoadon);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi câu lệnh sql");
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi câu lệnh sql");
                ex.printStackTrace();
            }
        }

        return listHoaDon;
    }
}
