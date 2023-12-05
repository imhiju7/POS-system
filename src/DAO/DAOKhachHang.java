/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Hieu PC
 */
public class DAOKhachHang {

    public DAOKhachHang() {

    }

    public DTOKhachHang getkh(DTOKhachHang i) throws SQLException {
        Connection con = Connect.connection();
        String sql = "SELECT * FROM khachhang WHERE maKhachHang = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, i.getMaKhachHang());
        ResultSet rs = pst.executeQuery();
        DTOKhachHang kh = new DTOKhachHang();
        while (rs.next()) {
            kh.setMaKhachHang(rs.getInt("maKhachHang"));
            kh.setTenKhachHang(rs.getString("tenKhachHang"));
            kh.setSDT(rs.getString("SDT"));
            kh.setDiemTichLuy(rs.getInt("diemTichLuy"));
            kh.setMaUuDai(rs.getInt("maUuDai"));
        }
        con.close();
        return kh;
    }

    public ArrayList<DTOKhachHang> getlist() throws SQLException {
        Connection con = Connect.connection();
        String sql = "SELECT * FROM khachhang";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTOKhachHang> list = new ArrayList<>();
        while (rs.next()) {
            DTOKhachHang kh = new DTOKhachHang();
            kh.setMaKhachHang(rs.getInt("maKhachHang"));
            kh.setTenKhachHang(rs.getString("tenKhachHang"));
            kh.setSDT(rs.getString("SDT"));
            kh.setDiemTichLuy(rs.getInt("diemTichLuy"));
            kh.setMaUuDai(rs.getInt("maUuDai"));
            list.add(kh);
        }
        con.close();
        return list;
    }

    public int addkhachhang(DTOKhachHang kh) throws SQLException {
        Connection con = Connect.connection();
        String sql = "INSERT INTO khachhang(SDT,tenKhachHang,diemTichLuy,maUuDai) VALUES(?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, kh.getSDT());
        pst.setString(2, kh.getTenKhachHang());
        pst.setInt(3, kh.getDiemTichLuy());
        pst.setInt(4, kh.getMaUuDai());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }

    public int updatekhachhang(DTOKhachHang kh) throws SQLException {
        Connection con = Connect.connection();
        String sql = "UPDATE khachhang set SDT= ?, tenKhachHang= ?WHERE maKhachHang= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, kh.getDiemTichLuy());
        pst.setInt(2, kh.getMaUuDai());
        pst.setInt(3, kh.getMaKhachHang());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }

    public int updatediemtichluy(DTOKhachHang kh) throws SQLException {
        Connection con = Connect.connection();
        String sql = "UPDATE khachhang set diemTichLuy= ?, maUuDai = ? WHERE maKhachHang= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, kh.getDiemTichLuy());
        pst.setInt(2, kh.getMaUuDai());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }

    public boolean checkpphone(String phone) throws SQLException {
        Connection con = Connect.connection();
        int i = 0;
        boolean key = false;
        String sql = "SELECT * FROM nhanvien where SDT = ? ";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, phone);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            i++;
        }
        con.close();
        if (i > 0) {
            key = false;
        } else {
            key = true;
        }
        return key;
    }

    public boolean checkpphoneedit(String phone, int makh) throws SQLException {
        Connection con = Connect.connection();
        int i = 0;
        boolean key = false;
        String sql = "SELECT * FROM khachhang where maKhachHang != ? and SDT = ? ";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, makh);
        pst.setString(2, phone);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            i++;
        }
        con.close();
        if (i > 0) {
            key = false;
        } else {
            key = true;
        }
        return key;
    }
}
