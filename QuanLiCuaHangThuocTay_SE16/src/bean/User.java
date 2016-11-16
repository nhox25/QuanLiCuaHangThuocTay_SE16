/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Timestamp;

/**
 *
 * @author Administrator
 */
public class User {
    private int id;
    private String name;
    private String pass;
    private String fullname;
    private String luong;
    private String hinhanh;
    private String gioitinh;
    private String chucvu;
    private Timestamp ngaysinh;
    private String diachi;
    private String ttt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public Timestamp getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Timestamp ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getTtt() {
        return ttt;
    }

    public void setTtt(String ttt) {
        this.ttt = ttt;
    }
    

    public User() {
    }

    public User(int id, String name, String pass, String fullname, String luong, String hinhanh, String gioitinh, String chucvu, Timestamp ngaysinh, String diachi, String ttt) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.fullname = fullname;
        this.luong = luong;
        this.hinhanh = hinhanh;
        this.gioitinh = gioitinh;
        this.chucvu = chucvu;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.ttt = ttt;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String name, String pass, String fullname) {
        this.name = name;
        this.pass = pass;
        this.fullname = fullname;
    }

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }
    

    
    @Override
    public String toString() {
        return fullname;
    }
    
    
}
