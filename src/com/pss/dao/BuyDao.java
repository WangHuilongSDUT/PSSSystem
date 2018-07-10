/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.dao;

import com.pss.po.Buy;
import java.util.Date;
import java.util.List;

/**
 *
 * @author po
 */
public interface BuyDao {
    public int AddBuy(Buy b);
    public int DeleteBuy(String buyNo);
    public int UpdateBuy(Buy b);//退货时更新
    public List<Buy> QueryBuy();
    public List<Buy> QueryBuySorted();
    public List<Buy> QueryBuyByPnoAndSid(String pno,int sid);
    public List<Buy> QueryBuyByTimeAndName(Date dateStart,Date dateEnd,String name);
}
