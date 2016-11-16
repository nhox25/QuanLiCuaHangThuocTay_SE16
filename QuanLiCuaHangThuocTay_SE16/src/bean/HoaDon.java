/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Date;




/**
 *
 * @author Administrator
 */
public class HoaDon {
    private int idHD;
    private String tenKH;
    private String diaChi;
    private String tenSP;
    private int soluong;
    private int gia;
    private int thanhtien;
    private String ghichu;
    private boolean isActive;
    private Date time;
    private int idnhanvien;
    private String username;


    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getIdnhanvien() {
        return idnhanvien;
    }

    public void setIdnhanvien(int idnhanvien) {
        this.idnhanvien = idnhanvien;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
    
    

    public HoaDon() {
    }

    public HoaDon(int idHD, String tenKH, String diaChi, String tenSP, int soluong, int gia, int thanhtien, String ghichu, Date time, String username) {
        this.idHD = idHD;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.tenSP = tenSP;
        this.soluong = soluong;
        this.gia = gia;
        this.thanhtien = thanhtien;
        this.ghichu = ghichu;
        this.time = time;
        this.username = username;
    }

    public HoaDon(int idHD, String tenSP, int soluong, int gia, int thanhtien, String ghichu, boolean isActive) {
        this.idHD = idHD;
        this.tenSP = tenSP;
        this.soluong = soluong;
        this.gia = gia;
        this.thanhtien = thanhtien;
        this.ghichu = ghichu;
        this.isActive = isActive;
    }

    public HoaDon(int idHD, String tenKH, String diaChi, String tenSP, int soluong, int gia, int thanhtien, String ghichu, boolean isActive) {
        this.idHD = idHD;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.tenSP = tenSP;
        this.soluong = soluong;
        this.gia = gia;
        this.thanhtien = thanhtien;
        this.ghichu = ghichu;
        this.isActive = isActive;
    }

    public HoaDon(int idHD, String tenKH, String diaChi, String tenSP, int soluong, int gia, int thanhtien, String ghichu, boolean isActive, Date time) {
        this.idHD = idHD;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.tenSP = tenSP;
        this.soluong = soluong;
        this.gia = gia;
        this.thanhtien = thanhtien;
        this.ghichu = ghichu;
        this.isActive = isActive;
        this.time = time;
    }

    public HoaDon(int idHD, String tenKH, String diaChi, String tenSP, int soluong, int gia, int thanhtien, String ghichu, boolean isActive, Date time, String username) {
        this.idHD = idHD;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.tenSP = tenSP;
        this.soluong = soluong;
        this.gia = gia;
        this.thanhtien = thanhtien;
        this.ghichu = ghichu;
        this.isActive = isActive;
        this.time = time;
        this.username = username;
    }

    
    
    
    
}
