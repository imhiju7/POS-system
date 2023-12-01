/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.*;
import DTO.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hieu PC
 */
public class BUSCTPhieuNhap {
    DAOCTPhieuNhap DAO = new DAOCTPhieuNhap();
    public ArrayList<DTOCTPhieuNhap> getlist(int code) throws SQLException{
        return DAO.getlist(code);
    }
    public int addctphieunhap(DTOCTPhieuNhap i) throws SQLException{
        return DAO.addctphieunhap(i);
    }
    public int updateCTPhieuNhap(DTOCTPhieuNhap i) throws SQLException{
        return DAO.updatectphieunhap(i);
    }
    public int deleteCTPhieuNhap(DTOCTPhieuNhap i) throws SQLException{
        return DAO.deletectphieunhap(i);
    }
}
