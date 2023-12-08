
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import DTO.*;
import BUS.*;
/**
 *
 * @author ADMIN
 */
public class GUIOrder extends javax.swing.JPanel {
    static int manv = 0;
    private int SL =0, i = 0;
    public double totalPrice = 0; 
    BUSMenu menu = new BUSMenu();
    BUSSanPham sanpham = new BUSSanPham();
    BUSPhanLoai phanloai = new BUSPhanLoai();
    private ArrayList<DTOSanPham> listsp = sanpham.getlistorder();
    private ArrayList<DTOPhanLoai> listpl = phanloai.getlist();
    private ArrayList<DTOSanPham> spOrderList = new ArrayList<>();
    public GUIOrder(int mnv) throws SQLException, ClassNotFoundException, ParseException{
        initComponents();
        init();
        reset();
        manv = mnv;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblIconTimKiem = new javax.swing.JLabel();
        cbbTimKiem = new javax.swing.JComboBox<>();
        lblIconGioHang = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        txtTotalPrice = new javax.swing.JTextField();

        setBackground(new java.awt.Color(218, 212, 181));
        setPreferredSize(new java.awt.Dimension(880, 650));

        jPanel2.setBackground(new java.awt.Color(255, 187, 92));

        cbbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTimKiemActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(161, 204, 209));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SOURCE/Icon/reset.png"))); // NOI18N
        jButton8.setToolTipText("");
        jButton8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(lblIconTimKiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblIconGioHang)
                .addGap(73, 73, 73))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIconGioHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbTimKiem)
                    .addComponent(lblIconTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel3.setBackground(new java.awt.Color(218, 212, 181));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 2));
        jPanel3.setPreferredSize(new java.awt.Dimension(630, 1500));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 20));
        jScrollPane1.setViewportView(jPanel3);

        jPanel1.setBackground(new java.awt.Color(250, 234, 177));
        jPanel1.setPreferredSize(new java.awt.Dimension(230, 590));

        jLabel37.setBackground(new java.awt.Color(149, 35, 35));
        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Giỏ hàng");
        jLabel37.setOpaque(true);

        jScrollPane2.setBackground(new java.awt.Color(250, 234, 177));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTable1.setBackground(new java.awt.Color(250, 234, 177));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Qty", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(226, 88, 34));
        jButton1.setText("Xóa tất cả");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(175, 169, 57));
        jButton2.setText("Thanh toán");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel41.setText("Đơn giá :");

        txtTotalPrice.setEditable(false);
        txtTotalPrice.setBackground(new java.awt.Color(250, 234, 177));
        txtTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTotalPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalPrice.setText("0.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(30, 30, 30))
                    .addComponent(txtTotalPrice)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void reset() {
        try {
            sanpham.cbplimport(cbbTimKiem, phanloai.getlist());
        } catch (SQLException ex) {
            Logger.getLogger(GUIOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        spOrderList.clear();
        totalPrice = 0;
        txtTotalPrice.setText(totalPrice + "");
        menu.arr_jt(jTable1, spOrderList);
    }
    public boolean SLIsZero(int SL) {
        if(SL == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn số lượng!");
            return false;
        }
        return true;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(spOrderList.isEmpty()){
            JOptionPane.showMessageDialog(this, "Bạn chưa thêm sản phẩm vào giỏ hàng");
        } else reset();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        try {
            sanpham.cbplimport(cbbTimKiem, phanloai.getlist());
            loadData(listsp);
        } catch (SQLException ex) {
            Logger.getLogger(GUIOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(spOrderList.isEmpty()){
            JOptionPane.showMessageDialog(this, "Bạn chưa thêm sản phẩm vào giỏ hàng");
        } else new Quest(spOrderList,manv).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbbTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTimKiemActionPerformed
        // TODO add your handling code here:
        if(cbbTimKiem.getSelectedItem()!=null ){
            if(!cbbTimKiem.getSelectedItem().equals("Phân loại")){
                String item = cbbTimKiem.getSelectedItem().toString();
                DTOPhanLoai pl = new DTOPhanLoai();
                pl.setTenPhanLoai(item);
                try {
                    pl = phanloai.getplbyname(pl);
                    loadData(menu.getlistpl(pl.getMaPhanLoai()));
                } catch (SQLException ex) {
                    Logger.getLogger(GUIOrder.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(GUIOrder.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_cbbTimKiemActionPerformed
   
    
//    private JSpinner spnSL;
//    private JCheckBox chbox;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbTimKiem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblIconGioHang;
    private javax.swing.JLabel lblIconTimKiem;
    private javax.swing.JTextField txtTotalPrice;
    // End of variables declaration//GEN-END:variables

    private void init() throws SQLException, ClassNotFoundException {
        setUp();
    }

    private void setUp() {
        
        loadData(listsp);

        //Set up ComboBox tim kiem

        menu.cbplimport(cbbTimKiem, listpl);
        
    }  
    
    private void loadData(ArrayList<DTOSanPham> spList) {
        jPanel3.removeAll();
        for (DTOSanPham sp : spList) {
            
            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(200,240));
            panel.setBackground(new Color(223,168,120));
            
            JLabel lblImgItem = new JLabel();
            lblImgItem.setPreferredSize(new Dimension(190,140));
            lblImgItem.setBackground(Color.blue);
            ImageIcon icon1 = new ImageIcon(sp.getImg());
            Image img1 = icon1.getImage().getScaledInstance(190, 140, Image.SCALE_SMOOTH);
            lblImgItem.setIcon(new ImageIcon(img1));
            
            
            JLabel lblNameItem = new JLabel(sp.getTenSanPham());
            lblNameItem.setBackground(new Color(223,168,120));
            lblNameItem.setFont(new Font("Times New Roman", Font.BOLD, 14));
            lblNameItem.setPreferredSize(new Dimension(160,20));
            lblNameItem.setHorizontalAlignment(SwingConstants.CENTER);
            
            JLabel lblPriceItem = new JLabel(sp.getGiaBan()+"");
            lblPriceItem.setBackground(new Color(223,168,120));
            lblPriceItem.setFont(new Font("Times New Roman", Font.BOLD, 14));
            lblPriceItem.setPreferredSize(new Dimension(160,20));
            lblPriceItem.setHorizontalAlignment(SwingConstants.CENTER);
            
            JSpinner spnSL = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
            spnSL.setPreferredSize(new Dimension(40,20));
            
            JCheckBox chbox = new JCheckBox();
            chbox.setPreferredSize(new Dimension(20,20));
            chbox.setBackground(new Color(223,168,120));
            chbox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int SL = Integer.parseInt(spnSL.getValue().toString());
                    double price = SL * Double.parseDouble(lblPriceItem.getText());
                    if(!SLIsZero(SL)){
                        chbox.setSelected(false);
                    } else if(chbox.isSelected()) {
                        
                        totalPrice += price;
                        txtTotalPrice.setText(totalPrice+"");
                        sp.setGiaBan((int) price);
                        sp.setSoLuong(SL);
                        spOrderList.add(sp);
                        menu.arr_jt(jTable1, spOrderList);
                           
                        } else {
                            if(totalPrice!=0)
                            totalPrice -= price;
                            txtTotalPrice.setText(totalPrice + "");
                            spOrderList.remove(sp);
                            menu.arr_jt(jTable1, spOrderList);
                        
                    }
                }
            });
            
            panel.add(lblImgItem);
            panel.add(lblNameItem);
            panel.add(lblPriceItem);
            panel.add(spnSL);
            panel.add(chbox);

            
            jPanel3.add(panel);
            

        }
    }
    
}
