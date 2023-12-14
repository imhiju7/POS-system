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

/**
 *
 * @author Hieu PC
 */
public class DAOKhuyenMai {
<<<<<<< Updated upstream
    public ArrayList<DTOKhuyenMai> getlist() throws SQLException, ParseException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM khuyenmai";
=======
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
>>>>>>> Stashed changes
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
            km.setIsdelete(rs.getInt("isdelete"));
            list.add(km);
        }
        con.close();
        return list;
    }
    public int getrowcount() throws SQLException, ParseException{
        return getlist().size();
    }
    public int addKhuyenMai(DTOKhuyenMai km) throws SQLException{
        Connection con = Connect.connection();
        String sql = "INSERT INTO khuyenmai(tenKhuyenMai,ngayBatDau,ngayHetHan,phanTram,soLuong,ishidden,isdelete) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, km.getTenKhuyenMai());
        pst.setDate(2, (Date) km.getNgayBatDau());
        pst.setDate(3, (Date) km.getNgayHetHan());
        pst.setInt(4, km.getPhanTram());
        pst.setInt(5, km.getSoLuong());
        pst.setInt(6, km.getIshidden());
        pst.setInt(7, km.getIsdelete());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int updateKhuyenMai(DTOKhuyenMai km) throws SQLException{
        Connection con = Connect.connection();
        String sql = "UPDATE khuyenmai set tenKhuyenMai = ?,ngayBatDau = ?,ngayHetHan = ?,phanTram = ?,soLuong WHERE maKhuyenMai= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, km.getTenKhuyenMai());
        pst.setDate(2, (Date) km.getNgayBatDau());
        pst.setDate(3, (Date) km.getNgayHetHan());
        pst.setInt(4, km.getPhanTram());
        pst.setInt(5, km.getSoLuong());
        pst.setInt(6, km.getIshidden());
        pst.setInt(7, km.getIsdelete());
        pst.setInt(8, km.getMaKhuyenMai());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
}
