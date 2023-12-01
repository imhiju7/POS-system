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
public class DAOTichDiem {
    public ArrayList<DTOTichDiem> getlist() throws SQLException, ParseException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM tichdiem";
        PreparedStatement pst =  con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTOTichDiem> list = new ArrayList<>();
        while(rs.next()){
            DTOTichDiem td = new DTOTichDiem();
            td.setMaTichDiem(rs.getInt("maTichDiem"));
            td.setTien(rs.getDouble("Tien"));
            td.setDiemTichLuy(rs.getInt("diemTichLuy"));
            list.add(td);
        }
        con.close();
        return list;
    }
    public int getrowcount() throws SQLException, ParseException{
        return getlist().size();
    }
    public int addtichdiem(DTOTichDiem td) throws SQLException{
        Connection con = Connect.connection();
        String sql = "INSERT INTO tichdiem(Tien,diemTichLuy,isDelete) VALUES(?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setDouble(1, td.getTien());
        pst.setInt(2, td.getDiemTichLuy());
        pst.setInt(3, td.getIsHidden());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int updatetichdiem(DTOTichDiem td) throws SQLException{
        Connection con = Connect.connection();
        String sql = "UPDATE tichdiem set mocTichDiem = ?,tiLeGiam = ?,isDelete=? WHERE maTichDiem= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setDouble(1, td.getTien());
        pst.setInt(2, td.getDiemTichLuy());
        pst.setInt(3, td.getIsHidden());
        pst.setInt(4, td.getMaTichDiem());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
}
