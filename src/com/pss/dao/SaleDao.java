/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.dao;

import com.pss.po.Sale;
import java.util.List;

/**
 *
 * @author wangh
 */
public interface SaleDao {
    public int AddSale(Sale b);
    public int DeleteSale(String buyNo);
    public List<Sale> QuerySale();
    public List<Sale> QuerySaleByPNoAndCId(String pNo,int cId);
    public List<Sale> QueryBySort();
}
