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
public class BUSHoaDon {
    DAOHoaDon DAO = new DAOHoaDon();
    public ArrayList<DTOHoaDon> getlist() throws SQLException, ParseException{
        return DAO.getlist();
    }
    public int addhoadon(DTOHoaDon i) throws SQLException{
        return DAO.addhoadon(i);
    }
    public int updateHoaDon(DTOHoaDon i) throws SQLException{
        return DAO.updatehoadon(i);
    }
    
}
