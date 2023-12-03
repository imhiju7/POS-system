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
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Hieu PC
 */
public class DAOSanPham {
    public DTOSanPham getsp(DTOSanPham i) throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM sanpham WHERE maSanPham = ? ";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setInt(1, i.getMaSanPham());
        ResultSet rs = pst.executeQuery();
        DTOSanPham sp = new DTOSanPham();
        while(rs.next()){
            sp.setMaSanPham(rs.getInt("maSanPham"));
            sp.setTenSanPham(rs.getString("tenSanPham"));
            sp.setSoLuong(rs.getInt("soLuong"));
            sp.setGiaBan(rs.getDouble("giaBan"));
            sp.setNgayThem(rs.getTimestamp("ngayThem"));
            sp.setIshidden(rs.getInt("isHidden"));
            sp.setIsdelete(rs.getInt("isDelete"));
            sp.setImg(rs.getString("img"));
        }
        con.close();
        return sp;
    }
    public DTOSanPham getspbyname(DTOSanPham i ) throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM sanpham WHERE tenSanPham = ? ";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setString(1, i.getTenSanPham());
        ResultSet rs = pst.executeQuery();
        DTOSanPham sp = new DTOSanPham();
        while(rs.next()){
            sp.setMaSanPham(rs.getInt("maSanPham"));
            sp.setTenSanPham(rs.getString("tenSanPham"));
            sp.setSoLuong(rs.getInt("soLuong"));
            sp.setGiaBan(rs.getDouble("giaBan"));
            sp.setNgayThem(rs.getTimestamp("ngayThem"));
            sp.setIshidden(rs.getInt("isHidden"));
            sp.setIsdelete(rs.getInt("isDelete"));
            sp.setImg(rs.getString("img"));
        }
        con.close();
        return sp;
    }
    public ArrayList<DTOSanPham> getlist() throws SQLException, ParseException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM sanpham";
        PreparedStatement pst =  con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTOSanPham> list = new ArrayList<>();
        while(rs.next()){
            DTOSanPham sp = new DTOSanPham();
            sp.setMaSanPham(rs.getInt("maSanPham"));
            sp.setTenSanPham(rs.getString("tenSanPham"));
            sp.setSoLuong(rs.getInt("soLuong"));
            sp.setGiaBan(rs.getDouble("giaBan"));
            sp.setNgayThem(rs.getTimestamp("ngayThem"));
            sp.setIshidden(rs.getInt("isHidden"));
            sp.setIsdelete(rs.getInt("isDelete"));
            sp.setImg(rs.getString("img"));
            list.add(sp);
        }
        con.close();
        return list;
    }
    public int getrowcount() throws SQLException, ParseException{
        return getlist().size();
    }
    public int addsanpham(DTOSanPham sp) throws SQLException{
        Connection con = Connect.connection();
        String sql = "INSERT INTO SanPham(tenSanPham,soLuong,giaBan,ngayThem,isHidden,isDelete,img) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, sp.getTenSanPham());
        pst.setInt(2, sp.getSoLuong());
        pst.setDouble(3, sp.getGiaBan());
        pst.setTimestamp(4,new java.sql.Timestamp ( sp.getNgayThem().getTime()));
        pst.setInt(5, sp.getIshidden());
        pst.setInt(6, sp.getIsdelete());
        pst.setString(7, sp.getImg());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int updatesanpham(DTOSanPham sp) throws SQLException{
        Connection con = Connect.connection();
        String sql = "UPDATE SanPham set tenSanPham = ?,soLuong = ?,giaBan=?,ngayThem=?,isHidden=?,isDelete=?,img=? WHERE maSanPham= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, sp.getTenSanPham());
        pst.setInt(2, sp.getSoLuong());
        pst.setDouble(3, sp.getGiaBan());
        pst.setTimestamp(4,new java.sql.Timestamp ( sp.getNgayThem().getTime()));
        pst.setInt(5, sp.getIshidden());
        pst.setInt(6, sp.getIsdelete());
        pst.setString(7, sp.getImg());
        pst.setInt(8, sp.getMaSanPham());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
}
