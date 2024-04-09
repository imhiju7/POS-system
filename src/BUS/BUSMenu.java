/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DTO.*;
import DAO.*;
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
public class BUSMenu {
    DAOSanPham DAO = new DAOSanPham();
    public int updateslsp(DTOSanPham i) throws SQLException{
        return DAO.updatesoluong(i);
    }
    public void cbplimport(JComboBox jcb,ArrayList<DTOPhanLoai> list){
        jcb.removeAllItems();
        jcb.addItem("Phân loại");
        for(DTOPhanLoai i: list){
            jcb.addItem(i.getTenPhanLoai());
        }
    }
    public ArrayList<DTOSanPham> getlist() throws SQLException, ParseException{
        return DAO.getlistorder();
    }
    public ArrayList<DTOSanPham> getlistpl(int mapl) throws SQLException, ParseException{
        return DAO.getlistorderpl(mapl);
    }
    public void arr_jt (JTable jTable, ArrayList<DTOSanPham> spOrder) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Tên SP");
        model.addColumn("SL");
        model.addColumn("Giá");
        model.addColumn("Thành tiền");
        int i = 0;
        for (DTOSanPham sp : spOrder) {
            i++;
            model.addRow(new Object[]{i, sp.getTenSanPham(), sp.getSoLuong(), sp.getGiaBan(),sp.getSoLuong()*sp.getGiaBan()});
        }
        jTable.setModel(model);
    }
    public void cbnccimport(JComboBox jcb,ArrayList<DTOKhuyenMai> ncc){
        jcb.removeAllItems();
        jcb.addItem("Khuyến mãi");
        for(DTOKhuyenMai i: ncc){
            jcb.addItem(i.getTenKhuyenMai());
        }
    }
    public double gettongtien(ArrayList<DTOSanPham> spOrder){
        double tongtien = 0;
        for (DTOSanPham sp : spOrder) {
            tongtien+=sp.getGiaBan()*sp.getSoLuong();
        }
        return tongtien;
    }
}
