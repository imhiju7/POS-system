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
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Hieu PC
 */
public class BUSSanPham {
    DAOSanPham DAO = new DAOSanPham();
    DAOPhanLoai DAOpl = new DAOPhanLoai();
    public ArrayList<DTOSanPham> getlist() throws SQLException, ParseException{
        return DAO.getlist();
    }
    public int addsanpham(DTOSanPham i) throws SQLException{
        return DAO.addsanpham(i);
    }
    public int updatesanpham(DTOSanPham i) throws SQLException{
        return DAO.updatesanpham(i);
    }
    public String getname(DTOSanPham i) throws SQLException{
        return DAO.getsp(i).getTenSanPham();
    }
    public DTOSanPham getspbyname(DTOSanPham i) throws SQLException{
        return DAO.getspbyname(i);
    }
    public void jtimport(JTable jt,ArrayList<DTOSanPham> list) throws SQLException, ParseException{
        
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã sản phẩm");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Phân loại");
        model.addColumn("Giá bán");
        model.addColumn("Số lượng");
        model.addColumn("Ngày thêm");
        
        for(DTOSanPham i: list){
            DTOPhanLoai pl = new DTOPhanLoai();
            pl.setMaPhanLoai(i.getMaPhanLoai());
            pl = DAOpl.getpl(pl);
            model.addRow(new Object[]{i.getMaSanPham(),i.getTenSanPham(),pl.getTenPhanLoai(),i.getGiaBan(),i.getSoLuong(),i.getNgayThem()});
        }
        jt.setModel(model);
    }
    public String getimg(DTOSanPham i) throws SQLException{
        return DAO.getsp(i).getImg();
    }
    public ArrayList<DTOSanPham> jtexport(JTable jt) throws SQLException{
        ArrayList<DTOSanPham> list = new ArrayList<>();
        int size = jt.getRowCount();
        for(int i = 0; i < size; i++){
            DTOSanPham a = new DTOSanPham();
            a.setMaSanPham(Integer.parseInt(jt.getValueAt(i, 0).toString()));
            a = DAO.getsp(a);
            list.add(a);
        }
        return list;
    }
    public void cbplimport(JComboBox jcb,ArrayList<DTOPhanLoai> list){
        jcb.removeAllItems();
        jcb.addItem("Phân loại");
        for(DTOPhanLoai i: list){
            jcb.addItem(i.getTenPhanLoai());
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
    public ArrayList<DTOSanPham> searchten(ArrayList<DTOSanPham> list,String tennv) throws SQLException{
        ArrayList<DTOSanPham> result = new ArrayList<>();
        for(DTOSanPham i: list){
            if(i.getTenSanPham().contains(tennv)){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTOSanPham> searchpl(ArrayList<DTOSanPham> list,String tennv) throws SQLException{
        ArrayList<DTOSanPham> result = new ArrayList<>();
        for(DTOSanPham i: list){
            DTOPhanLoai pl = new DTOPhanLoai();
            pl.setMaPhanLoai(i.getMaPhanLoai());
            if(pl.getTenPhanLoai().contains(tennv)){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTOSanPham> searchdate(ArrayList<DTOSanPham> list,Date day1,Date day2){
        ArrayList<DTOSanPham> result = new ArrayList<>();
        for(DTOSanPham i: list){
            if(i.getNgayThem().after(day1) && i.getNgayThem().before(day2)){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTOSanPham> searchgia(ArrayList<DTOSanPham> list,double var1,double var2){
        ArrayList<DTOSanPham> result = new ArrayList<>();
        for(DTOSanPham i: list){
            if(i.getGiaBan()>= var1 && i.getGiaBan() <= var2){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTOSanPham> searchsl(ArrayList<DTOSanPham> list,int var1,int var2){
        ArrayList<DTOSanPham> result = new ArrayList<>();
        for(DTOSanPham i: list){
            if(i.getSoLuong() >= var1 && i.getSoLuong() <= var2){
                result.add(i);
            }
        }
        return result;
    }
    public boolean checktensp(String name) throws SQLException{
        return DAO.checktensp(name);
    }
    public boolean checktenspedit(String name,int masp) throws SQLException{
        return DAO.checktenspedit(name, masp);
    }
}
