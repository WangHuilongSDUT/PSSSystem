/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wangh
 */
public class Tools {
    public static String DateFormatToSQL(Date d)
    {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");  
        return ft.format(d);
    }
    public static Date SQLStringToDate(String s)
    {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd"); 
        try {
            return ft.parse(s);
        } catch (ParseException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
