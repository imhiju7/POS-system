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
public class BUSSanPham {
    DAOSanPham DAO = new DAOSanPham();
    public ArrayList<DTOSanPham> getlist() throws SQLException, ParseException{
        return DAO.getlist();
    }
    public int addsanpham(DTOSanPham i) throws SQLException{
        return DAO.addsanpham(i);
    }
    public int updatesanpham(DTOSanPham i) throws SQLException{
        return DAO.updatesanpham(i);
    }
    public String getname(DTOSanPham i) throws SQLException{
        return DAO.getsp(i).getTenSanPham();
    }
    public DTOSanPham getspbyname(DTOSanPham i) throws SQLException{
        return DAO.getspbyname(i);
    }
}
