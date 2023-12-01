/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Hieu PC
 */
public class DAOKhachHang {
    public DAOKhachHang(){
        
    }
    
    public boolean isphone(String s){
        String phonepatt = "^(\\+?84|0)(\\d){9}$";
        Pattern patt = Pattern.compile(phonepatt);
        Matcher matcher = patt.matcher(s);
        return matcher.matches();
    }
    public boolean isnumeric(String s){
        return s.matches("-?\\d+(\\.\\d+)?");
    }
    public boolean check_phonenumber(String phonenumber) throws SQLException{
        boolean key = false;
        ArrayList<DTOKhachHang> khlist = getlist();
        for(DTOKhachHang i: khlist){
            if(i.getSDT().contains(phonenumber)){
                key = true;
            }
        }
        return key;
    }
    public boolean check_2phone(int id,String phone) throws SQLException{
        String phonegoc = "";
        ArrayList<DTOKhachHang> khlist = getlist();
        for(DTOKhachHang i: khlist){
            if(i.getMaKhachHang() == id){
                phonegoc = i.getSDT();
            }
        }
        boolean key = false;
        if(phone.contains(phonegoc)){
            key = true;
        }
        return key;
    }
    public ArrayList<DTOKhachHang> getlist() throws SQLException{
        Connection con = Connect.connection();
        String sql = "SELECT * FROM khachhang WHERE isDelete = 0";
        PreparedStatement pst =  con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTOKhachHang> list = new ArrayList<>();
        while(rs.next()){
            DTOKhachHang kh = new DTOKhachHang();
            kh.setMaKhachHang(rs.getInt("maKhachHang"));
            kh.setTenKhachHang(rs.getString("tenKhachHang"));
            kh.setSDT(rs.getString("SDT"));
            kh.setDiemTichLuy(rs.getInt("diemTichLuy"));
            kh.setMaUuDai(rs.getInt("maUuDai"));
            kh.setIsBlock(rs.getInt("isDelete"));
            list.add(kh);
        }
        con.close();
        return list;
    }
    public int addkhachhang(DTOKhachHang kh) throws SQLException{
        Connection con = Connect.connection();
        String sql = "INSERT INTO khachhang(SDT,tenKhachHang,diemTichLuy,maUuDai,isDelete) VALUES(?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,kh.getSDT());
        pst.setString(2,kh.getTenKhachHang());
        pst.setInt(3, kh.getDiemTichLuy());
        pst.setInt(4, kh.getMaUuDai());
        pst.setInt(5, kh.getIsBlock());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public int updatekhachhang(DTOKhachHang kh) throws SQLException{
        Connection con = Connect.connection();
        String sql = "UPDATE khachhang set SDT= ?, tenKhachHang= ?, diemTichLuy= ?, maUuDai = ?,isDelete=? WHERE maKhachHang= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,kh.getSDT());
        pst.setString(2,kh.getTenKhachHang());
        pst.setInt(3, kh.getDiemTichLuy());
        pst.setInt(4, kh.getMaUuDai());
        pst.setInt(5, kh.getIsBlock());
        pst.setInt(6, kh.getMaKhachHang());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }


}
