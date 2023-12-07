/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOCTHoaDon {

    private Connect conn;

    public DAOCTHoaDon() {

    }

    public DTOCTHoaDon getcthd(int maCTHoaDon) throws SQLException {
        Connection con = Connect.connection();
        String sql = "SELECT * FROM chitietHoaDon WHERE maCTHoaDon = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, maCTHoaDon);
        ResultSet rs = pst.executeQuery();
        DTOCTHoaDon cthd = new DTOCTHoaDon();
        while (rs.next()) {
            cthd.setMaCTHoaDon(rs.getInt("maCTHoaDon"));
            cthd.setMaSanPham(rs.getInt("maSanPham"));
            cthd.setMaHoaDon(rs.getInt("maHoaDon"));
            cthd.setDonGia(rs.getFloat("donGia"));
            cthd.setSoLuong(rs.getInt("soLuong"));
        }
        con.close();
        return cthd;
    }

    public ArrayList<DTOCTHoaDon> getlist(int maHoaDon) throws SQLException {
        Connection con = Connect.connection();
        String sql = "SELECT * FROM chitietHoaDon WHERE maHoaDon= " + maHoaDon;
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTOCTHoaDon> list = new ArrayList<>();
        while (rs.next()) {
            DTOCTHoaDon cthd = new DTOCTHoaDon();
            cthd.setMaCTHoaDon(rs.getInt("maCTHoaDon"));
            cthd.setMaSanPham(rs.getInt("maSanPham"));
            cthd.setMaHoaDon(rs.getInt("maHoaDon"));
            cthd.setDonGia(rs.getFloat("donGia"));
            cthd.setSoLuong(rs.getInt("soLuong"));
            list.add(cthd);
        }
        con.close();
        return list;
    }

    public boolean checksp(int masp, int macthd, int mahd) throws SQLException {
        Connection con = Connect.connection();
        int i = 0;
        boolean key = false;
        String sql = "SELECT * FROM chitiethoadon where maHoaDon = ? and maCTHoaDon != ? and maSanPham = ? ";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, mahd);
        pst.setInt(2, macthd);
        pst.setInt(3, masp);
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


    public int addctHoaDon(DTOCTHoaDon cthd) throws SQLException {
        Connection con = Connect.connection();
        String sql = "INSERT INTO chitiethoadon(maHoaDon,maSanPham,soLuong,donGia) VALUES(?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, cthd.getMaHoaDon());
        pst.setInt(2, cthd.getMaSanPham());
        pst.setInt(3, cthd.getSoLuong());
        pst.setDouble(4, cthd.getDonGia());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
}
