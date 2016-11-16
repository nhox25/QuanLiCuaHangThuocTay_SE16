/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Administrator
 */
public class LoaiThucPham {
    private int id_loai;
    private String loai_thucpham;

    public int getId_loai() {
        return id_loai;
    }

    public void setId_loai(int id_loai) {
        this.id_loai = id_loai;
    }

    public String getLoai_thucpham() {
        return loai_thucpham;
    }

    public void setLoai_thucpham(String loai_thucpham) {
        this.loai_thucpham = loai_thucpham;
    }

    public LoaiThucPham() {
    }

    public LoaiThucPham(int id_loai, String loai_thucpham) {
        this.id_loai = id_loai;
        this.loai_thucpham = loai_thucpham;
    }

    @Override
    public String toString() {
        return loai_thucpham;
    }
    
    
    
    
}
