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
public class BUSChucNang {

    DAOChucNang DAO = new DAOChucNang();

    public ArrayList<DTOChucNang> getlist() throws SQLException, ParseException {
        return DAO.getlist();
    }

    public boolean addchucnang(DTOChucNang i) throws SQLException {
        return DAO.addchucnang(i);
    }

    public boolean suaChucNang(int maChucNang, String tenChucNang) throws SQLException {
        return DAO.suachucnang(maChucNang, tenChucNang);
    }

    public boolean xoaChucNang(int maChucNang) throws SQLException {
        return DAO.xoachucnang(maChucNang);
    }
}
