/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sevval_bilgin_project_reversi;



/**
 *
 * @author hp
 */
public class SevvalBilginUsers {
//kullanıcıların özellikleri
    public static enum ColorName {
        white, black
    }
    public ColorName color;
    public static int gid = 0;
    public int id;
    public String name;
    public String mail;
    public int phone;
    public int score;
    public String password;
    public String address;
    public boolean isLogin;

    public static SevvalBilginUsers player = new SevvalBilginUsers();

    public SevvalBilginUsers() {

        this.id = SevvalBilginUsers.gid;
        SevvalBilginUsers.gid++;

    }

    public SevvalBilginUsers(String name, int score) {
        this.name = name;
        this.score = score;

        this.id = SevvalBilginUsers.gid;
        SevvalBilginUsers.gid++;

    }

    public String getScoreInfos() {
        return this.name + "&" + this.score;
    }

    public void setScoreInfos(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static void updateScore(SevvalBilginUsers user,int a) {
      
       if(user.getColor().compareTo(ColorName.white)==0){
           SevvalBilginGameSceneFrame.user1_score+=a;
       }
       if(user.getColor().compareTo(ColorName.black)==0){
           SevvalBilginGameSceneFrame.user2_score+=a;
       }
      

    }

    @Override
    public String toString() {
        String values = "";

        values = values + this.id + "&" + this.name + "&" + this.mail + "&" + this.phone + "&" + this.address + "&" + this.password + "&";

        return values;
    }

    public void setColorWhite() {
        this.color = ColorName.white;
    }

    public void setColorBlack() {
        this.color = ColorName.black;
    }

    public ColorName getColor() {
        return this.color;
    }

    public static void setPlayertoWhiteUser() {
        SevvalBilginUsers.player = SevvalBilginLogInFrame.entered_users_list[0];
    }

    public static void setPlayertoBlackUser() {
        SevvalBilginUsers.player = SevvalBilginLogInFrame.entered_users_list[1];
    }

    public static SevvalBilginUsers getPlayer() {
        return player;
    }

    public boolean isIsLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public  void setColor(ColorName color) {
        this.color = color;
    }

}
