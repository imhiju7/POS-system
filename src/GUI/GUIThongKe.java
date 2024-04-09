   /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;
import BUS.*;
import DTO.DTONhanVien;
import com.raven.chart.Chart;
import com.raven.chart.ModelChart;
import java.awt.Color;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hieu PC
 */
public class GUIThongKe extends javax.swing.JPanel {

    /**
     * Creates new form GUIThongKe
     */
    BUSThongKe thongke = new BUSThongKe();
    Date day = thongke.convertStringToDate("01-01-2020");
    public GUIThongKe() {
        initComponents();
        chart1.addLegend("Tiền bán", new Color(245, 189, 135));
        chart1.addLegend("Tiền nhập hàng", new Color(135, 189, 245));
        chart1.addLegend("Lợi nhuận", new Color(139, 229, 222));
        chart1.addLegend("Lỗ", new Color(189, 135, 245));
        Calendar calht = Calendar.getInstance();
        Date day2 = calht.getTime();
        
        resetall();
        jTextField6.setText(Double.toString(thongke.gettongdt(day,day2)-thongke.gettongtn(day,day2)));
        
    }
    public void resetall(){
        Calendar calht = Calendar.getInstance();
        Date day2 = calht.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String d2 = sdf.format(day2);
        Calendar calqk = Calendar.getInstance();
        calqk.add(Calendar.MONTH, -6);
        Date day1 = calqk.getTime();
        String d1 = sdf.format(day1);
        d1 = d1.substring(0, 7)+"-01";
        d2 = d2.substring(0, 7)+"-01";
        day2 = thongke.convertStringToDate(d2);
        day1 = thongke.convertStringToDate(d1);
        chart1.clear();
        chart1.start();
        monthsplit(chart1,day1,day2);
    }
    public void yearsplit(Chart chart,Date day1, Date day2){
        LocalDate localDate1 = day1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate2 = day2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Tính số tháng giữa hai ngày
        Period period = Period.between(localDate1, localDate2);
        int year = period.getYears();
        for(int i = 0; i < year;i++){
            Calendar calday  = Calendar.getInstance();
            calday.setTime(day1);
            calday.add(Calendar.YEAR, 1);
            Date labelday = calday.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String label = sdf.format(day1);
            label = label.substring(6 );
            importchart(chart,day1,labelday,label);
            day1 = calday.getTime();
        }
    }
    public void monthsplit(Chart chart,Date day1, Date day2){
        LocalDate localDate1 = day1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate2 = day2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Tính số tháng giữa hai ngày
        Period period = Period.between(localDate1, localDate2);
        int month = period.getMonths();
        for(int i = 0; i < month+1;i++){
            Calendar calday  = Calendar.getInstance();
            calday.setTime(day1);
            calday.add(Calendar.MONTH, 1);
            Date labelday = calday.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String label = sdf.format(day1);
            label = label.substring(3,5 );
            importchart(chart,day1,labelday,label);
            day1 = calday.getTime();
        }
    }
    public void daysplit(Chart chart,Date day1, Date day2){
        long mili = day2.getTime() - day1.getTime();
        long day = TimeUnit.DAYS.convert(mili, TimeUnit.MILLISECONDS);

        Calendar calday1  = Calendar.getInstance();
        calday1.setTime(day1);
        calday1.add(Calendar.DAY_OF_MONTH,-1);
        day1 = calday1.getTime();
        
        for(long i = 0; i < day+1;i++ ){
            Calendar calday  = Calendar.getInstance();
            calday.setTime(day1);
            calday.add(Calendar.DAY_OF_MONTH, 1);
            Date labelday = calday.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String label = sdf.format(day1);
            label = label.substring(0,5 );
            importchart(chart,day1,labelday,label);
            day1 = calday.getTime();
        }
    }
    public void importchart(Chart chart,Date day1,Date day2,String label){
        double a = thongke.gettongdt(day1, day2);
        double b = thongke.gettongtn(day1, day2);
        double c = a  - b;
        if(c > 0){
            chart.addData(new ModelChart(label, new double[]{a, b, c,0}));
        }
        else{
            chart.addData(new ModelChart(label, new double[]{a, b, 0,-1*c}));
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        dateChooser2 = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        chart1 = new com.raven.chart.Chart();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();

        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(jTextField5);

        dateChooser2.setDateFormat("yyyy-MM-dd");
        dateChooser2.setTextRefernce(jTextField4);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(161, 204, 209));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Doanh thu");
        jLabel1.setToolTipText("");
        jLabel1.setPreferredSize(new java.awt.Dimension(203, 100));
        jPanel2.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(245, 232, 183));
        jPanel3.setPreferredSize(new java.awt.Dimension(1152, 686));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Tiền bán");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tiền nhập");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Lợi nhuận");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SOURCE/icon/search.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Loại", "Ngày", "Tháng", "Năm" }));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tổng");

        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton8.setBackground(new java.awt.Color(161, 204, 209));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SOURCE/Icon/reset.png"))); // NOI18N
        jButton8.setToolTipText("");
        jButton8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(chart1, javax.swing.GroupLayout.PREFERRED_SIZE, 1113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(296, 296, 296)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField5)
                    .addComponent(jTextField4)
                    .addComponent(jComboBox1)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(chart1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1152, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 786, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int item = jComboBox1.getSelectedIndex();
        String day2 = jTextField4.getText().toString();
        String day1 = jTextField5.getText().toString();
        if(!day1.isEmpty() && !day2.isEmpty()){
            if(item == 1){
                Date d1 = thongke.convertStringToDate(day1);
                Date d2 = thongke.convertStringToDate(day2);
                chart1.clear();
                chart1.start();
                jTextField1.setText(Double.toString(thongke.gettongdt(d1,d2)));
                jTextField2.setText(Double.toString(thongke.gettongtn(d1,d2)));
                jTextField3.setText(Double.toString(thongke.gettongdt(d1,d2)-thongke.gettongtn(d1,d2)));
                daysplit(chart1,d1,d2);
            }
            else if(item == 2){
                day1 = day1.substring(0,7)+"-01";
                day2 = day2.substring(0,7)+"-01";
                Date d1 = thongke.convertStringToDate(day1);
                Date d2 = thongke.convertStringToDate(day2);
                chart1.clear();
                chart1.start();
                jTextField1.setText(Double.toString(thongke.gettongdt(d1,d2)));
                jTextField2.setText(Double.toString(thongke.gettongtn(d1,d2)));
                jTextField3.setText(Double.toString(thongke.gettongdt(d1,d2)-thongke.gettongtn(d1,d2)));
                monthsplit(chart1,d1,d2);
            }
            else if(item == 3){
                day1 = day1.substring(0,5)+"01-01";
                day2 = day2.substring(0,5)+"01-01";
                Date d1 = thongke.convertStringToDate(day1);
                Date d2 = thongke.convertStringToDate(day2);
                chart1.clear();
                chart1.start();
                jTextField1.setText(Double.toString(thongke.gettongdt(d1,d2)));
                jTextField2.setText(Double.toString(thongke.gettongtn(d1,d2)));
                jTextField3.setText(Double.toString(thongke.gettongdt(d1,d2)-thongke.gettongtn(d1,d2)));
                yearsplit(chart1,d1,d2);
            }
            else{
                JOptionPane.showMessageDialog(jPanel1, "Chưa chọn loại tìm kiếm!");
            }
        }
        else{
            JOptionPane.showMessageDialog(jPanel1, "Chọn khoảng thời gian!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        resetall();
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jComboBox1.setSelectedItem("Loại");
    }//GEN-LAST:event_jButton8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.chart.Chart chart1;
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
