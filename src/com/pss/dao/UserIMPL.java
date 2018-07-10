/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.dao;

import com.pss.po.User;
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
 * @author 161029
 */
public class UserIMPL implements IUser{

    @Override
    public List<User> getUser(String str) {
        List<User> list = new ArrayList<User>();
        String sql = "select * from user where concat(uName,sex,position) like ?";//？ 可以给它看成是一个动态的参数
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        //获取连接
        con = DBConnection.getConnection();
        try {
            pst=con.prepareStatement(sql);//加载定义好的sql语句 并将sql提交到数据库
            pst.setString(1, "%"+str+"%");
            rs = pst.executeQuery();//执行查询
            while(rs.next()){
                User p = new User();
                p.setuId(rs.getInt("uId"));
                p.setuName(rs.getString("uName"));
                p.setPosition(rs.getString("position"));
                p.setuTele(rs.getString("uTele"));
                p.setuAddress(rs.getString("uAddress"));
                p.setSex(rs.getString("sex"));
                p.setNativePlace(rs.getString("nativePlace"));
                p.setEmail(rs.getString("email"));
                list.add(p);
    
            }
      
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
        return list;
    }

    @Override
    public int addUser(User p) {
        
        String sql ="insert into user(uName,position,uTele,uAddress,sex,nativePlace,email) values(?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, p.getuName());
            pst.setString(2, p.getPosition());
            pst.setString(3, p.getuTele());
            pst.setString(4, p.getuAddress());
            pst.setString(5, p.getSex());
            pst.setString(6, p.getNativePlace());
            pst.setString(7, p.getEmail());
            result = pst.executeUpdate();
            while(result >0){
                return result;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public boolean isExit(String uTele, String email) {
        
        String sql = "select * from user where uTele=?and email=?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
                
        try {
            con=DBConnection.getConnection();
            pst=con.prepareStatement(sql);
            pst.setString(1, uTele);
            pst.setString(2, email);
            rs=pst.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public int UpdateUser(User p) {
        
        String sql = "update user set uName = ?,position = ?, uTele = ?,uAddress = ?, sex = ?,nativePlace = ?,email = ? where uId = ?";
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, p.getuName());
            pst.setString(2, p.getPosition());
            pst.setString(3, p.getuTele());
            pst.setString(4, p.getuAddress());
            pst.setString(5, p.getSex());
            pst.setString(6, p.getNativePlace());
            pst.setString(7, p.getEmail());
            pst.setInt(8, p.getuId());
            result = pst.executeUpdate();
            while(result > 0){
                return result;
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
        
    }

    @Override
    public int deleteUser(int uId) {
        String sql="delete from user where uId=?";
       Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
         int result=0;    
         
          String sql1 = "select uId from supplier where uId="+uId;
        try {
            con=DBConnection.getConnection();
            pst=con.prepareStatement(sql1);
            rs=pst.executeQuery();
            if(!rs.next()){
                        try {
            con=DBConnection.getConnection();
            pst=con.prepareStatement(sql);
            pst.setInt(1, uId);
            result=pst.executeUpdate();
            while(result>0){
                return result;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            }else{
                return 998;//不可删除原因：该员工还存在负责的供应商
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         
         
         
         
         
         
         
         
         
         
         
         

        return 0;
    }
     public boolean IsIDExist(int uid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from user where uId = ? ";

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, uid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
}
