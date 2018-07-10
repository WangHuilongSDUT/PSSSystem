/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.dao;

import com.pss.po.Client;
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
public class ClientImpl implements ClientDao{

    @Override
    public List<Client> QueryClient(String value) {
        try {
            Connection conn = null;
            List<Client> list = new ArrayList<>();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "select * from client where concat(cName) like ?";
            
            
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+value+"%");

            rs = ps.executeQuery();
            while (rs.next()) {
                Client p = new Client();
                p.setcId(Integer.parseInt(rs.getString("cId")));
                p.setcName(rs.getString("cName"));
                p.setcTele(rs.getString("cTele"));
                p.setcAddress(rs.getString("cAddress"));
                p.setPostcodes(rs.getString("postcodes"));
                list.add(p);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
           return null; 
    }

    @Override
    public int AddClient(Client p) {
        try {
            String sql ="insert into client(cName,cTele,cAddress,postcodes) values(?,?,?,?)";
            Connection con = null;
            PreparedStatement pst = null;
            int result = 0;
            con = DBConnection.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1,p.getcName());
            pst.setString(2,p.getcTele());
            pst.setString(3,p.getcAddress());
            pst.setString(4,p.getPostcodes());
            
            
            result = pst.executeUpdate();
            while(result >0){
                return result;
            }        
            
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(ClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int DeleteClient(String cName) {
        try {
            String sql = "delete from client where cName = ?";
            Connection con = null;
            PreparedStatement pst = null;
            int result = 0;
            con = DBConnection.getConnection();
            
            pst = con.prepareStatement(sql);
            pst.setString(1,cName);
            result = pst.executeUpdate();
            while(result >0){
                return result;
                
            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(ClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int UpdateClient(Client p) {
        try {
            String sql = "update client set cTele = ?,cAddress = ?,postcodes = ? where cName = ?";
            Connection con = null;
            PreparedStatement pst = null;
            int result = 0;
            con = DBConnection.getConnection();
            
            pst = con.prepareStatement(sql);
            pst.setString(1, p.getcTele());
            pst.setString(2,p.getcAddress());
            pst.setString(3, p.getPostcodes());
            pst.setString(4, p.getcName());
           
            result = pst.executeUpdate();
            while(result > 0){
                return result;
            
            }
            
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(ClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public boolean IsExist(String cname) {
        try {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "select * from client where cname = ?";
            
            
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, cname);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
            
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(ClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;
    }

   
}
