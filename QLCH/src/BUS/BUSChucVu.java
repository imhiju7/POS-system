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
public class BUSChucVu {
    DAOChucVu DAO = new DAOChucVu();
    public ArrayList<DTOChucVu> getlist() throws SQLException, ParseException{
        return DAO.getlist();
    }
    public int addchucvu(DTOChucVu i) throws SQLException{
        return DAO.addchucvu(i);
    }
    public int updatechucvu(DTOChucVu i) throws SQLException{
        return DAO.updatechucvu(i);
    }
}
