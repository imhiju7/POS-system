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
        DTOPhieuNhap pn = new DTOPhieuNhap();
        ArrayList<DTOPhieuNhap> list = getlist();
        for(DTOPhieuNhap i: list){
            if(i.getMaPhieuNhap() == mapn){
                pn = i;
            }
        }
        return pn;
    }
    
    public ArrayList<DTOPhieuNhap> getlist() throws SQLException, ParseException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM phieunhap";
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
        Collections.reverse(list);
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
    public int rowcount() throws SQLException, ParseException{
        ArrayList<DTOPhieuNhap> list = getlist();
        int row = list.size();
        return row;
    }
<<<<<<< Updated upstream
    public Date getaDate(int mpn){
        ArrayList<DTOPhieuNhap> pnlist  = new ArrayList<>();
        Date adate = null;
        for(DTOPhieuNhap i: pnlist){
            if(i.getMaPhieuNhap() == mpn){
                adate = (Date) i.getNgayNhap();
            }
        }
        return adate;
    }
=======
    
    public boolean checkpn(DTOPhieuNhap i) throws SQLException, ParseException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM chitietphieunhap WHERE maPhieuNhap = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setInt(1, i.getMaPhieuNhap());
        ResultSet rs = pst.executeQuery();
        int count = 0;
        while(rs.next()){
           count++;
        }
        con.close();
        if(count > 0) return false;
        else return true;
    }
    
    
>>>>>>> Stashed changes
}
