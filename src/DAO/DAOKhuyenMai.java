/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Hieu PC
 */
public class DAOKhuyenMai {
    public DTOKhuyenMai getkm(DTOKhuyenMai i) throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM khuyenmai WHERE maKhuyenMai = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setInt(1, i.getMaKhuyenMai());
        ResultSet rs = pst.executeQuery();
        DTOKhuyenMai km = new DTOKhuyenMai();
        while(rs.next()){
            km.setMaKhuyenMai(rs.getInt("maKhuyenMai"));
            km.setTenKhuyenMai(rs.getString("tenKhuyenMai"));
            km.setNgayBatDau(rs.getDate("ngayBatDau"));
            km.setNgayHetHan(rs.getDate("ngayHetHan"));
            km.setPhanTram(rs.getInt("phanTram"));
            km.setSoLuong(rs.getInt("soLuong"));
            km.setSoLuongDaDung(rs.getInt("soLuongDaDung"));
            km.setIshidden(rs.getInt("ishidden"));
        }
        con.close();
        return km;
    }
    public DTOKhuyenMai getkmbyname(DTOKhuyenMai i) throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM khuyenmai WHERE tenKhuyenMai = ? and ngayHetHan > NOW()";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setString(1, i.getTenKhuyenMai());
        ResultSet rs = pst.executeQuery();
        DTOKhuyenMai km = new DTOKhuyenMai();
        while(rs.next()){
            km.setMaKhuyenMai(rs.getInt("maKhuyenMai"));
            km.setTenKhuyenMai(rs.getString("tenKhuyenMai"));
            km.setNgayBatDau(rs.getDate("ngayBatDau"));
            km.setNgayHetHan(rs.getDate("ngayHetHan"));
            km.setPhanTram(rs.getInt("phanTram"));
            km.setSoLuong(rs.getInt("soLuong"));
            km.setSoLuongDaDung(rs.getInt("soLuongDaDung"));
            km.setIshidden(rs.getInt("ishidden"));
        }
        con.close();
        return km;
    }
    public ArrayList<DTOKhuyenMai> getlist() throws SQLException, ParseException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM khuyenmai WHERE ishidden = 0 and soLuong > soLuongDaDung";
        PreparedStatement pst =  con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTOKhuyenMai> list = new ArrayList<>();
        while(rs.next()){
            DTOKhuyenMai km = new DTOKhuyenMai();
            km.setMaKhuyenMai(rs.getInt("maKhuyenMai"));
            km.setTenKhuyenMai(rs.getString("tenKhuyenMai"));
            km.setNgayBatDau(rs.getDate("ngayBatDau"));
            km.setNgayHetHan(rs.getDate("ngayHetHan"));
            km.setPhanTram(rs.getInt("phanTram"));
            km.setSoLuong(rs.getInt("soLuong"));
            km.setSoLuongDaDung(rs.getInt("soLuongDaDung"));
            km.setIshidden(rs.getInt("ishidden"));
            list.add(km);
        }
        con.close();
        Collections.sort(list, new Comparator<DTOKhuyenMai>() {
            @Override
            public int compare(DTOKhuyenMai person1, DTOKhuyenMai person2) {
                return person2.getNgayBatDau().compareTo(person1.getNgayBatDau());
            }
        });
        return list;
    }
    public int addKhuyenMai(DTOKhuyenMai km) throws SQLException{
        Connection con = Connect.connection();
        String sql = "INSERT INTO khuyenmai(tenKhuyenMai,ngayBatDau,ngayHetHan,phanTram,soLuong,ishidden,soLuongDaDung) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, km.getTenKhuyenMai());
        pst.setDate(2, new java.sql.Date(km.getNgayBatDau().getTime()));
        pst.setDate(3, new java.sql.Date(km.getNgayHetHan().getTime()));
        pst.setInt(4, km.getPhanTram());
        pst.setInt(5, km.getSoLuong());
        pst.setInt(6, km.getIshidden());
        pst.setInt(7, km.getSoLuongDaDung());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int updateKhuyenMai(DTOKhuyenMai km) throws SQLException{
        Connection con = Connect.connection();
        String sql = "UPDATE khuyenmai set tenKhuyenMai = ?,ngayBatDau = ?,ngayHetHan = ?,phanTram = ?,soLuong=?,ishidden = ?,soLuongDaDung = ? WHERE maKhuyenMai= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, km.getTenKhuyenMai());
        pst.setDate(2, new java.sql.Date(km.getNgayBatDau().getTime()));
        pst.setDate(3,  new java.sql.Date(km.getNgayHetHan().getTime()));
        pst.setInt(4, km.getPhanTram());
        pst.setInt(5, km.getSoLuong());
        pst.setInt(6, km.getIshidden());
        pst.setInt(7, km.getSoLuongDaDung());
        pst.setInt(8, km.getMaKhuyenMai());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int deletekhuyenmai(DTOKhuyenMai km) throws SQLException{
        Connection con = Connect.connection();
        String sql = "DELETE FROM khuyenmai WHERE maKhuyenMai = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, km.getMaKhuyenMai());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public boolean checkdel(DTOKhuyenMai km) throws SQLException{
         Connection con = Connect.connection();
        String sql = "SELECT * FROM hoadon WHERE maKhuyenMai = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setInt(1, km.getMaKhuyenMai());
        ResultSet rs = pst.executeQuery();
        int count = 0;
        while(rs.next()){
            count++;
        }
        con.close();
        if(count > 0 ) return false;
        else return true;
    }
}
