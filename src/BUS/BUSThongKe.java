/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.*;
import DTO.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Hieu PC
 */
public class BUSThongKe {
    DAOKhachHang khachhang = new DAOKhachHang();
    DAOPhieuNhap phieunhap = new DAOPhieuNhap();
    DAOHoaDon hoadon = new  DAOHoaDon();
    public double gettongtn(Date d1,Date d2){
        double tong = 0;
        try {
            ArrayList<DTOPhieuNhap> list = phieunhap.getlist();
            for(DTOPhieuNhap i: list){
                if(i.getNgayNhap().after(d1) && i.getNgayNhap().before(d2)){
                    tong+=i.getTongTien();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BUSThongKe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(BUSThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tong;
    }
    public double gettongdt(Date d1,Date d2){
        double tong = 0;
        try {
            ArrayList<DTOHoaDon> list = hoadon.getlist();
            for(DTOHoaDon i: list){
                if(i.getNgayMua().after(d1) && i.getNgayMua().before(d2)){
                    tong+=i.getTongTien();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BUSThongKe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(BUSThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tong;
    }
    public Date convertStringToDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Trả về null nếu có lỗi chuyển đổi
        }
    }
}
