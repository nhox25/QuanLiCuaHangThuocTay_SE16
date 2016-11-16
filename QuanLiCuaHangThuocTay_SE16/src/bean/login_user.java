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
public class login_user {
    private String user_login;
    private String pass;
    private String fullname;
    private String chucvu;

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
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

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }
    

    public login_user() {
    }

    public login_user(String user_login, String pass) {
        this.user_login = user_login;
        this.pass = pass;
    }

    public login_user(String user_login, String pass, String fullname,String chucvu) {
        this.user_login = user_login;
        this.pass = pass;
        this.fullname = fullname;
        this.chucvu = chucvu;
    }

    @Override
    public String toString() {
        return fullname;
    }

    
    
    
}
