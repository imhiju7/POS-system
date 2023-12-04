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
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Hieu PC
 */
public class BUSNhaCungCap {
    DAONhaCungCap DAO = new DAONhaCungCap();
    public ArrayList<DTONhaCungCap> getlist() throws SQLException, ParseException{
        return DAO.getlist();
    }
    public int addnhacungcap(DTONhaCungCap i) throws SQLException{
        return DAO.addnhacungcap(i);
    }
    public int updatenhacungcap(DTONhaCungCap i) throws SQLException{
        return DAO.updatenhacungcap(i);
    }
    public DTONhaCungCap getmancc(DTONhaCungCap i) throws SQLException{
        return DAO.getmancc(i);
    }
    public void jtimport(JTable jt,ArrayList<DTONhaCungCap> list) throws SQLException{
        
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã nhà cung cấp");
        model.addColumn("Tên nhà cung cấp");
        model.addColumn("Số điện thoại");
        model.addColumn("Email");
        model.addColumn("Địa chỉ");
        model.addColumn("Trạng thái");
        model.addColumn("Ngày tạo");
        
        for(DTONhaCungCap i: list){
            model.addRow(new Object[]{i.getMaNhaCungCap(),i.getTenNhaCungCap(),i.getSDT(),i.getEmail(),i.getDiaChi(),i.trangthaistr(),i.getNgayTao()});
        }
        jt.setModel(model);
    }
    public ArrayList<DTONhaCungCap> jtexport(JTable jt) throws SQLException{
        ArrayList<DTONhaCungCap> list = new ArrayList<>();
        int size = jt.getRowCount();
        for(int i = 0; i < size; i++){
            DTONhaCungCap a = new DTONhaCungCap();
            a.setMaNhaCungCap(Integer.parseInt(jt.getValueAt(i, 0).toString()));
            a = DAO.getncc(a);
            list.add(a);
        }
        return list;
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
    public ArrayList<DTONhaCungCap> searchdate(ArrayList<DTONhaCungCap> list,Date day1,Date day2){
        ArrayList<DTONhaCungCap> result = new ArrayList<>();
        for(DTONhaCungCap i: list){
            if(i.getNgayTao().after(day1) && i.getNgayTao().before(day2)){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTONhaCungCap> searchten(ArrayList<DTONhaCungCap> list,String ten){
        ArrayList<DTONhaCungCap> result = new ArrayList<>();
        for(DTONhaCungCap i: list){
            if(i.getTenNhaCungCap().contains(ten)){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTONhaCungCap> searchsdt(ArrayList<DTONhaCungCap> list,String ten){
        ArrayList<DTONhaCungCap> result = new ArrayList<>();
        for(DTONhaCungCap i: list){
            if(i.getSDT().contains(ten)){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTONhaCungCap> searchdiachi(ArrayList<DTONhaCungCap> list,String ten){
        ArrayList<DTONhaCungCap> result = new ArrayList<>();
        for(DTONhaCungCap i: list){
            if(i.getDiaChi().contains(ten)){
                result.add(i);
            }
        }
        return result;
    }
    public ArrayList<DTONhaCungCap> getlistcb() throws SQLException, ParseException{
        return DAO.getlistcb();
    }
    public boolean checkdelncc(DTONhaCungCap i) throws SQLException{
        return DAO.checkncctodel(i);
    }
    public int deletenhacungcap(DTONhaCungCap i) throws SQLException{
        return DAO.deletenhacungcap(i);
    }
}
