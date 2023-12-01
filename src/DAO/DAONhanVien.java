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
import java.sql.Date;

/**
 *
 * @author Hieu PC
 */
public class DAONhanVien {
    public DTONhanVien getnv(DTONhanVien i) throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM nhanvien where isDelete= 0";
        PreparedStatement pst =  con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        DTONhanVien nv = new DTONhanVien();
        while(rs.next()){
            nv.setMaNhanVien(rs.getInt("maNhanVien"));
            nv.setTenNhanVien(rs.getString("tenNhanVien"));
            nv.setNgaySinh(rs.getDate("ngaySinh"));
            nv.setEmail(rs.getString("Email"));
            nv.setSDT(rs.getString("soDienThoai"));
            nv.setDiaChi(rs.getString("diaChi"));
            nv.setGioiTinh(rs.getInt("gioiTinh"));
            nv.setMaChucVu(rs.getInt("maChucVu"));
            nv.setIsdelete(rs.getInt("isDelete"));
            nv.setImg(rs.getString("img"));
        }
        con.close();
        return nv;
    }
    public ArrayList<DTONhanVien> getlist() throws SQLException, ParseException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM nhanvien where isDelete= 0";
        PreparedStatement pst =  con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTONhanVien> list = new ArrayList<>();
        while(rs.next()){
            DTONhanVien nv = new DTONhanVien();
            nv.setMaNhanVien(rs.getInt("maNhanVien"));
            nv.setTenNhanVien(rs.getString("tenNhanVien"));
            nv.setNgaySinh(rs.getDate("ngaySinh"));
            nv.setEmail(rs.getString("Email"));
            nv.setSDT(rs.getString("soDienThoai"));
            nv.setDiaChi(rs.getString("diaChi"));
            nv.setGioiTinh(rs.getInt("gioiTinh"));
            nv.setMaChucVu(rs.getInt("maChucVu"));
            nv.setIsdelete(rs.getInt("isDelete"));
            nv.setImg(rs.getString("img"));
            list.add(nv);
        }
        con.close();
        return list;
    }
    public int getrowcount() throws SQLException, ParseException{
        return getlist().size();
    }
    public int addnhanvien(DTONhanVien nv) throws SQLException{
        Connection con = Connect.connection();
        String sql = "INSERT INTO nhanvien(tenNhanVien,ngaySinh,Email,soDienThoai,diaChi,gioiTinh,maChucVu,isBlock,isDelete,img) VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, nv.getTenNhanVien());
        pst.setDate(2, (Date)nv.getNgaySinh());
        pst.setString(3, nv.getEmail());
        pst.setString(4, nv.getSDT());
        pst.setString(5,nv.getDiaChi());
        pst.setInt(6,nv.getGioiTinh());
        pst.setInt(7, nv.getMaChucVu());
        pst.setInt(8, nv.getIsdelete());
        pst.setString(9,nv.getImg());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int updatenhanvien(DTONhanVien nv) throws SQLException{
        Connection con = Connect.connection();
        String sql = "UPDATE nhanvien set tenNhanVien = ?,ngaySinh = ?,Email = ?,soDienThoai=?,diaChi=?,gioiTinh=?,maChucVu=?,isBlock=?,isDelete=?,img=? WHERE maNhanVien= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, nv.getTenNhanVien());
        pst.setDate(2, (Date)nv.getNgaySinh());
        pst.setString(3, nv.getEmail());
        pst.setString(4, nv.getSDT());
        pst.setString(5,nv.getDiaChi());
        pst.setInt(6,nv.getGioiTinh());
        pst.setInt(7, nv.getMaChucVu());
        pst.setInt(8, nv.getIsdelete());
        pst.setString(9,nv.getImg());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
}
