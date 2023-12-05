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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author Hieu PC
 */
public class BUSHoaDon {

    DAOHoaDon DAO = new DAOHoaDon();
    DAOKhachHang DAOkh = new DAOKhachHang();
    DAONhanVien DAOnv = new DAONhanVien();

    public ArrayList<DTOHoaDon> getlist() throws SQLException, ParseException {
        return DAO.getlist();
    }

    public int addhoadon(DTOHoaDon i) throws SQLException {
        return DAO.addhoadon(i);
    }

    public int updateHoaDon(DTOHoaDon i) throws SQLException {
        return DAO.updatehoadon(i);
    }

    public DTOHoaDon gethd(int mahd) throws SQLException, ParseException {
        return DAO.gethd(mahd);
    }

    public void jtimport(JTable jt, ArrayList<DTOHoaDon> list) throws SQLException {

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã hóa đơn");
        model.addColumn("Tên khách hàng");
        model.addColumn("Nhân viên tạo hóa đơn");
        model.addColumn("Mã khuyến mãi");
        model.addColumn("Mã tích điểm");
        model.addColumn("Ngày mua");
        model.addColumn("Tổng tiền");
        model.addColumn("Ghi chú");

        for (DTOHoaDon i : list) {
            DTOKhachHang kh = new DTOKhachHang();
            kh.setMaKhachHang(i.getMaKhachHang());
            kh = DAOkh.getkh(kh);
            DTONhanVien nv = new DTONhanVien();
            nv.setMaNhanVien(i.getMaNhanVien());
            nv = DAOnv.getnv(nv);
            model.addRow(new Object[]{i.getMaHoaDon(), kh.getTenKhachHang(), nv.getTenNhanVien(), i.getMaKhuyenMai(), i.getMaTichDiem(), i.getNgayMua(), i.getTongTien(), i.getGhiChu()});
        }
        jt.setModel(model);
    }

    public ArrayList<DTOHoaDon> jtexport(JTable jt) throws SQLException {
        ArrayList<DTOHoaDon> list = new ArrayList<>();
        int size = jt.getRowCount();
        for (int i = 0; i < size; i++) {
            DTOHoaDon a = new DTOHoaDon();
            a.setMaHoaDon(Integer.parseInt(jt.getValueAt(i, 0).toString()));
            try {
                a = DAO.gethd(a.getMaHoaDon());
                list.add(a);
            } catch (ParseException ex) {
                Logger.getLogger(BUSPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public void cbkhimport(JComboBox jcb, ArrayList<DTOKhachHang> kh) {
        jcb.removeAllItems();
        jcb.addItem("Tên khách hàng");
        for (DTOKhachHang i : kh) {
            jcb.addItem(i.getTenKhachHang());
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

    public ArrayList<DTOHoaDon> searchghichu(ArrayList<DTOHoaDon> list, String ghichu) {
        ArrayList<DTOHoaDon> result = new ArrayList<>();
        for (DTOHoaDon i : list) {
            if (i.getGhiChu() != null && i.getGhiChu().contains(ghichu)) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<DTOHoaDon> searchtenkh(ArrayList<DTOHoaDon> list, String tenkh) throws SQLException {
        ArrayList<DTOHoaDon> result = new ArrayList<>();
        for (DTOHoaDon i : list) {
            DTOKhachHang kh = new DTOKhachHang();
            kh.setMaKhachHang(i.getMaKhachHang());
            kh = DAOkh.getkh(kh);
            if (kh.getTenKhachHang().contains(tenkh)) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<DTOHoaDon> searchtennv(ArrayList<DTOHoaDon> list, String tennv) throws SQLException {
        ArrayList<DTOHoaDon> result = new ArrayList<>();
        for (DTOHoaDon i : list) {
            DTONhanVien nv = new DTONhanVien();
            nv.setMaNhanVien(i.getMaNhanVien());
            nv = DAOnv.getnv(nv);
            if (nv.getTenNhanVien().equals(tennv)) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<DTOHoaDon> searchdate(ArrayList<DTOHoaDon> list, Date day1, Date day2) {
        ArrayList<DTOHoaDon> result = new ArrayList<>();
        for (DTOHoaDon i : list) {
            if (i.getNgayMua().after(day1) && i.getNgayMua().before(day2)) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<DTOHoaDon> searchmoney(ArrayList<DTOHoaDon> list, double var1, double var2) {
        ArrayList<DTOHoaDon> result = new ArrayList<>();
        for (DTOHoaDon i : list) {
            if (i.getTongTien() >= var1 && i.getTongTien() <= var2) {
                result.add(i);
            }
        }
        return result;
    }

    public void exportDSHoaDon() {
        DAO.exportDSHoaDon();
    }
}
