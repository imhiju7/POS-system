/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.util.ArrayList;
import DTO.*;
import BUS.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Hieu PC
 */
public class GUIThanhToan extends javax.swing.JFrame {

    /**
     * Creates new form GUIThanhToan
     */
    static ArrayList<DTOSanPham> list = new ArrayList<>();
    static int manv =0;
    int mnv;
    BUSMenu menu = new BUSMenu();
    BUSKhuyenMai khuyenmai = new BUSKhuyenMai();
    BUSHoaDon hoadon = new BUSHoaDon();
    BUSSanPham sanpham = new BUSSanPham();
    BUSUuDai uudai = new BUSUuDai();
    BUSTichDiem tichdiem = new BUSTichDiem();
    BUSKhachHang khachhang = new BUSKhachHang();
    BUSNhanVien nhanvien = new BUSNhanVien();
    BUSCTHoaDon cthoadon = new BUSCTHoaDon();
    BUSCTPhieuNhap ctphieunhap = new BUSCTPhieuNhap();
    ArrayList<DTOSanPham> lia;
    
    DTOKhachHang kh = new DTOKhachHang();
    DTOUuDai ud = new DTOUuDai();
    DTOKhuyenMai km = new DTOKhuyenMai();
    DTOTichDiem td = new DTOTichDiem();
    DTONhanVien nv = new DTONhanVien();
    DTOHoaDon hd = new DTOHoaDon();
    
    double tongtien;
    double tongtienkm;
    double tongtienud;
    double tongtienfi;
    int diem;
    public GUIThanhToan(ArrayList<DTOSanPham> li,int ma) {
        initComponents();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Lấy kích thước của form
        Dimension frameSize = this.getSize();
        // Tính toán vị trí trung tâm
        int x = (screenSize.width - frameSize.width) / 2;
        int y = (screenSize.height - frameSize.height) / 2;

        // Đặt vị trí của form
        this.setResizable(false);
        this.setLocation(x, y);
        mnv = ma;
            nv.setMaNhanVien(ma);
            try {
                nv = nhanvien.getnv(nv);
            } catch (SQLException ex) {
                Logger.getLogger(GUIThanhToan.class.getName()).log(Level.SEVERE, null, ex);
            }
        menu.arr_jt(jTable1, li);
        jTextField2.setText(Double.toString(menu.gettongtien(li)));
        try {
            menu.cbnccimport(jComboBox1,khuyenmai.getkhuyenmaitoday());
        } catch (SQLException ex) {
            Logger.getLogger(GUIThanhToan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(GUIThanhToan.class.getName()).log(Level.SEVERE, null, ex);
        }
        tongtien = menu.gettongtien(li);
        tongtienfi = tongtien;
        jTextField3.setText(Double.toString(tongtienfi));
        hd.setMaNhanVien(ma);
        lia = li;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jButton1.setText("Check");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);

        jLabel3.setText("Tổng");

        jTextField3.setEditable(false);

        jButton2.setText("Thanh toán");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("0");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("0");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("0");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Tích lũy");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Khuyến mãi");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Ưu đãi");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Ghi chú");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(jTextField2))))
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(161, 204, 209));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thanh toán");
        jLabel1.setPreferredSize(new java.awt.Dimension(500, 100));
        jPanel2.add(jLabel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        hd.setGhiChu(jTextField4.getText().toString());
        hd.setNgayMua(new Date());
        hd.setTongTien(tongtienfi);
        hd.setIsHidden(0);
        if(hd.getMaKhachHang() == 0 && hd.getMaKhuyenMai() ==0){
            try {
                hoadon.addhdnokmkh(hd);
            } catch (SQLException ex) {
                Logger.getLogger(GUIThanhToan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(hd.getMaKhachHang() ==0 ){
            try {
                hoadon.addhdnokh(hd);
                km.setSoLuongDaDung(km.getSoLuongDaDung()+1);
                khuyenmai.updatekhuyenmai(km);
                hd = hoadon.gethdgannhat();
            } catch (SQLException ex) {
                Logger.getLogger(GUIThanhToan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(GUIThanhToan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(hd.getMaKhuyenMai() ==0 ){
            try {
                hoadon.addhdnokm(hd);
                kh.setDiemTichLuy(kh.getDiemTichLuy()+diem);
                kh.setMaUuDai(uudai.setudbydiem(kh.getDiemTichLuy()).getMaUuDai());
                khachhang.updatediemtichluy(kh);
            } catch (SQLException ex) {
                Logger.getLogger(GUIThanhToan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(GUIThanhToan.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else{
            try {
                hoadon.addhoadon(hd);
                kh.setDiemTichLuy(kh.getDiemTichLuy()+diem);
                kh.setMaUuDai(uudai.setudbydiem(kh.getDiemTichLuy()).getMaUuDai());
                khachhang.updatediemtichluy(kh);
                km.setSoLuongDaDung(km.getSoLuongDaDung()+1);
                khuyenmai.updatekhuyenmai(km);
            } catch (SQLException ex) {
                Logger.getLogger(GUIThanhToan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(GUIThanhToan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try{
            hd = hoadon.gethdgannhat();
            int a = hd.getMaHoaDon();
            DTOCTHoaDon cthd = new DTOCTHoaDon();
            for(DTOSanPham i: lia){
                cthd.setMaHoaDon(a);
                cthd.setMaSanPham(i.getMaSanPham());
                cthd.setSoLuong(i.getSoLuong());
                cthd.setDonGia(i.getGiaBan());
                cthoadon.addcthoadon(cthd);
                DTOCTPhieuNhap pn = ctphieunhap.getspganhh(cthd.getMaSanPham());
                pn.setSoluongtonkho(pn.getSoluongtonkho() - cthd.getSoLuong());
                ctphieunhap.updatectphieunhap(pn);
                DTOSanPham sp = new DTOSanPham();
                sp.setMaSanPham(pn.getMaSanPham());
                sp = sanpham.getsp(i);
                sp.setSoLuong(ctphieunhap.gettongsl(pn.getMaSanPham()));
                sanpham.updateslsanpham(sp);
            }
            JOptionPane.showMessageDialog(this, "Thanh toán thành công! In hóa đơn");
            this.dispose();
            
            bHeight = Double.valueOf(lia.size());
            
            PrinterJob pj = PrinterJob.getPrinterJob();
            pj.setPrintable(new BillPrintable(), getPageFormat(pj));
             try {
                pj.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUIThanhToan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(GUIThanhToan.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(!jTextField1.getText().isEmpty()){
            try {
                if(!khachhang.checkphone(jTextField1.getText().toString())){
                    JOptionPane.showMessageDialog(jPanel1, "Đã tìm thấy!");
                    kh.setSDT(jTextField1.getText().toString());
                    kh = khachhang.getkhbysdt(kh);
                    hd.setMaKhachHang(kh.getMaKhachHang());
                    ud.setMaUuDai(kh.getMaUuDai());
                    ud = uudai.getud(ud);
                    double tienud = (tongtien*ud.getTiLeGiam())/100;
                    td.setTien(tongtien);
                    td = tichdiem.gettdbytien(tongtien);
                    hd.setMaTichDiem(td.getMaTichDiem());
                    diem = td.getDiemTichLuy();
                    tongtienfi = tongtienfi - tienud;
                    tongtienud=tienud;
                    jLabel5.setText("- "+Integer.toString((int)tienud)+" đ "+Integer.toString(ud.getTiLeGiam())+" %");
                    jLabel6.setText(Integer.toString(diem));
                    jTextField3.setText(Integer.toString((int)tongtienfi));
                }
                else{
                    JOptionPane.showMessageDialog(jPanel1, "Không tìm thấy!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(GUIThanhToan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(GUIThanhToan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(jPanel1, "Chưa nhập số điện thoại cần kiểm tra!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        if(jComboBox1.getSelectedItem() != null){
            if(!jComboBox1.getSelectedItem().equals("Khuyến mãi")){
                km.setTenKhuyenMai(jComboBox1.getSelectedItem().toString());
                try {
                    km = khuyenmai.getkmbyname(km);
                    hd.setMaKhuyenMai(km.getMaKhuyenMai());
                    double tienkm = (tongtien*km.getPhanTram())/100;
                    tongtienkm = tienkm;
                    jLabel4.setText("-"+Integer.toString((int)tienkm)+" đ "+Integer.toString(km.getPhanTram())+" %");
                    tongtienfi = tongtienfi - tongtienkm;
                    jTextField3.setText(Integer.toString((int)tongtienfi));
                } catch (SQLException ex) {
                    Logger.getLogger(GUIThanhToan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    double bHeight = 0.0;
    
    public PageFormat getPageFormat(PrinterJob pj) {
        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();
        
        double bodyHeight = bHeight;
        double headerHeight = 5.0;
        double footerHeight = 5.0;
        double width = cm_to_pp(14.5);
        double height = cm_to_pp(14.8);
        paper.setSize(width, height);
        paper.setImageableArea(0, 5, width, height);
        
        pf.setOrientation(PageFormat.PORTRAIT);
        pf.setPaper(paper);
        return pf;
    }
    
    protected static double cm_to_pp(double cm) {
        return toPPI(cm * 0.393600787);
    }
    
    protected static double toPPI(double inch) {
        return inch* 72d;
    }
    
    public class BillPrintable implements Printable {
           
        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
            int r = 10;
            int result = NO_SUCH_PAGE;
            if(pageIndex == 0) {
                Graphics2D g2d = (Graphics2D) graphics;
                double width = pageFormat.getImageableWidth();
                g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY());
                
                try{
                    int y = 20;
                    int yShift = 10;
                    int headerRectHeight = 15;
                    int a = 125;
                    int stt=0;
                    g2d.setFont(new Font("Times New Roman",Font.PLAIN,9));
//                    g2d.drawImage(s);
                    g2d.drawString("-------------------------------------------------------------", a, y);y+=yShift;
                    g2d.drawString("            CỬA HÀNG TIỆN LỢI Mimi                           ", a, y);y+=yShift;
                    g2d.drawString("       ĐỊA CHỈ: xxxxxxxxxxxxxxxxxx                          ", a, y);y+=yShift;
                    g2d.drawString("       SĐT: xxxxxxxxxxxxxxxxxx                              ", a, y);y+=yShift;
                    g2d.drawString("       Ngày mua: "+hd.getNgayMua()+"                         ", a, y);y+=yShift;
                    g2d.drawString("       Mã hóa đơn: "+hd.getMaHoaDon()+"                         ", a, y);y+=yShift;
                    g2d.drawString("       Tên Nhân viên: "+nv.getTenNhanVien()+"                       ", a, y);y+=yShift;
                    g2d.drawString("       Tên khách hàng: "+kh.getTenKhachHang()+"                  ", a, y);y+=yShift;
                    g2d.drawString("-------------------------------------------------------------", a, y);y+=headerRectHeight;
                    
                    g2d.drawString("   Tên sản phẩm                              Tổng tiền(VND)   ", a, y);y+=yShift;
                    g2d.drawString("-------------------------------------------------------------", a, y);y+=headerRectHeight;

                    for (DTOSanPham i : lia) {
                        stt++;
                        g2d.drawString("    "+stt+" "+i.getTenSanPham()+"                                        ", a, y);y+=headerRectHeight;
                        g2d.drawString("        "+i.getGiaBan()+"      *"+i.getSoLuong()+"                            "+i.getSoLuong()*i.getGiaBan(), a, y);y+=yShift;
                        
                    }
                    g2d.drawString("-------------------------------------------------------------", a, y);y+=yShift;
                    g2d.drawString("    Tổng tiền mua:                                     "+tongtien, a, y);y+=yShift;
                    g2d.drawString("-------------------------------------------------------------", a, y);y+=yShift;
                    g2d.drawString("    Áp dụng Khuyến mãi:                                -"+tongtienkm, a, y);y+=yShift;
                    g2d.drawString("-------------------------------------------------------------", a, y);y+=yShift;
                    g2d.drawString("    Ưu đãi khách hàng:                                   -"+tongtienud, a, y);y+=yShift;
                    g2d.drawString("-------------------------------------------------------------", a, y);y+=yShift;
                    g2d.drawString("    Thành tiền:                                           "+tongtienfi, a, y);y+=yShift;
                    
                    g2d.drawString("*******************************************", a, y);y+=yShift;
                    g2d.drawString("                       CẢM ƠN QUÝ KHÁCH                      ", a, y);y+=yShift;
                    g2d.drawString("*******************************************", a, y);y+=yShift;
                    
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                result = PAGE_EXISTS;
            }
            return result;
        }
        
    }
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
            java.util.logging.Logger.getLogger(GUIThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIThanhToan(list,manv).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}