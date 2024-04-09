/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import DTO.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Comparator;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Hieu PC
 */
public class DAOHoaDon {

    public DTOHoaDon gethd(int mahd) throws SQLException, ParseException {
        Connection con = Connect.connection();
        String sql = "SELECT * FROM hoadon WHERE isDelete = 0 AND maHoaDon = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, mahd);
        ResultSet rs = pst.executeQuery();
        DTOHoaDon hd = new DTOHoaDon();
        while (rs.next()) {
            hd.setMaHoaDon(rs.getInt("maHoaDon"));
            hd.setMaKhachHang(rs.getInt("maKhachHang"));
            hd.setMaNhanVien(rs.getInt("maNhanVien"));
            hd.setMaKhuyenMai(rs.getInt("maKhuyenMai"));
            hd.setMaTichDiem(rs.getInt("maTichDiem"));
            hd.setNgayMua(rs.getTimestamp("ngayMua"));
            hd.setTongTien(rs.getDouble("tongTien"));
            hd.setGhiChu(rs.getString("ghiChu"));
            hd.setIsHidden(rs.getInt("isDelete"));
        }
        con.close();
        return hd;
    }

    public ArrayList<DTOHoaDon> getlist() throws SQLException, ParseException {
        Connection con = Connect.connection();
        String sql = "SELECT * FROM hoadon WHERE isDelete = 0";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTOHoaDon> list = new ArrayList<>();
        while (rs.next()) {
            DTOHoaDon hd = new DTOHoaDon();
            hd.setMaHoaDon(rs.getInt("maHoaDon"));
            hd.setMaKhachHang(rs.getInt("maKhachHang"));
            hd.setMaNhanVien(rs.getInt("maNhanVien"));
            hd.setMaKhuyenMai(rs.getInt("maKhuyenMai"));
            hd.setMaTichDiem(rs.getInt("maTichDiem"));
            hd.setNgayMua(rs.getTimestamp("ngayMua"));
            hd.setTongTien(rs.getDouble("tongTien"));
            hd.setGhiChu(rs.getString("ghiChu"));
            hd.setIsHidden(rs.getInt("isDelete"));
            list.add(hd);
        }
        con.close();
        Collections.sort(list, new Comparator<DTOHoaDon>() {
            @Override
            public int compare(DTOHoaDon person1, DTOHoaDon person2) {
                return person2.getNgayMua().compareTo(person1.getNgayMua());
            }
        });
        return list;
    }

    public int addhoadon(DTOHoaDon hd) throws SQLException {
        Connection con = Connect.connection();
        String sql = "INSERT INTO hoadon(maKhachHang,maNhanVien,maTichDiem,maKhuyenMai,ngayMua,tongTien,ghiChu,isDelete) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, hd.getMaKhachHang());
        pst.setInt(2, hd.getMaNhanVien());
        pst.setInt(3, hd.getMaTichDiem());
        pst.setInt(4, hd.getMaKhuyenMai());
        pst.setTimestamp(5, new java.sql.Timestamp(hd.getNgayMua().getTime()));
        pst.setDouble(6, hd.getTongTien());
        pst.setString(7, hd.getGhiChu());
        pst.setInt(8, hd.getIsHidden());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int addhdnokhkm(DTOHoaDon hd) throws SQLException {
        Connection con = Connect.connection();
        String sql = "INSERT INTO hoadon(maNhanVien,ngayMua,tongTien,ghiChu,isDelete) VALUES(?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, hd.getMaNhanVien());
        pst.setTimestamp(2, new java.sql.Timestamp(hd.getNgayMua().getTime()));
        pst.setDouble(3, hd.getTongTien());
        pst.setString(4, hd.getGhiChu());
        pst.setInt(5, hd.getIsHidden());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int addhdnokh(DTOHoaDon hd) throws SQLException {
        Connection con = Connect.connection();
        String sql = "INSERT INTO hoadon(maNhanVien,maKhuyenMai,ngayMua,tongTien,ghiChu,isDelete) VALUES(?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, hd.getMaNhanVien());
        pst.setInt(2, hd.getMaKhuyenMai());
        pst.setTimestamp(3, new java.sql.Timestamp(hd.getNgayMua().getTime()));
        pst.setDouble(4, hd.getTongTien());
        pst.setString(5, hd.getGhiChu());
        pst.setInt(6, hd.getIsHidden());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int addhdnokm(DTOHoaDon hd) throws SQLException {
        Connection con = Connect.connection();
        String sql = "INSERT INTO hoadon(maKhachHang,maNhanVien,maTichDiem,ngayMua,tongTien,ghiChu,isDelete) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, hd.getMaKhachHang());
        pst.setInt(2, hd.getMaNhanVien());
        pst.setInt(3, hd.getMaTichDiem());
        pst.setTimestamp(4, new java.sql.Timestamp(hd.getNgayMua().getTime()));
        pst.setDouble(5, hd.getTongTien());
        pst.setString(6, hd.getGhiChu());
        pst.setInt(7, hd.getIsHidden());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }

}
