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
import javax.swing.JOptionPane;
/**
 *
 * @author Hieu PC
 */
public class DAOCTPhieuNhap {
    public DAOCTPhieuNhap(){
        
    }
    public DTOCTPhieuNhap getctpn(int maCTPhieuNhap) throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM chitietphieunhap WHERE maCTPhieuNhap=? ";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setInt(1, maCTPhieuNhap);
        ResultSet rs = pst.executeQuery();
        DTOCTPhieuNhap ctpn = new DTOCTPhieuNhap();
        while(rs.next()){
            ctpn.setMaCTPhieuNhap(rs.getInt("maCTPhieuNhap"));
            ctpn.setMaSanPham(rs.getInt("maSanPham"));
            ctpn.setMaPhieuNhap(rs.getInt("maPhieuNhap"));
            ctpn.setDonGia(rs.getFloat("donGia"));
            ctpn.setSoLuong(rs.getInt("soLuong"));
            ctpn.setGhichu(rs.getString("ghiChu"));
            ctpn.setNgayhethan(rs.getDate("ngayHetHan"));
            ctpn.setSoluongtonkho(rs.getInt("soLuongTonKho"));
        }
        con.close();
        return ctpn;
    }
    public boolean checksp(int masp,int mactpn,int mapn) throws SQLException{
        Connection con = Connect.connection();
        int i = 0;
        boolean key = false;
        String sql = "SELECT * FROM chitietphieunhap where maPhieuNhap = ? and maCTPhieuNhap != ? and maSanPham = ? ";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setInt(1, mapn);
        pst.setInt(2, mactpn);
        pst.setInt(3, masp);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            i++;
        }
        con.close();
        if(i > 0 ){
            key = false;
        }
        else key = true;
        return key;
    }
    public ArrayList<DTOCTPhieuNhap> getlist(int maPhieuNhap) throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM chitietphieunhap WHERE maPhieuNhap=? ";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setInt(1, maPhieuNhap);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTOCTPhieuNhap> list = new ArrayList<>();
        while(rs.next()){
            DTOCTPhieuNhap ctpn = new DTOCTPhieuNhap();
            ctpn.setMaCTPhieuNhap(rs.getInt("maCTPhieuNhap"));
            ctpn.setMaSanPham(rs.getInt("maSanPham"));
            ctpn.setMaPhieuNhap(rs.getInt("maPhieuNhap"));
            ctpn.setDonGia(rs.getFloat("donGia"));
            ctpn.setSoLuong(rs.getInt("soLuong"));
            ctpn.setGhichu(rs.getString("ghiChu"));
            ctpn.setNgayhethan(rs.getDate("ngayHetHan"));
            ctpn.setSoluongtonkho(rs.getInt("soLuongTonKho"));
            list.add(ctpn);
        }
        con.close();
        return list;
    }
    public ArrayList<DTOCTPhieuNhap> getalllist() throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM chitietphieunhap WHERE ngayHetHan > NOW() ";
        PreparedStatement pst =  con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTOCTPhieuNhap> list = new ArrayList<>();
        while(rs.next()){
            DTOCTPhieuNhap ctpn = new DTOCTPhieuNhap();
            ctpn.setMaCTPhieuNhap(rs.getInt("maCTPhieuNhap"));
            ctpn.setMaSanPham(rs.getInt("maSanPham"));
            ctpn.setMaPhieuNhap(rs.getInt("maPhieuNhap"));
            ctpn.setDonGia(rs.getFloat("donGia"));
            ctpn.setSoLuong(rs.getInt("soLuong"));
            ctpn.setGhichu(rs.getString("ghiChu"));
            ctpn.setNgayhethan(rs.getDate("ngayHetHan"));
            ctpn.setSoluongtonkho(rs.getInt("soLuongTonKho"));
            list.add(ctpn);
        }
        con.close();
        return list;
    }
    
    public int addctphieunhap(DTOCTPhieuNhap ctpn) throws SQLException{
        Connection con = Connect.connection();
        String sql = "INSERT INTO chitietphieunhap(maPhieuNhap,maSanPham,soLuong,donGia,ngayHetHan,ishidden,ghiChu,soLuongTonKho) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, ctpn.getMaPhieuNhap());
        pst.setInt(2, ctpn.getMaSanPham());
        pst.setInt(3, ctpn.getSoLuong());
        pst.setDouble(4, ctpn.getDonGia());
        pst.setTimestamp(5, new java.sql.Timestamp (ctpn.getNgayhethan().getTime()));
        pst.setInt(6,ctpn.getIshidden());
        pst.setString(7, ctpn.getGhichu());
        pst.setInt(8, ctpn.getSoluongtonkho());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int updatectphieunhap(DTOCTPhieuNhap ctpn) throws SQLException{
        Connection con = Connect.connection();
        String sql = "UPDATE chitietphieunhap set maPhieuNhap= ?,maSanPham = ? ,soLuong= ?, donGia= ?, ngayHetHan = ?, ishidden=?,ghiChu = ?,soLuongTonKho = ? WHERE maCTPhieuNhap= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, ctpn.getMaPhieuNhap());
        pst.setInt(2, ctpn.getMaSanPham());
        pst.setInt(3, ctpn.getSoLuong());
        pst.setDouble(4, ctpn.getDonGia());
        pst.setTimestamp(5, new java.sql.Timestamp (ctpn.getNgayhethan().getTime()));
        pst.setInt(6,ctpn.getIshidden());
        pst.setString(7, ctpn.getGhichu());
        pst.setInt(8, ctpn.getSoluongtonkho());
        pst.setInt(9,ctpn.getMaCTPhieuNhap());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int deletectphieunhap(DTOCTPhieuNhap ctpn) throws SQLException{
        Connection con = Connect.connection();
        String sql = "DELETE FROM chitietphieunhap WHERE maCTPhieuNhap= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, ctpn.getMaCTPhieuNhap());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }

}
