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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Hieu PC
 */
public class BUSKhuyenMai {
    DAOKhuyenMai DAO = new DAOKhuyenMai();
    public ArrayList<DTOKhuyenMai> getlist() throws SQLException, ParseException{
        return DAO.getlist();
    }
    public int addkhuyenmai(DTOKhuyenMai i) throws SQLException{
        return DAO.addKhuyenMai(i);
    }
    public int updatekhuyenmai(DTOKhuyenMai i) throws SQLException{
        return DAO.updateKhuyenMai(i);
    }
    public int deletekhuyenmai(DTOKhuyenMai i) throws SQLException{
        return DAO.deletekhuyenmai(i);
    }
    public boolean checkkm(DTOKhuyenMai i) throws SQLException{
        return DAO.checkdel(i);
    }
    public DTOKhuyenMai getkm(DTOKhuyenMai i) throws SQLException{
        return DAO.getkm(i);
    }
    public DTOKhuyenMai getkmbyname(DTOKhuyenMai i) throws SQLException{
        return DAO.getkmbyname(i);
    }
    public ArrayList<DTOKhuyenMai> getkhuyenmaitoday() throws SQLException, ParseException{
        ArrayList<DTOKhuyenMai> list = getlist();
        ArrayList<DTOKhuyenMai> result = new ArrayList<>();
        Date day = new Date();
        for(DTOKhuyenMai i: list){
            if(i.getNgayBatDau().before(day) && i.getNgayHetHan().after(day)){
                result.add(i);
            }
        }
        return result;
    }
    public void jtimport(JTable jt,ArrayList<DTOKhuyenMai> list) throws SQLException, ParseException{
        
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã khuyến mãi");
        model.addColumn("Tên khuyến mãi");
        model.addColumn("Số lượng");
        model.addColumn("Số lượng đã dùng");
        model.addColumn("Tỉ lệ giảm ( % )");
        model.addColumn("Ngày bắt đầu");
        model.addColumn("Ngày hết hạn");
        
        for(DTOKhuyenMai i: list){
            model.addRow(new Object[]{i.getMaKhuyenMai(),i.getTenKhuyenMai(),i.getSoLuong(),i.getSoLuongDaDung(),i.getPhanTram(),i.getNgayBatDau(),i.getNgayHetHan()});
        }
        jt.setModel(model);
    }
    public ArrayList<DTOKhuyenMai> jtexport(JTable jt) throws SQLException{
        ArrayList<DTOKhuyenMai> list = new ArrayList<>();
        int size = jt.getRowCount();
        for(int i = 0; i < size; i++){
            DTOKhuyenMai a = new DTOKhuyenMai();
            a.setMaKhuyenMai(Integer.parseInt(jt.getValueAt(i, 0).toString()));
            a = getkm(a);
            list.add(a);
        }
        return list;
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
    public ArrayList<DTOKhuyenMai> searchten(ArrayList<DTOKhuyenMai> list,String ten){
        ArrayList<DTOKhuyenMai> result = new ArrayList<>();
        for(DTOKhuyenMai i: list){
            if(i.getTenKhuyenMai().contains(ten)){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTOKhuyenMai> searchsldd(ArrayList<DTOKhuyenMai> list,int var1,int var2){
        ArrayList<DTOKhuyenMai> result = new ArrayList<>();
        for(DTOKhuyenMai i: list){
            if(i.getSoLuongDaDung() >= var1 && i.getSoLuongDaDung() <= var2){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTOKhuyenMai> searchtile(ArrayList<DTOKhuyenMai> list,int var1,int var2){
        ArrayList<DTOKhuyenMai> result = new ArrayList<>();
        for(DTOKhuyenMai i: list){
            if(i.getPhanTram()>= var1 && i.getPhanTram() <= var2){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTOKhuyenMai> searchdatebd(ArrayList<DTOKhuyenMai> list,Date day1,Date day2){
        ArrayList<DTOKhuyenMai> result = new ArrayList<>();
        for(DTOKhuyenMai i: list){
            if(i.getNgayBatDau().after(day1) && i.getNgayBatDau().before(day2)){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTOKhuyenMai> searchdatehh(ArrayList<DTOKhuyenMai> list,Date day1,Date day2){
        ArrayList<DTOKhuyenMai> result = new ArrayList<>();
        for(DTOKhuyenMai i: list){
            if(i.getNgayHetHan().after(day1) && i.getNgayHetHan().before(day2)){
                result.add(i);
            }
        }
        return result;
    }
}
