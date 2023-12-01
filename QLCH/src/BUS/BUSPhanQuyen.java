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
public class BUSPhanQuyen {
    DAOPhanQuyen DAO = new DAOPhanQuyen();
    public ArrayList<DTOPhanQuyen> getlist() throws SQLException, ParseException{
        return DAO.getlist();
    }
    public int addphanquyen(DTOPhanQuyen i) throws SQLException{
        return DAO.addphanquyen(i);
    }
    public int updatephanquyen(DTOPhanQuyen i) throws SQLException{
        return DAO.updatephanquyen(i);
    }
}
