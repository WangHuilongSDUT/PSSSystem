/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.dao;

import com.pss.po.Product;
import com.pss.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zz
 */
public class ProductImpl implements ProductDao {

    DBConnection db = new DBConnection();

    @Override
    public int AddProduct(Product p) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "insert into product(pNo,pName,safeStock,type,suggestBuy,suggestSell,nowStock) values(?,?,?,?,?,?,?)";

            int result = 0;
            conn = DBConnection.getConnection();

            ps = conn.prepareStatement(sql);
            ps.setString(1, p.getpNo());
            ps.setString(2, p.getpName());
            ps.setInt(3, p.getSafeStock());
            ps.setString(4, p.getType());
            ps.setDouble(5, p.getSuggestBuy());
            ps.setDouble(6, p.getSuggestSell());
            ps.setInt(7, 0);
            result = ps.executeUpdate();
            while (result > 0) {
                return result;
            }
            return 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public int DeleteProduct(String pName) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "delete from product where pName = ?";
            int result = 0;
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, pName);
            result = ps.executeUpdate();
            while (result > 0) {
                return result;
            }
            return 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return 0;
    }

    public int UpdateProduct(Product p) {
        String sql = "update product set safeStock =?, type = ?,suggestBuy = ?,suggestSell = ? where pName = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            int result = 0;
            conn = db.getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getSafeStock());
            ps.setString(2, p.getType());
            ps.setDouble(3, p.getSuggestBuy());
            ps.setDouble(4, p.getSuggestSell());
            ps.setString(5, p.getpName());
            result = ps.executeUpdate();
            while (result > 0) {
                return result;
            }
            return 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    public List<Product> QueryProduct() {
        Connection conn = null;
        List<Product> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from product";
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setpNo(rs.getString("pNo"));
                p.setpName(rs.getString("pName"));
                p.setSafeStock(rs.getInt("safeStock"));
                p.setType(rs.getString("type"));
                p.setSuggestBuy(rs.getDouble("suggestBuy"));

                p.setSuggestSell(rs.getDouble("suggestSell"));
                p.setNowStock(rs.getInt("nowStock"));
                p.setLastBuyTime(rs.getDate("lastBuyTime"));

                p.setLastBuyTime(rs.getDate("lastBuyTime"));
                p.setLastDeliverTime(rs.getDate("lastDeliverTime"));

                list.add(p);
            }
            return list;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> QueryProductByValue(String value) {
        Connection conn = null;
        List<Product> list = new ArrayList<Product>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from product where concat(pName,type) like ?";
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+value+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setpName(rs.getString("pName"));
                p.setSafeStock(rs.getInt("safeStock"));
                p.setType(rs.getString("type"));
                p.setSuggestBuy(rs.getDouble("suggestBuy"));
                p.setNowStock(rs.getInt("nowStock"));
                p.setSuggestSell(rs.getDouble("suggestSell"));
                p.setLastBuyTime(rs.getDate("lastBuyTime"));
                p.setLastDeliverTime(rs.getDate("lastDeliverTime"));

                list.add(p);
            }
            return list;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Product> QueryProductByName(String pname) {
        try {
            Connection conn = null;
            List<Product> list = new ArrayList<>();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "select * from product where pName = ?";

            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, pname);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setpNo(rs.getString("pNo"));
                p.setpName(rs.getString("pName"));
                p.setType(rs.getString("type"));
                p.setSafeStock(rs.getInt("safeStock"));
                p.setSuggestBuy(rs.getDouble("suggestBuy"));
                p.setNowStock(rs.getInt("nowStock"));
                p.setSuggestSell(rs.getDouble("suggestSell"));
                p.setLastBuyTime(rs.getDate("lastBuyTime"));
                p.setLastDeliverTime(rs.getDate("lastDeliverTime"));

                list.add(p);
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public List<Product> QueryProductByLikelyName(String pname) {
        try {
            Connection conn = null;
            List<Product> list = new ArrayList<>();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "select * from product where concat(pName) like ?";

            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, pname);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setpNo(rs.getString("pNo"));
                p.setpName(rs.getString("pName"));
                p.setType(rs.getString("type"));
                p.setSafeStock(rs.getInt("safeStock"));
                p.setSuggestBuy(rs.getDouble("suggestBuy"));
                p.setNowStock(rs.getInt("nowStock"));
                p.setSuggestSell(rs.getDouble("suggestSell"));
                p.setLastBuyTime(rs.getDate("lastBuyTime"));
                p.setLastDeliverTime(rs.getDate("lastDeliverTime"));

                list.add(p);
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Product> QueryProductByType(String type) {
        try {
            Connection conn = null;
            List<Product> list = new ArrayList<>();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "select * from product where type = ?";

            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, type);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setpNo(rs.getString("pNo"));
                p.setpName(rs.getString("pName"));
                 p.setType(rs.getString("type"));
                p.setSafeStock(rs.getInt("safeStock"));
                p.setSuggestBuy(rs.getDouble("suggestBuy"));
                p.setNowStock(rs.getInt("nowStock"));
                p.setSuggestSell(rs.getDouble("suggestSell"));
                p.setLastBuyTime(rs.getDate("lastBuyTime"));
                p.setLastDeliverTime(rs.getDate("lastDeliverTime"));

                list.add(p);
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean IsExist(String pname) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String sql = "select * from product where pname = ?";

            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, pname);

            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }

            return false;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return false;
    }

    @Override
    public int UpdateProductStock(String pNo, int add) {
        String sql = "update product set nowStock = nowStock+? where pNo = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
           
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, add);
            ps.setString(2, pNo);
           
            return ps.executeUpdate();
        } catch (SQLException ex) {
        } finally{
            //DBConnection.close(conn, ps, rs);
        }
        return 0;
    }
    @Override
    public int UpdateProductStockPlus(String pNo, int add) {
        String sql = "update product set nowStock = nowStock-? where pNo = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
           
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, add);
            ps.setString(2, pNo);
            return ps.executeUpdate();
        } catch (SQLException ex) {
        } finally{
            //DBConnection.close(conn, ps, rs);
        }
        return 0;
    }

    @Override
    public List<Product> QueryProductByPNo(String pno) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      try {
            Connection conn = null;
            List<Product> list = new ArrayList<>();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "select * from product where pNo = ?";

            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, pno);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setpNo(rs.getString("pNo"));
                p.setpName(rs.getString("pName"));
                p.setType(rs.getString("type"));
                p.setSafeStock(rs.getInt("safeStock"));
                p.setSuggestBuy(rs.getDouble("suggestBuy"));
                p.setNowStock(rs.getInt("nowStock"));
                p.setSuggestSell(rs.getDouble("suggestSell"));
                p.setLastBuyTime(rs.getDate("lastBuyTime"));
                p.setLastDeliverTime(rs.getDate("lastDeliverTime"));

                list.add(p);
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
