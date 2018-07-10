/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 161029
 */
public class DBConnection {
    
    private static String url="jdbc:mysql://211.159.177.203:3306/pss?useUnicode=true&autoReconnect=true&characterEncoding=UTF-8&useSSL=false";
    private static String username="root";
    private static String password="zhangdi0";

    private static Connection con;
    
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");//获取数据库的驱动
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public static Connection getConnection(){
        
        try {
            con = DriverManager.getConnection(url,username,password);
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        return con;
    }
    
    public static void close(Connection con,Statement st, ResultSet rs){
        /*if(con != null || st != null || rs != null){
            try {
                con.close();
                st.close();
                rs.close();
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }  */  
    }    
}
