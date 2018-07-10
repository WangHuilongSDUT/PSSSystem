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
public class Refund {
    //向供应商退货
    private String refundNo;//退货单号
    private String buyNo;//采购单号
    private int refundNum;//退货数量
    private Date refundTime;//退货时间

    public String getBuyNo() {
        return buyNo;
    }

    public Refund(String refundNo, String buyNo, int refundNum, Date refundTime) {
        this.refundNo = refundNo;
        this.buyNo = buyNo;
        this.refundNum = refundNum;
        this.refundTime = refundTime;
    }

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    public int getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(int refundNum) {
        this.refundNum = refundNum;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

}
