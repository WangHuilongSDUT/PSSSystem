/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.dao;

import com.pss.po.Sale;
import com.pss.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wangh
 */
public class SaleImpl implements SaleDao {

    @Override
    public int AddSale(Sale b) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
     Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ProductDao pDao = new ProductImpl();
        try {
            //这里字符串要加的单引号
            String sql = "insert into sale(saleNo,pNo,saleCount,salePrice,cId) values("+"'"+b.getSaleNo()+"','"+b.getpNo()+"',"+b.getSaleCount()+","+b.getSalePrice()+",'"+b.getcId()+"'"+")";

            int result = 0;
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);

            if((ps.executeUpdate()>0)){
                return 1;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            //DBConnection.close(conn, ps, rs);
        }
        return 0;
    
    }

    @Override
    public int DeleteSale(String buyNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public List<Sale> QuerySale() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            List<Sale> list = new ArrayList<>();                                                 //返回值
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            conn = DBConnection.getConnection();
            String sql = "select * from sale";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sale b = new Sale();
                b.setSaleCount(Integer.parseInt(rs.getString("saleCount")));
                b.setSaleNo(rs.getString("saleNo"));
                b.setSalePrice(Double.parseDouble(rs.getString("salePrice")));
                b.setSaleTime(rs.getDate("saleTime"));
                b.setcId(rs.getString("cId"));
                b.setpNo(rs.getString("pNo"));
                list.add(b);
            }
            return list;
          } catch (SQLException ex) {
              Logger.getLogger(ClientImpl.class.getName()).log(Level.SEVERE, null, ex);
          }   
        return null;
    }

    @Override
    public List<Sale> QuerySaleByPNoAndCId(String pNo, int cId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Sale> saleList = new ArrayList();
        conn = DBConnection.getConnection();
        String sql = "select * from sale where pNo=" + "'" + pNo + "'" + " and cId=" + cId;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sale b = new Sale();
                b.setSaleCount(rs.getInt("saleCount"));
                b.setSaleNo(rs.getString("saleNo"));
                b.setSaleTime(rs.getTime("saleTime"));
                b.setSalePrice(rs.getDouble("salePrice"));
                b.setpNo(rs.getString("pNo"));
                b.setcId(""+rs.getInt("cId"));
                saleList.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaleImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return saleList;
    }

    @Override
    public List<Sale> QueryBySort() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Sale> saleList = new ArrayList();
        conn = DBConnection.getConnection();
        String sql = "SELECT * FROM `sale` ORDER BY `saleCount` DESC" ;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sale b = new Sale();
                b.setSaleCount(rs.getInt("saleCount"));
                b.setSaleNo(rs.getString("saleNo"));
                b.setSaleTime(rs.getTime("saleTime"));
                b.setSalePrice(rs.getDouble("salePrice"));
                b.setpNo(rs.getString("pNo"));
                b.setcId(""+rs.getInt("cId"));
                saleList.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaleImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return saleList;
    }
}
