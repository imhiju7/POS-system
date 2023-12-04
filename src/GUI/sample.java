/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.*;
import DTO.*;
import GUI.comp.TableGradientCell;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Hieu PC
 */
public class sample extends javax.swing.JFrame {

    /**
     * Creates new form frm_ctnhapkho
     */
    // ma san pham combobox
    
    // export function
    
    // id no edit
    
    // get sp name
    
    static int maPhieuNhap = 0;
    static int maNhanVien = 0;
    public sample(int mapn,int manv) throws SQLException, ParseException {
        initComponents();
        maPhieuNhap = mapn;
        maNhanVien = manv;
        // Lấy kích thước màn hình
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Lấy kích thước của form
        Dimension frameSize = this.getSize();
        // Tính toán vị trí trung tâm
        int x = (screenSize.width - frameSize.width) / 2;
        int y = (screenSize.height - frameSize.height) / 2;

        // Đặt vị trí của form
        this.setLocation(x, y);

        this.setVisible(true);
        jLabel1.setText("Nhập kho "+mapn);
        jTable1.setDefaultRenderer(Object.class, new TableGradientCell());
        jPanel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        jTable1.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background");
        jScrollPane1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:3,0,3,0,$Table.background,10,10");
        jScrollPane1.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverTrackColor:null");
        arr_jt(jTable1,ctpnBUS.getlist(mapn));
        cb(jComboBox1);
        
        DTOPhieuNhap pn = ctpnBUS.getpn(mapn);
        pn.setTongTien(ctpnBUS.getmoney(maPhieuNhap));
        ctpnBUS.updatephieunhap(pn);
    }
    BUSCTPhieuNhap ctpnBUS = new BUSCTPhieuNhap();
    public static void arr_jt(JTable jt,ArrayList<DTOCTPhieuNhap> ctpn){
         DefaultTableModel model = new DefaultTableModel();
         model.addColumn("Mã CT phiếu nhập");
         model.addColumn("Mã sản phẩm");
         model.addColumn("Tên sản phẩm");
         model.addColumn("Đơn giá");
         model.addColumn("Số lượng");
         for(DTOCTPhieuNhap i: ctpn){
             model.addRow(new Object[]{i.getMaCTPhieuNhap(),i.getMaSanPham(),i.getTenSanPham(),i.getDonGia(),i.getSoLuong()});
         }
         jt.setModel(model);
         JTableHeader hd = jt.getTableHeader();
         hd.setPreferredSize(new Dimension(hd.getWidth(),30));
         hd.setFont(new Font("Arial", Font.BOLD,18));
    }
    public static void cb(JComboBox<String> cb){
        ArrayList<String> list = new ArrayList<>();
        list.add("Mã CT phiếu nhập");
        list.add("Mã sản phẩm");
        Vector<String> dataVec = new Vector<>(list);
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(dataVec);
        cb.setModel(model);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(149, 35, 35));
        jPanel1.setForeground(new java.awt.Color(60, 63, 65));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 60));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chi tiết nhập kho + Mã NK");
        jLabel1.setToolTipText("");
        jLabel1.setPreferredSize(new java.awt.Dimension(166, 60));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(600, 480));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 200));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setRowHeight(30);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Mã sản phẩm");

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tên sản phẩm");

        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(255, 255, 255));
        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Mã chi tiết nhập kho");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Đơn giá");

        jTextField5.setBackground(new java.awt.Color(255, 255, 255));
        jTextField5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Số lượng");

        jTextField6.setBackground(new java.awt.Color(255, 255, 255));
        jTextField6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(0, 0, 0));
        jTextField6.setPreferredSize(new java.awt.Dimension(80, 26));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(149, 149, 149))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBackground(new java.awt.Color(255, 187, 92));
        jPanel3.setForeground(new java.awt.Color(60, 63, 65));
        jPanel3.setPreferredSize(new java.awt.Dimension(600, 60));

        jButton1.setBackground(new java.awt.Color(255, 187, 92));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SOURCE/Icon/search.png"))); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(40, 40));

        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton3.setBackground(new java.awt.Color(255, 187, 92));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SOURCE/Icon/edit.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 187, 92));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SOURCE/Icon/add.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 187, 92));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SOURCE/Icon/delete.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 187, 92));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SOURCE/Icon/reset.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 187, 92));
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Export");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(jTextField3.getText().isEmpty() || jTextField4.getText().isEmpty() || jTextField1.getText().isEmpty() || jTextField5.getText().isEmpty() || jTextField6.getText().isEmpty()){
            // thieu thong tin
            JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin cần chỉnh sửa!");
        }
        else{
            try {
                if( ctpnBUS.checksp(maPhieuNhap, Integer.parseInt(jTextField1.getText().toString())) && !ctpnBUS.check2sp(maPhieuNhap, Integer.parseInt(jTextField4.getText().toString()), Integer.parseInt(jTextField1.getText().toString()))){
                    // sp trung
                    JOptionPane.showMessageDialog(null, "Sản phẩm hiện đã có trong phiếu nhập!");
                }
                else{
                    DTOCTPhieuNhap ctpn = new DTOCTPhieuNhap();
                    ctpn.setDonGia(Float.parseFloat(jTextField5.getText()));
                    ctpn.setMaCTPhieuNhap(Integer.parseInt(jTextField4.getText()));
                    ctpn.setMaPhieuNhap(maPhieuNhap);
                    ctpn.setMaSanPham(Integer.parseInt(jTextField1.getText()));
                    ctpn.setTenSanPham(jTextField3.getText());
                    ctpn.setSoLuong(Integer.parseInt(jTextField6.getText()));
        
                    try {
                        ctpnBUS.updatectphieunhap(ctpn);
                    } catch (SQLException ex) {
                        Logger.getLogger(sample.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        arr_jt(jTable1,ctpnBUS.getlist(maPhieuNhap));
                    } catch (SQLException ex) {
                        Logger.getLogger(sample.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(sample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(jTextField3.getText().isEmpty() || jTextField1.getText().isEmpty() || jTextField5.getText().isEmpty() || jTextField6.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin sản phẩm trước khi thêm sản phẩm");
        }
        else{
            try {
                if(ctpnBUS.checksp(maPhieuNhap, Integer.parseInt(jTextField1.getText().toString()))){
                    JOptionPane.showMessageDialog(null, "Sản phẩm hiện đã có trong phiếu nhập này!");
                }
                else{
                    DTOCTPhieuNhap ctpn = new DTOCTPhieuNhap();
                    ctpn.setDonGia(Float.parseFloat(jTextField5.getText()));
                    try {
                        ctpn.setMaCTPhieuNhap(ctpnBUS.getlistcount()+1);
                    } catch (SQLException ex) {
                        Logger.getLogger(sample.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ctpn.setMaPhieuNhap(maPhieuNhap);
                    ctpn.setMaSanPham(Integer.parseInt(jTextField1.getText()));
                    ctpn.setTenSanPham(jTextField3.getText());
                    ctpn.setSoLuong(Integer.parseInt(jTextField6.getText()));
        
                    try {
                        ctpnBUS.addctphieunhap(ctpn);
                        DTOPhieuNhap pn = ctpnBUS.getpn(maPhieuNhap);
                        pn.setTongTien(ctpnBUS.getmoney(maPhieuNhap));
                        ctpnBUS.updatephieunhap(pn);
            
                    } catch (SQLException ex) {
                        Logger.getLogger(sample.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(sample.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        arr_jt(jTable1,ctpnBUS.getlist(maPhieuNhap));
                    } catch (SQLException ex) {
                        Logger.getLogger(sample.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(sample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        // delete
        if(jTextField4.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn chi tiết phiếu nhập để xóa!");
        }
        else{
            DTOCTPhieuNhap ctpn = new DTOCTPhieuNhap();
            ctpn.setMaCTPhieuNhap(Integer.parseInt(jTextField4.getText().toString()));
            try {
                ctpnBUS.deletephieunhap(ctpn);
                DTOPhieuNhap pn = ctpnBUS.getpn(maPhieuNhap);
                pn.setTongTien(ctpnBUS.getmoney(maPhieuNhap));
                ctpnBUS.updatephieunhap(pn);
            } catch (SQLException ex) {
                Logger.getLogger(sample.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(sample.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                arr_jt(jTable1,ctpnBUS.getlist(maPhieuNhap));
            } catch (SQLException ex) {
                Logger.getLogger(sample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        jTextField2.setText("");
        jTextField4.setText("");
        jTextField3.setText("");
        jTextField1.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        try {
            arr_jt(jTable1,ctpnBUS.getlist(maPhieuNhap));
        } catch (SQLException ex) {
            Logger.getLogger(sample.class.getName()).log(Level.SEVERE, null, ex);
        }
        jComboBox1.setSelectedItem("Mã CT phiếu nhập");
        DTOPhieuNhap pn = new DTOPhieuNhap();
        try {
            pn = ctpnBUS.getpn(maPhieuNhap);
        } catch (SQLException ex) {
            Logger.getLogger(sample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(sample.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pn.setTongTien(ctpnBUS.getmoney(maPhieuNhap));
        } catch (SQLException ex) {
            Logger.getLogger(sample.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ctpnBUS.updatephieunhap(pn);
        } catch (SQLException ex) {
            Logger.getLogger(sample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        jTextField4.setText(jTable1.getValueAt(row, 0).toString());
        jTextField3.setText(jTable1.getValueAt(row, 2).toString());
        jTextField1.setText(jTable1.getValueAt(row, 1).toString());
        jTextField5.setText(jTable1.getValueAt(row, 3).toString());
        jTextField6.setText(jTable1.getValueAt(row, 4).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // export file xls
        DTOPhieuNhap pn = new DTOPhieuNhap();
        try {
            pn = ctpnBUS.getpn(maPhieuNhap);
        } catch (SQLException ex) {
            Logger.getLogger(sample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(sample.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<DTOCTPhieuNhap> listctpn = new ArrayList<DTOCTPhieuNhap>();
        try {
            listctpn = ctpnBUS.getlist(maPhieuNhap);
        } catch (SQLException ex) {
            Logger.getLogger(sample.class.getName()).log(Level.SEVERE, null, ex);
        }
        String exp  = ctpnBUS.exportxls(pn, listctpn, maNhanVien);
        if(exp==null){
            
        }
        else{
            // file đã được tạo ra ở ...
            JOptionPane.showMessageDialog(null, "File: "+exp);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(sample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new sample(maPhieuNhap,maNhanVien).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(sample.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(sample.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}