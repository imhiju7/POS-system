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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Hieu PC
 */
public class BUSKhachHang {
    DAOKhachHang DAO = new DAOKhachHang();
    DAOUuDai DAOud = new DAOUuDai();
    public ArrayList<DTOKhachHang> getlist() throws SQLException, ParseException{
        return DAO.getlist();
    }
    public int addkhachhang(DTOKhachHang i) throws SQLException{
        return DAO.addkhachhang(i);
    }
    public int updatekhachhang(DTOKhachHang i) throws SQLException{
        return DAO.updatekhachhang(i);
    }
    public int updatediemtichluy(DTOKhachHang i) throws SQLException{
        return DAO.updatediemtichluy(i);
    }
    public DTOKhachHang getkh(DTOKhachHang i) throws SQLException{
        return DAO.getkh(i);
    }
     public DTOKhachHang getkhbysdt(DTOKhachHang i) throws SQLException{
        return DAO.getkhbyphone(i);
    }
    public void jtimport(JTable jt,ArrayList<DTOKhachHang> list) throws SQLException, ParseException{
        
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã khách hàng");
        model.addColumn("Tên khách hàng");
        model.addColumn("Số điện thoại");
        model.addColumn("Điểm tích lũy");
        model.addColumn("Tỉ lệ giảm");
        
        for(DTOKhachHang i: list){
            DTOUuDai ud = new DTOUuDai();
            ud.setMaUuDai(i.getMaUuDai());
            ud = DAOud.getud(ud);
            model.addRow(new Object[]{i.getMaKhachHang(),i.getTenKhachHang(),i.getSDT(),i.getDiemTichLuy(),ud.getTiLeGiam()});
        }
        jt.setModel(model);
    }
    public ArrayList<DTOKhachHang> jtexport(JTable jt) throws SQLException{
        ArrayList<DTOKhachHang> list = new ArrayList<>();
        int size = jt.getRowCount();
        for(int i = 0; i < size; i++){
            DTOKhachHang a = new DTOKhachHang();
            a.setMaKhachHang(Integer.parseInt(jt.getValueAt(i, 0).toString()));
            a = getkh(a);
            list.add(a);
        }
        return list;
    }
    public int getmaud(DTOKhachHang i) throws SQLException, ParseException{
        ArrayList<DTOUuDai> list= DAOud.getlist();
        int maud = 1;
        for(DTOUuDai a : list){
            if(a.getMocUuDai() < i.getDiemTichLuy()){
                maud = a.getMaUuDai();
            }
            else{
                break;
            }
        }
        return maud;
    }
    public boolean isValidVietnamesePhoneNumber(String phoneNumber) {
        // Sử dụng biểu thức chính quy để kiểm tra số điện thoại Việt Nam
        String regex = "^0[0-9]{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        // Kiểm tra xem số điện thoại có khớp với biểu thức chính quy hay không
        return matcher.matches();
    }
    public boolean checkphone(String phone) throws SQLException{
        return DAO.checkpphone(phone);
    }
    public boolean checkphoneedit(String phone,int makh) throws SQLException{
        return DAO.checkpphoneedit(phone, makh);
    }
    public ArrayList<DTOKhachHang> searchten(ArrayList<DTOKhachHang> list, String ten){
        ArrayList<DTOKhachHang> result = new ArrayList<>();
        for(DTOKhachHang i: list){
            if(i.getTenKhachHang().contains(ten)){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTOKhachHang> searchsdt(ArrayList<DTOKhachHang> list,String sdt){
        ArrayList<DTOKhachHang> result = new ArrayList<>();
        for(DTOKhachHang i: list){
            if(i.getSDT().contains(sdt)){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTOKhachHang> searchdiem(ArrayList<DTOKhachHang> list,int var1,int var2){
        ArrayList<DTOKhachHang> result = new ArrayList<>();
        for(DTOKhachHang i: list){
            if(i.getDiemTichLuy() >= var1 && i.getDiemTichLuy() <= var2){
                result.add(i);
            }
        }
        return result;
    }
}
