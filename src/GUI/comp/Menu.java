package GUI.comp;

import java.awt.Component;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;

public class Menu extends PanelTransparent {

    public boolean isShowMenu() {
        return showMenu;
    }

    public void addEvent(EventMenuSelected event) {
        this.event = event;
    }

    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    public void addEventShowPopup(EventShowPopupMenu eventShowPopup) {
        this.eventShowPopup = eventShowPopup;
    }

    private final MigLayout layout;
    private EventMenuSelected event;
    private EventShowPopupMenu eventShowPopup;
    private boolean enableMenu = true;
    private boolean showMenu = true;

    public Menu() {
        initComponents();
        setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
        panel.setLayout(layout);
        setTransparent(1f);
    }

    public void initMenuItem(int menu) {
        if(menu == 1){
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/SOURCE/Icon/user.png")), "Cài đặt","Tài khoản","Đăng xuất"));
        }
        else if(menu == 2){
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/SOURCE/Icon/user.png")), "Cài đặt","Tài khoản","Đăng xuất"));
        }
        else if(menu == 3){
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/SOURCE/Icon/user.png")), "Cài đặt","Tài khoản","Đăng xuất"));
        }
        else{
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/SOURCE/Icon/user.png")), "Quầy","Order","Hóa đơn"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/SOURCE/Icon/user.png")), "Nhân viên","Thông tin nhân viên","Tài khoản","Phân quyền","Chức vụ"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/SOURCE/Icon/user.png")), "Nhập kho","Phiếu nhập","Nhà cung cấp"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/SOURCE/Icon/user.png")), "Sản phẩm"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/SOURCE/Icon/user.png")), "Khuyến mãi"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/SOURCE/Icon/user.png")), "Khách hàng"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/SOURCE/Icon/user.png")), "Thống kê"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/SOURCE/Icon/user.png")), "Cài đặt","Tài khoản","Đăng xuất"));
        }
    }

    private void addMenu(ModelMenu menu) {
        panel.add(new MenuItem(menu, getEventMenu(), event, panel.getComponentCount()), "h 40!");
    }

    private EventMenu getEventMenu() {
        return new EventMenu() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
                if (enableMenu) {
                    if (isShowMenu()) {
                        if (open) {
                            new MenuAnimation(layout, com).openMenu();
                        } else {
                            new MenuAnimation(layout, com).closeMenu();
                        }
                        return true;
                    } else {
                        eventShowPopup.showPopup(com);
                    }
                }
                return false;
            }
        };
    }

    public void hideallMenu() {
        for (Component com : panel.getComponents()) {
            MenuItem item = (MenuItem) com;
            if (item.isOpen()) {
                new MenuAnimation(layout, com, 500).closeMenu();
                item.setOpen(false);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        profile1 = new GUI.comp.Profile();

        setBackground(new java.awt.Color(153, 0, 0));

        sp.setBackground(new java.awt.Color(255, 153, 0));
        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 772, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        profile1.setBackground(new java.awt.Color(204, 51, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    private GUI.comp.Profile profile1;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
