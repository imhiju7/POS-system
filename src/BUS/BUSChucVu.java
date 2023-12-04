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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hieu PC
 */
public class BUSChucVu {
    DAOChucVu DAO = new DAOChucVu();
    public ArrayList<DTOChucVu> getlist() throws SQLException, ParseException{
        return DAO.getlist();
    }
    public int addchucvu(DTOChucVu i) throws SQLException{
        return DAO.addchucvu(i);
    }
    public int updatechucvu(DTOChucVu i) throws SQLException{
        return DAO.updatechucvu(i);
    }
    public String getTenChucVu(DTOChucVu i) throws SQLException{
        return DAO.getcv(i).getTenChucVu();
    }
    public int getmacv(String tencv) throws SQLException{
        return DAO.getmachucvu(tencv);
    }
    public void jtimport(JTable jt,ArrayList<DTOChucVu> list) throws SQLException{
        
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã chức vụ");
        model.addColumn("Tên chức vụ");
        
        for(DTOChucVu i: list){
            model.addRow(new Object[]{i.getMaChucVu(),i.getTenChucVu()});
        }
        jt.setModel(model);
    }
    public ArrayList<DTOChucVu> jtexport(JTable jt) throws SQLException{
        ArrayList<DTOChucVu> list = new ArrayList<>();
        int size = jt.getRowCount();
        for(int i = 0; i < size; i++){
            DTOChucVu a = new DTOChucVu();
            a.setMaChucVu(Integer.parseInt(jt.getValueAt(i, 0).toString()));
            a = DAO.getcv(a);
            list.add(a);
        }
        return list;
    }
    public ArrayList<DTOChucVu> searchten(ArrayList<DTOChucVu> list, String ten){
        ArrayList<DTOChucVu> result = new ArrayList<>();
        for(DTOChucVu i: list){
            if(i.getTenChucVu().contains(ten)){
                result.add(i);
            }
        }
        return result;
    }
    public boolean checktencv(String ten) throws SQLException{
        return DAO.checktencv(ten);
    }
    public boolean checktencvedit(String ten,int macv) throws ParseException, SQLException{
        int count = 0;
        ArrayList<DTOChucVu> list = DAO.getlist();
        for(DTOChucVu i: list){
            if(i.getTenChucVu().equals(ten) && i.getMaChucVu() !=macv ){
                count++;
            }
        }
        if(count > 0) return false;
        else return true;
    }
    public DTOChucVu getcv(DTOChucVu i) throws SQLException{
        return DAO.getcv(i);
    }
}
