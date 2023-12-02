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
            ncc.setNgayTao(rs.getTimestamp("ngayTao"));
            ncc.setTrangThai(rs.getInt("trangThai"));
            ncc.setIsHidden(rs.getInt("isDelete"));
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
            ncc.setIsHidden(rs.getInt("isDelete"));
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
            ncc.setNgayTao(rs.getTimestamp("ngayTao"));
            ncc.setTrangThai(rs.getInt("trangThai"));
            ncc.setIsHidden(rs.getInt("isDelete"));
            list.add(ncc);
        }
        con.close();
        return list;
    }
    public int getrowcount() throws SQLException, ParseException{
        return getlist().size();
    }
    public int addnhacungcap(DTONhaCungCap ncc) throws SQLException{
        Connection con = Connect.connection();
        String sql = "INSERT INTO nhacungcap(tenNhaCungCap,SDT,Email,ngayTao,trangThai) VALUES(?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, ncc.getTenNhaCungCap());
        pst.setString(2, ncc.getSDT());
        pst.setString(3, ncc.getEmail());
        pst.setTimestamp(4,  new java.sql.Timestamp (ncc.getNgayTao().getTime()));
        pst.setInt(5, ncc.getTrangThai());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int updatenhacungcap(DTONhaCungCap ncc) throws SQLException{
        Connection con = Connect.connection();
        String sql = "UPDATE nhacungcap set tenNhaCungCap = ?,SDT = ?,Email=?,ngayTao=?,trangThai=? WHERE maNhaCungCap= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, ncc.getTenNhaCungCap());
        pst.setString(2, ncc.getSDT());
        pst.setString(3, ncc.getEmail());
        pst.setTimestamp(4,  new java.sql.Timestamp (ncc.getNgayTao().getTime()));
        pst.setInt(5, ncc.getTrangThai());
        pst.setInt(6, ncc.getMaNhaCungCap());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
}
