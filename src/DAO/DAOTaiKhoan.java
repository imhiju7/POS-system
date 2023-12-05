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
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.logging.log4j.Logger;

public class DAOTaiKhoan {

    public DTOTaiKhoan gettk(DTOTaiKhoan i) {
        Connection con = Connect.connection();
        String sql = "SELECT taikhoan.*, nhanvien.* "
                + "FROM taikhoan "
                + "JOIN nhanvien ON taikhoan.maNhanVien = nhanvien.maNhanVien "
                + "WHERE taikhoan.maNhanVien=? ";
        DTOTaiKhoan tk = new DTOTaiKhoan();
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, i.getMaNhanVien());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                tk.setTenDangNhap(rs.getString("tenDangNhap"));
                tk.setMatKhau(rs.getString("matKhau"));
                tk.setNgayTao(rs.getTimestamp("ngayTao"));
                tk.setIsblock(rs.getInt("isBlock"));
                tk.setMaNhanVien(rs.getInt("maNhanVien"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tk;
    }

    public DTOTaiKhoan kiemTraTaiKhoan(String tenDangNhap, String matKhau) {
        Connection con = Connect.connection();
        String sql = "select * from taikhoan where tenDangNhap = ? and matKhau = ? and isBlock = 0 ";
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
                tk.setNgayTao(rs.getTimestamp("ngayTao"));
                tk.setIsblock(rs.getInt("isBlock"));
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

    //Kiểm tra trạng thái
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

    //Lấy mã nhân viên theo tên đăng nhập
    public int layMaNhanVien(String tenDangNhap) {
        int maNhanVien = -1;
        Connection con = Connect.connection();
        String sql = "SELECT maNhanvien "
                + "FROM taikhoan "
                + "WHERE taikhoan.tenDangNhap = ? ";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, tenDangNhap);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                maNhanVien = rs.getInt("maNhanVien");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maNhanVien;
    }

    public ArrayList<DTOTaiKhoan> getList() throws SQLException, ParseException {
        Connection con = Connect.connection();
        String sql = "SELECT * FROM taikhoan";
        ArrayList<DTOTaiKhoan> dstk = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                DTOTaiKhoan tk = new DTOTaiKhoan();
                tk.setTenDangNhap(rs.getString("tenDangNhap"));
                tk.setMatKhau(rs.getString("matKhau"));
                tk.setNgayTao(rs.getTimestamp("ngayTao"));
                tk.setIsblock(rs.getInt("isBlock"));
                tk.setMaNhanVien(rs.getInt("maNhanVien"));
                dstk.add(tk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Collections.sort(dstk, new Comparator<DTOTaiKhoan>() {
            @Override
            public int compare(DTOTaiKhoan person1, DTOTaiKhoan person2) {
                return person2.getNgayTao().compareTo(person1.getNgayTao());
            }
        });
        return dstk;
    }

    // Lấy nhân viên chưa có tài khoản
    public ArrayList<DTONhanVien> ListComboboxSDT() {
        Connection con = Connect.connection();

        String sql = "SELECT soDienThoai"
                + " FROM nhanvien "
                + "WHERE maNhanVien "
                + "NOT IN (SELECT maNhanVien FROM taikhoan) AND isDelete = 0";
        ArrayList<DTONhanVien> list = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String pat = rs.getString("soDienThoai");
                DTONhanVien a = new DTONhanVien();
                a.setSDT(pat);
                list.add(a);
            }
            rs.close();
        } catch (Exception e) {

        }
        return list;
    }

    // Lấy nhân viên đã có tài khoản
    public void ListComboboxTenNhanVien1(JComboBox c, String tenDangNhap) {
        Connection con = Connect.connection();

        String sql = "SELECT n.tenNhanVien"
                + " FROM taikhoan AS t "
                + "INNER JOIN nhanvien AS n ON t.maNhanVien = n.maNhanVien "
                + "WHERE t.tenDangNhap = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, tenDangNhap);

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
        String sql = "INSERT INTO taikhoan(tenDangNhap,matKhau,ngayTao,isBlock,maNhanVien) VALUES(?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, tk.getTenDangNhap());
        pst.setString(2, tk.getMatKhau());
        pst.setTimestamp(3, new java.sql.Timestamp(tk.getNgayTao().getTime()));
        pst.setInt(4, tk.getIsblock());
        pst.setInt(5, tk.getMaNhanVien());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }

    public int uppdatetaikhoan(DTOTaiKhoan tk) throws SQLException {
        Connection con = Connect.connection();
        String sql = "UPDATE taikhoan set tenDangNhap = ?,matKhau= ?,isBlock= ? WHERE maNhanVien = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, tk.getTenDangNhap());
        pst.setString(2, tk.getMatKhau());
        pst.setInt(3, tk.getIsblock());
        pst.setInt(4, tk.getMaNhanVien());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }

    public int deletetaikhoan(DTOTaiKhoan tk) throws SQLException {
        Connection con = Connect.connection();
        String sql = "DELETE FROM taikhoan  WHERE tenDangNhap= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, tk.getTenDangNhap());
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }

    // khóa tài khoản
    public boolean khoaTaiKhoan(String tenDangNhap) {
        Connection con = Connect.connection();

        String sql = "UPDATE taikhoan "
                + "JOIN nhanvien ON taikhoan.maNhanVien = nhanvien.maNhanVien "
                + "SET taikhoan.isBlock = 1, nhanvien.isBlock = 1 "
                + "WHERE taikhoan.tenDangNhap = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, tenDangNhap);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //mở tài khoản
    public boolean moKhoaTaiKhoan(String tenDangNhap) {
        Connection con = Connect.connection();

        String sql = "UPDATE taikhoan "
                + "JOIN nhanvien ON taikhoan.maNhanVien = nhanvien.maNhanVien "
                + "SET taikhoan.isBlock = 0, nhanvien.isBlock = 0 "
                + "WHERE taikhoan.tenDangNhap = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, tenDangNhap);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checktendn(String tendn) throws SQLException {
        Connection con = Connect.connection();
        String sql = "select * from taikhoan where tenDangNhap = ?";
        int count = 0;
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, tendn);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            count++;
        }
        boolean key = false;
        if (count > 0) {
            key = false;
        } else {
            key = true;
        }
        rs.close();
        return key;
    }

    public boolean checktendnedit(String tendn) throws SQLException {
        Connection con = Connect.connection();
        String sql = "select * from taikhoan where tenDangNhap = ?";
        int count = 0;
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, tendn);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            count++;
        }
        boolean key = false;
        if (count > 1) {
            key = false;
        } else {
            key = true;
        }
        rs.close();
        return key;
    }

    public void exportDSTaiKhoan() {
        Connection con = Connect.connection();
        String sql = "SELECT * FROM taikhoan ";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Danh sách tài khoản");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Tên đăng nhập");
            headerRow.createCell(1).setCellValue("Mật khẩu");
            headerRow.createCell(2).setCellValue("Ngày tạo");
            headerRow.createCell(3).setCellValue("isBlock");
            headerRow.createCell(4).setCellValue("Mã nhân viên");

            int rowNum = 1;
            while (rs.next()) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(rs.getInt("tenDangNhap"));
                row.createCell(1).setCellValue(rs.getString("matKhau"));
                row.createCell(2).setCellValue(rs.getDate("ngayTao").toString());
                row.createCell(3).setCellValue(rs.getBoolean("isBlock"));
                row.createCell(4).setCellValue(rs.getInt("maNhanVien"));
            }

            FileOutputStream outputStream = new FileOutputStream("DSTaiKhoan.xlsx");
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
