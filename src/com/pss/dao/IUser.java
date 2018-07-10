/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.dao;

import com.pss.po.User;
import java.util.List;

/**
 *
 * @author 161029
 */
public interface IUser {
    
     public List<User> getUser(String str);
     
     public int addUser(User p);
     
     public boolean isExit(String uTele,String email);
     
     public int UpdateUser(User p) ;
     
     public int deleteUser(int uId);
     
      public boolean IsIDExist(int sid);
    
}
