/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.dao;

import com.pss.po.Buy;
import com.pss.po.Product;
import com.pss.util.DBConnection;
import com.pss.util.Tools;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author po
 */
public class BuyImpl implements BuyDao {
    
    @Override
    public int AddBuy(Buy b) {
        //新增采购记录
        //更新商品库存
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ProductDao pDao = new ProductImpl();
        try {
            String sql = "insert into buy(buyNo,sId,pNo,price,buyCount) values(?,?,?,?,?)";

            int result = 0;
            conn = DBConnection.getConnection();

            ps = conn.prepareStatement(sql);
            ps.setString(1, b.getBuyNo());
            ps.setInt(2, b.getsId());
            ps.setString(3, b.getpNo());
            ps.setDouble(4, b.getPrice());
            ps.setInt(5, b.getBuyCount());
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
    public int DeleteBuy(String buyNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int UpdateBuy(Buy b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Buy> QueryBuy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Buy> QueryBuyByTimeAndName(Date dateStart,Date dateEnd,String name) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        if(0==name.length())
        {
            try {
              List<Buy> list = new ArrayList<>();                                                 //返回值
              List<Product> pros=(new ProductImpl()).QueryProduct();                    //查询符合名称的商品s
              for(Product p:pros)                                                                 //迭代查询每一种商品
              {
                  Connection conn = null;           
                  PreparedStatement ps = null;
                  ResultSet rs = null;
                  List<Buy> buyTemp=new ArrayList();
                  conn=DBConnection.getConnection();
                  String sql = "select * from buy where pNo="+"'"+p.getpNo()+"'"+" and buyTime between '"+Tools.DateFormatToSQL(dateStart)+"' and '"+Tools.DateFormatToSQL(dateEnd)+"'";
                  ps=conn.prepareStatement(sql);
                  rs=ps.executeQuery();
                  while(rs.next())
                  {
                      Buy b=new Buy();
                      b.setBuyCount(rs.getInt("buyCount"));
                      b.setBuyNo(rs.getString("buyNo"));
                      b.setBuyTime(rs.getDate("buyTime"));
                      b.setPrice(rs.getDouble("price"));
                      b.setpNo(rs.getString("pNo"));
                      b.setsId(rs.getInt("sId"));
                      buyTemp.add(b);
                  }
                  list.addAll(buyTemp);
              }

              return list;
          } catch (SQLException ex) {
              Logger.getLogger(ClientImpl.class.getName()).log(Level.SEVERE, null, ex);
          }   
        }
        else
        {
            try {
                List<Buy> list = new ArrayList<>();                                                 //返回值
                List<Product> pros=(new ProductImpl()).QueryProductByLikelyName(name);                    //查询符合名称的商品s
                for(Product p:pros)                                                                 //迭代查询每一种商品
                {
                    Connection conn = null;           
                    PreparedStatement ps = null;
                    ResultSet rs = null;
                    List<Buy> buyTemp=new ArrayList();
                    conn=DBConnection.getConnection();
                    String sql = "select * from product where pNo=? and lastBuyTime between ? and ?";
                    ps=conn.prepareStatement(sql);
                    ps.setString(1, p.getpNo());
                    ps.setString(2, dateStart.toString());
                    ps.setString(3,dateEnd.toString());
                    rs=ps.executeQuery();
                    while(rs.next())
                    {
                        Buy b=new Buy();
                        b.setBuyCount(rs.getInt("buyCount"));
                        b.setBuyNo(rs.getString("bNo"));
                        b.setBuyTime(rs.getTime("buyTime"));
                        b.setPrice(rs.getDouble("price"));
                        b.setpNo(rs.getString("pNo"));
                        b.setsId(rs.getInt("sId"));
                        buyTemp.add(b);
                    }
                    list.addAll(buyTemp);
                }

                return list;
            } catch (SQLException ex) {
                Logger.getLogger(ClientImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     return null;   
    }

    @Override
    public List<Buy> QueryBuyByPnoAndSid(String pno, int sid) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Buy> list = new ArrayList<>();                                                 //返回值
        Connection conn = null;           
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn=DBConnection.getConnection();
        String sql = "select * from buy where pNo="+"'"+pno+"'"+" and sId="+sid;
        try{
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {
                Buy b=new Buy();
                b.setBuyCount(rs.getInt("buyCount"));
                b.setBuyNo(rs.getString("buyNo"));
                b.setBuyTime(rs.getDate("buyTime"));
                b.setPrice(rs.getDouble("price"));
                b.setpNo(rs.getString("pNo"));
                b.setsId(rs.getInt("sId"));
                list.add(b);
            }
            return list;
         } catch (SQLException ex) {
              Logger.getLogger(ClientImpl.class.getName()).log(Level.SEVERE, null, ex);
         } 
        return null;
    }

    @Override
    public List<Buy> QueryBuySorted() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Buy> list = new ArrayList<>();                                                 //返回值
        Connection conn = null;           
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn=DBConnection.getConnection();
        String sql = "SELECT * FROM `buy` ORDER BY `pNo` ASC";
        try{
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {
                Buy b=new Buy();
                b.setBuyCount(rs.getInt("buyCount"));
                b.setBuyNo(rs.getString("buyNo"));
                b.setBuyTime(rs.getDate("buyTime"));
                b.setPrice(rs.getDouble("price"));
                b.setpNo(rs.getString("pNo"));
                b.setsId(rs.getInt("sId"));
                list.add(b);
            }
            return list;
         } catch (SQLException ex) {
              Logger.getLogger(ClientImpl.class.getName()).log(Level.SEVERE, null, ex);
         } 
        return null;
    }

}
