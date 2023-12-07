/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.*;
import DTO.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hieu PC
 */
public class BUSCTHoaDon {

    DAOCTHoaDon DAO = new DAOCTHoaDon();
    DAOSanPham DAOsp = new DAOSanPham();

    public ArrayList<DTOCTHoaDon> getlist(int code) throws SQLException {
        return DAO.getlist(code);
    }

    public boolean checksp(int masp, int macthd, int mahd) throws SQLException {
        return DAO.checksp(masp, macthd, mahd);
    }

    public void jtimport(JTable jt, ArrayList<DTOCTHoaDon> list) throws SQLException {

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã CT Hóa đơn");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Đơn giá");
        model.addColumn("Số lượng");

        for (DTOCTHoaDon i : list) {
            DTOSanPham sp = new DTOSanPham();
            sp.setMaSanPham(i.getMaSanPham());
            sp = DAOsp.getsp(sp);
            model.addRow(new Object[]{i.getMaCTHoaDon(), sp.getTenSanPham(), i.getDonGia(), i.getSoLuong()});
        }
        jt.setModel(model);
    }

    public void cbimport(JComboBox jcb, ArrayList<DTOSanPham> cv) {
        jcb.removeAllItems();
        jcb.addItem("Sản phẩm");
        for (DTOSanPham i : cv) {
            jcb.addItem(i.getTenSanPham());
        }
    }

    public ArrayList<DTOCTHoaDon> jtexport(JTable jt) throws SQLException {
        ArrayList<DTOCTHoaDon> list = new ArrayList<>();
        int size = jt.getRowCount();
        for (int i = 0; i < size; i++) {
            DTOCTHoaDon a = new DTOCTHoaDon();
            a.setMaCTHoaDon(Integer.parseInt(jt.getValueAt(i, 0).toString()));
            a = DAO.getcthd(a.getMaCTHoaDon());
            list.add(a);
        }
        return list;
    }

    public DTOCTHoaDon getcthd(DTOCTHoaDon i) throws SQLException {
        return DAO.getcthd(i.getMaCTHoaDon());
    }

    public int addcthoadon(DTOCTHoaDon i) throws SQLException {
        return DAO.addctHoaDon(i);
    }

    public ArrayList<DTOCTHoaDon> searchmoney(ArrayList<DTOCTHoaDon> list, double var1, double var2) {
        ArrayList<DTOCTHoaDon> result = new ArrayList<>();
        for (DTOCTHoaDon i : list) {
            if (i.getDonGia() >= var1 && i.getDonGia() <= var2) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<DTOCTHoaDon> searchsl(ArrayList<DTOCTHoaDon> list, int var1, int var2) {
        ArrayList<DTOCTHoaDon> result = new ArrayList<>();
        for (DTOCTHoaDon i : list) {
            if (i.getSoLuong() >= var1 && i.getSoLuong() <= var2) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<DTOCTHoaDon> searchtensp(ArrayList<DTOCTHoaDon> list, String tenncc) throws SQLException {
        ArrayList<DTOCTHoaDon> result = new ArrayList<>();
        for (DTOCTHoaDon i : list) {
            DTOSanPham sp = new DTOSanPham();
            sp.setMaSanPham(i.getMaSanPham());
            sp = DAOsp.getsp(sp);
            if (sp.getTenSanPham().contains(tenncc)) {
                result.add(i);
            }
        }
        return result;
    }
}
