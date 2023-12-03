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
            a.setTenDangNhap(jt.getValueAt(i, 0).toString());
            a = DAO.gettk(a);
            list.add(a);
        }
        return list;
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
}
