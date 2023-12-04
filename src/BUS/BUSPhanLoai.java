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
public class BUSPhanLoai {
    DAOPhanLoai DAO = new DAOPhanLoai();
    public ArrayList<DTOPhanLoai> getlist() throws SQLException{
        return DAO.getlist();
    }
    public DTOPhanLoai getpl(DTOPhanLoai i) throws SQLException{
        return DAO.getpl(i);
    }
    public int addphanloai(DTOPhanLoai i) throws SQLException{
        return DAO.addphanloai(i);
    }
    public int updatephanloai(DTOPhanLoai i) throws SQLException{
        return DAO.updatephanloai(i);
    }
    public int deletephanloai(DTOPhanLoai i) throws SQLException{
        return DAO.deletephanloai(i);
    }
}
