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
    public void jtimport(JTable jt,ArrayList<DTOTaiKhoan> list) throws SQLException{
        
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Tên nhân viên");
        model.addColumn("Tên đăng nhập");
        model.addColumn("Mật khẩu");
        model.addColumn("Ngày tạo");
        model.addColumn("isBlock");
        
        for(DTOTaiKhoan i: list){
            DTONhanVien nv = new DTONhanVien();
            nv.setMaNhanVien( i.getMaNhanVien());
            String tennv = DAOnv.getnv(nv).getTenNhanVien();
            model.addRow(new Object[]{tennv,i.getTenDangNhap(),i.getMatKhau(),i.getNgayTao(),i.getIsblock()});
        }
        jt.setModel(model);
    }
    public ArrayList<DTOTaiKhoan> jtexport(JTable jt) throws SQLException{
        ArrayList<DTOTaiKhoan> list = new ArrayList<>();
        int size = jt.getRowCount();
        for(int i = 0; i < size; i++){
            DTOTaiKhoan a = new DTOTaiKhoan();
            a.setTenDangNhap(jt.getValueAt(i, 0).toString());
            a = gettk(a);
            list.add(a);
        }
        return list;
    }
}
