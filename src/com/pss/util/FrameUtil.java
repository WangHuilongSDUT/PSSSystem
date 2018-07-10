/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.util;

import com.pss.view.StaffManagement;
import com.pss.view.CommodityInformationManagement;
import java.util.HashMap;
import javax.swing.JInternalFrame;

/**
 * 工厂模式，生成内部窗体
 * @author yhy
 */
public class FrameUtil {
    //存放已生成的内部窗体
    public static HashMap<String,JInternalFrame> framemap = 
                    new HashMap<String,JInternalFrame>();
    /**
     * 根据指定的键值生成对应的内部窗体对象
     * @param framekey  窗体的键值
     * @return   内部窗体对象
     * 
     */
    public static JInternalFrame buildFrame(String framekey){
        JInternalFrame  inFrame = null;//初始化内部窗体
        if(framemap.containsKey(framekey)==true){
             //已经存
            inFrame = framemap.get(framekey);
        }else{
           //集合中没有
            if(framekey.equals("product")){
                inFrame = new CommodityInformationManagement();
                //添加到集合
                framemap.put("product", inFrame);
            }
            if(framekey.equals("customer")){
                inFrame = new StaffManagement();
                framemap.put("customer", inFrame);
            }
            //其他窗体（略）
            
            
        }
        return inFrame;
    }
}