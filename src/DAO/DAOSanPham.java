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
            sp.setGiaNhap(rs.getDouble("giaNhap"));
            sp.setNgayThem(rs.getTimestamp("ngayThem"));
            sp.setMaPhanLoai(rs.getInt("maPhanLoai"));
            sp.setautoishidden();
            sp.setImg(rs.getString("img"));
        }
        con.close();
        return sp;
    }
    public ArrayList<DTOSanPham> spcannhap() throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM sanpham WHERE soLuong < 15";
        PreparedStatement pst =  con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTOSanPham> list = new ArrayList<>();
        while(rs.next()){
            DTOSanPham sp = new DTOSanPham();
            sp.setMaSanPham(rs.getInt("maSanPham"));
            sp.setTenSanPham(rs.getString("tenSanPham"));
            sp.setSoLuong(rs.getInt("soLuong"));
            sp.setGiaBan(rs.getDouble("giaBan"));
            sp.setGiaNhap(rs.getDouble("giaNhap"));
            sp.setNgayThem(rs.getTimestamp("ngayThem"));
            sp.setMaPhanLoai(rs.getInt("maPhanLoai"));
            sp.setImg(rs.getString("img"));
            list.add(sp);
        }
        con.close();
        return list;
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
            sp.setGiaNhap(rs.getDouble("giaNhap"));
            sp.setNgayThem(rs.getTimestamp("ngayThem"));
            sp.setMaPhanLoai(rs.getInt("maPhanLoai"));
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
            sp.setGiaNhap(rs.getDouble("giaNhap"));
            sp.setNgayThem(rs.getTimestamp("ngayThem"));
            sp.setMaPhanLoai(rs.getInt("maPhanLoai"));
            sp.setImg(rs.getString("img"));
            list.add(sp);
        }
        con.close();
        return list;
    }
    public ArrayList<DTOSanPham> getlistorder() throws SQLException, ParseException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM sanpham WHERE isHidden = 0 and soLuong > 5 and giaBan > 0";
        PreparedStatement pst =  con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTOSanPham> list = new ArrayList<>();
        while(rs.next()){
            DTOSanPham sp = new DTOSanPham();
            sp.setMaSanPham(rs.getInt("maSanPham"));
            sp.setTenSanPham(rs.getString("tenSanPham"));
            sp.setSoLuong(0);
            sp.setGiaBan(rs.getDouble("giaBan"));
            sp.setMaPhanLoai(rs.getInt("maPhanLoai"));
            sp.setImg(rs.getString("img"));
            list.add(sp);
        }
        con.close();
        return list;
    }
    public ArrayList<DTOSanPham> getlistorderpl(int mapl) throws SQLException, ParseException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM sanpham WHERE isHidden = 0 and soLuong > 5 and giaBan > 0 and maPhanLoai=?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setInt(1,mapl);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTOSanPham> list = new ArrayList<>();
        while(rs.next()){
            DTOSanPham sp = new DTOSanPham();
            sp.setMaSanPham(rs.getInt("maSanPham"));
            sp.setTenSanPham(rs.getString("tenSanPham"));
            sp.setSoLuong(0);
            sp.setGiaBan(rs.getDouble("giaBan"));
            sp.setGiaNhap(rs.getDouble("giaNhap"));
            sp.setMaPhanLoai(rs.getInt("maPhanLoai"));
            sp.setImg(rs.getString("img"));
            list.add(sp);
        }
        con.close();
        return list;
    }
    public int addsanpham(DTOSanPham sp) throws SQLException{
        Connection con = Connect.connection();
        String sql = "INSERT INTO SanPham(tenSanPham,soLuong,giaBan,giaNhap,ngayThem,isHidden,maPhanLoai,img) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, sp.getTenSanPham());
        pst.setInt(2, sp.getSoLuong());
        pst.setDouble(3, sp.getGiaBan());
        pst.setDouble(4, sp.getGiaNhap());
        pst.setTimestamp(5,new java.sql.Timestamp ( sp.getNgayThem().getTime()));
        pst.setInt(6, sp.getIshidden());
        pst.setInt(7, sp.getMaPhanLoai());
        pst.setString(8, sp.getImg());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int updatesanpham(DTOSanPham sp) throws SQLException{
        Connection con = Connect.connection();
        String sql = "UPDATE SanPham set tenSanPham = ?,giaBan=?,maPhanLoai=?,img=? WHERE maSanPham= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, sp.getTenSanPham());
        pst.setDouble(2, sp.getGiaBan());
        pst.setInt(3, sp.getMaPhanLoai());
        pst.setString(4, sp.getImg());
        pst.setInt(5, sp.getMaSanPham());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int updatesoluong(DTOSanPham sp) throws SQLException{
        Connection con = Connect.connection();
        String sql = "UPDATE SanPham set soLuong = ?,isHidden = ? WHERE maSanPham= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, sp.getSoLuong());
        pst.setInt(2, sp.getIshidden());
        pst.setInt(3, sp.getMaSanPham());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
        
    }
    public int updategianhap(DTOSanPham sp) throws SQLException{
        Connection con = Connect.connection();
        String sql = "UPDATE SanPham set giaNhap = ? WHERE maSanPham= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setDouble(1, sp.getGiaNhap());
        pst.setInt(2, sp.getMaSanPham());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public boolean checktensp(String name) throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM sanpham WHERE tenSanPham = ? ";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setString(1, name);
        ResultSet rs = pst.executeQuery();
        int count=0;
        while(rs.next()){
            count++;
        }
        con.close();
        if(count > 0) return false;
        return true;
    }
    public boolean checktenspedit(String name,int masp) throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM sanpham WHERE maSanPham != ? and tenSanPham = ? ";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setInt(1, masp);
        pst.setString(2, name);
        ResultSet rs = pst.executeQuery();
        int count=0;
        while(rs.next()){
            count++;
        }
        con.close();
        if(count > 0) return false;
        return true;
    }
}
