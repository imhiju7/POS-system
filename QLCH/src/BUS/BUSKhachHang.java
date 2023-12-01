/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.*;
import DTO.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
/**
 *
 * @author Hieu PC
 */
public class BUSKhachHang {
    DAOKhachHang DAO = new DAOKhachHang();
    public ArrayList<DTOKhachHang> getlist() throws SQLException, ParseException{
        return DAO.getlist();
    }
    public int addkhachhang(DTOKhachHang i) throws SQLException{
        return DAO.addkhachhang(i);
    }
    public int updatekhachhang(DTOKhachHang i) throws SQLException{
        return DAO.updatekhachhang(i);
    }
}
