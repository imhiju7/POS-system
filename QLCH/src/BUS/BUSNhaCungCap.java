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
public class BUSNhaCungCap {
    DAONhaCungCap DAO = new DAONhaCungCap();
    public ArrayList<DTONhaCungCap> getlist() throws SQLException, ParseException{
        return DAO.getlist();
    }
    public int addnhacungcap(DTONhaCungCap i) throws SQLException{
        return DAO.addnhacungcap(i);
    }
    public int updatenhacungcap(DTONhaCungCap i) throws SQLException{
        return DAO.updatenhacungcap(i);
    }
}
