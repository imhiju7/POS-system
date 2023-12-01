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
public class BUSNhanVien {
    DAONhanVien DAO = new DAONhanVien();
    public ArrayList<DTONhanVien> getlist() throws SQLException, ParseException{
        return DAO.getlist();
    }
    public int addnhanvien(DTONhanVien i) throws SQLException{
        return DAO.addnhanvien(i);
    }
    public int updatenhanvien(DTONhanVien i) throws SQLException{
        return DAO.updatenhanvien(i);
    }
}
