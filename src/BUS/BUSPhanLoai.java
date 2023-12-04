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
public class BUSPhanLoai {
    DAOPhanLoai DAO = new DAOPhanLoai();
    public ArrayList<DTOPhanLoai> getlist() throws SQLException{
        return DAO.getlist();
    }
    public DTOPhanLoai getpl(DTOPhanLoai i) throws SQLException{
        return DAO.getpl(i);
    }
    public int addphanloai(DTOPhanLoai i) throws SQLException{
        return DAO.addphanloai(i);
    }
    public int updatephanloai(DTOPhanLoai i) throws SQLException{
        return DAO.updatephanloai(i);
    }
    public int deletephanloai(DTOPhanLoai i) throws SQLException{
        return DAO.deletephanloai(i);
    }
    public void jtimport(JTable jt,ArrayList<DTOPhanLoai> list) throws SQLException{
        
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã phân loại");
        model.addColumn("Tên phân loại");
        
        for(DTOPhanLoai i: list){
            model.addRow(new Object[]{i.getMaPhanLoai(),i.getTenPhanLoai()});
        }
        jt.setModel(model);
    }
    public ArrayList<DTOPhanLoai> jtexport(JTable jt) throws SQLException{
        ArrayList<DTOPhanLoai> list = new ArrayList<>();
        int size = jt.getRowCount();
        for(int i = 0; i < size; i++){
            DTOPhanLoai a = new DTOPhanLoai();
            a.setMaPhanLoai(Integer.parseInt(jt.getValueAt(i, 0).toString()));
            a = DAO.getpl(a);
            list.add(a);
        }
        return list;
    }
    public ArrayList<DTOPhanLoai> searchten(ArrayList<DTOPhanLoai> list, String ten){
        ArrayList<DTOPhanLoai> result = new ArrayList<>();
        for(DTOPhanLoai i: list){
            if(i.getTenPhanLoai().contains(ten)){
                result.add(i);
            }
        }
        return result;
    }
    public boolean checktenpl(String ten) throws SQLException{
        return DAO.checktenpl(ten);
    }
    public boolean checktenpledit(String ten,int macv) throws ParseException, SQLException{
        int count = 0;
        ArrayList<DTOPhanLoai> list = DAO.getlist();
        for(DTOPhanLoai i: list){
            if(i.getTenPhanLoai().equals(ten) && i.getMaPhanLoai() !=macv ){
                count++;
            }
        }
        if(count > 0) return false;
        else return true;
    }
    public boolean checkpltodel(DTOPhanLoai i) throws SQLException{
        return DAO.checkpltodelete(i);
    }
}
