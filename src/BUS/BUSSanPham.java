/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.*;
import DTO.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
/**
 *
 * @author Hieu PC
 */
public class BUSSanPham {
    DAOSanPham DAO = new DAOSanPham();
    public ArrayList<DTOSanPham> getlist() throws SQLException, ParseException{
        return DAO.getlist();
    }
    public int addsanpham(DTOSanPham i) throws SQLException{
        return DAO.addsanpham(i);
    }
    public int updatesanpham(DTOSanPham i) throws SQLException{
        return DAO.updatesanpham(i);
    }
<<<<<<< Updated upstream
=======
    public String getname(DTOSanPham i) throws SQLException{
        return DAO.getsp(i).getTenSanPham();
    }
    public DTOSanPham getspbyname(DTOSanPham i) throws SQLException{
        return DAO.getspbyname(i);
    }
    public int updateslsanpham(DTOSanPham i) throws SQLException{
        return DAO.updatesoluong(i);
    }
    public ArrayList<DTOSanPham> getlistorder() throws SQLException, ParseException{
        return DAO.getlistorder();
    }
    public void jtimport(JTable jt,ArrayList<DTOSanPham> list) throws SQLException, ParseException{
        
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã sản phẩm");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Phân loại");
        model.addColumn("Giá bán");
        model.addColumn("Giá nhập");
        model.addColumn("Số lượng");
        model.addColumn("Ngày thêm");
        
        for(DTOSanPham i: list){
            DTOPhanLoai pl = new DTOPhanLoai();
            pl.setMaPhanLoai(i.getMaPhanLoai());
            pl = DAOpl.getpl(pl);
            model.addRow(new Object[]{i.getMaSanPham(),i.getTenSanPham(),pl.getTenPhanLoai(),i.getGiaBan(),i.getGiaNhap(),i.getSoLuong(),i.getNgayThem()});
        }
        jt.setModel(model);
    }
    public String getimg(DTOSanPham i) throws SQLException{
        return DAO.getsp(i).getImg();
    }
    public DTOSanPham getsp(DTOSanPham i) throws SQLException{
        return DAO.getsp(i);
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
    public void jtnofiimport(JTable jt,ArrayList<DTOSanPham> list){
         DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã sản phẩm");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Số lượng hiện tại");
        
        for(DTOSanPham i: list){
            model.addRow(new Object[]{i.getMaSanPham(),i.getTenSanPham(),i.getSoLuong()});
        }
        jt.setModel(model);
    }
    public ArrayList<DTOSanPham> listcanhap() throws SQLException{
        return DAO.spcannhap();
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
            pl = DAOpl.getpl(pl);
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
    public ArrayList<DTOSanPham> searchgianhap(ArrayList<DTOSanPham> list,double var1,double var2){
        ArrayList<DTOSanPham> result = new ArrayList<>();
        for(DTOSanPham i: list){
            if(i.getGiaNhap()>= var1 && i.getGiaNhap() <= var2){
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
    public int updategianhap(DTOSanPham i) throws SQLException{
        return DAO.updategianhap(i);
    }
>>>>>>> Stashed changes
}
