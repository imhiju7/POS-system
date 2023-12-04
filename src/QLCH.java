/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import BUS.BUSChucNang;
import BUS.BUSChucVu;
import BUS.BUSNhanVien;
import GUI.*;
import java.sql.SQLException;
import java.text.ParseException;
/**
 *
 * @author Hieu PC
 */
public class QLCH {
    public static void main(String[] args) throws SQLException, ParseException{
       new GUIThemKhachHang().setVisible(true);
       //new Main(1).setVisible(true);
    }
}
