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
public class DAOChucNang {
    public ArrayList<DTOChucNang> getlist() throws SQLException, ParseException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM chucnang WHERE isDelete = 0";
        PreparedStatement pst =  con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTOChucNang> list = new ArrayList<>();
        while(rs.next()){
            DTOChucNang cn = new DTOChucNang();
            cn.setMaChucNang(rs.getInt("maChucNang"));
            cn.setTenChucNang(rs.getString("tenChucNang"));
            cn.setIsHidden(rs.getInt("isDelete"));
            cn.setMaGroup(rs.getInt("maGr"));
            list.add(cn);
        }
        con.close();
        return list;
    }
    public DTOChucNang getcn(DTOChucNang i) throws SQLException, ParseException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM chucnang WHERE isDelete = 0 and maChucNang = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setInt(1,i.getMaChucNang());
        ResultSet rs = pst.executeQuery();
        DTOChucNang cn = new DTOChucNang();
        while(rs.next()){
            cn.setMaChucNang(rs.getInt("maChucNang"));
            cn.setTenChucNang(rs.getString("tenChucNang"));
            cn.setIsHidden(rs.getInt("isDelete"));
            cn.setMaGroup(rs.getInt("maGr"));
        }
        con.close();
        return cn;
    }
    public DTOChucNang getcnbyname(DTOChucNang i) throws SQLException, ParseException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM chucnang WHERE isDelete = 0 and tenChucNang = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setString(1,i.getTenChucNang());
        ResultSet rs = pst.executeQuery();
        DTOChucNang cn = new DTOChucNang();
        while(rs.next()){
            cn.setMaChucNang(rs.getInt("maChucNang"));
            cn.setTenChucNang(rs.getString("tenChucNang"));
            cn.setIsHidden(rs.getInt("isDelete"));
            cn.setMaGroup(rs.getInt("maGr"));
        }
        con.close();
        return cn;
    }
    public boolean checktencn(String ten) throws SQLException, ParseException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM chucnang WHERE isDelete = 0 and tenChucNang = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setString(1, ten);
        ResultSet rs = pst.executeQuery();
        int count = 0;
        while(rs.next()){
            count++;
        }
        con.close();
        if(count > 0) return false;
        return true;
    }
    
    public int addchucnang(DTOChucNang cn) throws SQLException{
        Connection con = Connect.connection();
        String sql = "INSERT INTO ChucNang(tenChucNang,isDelete,maGr) VALUES(?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, cn.getTenChucNang());
        pst.setInt(2, cn.getIsHidden());
        pst.setInt(3, cn.getMaGroup());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int updatechucnang(DTOChucNang cn) throws SQLException{
        Connection con = Connect.connection();
        String sql = "UPDATE chucnang set tenChucNang = ?,isDelete=?,maGr=? WHERE maChucNang= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, cn.getTenChucNang());
        pst.setInt(2, cn.getIsHidden());
        pst.setInt(3, cn.getMaGroup());
        pst.setInt(4, cn.getMaChucNang());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public ArrayList<DTOChucNang> getlistgroup(int magroup) throws SQLException, ParseException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM chucnang WHERE isDelete = 0 and maGr = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setInt(1, magroup);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTOChucNang> list = new ArrayList<>();
        while(rs.next()){
            DTOChucNang cn = new DTOChucNang();
            cn.setMaChucNang(rs.getInt("maChucNang"));
            cn.setTenChucNang(rs.getString("tenChucNang"));
            cn.setIsHidden(rs.getInt("isDelete"));
            cn.setMaGroup(rs.getInt("maGr"));
            list.add(cn);
        }
        con.close();
        return list;
    }
}
