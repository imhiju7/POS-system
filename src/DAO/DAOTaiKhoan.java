package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.text.ParseException;
import DTO.*;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.logging.log4j.Logger;

public class DAOTaiKhoan {

    public DTOTaiKhoan kiemTraTaiKhoan(String tenDangNhap, String matKhau) {
        Connection con = Connect.connection();
        String sql = "select * from taikhoan where tenDangNhap = ? and matKhau = ? and isBlock = 0 and isDelete = 0";
        ArrayList<DTOTaiKhoan> dstk = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, tenDangNhap);
            pst.setString(2, matKhau);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                DTOTaiKhoan tk = new DTOTaiKhoan();
                tk.setTenDangNhap(rs.getString("tenDangNhap"));
                tk.setMatKhau(rs.getString("matKhau"));
                tk.setNgayTao(rs.getDate("ngayTao"));
                tk.setIsblock(rs.getInt("isBlock"));
                tk.setIsdelete(rs.getInt("isDelete"));
                tk.setMaNhanVien(rs.getInt("maNhanVien"));
                dstk.add(tk);
                return dstk.get(0);
            }
            rs.close();

        } catch (SQLException e) {
            return null;
        }
        return null;
    }

    // kiểm tra tên tài khoản
    public boolean checkTenDangNhap(String tenDangNhap) {
        Connection con = Connect.connection();
        String sql = "select * from taikhoan where tenDangNhap = ? ";
        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, tenDangNhap);
            ResultSet rs = pst.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //Kiểm tra mật khẩu
    public boolean checkMatKhau(String tenDangNhap, String matKhau) {
        Connection con = Connect.connection();
        String sql = "select * from taikhoan where tenDangNhap = ? and matKhau = ? ";
        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, tenDangNhap);
            pst.setString(2, matKhau);
            ResultSet rs = pst.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //Kiểm tra xem tài khoản có bị xóa không
    public boolean checkTaiKhoan(String tenDangNhap) {
        Connection con = Connect.connection();
        String sql = "select * from taikhoan where tenDangNhap = ? and isDelete = 1 ";
        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, tenDangNhap);
            ResultSet rs = pst.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkKhoaTaiKhoan(String tenDangNhap) {
        Connection con = Connect.connection();
        String sql = "select * from taikhoan where tenDangNhap = ? and isBlock = 1 ";
        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, tenDangNhap);
            ResultSet rs = pst.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<DTOTaiKhoan> getList() throws SQLException, ParseException {
        Connection con = Connect.connection();
        String sql = "SELECT taikhoan.*, nhanvien.* "
                + "FROM taikhoan "
                + "JOIN nhanvien ON taikhoan.maNhanVien = nhanvien.maNhanVien "
                + "WHERE taikhoan.isDelete = 0 AND nhanvien.isDelete = 0 ";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ArrayList<DTOTaiKhoan> dstk = new ArrayList<>();
            while (rs.next()) {
                DTOTaiKhoan tk = new DTOTaiKhoan();
                tk.setTenDangNhap(rs.getString("tenDangNhap"));
                tk.setMatKhau(rs.getString("matKhau"));
                tk.setNgayTao(rs.getDate("ngayTao"));
                tk.setIsblock(rs.getInt("isBlock"));
                dstk.add(tk);
            }
            return dstk;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Lấy nhân viên chưa có tài khoản
    public void ListComboboxTenNhanVien(JComboBox c) {
        Connection con = Connect.connection();

        String sql = "SELECT tenNhanVien"
                + " FROM nhanvien "
                + "WHERE maNhanVien "
                + "NOT IN (SELECT maNhanVien FROM taikhoan)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String pat = rs.getString("tenNhanVien");
                c.addItem(pat.trim());
            }
            rs.close();
        } catch (Exception e) {

        }
    }

    // Lấy nhân viên đã có tài khoản
    public void ListComboboxTenNhanVien1(JComboBox c, String tenDangNhap) {
        Connection con = Connect.connection();

        String sql = "SELECT n.tenNhanVien"
                + " FROM taikhoan AS t "
                + "INNER JOIN nhanvien AS n ON t.maNhanVien = n.maNhanVien "
                + "WHERE t.tenDangNhap = '" + tenDangNhap + "'";
        try {
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String pat = rs.getString("tenNhanVien");
                c.addItem(pat.trim());
            }
            rs.close();
        } catch (Exception e) {

        }
    }

    public int addtaikhoan(DTOTaiKhoan tk) throws SQLException {
        Connection con = Connect.connection();
        String sql = "INSERT INTO taikhoan(tenDangNhap,matKhau,ngayTao,isBlock,isDelete) VALUES(?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, tk.getTenDangNhap());
        pst.setString(2, tk.getMatKhau());
        pst.setTimestamp(3, new java.sql.Timestamp(tk.getNgayTao().getTime()));
        pst.setInt(4, tk.getIsblock());
        pst.setInt(5, tk.getIsdelete());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }

    public int updatetaikhoan(DTOTaiKhoan tk) throws SQLException {
        Connection con = Connect.connection();
        String sql = "UPDATE taikhoan set matKhau= ?, ngayTao= ?,isBlock= ? WHERE tenDangNhap= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, tk.getMatKhau());
        pst.setTimestamp(2, new java.sql.Timestamp(tk.getNgayTao().getTime()));
        pst.setInt(3, tk.getIsblock());
        pst.setInt(4, tk.getIsdelete());
        pst.setString(5, tk.getTenDangNhap());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }


    /*
    public void exportDSTaiKhoan() {
        String sql = "SELECT tk.*, cv.tenChucVu "
                + "FROM taikhoan tk "
                + "INNER JOIN nhanvien nv ON tk.maNhanVien = nv.maNhanVien "
                + "INNER JOIN chucvu cv ON nv.maChucVu = cv.maChucVu";
        try {
            PreparedStatement ps = Connect.connection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Danh sách tài khoản");

            ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            Row headerRow = sheet.createRow(0);
            for (int col = 1; col <= columnCount; col++) {
                headerRow.createCell(col - 1).setCellValue(metaData.getColumnName(col));
            }

            int rowNum = 1;
            while (rs.next()) {
                Row row = sheet.createRow(rowNum++);
                for (int col = 1; col <= columnCount; col++) {
                    Object value = rs.getObject(col);
                    row.createCell(col - 1).setCellValue(value.toString());
                }
            }

            FileOutputStream fileOut = new FileOutputStream("D:\\DSTaiKhoan.xlsx");
            workbook.write(fileOut);
            fileOut.close();
            JOptionPane.showMessageDialog(null, "Xuất file thành công");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi mở file");

        }
    }
     */
}
