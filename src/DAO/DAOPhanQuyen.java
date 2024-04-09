package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.*;
import java.util.Collections;
import java.util.Comparator;

public class DAOPhanQuyen {
    
    public DTOPhanQuyen getpq(DTOPhanQuyen i) throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM phanquyen WHERE maPhanQuyen = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setInt(1, i.getMaPhanQuyen());
        ResultSet rs = pst.executeQuery();
        DTOPhanQuyen pq = new DTOPhanQuyen();
        while(rs.next()){
            pq.setMaPhanQuyen(rs.getInt("maPhanQuyen"));
            pq.setMaChucVu(rs.getInt("maChucVu"));
            pq.setMaChucNang(rs.getInt("maChucNang"));
        }
        con.close();
        return pq;
    }
    public ArrayList<DTOPhanQuyen> getlist() throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM phanquyen";
        PreparedStatement pst =  con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTOPhanQuyen> list = new ArrayList<>();
        while(rs.next()){
            DTOPhanQuyen pq = new DTOPhanQuyen();
            pq.setMaPhanQuyen(rs.getInt("maPhanQuyen"));
            pq.setMaChucVu(rs.getInt("maChucVu"));
            pq.setMaChucNang(rs.getInt("maChucNang"));
            list.add(pq);
        }
        con.close();
        return list;
    }
    public ArrayList<DTOPhanQuyen> getlistcbcv(DTOPhanQuyen i) throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM phanquyen WHERE maChucVu = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setInt(1, i.getMaChucVu());
        ResultSet rs = pst.executeQuery();
        ArrayList<DTOPhanQuyen> list = new ArrayList<>();
        while(rs.next()){
            DTOPhanQuyen pq = new DTOPhanQuyen();
            pq.setMaPhanQuyen(rs.getInt("maPhanQuyen"));
            pq.setMaChucVu(rs.getInt("maChucVu"));
            pq.setMaChucNang(rs.getInt("maChucNang"));
            list.add(pq);
        }
        con.close();
        return list;
    }
    public boolean checkpq(int macv,int macn) throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM phanquyen WHERE maChucVu = ? and maChucNang = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setInt(1, macv);
        pst.setInt(2, macn);
        ResultSet rs = pst.executeQuery();
        int count = 0;
        while(rs.next()){
            count++;
        }
        con.close();
        if(count > 0) return false;
        else return true;
    }
    public boolean checkpqedit(int mapq,int macv,int macn) throws SQLException{
         Connection con = Connect.connection();
        String sql = "SELECT * FROM phanquyen WHERE maPhanQuyen != ? and maChucVu = ? and maChucNang = ?";
        PreparedStatement pst =  con.prepareStatement(sql);
        pst.setInt(1, mapq);
        pst.setInt(2, macv);
        pst.setInt(3, macn);
        ResultSet rs = pst.executeQuery();
        int count = 0;
        while(rs.next()){
            count++;
        }
        con.close();
        if(count > 0) return false;
        else return true;
    }
    public int addphanquyen(DTOPhanQuyen pq) throws SQLException{
        Connection con = Connect.connection();
        String sql = "INSERT INTO phanquyen(maChucNang,maChucVu) VALUES(?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, pq.getMaChucNang());
        pst.setInt(2, pq.getMaChucVu());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int updatephanquyen(DTOPhanQuyen pq) throws SQLException{
        Connection con = Connect.connection();
        String sql = "UPDATE phanquyen set maChucNang = ?, maChucVu = ? WHERE maPhanQuyen= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, pq.getMaChucNang());
        pst.setInt(2, pq.getMaChucVu());
        pst.setInt(3, pq.getMaPhanQuyen());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int deletephanquyen(DTOPhanQuyen pq) throws SQLException{
        Connection con = Connect.connection();
        String sql = "DELETE FROM phanquyen WHERE maPhanQuyen= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, pq.getMaPhanQuyen());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
}
