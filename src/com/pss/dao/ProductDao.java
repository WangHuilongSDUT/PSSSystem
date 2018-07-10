/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.dao;

import com.pss.po.Product;
import java.util.List;

/**
 *
 * @author zz
 */
public interface ProductDao {
        public List<Product> QueryProduct() ;
        public List<Product> QueryProductByValue(String value) ;
        public List<Product> QueryProductByName(String pname) ;
        public List<Product> QueryProductByPNo(String pno) ;
        public List<Product> QueryProductByLikelyName(String pname);
        public List<Product> QueryProductByType(String type) ;
        public int AddProduct(Product p) ;
        public int DeleteProduct(String pName) ;
        public int UpdateProduct(Product p) ;
        public int UpdateProductStock(String pNo,int add) ;
        public int UpdateProductStockPlus(String pNo, int add); 
        public boolean IsExist(String pname) ;

    
}
