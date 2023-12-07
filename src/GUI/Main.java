package GUI;

import GUI.comp.*;
import DTO.*;
import BUS.*;
import java.awt.Component;
import java.awt.Frame;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;


public class Main extends javax.swing.JFrame {

    private MigLayout layout;
    private Menu menu;
    private MainForm main;
    private Animator animator;
    static int manv;
    BUSNhanVien nhanvien = new BUSNhanVien();
    public Main(int mnv) {
        initComponents();
        init(mnv);
    }

    private void init(int mnv) {
        layout = new MigLayout("fill", "[][100%, fill]", "[fill, top]");
        bg.setLayout(layout); 
        DTONhanVien nv = new DTONhanVien();
        nv.setMaNhanVien(mnv);
        try {
            int macv = nhanvien.maChucVu(nv);
            menu = new Menu(macv);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        main = new MainForm();
        main.showForm(new GUITrangChu(mnv));
        //  Init google icon font
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                DTONhanVien nv = new DTONhanVien();
                nv.setMaNhanVien(mnv);
                int macv;
                try {
                    macv = nhanvien.maChucVu(nv);
                    if(macv == 1){
                        if(menuIndex == 0){
                            if(subMenuIndex == 0){
                                main.showForm(new GUIOrder(mnv));
                            }
                            else if(subMenuIndex == 1){
                                 main.showForm(new GUIHoaDon());
                            }
                        }
                        else if(menuIndex == 1){
                            if(subMenuIndex == 0){
                                main.showForm(new GUISanPham());
                            }
                            else if(subMenuIndex == 1){
                                 main.showForm(new GUINhaCungCap());
                            }
                            else if(subMenuIndex == 2){
                                 main.showForm(new GUIPhieuNhap(mnv));
                            }
                        }
                        else if(menuIndex == 2){
                            if(subMenuIndex == 0){
                                main.showForm(new GUINhanVien());
                            }
                            else if(subMenuIndex == 1){
                                 main.showForm(new GUITaiKhoan());
                            }
                            else if(subMenuIndex == 2){
                                 main.showForm(new GUIPhanQuyen());
                            }
                        }
                        else if(menuIndex == 3){
                            if(subMenuIndex == 0){
                                main.showForm(new GUIKhachHang());
                            }
                            else if(subMenuIndex == 1){
                                 main.showForm(new GUIKhuyenMai());
                            }
                        }
                        else if(menuIndex == 4){
                            if(subMenuIndex == 0){
                                main.showForm(new GUIThongKe());
                            }
                        }
                        else if(menuIndex == 5){
                            if(subMenuIndex == 0){
                                main.showForm(new GUIDangXuat(mnv));
                            }
                        }
                    }
                    else if(macv == 2){
                        if(menuIndex == 0){
                            if(subMenuIndex == 0){
                                 main.showForm(new GUIPhieuNhap(mnv));
                            }
                        }
                        else if(menuIndex == 1){
                            if(subMenuIndex == 0){
                                main.showForm(new GUIDangXuat(mnv));
                            }
                        }
                    }
                    else if(macv == 3){
                        if(menuIndex == 0){
                            if(subMenuIndex == 0){
                                main.showForm(new GUIOrder(mnv));
                            }
                            else if(subMenuIndex == 1){
                                main.showForm(new GUIHoaDon());
                            }
                        }
                        else if(menuIndex == 1){
                            if(subMenuIndex == 0){
                                main.showForm(new GUIDangXuat(mnv));
                            }
                            
                        }
                    }
                    else if(macv == 4){
                        if(menuIndex == 0){
                            if(subMenuIndex == 0){
                                 main.showForm(new GUIHoaDon());
                            }
                        }
                        else if(menuIndex == 1){
                            if(subMenuIndex == 0){
                                 main.showForm(new GUISanPham());
                            }
                            else if(subMenuIndex == 1){
                                 main.showForm(new GUINhaCungCap());
                            }
                        }
                        else if(menuIndex == 2){
                            if(subMenuIndex == 0){
                                 main.showForm(new GUINhanVien());
                            }
                        }
                        else if(menuIndex == 3){
                            if(subMenuIndex == 0){
                                 main.showForm(new GUIKhachHang());
                            }
                            else if(subMenuIndex == 1){
                                 main.showForm(new GUIKhuyenMai());
                            }
                        }
                        else if(menuIndex == 4){
                            if(subMenuIndex == 0){
                                main.showForm(new GUIThongKe());
                            }
                        }
                        else if(menuIndex == 5){
                            if(subMenuIndex == 0){
                                main.showForm(new GUIDangXuat(mnv));
                            }
                        }
                    }
                    else if(macv ==5){
                        if(menuIndex == 0){
                            if(subMenuIndex == 0){
                                 main.showForm(new GUIHoaDon());
                            }
                        }
                        else if(menuIndex == 1){
                            if(subMenuIndex == 0){
                                 main.showForm(new GUIPhieuNhap(mnv));
                            }
                        }
                        else if(menuIndex == 2){
                            if(subMenuIndex == 0){
                                 main.showForm(new GUIThongKe());
                            }
                        }
                        else if(menuIndex == 3){
                            if(subMenuIndex == 0){
                                 main.setVisible(false);
                            }
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;
                PopupMenu popup = new PopupMenu(Main.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = Main.this.getX() + 62;
                int y = Main.this.getY() + com.getY() + 95;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        menu.initMenuItem(manv);
        bg.add(menu, "w 230!, spany 2");    // Span Y 2cell
        bg.add(main, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        //  Start with this form
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new GUI.comp.PanelTransparent();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setOpaque(true);
        bg.setPreferredSize(new java.awt.Dimension(1256, 705));

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1400, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 1400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formMouseClicked

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SwingAcrylic.prepareSwing();
                Main frame = new Main(manv);
                frame.setVisible(true);
                SwingAcrylic.processFrame(frame);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.comp.PanelTransparent bg;
    // End of variables declaration//GEN-END:variables
}
