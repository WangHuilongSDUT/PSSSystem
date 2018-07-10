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
public class Client {
    
    private int cId;//客户编号

    private String cName;//客户姓名
    private String cTele;//客户电话
    private String cAddress;//客户地址
    private String postcodes;//客户邮编


    public Client(){
    }

    public Client(int cId, String cName, String cTele, String cAddress, String postcodes) {
        this.cId = cId;
        this.cName = cName;
        this.cTele = cTele;
        this.cAddress = cAddress;
        this.postcodes = postcodes;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcTele() {
        return cTele;
    }

    public void setcTele(String cTele) {
        this.cTele = cTele;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public String getPostcodes() {
        return postcodes;
    }

    public void setPostcodes(String postcodes) {
        this.postcodes = postcodes;
    }

       
}
