/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import DTO.*;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Hieu PC
 */
public class DAOHoaDon {

    public DTOHoaDon gethd(int mahd) throws SQLException, ParseException {
        Connection con = Connect.connection();
        String sql = "SELECT * FROM hoadon WHERE isDelete = 0 AND maHoaDon = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, mahd);
        ResultSet rs = pst.executeQuery();
        DTOHoaDon hd = new DTOHoaDon();
        while (rs.next()) {
            hd.setMaHoaDon(rs.getInt("maHoaDon"));
            hd.setMaKhachHang(rs.getInt("maKhachHang"));
            hd.setMaNhanVien(rs.getInt("maNhanVien"));
            hd.setMaKhuyenMai(rs.getInt("maKhuyenMai"));
            hd.setMaTichDiem(rs.getInt("maTichDiem"));
            hd.setNgayMua(rs.getTimestamp("ngayMua"));
            hd.setTongTien(rs.getDouble("tongTien"));
            hd.setGhiChu(rs.getString("ghiChu"));
            hd.setIsHidden(rs.getInt("isDelete"));
        }
        con.close();
        return hd;
    }

    public ArrayList<DTOHoaDon> getlist() throws SQLException, ParseException {
        Connection con = Connect.connection();
        String sql = "SELECT * FROM hoadon WHERE isDelete = 0";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ArrayList<DTOHoaDon> list = new ArrayList<>();
        while (rs.next()) {
            DTOHoaDon hd = new DTOHoaDon();
            hd.setMaHoaDon(rs.getInt("maHoaDon"));
            hd.setMaKhachHang(rs.getInt("maKhachHang"));
            hd.setMaNhanVien(rs.getInt("maNhanVien"));
            hd.setMaKhuyenMai(rs.getInt("maKhuyenMai"));
            hd.setMaTichDiem(rs.getInt("maTichDiem"));
            hd.setNgayMua(rs.getTimestamp("ngayMua"));
            hd.setTongTien(rs.getDouble("tongTien"));
            hd.setGhiChu(rs.getString("ghiChu"));
            hd.setIsHidden(rs.getInt("isDelete"));
            list.add(hd);
        }
        con.close();
        Collections.reverse(list);
        return list;
    }

    public int addhoadon(DTOHoaDon hd) throws SQLException {
        Connection con = Connect.connection();
        String sql = "INSERT INTO hoadon(maKhachHang,maNhanVien,maKhuyenMai,maTichDiem,ngayMua,tongTien,ghiChu,isDelete) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, hd.getMaKhachHang());
        pst.setInt(2, hd.getMaNhanVien());
        pst.setInt(3, hd.getMaKhuyenMai());
        pst.setInt(4, hd.getMaTichDiem());
        pst.setTimestamp(5, new java.sql.Timestamp(hd.getNgayMua().getTime()));
        pst.setDouble(6, hd.getTongTien());
        pst.setString(7, hd.getGhiChu());
        pst.setInt(8, hd.getIsHidden());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }

    public int updatehoadon(DTOHoaDon hd) throws SQLException {
        Connection con = Connect.connection();
        String sql = "UPDATE hoadon set maKhachHang= ?,maNhanVien=?, maKhuyenMai= ?, maTichDiem= ?,ngayMua = ?,tongTien=?, ghiChu= ?,isDelete = ? WHERE maHoaDon= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, hd.getMaKhachHang());
        pst.setInt(3, hd.getMaNhanVien());
        pst.setInt(2, hd.getMaKhuyenMai());
        pst.setInt(4, hd.getMaTichDiem());
        pst.setTimestamp(5, new java.sql.Timestamp(hd.getNgayMua().getTime()));
        pst.setDouble(6, hd.getTongTien());
        pst.setString(7, hd.getGhiChu());
        pst.setInt(8, hd.getIsHidden());
        pst.setInt(9, hd.getMaHoaDon());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }

    public int rowcount() throws SQLException, ParseException {
        ArrayList<DTOHoaDon> list = getlist();
        int row = list.size();
        return row;
    }

    public void exportDSHoaDon() {
        Connection con = Connect.connection();
        String sql = "SELECT * FROM hoadon ";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Danh sách hóa đơn");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Mã hóa đơn");
            headerRow.createCell(1).setCellValue("Mã khách hàng");
            headerRow.createCell(2).setCellValue("Mã nhân viên");
            headerRow.createCell(3).setCellValue("Mã khuyến mãi");
            headerRow.createCell(4).setCellValue("Mã tích điểm");
            headerRow.createCell(5).setCellValue("Ngày mua");
            headerRow.createCell(6).setCellValue("Tổng tiền");

            int rowNum = 1;
            while (rs.next()) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(rs.getInt("maHoaDon"));
                row.createCell(1).setCellValue(rs.getInt("maKhachHang"));
                row.createCell(2).setCellValue(rs.getInt("maNhanVien"));
                row.createCell(3).setCellValue(rs.getInt("maKhuyenMai"));
                row.createCell(4).setCellValue(rs.getInt("maTichDiem"));
                row.createCell(5).setCellValue(rs.getDate("ngayMua"));
                row.createCell(6).setCellValue(rs.getDouble("tongTien"));

            }

            FileOutputStream outputStream = new FileOutputStream("DSHoaDon.xlsx");
            workbook.write(outputStream);
            workbook.close();

            outputStream.close();
            pst.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Xuất file thành công");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi mở file");
        }
    }

}
