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
public class Saleback {
    //客户退货
    private String backNo;//退货单号
    private String saleNo;//销售单号
    private int backNum;//退货数量
    private Date backTime;//退货时间

    public Saleback() {
    }

    public Saleback(String backNo, String saleNo, int backNum, Date backTime) {
        this.backNo = backNo;
        this.saleNo = saleNo;
        this.backNum = backNum;
        this.backTime = backTime;
    }

    public String getBackNo() {
        return backNo;
    }

    public void setBackNo(String backNo) {
        this.backNo = backNo;
    }

    public String getSaleNo() {
        return saleNo;
    }

    public void setSaleNo(String saleNo) {
        this.saleNo = saleNo;
    }

    public int getBackNum() {
        return backNum;
    }

    public void setBackNum(int backNum) {
        this.backNum = backNum;
    }

    public Date getBackTime() {
        return backTime;
    }

    public void setBackTime(Date backTime) {
        this.backTime = backTime;
    }

    
    
}
