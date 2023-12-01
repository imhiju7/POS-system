package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.*;

public class DAOPhanQuyen {

    public ArrayList<DTOPhanQuyen> getlist() throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM phanquyen";
        PreparedStatement pst =  con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTOPhanQuyen> list = new ArrayList<>();
        while(rs.next()){
            DTOPhanQuyen pq = new DTOPhanQuyen();
            pq.setMaPhanQuyen(rs.getInt("maPhanQuyen"));
            pq.setMaPhanQuyen(rs.getInt("maPhanQuyen"));
            pq.setMaChucNang(rs.getInt("maChucNang"));
            pq.setIsHidden(rs.getInt("isDelete"));
            list.add(pq);
        }
        con.close();
        return list;
    }
    public int getrowcount() throws SQLException{
        return getlist().size();
    }
    public int addphanquyen(DTOPhanQuyen pq) throws SQLException{
        Connection con = Connect.connection();
        String sql = "INSERT INTO phanquyen(maChucNang,maChucVu,isDelete) VALUES(?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, pq.getMaChucNang());
        pst.setInt(2, pq.getMaChucVu());
        pst.setInt(3,pq.getIsHidden());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int updatephanquyen(DTOPhanQuyen pq) throws SQLException{
        Connection con = Connect.connection();
        String sql = "UPDATE phanquyen set maChucNang = ?, maChucVu = ?,isDelete=? WHERE maPhanQuyen= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, pq.getMaChucNang());
        pst.setInt(2, pq.getMaChucVu());
        pst.setInt(3,pq.getIsHidden());
        pst.setInt(4, pq.getMaPhanQuyen());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
}
