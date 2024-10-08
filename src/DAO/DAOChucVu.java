/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.*;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author buile
 */
public class DAOChucVu {
    public int getmachucvu(String tencv) throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM chucvu WHERE tenChucVu = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setString(1, tencv);
        ResultSet rs = pst.executeQuery();
        DTOChucVu cv = new DTOChucVu();
        while(rs.next()){
            cv.setMaChucVu(rs.getInt("maChucVu"));
            cv.setTenChucVu(rs.getString("tenChucVu"));
            cv.setIsHidden(rs.getInt("isDelete"));
        }
        con.close();
        return cv.getMaChucVu();
    }
    public boolean checktencv(String tencv) throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM chucvu WHERE isDelete = 0 and tenChucVu = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setString(1, tencv);
        ResultSet rs = pst.executeQuery();
        int count = 0;
        while(rs.next()){
            count++;
        }
        con.close();
        
        if(count > 0) return false;
        else return true;
    }
    public DTOChucVu getcv(DTOChucVu i) throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM chucvu WHERE isDelete = 0 and maChucVu = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setInt(1, i.getMaChucVu());
        ResultSet rs = pst.executeQuery();
        DTOChucVu cv = new DTOChucVu();
        while(rs.next()){
            cv.setMaChucVu(rs.getInt("maChucVu"));
            cv.setTenChucVu(rs.getString("tenChucVu"));
            cv.setIsHidden(rs.getInt("isDelete"));
        }
        con.close();
        return cv;
    }
    public ArrayList<DTOChucVu> getlist() throws SQLException, ParseException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM chucvu WHERE isDelete = 0";
        PreparedStatement pst =  con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTOChucVu> list = new ArrayList<>();
        while(rs.next()){
            DTOChucVu cv = new DTOChucVu();
            cv.setMaChucVu(rs.getInt("maChucVu"));
            cv.setTenChucVu(rs.getString("tenChucVu"));
            cv.setIsHidden(rs.getInt("isDelete"));
            list.add(cv);
        }
        con.close();
        return list;
    }
    public int getrowcount() throws SQLException, ParseException{
        return getlist().size();
    }
    public int addchucvu(DTOChucVu cv) throws SQLException{
        Connection con = Connect.connection();
        String sql = "INSERT INTO chucvu(tenChucVu,isDelete) VALUES(?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, cv.getTenChucVu());
        pst.setInt(2, cv.getIsHidden());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int updatechucvu(DTOChucVu cv) throws SQLException{
        Connection con = Connect.connection();
        String sql = "UPDATE chucvu set tenChucVu = ?,isDelete=? WHERE maChucVu= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, cv.getTenChucVu());
        pst.setInt(2, cv.getIsHidden());
        pst.setInt(3, cv.getMaChucVu());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
}
