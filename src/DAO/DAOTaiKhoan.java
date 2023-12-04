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
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.logging.log4j.Logger;

public class DAOTaiKhoan {
    
    public DTOTaiKhoan gettk(DTOTaiKhoan i){
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

    public int updatetaikhoan(DTOTaiKhoan tk) throws SQLException {
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
    public int deletetaikhoan(DTOTaiKhoan tk) throws SQLException{
        Connection con = Connect.connection();
        String sql = "DELETE FROM taikhoan  WHERE tenDangNhap= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,tk.getTenDangNhap() );
        int rowaffect = pst.executeUpdate();
        con.close();
        return rowaffect;
    }
    public boolean checktendn(String tendn) throws SQLException{
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
        if(count > 0) key = false;
        else key = true;
        rs.close();
        return key;
    }
    public boolean checktendnedit(String tendn) throws SQLException{
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
        if(count > 1) key = false;
        else key = true;
        rs.close();
        return key;
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
