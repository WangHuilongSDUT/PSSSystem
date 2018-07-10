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
public class Sale {

    private String saleNo;//销售单号
    private String pNo;//商品编号
    private int saleCount;//销售数量
    private double salePrice;//销售单价
    private String cId;//客户编号
    private Date saleTime;//销售时间

    public Sale() {
    }

    public Sale(String saleNo, String pNo, int saleCount, double salePrice, String cId, Date saleTime) {
        this.saleNo = saleNo;
        this.pNo = pNo;
        this.saleCount = saleCount;
        this.salePrice = salePrice;
        this.cId = cId;
        this.saleTime = saleTime;
    }

    public String getSaleNo() {
        return saleNo;
    }

    public void setSaleNo(String saleNo) {
        this.saleNo = saleNo;
    }

    public String getpNo() {
        return pNo;
    }

    public void setpNo(String pNo) {
        this.pNo = pNo;
    }

    public int getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(int saleCount) {
        this.saleCount = saleCount;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    
}
