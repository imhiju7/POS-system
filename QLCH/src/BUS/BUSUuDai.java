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
public class BUSUuDai {
    DAOUuDai DAO = new DAOUuDai();
    public ArrayList<DTOUuDai> getlist() throws SQLException, ParseException{
        return DAO.getlist();
    }
    public int adduudai(DTOUuDai i) throws SQLException{
        return DAO.adduudai(i);
    }
    public int updateuudai(DTOUuDai i) throws SQLException{
        return DAO.updateuudai(i);
    }
}
