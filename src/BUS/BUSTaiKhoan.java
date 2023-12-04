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
public class BUSTaiKhoan {

    DAOTaiKhoan DAO = new DAOTaiKhoan();
    DAONhanVien DAOnv = new DAONhanVien();
    public ArrayList<DTOTaiKhoan> getlist() throws SQLException, ParseException {
        return DAO.getList();
    }

    public int addtaikhoan(DTOTaiKhoan i) throws SQLException {
        return DAO.addtaikhoan(i);
    }

    public int updatetaikhoan(DTOTaiKhoan i) throws SQLException {
        return DAO.updatetaikhoan(i);
    }
    public int deletetaikhoan(DTOTaiKhoan i) throws SQLException{
        return DAO.deletetaikhoan(i);
    }
    public ArrayList<DTONhanVien> getlistsdtnvchcotk(){
        return DAO.ListComboboxSDT();
    }
    public void jtimport(JTable jt,ArrayList<DTOTaiKhoan> list) throws SQLException{
        
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Tên nhân viên");
        model.addColumn("Số điện thoại");
        model.addColumn("Email");
        model.addColumn("Tên đăng nhập");
        model.addColumn("Mật khẩu");
        model.addColumn("Ngày tạo");
        model.addColumn("isBlock");
        
        for(DTOTaiKhoan i: list){
            DTONhanVien nv = new DTONhanVien();
            nv.setMaNhanVien( i.getMaNhanVien());
            nv= DAOnv.getnv(nv);
            model.addRow(new Object[]{nv.getTenNhanVien(),nv.getSDT(),nv.getEmail(),i.getTenDangNhap(),i.getMatKhau(),i.getNgayTao(),i.getIsblock()});
        }
        jt.setModel(model);
    }
    public ArrayList<DTOTaiKhoan> jtexport(JTable jt) throws SQLException{
        ArrayList<DTOTaiKhoan> list = new ArrayList<>();
        int size = jt.getRowCount();
        for(int i = 0; i < size; i++){
            DTOTaiKhoan a = new DTOTaiKhoan();
            a.setTenDangNhap(jt.getValueAt(i, 3).toString());
            a = DAO.gettk(a);
            list.add(a);
        }
        return list;
    }
    public boolean checktendn(String tendn) throws SQLException{
        return DAO.checktendn(tendn);
    }
    public boolean checktendnedit(String tendn) throws SQLException{
        return DAO.checktendnedit(tendn);
    }
    public DTOTaiKhoan gettk(DTOTaiKhoan i){
        return DAO.gettk(i);
    }
    public void cbimport(JComboBox jcb,ArrayList<DTOTaiKhoan> list) throws SQLException{
        jcb.removeAllItems();
        jcb.addItem("Số điện thoại");
        for(DTOTaiKhoan i: list){
            DTONhanVien nv = new DTONhanVien();
            nv.setMaNhanVien( i.getMaNhanVien());
            nv= DAOnv.getnv(nv);
            jcb.addItem(nv.getSDT());
        }
    }
    public void cbimchtkport(JComboBox jcb,ArrayList<DTONhanVien> list) throws SQLException{
        jcb.removeAllItems();
        jcb.addItem("Số điện thoại");
        for(DTONhanVien i: list){
            jcb.addItem(i.getSDT());
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
    public ArrayList<DTOTaiKhoan> searchten(ArrayList<DTOTaiKhoan> list,String ten) throws SQLException{
        ArrayList<DTOTaiKhoan> result = new ArrayList<>();
        for(DTOTaiKhoan i: list){
            DTONhanVien a = new DTONhanVien();
            a.setMaNhanVien(i.getMaNhanVien());
            a = DAOnv.getnv(a);
            if(a.getTenNhanVien().contains(ten)){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTOTaiKhoan> searchsdt(ArrayList<DTOTaiKhoan> list,String sdt) throws SQLException{
        ArrayList<DTOTaiKhoan> result = new ArrayList<>();
        for(DTOTaiKhoan i: list){
            DTONhanVien a = new DTONhanVien();
            a.setMaNhanVien(i.getMaNhanVien());
            a = DAOnv.getnv(a);
            if(a.getSDT().contains(sdt)){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTOTaiKhoan> searchemail(ArrayList<DTOTaiKhoan> list,String email) throws SQLException{
        ArrayList<DTOTaiKhoan> result = new ArrayList<>();
        for(DTOTaiKhoan i: list){
            DTONhanVien a = new DTONhanVien();
            a.setMaNhanVien(i.getMaNhanVien());
            a = DAOnv.getnv(a);
            if(a.getEmail().contains(email)){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTOTaiKhoan> searchdate(ArrayList<DTOTaiKhoan> list,Date day1,Date day2){
        ArrayList<DTOTaiKhoan> result = new ArrayList<>();
        for(DTOTaiKhoan i: list){
            if(i.getNgayTao().after(day1) && i.getNgayTao().before(day2)){
                result.add(i);
            }
        }
        return result;
    }
}
