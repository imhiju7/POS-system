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
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hieu PC
 */
public class BUSCTPhieuNhap {
    DAOCTPhieuNhap DAO = new DAOCTPhieuNhap();
    DAOSanPham DAOsp = new DAOSanPham();
    public ArrayList<DTOCTPhieuNhap> getlist(int code) throws SQLException{
        return DAO.getlist(code);
    }
    public int addctphieunhap(DTOCTPhieuNhap i) throws SQLException{
        return DAO.addctphieunhap(i);
    }
    public int updatectphieunhap(DTOCTPhieuNhap i) throws SQLException{
        return DAO.updatectphieunhap(i);
    }
    public int deletephieunhap(DTOCTPhieuNhap i) throws SQLException{
        return DAO.deletectphieunhap(i);
    }
    public DTOCTPhieuNhap getctpn(DTOCTPhieuNhap i) throws SQLException{
        return DAO.getctpn(i.getMaCTPhieuNhap());
    }
    public boolean checksp(int masp,int mactpn,int mapn) throws SQLException{
        return DAO.checksp(masp, mactpn,mapn);
    }
    public DTOCTPhieuNhap getspganhh(int masp) throws SQLException{
        ArrayList<DTOCTPhieuNhap> list = DAO.getalllist();
        DTOCTPhieuNhap sp= new DTOCTPhieuNhap();
        int day = 100000;
        for(DTOCTPhieuNhap i : list){
            if(i.getMaSanPham() == masp){
                int han = isganhh(i.getNgayhethan().toString());
                if(han < day){
                    day = han;
                    sp = i;
                }
            }
        }
        return sp;
    }
    public int isganhh(String birthday) {
        // Định dạng ngày tháng từ chuỗi
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(birthday, formatter);
        // Tính tuổi hiện tại
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(currentDate,birthDate);
        return age.getDays();
    }
    public void jtimport(JTable jt,ArrayList<DTOCTPhieuNhap> list) throws SQLException{
        
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã CT Phiếu nhập");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Đơn giá");
        model.addColumn("Số lượng");
        model.addColumn("Số lượng tồn kho");
        model.addColumn("Ngày hết hạn");
        model.addColumn("Ghi chú");
        
        for(DTOCTPhieuNhap i: list){
            DTOSanPham sp = new DTOSanPham();
            sp.setMaSanPham(i.getMaSanPham());
            sp = DAOsp.getsp(sp);
            model.addRow(new Object[]{i.getMaCTPhieuNhap(),sp.getTenSanPham(),i.getDonGia(),i.getSoLuong(),i.getSoluongtonkho(),i.getNgayhethan(),i.getGhichu()});
        }
        jt.setModel(model);
    }
    public ArrayList<DTOCTPhieuNhap> jtexport(JTable jt) throws SQLException{
        ArrayList<DTOCTPhieuNhap> list = new ArrayList<>();
        int size = jt.getRowCount();
        for(int i = 0; i < size; i++){
            DTOCTPhieuNhap a = new DTOCTPhieuNhap();
            a.setMaCTPhieuNhap(Integer.parseInt(jt.getValueAt(i, 0).toString()));
            a = DAO.getctpn(a.getMaCTPhieuNhap());
            list.add(a);
        }
        return list;
    }
    
    public void cbimport(JComboBox jcb,ArrayList<DTOSanPham> cv){
        jcb.removeAllItems();
        jcb.addItem("Sản phẩm");
        for(DTOSanPham i: cv){
            jcb.addItem(i.getTenSanPham());
        }
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
    public ArrayList<DTOCTPhieuNhap> searchdate(ArrayList<DTOCTPhieuNhap> list,Date day1,Date day2){
        ArrayList<DTOCTPhieuNhap> result = new ArrayList<>();
        for(DTOCTPhieuNhap i: list){
            if(i.getNgayhethan().after(day1) && i.getNgayhethan().before(day2)){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTOCTPhieuNhap> searchmoney(ArrayList<DTOCTPhieuNhap> list,double var1,double var2){
        ArrayList<DTOCTPhieuNhap> result = new ArrayList<>();
        for(DTOCTPhieuNhap i: list){
            if(i.getDonGia() >= var1 && i.getDonGia() <= var2){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTOCTPhieuNhap> searchsl(ArrayList<DTOCTPhieuNhap> list,int var1,int var2){
        ArrayList<DTOCTPhieuNhap> result = new ArrayList<>();
        for(DTOCTPhieuNhap i: list){
            if(i.getSoLuong() >= var1 && i.getSoLuong() <= var2){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTOCTPhieuNhap> searchsltk(ArrayList<DTOCTPhieuNhap> list,int var1,int var2){
        ArrayList<DTOCTPhieuNhap> result = new ArrayList<>();
        for(DTOCTPhieuNhap i: list){
            if(i.getSoluongtonkho() >= var1 && i.getSoluongtonkho() <= var2){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTOCTPhieuNhap> searchghichu(ArrayList<DTOCTPhieuNhap> list,String ghichu){
        ArrayList<DTOCTPhieuNhap> result = new ArrayList<>();
        for(DTOCTPhieuNhap i: list){
            if(i.getGhichu() != null && i.getGhichu().contains(ghichu)){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTOCTPhieuNhap> searchtensp(ArrayList<DTOCTPhieuNhap> list,String tenncc) throws SQLException{
        ArrayList<DTOCTPhieuNhap> result = new ArrayList<>();
        for(DTOCTPhieuNhap i: list){
            DTOSanPham sp = new DTOSanPham();
            sp.setMaSanPham(i.getMaSanPham());
            sp = DAOsp.getsp(sp);
            if(sp.getTenSanPham().contains(tenncc)){
                result.add(i);
            }
        }
        return result;
    }
    public int gettongsl(int masp) throws SQLException{
        int tong = 0;
        ArrayList<DTOCTPhieuNhap> i = DAO.getalllist();
        for(DTOCTPhieuNhap a: i){
            if(a.getMaSanPham() == masp){
                tong = tong + a.getSoluongtonkho();
            }
        }
        return tong;
    }
    
}
