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
        String sql = "SELECT * FROM chucnang";
        PreparedStatement pst =  con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTOChucNang> list = new ArrayList<>();
        while(rs.next()){
            DTOChucNang cn = new DTOChucNang();
            cn.setMaChucNang(rs.getInt("maChucNang"));
            cn.setTenChucNang(rs.getString("tenChucNang"));
            cn.setIsHidden(rs.getInt("isDelete"));
            list.add(cn);
        }
        con.close();
        return list;
    }
    public int getrowcount() throws SQLException, ParseException{
        return getlist().size();
    }
    public int addchucnang(DTOChucNang cn) throws SQLException{
        Connection con = Connect.connection();
        String sql = "INSERT INTO ChucNang(tenChucNang,isDelete) VALUES(?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, cn.getTenChucNang());
        pst.setInt(2, cn.getIsHidden());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int updatechucnang(DTOChucNang cn) throws SQLException{
        Connection con = Connect.connection();
        String sql = "UPDATE chucnang set tenChucNang = ?,isDelete=? WHERE maChucNang= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, cn.getTenChucNang());
        pst.setInt(2, cn.getIsHidden());
        pst.setInt(3, cn.getMaChucNang());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
}
