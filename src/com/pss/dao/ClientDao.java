/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.dao;

import com.pss.po.Client;
import java.util.List;

/**
 *
 * @author zz
 */
public interface ClientDao {
    public List<Client> QueryClient(String value) ;
        public int AddClient(Client p) ;
        public int DeleteClient(String cName) ;
        public int UpdateClient(Client p) ;
        public boolean IsExist(String cname) ;
}
