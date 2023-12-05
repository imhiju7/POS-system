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
public class DAONhaCungCap {
    public DTONhaCungCap getncc(DTONhaCungCap i) throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM nhacungcap WHERE maNhaCungCap = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setInt(1, i.getMaNhaCungCap());
        ResultSet rs = pst.executeQuery();
        DTONhaCungCap ncc = new DTONhaCungCap();
        while(rs.next()){
            ncc.setMaNhaCungCap(rs.getInt("maNhaCungCap"));
            ncc.setTenNhaCungCap(rs.getString("tenNhaCungCap"));
            ncc.setSDT(rs.getString("SDT"));
            ncc.setEmail(rs.getString("Email"));
            ncc.setDiaChi(rs.getString("diaChi"));
            ncc.setNgayTao(rs.getTimestamp("ngayTao"));
            ncc.setTrangThai(rs.getInt("trangThai"));
        }
        con.close();
        return ncc;
    }
    public DTONhaCungCap getmancc(DTONhaCungCap i) throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM nhacungcap WHERE tenNhaCungCap = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setString(1, i.getTenNhaCungCap());
        ResultSet rs = pst.executeQuery();
        DTONhaCungCap ncc = new DTONhaCungCap();
        while(rs.next()){
            ncc.setMaNhaCungCap(rs.getInt("maNhaCungCap"));
            ncc.setTenNhaCungCap(rs.getString("tenNhaCungCap"));
            ncc.setSDT(rs.getString("SDT"));
            ncc.setEmail(rs.getString("Email"));
            ncc.setNgayTao(rs.getTimestamp("ngayTao"));
            ncc.setTrangThai(rs.getInt("trangThai"));
        }
        con.close();
        return ncc;
    }
    public ArrayList<DTONhaCungCap> getlist() throws SQLException, ParseException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM nhacungcap";
        PreparedStatement pst =  con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTONhaCungCap> list = new ArrayList<>();
        while(rs.next()){
            DTONhaCungCap ncc = new DTONhaCungCap();
            ncc.setMaNhaCungCap(rs.getInt("maNhaCungCap"));
            ncc.setTenNhaCungCap(rs.getString("tenNhaCungCap"));
            ncc.setSDT(rs.getString("SDT"));
            ncc.setEmail(rs.getString("Email"));
            ncc.setDiaChi(rs.getString("diaChi"));
            ncc.setNgayTao(rs.getTimestamp("ngayTao"));
            ncc.setTrangThai(rs.getInt("trangThai"));
            list.add(ncc);
        }
        con.close();
        return list;
    }
    public ArrayList<DTONhaCungCap> getlistcb() throws SQLException, ParseException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM nhacungcap WHERE trangThai = 0";
        PreparedStatement pst =  con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTONhaCungCap> list = new ArrayList<>();
        while(rs.next()){
            DTONhaCungCap ncc = new DTONhaCungCap();
            ncc.setMaNhaCungCap(rs.getInt("maNhaCungCap"));
            ncc.setTenNhaCungCap(rs.getString("tenNhaCungCap"));
            ncc.setSDT(rs.getString("SDT"));
            ncc.setEmail(rs.getString("Email"));
            ncc.setDiaChi(rs.getString("diaChi"));
            ncc.setNgayTao(rs.getTimestamp("ngayTao"));
            ncc.setTrangThai(rs.getInt("trangThai"));
            list.add(ncc);
        }
        con.close();
        return list;
    }
    public int addnhacungcap(DTONhaCungCap ncc) throws SQLException{
        Connection con = Connect.connection();
        String sql = "INSERT INTO nhacungcap(tenNhaCungCap,SDT,Email,diaChi,ngayTao,trangThai) VALUES(?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, ncc.getTenNhaCungCap());
        pst.setString(2, ncc.getSDT());
        pst.setString(3, ncc.getEmail());
        pst.setString(4, ncc.getDiaChi());
        pst.setTimestamp(5,  new java.sql.Timestamp (ncc.getNgayTao().getTime()));
        pst.setInt(6, ncc.getTrangThai());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int updatenhacungcap(DTONhaCungCap ncc) throws SQLException{
        Connection con = Connect.connection();
        String sql = "UPDATE nhacungcap set tenNhaCungCap = ?,SDT = ?,Email= ?,diaChi = ?,ngayTao=?,trangThai=? WHERE maNhaCungCap= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, ncc.getTenNhaCungCap());
        pst.setString(2, ncc.getSDT());
        pst.setString(3, ncc.getEmail());
        pst.setString(4, ncc.getDiaChi());
        pst.setTimestamp(5,  new java.sql.Timestamp (ncc.getNgayTao().getTime()));
        pst.setInt(6, ncc.getTrangThai());
        pst.setInt(7, ncc.getMaNhaCungCap());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public boolean checkncctodel(DTONhaCungCap i) throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM phieunhap WHERE maNhaCungCap = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setInt(1, i.getMaNhaCungCap());
        ResultSet rs = pst.executeQuery();
        int count = 0;
        while(rs.next()){
            count++;
        }
        con.close();
        if(count > 0) return false;
        else return true;
    }
    public int deletenhacungcap(DTONhaCungCap i) throws SQLException{
        Connection con = Connect.connection();
        String sql = "DELETE FROM nhacungcap WHERE maNhaCungCap= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, i.getMaNhaCungCap());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public boolean checkgmail(String gmail) throws SQLException{
        Connection con = Connect.connection();
        int i = 0;
        boolean key = false;
        String sql = "SELECT * FROM nhacungcap where email = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setString(1, gmail);
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
    public boolean checkgmailedit(String gmail,int manv) throws SQLException{
        Connection con = Connect.connection();
        int i = 0;
        boolean key = false;
        String sql = "SELECT * FROM nhacungcap where maNhaCungCap != ? and email = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setInt(1, manv);
        pst.setString(2, gmail);
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
    public boolean checkphone(String phone) throws SQLException{
        Connection con = Connect.connection();
        int i = 0;
        boolean key = false;
        String sql = "SELECT * FROM nhacungcap where SDT = ? ";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setString(1, phone);
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
    public boolean checkphoneedit(String phone,int manv) throws SQLException{
        Connection con = Connect.connection();
        int i = 0;
        boolean key = false;
        String sql = "SELECT * FROM nhacungcap where maNhaCungCap != ? and SDT = ? ";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setInt(1, manv);
        pst.setString(2, phone);
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
}
