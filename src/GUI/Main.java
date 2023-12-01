package GUI;

import GUI.comp.*;

import java.awt.Component;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;


public class Main extends javax.swing.JFrame {

    private MigLayout layout;
    private Menu menu;
    private MainForm main;
    private Animator animator;
    private static int manv = 0;
    private static int mapq = 0;

    public static int getMapq() {
        return mapq;
    }

    public static void setMapq(int mapq) {
        Main.mapq = mapq;
    }
    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }
    public Main(int mnv) {
        initComponents();
        init();
        manv = mnv;
    }

    private void init() {
        layout = new MigLayout("fill", "[][100%, fill]", "[fill, top]");
        bg.setLayout(layout); 
        menu = new Menu();
        main = new MainForm();
        mapq = 0;
        //  Init google icon font
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                if(mapq == 1){
                    
                }
                else if(mapq == 2){
                    
                }
                else if(mapq == 3){
                    
                }
                else{
                    if(menuIndex == 0){
                        main.showForm(new GUITaiKhoan());
                    }
                    else if(menuIndex == 1){
                        if(subMenuIndex == 0){
                            
                        }
                        else if(subMenuIndex == 1){

                        }
                        else if(subMenuIndex == 2){

                        }
                    }
                    else if(menuIndex == 2){
                        if(subMenuIndex == 0){
                            
                        }
                        else{
                            
                        }
                    }
                    else if(menuIndex == 3){
                        
                    }
                    else if(menuIndex == 4){
                        
                    }
                    else if(menuIndex == 5){
                        
                    }
                    else if(menuIndex == 6){
                        
                    }
                    else{
                        
                    }
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
