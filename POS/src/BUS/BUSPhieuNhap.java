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
public class BUSPhieuNhap {
    DAOPhieuNhap DAO = new DAOPhieuNhap();
    public ArrayList<DTOPhieuNhap> getlist() throws SQLException, ParseException{
        return DAO.getlist();
    }
    public int addphieunhap(DTOPhieuNhap i) throws SQLException{
        return DAO.addphieunhap(i);
    }
    public int updatePhieuNhap(DTOPhieuNhap i) throws SQLException{
        return DAO.updatephieunhap(i);
    }
}
