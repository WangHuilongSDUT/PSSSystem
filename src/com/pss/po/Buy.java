/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.po;

import java.util.Date;

/**
 *
 * @author po
 */
public class Buy {

    //从供应商那里进货
    private String buyNo;//购买编号
    private int sId;//供应商编号
    private String pNo;//商品编号
    private double price;//购买价格
    private Date buyTime;//购买时间
    private int buyCount;//购买数量

    public Buy() {
    }

    public Buy(String buyNo, int sId, String pNo, double price, Date buyTime, int buyCount) {
        this.buyNo = buyNo;
        this.sId = sId;
        this.pNo = pNo;
        this.price = price;
        this.buyTime = buyTime;
        this.buyCount = buyCount;
    }

    public String getBuyNo() {
        return buyNo;
    }

    public void setBuyNo(String buyNo) {
        this.buyNo = buyNo;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getpNo() {
        return pNo;
    }

    public void setpNo(String pNo) {
        this.pNo = pNo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public int getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
    }

   
    
}
