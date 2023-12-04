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
import javax.swing.JComboBox;

/**
 *
 * @author Hieu PC
 */
public class BUSTaiKhoan {

    DAOTaiKhoan DAO = new DAOTaiKhoan();

    public DTOTaiKhoan kiemTraTaiKhoan(String tenDangNhap, String matKhau) {
        return DAO.kiemTraTaiKhoan(tenDangNhap, matKhau);
    }

    public boolean checkTenDangNhap(String tenDangNhap) {
        return DAO.checkTenDangNhap(tenDangNhap);
    }

    public boolean checkMatKhau(String tenDangNhap, String matKhau) {
        return DAO.checkMatKhau(tenDangNhap, matKhau);
    }

    public boolean checkKhoaTaiKhoan(String tenDangNhap) {
        return DAO.checkKhoaTaiKhoan(tenDangNhap);
    }

    public int layMaNhanVien(String tenDangNhap) {
        return DAO.layMaNhanVien(tenDangNhap);
    }

    public ArrayList<DTOTaiKhoan> getlist() throws SQLException, ParseException {
        return DAO.getList();
    }

    public int addtaikhoan(DTOTaiKhoan i) throws SQLException {
        return DAO.addtaikhoan(i);
    }

    public int uppdatetaikhoan(DTOTaiKhoan i) throws SQLException {
        return DAO.uppdatetaikhoan(i);
    }

    public boolean khoaTaiKhoan(String tenDangNhap) {
        return DAO.khoaTaiKhoan(tenDangNhap);
    }

    public boolean moKhoaTaiKhoan(String tenDangNhap) {
        return DAO.moKhoaTaiKhoan(tenDangNhap);
    }

}
