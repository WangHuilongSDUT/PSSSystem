/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.ScriptStyle;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author wangh
 */
public class ExportExcel {
    //打印商品销售信息
    public static void printSale(List<String[]> plist,File file){
       //1 ============设定表列名
        String bId = "采购单号";
        String pName = "商品名";
        String bCount = "采购数量";
        String bPrice="采购价格";
        String supplier="供应商";
        String bTime="采购时间";
        try {
                //2==============创建excel文件并设置数据显示格式
            WritableWorkbook book = Workbook.createWorkbook(file); //创建特殊类型的变量使之与Excel表格对应以便于操作
            WritableSheet sheet1 = book.createSheet("第一页", 0); //在表格中创建第一页，参数指明页的名称和索引，索引从0开始
            sheet1.setColumnView(0, 20); //设置某一列的宽度
            sheet1.setRowView(0, 400); //设置某一行的高度
            //设置第一行第二列的高度和宽度
            sheet1.setColumnView(1, 20);
            //sheet1.setRowView(1, 500);
            //设置第一行第三列的高度和宽度
            sheet1.setColumnView(2, 20);
            //sheet1.setRowView(2, 500);
            sheet1.setColumnView(3, 20);
            sheet1.setColumnView(4, 20);
            sheet1.setColumnView(5, 20);
            sheet1.setColumnView(6, 20);
            //WritableSheet sheet2 = book.createSheet("第二页", 1); //创建第二页
           //创建字体，7个参数分别是字体名称，字号，是否粗体，是否斜体，下划线，颜色，上下标
            WritableFont font = new WritableFont(WritableFont.TIMES, 13, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.DARK_RED, ScriptStyle.NORMAL_SCRIPT); 
            WritableFont font1 = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK, ScriptStyle.NORMAL_SCRIPT);
            
            
            WritableCellFormat format = new WritableCellFormat(font); //将字体放入单元格式中

            WritableCellFormat format1 = new WritableCellFormat(font1);
           
            format1.setAlignment(Alignment.CENTRE); //对齐方式的设定

            format.setAlignment(Alignment.CENTRE); //对齐方式的设定
            //3 ============设置第一行为列名,并添加列名
            Label labelBId= new Label(0, 0, bId, format); //写入字符串，确定位置（列，行）、内容和格式
            Label labelPName = new Label(1, 0,pName, format);
            Label labelBCount= new Label(2, 0, bCount, format);
            Label labelBPrice = new Label(3, 0, bPrice, format);
            Label labelSupplier= new Label(4, 0, supplier, format);
            Label labelBTime= new Label(5, 0, bTime, format);
            //添加列名
            sheet1.addCell(labelBId); //sheet对象添加文本的数据类型为Label
            sheet1.addCell(labelPName);
            sheet1.addCell(labelBCount);
            sheet1.addCell(labelBPrice);
            sheet1.addCell(labelSupplier);
            sheet1.addCell(labelBTime);
            //4 =====================取出List集合中的的内容，放到Excel中
            int row = plist.size();//获取集合的长度作为表格的行数
            for (int i = 0; i < row; i++) {
                //获取每一行数据，从第一行开始，第0行是标题
                Label pname1 = new Label(0, i+1, plist.get(i)[0], format1);
                Label l1 = new Label(1, i+1, plist.get(i)[1], format1);
                Label l2 = new Label(2, i+1, plist.get(i)[2], format1);
                Label l3 = new Label(3, i+1, plist.get(i)[3], format1);
                Label l4 = new Label(4, i+1, plist.get(i)[4], format1);
                Label l5 = new Label(5, i+1, plist.get(i)[5], format1);
                //添加每一行内容
                sheet1.addCell(pname1);
                sheet1.addCell(l1);
                sheet1.addCell(l2);
                sheet1.addCell(l3);
                sheet1.addCell(l4);
                sheet1.addCell(l5);
            }
            //5 ===================保存数据，存盘
            book.write();//存盘
            book.close();
        } catch (WriteException ex) {
          ex.printStackTrace();

        } catch (IOException ex) {
           ex.printStackTrace();
        }
    
    } public static void printSale1(List<String[]> plist,File file){
       //1 ============设定表列名
        String bId = "销售单号";
        String pName = "商品名";
        String bCount = "销售数量";
        String bPrice="销售价格";
        String supplier="顾客";
        String bTime="销售时间";
        try {
                //2==============创建excel文件并设置数据显示格式
            WritableWorkbook book = Workbook.createWorkbook(file); //创建特殊类型的变量使之与Excel表格对应以便于操作
            WritableSheet sheet1 = book.createSheet("第一页", 0); //在表格中创建第一页，参数指明页的名称和索引，索引从0开始
            sheet1.setColumnView(0, 20); //设置某一列的宽度
            sheet1.setRowView(0, 400); //设置某一行的高度
            //设置第一行第二列的高度和宽度
            sheet1.setColumnView(1, 20);
            //sheet1.setRowView(1, 500);
            //设置第一行第三列的高度和宽度
            sheet1.setColumnView(2, 20);
            //sheet1.setRowView(2, 500);
            sheet1.setColumnView(3, 20);
            sheet1.setColumnView(4, 20);
            sheet1.setColumnView(5, 20);
            sheet1.setColumnView(6, 20);
            //WritableSheet sheet2 = book.createSheet("第二页", 1); //创建第二页
           //创建字体，7个参数分别是字体名称，字号，是否粗体，是否斜体，下划线，颜色，上下标
            WritableFont font = new WritableFont(WritableFont.TIMES, 13, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.DARK_RED, ScriptStyle.NORMAL_SCRIPT); 
            WritableFont font1 = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK, ScriptStyle.NORMAL_SCRIPT);
            
            
            WritableCellFormat format = new WritableCellFormat(font); //将字体放入单元格式中

            WritableCellFormat format1 = new WritableCellFormat(font1);
           
            format1.setAlignment(Alignment.CENTRE); //对齐方式的设定

            format.setAlignment(Alignment.CENTRE); //对齐方式的设定
            //3 ============设置第一行为列名,并添加列名
            Label labelBId= new Label(0, 0, bId, format); //写入字符串，确定位置（列，行）、内容和格式
            Label labelPName = new Label(1, 0,pName, format);
            Label labelBCount= new Label(2, 0, bCount, format);
            Label labelBPrice = new Label(3, 0, bPrice, format);
            Label labelSupplier= new Label(4, 0, supplier, format);
            Label labelBTime= new Label(5, 0, bTime, format);
            //添加列名
            sheet1.addCell(labelBId); //sheet对象添加文本的数据类型为Label
            sheet1.addCell(labelPName);
            sheet1.addCell(labelBCount);
            sheet1.addCell(labelBPrice);
            sheet1.addCell(labelSupplier);
            sheet1.addCell(labelBTime);
            //4 =====================取出List集合中的的内容，放到Excel中
            int row = plist.size();//获取集合的长度作为表格的行数
            for (int i = 0; i < row; i++) {
                //获取每一行数据，从第一行开始，第0行是标题
                Label pname1 = new Label(0, i+1, plist.get(i)[0], format1);
                Label l1 = new Label(1, i+1, plist.get(i)[1], format1);
                Label l2 = new Label(2, i+1, plist.get(i)[2], format1);
                Label l3 = new Label(3, i+1, plist.get(i)[3], format1);
                Label l4 = new Label(4, i+1, plist.get(i)[4], format1);
                Label l5 = new Label(5, i+1, plist.get(i)[5], format1);
                //添加每一行内容
                sheet1.addCell(pname1);
                sheet1.addCell(l1);
                sheet1.addCell(l2);
                sheet1.addCell(l3);
                sheet1.addCell(l4);
                sheet1.addCell(l5);
            }
            //5 ===================保存数据，存盘
            book.write();//存盘
            book.close();
        } catch (WriteException ex) {
          ex.printStackTrace();

        } catch (IOException ex) {
           ex.printStackTrace();
        }
    
    }
}
