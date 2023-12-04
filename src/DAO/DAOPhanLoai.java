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
/**
 *
 * @author Hieu PC
 */
public class DAOPhanLoai {
    public ArrayList<DTOPhanLoai> getlist() throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM phanloai";
        PreparedStatement pst =  con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTOPhanLoai> list = new ArrayList<>();
        while(rs.next()){
            DTOPhanLoai pl = new DTOPhanLoai();
            pl.setMaPhanLoai(rs.getInt("maPhanLoai"));
            pl.setTenPhanLoai(rs.getString("tenPhanLoai"));
            list.add(pl);
        }
        con.close();
        return list;
    }
    public DTOPhanLoai getpl(DTOPhanLoai i) throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM phanloai WHERE maPhanLoai = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setInt(1, i.getMaPhanLoai());
        ResultSet rs = pst.executeQuery();
        DTOPhanLoai pl = new DTOPhanLoai();
        while(rs.next()){
            pl.setMaPhanLoai(rs.getInt("maPhanLoai"));
            pl.setTenPhanLoai(rs.getString("tenPhanLoai"));
        }
        con.close();
        return pl;
    }
    public DTOPhanLoai getplbyname(DTOPhanLoai i) throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM phanloai WHERE tenPhanLoai = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setString(1, i.getTenPhanLoai());
        ResultSet rs = pst.executeQuery();
        DTOPhanLoai pl = new DTOPhanLoai();
        while(rs.next()){
            pl.setMaPhanLoai(rs.getInt("maPhanLoai"));
            pl.setTenPhanLoai(rs.getString("tenPhanLoai"));
        }
        con.close();
        return pl;
    }
    public int addphanloai(DTOPhanLoai i) throws SQLException{
        Connection con = Connect.connection();
        String sql = "INSERT INTO phanloai(tenPhanLoai) VALUES(?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,i.getTenPhanLoai());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int updatephanloai(DTOPhanLoai i) throws SQLException{
        Connection con = Connect.connection();
        String sql = "UPDATE phanloai set tenPhanLoai= ?WHERE maPhanLoai= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, i.getTenPhanLoai());
        pst.setInt(2, i.getMaPhanLoai());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int deletephanloai(DTOPhanLoai i) throws SQLException{
        Connection con = Connect.connection();
        String sql = "DELETE FROM phanloai WHERE maPhanLoai= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, i.getMaPhanLoai());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public boolean checkpltodelete(DTOPhanLoai i) throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM sanpham WHERE maPhanLoai = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setInt(1, i.getMaPhanLoai());
        ResultSet rs = pst.executeQuery();
        int count = 0;
        while(rs.next()){
            count++;
        }
        if(count > 0) return false;
        return true;
        
    }
    public boolean checktenpl(String tencv) throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM phanloai WHERE tenPhanLoai = ?";
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
}
