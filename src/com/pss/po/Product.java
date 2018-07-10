/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.po;

import java.util.Date;

/**
 *
 * @author 161029
 */
public class Product {
    
    private String pNo;//商品编号
    private String pName;//商品名称
    private String type;//商品类型
    private int safeStock;//安全库存,商品当前数量少于安全库存时应发出警报
    private int nowStock;//当前库存
    private double suggestBuy;//建议购买价格
    private double suggestSell;//建议销售价格
    private Date lastBuyTime;//最后一次购买时间
    private Date lastDeliverTime;//最后一次销售时间
    
    public Product(){
    }

    public Product(String pNo, String pName, String type, int safeStock, int nowStock, double suggestBuy, double suggestSell, Date lastBuyTime, Date lastDeliverTime) {
        this.pNo = pNo;
        this.pName = pName;
        this.type = type;
        this.safeStock = safeStock;
        this.nowStock = nowStock;
        this.suggestBuy = suggestBuy;
        this.suggestSell = suggestSell;
        this.lastBuyTime = lastBuyTime;
        this.lastDeliverTime = lastDeliverTime;
    }

    public String getpNo() {
        return pNo;
    }

    public void setpNo(String pNo) {
        this.pNo = pNo;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSafeStock() {
        return safeStock;
    }

    public void setSafeStock(int safeStock) {
        this.safeStock = safeStock;
    }

    public int getNowStock() {
        return nowStock;
    }

    public void setNowStock(int nowStock) {
        this.nowStock = nowStock;
    }

    public double getSuggestBuy() {
        return suggestBuy;
    }

    public void setSuggestBuy(double suggestBuy) {
        this.suggestBuy = suggestBuy;
    }

    public double getSuggestSell() {
        return suggestSell;
    }

    public void setSuggestSell(double suggestSell) {
        this.suggestSell = suggestSell;
    }

    public Date getLastBuyTime() {
        return lastBuyTime;
    }

    public void setLastBuyTime(Date lastBuyTime) {
        this.lastBuyTime = lastBuyTime;
    }

    public Date getLastDeliverTime() {
        return lastDeliverTime;
    }

    public void setLastDeliverTime(Date lastDeliverTime) {
        this.lastDeliverTime = lastDeliverTime;
    }
    
    
    
}
