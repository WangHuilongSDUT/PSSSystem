/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.dao;

import com.pss.po.Buy;
import com.pss.po.Supplier;
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
 * @author shi
 */
public class supplierImpl implements supplierdao{
     public List<Supplier> QuerySupplier() {
        Connection conn = null;
        List<Supplier> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from supplier";

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Supplier p = new Supplier();
                p.setsId(rs.getInt("sId"));
                p.setsName(rs.getString("sName"));
                p.setuId(rs.getInt("uId"));
                p.setGoods(rs.getString("goods"));
                p.setPrice(rs.getDouble("price"));
                p.setsTele(rs.getString("sTele"));
                p.setFax(rs.getString("fax"));
                p.setFirmAddress(rs.getString("firmAddress"));
                p.setPlantAddress(rs.getString("plantAddress"));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
     }
    
     public int AddSupplier(Supplier p) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "insert into supplier(sName, uId, goods, price, sTele, fax, firmAddress, plantAddress) values(?,?,?,?,?,?,?,?)";

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,p.getsName());
            ps.setInt(2,p.getuId());
            ps.setString(3,p.getGoods());
            ps.setDouble(4,p.getPrice());
            ps.setString(5,p.getsTele());
            ps.setString(6,p.getFax());
            ps.setString(7,p.getFirmAddress());
            ps.setString(8,p.getPlantAddress());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
     public int DeleteSupplierByName(String sName) {
        try {
            String sql = "delete from supplier where sName = ?";
            Connection con = null;
            PreparedStatement pst = null;
            int result = 0;
            con = DBConnection.getConnection();
            
            pst = con.prepareStatement(sql);
            pst.setString(1,sName);
            result = pst.executeUpdate();
            while(result >0){
                return result;
            }
            return 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
      public int UpdateSupplier(Supplier p) {
           try {
            String sql =  "update supplier set uId = ? , goods = ? , price = ? , sTele =  ? , fax = ? ,  firmAddress = ? , plantAddress = ? where sName = ? ";
            Connection con = null;
            PreparedStatement ps = null;
            int result = 0;
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, p.getuId());
            ps.setString(2, p.getGoods());
            ps.setDouble(3, p.getPrice());
            ps.setString(4, p.getsTele());
            ps.setString(5, p.getFax());
            ps.setString(6, p.getFirmAddress());
            ps.setString(7, p.getPlantAddress());
            ps.setString(8, p.getsName());
            return ps.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         return 0;
      
    }
   public boolean IsExist(String sName) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from supplier where sName = ? ";

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, sName);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
     public List<Buy> QueryBuy(int sid) {
        Connection conn = null;
        List<Buy> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select buyNo,pNo,price,buyCount,buyTime from buy where sId= ? ";

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, sid);
            rs = ps.executeQuery();
            while (rs.next()) {
                Buy p = new Buy();
                p.setBuyNo(rs.getString("buyNo"));
                p.setpNo(rs.getString("pNo"));
                p.setPrice(rs.getDouble("price"));
                p.setBuyCount(rs.getInt("buyCount"));
                p.setBuyTime(rs.getDate("buyTime"));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return null;
     }

    @Override
    public List<Supplier> QuerySupplierByGoods(String goods) {
        Connection conn = null;
        List<Supplier> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from supplier where goods = ?";

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, goods);
            rs = ps.executeQuery();
            while (rs.next()) {
                Supplier p = new Supplier();
                p.setsId(rs.getInt("sId"));
                p.setsName(rs.getString("sName"));
                p.setuId(rs.getInt("uId"));
                p.setGoods(rs.getString("goods"));
                p.setPrice(rs.getDouble("price"));
                p.setsTele(rs.getString("sTele"));
                p.setFax(rs.getString("fax"));
                p.setFirmAddress(rs.getString("firmAddress"));
                p.setPlantAddress(rs.getString("plantAddress"));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return null;
    }
    public List<Supplier> QuerySupplierByName(String sname) {
        Connection conn = null;
        List<Supplier> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from supplier where sName = ?";

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, sname);
            rs = ps.executeQuery();
            while (rs.next()) {
                Supplier p = new Supplier();
                p.setsId(rs.getInt("sId"));
                p.setsName(rs.getString("sName"));
                p.setuId(rs.getInt("uId"));
                p.setGoods(rs.getString("goods"));
                p.setPrice(rs.getDouble("price"));
                p.setsTele(rs.getString("sTele"));
                p.setFax(rs.getString("fax"));
                p.setFirmAddress(rs.getString("firmAddress"));
                p.setPlantAddress(rs.getString("plantAddress"));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return null;
    }

    @Override
    public List<Supplier> QuerySupplierBySId(int sid) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection conn = null;
        List<Supplier> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from supplier where sId = ?";

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, sid);
            rs = ps.executeQuery();
            while (rs.next()) {
                Supplier p = new Supplier();
                p.setsId(rs.getInt("sId"));
                p.setsName(rs.getString("sName"));
                p.setuId(rs.getInt("uId"));
                p.setGoods(rs.getString("goods"));
                p.setPrice(rs.getDouble("price"));
                p.setsTele(rs.getString("sTele"));
                p.setFax(rs.getString("fax"));
                p.setFirmAddress(rs.getString("firmAddress"));
                p.setPlantAddress(rs.getString("plantAddress"));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return null;
    }
}
