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
public class SanPham {
    private int idSanPham;
    private String nameSP;
    private String donvi;
    private String solo;
    private Timestamp handung;
    private String soluong;
    private String dongia;
    private int id_loaithucpham;
    private LoaiThucPham name_loai;

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getNameSP() {
        return nameSP;
    }

    public void setNameSP(String nameSP) {
        this.nameSP = nameSP;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public String getSolo() {
        return solo;
    }

    public void setSolo(String solo) {
        this.solo = solo;
    }

    public Timestamp getHandung() {
        return handung;
    }

    public void setHandung(Timestamp handung) {
        this.handung = handung;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }

    public int getId_loaithucpham() {
        return id_loaithucpham;
    }

    public void setId_loaithucpham(int id_loaithucpham) {
        this.id_loaithucpham = id_loaithucpham;
    }

    public LoaiThucPham getName_loai() {
        return name_loai;
    }

    public void setName_loai(LoaiThucPham name_loai) {
        this.name_loai = name_loai;
    }
    

    public SanPham() {
    }

    public SanPham(int idSanPham, String nameSP, String donvi, String solo, Timestamp handung, String soluong, String dongia, int id_loaithucpham, LoaiThucPham name_loai) {
        this.idSanPham = idSanPham;
        this.nameSP = nameSP;
        this.donvi = donvi;
        this.solo = solo;
        this.handung = handung;
        this.soluong = soluong;
        this.dongia = dongia;
        this.id_loaithucpham = id_loaithucpham;
        this.name_loai = name_loai;
    }

    
    
    
}
