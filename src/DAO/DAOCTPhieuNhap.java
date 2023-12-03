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
        
    }/*
    public boolean check2sp(int mapn,int mactpn,int masp) throws SQLException{
        int maspgoc = 0;
        ArrayList<DTOCTPhieuNhap> list = getlist(mapn);
        for(DTOCTPhieuNhap i : list){
            if(i.getMaCTPhieuNhap() == mactpn){
                maspgoc = i.getMaSanPham();
            }
        }
        boolean key = false;
        if(maspgoc == masp){
            key = true;
        }
        return key;
    }
    public double pnmoney(int mapn) throws SQLException{
        double money = 0;
        ArrayList<DTOCTPhieuNhap> list = getlist(mapn);
        for(DTOCTPhieuNhap i: list){
            money += i.getDonGia()*i.getSoLuong();
        }
        return money;
    }
    public boolean checksp(int mapn,int masp) throws SQLException{
        boolean key = false;
        ArrayList<DTOCTPhieuNhap> list = getlist(mapn);
        for(DTOCTPhieuNhap i: list){
            if(i.getMaSanPham() == masp){
                key = true;
            }
        }
        return key;
    }
    public boolean checksoluong(int mapn) throws SQLException{
        boolean key = false;
        if(soluong(mapn) > 0){
            key = true;
        }
        return key;
    }
    public int soluong(int mapn) throws SQLException{
        ArrayList<DTOCTPhieuNhap> list = getlist(mapn);
        return list.size();
    }*/
    public ArrayList<DTOCTPhieuNhap> getlist(int maPhieuNhap) throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM chitietphieunhap WHERE isDelete = 0 and maPhieuNhap=? ";
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
    public int getlistcount(int maPhieuNhap) throws SQLException{
        int count;
        ArrayList<DTOCTPhieuNhap> ctpn = getlist(maPhieuNhap);
        count = ctpn.size();
        return count;
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

}
