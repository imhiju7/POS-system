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
public class DAOPhieuNhap {
    public DAOPhieuNhap(){
        
    }
    
    // +ID function
    
    // delete
    
    public DTOPhieuNhap getpn(int mapn) throws SQLException, ParseException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM phieunhap WHERE isDelete = 0 AND maPhieuNhap = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setInt(1, mapn);
        ResultSet rs = pst.executeQuery();
        DTOPhieuNhap pn = new DTOPhieuNhap();
        while(rs.next()){
            pn.setMaPhieuNhap(rs.getInt("maPhieuNhap"));
            pn.setMaNhaCungCap(rs.getInt("maNhaCungCap"));
            pn.setNgayNhap(rs.getTimestamp("ngayNhap"));
            pn.setTongTien(rs.getDouble("tongTien"));
            pn.setMaNhanVien(rs.getInt("maNhanVien"));
            pn.setIsHidden(rs.getInt("isDelete"));
            pn.setGhiChu(rs.getString("ghiChu"));
        }
        con.close();
        return pn;
    }
    
    public ArrayList<DTOPhieuNhap> getlist() throws SQLException, ParseException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM phieunhap WHERE isDelete = 0";
        PreparedStatement pst =  con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTOPhieuNhap> list = new ArrayList<>();
        while(rs.next()){
            DTOPhieuNhap pn = new DTOPhieuNhap();
            pn.setMaPhieuNhap(rs.getInt("maPhieuNhap"));
            pn.setMaNhaCungCap(rs.getInt("maNhaCungCap"));
            pn.setNgayNhap(rs.getTimestamp("ngayNhap"));
            pn.setTongTien(rs.getDouble("tongTien"));
            pn.setMaNhanVien(rs.getInt("maNhanVien"));
            pn.setIsHidden(rs.getInt("isDelete"));
            pn.setGhiChu(rs.getString("ghiChu"));
            list.add(pn);
        }
        con.close();
        Collections.sort(list, new Comparator<DTOPhieuNhap>() {
            @Override
            public int compare(DTOPhieuNhap person1, DTOPhieuNhap person2) {
                return person2.getNgayNhap().compareTo(person1.getNgayNhap());
            }
        });
        return list;
    }
    
    public int addphieunhap(DTOPhieuNhap pn) throws SQLException{
        Connection con = Connect.connection();
        String sql = "INSERT INTO phieunhap(ngayNhap,tongTien,maNhaCungCap,maNhanVien,ghiChu,isDelete) VALUES(?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setTimestamp(1, new java.sql.Timestamp (pn.getNgayNhap().getTime()));
        pst.setDouble(2,pn.getTongTien());
        pst.setInt(3,pn.getMaNhaCungCap());
        pst.setInt(4, pn.getMaNhanVien());
        pst.setString(5,pn.getGhiChu());
        pst.setInt(6, pn.getIsHidden());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int updatephieunhap(DTOPhieuNhap pn) throws SQLException{
        Connection con = Connect.connection();
        String sql = "UPDATE phieunhap set tongTien= ?, maNhaCungCap= ?, maNhanVien= ?,ghiChu= ?,isDelete=? WHERE maPhieuNhap= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setDouble(1, pn.getTongTien());
        pst.setInt(2, pn.getMaNhaCungCap());
        pst.setInt(3, pn.getMaNhanVien());
        pst.setString(4, pn.getGhiChu());
        pst.setInt(6, pn.getMaPhieuNhap());
        pst.setInt(5, pn.getIsHidden());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int updatephieunhaptongtien(DTOPhieuNhap pn) throws SQLException{
        Connection con = Connect.connection();
        String sql = "UPDATE phieunhap set tongTien= ? WHERE maPhieuNhap= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setDouble(1, pn.getTongTien());
        pst.setInt(2, pn.getMaPhieuNhap());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int rowcount() throws SQLException, ParseException{
        ArrayList<DTOPhieuNhap> list = getlist();
        int row = list.size();
        return row;
    }
}
