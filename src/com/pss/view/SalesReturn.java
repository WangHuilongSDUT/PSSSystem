/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.view;

import com.pss.dao.ClientDao;
import com.pss.dao.ClientImpl;
import com.pss.dao.ProductDao;
import com.pss.dao.ProductImpl;
import com.pss.util.LocationUtil;
import com.pss.dao.SaleDao;
import com.pss.dao.SaleImpl;
import com.pss.po.Product;
import com.pss.po.Sale;
import com.pss.util.StringUtile;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Administrator
 */
public class SalesReturn extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewJInternalFrame9
     */
    public SalesReturn() {
        initComponents();
        LocationUtil.setFullScreen(this);  //设置全屏显示
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipRefund = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        tipBNo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        textBNo = new javax.swing.JTextField();
        tipPNo = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        textPNo = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        tipBCount = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textFound = new javax.swing.JTextPane();
        textBCount = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("销售退货");

        tipRefund.setText("退货数量：");

        jButton2.setText("销售退货");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tipBNo.setText("销售编号：");

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "销售编号", "商品编号", "商品名", "销售数量", "销售价格", "顾客编号"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduct);

        textBNo.setEditable(false);

        tipPNo.setText("销售编号：");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        textPNo.setEditable(false);

        btnSearch.setText("查询");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tipBCount.setText("销售数量：");

        jScrollPane2.setViewportView(textFound);

        textBCount.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tipBCount)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textBCount, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tipBNo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textBNo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(73, 73, 73)
                                    .addComponent(tipPNo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textPNo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tipRefund)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(42, 42, 42)
                                    .addComponent(jButton2))))
                        .addGap(0, 360, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipBNo)
                    .addComponent(textBNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipPNo)
                    .addComponent(textPNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipBCount)
                    .addComponent(textBCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2)
                        .addComponent(tipRefund, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2))
                .addGap(231, 231, 231))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (!StringUtile.validateNull(textFound.getText())) {
            JOptionPane.showMessageDialog(this, "退货数量不允许为空！");
            return;
        }
        if (!StringUtile.validateDigit(textFound.getText())) {
            JOptionPane.showMessageDialog(this, "退货数量必须为数字！");
            return;
        }
        int foundCount=Integer.parseInt(textFound.getText());
        DefaultTableModel tm = (DefaultTableModel) tblProduct.getModel();
        //获取当前行
        int row = this.tblProduct.getSelectedRow();
        int buyCount=Integer.parseInt(tm.getValueAt(row, 3).toString().trim());
        if(foundCount>buyCount)
        {
            JOptionPane.showMessageDialog(this, "退货数量多余购置数量！");
            return ;
        }
        ProductDao pd=new ProductImpl();
        Product p=pd.QueryProductByPNo(textPNo.getText()).get(0);
        int stock=p.getSafeStock();
        p.setSafeStock(stock+foundCount);                                       //这里并没有入库
        pd.UpdateProductStock(p.getpNo(),foundCount);                           //在这里已经入库
        JOptionPane.showMessageDialog(this, "退货成功！");
        
        //这里差一个数据库操作 因为没有写底层操作(退货记录
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMouseClicked
        //商品表
        DefaultTableModel tm = (DefaultTableModel) tblProduct.getModel();
        //获取当前行
        int row = this.tblProduct.getSelectedRow();
        textBNo.setText(tm.getValueAt(row, 0).toString().trim());
        textPNo.setText(tm.getValueAt(row, 1).toString().trim());
        textBCount.setText(tm.getValueAt(row, 3).toString().trim());
    }//GEN-LAST:event_tblProductMouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // 搜索
        SaleDao sale=new SaleImpl();
        List<Sale> sList=sale.QuerySale();
        DefaultTableModel tm = (DefaultTableModel) tblProduct.getModel();
        while (tm.getRowCount() > 0) {
            tm.removeRow(tm.getRowCount() - 1);//逐行清除表中内容
        }

        for(Sale b:sList)
        {
            ProductDao pd=new ProductImpl();
            for(Product p:pd.QueryProductByPNo(b.getpNo()))
            {
                String []str={
                    b.getSaleNo(),
                    b.getpNo(),
                    p.getpName(),
                    String.format("%d",b.getSaleCount()),
                    String.format("%f",b.getSalePrice()),
                    b.getcId()};
                tm.addRow(str);
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTextField textBCount;
    private javax.swing.JTextField textBNo;
    private javax.swing.JTextPane textFound;
    private javax.swing.JTextField textPNo;
    private javax.swing.JLabel tipBCount;
    private javax.swing.JLabel tipBNo;
    private javax.swing.JLabel tipPNo;
    private javax.swing.JLabel tipRefund;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
