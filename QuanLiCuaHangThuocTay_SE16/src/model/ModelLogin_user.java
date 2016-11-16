/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.User;
import bean.login_user;
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
import view.FrMain;

/**
 *
 * @author Administrator
 */
public class ModelLogin_user {

    private LibraryDbConnect lcdb;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection con;

    public ModelLogin_user() {
        lcdb = new LibraryDbConnect();
    }

    public ArrayList<User> getList(User username) {
        ArrayList<User> alItem = new ArrayList<>();
        try {
            String sql = "Select * from nhanvien where name like '" + username.getName()+ "'";

            con = lcdb.getConnectMySQL();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                alItem.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getTimestamp(9), rs.getString(10),rs.getString(11)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelLogin_user.class.getName()).log(Level.SEVERE, null, ex);
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

public ArrayList<login_user> getUserLogin() {
        lcdb = new LibraryDbConnect();
        ArrayList<login_user> alItem = new ArrayList<>();
        try {
            String sql = "Select * from login_user";
            con = lcdb.getConnectMySQL();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                alItem.add(new login_user(rs.getString("username"), rs.getString("pass"), rs.getString("fullname"), rs.getString("chucvu")));
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
    public int add_user_login(login_user item) {
        con = lcdb.getConnectMySQL();
        int result = 0;
        String sql = "INSERT INTO login_user(username,pass,fullname,chucvu) VALUES (?,?,?,?)";
        try {
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, item.getUser_login());
            pst.setString(2, library.LibraryString.md5(item.getPass()));
            pst.setString(3, item.getFullname());
            pst.setString(4, item.getChucvu());
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

    public int del_user_login() {
        con = lcdb.getConnectMySQL();
        int result = 0;
        String sql = "DELETE FROM login_user";

        try {
            pst = con.prepareStatement(sql);
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
    public int chage_pass(String name, String oldPass, String newPass){
        con = lcdb.getConnectMySQL();
        int result = 0;
        String sql = "UPDATE nhanvien SET pass = ? WHERE name = '"+name+"' and pass ='"+library.LibraryString.md5(oldPass)+"'";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, library.LibraryString.md5(newPass));
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
