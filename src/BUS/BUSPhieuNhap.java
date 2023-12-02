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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Hieu PC
 */
public class BUSPhieuNhap {
    DAOPhieuNhap DAO = new DAOPhieuNhap();
    DAONhaCungCap DAOncc = new DAONhaCungCap();
    DAONhanVien DAOnv = new DAONhanVien();
    public ArrayList<DTOPhieuNhap> getlist() throws SQLException, ParseException{
        return DAO.getlist();
    }
    public int addphieunhap(DTOPhieuNhap i) throws SQLException{
        return DAO.addphieunhap(i);
    }
    public int updatephieunhap(DTOPhieuNhap i) throws SQLException{
        return DAO.updatephieunhap(i);
    }
    public DTOPhieuNhap getpn(int mapn) throws SQLException, ParseException{
        return DAO.getpn(mapn);
    }
    public void jtimport(JTable jt,ArrayList<DTOPhieuNhap> list) throws SQLException{
        
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã phiếu nhập");
        model.addColumn("Tên nhà cung cấp");
        model.addColumn("Nhân viên tạo phiếu nhập");
        model.addColumn("Ngày nhập");
        model.addColumn("Tổng tiền");
        model.addColumn("Ghi chú");
        
        for(DTOPhieuNhap i: list){
            DTONhaCungCap ncc = new DTONhaCungCap();
            ncc.setMaNhaCungCap(i.getMaNhaCungCap());
            ncc = DAOncc.getncc(ncc);
            DTONhanVien nv = new DTONhanVien();
            nv.setMaNhanVien(i.getMaNhanVien());
            nv = DAOnv.getnv(nv);
            model.addRow(new Object[]{i.getMaPhieuNhap(),ncc.getTenNhaCungCap(),nv.getTenNhanVien(),i.getNgayNhap(),i.getTongTien(),i.getGhiChu()});
        }
        jt.setModel(model);
    }
    public ArrayList<DTOPhieuNhap> jtexport(JTable jt) throws SQLException{
        ArrayList<DTOPhieuNhap> list = new ArrayList<>();
        int size = jt.getRowCount();
        for(int i = 0; i < size; i++){
            DTOPhieuNhap a = new DTOPhieuNhap();
            a.setMaPhieuNhap(Integer.parseInt(jt.getValueAt(i, 0).toString()));
            try {
                a = DAO.getpn(a.getMaPhieuNhap());
                list.add(a);
            } catch (ParseException ex) {
                Logger.getLogger(BUSPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    public void cbnccimport(JComboBox jcb,ArrayList<DTONhaCungCap> ncc){
        jcb.removeAllItems();
        jcb.addItem("Nhà cung cấp");
        for(DTONhaCungCap i: ncc){
            jcb.addItem(i.getTenNhaCungCap());
        }
    }
    
}
