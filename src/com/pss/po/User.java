/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.po;

/**
 *
 * @author 161029
 */
public class User {
    //用户分为超级管理员和销售员
    //用户可以修改自己的密码
    //超级管理员拥有所有的权限
    //销售员是供应商的负责人
    //一个销售员能对应多个供应商
    
    private int uId;//用户编号
    private String uName;//用户姓名
    private String password;//登录密码
    private String position;//职位或离职 
    private String uTele;//电话
    private String uAddress;//家庭住址
    private String authority;//用户权限
    private String sex;//性别
    private String nativePlace;//户籍所在地
    private String email;//邮箱
    
    public User(){
    }

    public User(int uId, String uName, String password, String position, String uTele, String uAddress, String authority, String sex, String nativePlace, String email) {
        this.uId = uId;
        this.uName = uName;
        this.password = password;
        this.position = position;
        this.uTele = uTele;
        this.uAddress = uAddress;
        this.authority = authority;
        this.sex = sex;
        this.nativePlace = nativePlace;
        this.email = email;
    }

    public User(String name, String position, String phone, String address, String sex, String place, String email) {
        this.uName=name;
        this.position=position;
        this.uTele=phone;
        this.uAddress=address;
        this.sex=sex;
        this.nativePlace=place;
        this.email=email;
    }

    public User(int id, String name, String address, String position, String sex, String place, String email, String phone) {
        this.uId=id;
        this.uName=name;
        this.position=position;
        this.uTele=phone;
        this.uAddress=address;
        this.sex=sex;
        this.nativePlace=place;
        this.email=email;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getuTele() {
        return uTele;
    }

    public void setuTele(String uTele) {
        this.uTele = uTele;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
