/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.dao;

import com.pss.po.Buy;
import com.pss.po.Supplier;
import java.util.List;

/**
 *
 * @author shi
 */
public interface supplierdao {
    public List<Supplier> QuerySupplier();
    public List<Supplier> QuerySupplierByGoods(String goods);
    public int AddSupplier(Supplier p);
    public int DeleteSupplierByName(String sName);
    public int UpdateSupplier(Supplier p);
    public boolean IsExist(String sName);
    public List<Buy> QueryBuy(int sid);
    public List<Supplier> QuerySupplierByName(String sname);
    public List<Supplier> QuerySupplierBySId(int sid);
}
