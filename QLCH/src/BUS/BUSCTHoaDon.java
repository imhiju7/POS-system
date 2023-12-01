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
public class BUSCTHoaDon {
    DAOCTHoaDon DAO = new DAOCTHoaDon();
    public ArrayList<DTOCTHoaDon> getlist(int code) throws SQLException{
        return DAO.getlist(code);
    }
    public int addcthoadon(DTOCTHoaDon i) throws SQLException{
        return DAO.addctHoaDon(i);
    }
    public int updatecthoadon(DTOCTHoaDon i) throws SQLException{
        return DAO.updatectHoaDon(i);
    }
    public int deletecthoadon(DTOCTHoaDon i) throws SQLException{
        return DAO.deletectHoaDon(i);
    }
}
