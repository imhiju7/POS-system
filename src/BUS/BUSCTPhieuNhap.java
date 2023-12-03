/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.*;
import DTO.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hieu PC
 */
public class BUSCTPhieuNhap {
    DAOCTPhieuNhap DAO = new DAOCTPhieuNhap();
    public ArrayList<DTOCTPhieuNhap> getlist(int code) throws SQLException{
        return DAO.getlist(code);
    }
    public int addctphieunhap(DTOCTPhieuNhap i) throws SQLException{
        return DAO.addctphieunhap(i);
    }
    public int updateCTPhieuNhap(DTOCTPhieuNhap i) throws SQLException{
        return DAO.updatectphieunhap(i);
    }
    public void jtimport(JTable jt,ArrayList<DTONhanVien> list) throws SQLException{
        
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã CT Phiếu nhập");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Ngày Sinh");
        model.addColumn("Giới Tính");
        model.addColumn("Tên Chức Vụ");
        model.addColumn("Số Điện Thoại");
        model.addColumn("Email");
        model.addColumn("Địa Chỉ");
        
        for(DTONhanVien i: list){
            DTOChucVu cv = new DTOChucVu();
            cv.setMaChucVu(i.getMaChucVu());
            model.addRow(new Object[]{i.getMaNhanVien(),i.getTenNhanVien(),i.getNgaySinh(),i.getStringGioiTinh(),DAOcv.getcv(cv).getTenChucVu(),i.getSDT(),i.getEmail(),i.getDiaChi()});
        }
        jt.setModel(model);
    }
}
