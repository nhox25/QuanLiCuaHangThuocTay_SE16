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
public class ThongTinSE16 {
    private String nameKS;
    private String address;
    private String boss;
    private String phone;
    private String yearstart;

    public String getNameKS() {
        return nameKS;
    }

    public void setNameKS(String nameKS) {
        this.nameKS = nameKS;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getYearstart() {
        return yearstart;
    }

    public void setYearstart(String yearstart) {
        this.yearstart = yearstart;
    }

    public ThongTinSE16() {
    }

    public ThongTinSE16(String nameKS, String address, String boss, String phone, String yearstart) {
        this.nameKS = nameKS;
        this.address = address;
        this.boss = boss;
        this.phone = phone;
        this.yearstart = yearstart;
    }

    @Override
    public String toString() {
        return nameKS+" || Địa điểm: "+address+" || Giám đốc: "+boss+" || Phone: "+phone+" || Năm thành lập: "+yearstart;
    }
    
    
    
}
