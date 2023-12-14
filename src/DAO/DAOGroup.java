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
public class DAOGroup {
    public DTOGroup getgr(DTOGroup i) throws SQLException, ParseException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM qlcuahangtienloi.group WHERE isDelete = 0 and maGroup = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setInt(1, i.getMaGroup());
        ResultSet rs = pst.executeQuery();
        DTOGroup gr = new DTOGroup();
        while(rs.next()){
            gr.setMaGroup(rs.getInt("maGroup"));
            gr.setTenGroup(rs.getString("tenGroup"));
            gr.setIcon(rs.getString("icon"));
            gr.setIsdelete(rs.getInt("isDelete"));
        }
        con.close();
        return gr;
    }
    public ArrayList<DTOGroup> getlist() throws SQLException, ParseException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM qlcuahangtienloi.group WHERE isDelete = 0";
        PreparedStatement pst =  con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTOGroup> list = new ArrayList<>();
        while(rs.next()){
            DTOGroup gr = new DTOGroup();
            gr.setMaGroup(rs.getInt("maGroup"));
            gr.setTenGroup(rs.getString("tenGroup"));
            gr.setIcon(rs.getString("icon"));
            gr.setIsdelete(rs.getInt("isDelete"));
            list.add(gr);
        }
        con.close();
        return list;
    }
    public DTOGroup getmagr(DTOGroup i) throws SQLException, ParseException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM qlcuahangtienloi.group WHERE isDelete = 0 and tenGroup = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setString(1, i.getTenGroup());
        ResultSet rs = pst.executeQuery();
        DTOGroup gr = new DTOGroup();
        while(rs.next()){
            gr.setMaGroup(rs.getInt("maGroup"));
            gr.setTenGroup(rs.getString("tenGroup"));
            gr.setIcon(rs.getString("icon"));
            gr.setIsdelete(rs.getInt("isDelete"));
        }
        con.close();
        return gr;
    }
    public boolean checktengr(String ten) throws SQLException, ParseException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM qlcuahangtienloi.group WHERE tenGroup = ?";
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
    public int addgroup(DTOGroup gr) throws SQLException{
        Connection con = Connect.connection();
        String sql = "INSERT INTO Group(tenGroup,icon,isDelete) VALUES(?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, gr.getTenGroup());
        pst.setString(2, gr.getIcon());
        pst.setInt(3, gr.getIsdelete());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int updategroup(DTOGroup gr) throws SQLException{
        Connection con = Connect.connection();
        String sql = "UPDATE Group set tenGroup = ?,icon = ?,isDelete =? WHERE maGroup= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, gr.getTenGroup());
        pst.setString(2, gr.getIcon());
        pst.setInt(3, gr.getIsdelete());
        pst.setInt(4, gr.getMaGroup());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
}
