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
/**
 *
 * @author Hieu PC
 */
public class DAOHoaDon {
    public ArrayList<DTOHoaDon> getlist() throws SQLException, ParseException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM hoadon WHERE isDelete = 0";
        PreparedStatement pst =  con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTOHoaDon> list = new ArrayList<>();
        while(rs.next()){
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
        Collections.reverse(list);
        return list;
    }
    
    public int addhoadon(DTOHoaDon hd) throws SQLException{
        Connection con = Connect.connection();
        String sql = "INSERT INTO hoadon(maKhachHang,maNhanVien,maKhuyenMai,maTichDiem,ngayMua,tongTien,ghiChu,isDelete) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, hd.getMaKhachHang());
        pst.setInt(2, hd.getMaNhanVien());
        pst.setInt(3, hd.getMaKhuyenMai());
        pst.setInt(4, hd.getMaTichDiem());
        pst.setTimestamp(5, new java.sql.Timestamp (hd.getNgayMua().getTime()));
        pst.setDouble(6, hd.getTongTien());
        pst.setString(7, hd.getGhiChu());
        pst.setInt(8, hd.getIsHidden());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int updatehoadon(DTOHoaDon hd) throws SQLException{
        Connection con = Connect.connection();
        String sql = "UPDATE hoadon set maKhachHang= ?,maNhanVien=?, maKhuyenMai= ?, maTichDiem= ?,ngayMua = ?,tongTien=?, ghiChu= ?,isDelete = ? WHERE maHoaDon= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, hd.getMaKhachHang());
        pst.setInt(3, hd.getMaNhanVien());
        pst.setInt(2, hd.getMaKhuyenMai());
        pst.setInt(4, hd.getMaTichDiem());
        pst.setTimestamp(5, new java.sql.Timestamp (hd.getNgayMua().getTime()));
        pst.setDouble(6, hd.getTongTien());
        pst.setString(7, hd.getGhiChu());
        pst.setInt(8, hd.getIsHidden());
        pst.setInt(9, hd.getMaHoaDon());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int rowcount() throws SQLException, ParseException{
        ArrayList<DTOHoaDon> list = getlist();
        int row = list.size();
        return row;
    }
}
