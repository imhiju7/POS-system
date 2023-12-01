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
public class BUSTichDiem {
    DAOTichDiem DAO = new DAOTichDiem();
    public ArrayList<DTOTichDiem> getlist() throws SQLException, ParseException{
        return DAO.getlist();
    }
    public int addtichdiem(DTOTichDiem i) throws SQLException{
        return DAO.addtichdiem(i);
    }
    public int updatetichdiem(DTOTichDiem i) throws SQLException{
        return DAO.updatetichdiem(i);
    }
}
