/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.*;
import DTO.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Hieu PC
 */
public class BUSNhanVien {
    DAONhanVien DAO = new DAONhanVien();
    DAOChucVu DAOcv = new DAOChucVu();
    public ArrayList<DTONhanVien> getlist() throws SQLException, ParseException{
        return DAO.getlist();
    }
    public int addnhanvien(DTONhanVien i) throws SQLException{
        return DAO.addnhanvien(i);
    }
    public int updatenhanvien(DTONhanVien i) throws SQLException{
        return DAO.updatenhanvien(i);
    }
    public void jtimport(JTable jt,ArrayList<DTONhanVien> list) throws SQLException{
        
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã Nhân Viên");
        model.addColumn("Tên Nhân Viên");
        model.addColumn("Ngày Sinh");
        model.addColumn("Giới Tính");
        model.addColumn("Tên Chức Vụ");
        model.addColumn("Số Điện Thoại");
        model.addColumn("Email");
        model.addColumn("Địa Chỉ");
        
        for(DTONhanVien i: list){
            DTOChucVu cv = new DTOChucVu();
            cv.setMaChucVu(i.getMaChucVu());
            model.addRow(new Object[]{i.getMaNhanVien(),i.getTenNhanVien(),i.getNgaySinh(),i.getStringGioiTinh(),DAOcv.getcv(cv).getTenChucVu(),i.getSDT(),i.getEmail(),i.getDiaChi()});
        }
        jt.setModel(model);
    }
    public ArrayList<DTONhanVien> jtexport(JTable jt) throws SQLException{
        ArrayList<DTONhanVien> list = new ArrayList<>();
        int size = jt.getRowCount();
        for(int i = 0; i < size; i++){
            DTONhanVien a = new DTONhanVien();
            a.setMaNhanVien(Integer.parseInt(jt.getValueAt(i, 0).toString()));
            a = getnv(a);
            list.add(a);
        }
        return list;
    }
    
    public void cbimport(JComboBox jcb,ArrayList<DTOChucVu> cv){
        jcb.removeAllItems();
        jcb.addItem("Chức vụ");
        for(DTOChucVu i: cv){
            jcb.addItem(i.getTenChucVu());
        }
    }
    public int maChucVu(DTONhanVien i) throws SQLException{
        return DAO.getnv(i).getMaChucVu();
    }
    
    
    public DTONhanVien getnv(DTONhanVien i ) throws SQLException{
        return DAO.getnv(i);
    }
    public String getimg(DTONhanVien i) throws SQLException{
        return DAO.getnv(i).getImg();
    }
    public DTONhanVien getnvbysdt(DTONhanVien i) throws SQLException{
        return DAO.getnvbysdt(i);
    }
    
    public boolean checkgmail(String email) throws SQLException{
        return DAO.checkgmail(email);
    }
    public boolean checkphone(String phone) throws SQLException{
        return DAO.checkpphone(phone);
    }
    public boolean checkimg(String img) throws SQLException{
        return DAO.checkimg(img);
    }
    public boolean checkgmailedit(String email,int manv) throws SQLException{
        return DAO.checkgmailedit(email,manv);
    }
    public boolean checkphoneedit(String phone,int manv) throws SQLException{
        return DAO.checkpphoneedit(phone,manv);
    }
    public boolean checkimgedit(String img,int manv) throws SQLException{
        return DAO.checkimgedit(img,manv);
    }
    public boolean isValidVietnamesePhoneNumber(String phoneNumber) {
        // Sử dụng biểu thức chính quy để kiểm tra số điện thoại Việt Nam
        String regex = "^0[0-9]{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        // Kiểm tra xem số điện thoại có khớp với biểu thức chính quy hay không
        return matcher.matches();
    }
    public boolean isValidGmailAddress(String email) {
        // Sử dụng biểu thức chính quy để kiểm tra email
        String regex = "^[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*@gmail\\.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        // Kiểm tra xem email có khớp với biểu thức chính quy hay không
        return matcher.matches();
    }
    public boolean isEighteenOrOlder(String birthday) {
        // Định dạng ngày tháng từ chuỗi
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(birthday, formatter);

        // Tính tuổi hiện tại
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthDate, currentDate);

        // Kiểm tra xem tuổi có đủ 18 hay không
        return age.getYears() >= 18;
    }
    public Date convertStringToDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Trả về null nếu có lỗi chuyển đổi
        }
    }
    public ArrayList<DTONhanVien> searchten(ArrayList<DTONhanVien> list,String ten){
        ArrayList<DTONhanVien> result = new ArrayList<>();
        for(DTONhanVien i: list){
            if(i.getTenNhanVien().contains(ten)){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTONhanVien> searchchucvu(ArrayList<DTONhanVien> list,int chucvu){
        ArrayList<DTONhanVien> result = new ArrayList<>();
        for(DTONhanVien i: list){
            if(i.getMaChucVu()==chucvu){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTONhanVien> searchgioitinh(ArrayList<DTONhanVien> list,String gioitinh){
        ArrayList<DTONhanVien> result = new ArrayList<>();
        for(DTONhanVien i: list){
            if(i.getStringGioiTinh().equals(gioitinh)){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTONhanVien> searchsdt(ArrayList<DTONhanVien> list,String sdt){
        ArrayList<DTONhanVien> result = new ArrayList<>();
        for(DTONhanVien i: list){
            if(i.getSDT().contains(sdt)){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTONhanVien> searchdiachi(ArrayList<DTONhanVien> list,String diachi){
        ArrayList<DTONhanVien> result = new ArrayList<>();
        for(DTONhanVien i: list){
            if(i.getDiaChi().contains(diachi)){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTONhanVien> searchdate(ArrayList<DTONhanVien> list,Date day1,Date day2){
        ArrayList<DTONhanVien> result = new ArrayList<>();
        for(DTONhanVien i: list){
            if(i.getNgaySinh().after(day1) && i.getNgaySinh().before(day2)){
                result.add(i);
            }
        }
        return result;
    }
}
