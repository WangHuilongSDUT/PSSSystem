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
public class Supplier {
    //一个供应商对应一个负责人
    //一个供应商只卖一种商品
    
    private int sId;//供应商编号
    private String sName;//供应商姓名
    private int uId;//负责人，即销售员
    private String goods;//供应商所卖的商品
    private double price;//所卖商品的价格
    private String sTele;//供应商电话
    private String firmAddress;//公司地址
    private String plantAddress;//工厂地址
    private String fax;//传真

    public Supplier() {
    }

    public Supplier(int sId, String sName, int uId, String goods, double price, String sTele, String firmAddress, String plantAddress, String fax) {
        this.sId = sId;
        this.sName = sName;
        this.uId = uId;
        this.goods = goods;
        this.price = price;
        this.sTele = sTele;
        this.firmAddress = firmAddress;
        this.plantAddress = plantAddress;
        this.fax = fax;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getsTele() {
        return sTele;
    }

    public void setsTele(String sTele) {
        this.sTele = sTele;
    }

    public String getFirmAddress() {
        return firmAddress;
    }

    public void setFirmAddress(String firmAddress) {
        this.firmAddress = firmAddress;
    }

    public String getPlantAddress() {
        return plantAddress;
    }

    public void setPlantAddress(String plantAddress) {
        this.plantAddress = plantAddress;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    

}
